import cesarjzo.gui.AccentColor;
import cesarjzo.gui.Style;
import cesarjzo.gui.Theme;
import cesarjzo.gui.Window;
import cesarjzo.gui.panels.Form;
import cesarjzo.gui.panels.Console;
import cesarjzo.gui.panels.Login;
import cesarjzo.gui.panels.SideMenu;

import javax.swing.*;

/**
 * Example class which implements Window class and some panels.
 *
 * @author CésarJZO
 */
public class Demo {
    /**
     * Starts an implementation example.
     */
    static void implementUI() {
        // Instantiate the Window and a style
        Window window = new Window("Window");
        Style style = new Style(Theme.light, AccentColor.lime, "Roboto");

        // Create some panels and forms
        SideMenu menu = new SideMenu("Login", "Insert", "Terminal");
        Login login = new Login();
        Form form = new Form("Send", "Name", "Number", "Address", "eMail", "City");
        Console console = new Console("Send");

        // Sets a style for each created panel
        window.setStyle(style);
        menu.setStyle(style);
        login.setStyle(style);
        form.setStyle(style);
        console.setStyle(style);

        // Add all of them to central panel and make one of them visible by default
        menu.addToCentralPanel(login);
        menu.addToCentralPanel(form);
        menu.addToCentralPanel(console);
        menu.setDefaultPanel(console);

        // Add some action listeners to make menu work
        menu.getButton('l')
                .addActionListener(e -> menu.setDefaultPanel(login));
        menu.getButton('i')
                .addActionListener(e -> menu.setDefaultPanel(form));
        menu.getButton('t')
                .addActionListener(e -> menu.setDefaultPanel(console));

        // Makes these panels functional
        login.getButton()
                .addActionListener(e -> JOptionPane.showMessageDialog(window, login.toString()));
        form.getButton().addActionListener(e -> {
            JOptionPane.showMessageDialog(window, form.toString());
            form.clearValues();
        });
        console.getButton()
                .addActionListener(e -> JOptionPane.showMessageDialog(window, console.getInput()));
        console.getTextField().addActionListener(e -> console.writeInput());

        // Once menu is created and set, it is added to the main container of the window
        window.setMainPanel(menu);

        // window is visible
        window.appearAndFit();
    }
}
