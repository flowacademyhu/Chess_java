package FrontEnd.NorthPanelLabels;

import javax.swing.*;
import java.awt.*;

public class ColorLabel extends JLabel {
    public ColorLabel() {
        this.setText("WHITE'S TURN");
        this.setFont(new Font("Serif", Font.PLAIN, 25));
        this.setVerticalAlignment(SwingConstants.CENTER);
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setOpaque(true);
        this.setPreferredSize(new Dimension(400, 100));
    }
}
