/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.adv16s._2_1615.sora00_sorfa.game;

import eu.pedu.adv16s_fw.game_txt.IGame;
import eu.pedu.adv16s_fw.game_txt.INamed;



/**
 * Instance třídy {@code ANamed} představují rodičovské podobjekty
 * instancí tříd pojmenovaných objektů, tj. tříd implementujících
 * interfejs {@link INamed}.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
 */
public abstract class ANamed implements INamed
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

    /** Název dané instance. */
    private final String name;



//== VARIABLE INSTANCE FIELDS ==================================================



//##############################################################################
//== CONSTRUCTORS AND FACTORY METHODS ==========================================

    /**
     * Vytvoří rodičovský podobjekt instance objektu se zadaným názvem.
     *
     * @param name Název dané instance
     */
    public ANamed(String name)
    {
        if ((name == null)  ||  name.isEmpty()) {
            throw new IllegalArgumentException(
                        "\nThe object name may be neither null "
                      + "nor an empty string");
        }
        if (! (this instanceof IGame)         &&
            ( (! name.equals(name.trim())) ||
              (name.split("\\s").length > 1)  ))
        {
            throw new IllegalArgumentException(
                      "\nNames may not contain any whitespaces - Entered: «"
                    + name + '»');
        }
        this.name = name;
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    /**
     * Vrátí název dané instance.
     *
     * @return Název instance
     */
    @Override
    public String getName()
    {
        return name;
    }



//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /**
     * Vrátí textový podpis dané instance tvořený názvem její mateřské třídy
     * následovaným znakem podtržení a názvem instance.
     *
     * @return Název instance
     */
    @Override
    public String toString()
    {
        return name;
    }



//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
