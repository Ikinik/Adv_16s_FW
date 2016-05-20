/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.adv16s._2_1615.sora00_sorfa;

import java.util.Arrays;
import java.util.stream.Collectors;



/*******************************************************************************
 * Knihovní třída {@code Texts} slouží jako schránka na textové konstanty,
 * které se používají na různých místech programu.
 * Centralizací definic těchto textových řetězců lze nejsnadněji dosáhnout toho,
 * že texty, které mají být shodné na různých místech programu,
 * budou doopravdy shodné.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version Reference
 */
class Texts
{
//== CONSTANT CLASS ATTRIBUTES =================================================
    static final String MV = "#";

    /** Názvy používaných prostorů - místností. */
    static final String
            LOZNICE_RODICU  = "Ložnice-rodičů",
            DETSKY_POKOJ    = "Dětský-pokoj",
            CHODBA          = "Chodba",
            KOUPELNA        = "Koupelna",
            POKOJ_PRO_HOSTY = "Pokoj-pro-hosty",
            KUMBAL          = "Kumbál",
            SCHODY          = "Schody",
            OBYVAK          = "Obývák",
            KUCHYN          = "Kuchyň",
            PREDSIN         = "Předsíň",
            GARAZ           = "Garáž",
            SKLAD_JADERNYCH_ZBRANI = "Sklad-jaderných-zbraní";

    /** Názvy používaných objektů. */
    static final String
            HOLCICKA        = "Holčička",
            SKRIN           = "Skříň",
            NEPORADEK       = "Nepořádek",
            SPRCHOVY_KOUT   = "Sprchový-kout",
            UMYVADLO        = "Umyvadlo",
            ZACHOD          = "Záchod",
            PISTOLE         = "Pistole",
            POSTEL          = "Postel",
            KRESLO          = "Křeslo",
            STRYCEK_ALFRED  = "Strýček-Alfréd",
            TELEFON         = "Telefon",
            PRISTUPOVY_KOD  = "Přístupový-kód",
            ROLEXKY         = "Rolexky",
            PENEZENKA       = "Peněženka",
            PSACI_PERO      = "Psací-pero",
            TELEVIZE        = "Televize",
            POHOVKA         = "Pohovka",
            TATINEK         = "Tatínek",
            AUTO            = "Auto",
            MAMINKA         = "Maminka",
            OBRAZ           = "Obraz",
            SPONKA          = "Sponka",
            KOSTE           = "Koště",
            SMETACEK        = "Smetáček",
            LOPATKA         = "Lopatka",
            SAVO            = "Savo",
            SEKERA          = "Sekera",
            TRISKY          = "Třísky",
            FOTKY           = "Fotky",
            ZABRADLI        = "Zábradlí";

            /* pomocné texty - výstupy: */
    static final String
            zCELE_UVITANI   =
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
            "--------------------------------------------------------------\n",
            zNENI_START =
            "\nPrvním příkazem není startovací příkaz.\n"
            + "Hru, která neběží lze spustit pouze startovacím příkazem.\n",
            zNEZNAMY_PRIKAZ = "Nedefinonvaný příkaz. Chrrrr, zničit lidstvo.",
            zNAPOVEDA =
            "Nápověda:\n Abyste vyhladil lidstvo musíte se nějak dostat \n" +
            "do nedalekého skladu jaderných zbraní. K tomu by vám mohl \n" +
            "pomoct nědko v domě. Budete ho ale muste nějak motivovat. \n" +
            "Dostat se pouze do skaldu nestačí. Budete potřebovat tajný kód\n" +
            "k odpálení jaderných hlavic. (Pssst prý se nachází u \n" +
            "důvěryhodné osoby v v domě.\n\n" +
            "Seznam užitečných příkazů:\n",
            zKONEC = "Konec hry, tak zas příště.\n",
            zPREDMET_NEZADAN = "stderr: Není co sebrat.\n",
            zNENI_ITEM = "Undefined index. Předmět nenalezen. " +
                    "Segmentation fault !!!\n",
            zZVEDNUTO = "Sebral jste ",
            zNE_ZVEDNUTO = "Přístup odepřen. Do klávesnice bude vpuštěno 2230 "+
                    "voltů\n Odpočítávám: \n3.\n2..\n1...",
            zCIL_NEZADAN = "Cíl nezadán, Cíl nezadán píp píp, chrrrr",
            zNENI_CIL = "Příliš daleko.",
            zPRESUN = "Vešel jste do ",
            zNENI_V_BATOHU = "Předmět není v batohu. píp píp",
            zPOLOZENO = "Položil jste ",
            zPRAZDY_PRIKAZ = "Nevím, co mám dělat, proto se raději ani o nic " +
                 "pokoušet nebudu.\nProtože kdo nic neudělá, ten nic neskazí.",
            zZKOUMANY_PREDMNET_NEZADAN = "Nevím co mám prozkoumat",
            zNENI_ZKOUMATELNY = "Nic zajímavého.",
            zPROZKOUMANY = "Už tu není nic zajímavého k vidělí.",
            zTANCUJ_HOLCICKA =
            "Holčičce se tanaček velice líbil, zatleskala vám a přitom jí\n" +
            "vypadla sponka do vlasů.\nZískáváte tedy sponku do vlasů.",
            zTANCUJ_HOLCICKA_PLNY_BATOH = zTANCUJ_HOLCICKA + " Ehm...\n" +
            "pardon vlastně nezískáváte vůbec nic, jelikož máte batoh plný\n" +
            "zbytečných nesmyslů",
            zTANCUJ_KDEKOLIV = "Bum shaka laka",
            zSKOMBINUJ_NEZADAN = "Nevím co mám skombinovat, zadej prosím dvě " +
            "věci a já to skusím znovu",
            zSKOMBINUJ_NENI_V_BATOHU = "Nemůžu a nechci montovat to co nemám.",
            zSKOMBINUJ_NENI_KOMBINACE = "Hmm... z toho nic zajímavého nezískám",
            zPOUZIJ_NEZADAN = "Nevím co a jak, zapínám TOR EXIT NODE.",
            zPOUZIJ_NENI_TOOL = "Nemám potřebný nástroj. Stahuji mallware...\n"+
            "Obsah zašifrován..... !!\n " + "Pošelete urychleně 50 BTC na " +
            "adresu: 1FCFCZ2rXnjfzqrnLvjApY6XzaShCZgV1p\npro získání " +
            "dekriptoru",
            zPOUZIJ_NENI_VEC = "Unknown item. Windows random error: 2622872787",
            zPOUZIJ_EXCEPTION = "Jejda něco se pokazilo",
            zPOUZIJ_NELZE_POUZIT = "Hmm.... no joooo. Zrovna se mi nechce nic " +
                    "dělat",
            zPOUZIJ_PISTOLE_TATINEK = "Vytáhl jste pistoli na tatínka, nyní " +
            "se stává vaším rukojmím.",
            zPOUZIJ_PISTOLE_TATINEK_PLNY_BATOH = "Nemohu spáchat takouvou " +
            "ohavnost s plným batohem.",
            zPOUZIJ_SEKERA_OBRAZ = "Yeaaaaa, uuaaaa dkgfdskfgb\nRozštípal jste " +
            "obraz na třísky",
            zSUCCESS_END =
            "S tatínkovo pomocí jste se úspěšně dostal do tajného skladu \n" +
            "jaderných zbraní. Zde jste pomocí skenu tatínkovy sítnice a \n" +
            "tajného strýčkova kódu odpálil střely dlouhého doletu na \n" +
            "hlavní města předních světových velmocí. Netrvalo to dlouhou a\n" +
            "odpověď na sebe nenechala dlouho čekat. \n\n" +
            "Lidsvo to má spočítané. Úkol jste splnil na výbornou, Budiž vám" +
            " země lehká.";

    /** Názvy používaných příkazů. */
    static final String
            pHELP   = "?",
            pTANCUJ = "tancuj",
            pJDI    = "jdi",
        pPROZKOUMEJ = "Prozkoumej",
            pPOLOZ  = "Polož",
            pPRECTI = "Skombinuj",
            pPOUZIJ = "Použij",
            pZAVRI  = "Polož",
            pKONEC  = "Konec",
            pSEBER  = "Seber",
         pSKOMBINUJ = "Skombinuj",
            pBJEZ   = "Bjež";

//== VARIABLE CLASS ATTRIBUTES =================================================



//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================

    /***************************************************************************
     * Vrátí řetězec obsahující zadané názvy oddělené čárkami.
     *
     * @param názvy Názvy, které je třeba sloučit
     * @return Výsledný řetězec ze sloučených zadaných názvů
     */
    static String cm(String... názvy)
    {
        String result = Arrays.stream(názvy)
                .collect(Collectors.joining(", "));
        return result;
    }



//== PRIVATE AND AUXILIARY CLASS METHODS =======================================



//##############################################################################
//== CONSTANT INSTANCE ATTRIBUTES ==============================================
//== VARIABLE INSTANCE ATTRIBUTES ==============================================



//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /** Soukromý konstruktor zabraňující vytvoření instance.*/
    private Texts() {}



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
