/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.adv16s._2_1615.sora00_sorfa.game;

import eu.pedu.adv16s_fw.scenario.AScenarioManager;
import eu.pedu.adv16s_fw.scenario.ScenarioStep;
import eu.pedu.adv16s_fw.scenario.TypeOfScenario;


import static eu.pedu.adv16s_fw.scenario.TypeOfStep.*;
import static eu.pedu.adv16s._2_1615.sora00_sorfa.game.Texts.*;


/**
 * Instance třídy {@code ScenarioManager} slouží jako
 * šablona (nebo chcete-li kostra) správce scénářů, jejichž prostřednictvím
 * budou testovací programy prověřovat správnou funkci plánované hry.
 * <p>
 * Jednotlivé scénáře jsou iterovatelné posloupností kroků specifikovaných
 * instancemi třídy
 * {@link ScenarioStep}
 * z frameworku, do nějž je třeba vyvíjenou hru hra začlenit.
 * <p>
 * Správce scénářů je jedináček, který má na starosti všechny scénáře
 * týkající se s ním sdružené hry.
 * <p>
 * Jednotlivé spravované scénáře se musí lišit svým názvem,
 * přičemž názvy základního úspěšného a základního chybového scénáře
 * jsou předem pevně dány a není je možno změnit.
 *
 * @author  Rudolf PECINOVSKÝ
 */
public final class ScenarioManager extends AScenarioManager
                               implements IAuthorPrototype
{
//== CONSTANT CLASS FIELDS =====================================================

    /**
     * Počáteční krok hry, který je pro všechny scénáře shodný.
     * <p>
     * Konstruktor plnohodnotné instance třídy {@link ScenarioStep}
     * vyžaduje následující parametry:
     <pre> {@code
    TypeOfStep typeOfStep; //Typ daného kroku scénáře
    String     command;    //Příkaz realizující tento krok scénáře
    String     message;    //Zpráva vypsaná po zadání příkazu
    String     area;       //Prostor, v němž skončí hráč po zadání příkazu
    String[]   neighbors;  //Sousedé aktuálního prostoru (= východy)
    String[]   objects;    //Objekty vyskytující se v daném prostoru
    String[]   bag;        //Aktuální obsah batohu
    }</pre>
     =======================================================================<br>
     * Kroky scénáře musejí navíc vyhovovat následujícím požadavkům:
     * <ul>
     *   <li>Žádná z položek nesmí obsahovat prázdný odkaz.</li>
     *   <li>S výjimkou položky {@code command} nesmí být žádný řetězec
     *     prázdný (tj. {@code ""})</li>
     *   <li>Prázdný řetězec se nesmí objevit ani jako položka některého
     *     z vektorů {@code neighbors}, {@code objects} či {@code bag}</li>
     * </ul>
     * <br>
     */
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


    /**
     * Kroky základního úspěšného scénáře
     * popisující očekávatelný úspěšný průběh hry.
     * Z těchto kroků sestavený scénář nemusí být nutně nejkratším možným
     * (takže to vlastně ani nemusí být základní úspěšný scénář),
     * ale musí vyhovovat všem okrajovým podmínkám zadání,
     * tj. musí obsahovat minimální počet kroků,
     * projít požadovaný.minimální počet prostorů
     * a demonstrovat použití všech požadovaných příkazů.
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


    /** Krok testující špatné spuštění hry je definován zvlášť,
     *  aby bylo možno správně nastavit indexy následujících kroků. */
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


    /**
     * Základní chybový scénář definující reakce
     * na povinnou sadu typů chybně zadaných příkazů.
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

    /**
     * Kroky scénáře pro prověření správné funkce definovaných pžíkazů a
     * správného chování hry
     */
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

    /**
     * Kroky scénáře pro dohrání hry s alternativním koncem
     */
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

    /**
     * Kroky scénáře pro dohrání hry se špatným (neůspěšným) koncem
     */
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

    /** Jediná instance této třídy. Spravuje všechny scénáře sdružené hry. */
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

    /**
     * Vrátí správce scénářů - jedinou instanci této třídy.
     *
     * @return Správce scénářů
     */
    public static ScenarioManager getInstance()
    {
        return MANAGER;
    }


    /**
     * Vytvoří instanci představující správce scénářů hry.
     * V rámci konstruktoru je vhodné vytvořit všechny scénáře
     * a správce scénářů poté zalepit.
     * <p>
     * Jednotlivé spravované scénáře se musí lišit svým názvem,
     * přičemž názvy základního úspěšného a základního chybového scénáře
     * jsou předem pevně dány a není je možno změnit.
     * Jim zadávané názvy jsou proto pouze formální, protože
     * jim volaná metoda stejně přiřadí ty předem definované.
     * <p>
     * Kontrakt metody
     * {@link #addScenario(String, TypeOfScenario, ScenarioStep...) }
     * vyžaduje, aby byl jak první přidán úspěšný scénář, tj. scénář typu
     * {@code TypeOfScenario.scHappy}, a jako druhý chybový scénář,
     * tj. scénář typu {@code MISTAKE_SCENARIO_NAME}.
     * Na pořadí následně přidávaných scénářů nezáleží.
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
     * Metoda prověřující daného správce scénářů
     * či hru definovanou scénáři tohoto správce.
     * <p>
     * U správce scénářů se prověřuje, zda vyhovuje zadaným okrajovým podmínkám,
     * tj. jestli:
     * <ul>
     *   <li>Umí vrátit správně naformátované jméno autora/autorky hry
     *       a jeho/její ID.</li>
     *   <li>Definuje základní úspěšný a základní chybový scénář.</li>
     *   <li>Základní chybový scénář má následující vlastnosti:
     *     <ul>
     *       <li>Startovní příkaz, jehož název je prázdný řetězec</li>
     *       <li>Minimální požadovaný počet kroků</li>
     *       <li>Minimální počet navštívených místností</li>
     *       <li>Minimální počet "zahlédnutých" místností</li>
     *       <li>Minimální počet vlastních (nepovinných) příkazů</li>
     *       <li>Použití příkazů pro přechod z prostoru do prostoru
     *         zvednutí nějakého objektu a položení nějakého objektu</li>
     *     </ul>
     *   </li>
     *   <li>Základní chybový scénář má následující vlastnosti:
     *     <ul>
     *       <li>Chybné odstartování příkazem,
     *           jehož název není prázdný řetězec</li>
     *       <li>Startovní příkaz, jehož název je prázdný řetězec</li>
     *       <li>Použití všech povinných chybových typů kroku definovaných
     *         ve třídě<br>
     *         {@link eu.pedu.adv16s_fw.scenario.TypeOfStep}</li>
     *       <li>Vyvolání nápovědy</li>
     *       <li>Ukončení příkazem pro nestandardní ukončení hry</li>
     *     </ul>
     *   </li>
     * </ul>
     * <p>
     * U hry se prověřuje, zda je možno ji zahrát přesně tak,
     * jak je naplánováno ve scénářích.
     *
     * @param args Parametry příkazového řádku - nepoužívané.
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
        MANAGER.testGameByScenarios(HAPPY_SCENARIO_NAME);
        //MANAGER.testGameByScenarios(MISTAKE_SCENARIO_NAME);
        //MANAGER.testGameByScenarios("_REQUIRED_");
        //MANAGER.testGameByScenarios("_ALTERNATIVE_");
        //MANAGER.testGameByScenarios("_BADEND_");

        //Playing the game according to the scenario with the given name
//        MANAGER.playGameByScenario("???");

        System.exit(0);
    }

}
