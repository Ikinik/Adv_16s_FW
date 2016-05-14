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
            GARAZ           = "Garáž";

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
            TELEVIZE        = "Televize",
            POHOVKA         = "Pohovka",
            TATINEK         = "Tatínek",
            AUTO            = "Auto",
            MAMINKA         = "Maminka";

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
            zCIL_NEZADAN = "Cíl nezadán, Cíl nezadán píp píp, chrrrr",
            zNENI_CIL = "Tam jít nemohu",
            zPRESUN = "Šel jste do ",
            zPREDMET_NEZADAN = "stderr: Není co sebrat.",
            zNENI_ITEM = "stderr: Není co sebrat.",
            zZVEDNUTO = "Sebral jste ",
            zNE_ZVEDNUTO = "Přístup odepřen. Do klávesnice bude vpuštěno 2230" +
                           " voltů\nOdpočítávám: \n3.\n2..\n1...";

    /** Názvy používaných příkazů. */
    static final String
            pHELP   = "?",
            pTANCUJ = "tancuj",
            pJDI    = "jdi",
            pOTEVŘI = "Prozkoumej",
            pPOLOŽ  = "Polož",
            pPŘEČTI = "Skombinuj",
            pVEZMI  = "Použij",
            pZAVŘI  = "Polož",
            pKONEC  = "Konec",
            pSEBER  = "Seber";

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
