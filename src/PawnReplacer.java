import Pieces.ChessPiece;
import Pieces.Pawn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class PawnReplacer extends JDialog implements MouseListener {

    private List<ChessPiece> liveChessPieceList;
    private List<ChessPiece> deadChessPieceList;
    private JLabel[][] labels;
    ChessPiece piece;

    public PawnReplacer(List<ChessPiece> liveChessPieceList, List<ChessPiece> deadChessPieceList, JLabel[][] labels) {
        this.liveChessPieceList = liveChessPieceList;
        this.deadChessPieceList = deadChessPieceList;
        this.labels = labels;
        this.setLayout(new FlowLayout());
        this.setTitle("Pawn Replacer");
    }

    public void setWhitePawnReplacerDialog() {
        int counterNumberOfPieces = 0;
        for (int j = 0; j < deadChessPieceList.size(); j++) {
            if (deadChessPieceList.get(j).getPieceColor() == ChessPiece.PieceColor.white && !(deadChessPieceList.get(j) instanceof Pawn)) {
                JLabel label = new JLabel();
                label.setName(deadChessPieceList.get(j).getImg().toString());
                label.setIcon(deadChessPieceList.get(j).getImg());
                label.setOpaque(true);
                label.addMouseListener(this);
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setVerticalAlignment(JLabel.CENTER);
                this.add(label);
                counterNumberOfPieces++;
            }
        }
        if (counterNumberOfPieces != 0) {
            this.setSize(counterNumberOfPieces * 125, 125);
            this.setVisible(true);
        }
    }

    public void setBlackPawnReplacerDialog() {
        int counterNumberOfPieces = 0;
        for (int j = 0; j < deadChessPieceList.size(); j++) {
            if (deadChessPieceList.get(j).getPieceColor() == ChessPiece.PieceColor.black && !(deadChessPieceList.get(j) instanceof Pawn)) {

                JLabel label = new JLabel();
                label.setName(deadChessPieceList.get(j).getImg().toString());
                label.setIcon(deadChessPieceList.get(j).getImg());
                label.setOpaque(true);
                label.addMouseListener(this);
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setVerticalAlignment(JLabel.CENTER);
                this.add(label);
                counterNumberOfPieces++;
            }
        }
        if (counterNumberOfPieces != 0) {
            this.setSize(counterNumberOfPieces * 125, 125);
            this.setVisible(true);
        }
    }


    public void setDeadChessPieceToLive(MouseEvent e) {
        for (int i = 0; i < liveChessPieceList.size(); i++) {
            piece = liveChessPieceList.get(i);
            if (piece instanceof Pawn && (piece.getyLocation() == 0 || piece.getyLocation() == 7)) {
                labels[piece.getyLocation()][piece.getxLocation()].setIcon(((JLabel) e.getSource()).getIcon());
                deadChessPieceList.add(liveChessPieceList.remove(i));
                break;
            }
        }
    }

    public void setLiveChessPieceToDead(MouseEvent e) {
        for (int i = 0; i < deadChessPieceList.size(); i++) {
            if (deadChessPieceList.get(i).getImg().toString().equals(((JLabel) e.getSource()).getName())) {
                deadChessPieceList.get(i).setyLocation(piece.getyLocation());
                deadChessPieceList.get(i).setxLocation(piece.getxLocation());
                liveChessPieceList.add(deadChessPieceList.remove(i));
                break;
            }
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() instanceof JLabel) {
            setDeadChessPieceToLive(e);
            setLiveChessPieceToDead(e);
            this.dispose();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
