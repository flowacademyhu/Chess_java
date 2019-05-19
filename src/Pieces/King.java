package Pieces;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
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
    public void validMoveColor(int x, int y, JLabel[][] labels, List<ChessPiece> liveChessPieceList) {
        for (int i = 0; i < labels.length; i++) {
            for (int j = 0; j < labels.length; j++) {
                if ((j == x + 1 || j == x - 1 || j == x)
                        && (i == y + 1 || i == y - 1 || i == y)
                        && !(j == x && i == y)) {
                    if (labels[i][j].getIcon() == null) {
                        labels[i][j].setBackground(Color.green);
                    }
                    for (ChessPiece liveChessPiece : liveChessPieceList) {
                        if (j == liveChessPiece.xLocation
                                && i == liveChessPiece.yLocation) {
                            if (liveChessPiece.getPieceColor() != this.pieceColor) {
                                labels[i][j].setBackground(Color.red);
                            }
                        }
                    }
                    labels[i][j].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.black));
                }
            }
        }
    }

    public void castlingColor(JLabel[][] labels, List<Rook> rookList, HashSet<String> checkMateList) {
        for (Rook rook : rookList) {
            if (!this.isMoved && labels[this.yLocation][5].getIcon() == null &&
                    labels[this.yLocation][6].getIcon() == null && rook.xLocation == 7 &&
                    rook.isMoved() == false && this.getPieceColor().equals(rook.getPieceColor()) &&
                    !(checkMateList.contains("4 " + getyLocation()) || checkMateList.contains("6 " + getyLocation()) ||
                            checkMateList.contains("5 " + getyLocation()))) {
                labels[getyLocation()][6].setBackground(Color.orange);
            }
            if (!this.isMoved && labels[this.yLocation][3].getIcon() == null &&
                    labels[this.yLocation][2].getIcon() == null && labels[this.yLocation][1].getIcon() == null && rook.xLocation == 0 &&
                    rook.isMoved() == false && this.getPieceColor().equals(rook.getPieceColor()) &&
                    !(checkMateList.contains("4 " + getyLocation()) || checkMateList.contains("3 " + getyLocation()) ||
                            checkMateList.contains("2 " + getyLocation()))) {
                labels[getyLocation()][2].setBackground(Color.orange);
            }
        }
    }
}
