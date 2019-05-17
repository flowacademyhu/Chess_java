package Pieces;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Queen extends ChessPiece {
    public Queen(PieceColor color, int xLocation, int yLocation) {
        this.pieceColor = color;
        this.xLocation = xLocation;
        this.yLocation = yLocation;

        if (color == PieceColor.white) {
            img = new ImageIcon("img/White_queen.png");
        } else if (color == PieceColor.black) {
            img = new ImageIcon("img/Black_queen.png");
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
        if (dir.equals("North")) {
            validation("North", x, --y, labels, liveChessPieceList, setColor, checkMateList);
        }
        if (dir.equals("South")) {
            validation("South", x, ++y, labels, liveChessPieceList, setColor, checkMateList);
        }
        if (dir.equals("East")) {
            validation("East", --x, y, labels, liveChessPieceList, setColor, checkMateList);
        }
        if (dir.equals("West")) {
            validation("West", ++x, y, labels, liveChessPieceList, setColor, checkMateList);
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

        validation("North", x, --y, labels, liveChessPieceList, setColor, checkMateList);
        y = yLocation;
        validation("South", x, ++y, labels, liveChessPieceList, setColor, checkMateList);
        y = yLocation;
        validation("East", --x, y, labels, liveChessPieceList, setColor, checkMateList);
        x = xLocation;
        validation("West", ++x, y, labels, liveChessPieceList, setColor, checkMateList);
        x = xLocation;
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
