/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.adv16s._2_1615.sora00_sorfa.game;

import java.util.Arrays;
import java.util.function.Predicate;

import static eu.pedu.adv16s._2_1615.sora00_sorfa.game.Texts.*;


/**
 * Akce sloužící k zatancování.
 *
 * @author  Adam Šorfa
 */
class ActionDance extends AAction
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
     * Vytvoří instanci akce zatancuj
     */
    ActionDance()
    {
        super (pTANCUJ,
                "Robot zatancuje");
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /**
     * Robot provede taneček, pokud jsou příkazu zadány nějaké argumenty jsou
     * vráceny jako text hlášky po zatancování. Pokud je tanec proveden
     * ve stejné místnosti s předmětem {@code Holčička} Obdrží hráč předmět
     * sponka, který je důležitý pro další průběh hry.
     *
     * @param arguments Akce má libovolný počet parametrů. Parametry jsou
     *                  vrávceny jakou součást hlášky po zatancování robota
     * @return Text zprávy vypsané po provedeni příkazu
     */
    @Override
    public String execute(String... arguments)
    {
        Space currentSpace = World.getInstance().getCurrentSpace();
        boolean holcickaPresent = currentSpace.getItems().stream()
                                    .map(i->{return i.getName();})
                                    .filter(Predicate.isEqual(HOLCICKA))
                                    .findFirst().isPresent();
        if(holcickaPresent){
            Item sponka = new Item(MV + SPONKA);
            if(Bag.getInstance().tryAddItem(sponka)){
                return zTANCUJ_HOLCICKA;
            }else{
                return zTANCUJ_HOLCICKA_PLNY_BATOH;
            }
        }else{
            if(arguments.length > 1) {
                arguments = Arrays.copyOfRange(arguments, 1, arguments.length);
                return zTANCUJ_KDEKOLIV + " " + String.join(" ", arguments);
            }else{
                return zTANCUJ_KDEKOLIV;
            }
        }
    }

//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================

//##############################################################################
//== NESTED DATA TYPES =========================================================
}
