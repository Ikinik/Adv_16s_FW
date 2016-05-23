package eu.pedu.adv16s._2_1615.sora00_sorfa;

import eu.pedu.adv16s._2_1615.sora00_sorfa.auxiliaryClases.Pair;

import java.util.*;
import java.util.stream.Collectors;

import static eu.pedu.adv16s._2_1615.sora00_sorfa.Texts.*;

/**
 * Created by Adam on 17.5.2016.
 */
class Flags {

    private static Map<String,ExploredContent>
            explorableItems = new HashMap<String,ExploredContent>();
    private static Map<Pair<String>,CombinedContent>
            combinableItems = new HashMap<Pair<String>,CombinedContent>();
    private static Map<String, String> usableItems = new HashMap<String,String>();

    private void Flags(){}

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

    static boolean isCombinablePair(Pair<String> pair){
        return combinableItems.containsKey(pair);
    }

    static CombinedContent getCombinedContent(Pair<String> pair){
        return combinableItems.get(pair);
    }

    static boolean isExplorableItem(String itemName){
        return explorableItems.containsKey(itemName);
    }

    static ExploredContent getExploredContent(String itemName){
        return explorableItems.get(itemName);
    }

    static class CombinedContent {
        private final String message;
        private final Item manufacturedItem;

        CombinedContent(String message, String manufacturedItemName) {
            this.message = message;
            this.manufacturedItem = new Item(manufacturedItemName);
        }

        Item getManufacturedItem() {
            return manufacturedItem;
        }

        String getMessage() {
            return message;
        }
    }

    /**
     * Třída pro uchování obsahu prozkoumatelného předmětu. Každý předmě lze
     * prozkoumat pouze jednou. K prozkoumání slouží metoda {@code flushItems}
     */
    static class ExploredContent {
        private final ArrayList<Item> items;
        private final String message;
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

        void setExplored() { explored = true; }

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
