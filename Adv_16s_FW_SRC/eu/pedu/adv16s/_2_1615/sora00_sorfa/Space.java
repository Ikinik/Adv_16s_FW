/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.adv16s._2_1615.sora00_sorfa;

import java.util.*;
import java.util.stream.Collectors;

import eu.pedu.adv16s_fw.game_txt.IGame;
import eu.pedu.adv16s_fw.game_txt.INamed;
import eu.pedu.adv16s_fw.game_txt.ISpace;

import static eu.pedu.adv16s._2_1615.sora00_sorfa.Texts.zNIC_NENI;
import static eu.pedu.adv16s._2_1615.sora00_sorfa.Texts.zPRESUN;
import static eu.pedu.adv16s._2_1615.sora00_sorfa.Texts.zPRESUN_POPIS_ITEMU;


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
class Space extends ItemContainer implements ISpace, INamed
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
    private String name;

    /** Názvy sousedů místnosti na počátku hry. */
    private final String[] neighborNames;

    /** Názvy objektů v místnosti na počátku hry. */
    private final String[] itemNames;

    /** Uvítací správa zobrazená při prvním navštívení prostoru. */
    private final String welcomeMessage;

    /** Počet vstupů do místnosti, kolikrát byla místnost už navštívena. */
    private int entersCount = 0;
//== VARIABLE INSTANCE FIELDS ==================================================
    private Collection<Space> neighbors;

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
        super(itemNames);
        checkName(name);
        this.name = name;
        this.neighborNames = neighborNames;
        this.itemNames = itemNames;
        this.welcomeMessage = "";
    }

    Space(String name, String welcomeMessage, String[] neighborNames,
          String... itemNames) {
        super(itemNames);
        checkName(name);
        this.name = name;
        this.neighborNames = neighborNames;
        this.itemNames = itemNames;
        this.welcomeMessage = welcomeMessage;
    }


//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    public String getMessage(){
        Collection<Item> itemsInside = getItems();

        String realItemNames;
        if(!itemsInside.isEmpty()) {
            realItemNames = itemsInside.stream()
                    .map(item -> item.getName())
                    .collect(Collectors.joining(" "));
        }else{
            realItemNames = zNIC_NENI;
        }

        if(entersCount++ == 0 && welcomeMessage != ""){
            return zPRESUN + getName() + "\n" + welcomeMessage +
                    "\n\n" + zPRESUN_POPIS_ITEMU + realItemNames;
        }else{
            return zPRESUN + getName() + "\n" + zPRESUN_POPIS_ITEMU +
                    realItemNames;
        }
    }

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

    @Override
    public String toString()
    {
        return name;
    }

//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
    /***************************************************************************
     * Nastaví výchozí stav dané místnosti na počátku hry.
     */
    void initialize(){
        super.initialize();
        initializeNeightbors();
    }

//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================
    private void initializeNeightbors(){
        World world = World.getInstance();
        neighbors = Arrays.stream(neighborNames)
                .map(world::getSpace)
                .collect(Collectors.toList());
    }

    /**
     * Vnitřek konstruktoru abstaraktní třídy ANamed. Musel jsem implementovat
     * uvnitř třídy, aby tato třída {@code Space} mohla být potomkem třídy
     * {@code {@link ItemContainer}}
     * @param name název prostoru.
     */
    private void checkName(String name){
        if ((name == null)  ||  name.isEmpty()) {
            throw new IllegalArgumentException(
                    "\nThe object name may be neither null "
                            + "nor an empty string");
        }
        if (! (this instanceof IGame)         &&
                ( (! name.equals(name.trim())) ||
                        (name.split("\\s").length > 1)  ))
        {
            throw new IllegalArgumentException(
                    "\nNames may not contain any whitespaces - Entered: «"
                            + name + '»');
        }
        this.name = name;
    }
//##############################################################################
//== NESTED DATA TYPES =========================================================
}
