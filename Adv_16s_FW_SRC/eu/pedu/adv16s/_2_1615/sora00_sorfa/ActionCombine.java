/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.adv16s._2_1615.sora00_sorfa;

import eu.pedu.adv16s._2_1615.sora00_sorfa.auxiliaryClases.Pair;

import static eu.pedu.adv16s._2_1615.sora00_sorfa.Texts.*;


/*******************************************************************************
 * Akce sloužící ke skombinování dvou věcí dohromady. Pokud jsou skombinovány
 * správné předměty vznikne předmět nový.
 *
 * @author  Adam Šorfa
 */
class ActionCombine extends AAction
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
    ActionCombine()
    {
        super (pSKOMBINUJ,
                "Pokusí se skombinovat dvě věci dohromady.");
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
     * @param arguments ActionCombine arguments –
     *                  their number can be different for each action,
     *                  but for all execution of the same action is the same
     * @return The answer of the game after processing the command
     */
    @Override
    public String execute(String... arguments)
    {
        if(arguments.length < 3){
            return zSKOMBINUJ_NEZADAN;
        }

        Bag bag = Bag.getInstance();
        Item firstItem = bag.getItem(arguments[1]);
        Item secondItem = bag.getItem(arguments[2]);

        if( firstItem == null || secondItem == null){
            return zSKOMBINUJ_NENI_V_BATOHU;
        }

        Pair<String> combinedPair = new Pair<String>(arguments[1],
                                                arguments[2]);
        if(Flags.isCombinablePair(combinedPair)){
            Flags.CombinedContent
                    result = Flags.getCombinedContent(combinedPair);

            bag.removeItem(firstItem);
            bag.removeItem(secondItem);
            bag.tryAddItem(result.getManufacturedItem());

            return result.getMessage();
        }else{
            return zSKOMBINUJ_NENI_KOMBINACE;
        }
    }

//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================

//##############################################################################
//== NESTED DATA TYPES =========================================================
}
