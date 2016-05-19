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


    private void Flags(){}

    static void initialize(){
        //MultiKeyMap hoj =
        explorableItems.put(STRYCEK_ALFRED.toLowerCase(), new ExploredContent(
            "Strýček má na zápěstí drahé hodinky značky Rolex. V levé kapse\n" +
            "má telefon, v pravé peněženku, v náprsní kapse má zastrčené \n" +
            "psací pero."
            ,
            MV + ROLEXKY, MV + TELEFON, MV + PENEZENKA, MV + PSACI_PERO));

        explorableItems.put(ZACHOD.toLowerCase(), new ExploredContent(
            "Záchod vypadá v celku čistě. Na první pohled na něm není\n" +
            "nic zvláštního. Moment ... Poodkryl jste víko od nádržky. A \n" +
            "vydíte podivně vyhlížející igelitový sáček. Po otevření \n" +
            "sáčku nacházíte plně funkční pistoli ráže devět milimetrů " +
            "s plným zásobníkem. \n\nMůžete dělat, jako že se nic nestalo a\n" +
            "na pistoli zapomenou. Nebo můžete pistoli sebrat a vyzkoušet\n" +
            "co dokáže."
            ,
            MV + PISTOLE
        ));

        combinableItems.put(new Pair<String>(SPONKA.toLowerCase(),
                                             TELEFON.toLowerCase()),
                            new CombinedContent(
            "Pomocí sponky jste z otevřel kryt telefonu a našel jste v něm \n" +
            "ukrytý papírek s přístupovým kódem."
            ,
            PRISTUPOVY_KOD));
    }

//    static Optional<CombinedContent> tryCombineItems(Pair<String> combinedPair){
//        return Optional.ofNullable(combinableItems.get(combinedPair));
//    }

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
            this.manufacturedItem = new Item(MV + manufacturedItemName);
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
