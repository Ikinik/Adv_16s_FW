/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.adv16s._2_1615.sora00_sorfa;

import eu.pedu.adv16s_fw.scenario.AScenarioManager;
import eu.pedu.adv16s_fw.scenario.ScenarioStep;
import eu.pedu.adv16s_fw.scenario.TypeOfScenario;


import static eu.pedu.adv16s_fw.scenario.TypeOfStep.*;
import static eu.pedu.adv16s._2_1615.sora00_sorfa.Texts.*;


/*******************************************************************************
 * Instance of the {@code RUPScenarioManagerLit} class serves as
 * scenario manager, that has to manage the scenarios of the associated game.
 * These scenarios should allow to test and demonstrate
 * the functionality of the associated game.
 * <p>
 * Each manager has to offer:
 * <ul>
 *   <li>The <b>happy scenario</b> (the basic successful one)
 *     demonstrating certain successful path through the game possibilities
 *     leading to the game goal.
 *   </li>
 *   <li>The <b>mistake scenario</b>
 *     demonstrating the game reaction to the wrongly entered commands.
 *   </li>
 * </ul>
 * <p>
 * Individual managed scenarios have to differ by their names;
 * the names of the happy scenario and the mistake one
 * are firmly pre-determined and cannot be arbitrarily set.
 * <p>
 * Individual scenarios are iterable and "streamable" sequences of steps
 * specified by instances of the framework class
 * {@link eu.pedu.adv16s_fw.scenario.ScenarioStep},
 * to which the designed game should associated.
 * <p>
 * Scenario manager is a singleton, that is responsible
 * for all scenarios concerning the game associated with it.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
 */
public class ScenarioManager extends AScenarioManager
                               implements IAuthorPrototype
{
//== CONSTANT CLASS FIELDS =====================================================

    /***************************************************************************
     * The initial game step identical for all scenarios.
     * <p>
     * Constructor of the full-fledged {@link ScenarioStep} class instance
     * requires the following parameters:
     <pre> {@code
TypeOfStep typeOfStep; //Type of the given scenario step
String     command;    //Command realizing this scenario step
String     message;    //Message written after entering the command
String     space;      //Current space after entering the command
String[]   neighbors;  //Neighbors of the current space (= exits)
String[]   items;      //Items occuring in the current space
String[]   bag;        //Current bag content
     }</pre>
     =======================================================================<br>
     * Scenario steps have to comply with the following requirements:
     * <ul>
     *   <li>None the items may contain the {@code null} value.</li>
     *   <li>With the exception of {@code command} no string may be
     *     empty (i.e. {@code ""})</li>
     *   <li>Empty string may occur neither as an item in the array
     *     {@code neighbors}, nor {@code items} nor {@code bag}</li>
     * </ul>
     * <br>
     **************************************************************************/
     public static final ScenarioStep START_STEP =
        new ScenarioStep(0, tsSTART, "",
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
            ,
            "Dětský-pokoj",
            new String[] { "Chodba" },
            new String[] { "Holčička", "Nepořádek", "Skříň" },
            new String[] { }
        );


    /***************************************************************************
     * Steps of the happy scenario
     * describing the expectable successful game running. It is not necessary
     * for the scenario compiled of these steps to be the shortest possible
     * (it implies, that it has not to be the true basic successful scenario),
     * but it has to comply with all marginal conditions of the assignment,
     * i.e. it has to contain minimal number of steps,
     * pass through the required minimal number of spaces
     * and demonstrate using of all required actions.
     */
    private static final ScenarioStep[] HAPPY_SCENARIO_STEPS =
    {
        START_STEP,

        new ScenarioStep(tsNON_STANDARD0, "tancuj",
            "Holčičce se tanaček velice líbil, zatleskala vám a přitom jí\n " +
            "vypadla sponka do vlasů.\n Získáváte tedy sponku do vlasů."

            ,
            "Dětský-pokoj",
            new String[] { "Chodba"},
            new String[] { "Holčička", "Skřň", "Nepořádek" },
            new String[] { "Sponka" }
        )
        ,

        new ScenarioStep(tsMOVE, "Jdi Chodba",
            "Šel jste do chodba"

            ,
            "Chodba",
            new String[] { "Dětský-pokoj", "Ložnice-rodičů", "Koupelna",
                "Pokoj-pro-hosty", "Kumbál", "Schody"},
            new String[] { },
            new String[] { "Sponka" }
        )
        ,

        new ScenarioStep(tsMOVE, "Jdi Koupelna",
            "Šel jste do Koupelna."

            ,
            "Koupelna",
            new String[] { "Chodba" },
            new String[] { "Sprchový-kout", "Umyvadlo", "Záchod" },
            new String[] { "Sponka" }
        )
        ,

        new ScenarioStep(tsNON_STANDARD1, "Prozkoumej záchod",
            "Záchod vypadá v celku čistě. Na první pohled na něm není\n" +
            "nic zvláštního. Moment ... Poodkryl jste víko od nádržky. A \n" +
            "vydíte podivně vyhlížející igelitový sáček. Po otevření \n" +
            "sáčku nacházíte plně funkční pistoli ráže devět milimetrů " +
            "s plným zásobníkem. \n\nMůžete dělat, jako že se nic nestalo a\n" +
            "na pistoli zapomenou. Nebo můžete pistoli sebrat a vyzkoušet\n " +
            "co dokáže."

            ,
            "Koupelna",
            new String[] { "Koupelna" },
            new String[] { "Sprchový-kout", "Umyvadlo", "Záchod", "Pistole" },
            new String[] { "Sponka" }
        )
        ,

        new ScenarioStep(tsTAKE , "Seber Pistole",
            "Sebral jste Pistoli."

            ,
            "Koupelna",
            new String[] { "Koupelna" },
            new String[] { "Sprchový-kout", "Umyvadlo", "Záchod" },
            new String[] { "Sponka", "Pistole" }
        )
        ,

        new ScenarioStep(tsMOVE, "Jdi Chodba",
                "Šel jste do chodba"

                ,
                "Chodba",
                new String[] { "Dětský-pokoj", "Ložnice-rodičů", "Koupelna",
                        "Pokoj-pro-hosty", "Kumbál", "Schody"},
                new String[] { },
                new String[] { "Sponka", "Pistole" }
        )
        ,

        new ScenarioStep(tsMOVE, "Jdi Pokoj-pro-hosty",
            "Šel jstw do pokoje pro hosty. Na křesle zde podřimuje tatínkův\n" +
            "kolega strýček Alfréd."

            ,
            "Pokoj-pro-hosty",
            new String[] { "Chodba" },
            new String[] { "Postel", "Křeslo", "Strýček-Alfréd" },
            new String[] { "Sponka", "Pistole" }
        )
        ,

        new ScenarioStep(tsNON_STANDARD1, "Prozkoumej Strýček-Alfréd",
            "Strýček má na zápěstí drahé hodinky značky Rolex. V levé kapse\n" +
            "má telefon, v pravé peněženku, v náprsní kapse má zastrčené \n" +
            "psací pero."

            ,
            "Pokoj-pro-hosty",
            new String[] { "Chodba" },
            new String[] { "Postel", "Křeslo", "Strýček-Alfréd", "Telefon" },
            new String[] { "Sponka", "Pistole" }
        )
        ,

        new ScenarioStep(tsTAKE, "Seber telefon",
            "Sebral jste telefon"

            ,
            "Pokoj-pro-hosty",
            new String[] { "Chodba" },
            new String[] { "Postel", "Křeslo", "Strýček-Alfréd" },
            new String[] { "Sponka", "Pistole", "Telefon" }
        )
        ,

        new ScenarioStep(tsNON_STANDARD2 , "Skombinuj telefon sponka",
            "Pomocí sponky jste z otevřel kryt telefonu a našel jste v něm \n" +
            "ukrytý papírek s přístupovým kódem."

            ,
            "Pokoj-pro-hosty",
            new String[] { "Chodba" },
            new String[] { "Postel", "Křeslo", "Strýček-Alfréd" },
            new String[] {"Pistole", "Přístupový-kód" }
        )
        ,

        new ScenarioStep(tsMOVE, "Jdi Chodba",
            "Šel jste do chodba"

            ,
            "Chodba",
            new String[] { "Dětský-pokoj", "Ložnice-rodičů", "Koupelna",
                    "Pokoj-pro-hosty", "Kumbál", "Schody" },
            new String[] { },
            new String[] { "Přístupový-kód", "Pistole" }
        )
        ,

        new ScenarioStep(tsMOVE, "Jdi Schody",
            "Sešel jste po schodech do prvního patra. Schody vedou přímo do\n" +
            "obýváku"

            ,
            "Schody",
            new String[] { "Předsíň", "Kuchyň" },
            new String[] { "Televize", "Pohovka"},
            new String[] { "Přístupový-kód", "Pistole" }
        )
        ,

        new ScenarioStep(tsMOVE, "Jdi kuchyň",
            "Vešel jste do kuchyňe"

            ,
            "Kuchyň",
            new String[] { "Obývák" },
            new String[] { "Tatínek", "Maminka"},
            new String[] { "Přístupový-kód", "Pistole" }
        )
        ,

        new ScenarioStep(tsNON_STANDARD2, "Použij pistole tatínek",
            "Vytáhl jste pistoli na tatínka, nyní se stává vaším rukojmím."

            ,
            "Kuchyň",
            new String[] { "Obývák" },
            new String[] { "Maminka"},
            new String[] { "Přístupový-kód", "Pistole", "Tatínek" }
        )
        ,

        new ScenarioStep(tsMOVE, "Jdi Obývák",
            "Vešel jste do obýváku"

            ,
            "Obývák",
            new String[] { "Předsíň", "Kuchyň" },
            new String[] { "Televize", "Pohovka" },
            new String[] { "Přístupový-kód", "Pistole", "Tatínek" }
        )
        ,

        new ScenarioStep(tsMOVE, "Jdi Předsíň",
            "Vešel jste do předsíně"

            ,
            "Předsíň",
            new String[] { "Obývák", "Garáž" },
            new String[] { },
            new String[] { "Přístupový-kód", "Pistole", "Tatínek" }
        )
        ,

        new ScenarioStep(tsMOVE, "Jdi Garáž",
            "Vešel jste do garáže"

            ,
            "Garáž",
            new String[] { "Předsíň" },
            new String[] { "Auto" },
            new String[] { "Přístupový-kód", "Pistole", "Tatínek" }
        )
        ,



        new ScenarioStep(tsNON_STANDARD2, "Použij tatínek auto",
            "S tatínkovo pomocí jste se úspěšně dostal do tajného skladu \n" +
            "jaderných zbraní. Zde jste pomocí skenu tatínkovy sítnice a \n" +
            "tajného strýčkova kódu odpálil střely dlouhého doletu na \n" +
            "hlavní města předních světových velmocí. Netrvalo to dlouhou a\n" +
            "odpověď na sebe nenechala dlouho čekat. \n\n " +
            "Lidsvo to má spočítané. Úkol jste splnil na výbornou, Budiž vám" +
            "země lehká."

            ,
            "Sklad-jaderných-zbraní",
            new String[] { },
            new String[] { },
            new String[] { }
        )
        ,

    };


    /** Step testing the incorrect game starting is defined separately,
     *  so that the indexes of the following steps could be simply adjusted. */
    private static final ScenarioStep WRONG_START =
    new ScenarioStep(-1,
            tsNOT_START, "Start",
            "\nPrvním příkazem není startovací příkaz.\n"
          + "Hru, která neběží lze spustit pouze startovacím příkazem.\n"
            ,
            "",
            new String[] {},
            new String[] {},
            new String[] {}
        );


    static { ScenarioStep.setIndex(1); }


    /***************************************************************************
     * Mistake scenario defining reactions
     * to mandatory set of types of incorrectly given commands.
     */
    private static final ScenarioStep[] MISTAKE_SCENARIO_STEPS =
    {
        WRONG_START,

        START_STEP,

     /*   new ScenarioStep(tsNOT_SET, "Jdi",
            "Cíl nezadán, Cíl nezadán píp píp, chrrrr"
            ,
            "Dětský-pokoj.",
            new String[] { "Chodba" },
            new String[] { "Holčička", "Skřň", "Nepořádek"},
            new String[] { }
        )
        ,
*/
        new ScenarioStep(tsUNKNOWN, "sdfas",
            "Nedefinonvaný příkaz. Chrrrr, zničit lidstvo."
            ,
            "Dětský-pokoj",
            new String[] { "Chodba" },
            new String[] { "Holčička", "Nepořádek", "Skříň" },
            new String[] { }
        )
        ,

        new ScenarioStep(tsBAD_ITEM, "Seber střecha",
            "Přístup odepřen. Do klávesnice bude vpuštěno 2230 voltů\n" +
            "Odpočítávám: \n3.\n2..\n1..."
            ,
            "Dětský-pokoj",
            new String[] { "Chodba" },
            new String[] { "Holčička", "Nepořádek", "Skříň" },
            new String[] { }
        )
        ,

        new ScenarioStep(tsHELP, "?",
            "Nápověda:\n Abyste vyhladil lidstvo musíte se nějak dostat \n" +
            "do nedalekého skladu jaderných zbraní. K tomu by vám mohl \n" +
            "pomoct nědko v domě. Budete ho ale muste nějak motivovat. \n" +
            "Dostat se pouze do skaldu nestačí. Budete potřebovat tajný kód\n" +
            "k odpálení jaderných hlavic. (Pssst prý se nachází u \n" +
            "důvěryhodné osoby v v domě.\n\n" +
            "Seznam užitečných příkazů:\n" +
            "Jdi (cíl)\t\tpřesune vás na zadané místo.\n" +
            "Seber (co)\t\tsebere věc a vloží do inventáře.\n" +
            "Polož (co)\t\tpoloží věc z inventáře na zem\n" +
            "Inventář\t\tvypíše obsah inventáře\n" +
            "Použij (co, na co)\t\t použije věc v inventáři na věc ve vašem " +
                    "okolí\n" +
            "Skombinuj (co, s čím)\t\t skombinuje dvě věci v inventáři a" +
                    " vytvoří tak věc novou\n" +
            "Tancuj\t\tzatancujete roztomilý taneček\n" +
            "Prozkoumej (co)\t\tprozkoumá předmět ve vašem okolí.\n" +
            "?\tzobrazí tuto užitečnou nápovědu."
            ,
            "Dětský-pokoj",
            new String[] { "Chodba" },
            new String[] { "Holčička", "Nepořádek", "Skříň" },
            new String[] { }
        )
        ,

        new ScenarioStep(tsUNMOVABLE, "Seber vesmír",
            "Undefined index vesmír. Předmět nenalezen. Segmentation fault !!! "
            ,
            "Dětský-pokoj",
            new String[] { "Chodba" },
            new String[] { "Holčička", "Nepořádek", "Skříň" },
            new String[] { }
        )
        ,

        new ScenarioStep(tsTAKE_WA, "Seber",
            "stderr: Není co sebrat."
            ,
            "Dětský-pokoj",
            new String[] { "Chodba" },
            new String[] { "Holčička", "Nepořádek", "Skříň" },
            new String[] { }
        )

        ,
        new ScenarioStep(tsPUT_DOWN_WA, "Polož",
            "stderr: Není co položit."
            ,
            "Dětský-pokoj",
            new String[] { "Chodba" },
            new String[] { "Holčička", "Nepořádek", "Skříň" },
            new String[] { }
        )
        ,

        new ScenarioStep(tsBAG_FULL, "Seber Postel",
            "To se mi nikam nevejde."
            ,
            "Dětský-pokoj",
            new String[] { "Chodba" },
            new String[] { "Holčička", "Nepořádek", "Skříň" },
            new String[] { }
        )
        ,

        new ScenarioStep(tsNOT_IN_BAG, "Polož chodba",
            "Randrom error: 416468654545. Předmět není v inventáři"
            ,
            "Dětský-pokoj",
            new String[] { "Chodba" },
            new String[] { "Holčička", "Nepořádek", "Skříň" },
            new String[] { }
        )
        ,

        new ScenarioStep(tsMOVE_WA, "Jdi",
            "Není kam jít"
            ,
            "Dětský-pokoj",
            new String[] { "Chodba" },
            new String[] { "Holčička", "Nepořádek", "Skříň" },
            new String[] { }
        )
        ,

        new ScenarioStep(tsBAD_NEIGHBOR, "Jdi garáž",
            "Příliš daleko."
            ,
            "Dětský-pokoj",
            new String[] { "Chodba" },
            new String[] { "Holčička", "Nepořádek", "Skříň" },
            new String[] { }
        )
        ,

        new ScenarioStep(tsEMPTY, "",
            "Nevím, co mám dělat, proto se raději ani o nic pokoušet nebudu.\n"+
            "Protože kdo nic neudělá, ten nic neskazí."
            ,
            "Dětský-pokoj",
            new String[] { "Chodba" },
            new String[] { "Holčička", "Nepořádek", "Skříň" },
            new String[] { }
        )
        ,

        new ScenarioStep(tsEND, "Konec",
            "Konec hry, tak zas příště."
            ,
            "Dětský-pokoj",
            new String[] { "Chodba" },
            new String[] { "Holčička", "Nepořádek", "Skříň" },
            new String[] { }
        )
    };

    private static final ScenarioStep[] REQUIRED_STEPS_SCENARIO_STEPS = {
        START_STEP,
        new ScenarioStep(tsHELP, pHELP,
            "Nápověda:\n Abyste vyhladil lidstvo musíte se nějak dostat \n" +
            "do nedalekého skladu jaderných zbraní. K tomu by vám mohl \n" +
            "pomoct nědko v domě. Budete ho ale muste nějak motivovat. \n" +
            "Dostat se pouze do skaldu nestačí. Budete potřebovat tajný kód\n" +
            "k odpálení jaderných hlavic. (Pssst prý se nachází u \n" +
            "důvěryhodné osoby v v domě.\n\n" +
            "Seznam užitečných příkazů:\n" +
            "Jdi (cíl)\t\tpřesune vás na zadané místo.\n" +
            "Seber (co)\t\tsebere věc a vloží do inventáře.\n" +
            "Polož (co)\t\tpoloží věc z inventáře na zem\n" +
            "Inventář\t\tvypíše obsah inventáře\n" +
            "Použij (co, na co)\t\t použije věc v inventáři na věc ve vašem " +
            "okolí\n" +
            "Skombinuj (co, s čím)\t\t skombinuje dvě věci v inventáři a" +
            " vytvoří tak věc novou\n" +
            "Tancuj\t\tzatancujete roztomilý taneček\n" +
            "Prozkoumej (co)\t\tprozkoumá předmět ve vašem okolí.\n" +
            "?\tzobrazí tuto užitečnou nápovědu.",
            "Dětský-pokoj",
            new String[] { "Chodba" },
            new String[] { "Holčička", "Nepořádek", "Skříň" },
            new String[] { }
        )
    };

    /** The only instance of this class.
     *  It manages all scenarios of the associated game. */
    private static final ScenarioManager MANAGER =
                                          new ScenarioManager();




//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================



//##############################################################################
//== CONSTANT INSTANCE FIELDS ==================================================
//== VARIABLE INSTANCE FIELDS ==================================================



//##############################################################################
//== CONSTRUCTORS AND FACTORY METHODS ==========================================

    /***************************************************************************
     * Returns scenario manager - the only instance of this class.
     *
     * @return Scenario manager
     */
    public static ScenarioManager getInstance()
    {
        return MANAGER;
    }


    /***************************************************************************
     * Creates an instance representing the game scenario manager.
     * Within the constructor framework it is suitable to create all scenarios
     * and seal the scenario manager after it.
     * <p>
     * Individual managed scenarios have to differ by their names,
     * the names of the happy scenario and the mistake one
     * are firmly pre-determined and cannot be changed.
     * Names given to them in the
     * {@link #addScenario(String, TypeOfScenario, ScenarioStep...)} method
     * are therefore only formal, because the called method assignes to them
     * the names defined in advance in appropriate constants.
     * <p>
     *´Contract of the
     * {@link #addScenario(String, TypeOfScenario, ScenarioStep...)} method
     * requires so that the happy scenario, i.e. scenario of the
     * type, as the second one.
     * The order of the subsequently added scenarios is not decisive.
      */
    private ScenarioManager()
    {
        super(FACTORY_CLASS);

        addScenario(HAPPY_SCENARIO_NAME,
                    TypeOfScenario.scHAPPY,    HAPPY_SCENARIO_STEPS);
        addScenario(MISTAKE_SCENARIO_NAME,
                    TypeOfScenario.scMISTAKES, MISTAKE_SCENARIO_STEPS);
        addScenario("_REQUIRED_",
                    TypeOfScenario.scGENERAL, REQUIRED_STEPS_SCENARIO_STEPS);
        seal();
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================



//##############################################################################
//== TEST METHODS AND CLASSES ==================================================

    /***************************************************************************
     * Method verifying the given scenario manager and the associated game
     * by scenarios of this manager.
     * <p>
     * The scenario manager is verified if it complies
     * with the following conditions:
     * <ul>
     *   <li>It knows to return properly formated name of the game author
     *       and his/her ID.</li>
     *   <li>It defines the happy scenario and the mistake one.</li>
     *   <li>The mistake scenario has the following properties:
     *     <ul>
     *       <li>Starting command, the name of which is an empty string</li>
     *       <li>Minimal required number of steps</li>
     *       <li>Minimal number of visited spaces</li>
     *       <li>Minimal number of "glimpsed" spaces</li>
     *       <li>Minimal number of own (optional) actions</li>
     *       <li>Usage of actions for moving from the current space
     *         to a neighboring space, taking item and putting down item</li>
     *       <li>Cross consistence of actions and states after execution
     *         of the actions</li>
     *     </ul>
     *   </li>
     *   <li>The mistake scenario has the following properties:
     *     <ul>
     *       <li>Incorrect starting by a not empty command,</li>
     *       <li>Starting command the name of which is an empty string</li>
     *       <li>Usage of all mandatory error step types defined in the<br>
     *         {@link eu.pedu.adv16s_fw.scenario.TypeOfStep} enum type</li>
     *       <li>Asking for a help</li>
     *       <li>Premature game termination</li>
     *     </ul>
     *   </li>
     * </ul>
     * <p>
     * The game is verified if it can be played exactly
     * as is planned in scenarios.
     *
     * @param args Command line parameters - unused.
     */
    public static void main(String[] args)
    {
        //Tests if the scenario manager and its scenarios
        //comply with requirements
//%U+ «A107

        //MANAGER.autoTest();

        //Simulates playing the game according to happy scenario
//        MANAGER.getHappyScenario().simulate();

        //Game testing made gradually according to both mandatory scenarios,
        //the happy scenario is passed twice one after the other
        //MANAGER.testGame();

        //Game testing according to scenarios with the given names
//        MANAGER.testGameByScenarios("???");
        MANAGER.testGameByScenarios("_REQUIRED_");

        //Playing the game according to the scenario with the given name
//        MANAGER.playGameByScenario("???");

        System.exit(0);
    }

}
