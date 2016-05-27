/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.adv16s._2_1615.sora00_sorfa.game;
import static eu.pedu.adv16s._2_1615.sora00_sorfa.game.Texts.*;


/*******************************************************************************
 * Akce skoužící k poleožení předmětu. Tj. přemístí předmět z batohu do
 * aktuální místnosti
 *
 * @author  Adam Šorfa
 */
class ActionPutDown extends AAction
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
     * Vytvoří instanci pro akci seber
     */
    ActionPutDown()
    {
        super (pPOLOZ,
                "Položí věc z inventáře na zem");
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /**
     * Přemístí věc z batobu {@link Bag} do aktuální místnosti {@link Space}.
     * Aby bylo možné věc přesunout. musí být přítomna v batohu. Do aktuálního
     * prostoru je možné přesunout libovolný počet předmětů. Kapacita prostorů
     * není omezena
     *
     * @param arguments Předmět, který má být pololžen
     * @return Text zprávy vypsané po provedeni příkazu
     */
    @Override
    public String execute(String... arguments)
    {
        if(arguments.length < 2){
            return zNENI_V_BATOHU;
        }
        String itemName = arguments[1];
        Space currentSpace = World.getInstance().getCurrentSpace();
        Bag bag = Bag.getInstance();

        Item item = bag.getItem(itemName);
        if(item == null){
            return zNENI_V_BATOHU;
        }

        currentSpace.tryAddItem(item);
        bag.removeItem(item);
        return zPOLOZENO + itemName;
    }

//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================

//##############################################################################
//== NESTED DATA TYPES =========================================================
}