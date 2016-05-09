/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.adv16s._2_1615.sora00_sorfa;

import java.util.*;
import java.util.stream.Collectors;

import eu.pedu.adv16s_fw.game_txt.ISpace;



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
    /** Název dané místnosti */
    private final String name;

    /** Názvy sousedů místnosti na počátku hry. */
    private final String[] neighborNames;

    /** Názvy objektů v místnosti na počátku hry. */
    private final String[] itemNames;

//== VARIABLE INSTANCE FIELDS ==================================================
    private Collection<Space> neighbors;
    private Collection<Item> items;

//##############################################################################
//== CONSTRUCTORS AND FACTORY METHODS ==========================================

    /***************************************************************************
     * Vytvoří novou místnost se zadaným názvem a
     * zadanými názvy jejich počátečních sousedů a objektů.
     *
     * @param name          Název dané místnosti
     * @param neighborNames Názvy sousedů místnosti na počátku hry
     * @param itemNames   Názvy objektů v místnosti na počátku hry
     */
    Space(String name, String[] neighborNames, String... itemNames) {
        super(name);
        this.name = name;
        this.neighborNames = neighborNames;
        this.itemNames = itemNames;
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    /***************************************************************************
     * @return jméno prostoru
     */
    public String getName(){
        return this.name;
    }

    /***************************************************************************
     * Returns the collection of current neighbors of this space, i.e. the
     * collection of spaces, to which we can move from this space with the
     * command of the {@link eu.pedu.adv16s_fw.scenario.TypeOfStep#tsMOVE
     * TypeOfStep.tsMOVE} type.
     *
     * @return Collection of neighbors
     */
    @Override
    public Collection<Space> getNeighbors()
    {
        return Collections.unmodifiableCollection(neighbors);
    }

    /***************************************************************************
     * Returns a collection of items located in the given space.
     *
     * @return Collection of items located in the given space
     */
    @Override
    public Collection<Item> getItems()
    {
        return Collections.unmodifiableCollection(items);
    }



//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
    /***************************************************************************
     * Nastaví výchozí stav dané místnosti na počátku hry.
     */
    void initialize(){
        initializeNeightbors();
        initializeItems();
    }

//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================
    private void initializeNeightbors(){
        World world = World.getInstance();
        neighbors = Arrays.stream(neighborNames)
                          .map(world::getSpace)
                          .collect(Collectors.toList());
    }

    private void initializeItems(){
        items = Arrays.stream(itemNames)
                      .map(Item::new)
                      .collect(Collectors.toList());
    }

//##############################################################################
//== NESTED DATA TYPES =========================================================
}
