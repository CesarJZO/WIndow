# Window

This is a library that implements and simplifies Swing GUI package.

It has some general-purpose panels predefined, such as a **Login** form or a **Menu**.

The expected use is to put the panels in the **Window** _(JFrame)_ container or the _central panel_ of the **SideMenu**
panel.

> #### Included panels _(JPanel)_ so far:
>
> - Form: A generic form with _n_ text fields.
> - Login: Login panel with its user and password field.
> - SideMenu: Menu with option buttons on the _west_ side.
> - InputField _(WIP)_: A _terminal-like_ panel.

### How to use them:

1. Instantiate any panel and put it into a container, such as:
   - **Window** main container.
   - **SideMenu** central panel.
2. You can use (**SideMenu**) _setVisibleOnly(p: JPanel)_ method in an _ActionListener_ to navigate over the panels put
   in the menu.
3. For each panel, you must add an _ActionListener_ in order to give a use to the button of each panel.  
   ***eg:*** A "Send" button for **Login** panel which returns the text of the fields.
4. Make your Window _(JFrame)_ visible.
