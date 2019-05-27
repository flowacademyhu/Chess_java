import javax.swing.*;

public class MenuBar extends JMenuBar {
    private final JMenu fileMenu;
    private final JMenu modeMenu;
    private final JMenuItem normalModeMenuItem;
    private final JMenuItem tournamentModeMenuItem;
    private final JMenuItem trollGameMenuItem;
    private final JMenuItem newGameMenuItem;
    private final JMenuItem exitMenuItem;
    private final JMenuItem saveMenuItem;
    private final JMenuItem openMenuItem;

    public JMenu getFileMenu() {
        return fileMenu;
    }

    public JMenu getModeMenu() {
        return modeMenu;
    }

    public JMenuItem getNormalModeMenuItem() {
        return normalModeMenuItem;
    }

    public JMenuItem getTournamentModeMenuItem() {
        return tournamentModeMenuItem;
    }

    public JMenuItem getTrollGameMenuItem() {
        return trollGameMenuItem;
    }

    public JMenuItem getNewGameMenuItem() {
        return newGameMenuItem;
    }

    public JMenuItem getExitMenuItem() {
        return exitMenuItem;
    }

    public JMenuItem getSaveMenuItem() {
        return saveMenuItem;
    }

    public JMenuItem getOpenMenuItem() {
        return openMenuItem;
    }

    public MenuBar() {
        fileMenu = new JMenu("File");
        modeMenu = new JMenu("Modes");
        newGameMenuItem = new JMenuItem("New Game");
        saveMenuItem = new JMenuItem("Save Game");
        openMenuItem = new JMenuItem("Open Game");
        exitMenuItem = new JMenuItem("Exit");
        tournamentModeMenuItem = new JMenuItem("Tournament");
        normalModeMenuItem = new JMenuItem("Normal");
        trollGameMenuItem = new JMenuItem("Cats vs. Dogs");

        this.add(fileMenu);
        this.add(modeMenu);
        fileMenu.add(newGameMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(exitMenuItem);
        modeMenu.add(normalModeMenuItem);
        modeMenu.add(tournamentModeMenuItem);
        modeMenu.add(trollGameMenuItem);
    }
}
