/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.adv16s._2_1615.sora00_sorfa.game;

import java.util.Collection;
import java.util.stream.Collectors;

import static eu.pedu.adv16s._2_1615.sora00_sorfa.game.Texts.*;


/**
 * Akce sloužící k rozhlédnutí se po místnosti. Zobrazuje popis aktuálního
 * prostoru
 *
 * @author  Adam Šorfa
 */
class ActionLookAround extends AAction
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

    /**
     * Vytvoří instanci pro akci rozhlédni-se
     */
    ActionLookAround()
    {
        super (pROZHLED,
                "Vypíše aktuální stav prostoru a obsah batohu.");
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /**
     * Vypíše předměty obsažené v aktuální místnosti, dostupné sousední
     * místnosti a aktuální obsah batohu
     *
     * @param arguments zadané parametry nejsou zpracovávány
     * @return Text zprávy vypsané po provedeni příkazu
     */
    @Override
    public String execute(String... arguments)
    {
        Space currentSpace = World.getInstance().getCurrentSpace();
        Collection<Item> itemsInside = currentSpace.getItems();
        Collection<Space> neighbors = currentSpace.getNeighbors();
        Collection<Item> itemsInBag = Bag.getInstance().getItems();
        String strItems;
        String strNeighbors;
        String strItemsInBag;
        String spaceName = currentSpace.getName();

        if(!itemsInside.isEmpty()){
            strItems = itemsInside.stream()
                                  .map(item -> item.getName())
                                  .collect(Collectors.joining(" "));
        }else{
            strItems = zNIC_NENI;
        }

        if(!itemsInBag.isEmpty()){
            strItemsInBag = itemsInBag.stream()
                                      .map(item -> item.getName())
                                      .collect(Collectors.joining(" "));
        }else{
            strItemsInBag = zNIC_NENI;
        }

        if(!neighbors.isEmpty()){
            strNeighbors = neighbors.stream()
                                    .map(space -> space.getName())
                                    .collect(Collectors.joining(" "));
        }else{
            strNeighbors = "Nikam";
        }

        return
        "V aktuálním prostoru: " +spaceName+ " se\n" +
        "nachází: " + strItems + "\n\n" +
        "v batohu máte: " + strItemsInBag + "\n\n" +
        "Odsud je dále možné jít: " + strNeighbors;
    }

//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================

//##############################################################################
//== NESTED DATA TYPES =========================================================
}
