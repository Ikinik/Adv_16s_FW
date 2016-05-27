package eu.pedu.adv16s._2_1615.sora00_sorfa.textui;

import eu.pedu.adv16s._2_1615.sora00_sorfa.GSMFactory;
import eu.pedu.adv16s._2_1615.sora00_sorfa.game.IAuthorPrototype;
import eu.pedu.adv16s._2_1615.sora00_sorfa.game.RobotGame;
import eu.pedu.adv16s_fw.game_txt.IGSMFactory;
import eu.pedu.adv16s_fw.game_txt.IGame;
import eu.pedu.adv16s_fw.game_txt.IUI;

import java.util.Scanner;

/**
 * Instance třídy {@code UIC_GamePlayer} realizují uživatelské rozhraní,
 * kterému lze zadat objekt typu {@code IGamePlayer}, jehož prostřednictvím
 * bude program komunikovat s uživatelem.
 */
public class UIC_GamePlayer implements IUI{

    /** Objekt specifikující některé detaily konverzace. */
    private final IGamePlayer player;

    /**
     * Vytvoří instanci využívající pro řešení některých detailů zadaný objekt.
     * @param player Objekt definující řešení některých detailů.
     */
    public UIC_GamePlayer(IGamePlayer player) {
        this.player = player;
    }

    /**
     * @return Odakaz na instanci probíhající hry
     */
    @Override
    public IGame getGame() {
        return RobotGame.getInstance();
    }

    /** Zahájí hru */
    @Override
    public void startGame() {
        startGame(RobotGame.getInstance());
    }

    /** Zahájí hru */
    @Override
    public void startGame(IGame iGame) {
        String command = "";
        String answer;
        for(;;){
            answer = getGame().executeCommand(command);
            if(!getGame().isAlive()){break;}
            command = player.askCommand(answer);
        }
        player.sendMessage(answer);
    }

    /**
     * @return Odkaz na class objekt tovární třídy {@lik GSMFactory}
     */
    @Override
    public Class<? extends IGSMFactory> getFactoryClass() {
       return GSMFactory.class;
    }

    /**
     * @return Jméno autora hry
     */
    @Override
    public String getAuthorName() {
        return IAuthorPrototype.AUTHOR_NAME;
    }

    /**
     * @return ID autora hry
     */
    @Override
    public String getAuthorID() {
        return IAuthorPrototype.AUTHOR_ID;
    }

    public static void main(String[] args) {
        IGamePlayer gamePlayer;
        gamePlayer = ((args.length < 1) || (! args[0].equals("-con")))
                   ? new ByJOptionPane()
                   : new ByScanner();
        new UIC_GamePlayer(gamePlayer).startGame();
        System.exit(0);

    }
}
