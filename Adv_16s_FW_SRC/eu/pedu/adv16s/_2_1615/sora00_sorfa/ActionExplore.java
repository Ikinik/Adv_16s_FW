/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.adv16s._2_1615.sora00_sorfa;

import eu.pedu.adv16s_fw.game_txt.INamed;

import java.util.Arrays;
import java.util.Optional;

import static eu.pedu.adv16s._2_1615.sora00_sorfa.Texts.*;


/*******************************************************************************
 * Třída akce sloužící pro přesun z jednoho ptostoru do druhého.
 *
 * @author  Adam Šorfa
 */
class ActionExplore extends AAction
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
    ActionExplore()
    {
        super (pPROZKOUMEJ,
                "Prozkoumá daný předmět");
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
     * @param arguments ActionMove arguments –
     *                  their number can be different for each action,
     *                  but for all execution of the same action is the same
     * @return The answer of the game after processing the command
     */
    @Override
    public String execute(String... arguments)
    {
        if(arguments.length < 2){
            return zZKOUMANY_PREDMNET_NEZADAN;
        }

        String itemName = arguments[1];
        Space currentSpace = World.getInstance().getCurrentSpace();
        Item item = currentSpace.getItem(itemName);
        if(item == null){
            return zNENI_ITEM;
        }

        if(!Flags.isExplorableItem(itemName)){
            return zNENI_ZKOUMATELNY;
        }else{
            Flags.ExploredContent exploredContent =
                    Flags.getExploredContent(itemName);
            if(exploredContent.isEmpty()){
                return zPROZKOUMANY;
            }else{
                exploredContent.flushItems().stream().forEach(exploredItem -> {
                    currentSpace.forceAddItem(exploredItem);
                });
                return exploredContent.getMessage();
            }
        }
    }

//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================

//##############################################################################
//== NESTED DATA TYPES =========================================================
}
