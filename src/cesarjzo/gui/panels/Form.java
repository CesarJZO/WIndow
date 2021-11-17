package cesarjzo.gui.panels;

import javax.swing.*;
import java.awt.*;

/**
 * A general purpose form. You can create a form with n fields by naming them.
 *
 * @author CésarJZO
 */
public class Form extends JPanel {
    private final JPanel[] panels;
    private final JLabel[] labels;
    private final JTextField[] txtFields;
    private final int amount;
    private final int COLUMNS = 15;
    private final JButton button;

    /**
     * Creates a single text field form.
     *
     * @param btnTab Text to be displayed on the button.
     * @param label  Text of the text field.
     */
    public Form(String btnTab, String label) {
        amount = 1;
        final int i = 0;
        labels = new JLabel[amount];
        labels[i] = new JLabel(label);

        txtFields = new JTextField[amount];
        txtFields[i] = new JTextField(COLUMNS);

        panels = new JPanel[amount];
        panels[i] = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panels[i].add(labels[i]);
        panels[i].add(txtFields[i]);

        add(panels[i]);
        button = new JButton(btnTab);
    }

    /**
     * Creates a form depending on how many labels you put.
     *
     * @param btnTab Text to be displayed on the button.
     * @param tabs   Texts to be displayed on the labels.
     */
    public Form(String btnTab, String... tabs) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        amount = tabs.length;
        panels = new JPanel[amount + 1];
        labels = new JLabel[amount];
        txtFields = new JTextField[amount];
        for (int i = 0; i < amount; i++) {
            panels[i] = new JPanel();
            panels[i].setLayout(new BoxLayout(panels[i], BoxLayout.Y_AXIS));
            labels[i] = new JLabel(tabs[i]);
            txtFields[i] = new JTextField(COLUMNS);
            panels[i].add(labels[i]);
            panels[i].add(txtFields[i]);
            add(panels[i]);
        }
        panels[amount] = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        button = new JButton(btnTab);
        panels[amount].add(button);
        add(panels[amount]);
    }

    /**
     * Clear the typed values of each text field of the form.
     */
    public void clearValues() {
        for (JTextField txtFld : txtFields)
            txtFld.setText("");
    }

    /**
     * Gets the values of each text field.
     *
     * @return an array with all the texts typed.
     */
    public String[] getInsertedValues() {
        String[] inserted = new String[amount];
        for (int i = 0; i < amount; i++)
            inserted[i] = txtFields[i].getText();
        return inserted;
    }

    /**
     * Gets the text of the text field.
     *
     * @return a string with the text typed. Null if there are more than one field.
     */
    public String getInsertedValue() {
        if (amount == 1)
            return txtFields[0].getText();
        else
            return null;
    }

    /**
     * Gets the button at the final of the form.
     *
     * @return the button.
     */
    public JButton getButton() {
        return button;
    }

    /**
     * Returns the typed values with their description.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < txtFields.length; i++) {
            sb.append(labels[i].getText()).append(": ").append(txtFields[i].getText());
            if (i < txtFields.length - 1) sb.append('\n');
        }
        return sb.toString();
    }
}
