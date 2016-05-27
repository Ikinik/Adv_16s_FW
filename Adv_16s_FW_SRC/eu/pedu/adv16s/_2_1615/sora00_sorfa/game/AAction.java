/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.adv16s._2_1615.sora00_sorfa.game;

import eu.pedu.adv16s_fw.game_txt.IAction;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import static eu.pedu.adv16s._2_1615.sora00_sorfa.game.Texts.*;

/**
 * Třída {@code AAction} je společným rodičem všech tříd, jejichž instance
 * mají na starosti interpretaci příkazů zadávaných uživatelem hrajícím hru.
 * Název spouštěného příkazu bývá většinou první slovo řádku zadávaného
 * z klávesnice a další slova pak bývají interpretována jako parametry.
 * Můžete ale definovat příkaz, který odstartuje konverzaci
 * (např. s osobou přítomnou v místnosti) a tím přepne systém do režimu,
 * v němž se zadávané texty neinterpretují jako příkazy,
 * ale předávají se definovanému objektu až do chvíle,
 * kdy uživatel rozhovor ukončí a objekt rozhovoru přepne hru zpět
 * do režimu klasických příkazů.
 *
 * @author  Adam Šorfa
 */
abstract class AAction extends ANamed implements IAction
{
//== CONSTANT CLASS FIELDS =====================================================
    /** Mapa akcí a jejich oběktů */
    private static final Map<String, AAction> NAME_2_ACTION = new HashMap<>();

//== VARIABLE CLASS FIELDS =====================================================
    /** Uchovává informaci o tom, zda se hra právě hraje nebo jen čeká na
     *  spuštění. */
    public static boolean isAlive = false;


//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================

    /** Vytvoří instance akcí, tím že se vytvoří jejich instance se sami
     * přidají do mapy name_2_acction */
    static {
        new ActionHelp();
        new ActionMove();
        new ActionEnd();
        new ActionPickUp();
        new ActionPutDown();
        new ActionExplore();
        new ActionDance();
        new ActionCombine();
        new ActionUse();
        new ActionLookAround();
    }

//== CLASS GETTERS AND SETTERS =================================================

    /**
     * Vrátí informaci o tom, je-li hra aktuálně spuštěná.
     * Spuštěnou hru není možno pustit znovu.
     * Chceme-li hru spustit znovu, musíme ji nejprve ukončit.
     *
     * @return Je-li hra spuštěná, vrátí {@code true},
     *         jinak vrátí {@code false}
     */
    static boolean isAlive()
    {
        return isAlive;
    }



    /**
     * Vrátí kolekci akcí, které je možné ve hře použít.
     *
     * @return Kolekce akcí použitelných ve hře
     */
    static Collection<AAction> getAllActions()
    {
        return Collections.unmodifiableCollection(NAME_2_ACTION.values());
    }
//== OTHER NON-PRIVATE CLASS METHODS ===========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================

    /**
     * Zjistí, jaká akce je zadávána, a jedná-li se o známou akci,
     * provede jeí.
     *
     * @param commandLine Zadávaná akce
     * @return Odpověď hry na zadanou akci
     */
    private static String executeCommonAction(String commandLine) {
        String[] words = commandLine.toLowerCase().split("\\s+");
        String commandName = words[0];
        AAction command = NAME_2_ACTION.get(commandName);
        String answer;
        if (command == null) {
            answer = zNEZNAMY_PRIKAZ;
        } else {
            answer = command.execute(words);
        }
        return answer;
    }

    /**
     * Ověří, jestli je hra spouštěna správným (= prázdným) příkazem,
     * a pokud ano, spustí hru.
     *
     * @param command Příkaz spouštějící hru
     * @return Odpověď hry na zadaný příkaz
     */
    private static String startGame(String command) {
        String answer;
        if (command.isEmpty()) {
            isAlive = true;
            initialize();
            answer = Texts.zCELE_UVITANI;
        } else {
            answer = Texts.zNENI_START;
        }
        return answer;
    }

//##############################################################################
//== CONSTANT INSTANCE FIELDS ==================================================

    /** Stručný popis danné akce. */
    private final String description;
    private final String name;


//== VARIABLE INSTANCE FIELDS ==================================================



//##############################################################################
//== CONSTRUCTORS AND FACTORY METHODS ==========================================

    /**
     * Vytvoří rodičovský podobjekt vytvářené akce.
     *
     * @param name  Název vytvářené akce,
     *              kterou musí hráč zadat pro vyvolaní dané akce
     * @param description Stručný popis vytvářené akce
     */
    AAction(String name, String description)
    {
        super(name);
        this.name = name;
        this.description = description;

        AAction act = NAME_2_ACTION.put(name.toLowerCase(), this);
        if(act != null){
            throw new IllegalArgumentException(
            "\nPříkaz: " + name + " byl již vytvořen");
        }
    }



//== ABSTRACT METHODS ==========================================================

    /**
     * Metoda realizující reakci hry na zadání daného příkazu.
     * Počet parametrů je závislý na konkrétním příkazu,
     * např. příkazy <i>konec</i> a <i>?</i> nemají parametry,
     * příkazy <i>jdi</i> a <i>seber</i> mají jeden parametr.
     *
     * @param arguments Parametry příkazu;
     *                  jejich počet muže být pro každý příkaz jiný
     * @return Text zprávy vypsané po provedeni příkazu
     */
    @Override
    abstract
    public String execute(String... arguments)
    ;



//== INSTANCE GETTERS AND SETTERS ==============================================

    /**
     * Vrátí název akce, tj. text, který musí hráč zadat
     * pro vyvolaní dané akce.
     *
     * @return Název akce
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Vrátí popis akce s vysvětlením její funkce
     *
     * @return Popis akce
     */
    @Override
    public String getDescription()
    {
        return description;
    }

    /**
     * Zpracuje zadanou akci a vrátí text zprávy pro uživatele.
     *
     * @param action Zadávaná akce
     * @return Textová odpověď hry na zadanou akci
     */
    static String executeAction(String action)
    {
        action = action.trim();
        String answer;
        if (isAlive) {
            if(action.isEmpty()){
                answer = zPRAZDY_PRIKAZ;
            }else{
                answer = executeCommonAction(action);
            }
        }
        else {
            answer = startGame(action);
        }
        return answer;
    }

    static void initialize(){
        World.getInstance().initialize();
        Bag.getInstance().initialize();
        Flags.initialize();
    }

    /**
     * Příkaz, který zastaví hru.
     */
    public static void stopGame(){
        isAlive = false;
    }

//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
