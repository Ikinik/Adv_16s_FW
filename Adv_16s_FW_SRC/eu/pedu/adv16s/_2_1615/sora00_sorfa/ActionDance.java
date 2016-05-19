/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.adv16s._2_1615.sora00_sorfa;

import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static eu.pedu.adv16s._2_1615.sora00_sorfa.Texts.*;


/*******************************************************************************
 * Akce sloužící k zatancování.
 *
 * @author  Adam Šorfa
 */
class ActionDance extends AAction
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
    ActionDance()
    {
        super (pTANCUJ,
                "Robot zatancuje");
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
     * @param arguments ActionDance arguments –
     *                  their number can be different for each action,
     *                  but for all execution of the same action is the same
     * @return The answer of the game after processing the command
     */
    @Override
    public String execute(String... arguments)
    {
        Space currentSpace = World.getInstance().getCurrentSpace();
        boolean holcickaPresent = currentSpace.getItems().stream()
                                    .map(i->{return i.getName();})
                                    .filter(Predicate.isEqual(HOLCICKA))
                                    .findFirst().isPresent();
        if(holcickaPresent){
            Item sponka = new Item(MV + SPONKA);
            if(Bag.getInstance().tryAddItem(sponka)){
                return zTANCUJ_HOLCICKA;
            }else{
                return zTANCUJ_HOLCICKA_PLNY_BATOH;
            }
        }else{
            if(arguments.length > 1) {
                arguments = Arrays.copyOfRange(arguments, 1, arguments.length);
                return zTANCUJ_KDEKOLIV + " " + String.join(" ", arguments);
            }else{
                return zTANCUJ_KDEKOLIV;
            }
        }
    }

//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================

//##############################################################################
//== NESTED DATA TYPES =========================================================
}
