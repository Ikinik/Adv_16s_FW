/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.adv16s._2_1615.sora00_sorfa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import eu.pedu.adv16s_fw.game_txt.INamed;
import eu.pedu.adv16s_fw.game_txt.IWorld;
import eu.pedu.adv16s_fw.game_txt.ISpace;
import static eu.pedu.adv16s._2_1615.sora00_sorfa.Texts.*;


/*******************************************************************************
 * An instance of the {@code World} class represents the game world.
 * It should be defined as a singleton.
 * It is responsible for arrangement of individual spaces and keeps information,
 * in which space the player is just situated.
 * The mutual arrangement may change during the gawme,
 * the spaces can gain and/or lose their neighbors.
 * <p>
 * In this game the world is ...
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
 */
class World implements IWorld
{
//== CONSTANT CLASS FIELDS =====================================================

    /** The only instance (singleton) of this world. */
    private static final World SINGLETON = new World();

    private final ArrayList<Space> spaces;

//== VARIABLE CLASS FIELDS =====================================================



//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================



//##############################################################################
//== CONSTANT INSTANCE FIELDS ==================================================
//== VARIABLE INSTANCE FIELDS ==================================================
    private Space currentSpace;


//##############################################################################
//== CONSTRUCTORS AND FACTORY METHODS ==========================================

    /***************************************************************************
     * The factory method returning the only existing instance of the game.
     *
     * @return The only instance of the given game
     */
    static World getInstance()
    {
        return SINGLETON;
    }


    /***************************************************************************
     * The private constructor creating the only instance of the space world.
     * Within this manager definition it creates all game spaces.
     */
    private World()
    {
        spaces = new ArrayList<>();
        spaces.add(new Space(DETSKY_POKOJ,
                             new String[] {CHODBA},
                             HOLCICKA, SKRIN, NEPORADEK));
        spaces.add(new Space(LOZNICE_RODICU,
                             new String[] {CHODBA}));
        spaces.add(new Space(CHODBA,
                             new String[] {DETSKY_POKOJ, LOZNICE_RODICU,
                                 KOUPELNA, POKOJ_PRO_HOSTY, KUMBAL, SCHODY}));
        spaces.add(new Space(KOUPELNA,
                             new String[] {CHODBA},
                             SPRCHOVY_KOUT, UMYVADLO, ZACHOD));
        spaces.add(new Space(POKOJ_PRO_HOSTY,
                             new String[] {CHODBA},
                             POSTEL, KRESLO, STRYCEK_ALFRED));
        spaces.add(new Space(OBYVAK,
                             new String[] {PREDSIN, KUCHYN},
                             TELEVIZE, POHOVKA));
        spaces.add(new Space(KUCHYN,
                             new String[] {OBYVAK},
                             TATINEK, MAMINKA));
        spaces.add(new Space(PREDSIN,
                             new String[] {OBYVAK, GARAZ}));
        spaces.add(new Space(GARAZ,
                             new String[] {PREDSIN},
                             AUTO));
    }

    public void initialize(){
        currentSpace = INamed.getO(DETSKY_POKOJ, spaces).get();
        spaces.forEach(Space::initialize);
    }

//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    /***************************************************************************
     * Returns the collection of all spaces of the game.
     *
     * @return Collection of all spaces performing in the game
     */
    @Override
    public Collection<? extends ISpace> getAllSpaces()
    {
        return Collections.unmodifiableCollection(spaces);
    }


    /***************************************************************************
     * Returns the current space,
     * i.e. to the space in which the player is just situated.
     *
     * @return The space in which the player is just situated
     */
    @Override
    public Space getCurrentSpace()
    {
        return currentSpace;
    }

    /***************************************************************************
     * Nastaví aktuální prostor.
     */
    public void setCurrentSpace(Space currentSpace){
        this.currentSpace = currentSpace;
    }
    /***************************************************************************
     * Vrátí odkaz na místnost se zadaným názvem.
     *
     * *
     * @param name Název požadované místnosti
     * @return Místnost se zadaným názvem (nezávisle na velkosti písmen)
     * nebo {@code null} v případě, že taková místnost neexistuje
     */
    Space getSpace(String name)
    {
        Optional<Space> space = INamed.getO(name, spaces);
        Space result = space.orElse(null);
        return result;
    }
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
