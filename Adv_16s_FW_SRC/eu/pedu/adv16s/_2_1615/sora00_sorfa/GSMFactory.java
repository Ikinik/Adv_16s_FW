/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.adv16s._2_1615.sora00_sorfa;

import eu.pedu.adv16s_fw.game_txt.IGSMFactory;
import eu.pedu.adv16s_fw.scenario.AScenarioManager;



/*******************************************************************************
 * Instances of the {@code GSMFactory } class represent
 * the factory objects which are able to deliver the game instance,
 * an instance of scenario manager of this game
 * and an instance of the text user interface.
 * As long as some of these objects are not yet fully defined,
 * the methods throw the
 * {@link eu.pedu.adv16s_fw.utilities.UncompletedMethodException}.
 * <p>
 * In the first stage of the whole application development only the method
 * {@link #getScenarioManager()} allowing to obtain
 * the scenario manager instance is active.
 * Bodies of remaining methods are commented.
 * In the next development stages also these methods are uncommented.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
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

    /***************************************************************************
     * Creates the factory object providing the key application objects.
     */
    public GSMFactory()
    {
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    /***************************************************************************
     * Returns the instance of the scenario manager.
     *
     * @return Required scenario manager
     */
    @Override
    public AScenarioManager getScenarioManager()
    {
        return ScenarioManager.getInstance();
    }


    /***************************************************************************
     * Returns the instance of text version of the game.
     *
     * @return Required game
     */
//    @Override
//    public IGame getGame()
//    {
//        return GameClass.getInstance();
//    }


    /***************************************************************************
     * Returns the object executing the user interface.
     *
     * @return Required user interface
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
