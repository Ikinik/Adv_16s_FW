package eu.pedu.adv16s._2_1615.sora00_sorfa.game;

import eu.pedu.adv16s._2_1615.sora00_sorfa.game.auxiliaryClases.Pair;

import java.util.*;
import java.util.stream.Collectors;

import static eu.pedu.adv16s._2_1615.sora00_sorfa.game.Texts.*;

/**
 * Statická přída sloužící k ukládání dodatčných informací o objektech hry.
 *
 * @author Adam Šorfa
 */
class Flags {

    /** Mapa pro ukádání prozkoumávatelných předmětů a jejich obsahu. */
    private static Map<String,ExploredContent>
            explorableItems = new HashMap<String,ExploredContent>();

    /** Mapa pro ukládání kombinovatelných předmětů a výsledných předmětů po
     * jejich zkombinování */
    private static Map<Pair<String>,CombinedContent>
            combinableItems = new HashMap<Pair<String>,CombinedContent>();

    /** Privátní konstruktor bránící vytvoření instance třídy */
    private void Flags(){}

    /** Inicializace. Jsou naplněny definované mapy.  */
    static void initialize(){

        ExploredContent strycekContent = new ExploredContent(
            zPROZKOUMEJ_STRYCEK_ALFRED,
            MV + ROLEXKY, MV + TELEFON, MV + PENEZENKA, MV + PSACI_PERO);

        explorableItems.put(STRYCEK_ALFRED.toLowerCase(), strycekContent);

        explorableItems.put(MRTVOLA_STRYCKA.toLowerCase(),strycekContent);

        explorableItems.put(ZACHOD.toLowerCase(), new ExploredContent(
                zPROZKOUMEJ_ZACHOD
            ,
            MV + PISTOLE
        ));

        explorableItems.put(NOCNI_STOLEK.toLowerCase(), new ExploredContent(
            zPROZKOUMEJ_NOCNI_STOLEK
            ,
            MV + RETIZEK, MV + SVAZEK_BANKOVEK
        ));

        explorableItems.put(OBRAZ.toLowerCase(),new ExploredContent(
            zPROZKOUMEJ_OBRAZ
            ,
            SEJF
        ));

        explorableItems.put(KNIHOVNA.toLowerCase(),new ExploredContent(
            zPROZKOUMEJ_KNIHOVNA
            ,
            MV + KOD_OD_SEJFU
        ));

        explorableItems.put(SEJF.toLowerCase(),new ExploredContent(
            zPROZKOUMEJ_SEJF
        ));

        combinableItems.put(new Pair<String>(SPONKA.toLowerCase(),
                                             TELEFON.toLowerCase()),
                            new CombinedContent(
            zSKOMBINUJ_SPONKA_TELEFON
            ,
            MV + PRISTUPOVY_KOD));

        combinableItems.put(new Pair<String>(SROUBOVAK.toLowerCase(),
                                             VYSAVAC.toLowerCase()),
                            new CombinedContent(
            zSKOMBINUJ_SROUBOVAK_VYSAVAC
            ,
            MV + UPRAVENY_VYSAVAC));

        combinableItems.put(new Pair<String>(
                FOSFORESKUJICI_AMPULKA.toLowerCase(),
                UPRAVENY_VYSAVAC.toLowerCase()),
                new CombinedContent(
            zSKOMBINUJ_AMPULKA_UVYSAVAC
            ,
            MV + XRAY_GUN));
    }

    /** Vrátí {@code true}, pokud je pár {@link Pair} kombinovatelný */
    static boolean isCombinablePair(Pair<String> pair){
        return combinableItems.containsKey(pair);
    }

    /** Vrátí výsledek kombinace dvou předmětů {@link CombinedContent}. Pokud
     * nejdou ředměty kombinovatelné vrátí {@code null} */
    static CombinedContent getCombinedContent(Pair<String> pair){
        return combinableItems.get(pair);
    }

    /** Vrátí {@code true}, pokud je přemět prozkoumatelný. Pokun ne,
     * vrátí {@code false} */
    static boolean isExplorableItem(String itemName){
        return explorableItems.containsKey(itemName);
    }

    /** vrátí porozkoumaný obsah předmětu {@link ExploredContent}. Pokud není
     *  předmět zkoumatelný vrátí {@code null} */
    static ExploredContent getExploredContent(String itemName){
        return explorableItems.get(itemName);
    }

    /**
     * Statická třída, sloužící jako přepravka pro uchování zrpávy po
     * zkombinování předmětů a Nově vytvořeného předmětu.
     *
     */
    static class CombinedContent {
        /** Zpráva zobrazená akcí {@link ActionCombine } po úspěšném
         * zkombinování dvou předmětů */
        private final String message;

        /** Předmět, který je výsledkem kombinace dvou předmětů. */
        private final Item manufacturedItem;

        /**
         * Vytvoří instanci obsahu kombinace předmětů.
         *
         * @param message zpráva zobrazená po zkombinování předmětů
         * @param manufacturedItemName Výsledný předmět kombinace
         */
        CombinedContent(String message, String manufacturedItemName) {
            this.message = message;
            this.manufacturedItem = new Item(manufacturedItemName);
        }

        /**
         * Vrátí vytvořený předmět
         *
         * @return vytvořený předmět
         */
        Item getManufacturedItem() {
            return manufacturedItem;
        }

        /**
         * @return zpráva po zkombinování předmětů
         */
        String getMessage() {
            return message;
        }
    }

    /**
     * Třída pro uchování obsahu prozkoumatelného předmětu. Každý předmě lze
     * prozkoumat pouze jednou. K prozkoumání slouží metoda {@code flushItems}
     */
    static class ExploredContent {
        /** List ukrývaných předmětů */
        private final ArrayList<Item> items;
        /** Zpráva zobrazená po prozkoumání předmětu */
        private final String message;
        /** Uchováv informazi, zda-li byl předmět již prozkoumán */
        private boolean explored = false;
        /**
         * Uchová tajný obsah zkoumatelného předmětu.
         * @param message zpráva zobrazená při prozkoumání předmětu.
         * @param itemNames seznam předmětů skrytých uvnitř.
         */
        ExploredContent(String message, String... itemNames){
            this.message = message;
            items = (ArrayList) Arrays.stream(itemNames)
                          .map(Item::new)
                          .collect(Collectors.toList());
        }

        /** Předmět také nemusí obsahovat žádné další ukryté předměty, ale
         * pouze užitečnou informaci */
        ExploredContent(String message){
            this.message = message;
            items = new ArrayList<>();
        }

        /**
         * @return uvítací zpráva zobrazená při prozkoumání předmětu
         */
        String getMessage(){
            return message;
        }

        /**
         * Prověří, zdali zkoumaný předmět obsahuje ještě nějaké další předměty.
         * @return Pokud obsahuje předměty vrátí {@code true}, jinak vrací
         * {@code false}
         */
        boolean isEmpty(){
            return items.isEmpty();
        }

        /** Nastaví předmět, jako již prozkoumaný, aby se předešlo vytváření
         * duplicitních předmětů */
        void setExplored() { explored = true; }

        /** Pokud byl předmět již prozkoumán vrátí {@code true}. Pokud ne,
         * vrátí {@code false} */
        boolean isExplored() { return explored; }
        /**
         * vyplivne všechny obsažené předměty. Po zavolání metody se obsah
         * vyprázní. Předměty lze prozkoumat pouze jednou
         * @return Seznam obsažených předmětů
         */
        ArrayList<Item> flushItems(){
            ArrayList<Item> flItems = (ArrayList) items.clone();
            items.clear();
            return flItems;
        }
    }
}
