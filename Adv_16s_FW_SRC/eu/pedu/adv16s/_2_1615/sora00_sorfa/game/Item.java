/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.adv16s._2_1615.sora00_sorfa.game;

import eu.pedu.adv16s_fw.game_txt.IItem;


/**
 * Instance třídy {@code Item} přestavují předměty v prostorech {@link Space}.
 * Předměty mohou být jak věci, tak i osoby.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
 */
class Item extends ANamed implements IItem
{
//== CONSTANT CLASS FIELDS =====================================================
    private final boolean MOVABLE;
//== VARIABLE CLASS FIELDS =====================================================



//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================



//##############################################################################
//== CONSTANT INSTANCE FIELDS ==================================================
    /** Název předmětu */
    private String name;

//== VARIABLE INSTANCE FIELDS ==================================================



//##############################################################################
//== CONSTRUCTORS AND FACTORY METHODS ==========================================

    /**
     * Vytvoří předmět. Pokud jméno přednětu začíná mřížkou {@code #} je
     * předmětu nastaven příznak movable. Mřížka není součástí názvu předmětu.
     *
     * @param name Jméno aktuálního předmětu
     */
    Item(String name)
    {
        super(name);
        boolean movable = false;
        if(name.charAt(0) == '#'){
            movable = true;
            name = name.substring(1);
        }

        this.name = name;
        MOVABLE = movable;
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    /**
     * @return Váha předmětu
     */
    @Override
    public int getWeight()
    {
        return 0;
    }

    /** Pokud má předmět nastaven příznak moovable vrátí {@code true}. Pokud
     * ne, vrátí {@code false} */
    public boolean isMovable(){
        return MOVABLE;
    }

    /**
     * Vrátí název předmětu
     *
     * @return Název předmětu
     */
    @Override
    public String getName(){
        return name;
    }

//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
