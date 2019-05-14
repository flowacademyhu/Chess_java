package Pieces;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class King extends ChessPiece {
    public King(PieceColor color, int xLocation, int yLocation) {
        this.pieceColor = color;
        this.xLocation = xLocation;
        this.yLocation = yLocation;

        if (color == PieceColor.white) {
            Img = new ImageIcon("img/White_king.png");
        } else if (color == PieceColor.black) {
            Img = new ImageIcon("img/Black_king.png");
        }
    }

    @Override
    public JLabel[][] isValidMove(
            int x, int y, JLabel[][] labels, List<ChessPiece> liveChessPieceList) {
        for (int i = 0; i < labels.length; i++) {
            for (int j = 0; j < labels.length; j++) {
                if ((j == x + 1 || j == x - 1 || j == x)
                        && (i == y + 1 || i == y - 1 || i == y)
                        && !(j == x && i == y)) {
                    for (int k = 0; k < liveChessPieceList.size(); k++) {
                        if (labels[i][j].getIcon() == null) {
                            labels[i][j].setBackground(Color.green);
                        } else if (j == liveChessPieceList.get(k).xLocation
                                && i == liveChessPieceList.get(k).yLocation) {
                            if (liveChessPieceList.get(k).getPieceColor() != this.pieceColor) {
                                labels[i][j].setBackground(Color.red);
                            }
                        }
                    }
                    labels[i][j].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.black));
                }
            }
        }
        return labels;
    }
}
