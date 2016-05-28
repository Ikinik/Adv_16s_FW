/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.adv16s._2_1615.sora00_sorfa.game;

import java.util.Arrays;
import java.util.stream.Collectors;



/**
 * Knihovní třída {@code Texts} slouží jako schránka na textové konstanty,
 * které se používají na různých místech programu.
 * Centralizací definic těchto textových řetězců lze nejsnadněji dosáhnout toho,
 * že texty, které mají být shodné na různých místech programu,
 * budou doopravdy shodné.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version Reference
 */
final class Texts
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
            ZOMBIE_HOLCICKA = "Zombie holčička",
            SKRIN           = "Skříň",
            NEPORADEK       = "Nepořádek",
            SPRCHOVY_KOUT   = "Sprchový-kout",
            UMYVADLO        = "Umyvadlo",
            ZACHOD          = "Záchod",
            PISTOLE         = "Pistole",
            POSTEL          = "Postel",
            KRESLO          = "Křeslo",
            STRYCEK_ALFRED  = "Strýček-Alfréd",
            MRTVOLA_STRYCKA = "Mrtvola-strýčka",
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
            MRTVOLA_MAMINKY = "Mrtvola-maminky",
            OBRAZ           = "Obraz",
            SPONKA          = "Sponka",
            KOSTE           = "Koště",
            SMETACEK        = "Smetáček",
            LOPATKA         = "Lopatka",
            SAVO            = "Savo",
            SEKERA          = "Sekera",
            SROUBOVAK       = "Šroubovák",
            TRISKY          = "Třísky",
            FOTKY           = "Fotky",
            ZABRADLI        = "Zábradlí",
  MANZELSKA_POSTEL          = "Manželská-postel",
            KNIHOVNA        = "Knihovna",
            NOCNI_STOLEK    = "Noční-stolek",
            ZRCADLO         = "Zrcadlo",
            RETIZEK         = "Řetízek",
     SVAZEK_BANKOVEK        = "Svazek-bankovek",
            MINIBAR         = "Minibar",
            VESAK           = "Věšák",
            BOTNIK          = "Botník",
            ROHOZKA         = "Rohožka",
            VYSAVAC         = "Vysavač",
        UPRAVENY_VYSAVAC    = "Upravený-vysavač",
            SEJF            = "Sejf",
            KOD_OD_SEJFU    = "Kód-od-sejfu",
            VYKRADENY_SEJF  = "Vykradený-sejf",
    FOSFORESKUJICI_AMPULKA  = "Fosforeskující-ampulka",
            XRAY_GUN        = "Xray-gun",
            ZELENY_BLOB     = "Zelený-blob";

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
            zPRESUN = "Vešel jste do místnosti ",
            zPRESUN_POPIS_ITEMU = "Nachází se zde: ",
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
            zNIC_NENI = "Vůbec nic",
            zSUCCESS_END =
            "S tatínkovo pomocí jste se úspěšně dostal do tajného skladu \n" +
            "jaderných zbraní. Zde jste pomocí skenu tatínkovy sítnice a \n" +
            "tajného strýčkova kódu odpálil střely dlouhého doletu na \n" +
            "hlavní města předních světových velmocí. Netrvalo to dlouhou a\n" +
            "odpověď na sebe nenechala dlouho čekat. \n\n" +
            "Lidsvo to má spočítané. Úkol jste splnil na výbornou, Budiž vám" +
            " země lehká.",
            zUNSUCCESSFULL_END =
            "S tatínkovo pomocí jste se úspěšně dostal do tajného skladu\n"+
            "jaderných zbraní. Zde jste pomocí skenu tatínkovy sítnice \n" +
            "otevřel dveře od řídící místnosti. Boužel jste neznal\n" +
            "přístupový kód od ovládacího terminálu. Než ste stačil provést\n" +
            "jakoukoliv jinou záškodnickou akci byl jste dopaden\n" +
            "bezpečnostními jednotkami. Skončil jste ve vládních\n" +
            "laboratořích, jako testovací oběkt.\n\n" +
            "Bohužl jste selhal, váš úkol zůstal nesplněn. Tak snad nědky\n" +
            "příště :)",
            zALTERNATIVE_END =
            "Použil jste Xray gun na maminku. Zprvu se nedělo vůbec nic\n" +
            "zvláštního. Maminka strnula a dlouho se nehýbala. Tatínek se jí\n"+
            "pokusil dotknout. Ihned po té co se jí dotknul se rozpadla na\n" +
            "malinké částečky prachu, které odvál průvan ven z okna.\n" +
            "Jak po čase vyplinulo z pátrání biologů. Maminka byla nakažena\n" +
            "vzácným virem, který si přivezla z exotické dovolené v Thajsku\n" +
            "za rozumnou cenu. Ten postihoval především mláďátka opiček a\n" +
            "pro lidi nebyl nikterak škodlivý. Ovšem vlivem radiace\n" +
            "způsobené vysavačovou zbraní virus zmutoval a stal se pro lidi\n" +
            "smrtelným. Nákaza se šířila enormě rychle a za krátko vypukla\n" +
            "pandemie, která skončila naprostým vyhlazením lidské rasy.\n\n" +
            "Blahopřejemne, váš úkol byl splněn na výbornou. Lidstvo to má\n" +
            "spočítané.",


            zPOUZIJ_NEZADAN = "Nevím co a jak, zapínám TOR EXIT NODE.",
            zPOUZIJ_NENI_TOOL = "Nemám potřebný nástroj. Stahuji mallware...\n"+
            "Obsah zašifrován..... !!\n " + "Pošelete urychleně 50 BTC na " +
            "adresu: 1FCFCZ2rXnjfzqrnLvjApY6XzaShCZgV1p\npro získání " +
            "dekriptoru",
            zPOUZIJ_NENI_VEC = "Unknown item. Windows random error: 2622872787",
            zPOUZIJ_EXCEPTION = "Jejda něco se pokazilo",
            zPOUZIJ_NELZE_POUZIT = "Hmm.... no joooo. Zrovna se mi nechce nic "+
                    "dělat",
            zPOUZIJ_PISTOLE_HOLCICKA =
            "Zprvu vám to přišlo ja výborný nápad, ale nakonec jste si to\n" +
            "rozmyslel. Unitř vám sice bije chladné strojové srdce robota,\n" +
            "ale i na takovouto ohavnost je to přece jen málo.",
            zPOUZIJ_PISTOLE_STRYCEK =
            "Nepozorovaně jste se přiblížil ke strýčkovi, přiložil mu\n" +
            "pistoli na spánek a zmáčkl spoušť. Strýček se odebral do\n" +
            "věčných lovišť. Zbylo po něm jen torzo lidského těla, bez hlavy\n"+
            "a velká kaluž krve. Tak to bychom jednoho měli. Zbývá ještě\n" +
            "něco málo přes sedm miliard.",
            zPOUZIJ_PISTOLE_MAMINKA =
            "Vytáhl jste pistoli na maminku. Když to tatínek viděl, skočil\n" +
            "před maminku a začal vám slibovat hory doly. Uvědomil ste si,\n" +
            "že by se vám tatíneik mohl ještě hodit. Vzal jste si ho proto\n" +
            "jako rukojmí.",
            zPOUZIJ_PISTOLE_MAMINKA_NENI_TATINEK =
            "Zastřelij jste mamniku",
            zPOUZIJ_PISTOLE_TATINEK = "Vytáhl jste pistoli na tatínka, nyní " +
            "se stává vaším rukojmím.",
            zPOUZIJ_XRAY_TATINEK =
            "Vytáhl jste Xray gun na tatínka. Ten začal prosit o slitování.\n"+
            "Hmmm.... bůhví co by se z tatínka pak stalo. Mohl by vám však\n" +
            "být ještě užitečný a posloužt tak ke vznešenějším účelům.\n" +
            "Rozhodl jste se tedy vzít tatínka jako rukojmí",
            zPOUZIJ_PISTOLE_TATINEK_PLNY_BATOH = "Nemohu spáchat takouvou " +
            "ohavnost s plným batohem.",
            zPOUZIJ_XRAY_TATINEK_PLNY_BATOH =
                    zPOUZIJ_PISTOLE_TATINEK_PLNY_BATOH,
            zPOUZIJ_PISTOLE_MAMINKA_PLNY_BATOH =
                    zPOUZIJ_PISTOLE_TATINEK_PLNY_BATOH,
            zPOUZIJ_BANKOVKY_HOLCICKA =
            "Dal jste holčičce svazek bankovek. Holčička vypadá\n" +
            "velice spokojeně. Na oplnátku vám za to věnovala vysavač s \n" +
            "obrázkem sloníka\nZískáváte vysavač",
            zPOUZIJ_PENEZENKA_HOLCICKA =
            "Dal jste holčičce strýčkovu peněženku. Holčička vypadá\n"+
            "velice spokojeně. Na oplnátku vám za to věnovala vysavač s \n" +
            "obrázkem sloníka\nZískáváte vysavač",
            zPOUZIJ_SEKERA_OBRAZ = "Yeaaaaa, uuaaaa dkgfdskfgb\nRozštípal jste"+
            " obraz na třísky. Obraz však nebyl na stěně jen tak na okrasu.\n" +
            "Plnil zde důležitou funkci, ukrýval totiž tajný sejf.",
            zPOUZIJ_KOD_SEJF =
            "Pomocí kódu na papírku jste otevřel sejf. Kromně nezajímavých\n" +
            "pěti zlatých cihel a papírů, oběvujete podivnou ampulku s\n" +
            "fosforeskujícím zeleným slizem unitř a nálepku biohazard z\n" +
            "venku.\nMohla by se vám ještě hodit.\n" +
            "Získáváte tedy fosforeskující ampulku",
            zPOUZIJ_XRAY_HOLCICKA =
            "Použil jste Xray gun na holčičku. Zprvu to vypadalo že se\n" +
            "nestalo nic zvláštního. Po chvíli jste ale začal pozorovat jak\n" +
            "se holčička mění v zombie.",
            zPOUZIJ_XRAY_STRYCEK_ALFRED =
            "Použil jste Xray gun na strýčka Alfréda a výsledky na sebe\n" +
            "nenechaly dlouho čekat. Strýček se proměnil v zelený blob. Něco\n"+
            "zabreptal a zas znova usnul",


            zPROZKOUMEJ_STRYCEK_ALFRED =
            "Strýček má na zápěstí drahé hodinky značky Rolex. V levé kapse\n" +
            "má telefon, v pravé peněženku, v náprsní kapse má zastrčené \n" +
            "psací pero.",
            zPROZKOUMEJ_ZACHOD =
            "Záchod vypadá v celku čistě. Na první pohled na něm není\n" +
            "nic zvláštního. Moment ... Poodkryl jste víko od nádržky. A \n" +
            "vydíte podivně vyhlížející igelitový sáček. Po otevření \n" +
            "sáčku nacházíte plně funkční pistoli ráže devět milimetrů " +
            "s plným zásobníkem. \n\nMůžete dělat, jako že se nic nestalo a\n" +
            "na pistoli zapomenou. Nebo můžete pistoli sebrat a vyzkoušet\n" +
            "co dokáže.",
            zPROZKOUMEJ_NOCNI_STOLEK =
            "Otevřel jste noční stolek. Kromě jistých věcí na které byste\n" +
            "raději zapoměl, že ste je kdy viděl nacházíte zaltý řetízek a\n" +
            "svazek bankovek",
            zPROZKOUMEJ_OBRAZ =
            "Podíval jste se na obraz z blízka a něco vám na něm nesedělo.\n" +
            "Podíval jste se za něj a spatřil jste malé kovové panty. Pohl \n" +
            "jste obrazem a vidíte že je za ním ukrytý sejf.",
            zPROZKOUMEJ_KNIHOVNA =
            "Po prozkoumávání knih, jste našel mnoho zajímavých věcí.\n" +
            "Zaujaly vás zejména publikce o jaderném štěpení. Při pročítání\n" +
            "jedné z nic na vás vypadl malinký podivný papírek. Z jedné\n" +
            "strany je na něm napsáno sejf a z druhé je změť čísel.\n" +
            "Crrrrrrrrr unexpeced error crrrrrrrr null pointer exception\n"+
            "A jejda, to je nepříjemné\n"+
            "Rozhraní pro ovládání rukou havarovalo s neznámou chybou a\n" +
            "muselo být restartováno. Papírek s kódem od sejfu vám upadl na\n" +
            "zem.",
            zPROZKOUMEJ_SEJF =
            "Hmmm... vypadá to, že budu potřebovat znát tajný kód od sejfu,\n" +
            "abych se dostal dovnitř",


            zSKOMBINUJ_NEZADAN = "Nevím co mám skombinovat, zadej prosím dvě " +
            "věci a já to skusím znovu",
            zSKOMBINUJ_NENI_V_BATOHU = "Nemůžu a nechci montovat to co nemám.",
            zSKOMBINUJ_NENI_KOMBINACE = "Hmm... z toho nic zajímavého nezískám",
            zSKOMBINUJ_SPONKA_TELEFON =
            "Pomocí sponky jste z otevřel kryt telefonu a našel jste v něm \n" +
            "ukrytý papírek s přístupovým kódem.",
            zSKOMBINUJ_SROUBOVAK_VYSAVAC =
            "Za pomocí šroubováku jste upravil dětský vysavač. Obrátil jste\n" +
            "chod motorku. Nyní místo vysávání vyfukuje vzduch ven. Vyrobil\n" +
            "jste si improvizovaný výkoný rozprašovač. Stačí ještě sehnat\n" +
            "nějakou zajímavou náplň a můžeme se pustit do díla",
            zSKOMBINUJ_AMPULKA_UVYSAVAC =
            "vložil jste fosforeskující ampulku s podivným slizem do \n" +
            "upraveného vysavače. Tím jste získal fantastickou zbraň\n" +
            "ideální na likvidování všeho živého, co se vám připlete do\n" +
            "cesty. Vynalezenou zbraň jste pojmenoval Xray-gun.";


    /** Uvítací správy zobrazené při prvním vstupu do místnosti */
    static final String
            wLOZNICE_RODICU =
            "Ložnice vypadá vcelku uklizeně,\n"+
            "na první pohled se zde nenachází žádná věc, která by\n" +
            "potencionálně mohla zničit svět.",
            wCHODBA =
            "Odsud je možné navštívit spoustu dalších místností, nebo\n" +
            "sejít dolů po schodech. Kromě obrazu na stěně tu není nic\n" +
            "dalšího k vidění.",
            wKOUPELNA =
            "Hmmmm... tohle je nádhrená koupelna, je tu naprosto vše, co\n"+
            "by mohlo posloužit k výtečné vraždě, jako z hallywoodského\n" +
            "hororu. Naprvní pohled ovšem nic nenormálního. Při \n" +
            "důkladněším pohledu vám padlo oko na nádržku od záchodu,\n" +
            "vypadá, jako by s ní nedávno někdo manipuloval.",
            wPOKOJ_PRO_HOSTY =
            "Při vstupu do pokoje vidíte strýčka Alfréda jak podřimuje v\n"+
            "křesle. Vypadá to tu jako po pořádném flámu. Minimálně\n" +
            "strýšek Alfréd na to vypadá",
            wKUMBAL =
            "Kumbál patrně slouží jako sklad úklydových pomůcek, je to\n" +
            "tu samý hadr a smeták. Něco z toho by se možná mohlo hodit.\n"+
            "v kumbálu je pěkná tma, vypínač bohužel nefunguje. Po\n" +
            "chvíli se vaše oční kamery vzpamatovaly a v koutku vidíte\n" +
            "nádhernou sekeru.",
            wSCHODY =
            "I přesto že nejsou schody nijak extrémně strmé, dávají vám\n" +
            "co proto. Kdybernetika je teprve plenkách, za normálních\n" +
            "okolností jste rád, že dokážete jít sotva rovně.",
            wOBYVAK =
            "Obývák vypadá dosti obývatelně. Je zde veliký polstrovaný\n" +
            "gauč, naproti němu na stěně visí veliká širokoúhlá\n" +
            "televize. Vedle gauče se leskne minibar.",
            wKUCHYN =
            "V kuchini vidíte maminku a tatínka, patrně se pokoušejí\n" +
            "něco ukuchtit. K vašemu štěstí si vás příliš nevšímají.",
            wPREDSIN =
            "Ihned vám oko padlo na vstupní dveře. Vypadají opravdu\n" +
            "masivně obvzlášť pokud měříte na výšku s bídou 30 centimetrů.\n"+
            "Tudy do dál rozhodně nepůjde. Pode dveřmi je gumová rohožka\n"+
            "z vietnamské tržnice s nápisem Weclome. Po stranách je pak\n" +
            "botník a věšák na oblečení.",
            wGARAZ =
            "Tak tohle se jen tak nevidí, přímo před vámi je nádherný\n" +
            "nablískaný sportovní vůz značky Porsche. Auto je však\n" +
            "zamčené a se svojí velikostí by ste se stejně moc daleko\n" +
            "nedostal. Vypadá to že budete potřebovat někoho, kdo vám\n" +
            "tento problém pomůže vyřešit";

    /** Názvy používaných příkazů. */
    static final String
            pHELP   = "?",
            pTANCUJ = "tancuj",
            pJDI    = "jdi",
        pPROZKOUMEJ = "Prozkoumej",
            pPOLOZ  = "Polož",
            pPOUZIJ = "Použij",
            pKONEC  = "Konec",
            pSEBER  = "Seber",
         pSKOMBINUJ = "Skombinuj",
         pROZHLED   = "Rozhlédni-se";

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
