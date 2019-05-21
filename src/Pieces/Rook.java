package Pieces;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Rook extends ChessPiece {
    private boolean isMoved = false;

    public boolean isMoved() {
        return isMoved;
    }

    public void setMoved(boolean moved) {
        isMoved = moved;
    }

    public Rook(ChessPiece.PieceColor color, int xLocation, int yLocation) {
        this.pieceColor = color;
        this.xLocation = xLocation;
        this.yLocation = yLocation;

        if (color == ChessPiece.PieceColor.white) {
            img = new ImageIcon("img/White_rook.png");
        } else if (color == ChessPiece.PieceColor.black) {
            img = new ImageIcon("img/Black_rook.png");
        }
    }

    private void validation(String dir, int x, int y, JLabel[][] labels, List<ChessPiece> liveChessPieceList) {
        if ((x > 7 || y > 7) || (x < 0 || y < 0)) {
            return;
        }
        for (ChessPiece liveChessPiece : liveChessPieceList) {
            if (x == liveChessPiece.xLocation && y == liveChessPiece.yLocation) {
                if (liveChessPiece.getPieceColor() != this.pieceColor) {
                    labels[y][x].setBackground(Color.red);
                    return;
                } else if (liveChessPiece.getPieceColor() == this.pieceColor) {
                    return;
                }
            }
        }
        if (labels[y][x].getIcon() == null) {
            labels[y][x].setBackground(Color.green);
            labels[y][x].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.black));
        }
        if (dir.equals("North")) {
            validation("North", x, --y, labels, liveChessPieceList);
        }
        if (dir.equals("South")) {
            validation("South", x, ++y, labels, liveChessPieceList);
        }
        if (dir.equals("East")) {
            validation("East", --x, y, labels, liveChessPieceList);
        }
        if (dir.equals("West")) {
            validation("West", ++x, y, labels, liveChessPieceList);
        }
    }

    @Override
    public void validMoveColor(int x, int y, JLabel[][] labels, List<ChessPiece> liveChessPieceList) {

        validation("North", x, --y, labels, liveChessPieceList);
        y = yLocation;
        validation("South", x, ++y, labels, liveChessPieceList);
        y = yLocation;
        validation("East", --x, y, labels, liveChessPieceList);
        x = xLocation;
        validation("West", ++x, y, labels, liveChessPieceList);
    }
}
