package Pieces;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Pawn extends ChessPiece {

    public Pawn(ChessPiece.PieceColor color, int xLocation, int yLocation) {
        this.pieceColor = color;
        this.xLocation = xLocation;
        this.yLocation = yLocation;

        if (color == ChessPiece.PieceColor.white) {
            img = new ImageIcon("img/White_pawn.png");
        } else if (color == ChessPiece.PieceColor.black) {
            img = new ImageIcon("img/Black_pawn.png");
        }
    }

    @Override
    public void validMoveColor(
            int x, int y, JLabel[][] labels, List<ChessPiece> liveChessPieceList) {

        if (this.pieceColor == PieceColor.white) {
            if (this.yLocation == 6 && labels[this.yLocation - 2][this.xLocation].getIcon() == null
                    && labels[this.yLocation - 1][this.xLocation].getIcon() == null) {
                labels[this.yLocation - 2][this.xLocation].setBackground(Color.green);
            }
            for (int i = 0; i < labels.length; i++) {
                for (int j = 0; j < labels.length; j++) {
                    if (i == y - 1 && j == x) {
                        if (labels[i][j].getIcon() == null) {
                            labels[i][j].setBackground(Color.green);
                        }
                    } else if (i == y - 1 && j == x + 1 || i == y - 1 && j == x - 1) {
                        for (ChessPiece liveChessPiece : liveChessPieceList) {
                            if (j == liveChessPiece.xLocation && i == liveChessPiece.yLocation) {
                                if (liveChessPiece.getPieceColor() != this.pieceColor) {
                                    labels[i][j].setBackground(Color.red);
                                }
                            }
                        }
                    }
                    if (this.yLocation == 6) {
                        labels[i][j].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.black));
                    }
                }
            }

        } else if (this.pieceColor == PieceColor.black) {

            if (this.yLocation == 1 && labels[this.yLocation + 2][this.xLocation].getIcon() == null && labels[this.yLocation + 1][this.xLocation].getIcon() == null) {
                labels[this.yLocation + 2][this.xLocation].setBackground(Color.green);
            }
            for (int i = 0; i < labels.length; i++) {
                for (int j = 0; j < labels.length; j++) {
                    if (i == y + 1 && j == x) {
                        if (labels[i][j].getIcon() == null) {
                            labels[i][j].setBackground(Color.green);
                        }
                    } else if (i == y + 1 && j == x + 1 || i == y + 1 && j == x - 1) {
                        for (ChessPiece liveChessPiece : liveChessPieceList) {
                            if (j == liveChessPiece.xLocation
                                    && i == liveChessPiece.yLocation) {
                                if (liveChessPiece.getPieceColor() != this.pieceColor) {
                                    labels[i][j].setBackground(Color.red);
                                }
                            }
                        }
                    }
                    if (this.yLocation == 1) {
                        labels[i][j].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.black));
                    }
                }
            }
        }
    }

    public void checkMateColor(JLabel[][] labels) {
        for (int i = 0; i < labels.length; i++) {
            for (int j = 0; j < labels.length; j++) {
                if (this.pieceColor == PieceColor.black) {
                    if (i == yLocation + 1 && j == xLocation + 1 || i == yLocation + 1 && j == xLocation - 1) {
                        labels[i][j].setBackground(Color.green);
                    }
                } else if (this.pieceColor == PieceColor.white) {
                    if (i == yLocation - 1 && j == xLocation + 1 || i == yLocation - 1 && j == xLocation - 1) {
                        labels[i][j].setBackground(Color.green);
                    }
                }
            }
        }
    }
}
