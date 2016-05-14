/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.adv16s._2_1615.sora00_sorfa;

import eu.pedu.adv16s_fw.game_txt.IBag;
import eu.pedu.adv16s_fw.game_txt.IItem;
import eu.pedu.adv16s_fw.utilities.UncompletedMethodException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;


/*******************************************************************************
 * Instance of the {@code EmptyBag} class represents the repository,
 * to which the players store the items picked up in individual spaces,
 * so that they could be moved to other spaces and/or used.
 * The disposal site has a final capacity defining the maximal permitted
 * sum of weights of items occuring in the repository.
 * <p>
 * In this game the bag is ...
 * with capacity ....
 * The item weight represents
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
 */
class Bag implements IBag
{
//== CONSTANT CLASS FIELDS =====================================================

    /** The only instance of the bag in the game. */
    private static final Bag SINGLETON = new Bag();



//== VARIABLE CLASS FIELDS =====================================================



//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================



//##############################################################################
//== CONSTANT INSTANCE FIELDS ==================================================
    private static int CAPACITY = 4;
//== VARIABLE INSTANCE FIELDS ==================================================
    private Collection<Item> items;


//##############################################################################
//== CONSTRUCTORS AND FACTORY METHODS ==========================================

    /***************************************************************************
     * Factory method returning the only existing instance of the game.
     *
     * @return The instance of the given game
     */
    static Bag getInstance()
    {
        return SINGLETON;
    }


    /***************************************************************************
     */
    Bag()
    {
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    /***************************************************************************
     * Returns the bag capacity, i.e. the maximal permitted sum
     * of weights of items, that can be put into the bag at the same time.
     *
     * @return Capacity of the bag
     */
    @Override
    public int getCapacity()
    {
        return CAPACITY;
    }


    /***************************************************************************
     * Returns the collection of items saved in the bag.
     *
     * @return Collection of items in the bag
     */
    @Override
    public Collection<? extends IItem> getItems()
    {
        return Collections.unmodifiableCollection(items);
    }

    public boolean tryAddItem(Item item){
        if(!item.isMovable() || items.size() >= getCapacity()){
            return false;
        }
        items.add(item);
        return true;
    }

//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
    /***************************************************************************
     * Initialize.
     */
    void initialize()
    {
        items = new ArrayList<>();
    }

//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
