package FrontEnd.NorthPanelPackage.Labels;

import javax.swing.*;
import java.awt.*;

public class WhiteTimerLabel extends JLabel {
    public WhiteTimerLabel() {
        this.setText("0:10");
        this.setFont(new Font("Serif", Font.PLAIN, 30));
        this.setVerticalAlignment(SwingConstants.CENTER);
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setOpaque(true);
        this.setPreferredSize(new Dimension(250, 100));
    }
}
