package Dialogs;

import javax.swing.*;

public class WinnerDialog extends JDialog {

    public WinnerDialog(JFrame jFrame) {
        super(jFrame);
        JOptionPane.showMessageDialog(this, "You are the Chess's King!");
    }
}
