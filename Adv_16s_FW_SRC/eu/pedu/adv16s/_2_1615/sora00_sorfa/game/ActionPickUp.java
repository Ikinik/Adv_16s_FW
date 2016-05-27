/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.adv16s._2_1615.sora00_sorfa.game;


/**
 * Akce slouží k sebrání předmětu. Tj. přemístění předmětu z aktuálního
 * prostoru do batohu {@link Bag}
 *
 * @author  Adam Šorfa
 */
class ActionPickUp extends AAction
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
     * Vytvoří instanci pro akci seber
     */
    ActionPickUp()
    {
        super (Texts.pSEBER,
                "Sebere věc a vloží do inventáře.");
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /**
     * Sebere věc z daného prostoru a přemístí jí do batohu {@link Bag}. Aby
     * bylo věc {@link Item} možné sebrat musí bát zadefinována z příznakem
     * movable. Zároveň nesmí být vyčerpána kapacita batohu.
     *
     * @param arguments Předmět, který má být sebrán
     * @return Text zprávy vypsané po provedeni příkazu
     */
    @Override
    public String execute(String... arguments)
    {
        if(arguments.length < 2){
            return Texts.zPREDMET_NEZADAN;
        }
        String itemName = arguments[1];
        Space currentSpace = World.getInstance().getCurrentSpace();
        Item item = currentSpace.getItem(itemName);
        if(item == null){
            return Texts.zNENI_ITEM;
        }

        Bag bag = Bag.getInstance();
        if(bag.tryAddItem(item)){
            currentSpace.removeItem(item);
            return Texts.zZVEDNUTO + itemName;
        }else{
            return Texts.zNE_ZVEDNUTO;
        }
    }

//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================

//##############################################################################
//== NESTED DATA TYPES =========================================================
}