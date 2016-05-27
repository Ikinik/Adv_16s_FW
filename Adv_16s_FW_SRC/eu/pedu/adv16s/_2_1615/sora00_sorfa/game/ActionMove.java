/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.adv16s._2_1615.sora00_sorfa.game;

import eu.pedu.adv16s_fw.game_txt.INamed;

import java.util.Optional;

import static eu.pedu.adv16s._2_1615.sora00_sorfa.game.Texts.*;


/**
 * Třída akce sloužící pro přesun z jednoho ptostoru do druhého.
 *
 * @author  Adam Šorfa
 */
class ActionMove extends AAction
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
     * Vytvoří instanci pro akci jdi
     */
    ActionMove()
    {
        super (pJDI,
                "Přesune hráče do sousední místnonsi, zadané jako parametr.");
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /**
     * Přesune hráče z jednoho prostoru do druhého. Lze se přesunout poze do
     * sousedních prostor aktuálního prostoru.
     *
     * @param arguments Prostor do kterého se má hráč přesunout.
     * @return Text zprávy vypsané po provedeni příkazu
     */
    @Override
    public String execute(String... arguments)
    {
        if(arguments.length < 2){
            return zCIL_NEZADAN;
        }
        String destinationName = arguments[1];
        Space currentSpace = World.getInstance().getCurrentSpace();
        Optional<Space> destination = INamed.getO(destinationName,
                currentSpace.getNeighbors());
        if(!destination.isPresent()){
            return zNENI_CIL;
        }
        Space destinationSpace = destination.get();
        World.getInstance().setCurrentSpace(destinationSpace);
        return destinationSpace.getMessage();
    }

//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================

//##############################################################################
//== NESTED DATA TYPES =========================================================
}
