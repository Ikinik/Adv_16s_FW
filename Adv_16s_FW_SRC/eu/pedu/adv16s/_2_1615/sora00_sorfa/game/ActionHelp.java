/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.adv16s._2_1615.sora00_sorfa.game;

import java.util.Collection;
import java.util.stream.Collectors;

import static eu.pedu.adv16s._2_1615.sora00_sorfa.game.Texts.*;


/**
 * Akce sloužící pro zobrazení nápovědy.
 *
 * @author  Adam Šorfa
 */
class ActionHelp extends AAction
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
     * Vytvoří instanci pro akci nápověda
     */
    ActionHelp()
    {
        super (pHELP,
               "Vypíše nápovědu - názvy a popisy všech příkazů");
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /**
     * Vypíše nápovědu, jakým směrem se ubýrat pro úspěšné dohrání hry podle
     * hlavního scénáře. K tomu vypíše seznam všech příkazů s jejich popisem.
     *
     * @param arguments Zadané parametry nejsou nijak zpracovávány.
     * @return Text zprávy vypsané po provedeni příkazu
     */
    @Override
    public String execute(String... arguments)
    {
        RobotGame game = RobotGame.getInstance();
        Collection<AAction> actions = game.getAllActions();
        String result =
            "Nápověda:\n Abyste vyhladil lidstvo musíte se nějak dostat \n" +
            "do nedalekého skladu jaderných zbraní. K tomu by vám mohl \n" +
            "pomoct nědko v domě. Budete ho ale muste nějak motivovat. \n" +
            "Dostat se pouze do skaldu nestačí. Budete potřebovat tajný kód\n" +
            "k odpálení jaderných hlavic. (Pssst prý se nachází u \n" +
            "důvěryhodné osoby v v domě.\n\n" +
            "Seznam užitečných příkazů:\n" +
            actions.stream().map(cmd -> cmd.getName() + " - " +
                                        cmd.getDescription())
                                        .collect(Collectors.joining("\n"));
        return result;
    }

//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================

//##############################################################################
//== NESTED DATA TYPES =========================================================
}
