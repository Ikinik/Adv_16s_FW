package eu.pedu.adv16s._2_1615.sora00_sorfa.textui;

import javax.swing.*;

/**
 * Instance třídy {@code UID_Multiplayer} realizují uživatelské rozhraní,
 * které rozšiřuje možnosti rozhraní typu {@link IGamePlayer} o možnost zadat
 * po skončení hry, zda si che hráč zahrát ještě jednou, a pokud ano tak si
 * také vybrat typ rozhtaní, kterému bude dávat přednost.
 *
 * kterému lze zadat objekt typu {@code IGamePlayer}, jehož prostřednictvím
 * bude program komunikovat s uživatelem
 */
public class UID_Multiplayer extends UIC_GamePlayer {

    /** Oběkt specifikující některé detaily konverzace */
    private final IGameMultiPlayer multiPlayer;

    /**
     * Vytvoří instanci využívající pro řešení některých detailů zadaný objekt.
     * @param multiPlayer Objekt definující řešení některých detailů.
     */
    public UID_Multiplayer(IGameMultiPlayer multiPlayer) {
        super(multiPlayer);
        this.multiPlayer = multiPlayer;
    }

    /**
     * Komunikuje s uživatelem prostřednictvím zadaného prostředku. Vžda spustí
     * hru a po jejím ukončení se uživatele zeptá, chce-li si zahrát ještě
     * jednou, a koud ano, znovu spustí hru.
     */
    public void multistartGame(){
        do{
            startGame();
        }while (multiPlayer.wantContinue());
    }

    /**
     * Instance interfejsu {@code IGameMultiPlayer} definují variantní části
     * univerzálního textového uživatelského rozhraní pro hraní textových her.
     */
    public interface IGameMultiPlayer extends IGamePlayer{
        /**
         * Zjistí, chce-li si uživatel zahrát ještě jednou.
         *
         * @return Chceli si uživatel zahrát, vrátí {@code true},
         *         jinak vrátí {@code false}
         */
        public boolean wantContinue();
    }


    /**
     * Instance třídy {@code ByJOptionPane} zprostředkovávají komunikaci s
     * uživatelem prostřednictvím statických metod třídy {@link JOptionPane}
     */
    public static class ByJOptionPaneMulti extends ByJOptionPane
                                           implements IGameMultiPlayer{

        /** {@inheritDoc} */
        @Override
        public boolean wantContinue() {
            int answer = JOptionPane.showConfirmDialog(null,
                                    "Chcete si zahrát ještě jednou?");
            System.out.println(answer);
            return (answer == 0);
        }
    }

    public static class ByScannerMulti extends ByScanner
                                       implements  IGameMultiPlayer{
        /** {@inheritDoc} */
        @Override
        public boolean wantContinue() {
            String answer = askCommand("Chcete si zahrát ještě jednou (A/N)?");
            answer = answer.trim().toUpperCase();
            return (answer.charAt(0) == 'A');
        }
    }

    public static void main(String[] args) {
        IGameMultiPlayer gameMultiPlayer;
        gameMultiPlayer = ((args.length < 1) || (! args[0].equals("-con")))
                ? new ByJOptionPaneMulti()
                : new ByScannerMulti();
        new UID_Multiplayer(gameMultiPlayer).multistartGame();
        System.exit(0);
    }
}
