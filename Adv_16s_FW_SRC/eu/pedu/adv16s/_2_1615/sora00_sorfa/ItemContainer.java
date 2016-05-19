package eu.pedu.adv16s._2_1615.sora00_sorfa;

import eu.pedu.adv16s_fw.game_txt.IItem;
import eu.pedu.adv16s_fw.game_txt.IItemContainer;
import eu.pedu.adv16s_fw.game_txt.INamed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * Created by Adam on 16.5.2016.
 */
public abstract class ItemContainer implements IItemContainer {

    protected final int CAPACITY;
    private Collection<Item> items;
    private String[] itemNames = {};

    public ItemContainer(){
        this.CAPACITY = Integer.MAX_VALUE;
    }

    public ItemContainer(int capacity){
        this.CAPACITY = capacity;
    }

    public ItemContainer(String[] itemNames){
        this.itemNames = itemNames;
        this.CAPACITY = Integer.MAX_VALUE;
    }

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

    public Item getItem(String itemName){
        return INamed.getO(itemName, items).orElse(null);
    }

    public void removeItem(Item item){
        items.remove(item);
    }

    /***************************************************************************
     * Returns the bag capacity, i.e. the maximal permitted sum
     * of weights of items, that can be put into the bag at the same time.
     *
     * @return Capacity of the bag
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

    void forceAddItem(Item item){
        items.add(item);
    }

    void initialize() {
        items = Arrays.stream(itemNames)
                      .map(Item::new)
                      .collect(Collectors.toList());
    }
}
