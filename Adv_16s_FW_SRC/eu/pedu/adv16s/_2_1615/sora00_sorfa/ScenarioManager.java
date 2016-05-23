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

        new ScenarioStep(tsNON_STANDARD0, pTANCUJ,
            zTANCUJ_HOLCICKA
            ,
            DETSKY_POKOJ,
            new String[] { CHODBA },
            new String[] { HOLCICKA, NEPORADEK, SKRIN },
            new String[] { SPONKA }
        ),

        new ScenarioStep(tsMOVE, pJDI +" "+CHODBA,
                zPRESUN + CHODBA + "\n" + wCHODBA
                ,
                CHODBA,
                new String[] { DETSKY_POKOJ, LOZNICE_RODICU,
                        KOUPELNA, POKOJ_PRO_HOSTY, KUMBAL, SCHODY },
                new String[] { OBRAZ },
                new String[] { SPONKA }
        ),

        new ScenarioStep(tsMOVE, pJDI +" "+ KOUPELNA,
            zPRESUN + KOUPELNA + "\n" + wKOUPELNA
            ,
            KOUPELNA,
            new String[] { CHODBA },
            new String[] { SPRCHOVY_KOUT, UMYVADLO, ZACHOD },
            new String[] { SPONKA }
        ),

        new ScenarioStep(tsNON_STANDARD1, pPROZKOUMEJ +" "+ ZACHOD,
            zPROZKOUMEJ_ZACHOD
            ,
            KOUPELNA,
            new String[] { CHODBA },
            new String[] { SPRCHOVY_KOUT, UMYVADLO, ZACHOD, PISTOLE },
            new String[] { SPONKA }
        ),

        new ScenarioStep(tsTAKE, pSEBER + " " + PISTOLE,
            zZVEDNUTO + PISTOLE
            ,
            KOUPELNA,
            new String[] { CHODBA },
            new String[] { SPRCHOVY_KOUT, UMYVADLO, ZACHOD },
            new String[] { PISTOLE, SPONKA }
        ),

        new ScenarioStep(tsMOVE, pJDI +" "+ CHODBA,
            zPRESUN + CHODBA +"\n"+ zPRESUN_POPIS_ITEMU + OBRAZ
            ,
            CHODBA,
            new String[] { DETSKY_POKOJ, LOZNICE_RODICU,
                    KOUPELNA, POKOJ_PRO_HOSTY, KUMBAL, SCHODY },
            new String[] { OBRAZ },
            new String[] { PISTOLE, SPONKA }
        ),

        new ScenarioStep(tsMOVE, pJDI + " " + POKOJ_PRO_HOSTY,
            zPRESUN + POKOJ_PRO_HOSTY +"\n"+ wPOKOJ_PRO_HOSTY
            ,
            POKOJ_PRO_HOSTY,
            new String[] { CHODBA },
            new String[] { POSTEL, KRESLO, STRYCEK_ALFRED },
            new String[] { PISTOLE, SPONKA }
        ),

        new ScenarioStep(tsNON_STANDARD1, pPROZKOUMEJ + " " + STRYCEK_ALFRED,
            zPROZKOUMEJ_STRYCEK_ALFRED
            ,
            POKOJ_PRO_HOSTY,
            new String[] { CHODBA },
            new String[] { POSTEL, KRESLO, STRYCEK_ALFRED, ROLEXKY, TELEFON,
                    PENEZENKA, PSACI_PERO },
            new String[] { PISTOLE, SPONKA }
        ),

        new ScenarioStep(tsTAKE, pSEBER + " " + TELEFON,
            zZVEDNUTO + TELEFON
            ,
            POKOJ_PRO_HOSTY,
            new String[] { CHODBA },
            new String[] { POSTEL, KRESLO, STRYCEK_ALFRED, ROLEXKY,
                    PENEZENKA, PSACI_PERO },
            new String[] { PISTOLE, TELEFON, SPONKA }
        ),

        new ScenarioStep(tsNON_STANDARD2, pSKOMBINUJ +" "+ SPONKA +" "+ TELEFON,
            zSKOMBINUJ_SPONKA_TELEFON
            ,
            POKOJ_PRO_HOSTY,
            new String[] { CHODBA },
            new String[] { POSTEL, KRESLO, STRYCEK_ALFRED, ROLEXKY,
                    PENEZENKA, PSACI_PERO },
            new String[] { PISTOLE, PRISTUPOVY_KOD }
        ),

        new ScenarioStep(tsMOVE, pJDI +" "+ CHODBA,
            zPRESUN + CHODBA +"\n"+ zPRESUN_POPIS_ITEMU + OBRAZ
            ,
            CHODBA,
            new String[] { DETSKY_POKOJ, LOZNICE_RODICU,
                    KOUPELNA, POKOJ_PRO_HOSTY, KUMBAL, SCHODY },
            new String[] { OBRAZ },
            new String[] { PISTOLE, PRISTUPOVY_KOD }
        ),

        new ScenarioStep(tsMOVE, pJDI +" "+ SCHODY,
            zPRESUN + SCHODY +"\n"+ wSCHODY
            ,
            SCHODY,
            new String[] { CHODBA, OBYVAK },
            new String[] { FOTKY, ZABRADLI },
            new String[] { PISTOLE, PRISTUPOVY_KOD }
        ),

        new ScenarioStep(tsMOVE, pJDI +" "+ OBYVAK,
            zPRESUN + OBYVAK +"\n"+ wOBYVAK
            ,
            OBYVAK,
            new String[] { SCHODY, PREDSIN, KUCHYN },
            new String[] { POHOVKA, TELEVIZE, MINIBAR },
            new String[] { PISTOLE, PRISTUPOVY_KOD }
        ),

        new ScenarioStep(tsMOVE, pJDI +" "+ KUCHYN,
            zPRESUN + KUCHYN +"\n"+ wKUCHYN
            ,
            KUCHYN,
            new String[] { OBYVAK },
            new String[] { TATINEK, MAMINKA },
            new String[] { PISTOLE, PRISTUPOVY_KOD}
        ),

        new ScenarioStep(tsNON_STANDARD2, pPOUZIJ +" "+ PISTOLE +" "+TATINEK,
            zPOUZIJ_PISTOLE_TATINEK
            ,
            KUCHYN,
            new String[] { OBYVAK },
            new String[] { MAMINKA },
            new String[] { PISTOLE, PRISTUPOVY_KOD, TATINEK }
        ),

        new ScenarioStep(tsMOVE, pJDI +" "+ OBYVAK,
            zPRESUN + OBYVAK +"\n"+ zPRESUN_POPIS_ITEMU + TELEVIZE +" "+
                    POHOVKA +" "+ MINIBAR
            ,
            OBYVAK,
            new String[] { SCHODY, PREDSIN, KUCHYN },
            new String[] { TELEVIZE, POHOVKA, MINIBAR },
            new String[] { PISTOLE, PRISTUPOVY_KOD, TATINEK }
        ),

        new ScenarioStep(tsMOVE, pJDI +" "+ PREDSIN,
            zPRESUN + PREDSIN +"\n"+ wPREDSIN
            ,
            PREDSIN,
            new String[] { OBYVAK, GARAZ },
            new String[] { VESAK, BOTNIK, ROHOZKA },
            new String[] { PISTOLE, PRISTUPOVY_KOD, TATINEK }
        ),

        new ScenarioStep(tsMOVE, pJDI + " "+GARAZ,
            zPRESUN + GARAZ +"\n"+ wGARAZ
            ,
            GARAZ,
            new String[] { PREDSIN },
            new String[] { AUTO },
            new String[] { PISTOLE, PRISTUPOVY_KOD, TATINEK }
        ),

        new ScenarioStep(tsNON_STANDARD2, pPOUZIJ +" "+ TATINEK +" "+ AUTO,
                zSUCCESS_END
                ,
                SKLAD_JADERNYCH_ZBRANI,
                new String[] { },
                new String[] { },
                new String[] { PISTOLE, PRISTUPOVY_KOD, TATINEK }
        )
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

        new ScenarioStep(tsUNKNOWN, "sdfas",
            zNEZNAMY_PRIKAZ
            ,
            DETSKY_POKOJ,
            new String[] { CHODBA },
            new String[] { HOLCICKA , NEPORADEK, SKRIN },
            new String[] { }
        )
        ,

        new ScenarioStep(tsBAD_ITEM, pSEBER + " Střecha",
            zNENI_ITEM
            ,
            DETSKY_POKOJ,
            new String[] { CHODBA },
            new String[] { HOLCICKA, NEPORADEK, SKRIN },
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
            DETSKY_POKOJ,
            new String[] { CHODBA },
            new String[] { HOLCICKA, NEPORADEK, SKRIN },
            new String[] { }
        )
        ,

        new ScenarioStep(tsUNMOVABLE, pSEBER + " vesmír",
            zNENI_ITEM
            ,
            DETSKY_POKOJ,
            new String[] { CHODBA },
            new String[] { HOLCICKA, NEPORADEK, SKRIN },
            new String[] { }
        )
        ,

        new ScenarioStep(tsTAKE_WA, "Seber",
            zPREDMET_NEZADAN
            ,
            DETSKY_POKOJ,
            new String[] { CHODBA },
            new String[] { HOLCICKA, NEPORADEK, SKRIN },
            new String[] { }
        )

        ,
        new ScenarioStep(tsPUT_DOWN_WA, "Polož",
            zNENI_V_BATOHU
            ,
            DETSKY_POKOJ,
            new String[] { CHODBA },
            new String[] { HOLCICKA, NEPORADEK, SKRIN },
            new String[] { }
        )
        ,

        new ScenarioStep(tsBAG_FULL, pSEBER + " Postel",
            zNENI_ITEM
            ,
            DETSKY_POKOJ,
            new String[] { CHODBA },
            new String[] { HOLCICKA, NEPORADEK, SKRIN },
            new String[] { }
        )
        ,

        new ScenarioStep(tsNOT_IN_BAG, pPOLOZ + " chodba",
            zNENI_V_BATOHU
            ,
            DETSKY_POKOJ,
            new String[] { CHODBA },
            new String[] { HOLCICKA, NEPORADEK, SKRIN },
            new String[] { }
        )
        ,

        new ScenarioStep(tsMOVE_WA, "Jdi",
            zCIL_NEZADAN
            ,
            DETSKY_POKOJ,
            new String[] { CHODBA },
            new String[] { HOLCICKA, NEPORADEK, SKRIN },
            new String[] { }
        )
        ,

        new ScenarioStep(tsBAD_NEIGHBOR, pJDI + " garáž",
            zNENI_CIL
            ,
            DETSKY_POKOJ,
            new String[] { CHODBA },
            new String[] { HOLCICKA, NEPORADEK, SKRIN },
            new String[] { }
        )
        ,

        new ScenarioStep(tsEMPTY, "",
            zPRAZDY_PRIKAZ
            ,
            DETSKY_POKOJ,
            new String[] { CHODBA },
            new String[] { HOLCICKA, NEPORADEK, SKRIN },
            new String[] { }
        )
        ,

        new ScenarioStep(tsEND, pKONEC,
            zKONEC
            ,
            DETSKY_POKOJ,
            new String[] { CHODBA },
            new String[] { HOLCICKA, NEPORADEK, SKRIN },
            new String[] { }
        )
    };

    static { ScenarioStep.setIndex(1); }

    private static final ScenarioStep[] REQUIRED_STEPS_SCENARIO_STEPS = {
        START_STEP,

        new ScenarioStep(tsNON_STANDARD0, pTANCUJ,
            zTANCUJ_HOLCICKA
            ,
            DETSKY_POKOJ,
            new String[] { CHODBA },
            new String[] { HOLCICKA, NEPORADEK, SKRIN },
            new String[] { SPONKA }
        ),

        new ScenarioStep(tsMOVE, pJDI +" "+CHODBA,
                zPRESUN + CHODBA + "\n" + wCHODBA
            ,
            CHODBA,
            new String[] { DETSKY_POKOJ, LOZNICE_RODICU,
                    KOUPELNA, POKOJ_PRO_HOSTY, KUMBAL, SCHODY },
            new String[] { OBRAZ },
            new String[] { SPONKA }
        ),

        new ScenarioStep(tsMOVE, pJDI + " "+DETSKY_POKOJ,
                zPRESUN + DETSKY_POKOJ + "\n" + zPRESUN_POPIS_ITEMU +
                HOLCICKA +" "+ SKRIN +" "+ NEPORADEK
            ,
            DETSKY_POKOJ,
            new String[] { CHODBA },
            new String[] { HOLCICKA, NEPORADEK, SKRIN },
            new String[] { SPONKA }
        ),

        new ScenarioStep(tsNON_STANDARD0, pROZHLED,
            "V aktuálním prostoru: " +DETSKY_POKOJ+ " se\n" +
            "nachází: " + HOLCICKA +" "+ SKRIN +" "+ NEPORADEK +"\n\n" +
            "Odsud je dále možné jít: " + CHODBA
            ,
            DETSKY_POKOJ,
            new String[] { CHODBA },
            new String[] { HOLCICKA, NEPORADEK, SKRIN },
            new String[] { SPONKA }
        ),

        new ScenarioStep(tsMOVE, pJDI +" "+ CHODBA,
            zPRESUN + CHODBA + "\n" + zPRESUN_POPIS_ITEMU + OBRAZ
            ,
            CHODBA,
            new String[] { DETSKY_POKOJ, LOZNICE_RODICU,
                    KOUPELNA, POKOJ_PRO_HOSTY, KUMBAL, SCHODY },
            new String[] { OBRAZ },
            new String[] { SPONKA }
        ),

        new ScenarioStep(tsMOVE, pJDI + " "+KOUPELNA,
            zPRESUN + KOUPELNA + "\n" + wKOUPELNA
            ,
            KOUPELNA,
            new String[] { CHODBA },
            new String[] { SPRCHOVY_KOUT, UMYVADLO, ZACHOD },
            new String[] { SPONKA }
        ),

        new ScenarioStep(tsNON_STANDARD1, pPROZKOUMEJ + " " + ZACHOD,
            zPROZKOUMEJ_ZACHOD
            ,
            KOUPELNA,
            new String[] { CHODBA },
            new String[] { SPRCHOVY_KOUT, UMYVADLO, ZACHOD, PISTOLE },
            new String[] { SPONKA }
        ),

        new ScenarioStep(tsTAKE, pSEBER + " " + PISTOLE,
            zZVEDNUTO + PISTOLE
            ,
            KOUPELNA,
            new String[] { CHODBA },
            new String[] { SPRCHOVY_KOUT, UMYVADLO, ZACHOD },
            new String[] { PISTOLE, SPONKA }
        ),

        new ScenarioStep(tsMOVE, pJDI + " "+CHODBA,
            zPRESUN + CHODBA +"\n"+ zPRESUN_POPIS_ITEMU + OBRAZ
            ,
            CHODBA,
            new String[] { DETSKY_POKOJ, LOZNICE_RODICU,
                    KOUPELNA, POKOJ_PRO_HOSTY, KUMBAL, SCHODY },
            new String[] { OBRAZ },
            new String[] { PISTOLE, SPONKA }
        ),

        new ScenarioStep(tsMOVE, pJDI + " " + POKOJ_PRO_HOSTY,
            zPRESUN + POKOJ_PRO_HOSTY +"\n"+ wPOKOJ_PRO_HOSTY
            ,
            POKOJ_PRO_HOSTY,
            new String[] { CHODBA },
            new String[] { POSTEL, KRESLO, STRYCEK_ALFRED },
            new String[] { PISTOLE, SPONKA }
        ),

        new ScenarioStep(tsNON_STANDARD1, pPROZKOUMEJ + " " + STRYCEK_ALFRED,
            zPROZKOUMEJ_STRYCEK_ALFRED
            ,
            POKOJ_PRO_HOSTY,
            new String[] { CHODBA },
            new String[] { POSTEL, KRESLO, STRYCEK_ALFRED, ROLEXKY, TELEFON,
                    PENEZENKA, PSACI_PERO },
            new String[] { PISTOLE, SPONKA }
        ),

        new ScenarioStep(tsTAKE, pSEBER + " " + TELEFON,
            zZVEDNUTO + TELEFON
            ,
            POKOJ_PRO_HOSTY,
            new String[] { CHODBA },
            new String[] { POSTEL, KRESLO, STRYCEK_ALFRED, ROLEXKY,
                    PENEZENKA, PSACI_PERO },
            new String[] { PISTOLE, TELEFON, SPONKA }
        ),

        new ScenarioStep(tsNON_STANDARD0, pTANCUJ,
            zTANCUJ_KDEKOLIV
            ,
            POKOJ_PRO_HOSTY,
            new String[] { CHODBA },
            new String[] { POSTEL, KRESLO, STRYCEK_ALFRED, ROLEXKY,
                    PENEZENKA, PSACI_PERO },
            new String[] { PISTOLE, TELEFON, SPONKA }
        ),

        new ScenarioStep(tsNON_STANDARD2, pSKOMBINUJ +" "+ SPONKA +" "+ TELEFON,
            zSKOMBINUJ_SPONKA_TELEFON
            ,
            POKOJ_PRO_HOSTY,
            new String[] { CHODBA },
            new String[] { POSTEL, KRESLO, STRYCEK_ALFRED, ROLEXKY,
                    PENEZENKA, PSACI_PERO },
            new String[] { PISTOLE, PRISTUPOVY_KOD }
        ),

        new ScenarioStep(tsMOVE, pJDI +" "+ CHODBA,
            zPRESUN + CHODBA +"\n"+ zPRESUN_POPIS_ITEMU + OBRAZ
            ,
            CHODBA,
            new String[] { DETSKY_POKOJ, LOZNICE_RODICU,
                    KOUPELNA, POKOJ_PRO_HOSTY, KUMBAL, SCHODY },
            new String[] { OBRAZ },
            new String[] { PISTOLE, PRISTUPOVY_KOD }
        ),

        new ScenarioStep(tsMOVE, pJDI +" "+ SCHODY,
            zPRESUN + SCHODY +"\n"+ wSCHODY
            ,
            SCHODY,
            new String[] { CHODBA, OBYVAK },
            new String[] { FOTKY, ZABRADLI },
            new String[] { PISTOLE, PRISTUPOVY_KOD }
        ),

        new ScenarioStep(tsMOVE, pJDI +" "+ OBYVAK,
            zPRESUN + OBYVAK +"\n"+ wOBYVAK
            ,
            OBYVAK,
            new String[] { SCHODY, PREDSIN, KUCHYN },
            new String[] { POHOVKA, TELEVIZE, MINIBAR },
            new String[] { PISTOLE, PRISTUPOVY_KOD }
        ),

        new ScenarioStep(tsMOVE, pJDI +" "+ KUCHYN,
            zPRESUN + KUCHYN +"\n"+ wKUCHYN
            ,
            KUCHYN,
            new String[] { OBYVAK },
            new String[] { TATINEK, MAMINKA },
            new String[] { PISTOLE, PRISTUPOVY_KOD}
        ),

        new ScenarioStep(tsNON_STANDARD2, pPOUZIJ +" "+ PISTOLE +" "+TATINEK,
            zPOUZIJ_PISTOLE_TATINEK
            ,
            KUCHYN,
            new String[] { OBYVAK },
            new String[] { MAMINKA },
            new String[] { PISTOLE, PRISTUPOVY_KOD, TATINEK }
        ),

        new ScenarioStep(tsMOVE, pJDI +" "+ OBYVAK,
            zPRESUN + OBYVAK +"\n"+ zPRESUN_POPIS_ITEMU + TELEVIZE +" "+
                    POHOVKA +" "+ MINIBAR
            ,
            OBYVAK,
            new String[] { SCHODY, PREDSIN, KUCHYN },
            new String[] { TELEVIZE, POHOVKA, MINIBAR },
            new String[] { PISTOLE, PRISTUPOVY_KOD, TATINEK }
        ),

        new ScenarioStep(tsMOVE, pJDI +" "+ PREDSIN,
            zPRESUN + PREDSIN +"\n"+ wPREDSIN
            ,
            PREDSIN,
            new String[] { OBYVAK, GARAZ },
            new String[] { VESAK, BOTNIK, ROHOZKA },
            new String[] { PISTOLE, PRISTUPOVY_KOD, TATINEK }
        ),

        new ScenarioStep(tsMOVE, pJDI + " "+GARAZ,
            zPRESUN + GARAZ +"\n"+ wGARAZ
            ,
            GARAZ,
            new String[] { PREDSIN },
            new String[] { AUTO },
            new String[] { PISTOLE, PRISTUPOVY_KOD, TATINEK }
        ),

        new ScenarioStep(tsNON_STANDARD2, pPOUZIJ +" "+ TATINEK +" "+ AUTO,
            zSUCCESS_END
            ,
            SKLAD_JADERNYCH_ZBRANI,
            new String[] { },
            new String[] { },
            new String[] { PISTOLE, PRISTUPOVY_KOD, TATINEK }
        )
    };

    static { ScenarioStep.setIndex(1); }

    private static final ScenarioStep[] ALTERNATIVE_END_SCENARIO_STEPS = {
        START_STEP,

        new ScenarioStep(tsMOVE, pJDI + " " + CHODBA,
            zPRESUN + CHODBA + "\n" + wCHODBA
            ,
            CHODBA,
            new String[] {DETSKY_POKOJ, LOZNICE_RODICU,
                    KOUPELNA, POKOJ_PRO_HOSTY, KUMBAL, SCHODY},
            new String[] {OBRAZ},
            new String[] { }
        ),

        new ScenarioStep(tsMOVE, pJDI + " " + LOZNICE_RODICU,
            zPRESUN + LOZNICE_RODICU + "\n" + wLOZNICE_RODICU
            ,
            LOZNICE_RODICU,
            new String[]{CHODBA},
            new String[]{POSTEL, KNIHOVNA, NOCNI_STOLEK, ZRCADLO},
            new String[]{ }
        ),

        new ScenarioStep(tsNON_STANDARD1, pPROZKOUMEJ + " " + NOCNI_STOLEK,
            zPROZKOUMEJ_NOCNI_STOLEK
            ,
            LOZNICE_RODICU,
            new String[]{CHODBA},
            new String[]{POSTEL, KNIHOVNA, NOCNI_STOLEK, ZRCADLO, RETIZEK,
                    SVAZEK_BANKOVEK},
            new String[]{ }
        ),

        new ScenarioStep(tsTAKE, pSEBER + " " + SVAZEK_BANKOVEK,
            zZVEDNUTO + SVAZEK_BANKOVEK
            ,
            LOZNICE_RODICU,
            new String[]{CHODBA},
            new String[]{POSTEL, KNIHOVNA, NOCNI_STOLEK, ZRCADLO, RETIZEK },
            new String[]{ SVAZEK_BANKOVEK }
        ),

        new ScenarioStep(tsNON_STANDARD1, pPROZKOUMEJ + " " + KNIHOVNA,
            zPROZKOUMEJ_KNIHOVNA
            ,
            LOZNICE_RODICU,
            new String[]{CHODBA},
            new String[]{POSTEL, KNIHOVNA, NOCNI_STOLEK, ZRCADLO, RETIZEK,
                    KOD_OD_SEJFU },
            new String[]{ SVAZEK_BANKOVEK }
        ),

        new ScenarioStep(tsTAKE, pSEBER + " " + KOD_OD_SEJFU,
            zZVEDNUTO + KOD_OD_SEJFU
            ,
            LOZNICE_RODICU,
            new String[]{CHODBA},
            new String[]{POSTEL, KNIHOVNA, NOCNI_STOLEK, ZRCADLO, RETIZEK },
            new String[]{ SVAZEK_BANKOVEK, KOD_OD_SEJFU }
        ),

        new ScenarioStep(tsMOVE, pJDI + " " + CHODBA,
            zPRESUN + CHODBA +"\n"+ zPRESUN_POPIS_ITEMU + OBRAZ
            ,
            CHODBA,
            new String[] {DETSKY_POKOJ, LOZNICE_RODICU,
                    KOUPELNA, POKOJ_PRO_HOSTY, KUMBAL, SCHODY},
            new String[] {OBRAZ},
            new String[] { SVAZEK_BANKOVEK, KOD_OD_SEJFU }
        ),

        new ScenarioStep(tsMOVE, pJDI + " " + DETSKY_POKOJ,
            zPRESUN + DETSKY_POKOJ +"\n"+ zPRESUN_POPIS_ITEMU +
                    HOLCICKA +" "+ SKRIN +" "+ NEPORADEK
            ,
            DETSKY_POKOJ,
            new String[]{ CHODBA },
            new String[]{ HOLCICKA, SKRIN, NEPORADEK },
            new String[]{ SVAZEK_BANKOVEK, KOD_OD_SEJFU }
        ),

        new ScenarioStep(tsNON_STANDARD2, pPOUZIJ + " " +
                SVAZEK_BANKOVEK + " " + HOLCICKA,
            zPOUZIJ_BANKOVKY_HOLCICKA
            ,
            DETSKY_POKOJ,
            new String[]{ CHODBA },
            new String[]{ HOLCICKA, SKRIN, NEPORADEK },
            new String[]{ KOD_OD_SEJFU, VYSAVAC }
        ),

        new ScenarioStep(tsMOVE, pJDI + " " + CHODBA,
            zPRESUN + CHODBA +"\n"+ zPRESUN_POPIS_ITEMU + OBRAZ
            ,
            CHODBA,
            new String[] {DETSKY_POKOJ, LOZNICE_RODICU,
                    KOUPELNA, POKOJ_PRO_HOSTY, KUMBAL, SCHODY},
            new String[] {OBRAZ},
            new String[] { KOD_OD_SEJFU, VYSAVAC }
        ),

        new ScenarioStep(tsMOVE, pJDI + " " + KUMBAL,
            zPRESUN + KUMBAL + "\n" + wKUMBAL
            ,
            KUMBAL,
            new String[]{ CHODBA },
            new String[]{ SMETACEK, LOPATKA, KOSTE, SAVO, SEKERA,
                    SROUBOVAK },
            new String[]{ KOD_OD_SEJFU, VYSAVAC }
        ),

        new ScenarioStep(tsTAKE, pSEBER + " " + SEKERA,
            zZVEDNUTO + SEKERA
            ,
            KUMBAL,
            new String[]{ CHODBA },
            new String[]{ SMETACEK, LOPATKA, KOSTE, SAVO,
                    SROUBOVAK },
            new String[]{ KOD_OD_SEJFU, VYSAVAC, SEKERA }
        ),

        new ScenarioStep(tsTAKE, pSEBER + " " + SROUBOVAK,
            zZVEDNUTO + SROUBOVAK
            ,
            KUMBAL,
            new String[]{ CHODBA },
            new String[]{ SMETACEK, LOPATKA, KOSTE, SAVO },
            new String[]{ KOD_OD_SEJFU, VYSAVAC, SEKERA, SROUBOVAK }
        ),

        new ScenarioStep(tsMOVE, pJDI + " " + CHODBA,
            zPRESUN + CHODBA +"\n"+ zPRESUN_POPIS_ITEMU + OBRAZ
            ,
            CHODBA,
            new String[] {DETSKY_POKOJ, LOZNICE_RODICU,
                    KOUPELNA, POKOJ_PRO_HOSTY, KUMBAL, SCHODY},
            new String[] {OBRAZ},
            new String[] { KOD_OD_SEJFU, VYSAVAC, SEKERA, SROUBOVAK }
        ),

        new ScenarioStep(tsNON_STANDARD2, pPOUZIJ + " " + SEKERA + " " + OBRAZ,
            zPOUZIJ_SEKERA_OBRAZ
            ,
            CHODBA,
            new String[] {DETSKY_POKOJ, LOZNICE_RODICU,
                    KOUPELNA, POKOJ_PRO_HOSTY, KUMBAL, SCHODY},
            new String[] { TRISKY, SEJF },
            new String[] { KOD_OD_SEJFU, VYSAVAC, SEKERA, SROUBOVAK }
        ),

        new ScenarioStep(tsNON_STANDARD1, pPROZKOUMEJ +" "+ SEJF,
            zPROZKOUMEJ_SEJF
            ,
            CHODBA,
            new String[] {DETSKY_POKOJ, LOZNICE_RODICU,
                    KOUPELNA, POKOJ_PRO_HOSTY, KUMBAL, SCHODY},
            new String[] { TRISKY, SEJF },
            new String[] { KOD_OD_SEJFU, VYSAVAC, SEKERA, SROUBOVAK }
        ),

        new ScenarioStep(tsNON_STANDARD2, pPOUZIJ +" "+ KOD_OD_SEJFU +" "+ SEJF,
            zPOUZIJ_KOD_SEJF
            ,
            CHODBA,
            new String[] {DETSKY_POKOJ, LOZNICE_RODICU,
                    KOUPELNA, POKOJ_PRO_HOSTY, KUMBAL, SCHODY},
            new String[] { TRISKY, VYKRADENY_SEJF },
            new String[] { VYSAVAC, SEKERA, FOSFORESKUJICI_AMPULKA, SROUBOVAK }
        ),

        new ScenarioStep(tsNON_STANDARD2, pSKOMBINUJ +" "+ VYSAVAC +" "+
                SROUBOVAK,
            zSKOMBINUJ_SROUBOVAK_VYSAVAC
            ,
            CHODBA,
            new String[] {DETSKY_POKOJ, LOZNICE_RODICU,
                    KOUPELNA, POKOJ_PRO_HOSTY, KUMBAL, SCHODY},
            new String[] { TRISKY, VYKRADENY_SEJF },
            new String[] { SEKERA, FOSFORESKUJICI_AMPULKA, UPRAVENY_VYSAVAC }
        ),

        new ScenarioStep(tsNON_STANDARD2, pSKOMBINUJ +" "+ UPRAVENY_VYSAVAC
                +" "+ FOSFORESKUJICI_AMPULKA,
            zSKOMBINUJ_AMPULKA_UVYSAVAC
            ,
            CHODBA,
            new String[] {DETSKY_POKOJ, LOZNICE_RODICU,
                    KOUPELNA, POKOJ_PRO_HOSTY, KUMBAL, SCHODY},
            new String[] { TRISKY, VYKRADENY_SEJF },
            new String[] { SEKERA, XRAY_GUN}
        ),

        new ScenarioStep(tsMOVE, pJDI + " " + SCHODY,
            zPRESUN + SCHODY +"\n"+ wSCHODY
            ,
            SCHODY,
            new String[] {CHODBA, OBYVAK},
            new String[] {FOTKY, ZABRADLI},
            new String[] { SEKERA, XRAY_GUN }
        ),

        new ScenarioStep(tsMOVE, pJDI + " " + OBYVAK,
            zPRESUN + OBYVAK +"\n"+ wOBYVAK
            ,
            OBYVAK,
            new String[] { SCHODY, KUCHYN, PREDSIN },
            new String[] { TELEVIZE, POHOVKA, MINIBAR },
            new String[] { SEKERA, XRAY_GUN }
        ),

        new ScenarioStep(tsMOVE, pJDI + " " + KUCHYN,
            zPRESUN + KUCHYN +"\n"+ wKUCHYN
            ,
            KUCHYN,
            new String[] { OBYVAK },
            new String[] { MAMINKA, TATINEK },
            new String[] { SEKERA, XRAY_GUN }
        ),

        new ScenarioStep(tsNON_STANDARD2, pPOUZIJ +" "+ XRAY_GUN +" "+ MAMINKA,
            zALTERNATIVE_END
            ,
            KUCHYN,
            new String[] { OBYVAK },
            new String[] { MAMINKA, TATINEK },
            new String[] { SEKERA, XRAY_GUN }
        ),
    };

    static { ScenarioStep.setIndex(1); }

    private static final ScenarioStep[] BAD_END_SCENARIO_STEPS = {
        START_STEP,

        new ScenarioStep(tsMOVE, pJDI + " " + CHODBA,
            zPRESUN + CHODBA + "\n" + wCHODBA
            ,
            CHODBA,
            new String[] {DETSKY_POKOJ, LOZNICE_RODICU,
                    KOUPELNA, POKOJ_PRO_HOSTY, KUMBAL, SCHODY},
            new String[] {OBRAZ},
            new String[] { }
        ),

        new ScenarioStep(tsMOVE, pJDI + " " + KOUPELNA,
            zPRESUN + KOUPELNA + "\n" + wKOUPELNA
            ,
            KOUPELNA,
            new String[] { CHODBA },
            new String[] { SPRCHOVY_KOUT, UMYVADLO, ZACHOD },
            new String[] { }
        ),

        new ScenarioStep(tsNON_STANDARD1, pPROZKOUMEJ +" "+ ZACHOD,
                zPROZKOUMEJ_ZACHOD
            ,
            KOUPELNA,
            new String[] { CHODBA },
            new String[] { SPRCHOVY_KOUT, UMYVADLO, ZACHOD, PISTOLE },
            new String[] { }
        ),

        new ScenarioStep(tsTAKE, pSEBER +" "+ PISTOLE,
            zZVEDNUTO + PISTOLE
            ,
            KOUPELNA,
            new String[] { CHODBA },
            new String[] { SPRCHOVY_KOUT, UMYVADLO, ZACHOD },
            new String[] { PISTOLE }
        ),

        new ScenarioStep(tsMOVE, pJDI + " " + CHODBA,
            zPRESUN + CHODBA +"\n"+ zPRESUN_POPIS_ITEMU + OBRAZ
            ,
            CHODBA,
            new String[] {DETSKY_POKOJ, LOZNICE_RODICU,
                    KOUPELNA, POKOJ_PRO_HOSTY, KUMBAL, SCHODY},
            new String[] { OBRAZ },
            new String[] { PISTOLE }
        ),

        new ScenarioStep(tsMOVE, pJDI + " " + SCHODY,
            zPRESUN + SCHODY +"\n"+ wSCHODY
            ,
            SCHODY,
            new String[] { CHODBA, OBYVAK },
            new String[] { FOTKY, ZABRADLI },
            new String[] { PISTOLE }
        ),

        new ScenarioStep(tsMOVE, pJDI + " " + OBYVAK,
            zPRESUN + OBYVAK +"\n"+ wOBYVAK
            ,
            OBYVAK,
            new String[] { SCHODY, KUCHYN, PREDSIN },
            new String[] { TELEVIZE, POHOVKA, MINIBAR },
            new String[] { PISTOLE }
        ),

        new ScenarioStep(tsMOVE, pJDI + " " + KUCHYN,
            zPRESUN + KUCHYN +"\n"+ wKUCHYN
            ,
            KUCHYN,
            new String[] { OBYVAK },
            new String[] { MAMINKA, TATINEK },
            new String[] { PISTOLE }
        ),

        new ScenarioStep(tsNON_STANDARD2, pPOUZIJ +" "+ PISTOLE +" "+ TATINEK,
            zPOUZIJ_PISTOLE_TATINEK
            ,
            KUCHYN,
            new String[] { OBYVAK },
            new String[] { MAMINKA, },
            new String[] { PISTOLE, TATINEK }
        ),

        new ScenarioStep(tsMOVE, pJDI + " " + OBYVAK,
            zPRESUN + OBYVAK +"\n"+ zPRESUN_POPIS_ITEMU + TELEVIZE +" "+
                    POHOVKA +" "+ MINIBAR
            ,
            OBYVAK,
            new String[] { SCHODY, KUCHYN, PREDSIN },
            new String[] { TELEVIZE, POHOVKA, MINIBAR },
            new String[] { PISTOLE, TATINEK }
        ),

        new ScenarioStep(tsMOVE, pJDI + " " + PREDSIN,
            zPRESUN + PREDSIN +"\n"+ wPREDSIN
            ,
            PREDSIN,
            new String[] { OBYVAK, GARAZ },
            new String[] { VESAK, BOTNIK, ROHOZKA },
            new String[] { PISTOLE, TATINEK }
        ),

        new ScenarioStep(tsMOVE, pJDI +" "+ GARAZ,
            zPRESUN + GARAZ +"\n"+ wGARAZ
            ,
            GARAZ,
            new String[] { PREDSIN },
            new String[] { AUTO },
            new String[] { PISTOLE, TATINEK }
        ),

        new ScenarioStep(tsNON_STANDARD2, pPOUZIJ +" "+ TATINEK +" "+ AUTO,
            zUNSUCCESSFULL_END
            ,
            SKLAD_JADERNYCH_ZBRANI,
            new String[] { },
            new String[] { },
            new String[] { PISTOLE, TATINEK }
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
        addScenario("_ALTERNATIVE_",
                    TypeOfScenario.scGENERAL, ALTERNATIVE_END_SCENARIO_STEPS);
        addScenario("_BADEND_",
                TypeOfScenario.scGENERAL, BAD_END_SCENARIO_STEPS);
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
        //MANAGER.testGameByScenarios(HAPPY_SCENARIO_NAME);
        //MANAGER.testGameByScenarios(MISTAKE_SCENARIO_NAME);
        //MANAGER.testGameByScenarios("_REQUIRED_");
        //MANAGER.testGameByScenarios("_ALTERNATIVE_");
        MANAGER.testGameByScenarios("_BADEND_");

        //Playing the game according to the scenario with the given name
//        MANAGER.playGameByScenario("???");

        System.exit(0);
    }

}
