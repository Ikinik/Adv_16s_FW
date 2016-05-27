/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.adv16s._2_1615.sora00_sorfa.game;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import eu.pedu.adv16s_fw.game_txt.INamed;
import eu.pedu.adv16s_fw.game_txt.IWorld;

import static eu.pedu.adv16s._2_1615.sora00_sorfa.game.Texts.*;


/**
 * Instance třídy {@code World} reprezentují svět hry.
 * Mají na starosti uspořádání jednotlivých prostorů a udržují informaci o tom,
 * ve kterém z nich se hráč právě nachází.
 *
 * @author  Rudolf PECINOVSKÝ
 */
class World implements IWorld
{
//== CONSTANT CLASS FIELDS =====================================================

    /** Odkaz na jedinou instanci (jedináčka) této hry. */
    private static final World SINGLETON = new World();

    /** Kolekce prostorů */
    private final Collection<Space> spaces;

//== VARIABLE CLASS FIELDS =====================================================



//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================



//##############################################################################
//== CONSTANT INSTANCE FIELDS ==================================================
//== VARIABLE INSTANCE FIELDS ==================================================
    /** Uchovává informaci o aktuální místnosti, v níž se hráč nachází */
    private Space currentSpace;


//##############################################################################
//== CONSTRUCTORS AND FACTORY METHODS ==========================================

    /**
     * Tovární metoda vracející odkaz na jedninou existující instanci dané hry.
     *
     * @return Instance dané hry
     */
    static World getInstance()
    {
        return SINGLETON;
    }


    /**
     * Soukromý konstruktor definující jedinou instanci.
     * Protože je soukromý, musí být definován, i když má prázdné tělo.
     */
    private World()
    {
        spaces = new ArrayList<>();
        spaces.add(new Space(DETSKY_POKOJ,
                new String[] {CHODBA},
                HOLCICKA, MV + SKRIN, NEPORADEK));
        spaces.add(new Space(LOZNICE_RODICU, wLOZNICE_RODICU,
                new String[] {CHODBA},
                POSTEL, KNIHOVNA, NOCNI_STOLEK, MV + ZRCADLO
                ));
        spaces.add(new Space(CHODBA, wCHODBA,
                 new String[] {DETSKY_POKOJ, LOZNICE_RODICU,
                     KOUPELNA, POKOJ_PRO_HOSTY, KUMBAL, SCHODY},
                 OBRAZ
                ));
        spaces.add(new Space(KOUPELNA, wKOUPELNA,
                 new String[] {CHODBA},
                 SPRCHOVY_KOUT, UMYVADLO, ZACHOD));
        spaces.add(new Space(POKOJ_PRO_HOSTY, wPOKOJ_PRO_HOSTY,
                 new String[] {CHODBA},
                 POSTEL, KRESLO, STRYCEK_ALFRED));
        spaces.add(new Space(KUMBAL, wKUMBAL,
                 new String[] { CHODBA },
                 MV+SMETACEK, MV+LOPATKA, MV+KOSTE, MV+SAVO, MV+SEKERA,
                 MV+SROUBOVAK));
        spaces.add(new Space(SCHODY,wSCHODY,
                 new String[] { CHODBA, OBYVAK },
                 FOTKY, ZABRADLI));
        spaces.add(new Space(OBYVAK,wOBYVAK,
                 new String[] {PREDSIN, KUCHYN, SCHODY},
                 TELEVIZE, POHOVKA, MINIBAR));
        spaces.add(new Space(KUCHYN,wKUCHYN,
                 new String[] {OBYVAK},
                 TATINEK, MAMINKA));
        spaces.add(new Space(PREDSIN,wPREDSIN,
                 new String[] {OBYVAK, GARAZ},
                VESAK, BOTNIK, ROHOZKA));
        spaces.add(new Space(GARAZ,wGARAZ,
                 new String[] {PREDSIN},
                 AUTO));
        spaces.add(new Space(SKLAD_JADERNYCH_ZBRANI, new String[]{ }));
    }

    /** Inicializace světa hry */
    public void initialize(){
        currentSpace = INamed.getO(DETSKY_POKOJ, spaces).get();
        spaces.forEach(Space::initialize);
    }

//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    /**
     * Vrátí kolekci odkazů na všechny prostory vystupující ve hře.
     *
     * @return Kolekce odkazů na všechny prostory vystupující ve hře
     */
    @Override
    public Collection<Space> getAllSpaces()
    {
        return Collections.unmodifiableCollection(spaces);
    }


    /***************************************************************************
     * Vrací aktuální prostor, tedy prostor, ve kterém se hráč právě nachází
     *
     * @return Prostor, ve kterém se hráč právě nachází
     */
    @Override
    public Space getCurrentSpace()
    {
        return currentSpace;
    }

    /***************************************************************************
     * Vrátí odkaz na místnost se zadaným názvem.
     *
     * *
     * @param name Název požadované místnosti
     * @return Místnost se zadaným názvem (nezávisle na velkosti písmen)
     * nebo {@code null} v případě, že taková místnost neexistuje
     */
    Space getSpace(String name) {
        Optional<Space> space = INamed.getO(name, spaces);

        Space result = null;
        try {
            return space.orElseThrow(() ->
                    new Exception("Zadaný prostor <<"+ name +">> neexistuje")
            );
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        return result;
    }

    /** Nastaví aktuální prostor */
    void setCurrentSpace(Space cSpace) {
        currentSpace = cSpace;
    }
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
