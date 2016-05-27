package eu.pedu.adv16s._2_1615.sora00_sorfa.textui;

import javax.swing.*;
import java.util.Scanner;

/**
 * Instance třídy {@code ByJOptionPane} zprostřednovávají komunikaci s
 * uživatelem prostřednictvím statických metod třídy {@link JOptionPane}
 */
public class ByScanner implements IGamePlayer {

    Scanner scanner = new Scanner(System.in);

    /** {@inheritDoc} */
    @Override
    public String askCommand(String message) {
        sendMessage(message);
        return scanner.nextLine();
    }

    /** {@inheritDoc} */
    @Override
    public void sendMessage(String message) {
        System.out.println(message);
    }
}
