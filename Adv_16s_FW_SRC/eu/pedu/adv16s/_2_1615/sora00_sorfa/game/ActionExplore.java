/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.adv16s._2_1615.sora00_sorfa.game;

import java.util.ArrayList;
import java.util.List;

import static eu.pedu.adv16s._2_1615.sora00_sorfa.game.Texts.*;


/**
 * Akce sloužící k prozkoumání předmětu v místnosti
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

    /**
     * Vytvoří instanci pro akci prozkoumání
     */
    ActionExplore()
    {
        super (pPROZKOUMEJ,
                "Prozkoumá daný předmět");
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /**
     * Prozkoumáváný předmět musí být umístěn v aktuální místnosti a musí být
     * zkoumatelný. Záznam o tom zada li je nějaký předmět zakoumatelný je
     * uložen ve statické třídě {@link Flags}. Pokud je předmět zkoumatelný
     * jsou do aktuální místnosti přidány předměty, jenž obsahoval.
     *
     * @param arguments prozkoumávan předmět (1 argument)
     * @return Text zprávy vypsané po provedeni příkazu
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
            if(exploredContent.isExplored()){
                return zPROZKOUMANY;
            }else{
                String message;

                if(!exploredContent.isEmpty()) {
                    List<String> exploredItems = new ArrayList<String>();
                    exploredContent.flushItems().stream().forEach(
                        exploredItem -> {
                            exploredItems.add(exploredItem.getName());
                            currentSpace.forceAddItem(exploredItem);
                        }
                    );

                    message = exploredContent.getMessage() +
                              "\nDo místlosti přibyli následující předměty: " +
                              String.join(" ", exploredItems);
                }else{
                    message = exploredContent.getMessage();
                }

                exploredContent.setExplored();
                return message;
            }
        }
    }

//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================

//##############################################################################
//== NESTED DATA TYPES =========================================================
}
