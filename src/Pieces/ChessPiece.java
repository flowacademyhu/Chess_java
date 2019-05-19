package Pieces;

import javax.swing.*;
import java.util.HashSet;
import java.util.List;

public abstract class ChessPiece {
    public enum PieceColor {
        white,
        black
    }

    protected ImageIcon img;
    protected int xLocation;
    protected int yLocation;
    protected PieceColor pieceColor;

    public abstract void validMoveColor(
            int x, int y, JLabel[][] labels, List<ChessPiece> liveChessPieceList);

    public PieceColor getPieceColor() {
        return pieceColor;
    }

    public void setPieceColor(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    public ImageIcon getImg() {
        return img;
    }

    public int getxLocation() {
        return xLocation;
    }

    public void setxLocation(int xLocation) {
        this.xLocation = xLocation;
    }

    public int getyLocation() {
        return yLocation;
    }

    public void setyLocation(int yLocation) {
        this.yLocation = yLocation;
    }
}
