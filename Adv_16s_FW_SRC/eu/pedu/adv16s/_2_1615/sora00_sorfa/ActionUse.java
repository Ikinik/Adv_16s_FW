/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.adv16s._2_1615.sora00_sorfa;

import eu.pedu.adv16s._2_1615.sora00_sorfa.auxiliaryClases.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

import static eu.pedu.adv16s._2_1615.sora00_sorfa.Texts.*;


/*******************************************************************************
 * Akce slouží k použití předmětu v inventáři na předmět v aktuálním prostoru
 *
 * @author  Adam Šorfa
 */
class ActionUse extends AAction
{
//== CONSTANT CLASS FIELDS =====================================================
    static final Map<String,Callable<String>>
        combinableItems = new HashMap<String,Callable<String>>();

//== VARIABLE CLASS FIELDS =====================================================

//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
    static {
        combinableItems.put((PISTOLE+" "+TATINEK).toLowerCase(),()-> {
            if(Bag.getInstance().tryAddItem(new Item(MV + TATINEK))){
                Space currentSpace = World.getInstance().getCurrentSpace();
                Item tatinek = currentSpace.getItem(TATINEK);
                currentSpace.removeItem(tatinek);

                return zPOUZIJ_PISTOLE_TATINEK;
            }else{
                return zPOUZIJ_PISTOLE_TATINEK;
            }
        });

        combinableItems.put((SEKERA+" "+OBRAZ).toLowerCase(),() -> {
            Space currentSpace = World.getInstance().getCurrentSpace();
            Item obraz = currentSpace.getItem(OBRAZ);
            currentSpace.removeItem(obraz);
            currentSpace.forceAddItem(new Item(MV + TRISKY));

            return zPOUZIJ_SEKERA_OBRAZ;
        });

        combinableItems.put((TATINEK+" "+AUTO).toLowerCase(),()->{
            Space sklad = World.getInstance()
                                      .getSpace(SKLAD_JADERNYCH_ZBRANI);
            World.getInstance().setCurrentSpace(sklad);

            stopGame();
            return zSUCCESS_END;
        });
    }
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
    ActionUse()
    {
        super (pPOUZIJ,
                "Použije věc v batohu na věc v aktuální místnosti");
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /****************************************************************************
     * @param arguments ActionCombine arguments –
     *                  their number can be different for each action,
     *                  but for all execution of the same action is the same
     * @return The answer of the game after processing the command
     */
    @Override
    public String execute(String... arguments)
    {
        if(arguments.length < 3){
            return zPOUZIJ_NEZADAN;
        }

        Bag bag = Bag.getInstance();
        Space currentSpace = World.getInstance().getCurrentSpace();

        String toolName = arguments[1].toLowerCase();
        String thinkName = arguments[2].toLowerCase();
        Item tool = bag.getItem(toolName);
        Item think = currentSpace.getItem(thinkName);

        if(tool == null){
            return zPOUZIJ_NENI_TOOL;
        }else if(think == null){
            return zPOUZIJ_NENI_VEC;
        }else{
            if(combinableItems.containsKey(toolName+" "+thinkName)){
                try {
                    return combinableItems.get(toolName+" "+thinkName)
                                          .call();
                } catch (Exception e) {
                    return zPOUZIJ_EXCEPTION;
                }
            }else{
                return zPOUZIJ_NELZE_POUZIT;
            }
        }
    }

//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================

//##############################################################################
//== NESTED DATA TYPES =========================================================
}
