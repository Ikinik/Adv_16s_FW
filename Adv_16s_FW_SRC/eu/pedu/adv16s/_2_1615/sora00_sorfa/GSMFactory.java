/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.adv16s._2_1615.sora00_sorfa;

import eu.pedu.adv16s._2_1615.sora00_sorfa.game.IAuthorPrototype;
import eu.pedu.adv16s._2_1615.sora00_sorfa.game.RobotGame;
import eu.pedu.adv16s._2_1615.sora00_sorfa.game.ScenarioManager;
import eu.pedu.adv16s_fw.game_txt.IGSMFactory;
import eu.pedu.adv16s_fw.game_txt.IGame;
import eu.pedu.adv16s_fw.scenario.AScenarioManager;

/**
 * Instance třídy {@code GSMFactory} představují tovární objekty,
 * které jsou schopny na požádání dodat instanci aktuální hry
 * a správce scénářů této hry, tj. dodat kombinaci
 * (Game + ScenarioManager Factory).
 * <p>
 * V první fázi bývá aktivována pouze metoda {@link #getScenarioManager()}
 * umožňující získání instance správce scénářů vyvíjené hry.
 * Posléze po odkomentování zakomentovaných metod lze postupně získat
 * také vlastní textové i grafické verze hry
 * a jejího textového, resp. grafického uživatelského rozhraní.
 *
 * @author  Rudolf PECINOVSKÝ
 */
public class GSMFactory implements IGSMFactory, IAuthorPrototype
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
     * Vytvoří tovární objekt poskytující klíčové objekty hry
     */
    public GSMFactory()
    {
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    /**
     * Vrací instanci {@link ScenarioManager}
     *
     * @return Pořadovaný scenario manager
     */
    @Override
    public AScenarioManager getScenarioManager()
    {
        return ScenarioManager.getInstance();
    }


    /**
     * @return  Odkaz na instanci hry
     */
    @Override
    public IGame getGame()
    {
       return RobotGame.getInstance();
    }


    /**
     * Vrací objekt zpracovávající uživatelské rozhraní
     *
     * @return Požadované uživatelské rozhraní
     */
//    @Override
//    public IUI getUI()
//    {
//        return TextUI_Instance;
//    }



//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
