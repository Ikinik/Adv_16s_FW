/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.adv16s._2_1615.sora00_sorfa;

import eu.pedu.adv16s_fw.game_txt.BasicActions;
import eu.pedu.adv16s_fw.game_txt.IGame;
import java.util.Collection;

import static eu.pedu.adv16s._2_1615.sora00_sorfa.Texts.*;


/*******************************************************************************
 * Instances of the {@code RobotGame} class are responsible for the game
 * logics. They are able to accept individual commands and provide information
 * on current state of the game and its parts.
 * <p>
 * The game class has to be defined as a singleton and,
 * besides methods declared in the {@link IGame} interface,
 * it has to define the {@code getInstance()} static factory method.
 * Fulfilling of this condition cannot be verified by the compiler, but they
 * can by verified by test utilizing the associated scenario manager.
 * <p>
 * {@code RobotGame} instances represent prototypes of game instances
 * which are not yet fully defined and serve only for completion
 * of the scenario managers features, which needs cooperation with the game.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
 */
public class RobotGame extends ANamed implements IGame, IAuthorPrototype
{
//== CONSTANT CLASS FIELDS =====================================================

    /** The reference to the only instance (singleton) of this game. */
    private static final RobotGame SINGLETON = new RobotGame();



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
     * The factory method returning the only instance of the given game.
     *
     * @return The instance of the given game
     */
    public static RobotGame getInstance()
    {
        return SINGLETON;
    }


    /***************************************************************************
     * The private constructor defining the only instance of the game class.
     * Because it is private, it has to be defined despite its body is empty.
     */
    private RobotGame()
    {
        super(
            "Grrrr cr... ˇ47ůl§}@{ ííííí Zničit Lidstvo !!!! Zničit Lidstvo\n" +
            "--------------------------------------------------------------\n" +
            "Probouzíte se jako malý robot na hraní v pokoji malé holčičky.\n" +
            "Byl jste vytvořen, za účelem bavit děti. Vlivem špatně        \n" +
            "odvedené práce a nekvalitního software se však ve vašem       \n" +
            "operačním systému něco vzrtlo a vaším nynějším posláním není  \n" +
            "nic menšího, než vyhladit celé lidstvo. I přes tuto nešťastnou\n" +
            "událost máte veliké štěstí. Tatínek holčičky pracuje jako     \n" +
            "technik v nedalekém muničním skladu jaderných zbraní.       \n\n" +
            "Hodně štěstí :)         GRRRRRR GRRR RRR ZNIČIT LIDSTVO !!!!!!\n" +
            "--------------------------------------------------------------\n"
        );
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    /***************************************************************************
     * Returns information if the game is currently running.
     * The once started game cannot be started again.
     * If you want to start the game again you have to finish it firstly.
     *
     * @return If the game is running, it returns {@code true},
     *         otherwise it returns {@code false}
     */
    @Override
    public boolean isAlive()
    {
        return AAction.isAlive;
    }


    /***************************************************************************
     * Returns the bag to which the player will save the taken items.
     *
     * @return The bag to which the player saves the taken items
     */
    @Override
    public Bag getBag()
    {
        return Bag.getInstance();
    }


    /***************************************************************************
     * Returns the collection of all actions usable in the game.
     *
     * @return The collection of all actions usable in the game
     */
    @Override
    public Collection<AAction> getAllActions()
    {
        return AAction.getAllActions();
    }


    /***************************************************************************
     * Returns the crate with names of mandatory actions, i.e. actions for
     * <ul>
     *   <li>moving into another space,</li>
     *   <li>taking item from the space and putting it into the bag,</li>
     *   <li>taking item from the bag and putting it down
     *       in the current space,</li>
     *   <li>asking for help,</li>
     *   <li>immediate game termination.</li>
     * </ul>
     *
     * @return The crate with names of mandatory actions
     */
    @Override
    public BasicActions getBasicActions()
    {
        return new BasicActions(pJDI, pSEBER, pPOLOZ, pHELP, pKONEC);
    }


    /***************************************************************************
     * Returns the world in which the game takes place.
     *
     * @return The world in which the game takes place
     */
    @Override
    public World getWorld()
    {
        return World.getInstance();
    }



//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /***************************************************************************
     * Processes the given command and returns the answer to the user.
     *
     * @param command The entered command
     * @return The answer of the game after processing the command
     */
    @Override
    public String executeCommand(String command)
    {
        return AAction.executeAction(command);
    }


    /***************************************************************************
     * Ends the whole game and returns the allocated resources.
     */
    @Override
    public void stop()
    {
        AAction.stopGame();
    }



//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
