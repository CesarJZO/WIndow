package cesarjzo.gui;

import java.awt.*;

/**
 * Sets a color scheme to be added to any panel.
 */
public class Style {
    public Color backgroundColor;
    public Color panelColor;
    public Color buttonColor;
    public Color textBGColor;
    public Color foreground;

    public Font font;

    /**
     * Sets a theme, without a particular accent color.
     * @param theme Enum theme
     */
    public Style(Theme theme) {
        setTheme(theme);
    }

    /**
     * Sets a theme and a font.
     * @param theme Enum theme
     * @param fontName Font family name
     */
    public Style(Theme theme, String fontName) {
        font = new Font(fontName, Font.PLAIN, 18);
        setTheme(theme);
    }

    /**
     * Sets a theme with an accent color.
     * @param theme Enum theme
     * @param accentColor Enum color
     */
    public Style(Theme theme, AccentColor accentColor) {
        setTheme(theme);
        setAccentColor(accentColor);
    }

    /**
     * Sets a theme with an accent color and a specified font.
     * @param theme Enum theme
     * @param accentColor Enum color
     * @param fontName Font family
     */
    public Style(Theme theme, AccentColor accentColor, String fontName) {
        font = new Font(fontName, Font.PLAIN, 18);
        setTheme(theme);
        setAccentColor(accentColor);
    }

    /**
     * Sets the specified theme to this object
     * @param theme Enum theme
     */
    public void setTheme(Theme theme) {
        switch (theme) {
            case dark -> {
                backgroundColor = new Color(0x262626);
                panelColor = new Color(0x121212);
                buttonColor = new Color(0x707070);
                textBGColor = new Color(0x404040);
                foreground = new Color(0xECECEC);
            }
            case light -> {
                backgroundColor = new Color(0xeeeeee);
                panelColor = new Color(0xaaaaaa);
                buttonColor = new Color(0xffffff);
                textBGColor = new Color(0XCCCCCC);
                foreground = new Color(0x101010);
            }
        }
    }

    /**
     * Sets an accent color. Should be set after the theme.
     * @param ac Enum accent color
     */
    public void setAccentColor(AccentColor ac) {
        switch (ac) {
            case red -> buttonColor = new Color(0xFF5733);
            case yellow -> buttonColor = new Color(0xFFBD33);
            case lime -> buttonColor = new Color(0xDBFF33);
            case green -> buttonColor = new Color(0x75FF33);
            case sky_blue -> buttonColor = new Color(0x33FFBD);
            case blue -> buttonColor = new Color(0x1D7EFF);
            case purple -> buttonColor = new Color(0x5733FF);
            case pink -> buttonColor = new Color(0xFF1DEF);
        }
    }
}
