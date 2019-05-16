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

    public void castling(JLabel[][] labels, List<Rook> rookList) {
        System.out.println("cica");
        System.out.println(labels[this.yLocation][6].getIcon());
        for (int i = 0; i < rookList.size(); i++) {
            if (!this.isMoved && this.xLocation == 4 && labels[this.yLocation][5].getIcon() == null &&
                    labels[this.yLocation][6].getIcon() == null && rookList.get(i).xLocation == 7 &&
                    rookList.get(i).isMoved() == false && this.getPieceColor().equals(rookList.get(i).getPieceColor())) {
                labels[getyLocation()][6].setBackground(Color.orange);
                System.out.println("cica");
            }
        }

    }
}
