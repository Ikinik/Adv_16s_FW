/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.adv16s._2_1615.sora00_sorfa.game;

import eu.pedu.adv16s._2_1615.sora00_sorfa.game.auxiliaryClases.Pair;

import static eu.pedu.adv16s._2_1615.sora00_sorfa.game.Texts.*;


/**
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

    /**
     * Vytvoří instanci akce, pro skombinování dvou předmětů v batohu
     */
    ActionCombine()
    {
        super (pSKOMBINUJ,
                "Pokusí se skombinovat dvě věci dohromady.");
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /**
     * Oba kombinované předměty musejí být přítomny v batohu {@link Bag}. Dále
     * musí být uvedená kombinace zaznamenána ve statické třídě {@link Flags }.
     * Pokud je kombinace možná jsou oba předměty smazány z batohu a jsou
     * nahrazeny jedním novým předmětem. Na pořadí zadávaných předmětů ke
     * skombinování nezáleží.
     *
     * @param arguments Parametry příkazu, vyžaduje další dva paramerty
     *                  pro určení věcí, které se mají skombinovat.
     * @return Text zprávy vypsané po provedeni příkazu
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
