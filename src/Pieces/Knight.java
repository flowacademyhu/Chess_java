package Pieces;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.List;

public class Knight extends ChessPiece {


    public Knight(PieceColor color, int xLocation, int yLocation) {
        this.pieceColor = color;
        this.xLocation = xLocation;
        this.yLocation = yLocation;

        if (color == PieceColor.white) {
            img = new ImageIcon("img/White_knight.png");
        } else if (color == PieceColor.black) {
            img = new ImageIcon("img/Black_knight.png");
        }
    }

    @Override
    public void validMoveColor(
            int x, int y, JLabel[][] labels, List<ChessPiece> liveChessPieceList) {
        for (int i = 0; i < labels.length; i++) {
            for (int j = 0; j < labels.length; j++) {
                if (((j == x + 1 || j == x - 1) && (i == y + 2 || i == y - 2))
                        || ((j == x + 2 || j == x - 2) && (i == y + 1 || i == y - 1))) {
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
                }
            }
        }
    }


}
