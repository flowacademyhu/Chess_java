package FrontEnd;

import FrontEnd.NorthPanelLabels.BlackTimerLabel;
import FrontEnd.NorthPanelLabels.ColorLabel;
import FrontEnd.NorthPanelLabels.WhiteTimerLabel;
import Main.Board;

import javax.swing.*;
import java.awt.*;

public class NorthPanel extends JPanel {
    public JLabel whiteTimerLabel;
    public JLabel blackTimerLabel;
    public JLabel colorLabel;
    public Thread threadTimer;
    public int whiteTimerValue;
    public int blackTimerValue;

    public NorthPanel() {
        whiteTimerLabel = new WhiteTimerLabel();
        blackTimerLabel = new BlackTimerLabel();
        colorLabel = new ColorLabel();

        whiteTimerLabel.setVisible(false);
        blackTimerLabel.setVisible(false);
        this.setPreferredSize(new Dimension(0, 100));
        this.setLayout(new FlowLayout());
        this.add(whiteTimerLabel);
        this.add(colorLabel);
        this.add(blackTimerLabel);
    }

    public void timer(Board board) {

        threadTimer = new Thread(() -> {

            while (true) {
                if (board.isBlackTurn) {
                    if (blackTimerValue > 9) {
                        blackTimerLabel.setText("0:" + blackTimerValue);
                    } else {
                        blackTimerLabel.setText("0:0" + blackTimerValue);
                    }
                    blackTimerValue--;
                } else {
                    if (whiteTimerValue > 9) {
                        whiteTimerLabel.setText("0:" + whiteTimerValue);
                    } else {
                        whiteTimerLabel.setText("0:0" + whiteTimerValue);
                    }
                    whiteTimerValue--;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
                if (whiteTimerValue == -1) {
                    board.setBlackTurn(!board.isBlackTurn);
                    whiteTimerValue = 0;
                    board.setupBoardColor();
                    colorLabel.setText("BLACK'S TURN");
                    blackTimerValue += 10;
                } else if (blackTimerValue == -1) {
                    board.setBlackTurn(!board.isBlackTurn);
                    blackTimerValue = 0;
                    board.setupBoardColor();
                    colorLabel.setText("WHITE'S TURN");
                    whiteTimerValue += 10;
                }
            }
        });
        threadTimer.start();
    }

    public void setTimerAfterMove(Board board) {

        if (board.isBlackTurn) {
            if (blackTimerValue == 0) {
                blackTimerValue += 10;
            } else {
                blackTimerValue += 11;
            }
            colorLabel.setText("BLACK'S TURN");

        } else {
            if (whiteTimerValue == 0) {
                whiteTimerValue += 10;
            } else {
                whiteTimerValue += 11;
            }
            colorLabel.setText("WHITE'S TURN");
        }

    }
}
