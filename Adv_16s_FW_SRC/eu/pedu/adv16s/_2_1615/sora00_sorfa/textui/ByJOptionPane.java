package eu.pedu.adv16s._2_1615.sora00_sorfa.textui;

import javax.swing.*;
import java.awt.*;

/**
 * Instance třídy {@code ByJOptionPane} zprostřednovávají komunikaci s
 * uživatelem prostřednictvím statických metod třídy {@link JOptionPane}
 */
public class ByJOptionPane implements IGamePlayer {

    /** Vytvoří novou instanci */
    public ByJOptionPane() { }

    /** {@inheritDoc} */
    @Override
    public String askCommand(String message) {
        return JOptionPane.showInputDialog(null,message);
    }

    /** {@inheritDoc} */
    @Override
    public void sendMessage(String message) {
        JOptionPane.showMessageDialog(null,message);
    }
}
