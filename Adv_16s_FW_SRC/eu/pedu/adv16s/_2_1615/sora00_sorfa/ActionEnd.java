/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.adv16s._2_1615.sora00_sorfa;

import static eu.pedu.adv16s._2_1615.sora00_sorfa.Texts.*;


/*******************************************************************************
 * Třída akce sloužící pro přesun z jednoho ptostoru do druhého.
 *
 * @author  Adam Šorfa
 */
class ActionEnd extends AAction
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
    ActionEnd()
    {
        super (pKONEC,
                "Ukončí hru");
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /***************************************************************************
     * Předčasně ukončí hru.
     *
     * @param arguments Parametry příkazu - nepoužité
     * @return Text zprávy vypsané po provedeni příkazu
     */
    @Override
    public String execute(String... arguments)
    {
        stopGame();
        return zKONEC;
    }

//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================

//##############################################################################
//== NESTED DATA TYPES =========================================================
}
