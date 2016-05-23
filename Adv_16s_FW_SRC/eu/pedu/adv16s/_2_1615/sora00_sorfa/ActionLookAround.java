/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.adv16s._2_1615.sora00_sorfa;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static eu.pedu.adv16s._2_1615.sora00_sorfa.Texts.*;


/*******************************************************************************
 * Akce sloužící k zatancování.
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

    /***************************************************************************
     * Creates the action instance for ...
     */
    ActionLookAround()
    {
        super (pROZHLED,
                "Vypíše aktuální stav prostoru a obsah batohu.");
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

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
     * @param arguments ActionLookAround arguments –
     *                  their number can be different for each action,
     *                  but for all execution of the same action is the same
     * @return The answer of the game after processing the command
     */
    @Override
    public String execute(String... arguments)
    {
        Space currentSpace = World.getInstance().getCurrentSpace();
        Collection<Item> itemsInside = currentSpace.getItems();
        Collection<Space> neighbors = currentSpace.getNeighbors();
        String strItems;
        String strNeighbors;
        String spaceName = currentSpace.getName();

        if(!itemsInside.isEmpty()){
            strItems = itemsInside.stream()
                                  .map(item -> item.getName())
                                  .collect(Collectors.joining(" "));
        }else{
            strItems = zNIC_NENI;
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
        "Odsud je dále možné jít: " + strNeighbors;
    }

//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================

//##############################################################################
//== NESTED DATA TYPES =========================================================
}
