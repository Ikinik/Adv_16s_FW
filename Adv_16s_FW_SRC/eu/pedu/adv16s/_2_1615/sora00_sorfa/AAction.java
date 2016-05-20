/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.adv16s._2_1615.sora00_sorfa;

import eu.pedu.adv16s_fw.game_txt.IAction;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import static eu.pedu.adv16s._2_1615.sora00_sorfa.Texts.*;

/*******************************************************************************
 * The {@code AAction} abstract class is a common superclass of all classes,
 * the instances of which are responsible for interpretation of commands
 * entered by the user playing the game.
 * Name of the executed action is usually the first word of the entered command.
 * The further words are interpreted as arguments.
 * <p>
 * You can define also a command that opens the conversation
 * (e.g. with a person present in the room) and thus switch to the mode,
 * in which the entered texts are not interpreted as commands,
 * but are passed to the defined object up to moment,
 * when the conversation ends and the object controlling the dialogue
 * switches the game back to the basic command mode.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
 */
abstract class AAction extends ANamed implements IAction
{
//== CONSTANT CLASS FIELDS =====================================================
    /** Mapa akcí a jejich oběktů */
    private static final Map<String, AAction> NAME_2_ACTION = new HashMap<>();

//== VARIABLE CLASS FIELDS =====================================================
    public static boolean isAlive = false;


//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================

    /**Vytvoří instance akcí, tím že se vytvoří jejich instance se sami
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
        //new ActionMove();
        //new CommandPickUp();
        //new CommandExit();
    }

//== CLASS GETTERS AND SETTERS =================================================

    /***************************************************************************
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



    /***************************************************************************
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

    /***************************************************************************
     * Zjistí, jaký příkaz je zadáván, a jedná-li se o známý příkaz,
     * provede jej.
     *
     * @param commandLine Zadávaný příkaz
     * @return Odpověď hry na zadaný příkaz
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

    /***************************************************************************
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

    /** Brief description of the given action. */
    private final String description;
    private final String name;


//== VARIABLE INSTANCE FIELDS ==================================================



//##############################################################################
//== CONSTRUCTORS AND FACTORY METHODS ==========================================

    /***************************************************************************
     * Creates the parent sub-object of the created action.
     *
     * @param name  Name of the created action = text, which the player has to
     *              enter as an initial word of the entered command
     * @param description Brief description of the created action
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

    /***************************************************************************
     * Processes the command composed from the given words
     * and returns the game answer to the user.
     * Number of word depends on particular action, however it must be
     * at least one, because the zeroth element contains the action name.
     * The remaining words are arguments of this action and they may differ:
     * the actions of <i>end</i> and <i>help</i> type do not have any,
     * the actions of <i>go</i> and <i>take</i> type have one,
     * the actions of <i>apply</i> type ) can have two (e.g. apply key lock)
     * or three (e.g. apply key to lock) etc.
     *
     * @param arguments ActionMove arguments –
     *                  their number can be different for each action,
     *                  but for all execution of the same action is the same
     * @return The answer of the game after processing the command
     */
    @Override
    abstract
    public String execute(String... arguments)
    ;



//== INSTANCE GETTERS AND SETTERS ==============================================

    /***************************************************************************
     * Vrátí název příkazu, tj. text, který musí hráč zadat
     * pro vyvolaní daného příkazu.
     *
     * @return Název příkazu
     */
    @Override
    public String getName() {
        return name;
    }

    /***************************************************************************
     * Returns the action description with explanation of its function
     * and the meaning of individual parameters.
     *
     * @return ActionMove description
     */
    @Override
    public String getDescription()
    {
        return description;
    }

    /***************************************************************************
     * Processes the given command and returns the answer to the user.
     *
     * @param action The entered command
     * @return The answer of the game after processing the command
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

    /***************************************************************************
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
