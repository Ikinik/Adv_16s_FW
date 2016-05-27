/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.adv16s._2_1615.sora00_sorfa.game;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

import static eu.pedu.adv16s._2_1615.sora00_sorfa.game.Texts.*;


/**
 * Akce slouží k použití předmětu v inventáři na předmět v aktuálním prostoru
 *
 * @author  Adam Šorfa
 */
class ActionUse extends AAction
{
//== CONSTANT CLASS FIELDS =====================================================
    /** Mapa definující předměty, které je možné nějakým způsobem pouřít */
    static final Map<String,Callable<String>>
        usableItems = new HashMap<String,Callable<String>>();

//== VARIABLE CLASS FIELDS =====================================================

//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================

    /**
     * Definice použitelných předmětů. Skládá se z názvů dvou předmětů a akce
     * provedené po jejich použití. Předpokládá se, že první předmět
     * {@link Item} je obsažen v batohu {@link Bag} a druhý se nachází v
     * aktuálním prostoru {@link Space}. Pro použití různých předmětů jsou
     * definovány různé akce. Akce jsou ukládány jako lambda výrazy.
     */
    static {
        Callable<String> expeditionToNuclearWarehouse = ()->{
            Space sklad = World.getInstance()
                    .getSpace(SKLAD_JADERNYCH_ZBRANI);
            World.getInstance().setCurrentSpace(sklad);
        
            if(Bag.getInstance().getItem(PRISTUPOVY_KOD) != null ){
                stopGame();
                return zSUCCESS_END;
            }else{
                stopGame();
                return zUNSUCCESSFULL_END;
            }
        };
    
        usableItems.put((PISTOLE+" "+TATINEK).toLowerCase(),()-> {
            if(Bag.getInstance().tryAddItem(new Item(MV + TATINEK))){
                Space currentSpace = World.getInstance().getCurrentSpace();
                Item tatinek = currentSpace.getItem(TATINEK);
                currentSpace.removeItem(tatinek);

                return zPOUZIJ_PISTOLE_TATINEK;
            }else{
                return zPOUZIJ_PISTOLE_TATINEK;
            }
        });

        usableItems.put((PISTOLE+" "+HOLCICKA).toLowerCase(),()->{
            return zPOUZIJ_PISTOLE_HOLCICKA;
        });

        usableItems.put((PISTOLE+" "+STRYCEK_ALFRED).toLowerCase(), ()->{
            Space currentSpace = World.getInstance().getCurrentSpace();
            Item strycek = currentSpace.getItem(STRYCEK_ALFRED);
            currentSpace.removeItem(strycek);
            currentSpace.forceAddItem(new Item(MRTVOLA_STRYCKA));

            return zPOUZIJ_PISTOLE_STRYCEK;
        });

        usableItems.put((PISTOLE+" "+MAMINKA).toLowerCase(), ()->{
            Space currentSpace = World.getInstance().getCurrentSpace();
            Item maminka = currentSpace.getItem(MAMINKA);
            Item tatinek = currentSpace.getItem(TATINEK);
            if(tatinek != null){
                Bag bag = Bag.getInstance();
                if(bag.tryAddItem(new Item(MV + TATINEK))){
                    currentSpace.removeItem(tatinek);
                    return zPOUZIJ_PISTOLE_MAMINKA;
                }else{
                    return zPOUZIJ_PISTOLE_MAMINKA_PLNY_BATOH;
                }
            }else{
                currentSpace.removeItem(maminka);
                currentSpace.forceAddItem(new Item(MRTVOLA_MAMINKY));
                return zPOUZIJ_PISTOLE_MAMINKA_NENI_TATINEK;
            }
        });

        usableItems.put((SEKERA+" "+OBRAZ).toLowerCase(),() -> {
            Space currentSpace = World.getInstance().getCurrentSpace();
            Item obraz = currentSpace.getItem(OBRAZ);
            currentSpace.removeItem(obraz);
            currentSpace.forceAddItem(new Item(MV + TRISKY));
            currentSpace.forceAddItem(new Item(SEJF));

            return zPOUZIJ_SEKERA_OBRAZ;
        });

        usableItems.put((TATINEK+" "+AUTO).toLowerCase(),expeditionToNuclearWarehouse);

        usableItems.put((SVAZEK_BANKOVEK+" "+HOLCICKA).toLowerCase(), () ->{
            Bag bag = Bag.getInstance();
            Item svazekBankovek = bag.getItem(SVAZEK_BANKOVEK);
            bag.removeItem(svazekBankovek);
            bag.tryAddItem(new Item(MV + VYSAVAC));

            return zPOUZIJ_BANKOVKY_HOLCICKA;
        });

        usableItems.put((PENEZENKA+" "+HOLCICKA).toLowerCase(),()->{
            Bag bag = Bag.getInstance();
            Item penezenka = bag.getItem(PENEZENKA);
            bag.removeItem(penezenka);
            bag.tryAddItem(new Item(MV + VYSAVAC));

            return zPOUZIJ_PENEZENKA_HOLCICKA;
        });

        usableItems.put((KOD_OD_SEJFU+" "+SEJF).toLowerCase(),()->{
            Bag bag = Bag.getInstance();
            Space currentSpace = World.getInstance().getCurrentSpace();

            Item kodOdSejfu = bag.getItem(KOD_OD_SEJFU);
            bag.removeItem(kodOdSejfu);
            bag.tryAddItem(new Item(MV+FOSFORESKUJICI_AMPULKA));

            Item sejf = currentSpace.getItem(SEJF);
            currentSpace.removeItem(sejf);
            currentSpace.forceAddItem(new Item(VYKRADENY_SEJF));

            return zPOUZIJ_KOD_SEJF;
        });

        usableItems.put((XRAY_GUN+" "+HOLCICKA).toLowerCase(),()->{
            Space currentSpace = World.getInstance().getCurrentSpace();
            Item holcicka = currentSpace.getItem(HOLCICKA);
            currentSpace.removeItem(holcicka);
            currentSpace.forceAddItem(new Item(ZOMBIE_HOLCICKA));

            return zPOUZIJ_XRAY_HOLCICKA;
        });

        usableItems.put((XRAY_GUN+" "+STRYCEK_ALFRED).toLowerCase(),()->{
            Space currentSpace = World.getInstance().getCurrentSpace();
            Item strycekAlfred = currentSpace.getItem(STRYCEK_ALFRED);
            currentSpace.removeItem(strycekAlfred);
            currentSpace.forceAddItem(new Item(ZELENY_BLOB));

            return zPOUZIJ_XRAY_STRYCEK_ALFRED;

        });

        usableItems.put((XRAY_GUN+" "+TATINEK).toLowerCase(),()->{
            if(Bag.getInstance().tryAddItem(new Item(MV + TATINEK))){
                Space currentSpace = World.getInstance().getCurrentSpace();
                Item tatinek = currentSpace.getItem(TATINEK);
                currentSpace.removeItem(tatinek);

                return zPOUZIJ_XRAY_TATINEK;
            }else{
                return zPOUZIJ_XRAY_TATINEK_PLNY_BATOH;
            }
        });

        usableItems.put((XRAY_GUN+" "+MAMINKA).toLowerCase(),()->{
            stopGame();
            return zALTERNATIVE_END;
        });

        usableItems.put((TATINEK+" "+AUTO).toLowerCase(),
                expeditionToNuclearWarehouse);

    }
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================



//##############################################################################
//== CONSTANT INSTANCE FIELDS ==================================================
//== VARIABLE INSTANCE FIELDS ==================================================



//##############################################################################
//== CONSTRUCTORS AND FACTORY METHODS ==========================================

    /***************************************************************************
     * Vytvoří instanci pro akci použij
     */
    ActionUse()
    {
        super (pPOUZIJ,
                "Použije věc v batohu na věc v aktuální místnosti");
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /**
     * Aby bylo možné provést akci použij, je nutné aby první zadaný předmět
     * byl umístěn v batohu {@link Bag} a druhý předmět se nacházel v aktuální
     * místnosti {@link Space}
     *
     * @param arguments Vyžaduje dva argumenty. Věc která se má použít a
     *                  předmět na který má být použita
     * @return Text zprávy vypsané po provedeni příkazu
     */
    @Override
    public String execute(String... arguments)
    {
        if(arguments.length < 3){
            return zPOUZIJ_NEZADAN;
        }

        Bag bag = Bag.getInstance();
        Space currentSpace = World.getInstance().getCurrentSpace();

        String toolName = arguments[1].toLowerCase();
        String thinkName = arguments[2].toLowerCase();
        Item tool = bag.getItem(toolName);
        Item think = currentSpace.getItem(thinkName);

        if(tool == null){
            return zPOUZIJ_NENI_TOOL;
        }else if(think == null){
            return zPOUZIJ_NENI_VEC;
        }else{
            if(usableItems.containsKey(toolName+" "+thinkName)){
                try {
                    return usableItems.get(toolName+" "+thinkName)
                                          .call();
                } catch (Exception e) {
                    return zPOUZIJ_EXCEPTION;
                }
            }else{
                return zPOUZIJ_NELZE_POUZIT;
            }
        }
    }

//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================

//##############################################################################
//== NESTED DATA TYPES =========================================================
}
