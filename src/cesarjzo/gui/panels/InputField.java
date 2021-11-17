package cesarjzo.gui.panels;

import javax.swing.*;

/**
 * Terminal-like panel (WIP)
 *
 * @author CésarJZO
 */
public class InputField extends JPanel {
    private JTextArea txtArea;
    private JTextField txtFld;
    private JScrollBar scrollBar;

    public InputField() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        txtArea = new JTextArea(20, 30);
        txtArea.setEditable(false);
        txtFld = new JTextField(30);
        add(txtArea);
        add(txtFld);
    }

    public String getInput() {
        txtFld.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, txtFld.getText());
        });
        return txtFld.getText();
    }
}
