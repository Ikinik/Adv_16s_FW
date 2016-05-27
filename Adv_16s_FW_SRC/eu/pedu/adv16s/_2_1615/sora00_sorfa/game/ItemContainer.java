package eu.pedu.adv16s._2_1615.sora00_sorfa.game;

import eu.pedu.adv16s_fw.game_txt.IItemContainer;
import eu.pedu.adv16s_fw.game_txt.INamed;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * Instance třídy {@code ItemContainer } představují rodičovské podobjekty
 * instancí, které vystupují jako kontejnery předmětů.
 */
public abstract class ItemContainer implements IItemContainer {

    /** Kapacita kontejneru */
    protected final int CAPACITY;

    /** Kolekce aktuálních předmětů v daném kontejneru */
    private Collection<Item> items;

    /** Názvy předmětů v kontejneru */
    private String[] itemNames = {};

    /** Vytvoří nový kontejner s neomezenou kapacotou */
    public ItemContainer(){
        this.CAPACITY = Integer.MAX_VALUE;
    }

    /**
     * Vytvoří nový kontejner s se zadanou kapacitou.
     * @param capacity Kapacita kontejneru
     */
    public ItemContainer(int capacity){
        this.CAPACITY = capacity;
    }

    /**
     * Vytvoří nový kontejner se zadanými názvy předmětů v něm a neomezenou
     * kapacitou
     * @param itemNames Názvy předmětů obsažených v kontejneru
     */
    public ItemContainer(String[] itemNames){
        this.itemNames = itemNames;
        this.CAPACITY = Integer.MAX_VALUE;
    }

    /**
     * Vytvoří nový kontejner se zadanými názvy předmětů v něm a danou kapacitou
     *
     * @param capacity Kapacita kontejneru
     * @param itemNames Názvy předmětů obsažených v kontejneru
     */
    public ItemContainer(int capacity, String... itemNames){
        this.CAPACITY = capacity;
        this.itemNames = itemNames;
    }

    /***************************************************************************
     * Vrátí kolekci předmětů uchovaných v kontaineru.
     *
     * @return Kolekce předmětů v kontaineru
     */
    @Override
    public Collection<Item> getItems()
    {
        return Collections.unmodifiableCollection(items);
    }

    /**
     * Vrátí přemět v kontejneru podle jeho jména
     * @param itemName Jméno požadovaného přemětu
     * @return Vrátí požadovaný předmět, nebo {@code null}, pokud se předmět v
     * kontejneru nenachází
     */
    public Item getItem(String itemName){
        return INamed.getO(itemName, items).orElse(null);
    }

    /**
     * Ostraní předmět z kontejneru
     *
     * @param item Předmět, který má být odstraněn.
     */
    public void removeItem(Item item){
        items.remove(item);
    }

    /**
     * @return Kapacita kontejneru
     */
    public int getCapacity()
    {
        return CAPACITY;
    }

    /**
     * Vejde-li se zdaná věc do kontajneru, přidá jí a vrátí zprávu o výsledku.
     *
     * @param item věc, která se má přidat do kontajneru
     * @return Zpráva o výsledku: {@code true} = byl přidán, {@code false} =
     *                            nebyl přidán
     */
    boolean tryAddItem(Item item){
        if(!item.isMovable()){
            return false;
        }

        if(items.size() >= CAPACITY){
            return false;
        }
        items.add(item);
        return true;
    }

    /** Přidá předmět do kontejneru bez ohledu na cokoliv */
    void forceAddItem(Item item){
        items.add(item);
    }

    /** Inicializuje kontejner */
    void initialize() {
        items = Arrays.stream(itemNames)
                      .map(Item::new)
                      .collect(Collectors.toList());
    }
}
