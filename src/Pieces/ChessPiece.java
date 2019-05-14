package Pieces;

import javax.swing.*;
import java.util.List;

public abstract class ChessPiece {
    public enum PieceColor {
        white,
        black
    }

    protected ImageIcon Img;
    protected int xLocation;
    protected int yLocation;
    protected PieceColor pieceColor;

    public abstract JLabel[][] isValidMove(
            int x, int y, JLabel[][] labels, List<ChessPiece> liveChessPieceList);

    public PieceColor getPieceColor() {
        return pieceColor;
    }

    public void setPieceColor(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    public ImageIcon getImg() {
        return Img;
    }

    public void setImg(ImageIcon img) {
        Img = img;
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
