package eu.pedu.adv16s._2_1615.sora00_sorfa.textui;

import eu.pedu.adv16s._2_1615.sora00_sorfa.GSMFactory;
import eu.pedu.adv16s._2_1615.sora00_sorfa.game.IAuthorPrototype;
import eu.pedu.adv16s._2_1615.sora00_sorfa.game.RobotGame;
import eu.pedu.adv16s_fw.game_txt.IGSMFactory;
import eu.pedu.adv16s_fw.game_txt.IGame;
import eu.pedu.adv16s_fw.game_txt.IUI;

import javax.swing.*;
import java.util.Scanner;

/**
 * Třída uživatelského rozraní vytvořeného pomocí standartního vstupu a
 * výstupu. Hra je hratelná pomocí konzolového rozhranní
 */
public class UIB_Scanner implements IUI{

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

    /** Spustí komunikaci mezi implicitní hrou a dannou instancí uživatelského
     *  rozhraní */
    @Override
    public void startGame(IGame iGame) {
        Scanner scanner = new Scanner(System.in);
        String command = "";
        String answer;

        for(;;){
            answer = getGame().executeCommand(command);
            System.out.println(answer);
            if(!iGame.isAlive()){ break; }
            command = scanner.nextLine();
        }
    }

    /**
     * @return Odkaz na class objekt tovární třídy {@link GSMFactory}
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
        UIB_Scanner scanner = new UIB_Scanner();
        scanner.startGame();
    }
}
