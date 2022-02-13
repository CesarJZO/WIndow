import cesarjzo.gui.*;
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
        Style style = new Style(Theme.dark, AccentColor.blue, "Roboto");

        String[] menuButtons = {"Login", "Form", "Console", "Paragraph"};
        // Create some panels and forms
        SideMenu menu = new SideMenu(menuButtons);
        Login login = new Login();
        Form form = new Form("Send", "ID Sucursal", "ID Estado", "ID Ciudad", "Nombre", "ID Colonia", "Calle");
        Console console = new Console("Send");
        Paragraph paragraph = new Paragraph("Great Western Railway War Memorial",
                """
                The Great Western Railway War Memorial is a First World War memorial by Charles Sargeant Jagger and\n
                Thomas S. Tait. It stands on platform 1 at London Paddington station, commemorating the 2,500 Great\n
                Western Railway (GWR) employees killed in the conflict. A third of the GWR's workforce of almost 80,000\n
                left to fight in the war, the company guaranteeing their jobs. The memorial consists of a bronze statue\n
                of a soldier in heavy winter clothing, reading a letter from home. The statue stands on a polished\n
                granite plinth, within a white stone surround.
                """);

        // Sets a style for each created panel
//        window.setStyle(style);
//        menu.setStyle(style);
//        login.setStyle(style);
//        form.setStyle(style);
//        console.setStyle(style);

        // Add all of them to central panel and make one of them visible by default
        menu.addToCentral(login);
        menu.addToCentral(form);
        menu.addToCentral(console);
        menu.addToCentral(paragraph);
        menu.setDefaultPanel(paragraph);

//        menu.addToEast();

        // Add some action listeners to make menu work
        menu.getButton(menuButtons[0])
                .addActionListener(e -> menu.setDefaultPanel(login));
        menu.getButton(menuButtons[1])
                .addActionListener(e -> menu.setDefaultPanel(form));
        menu.getButton(menuButtons[2])
                .addActionListener(e -> menu.setDefaultPanel(console));
        menu.getButton(menuButtons[3])
                .addActionListener(e -> menu.setDefaultPanel(paragraph));

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
