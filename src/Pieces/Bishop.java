package Pieces;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Bishop extends ChessPiece {

    public Bishop(ChessPiece.PieceColor color, int xLocation, int yLocation) {
        this.pieceColor = color;
        this.xLocation = xLocation;
        this.yLocation = yLocation;

        if (color == ChessPiece.PieceColor.white) {
            img = new ImageIcon("img/White_bishop.png");
        } else if (color == ChessPiece.PieceColor.black) {
            img = new ImageIcon("img/Black_bishop.png");
        }
    }

    private void validation(
            String dir, int x, int y, JLabel[][] labels, List<ChessPiece> liveChessPieceList, boolean setColor, List<String> checkMateList) {
        if ((x > 7 || y > 7) || (x < 0 || y < 0)) {
            return;
        }
        for (int i = 0; i < liveChessPieceList.size(); i++) {
            if (x == liveChessPieceList.get(i).xLocation && y == liveChessPieceList.get(i).yLocation) {
                if (liveChessPieceList.get(i).getPieceColor() != this.pieceColor) {
                    if (setColor) {
                        labels[y][x].setBackground(Color.red);
                    } else if (!setColor) {
                        checkMateList.add(labels[y][x].getName());
                    }
                    return;
                } else if (liveChessPieceList.get(i).getPieceColor() == this.pieceColor) {
                    return;
                }
            }
        }
        if (labels[y][x].getIcon() == null) {
            if (setColor) {
                labels[y][x].setBackground(Color.green);
            } else if (!setColor) {
                checkMateList.add(labels[y][x].getName());
            }
        }
        if (dir.equals("NorthWest")) {
            validation("NorthWest", --x, --y, labels, liveChessPieceList, setColor, checkMateList);
        }
        if (dir.equals("SouthEast")) {
            validation("SouthEast", ++x, ++y, labels, liveChessPieceList, setColor, checkMateList);
        }
        if (dir.equals("SouthWest")) {
            validation("SouthWest", --x, ++y, labels, liveChessPieceList, setColor, checkMateList);
        }
        if (dir.equals("NorthEast")) {
            validation("NorthEast", ++x, --y, labels, liveChessPieceList, setColor, checkMateList);
        }
    }

    @Override
    public void isValidMove(
            int x, int y, JLabel[][] labels, List<ChessPiece> liveChessPieceList, boolean setColor, List<String> checkMateList) {
        validation("NorthWest", --x, --y, labels, liveChessPieceList, setColor, checkMateList);
        y = yLocation;
        x = xLocation;
        validation("SouthEast", ++x, ++y, labels, liveChessPieceList, setColor, checkMateList);
        y = yLocation;
        x = xLocation;
        validation("SouthWest", --x, ++y, labels, liveChessPieceList, setColor, checkMateList);
        y = yLocation;
        x = xLocation;
        validation("NorthEast", ++x, --y, labels, liveChessPieceList, setColor, checkMateList);
    }
}
