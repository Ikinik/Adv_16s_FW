/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.adv16s._2_1615.sora00_sorfa.game;

import eu.pedu.adv16s_fw.game_txt.IBag;


/**
 * Instance třídy {@code EmptyBag} představují úložiště,
 * do nichž hráči ukládají objekty sebrané v jednotlivých prostorech,
 * aby je mohli přenést do jiných prostorů a/nebo použít.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
 */
class Bag extends ItemContainer implements IBag
{
//== CONSTANT CLASS FIELDS =====================================================

    /** Pouze jedna instance ve hře */
    private static final Bag SINGLETON = new Bag();



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
     * Tovární metoda vracející instanci třídy v dané hře
     *
     * @return Instance třídy v dané hře
     */
    static Bag getInstance()
    {
        return SINGLETON;
    }

    Bag() {
        super(6);
    }

//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================


//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
