/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.adv16s_fw.empty_classes;

import eu.pedu.adv16s_fw.game_txt.IItem;

import java.util.Collection;
import eu.pedu.adv16s_fw.game_txt.ISpace;
import eu.pedu.adv16s_fw.utilities.UncompletedMethodException;



/*******************************************************************************
 * Instances of the {@code EmptySpace} class represent the spaces in the game.
 *
 * We can take the space visiting as a partial goal,
 * which the player tries to reach.
 * The spaces can be rooms, planets, life stages etc.
 * The spaces can contain various items.that may help user to reach the goal.
 * Each space knows its current neighboring spaces and it knows
 * which items it currently contains.
 * The neighbors as well as the contained items can change during the game.
 * <p>
 * In this program the spaces are ...
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
 */
class Space extends ANamed implements ISpace
{
//== CONSTANT CLASS FIELDS =====================================================
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
     *
     */
    Space(String name)
    {
        super(name);
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    /***************************************************************************
     * Returns the collection of current neighbors of this space, i.e. the
     * collection of spaces, to which we can move from this space with the
     * command of the {@link eu.pedu.adv16s_fw.scenario.TypeOfStep#tsMOVE
     * TypeOfStep.tsMOVE} type.
     *
     * @return Collection of neighbors
     */
    @Override
    public Collection<? extends ISpace> getNeighbors()
    {
        //TODO EmptySpace.getNeighbors - Metoda ještě není hotova
        throw new UncompletedMethodException();
    }


    /***************************************************************************
     * Returns a collection of items located in the given space.
     *
     * @return Collection of items located in the given space
     */
    @Override
    public Collection<? extends IItem> getItems()
    {
        //TODO EmptySpace.getItems - Metoda ještě není hotova
        throw new UncompletedMethodException();
    }



//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
