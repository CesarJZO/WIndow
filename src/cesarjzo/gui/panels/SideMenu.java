package cesarjzo.gui.panels;

import cesarjzo.gui.Style;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Creates a general purpose menu with the sub-menu buttons on the west side of the whole panel.
 *
 * @author CésarJZO
 */
public class SideMenu extends JPanel {
    private final Map<Character, JButton> btnMap;
    private final ArrayList<JPanel> panels;
    private final JPanel west;
    private final JPanel center;

    public void setStyle(Style style) {
        setBackground(style.backgroundColor);
        west.setBackground(style.panelColor);
        center.setBackground(style.backgroundColor);
        for (JButton button : btnMap.values()) {
            button.setBackground(style.panelColor);
            button.setForeground(style.foreground);
            button.setFont(style.font);
        }
    }
    /**
     * Creates a menu located on the left side of the window.
     *
     * @param btnTags An array of strings which will be placed in the buttons.
     */
    public SideMenu(String... btnTags) {
        super(new BorderLayout());

        west = new JPanel();
        west.setLayout(new GridLayout(btnTags.length, 1));
        center = new JPanel();
        panels = new ArrayList<>();

        btnMap = new HashMap<>();
        for (String tag : btnTags) {
            char key = Character.toLowerCase(tag.charAt(0));
            JButton btn = new JButton(tag);
            btnMap.put(key, btn);
            west.add(btn);
        }

        add(west, BorderLayout.WEST);
        add(center, BorderLayout.CENTER);
    }

    /**
     * Gets the central panel
     *
     * @return Central panel
     */
    public JPanel getCenter() {
        return center;
    }

    public JButton getButton(char key) {
        return btnMap.get(key);
    }

    /**
     * Adds the specified panel to the central panel
     *
     * @param panel panel to be added
     */
    public void addToCentralPanel(JPanel panel) {
        panels.add(panel);
        center.add(panel);
    }

    /**
     * Sets visible only the specified panel, but it must be added to the central panel first.
     *
     * @param panel panel to be displayed
     */
    public void setDefaultPanel(JPanel panel) {
        for (JPanel p : panels)
            p.setVisible(p.equals(panel));
    }
}