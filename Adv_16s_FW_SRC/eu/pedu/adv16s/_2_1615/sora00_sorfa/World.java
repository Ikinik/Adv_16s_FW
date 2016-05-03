/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.adv16s._2_1615.sora00_sorfa;

import java.util.Collection;
import eu.pedu.adv16s_fw.game_txt.IWorld;
import eu.pedu.adv16s_fw.game_txt.ISpace;
import eu.pedu.adv16s_fw.utilities.UncompletedMethodException;



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



//== VARIABLE CLASS FIELDS =====================================================



//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================



//##############################################################################
//== CONSTANT INSTANCE FIELDS ==================================================
//== VARIABLE INSTANCE FIELDS ==================================================



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
        //TODO EmptyGame.getAllSpaces - Metoda ještě není hotova
        throw new UncompletedMethodException();
    }


    /***************************************************************************
     * Returns the current space,
     * i.e. to the space in which the player is just situated.
     *
     * @return The space in which the player is just situated
     */
    @Override
    public ISpace getCurrentSpace()
    {
        //TODO EmptyGame.getCurrentSpace - Metoda ještě není hotova
        throw new UncompletedMethodException();
    }



//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
