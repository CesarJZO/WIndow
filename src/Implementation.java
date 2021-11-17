import cesarjzo.gui.Window;
import cesarjzo.gui.panels.Form;
import cesarjzo.gui.panels.Login;
import cesarjzo.gui.panels.SideMenu;

import javax.swing.*;

/**
 * Example class which implements Window class and some panels.
 *
 * @author CésarJZO
 */
public class Implementation {
    /**
     * Starts an implementation example.
     */
    static void implementUI() {
        // Instantiate the Window
        Window window = new Window("Window");

        // Create some panels and forms
        SideMenu menu = new SideMenu("Login", "Insert");
        Login loginPanel = new Login();
        Form form = new Form("Send", "Name", "Number", "Address", "eMail");

        // Add all of them to central panel and makes one of them visible by default
        menu.addToCentralPanel(loginPanel);
        menu.addToCentralPanel(form);
        menu.setVisibleOnly(form);

        // Add some action listeners to make menu work
        menu.getButton('l')
                .addActionListener(e -> menu.setVisibleOnly(loginPanel));
        menu.getButton('i')
                .addActionListener(e -> menu.setVisibleOnly(form));

        // Makes these panels functional
        loginPanel.getButton()
                .addActionListener(e -> JOptionPane.showMessageDialog(window, loginPanel.toString()));
        form.getButton().addActionListener(e -> {
            JOptionPane.showMessageDialog(window, form.toString());
            form.clearValues();
        });

        // Once the menu is created and set, it is added to the main container of the window
        window.setMainPanel(menu);

        // window is visible
        window.appearAndFit();
    }
}
