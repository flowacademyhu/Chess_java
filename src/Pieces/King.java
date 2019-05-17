package Pieces;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class King extends ChessPiece {
    private boolean isMoved = false;

    public boolean isMoved() {
        return isMoved;
    }

    public void setMoved(boolean moved) {
        isMoved = moved;
    }

    public King(PieceColor color, int xLocation, int yLocation) {
        this.pieceColor = color;
        this.xLocation = xLocation;
        this.yLocation = yLocation;

        if (color == PieceColor.white) {
            img = new ImageIcon("img/White_king.png");
        } else if (color == PieceColor.black) {
            img = new ImageIcon("img/Black_king.png");
        }
    }

    @Override
    public void isValidMove(
            int x, int y, JLabel[][] labels, List<ChessPiece> liveChessPieceList, boolean setColor, List<String> checkMateList) {
        for (int i = 0; i < labels.length; i++) {
            for (int j = 0; j < labels.length; j++) {
                if ((j == x + 1 || j == x - 1 || j == x)
                        && (i == y + 1 || i == y - 1 || i == y)
                        && !(j == x && i == y)) {
                    for (int k = 0; k < liveChessPieceList.size(); k++) {
                        if (labels[i][j].getIcon() == null) {
                            if (setColor) {
                                labels[i][j].setBackground(Color.green);
                            } else if (!setColor) {
                                checkMateList.add(labels[i][j].getName());
                            }
                        } else if (j == liveChessPieceList.get(k).xLocation
                                && i == liveChessPieceList.get(k).yLocation) {
                            if (liveChessPieceList.get(k).getPieceColor() != this.pieceColor) {
                                if (setColor) {
                                    labels[i][j].setBackground(Color.red);
                                } else if (!setColor) {
                                    checkMateList.add(labels[i][j].getName());
                                }
                            }
                        }
                    }
                    if (setColor) {
                        labels[i][j].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.black));
                    }
                }
            }
        }
    }

    public void castling(JLabel[][] labels, List<Rook> rookList) {
        for (int i = 0; i < rookList.size(); i++) {
            if (!this.isMoved && this.xLocation == 4 && labels[this.yLocation][5].getIcon() == null &&
                    labels[this.yLocation][6].getIcon() == null && rookList.get(i).xLocation == 7 &&
                    rookList.get(i).isMoved() == false && this.getPieceColor().equals(rookList.get(i).getPieceColor())) {
                labels[getyLocation()][6].setBackground(Color.orange);
            }
            if (!this.isMoved && this.xLocation == 4 && labels[this.yLocation][3].getIcon() == null &&
                    labels[this.yLocation][2].getIcon() == null && labels[this.yLocation][1].getIcon() == null && rookList.get(i).xLocation == 0 &&
                    rookList.get(i).isMoved() == false && this.getPieceColor().equals(rookList.get(i).getPieceColor())) {
                labels[getyLocation()][2].setBackground(Color.orange);
            }
        }

    }

//    public void ()
}
