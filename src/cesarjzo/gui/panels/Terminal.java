package cesarjzo.gui.panels;
import cesarjzo.gui.Theme;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Creates a terminal-like panel. Contains a text area with a scroll bar for the output and a text
 * field for the input.
 * @author CésarJZO
 */
public class Terminal extends JPanel {
    private int rows = 15;
    private int columns = 30;
    private Font font;
    private Color bgColor;
    private Color fontColor;
    private final JTextArea txtArea;
    private final JScrollPane scrollPane;
    private final JTextField txtFld;
    private final JPanel inputPanel;
    private final JButton button;
    private String text;

    /**
     * Creates a terminal-like panel with a text area (uneditable) and a text field with a button.
     * @param btnLabel Text to be displayed on the button
     */
    public Terminal(String btnLabel) {
        font = new Font("Consolas", Font.PLAIN, 12);

        txtArea = new JTextArea(rows, columns);
        txtArea.setLineWrap(true);
        txtArea.setEditable(false);
        txtArea.setFont(font);
        scrollPane = new JScrollPane(
                txtArea,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        text = "";

        txtFld = new JTextField(columns);
        txtFld.setFont(font);
        txtFld.addActionListener(e -> writeInput());
        button = new JButton(btnLabel);
        inputPanel = new JPanel();
        inputPanel.add(txtFld);
        inputPanel.add(button);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(scrollPane);
        add(inputPanel);
    }

    public JButton getButton() {
        return button;
    }

    public String getInput() {
        return txtFld.getText();
    }

    /**
     * Sets the text of the text area, maintains the text fields without changes.
     * @param txt Text to replace the text area
     */
    public void setText(String txt) {
        text = txt;
        txtArea.setText(txt);
    }

    public JTextField getTextField() {
        return txtFld;
    }

    /**
     * Appends text in the text field to the text area.
     */
    public void writeInput() {
        if (!getInput().equals("")) {
            text = text.equals("") ? text + getInput() : text + '\n' + getInput();
            txtArea.setText(text);
            txtFld.setText("");
        }
    }

    public void setTheme(Theme theme) {
        switch (theme) {
            case dark -> {
                bgColor = Color.DARK_GRAY;
                fontColor = Color.WHITE;

            }
            case light -> {
                bgColor = new Color(0xdedede);
                fontColor = new Color(0x0a0a0a);
            }
        }
        txtArea.setBackground(bgColor);
        txtArea.setForeground(fontColor);
        txtFld.setBackground(bgColor);
        txtFld.setForeground(fontColor);
    }
}
