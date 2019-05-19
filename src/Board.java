import Pieces.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Board extends JFrame implements MouseListener {

    private JLabel[][] labels;
    private int boardSize;
    private int boardLocationX;
    private int boardLocationY;
    private ChessPiece chosenPiece;
    private JLabel chosenLabel;
    private boolean isMoved;
    private boolean isBlackTurn = false;
    private List<ChessPiece> liveChessPieceList = new ArrayList<>();
    private List<ChessPiece> deadChessPieceList = new ArrayList<>();
    private HashSet<String> checkMateList;

    private King blackKing = new King(ChessPiece.PieceColor.black, 4, 0);
    private King whiteKing = new King(ChessPiece.PieceColor.white, 4, 7);
    private Pawn whitePawn0 = new Pawn(ChessPiece.PieceColor.white, 0, 6);
    private Pawn whitePawn1 = new Pawn(ChessPiece.PieceColor.white, 1, 6);
    private Pawn whitePawn2 = new Pawn(ChessPiece.PieceColor.white, 2, 6);
    private Pawn whitePawn3 = new Pawn(ChessPiece.PieceColor.white, 3, 6);
    private Pawn whitePawn4 = new Pawn(ChessPiece.PieceColor.white, 4, 6);
    private Pawn whitePawn5 = new Pawn(ChessPiece.PieceColor.white, 5, 6);
    private Pawn whitePawn6 = new Pawn(ChessPiece.PieceColor.white, 6, 6);
    private Pawn whitePawn7 = new Pawn(ChessPiece.PieceColor.white, 7, 6);
    private Pawn blackPawn0 = new Pawn(ChessPiece.PieceColor.black, 0, 1);
    private Pawn blackPawn1 = new Pawn(ChessPiece.PieceColor.black, 1, 1);
    private Pawn blackPawn2 = new Pawn(ChessPiece.PieceColor.black, 2, 1);
    private Pawn blackPawn3 = new Pawn(ChessPiece.PieceColor.black, 3, 1);
    private Pawn blackPawn4 = new Pawn(ChessPiece.PieceColor.black, 4, 1);
    private Pawn blackPawn5 = new Pawn(ChessPiece.PieceColor.black, 5, 1);
    private Pawn blackPawn6 = new Pawn(ChessPiece.PieceColor.black, 6, 1);
    private Pawn blackPawn7 = new Pawn(ChessPiece.PieceColor.black, 7, 1);
    private Rook blackRook0 = new Rook(ChessPiece.PieceColor.black, 0, 0);
    private Rook blackRook1 = new Rook(ChessPiece.PieceColor.black, 7, 0);
    private Rook whiteRook0 = new Rook(ChessPiece.PieceColor.white, 0, 7);
    private Rook whiteRook1 = new Rook(ChessPiece.PieceColor.white, 7, 7);
    private Knight blackKnight0 = new Knight(ChessPiece.PieceColor.black, 1, 0);
    private Knight blackKnight1 = new Knight(ChessPiece.PieceColor.black, 6, 0);
    private Knight whiteKnight0 = new Knight(ChessPiece.PieceColor.white, 1, 7);
    private Knight whiteKnight1 = new Knight(ChessPiece.PieceColor.white, 6, 7);
    private Bishop whiteBishop0 = new Bishop(ChessPiece.PieceColor.white, 2, 7);
    private Bishop whiteBishop1 = new Bishop(ChessPiece.PieceColor.white, 5, 7);
    private Bishop blackBishop0 = new Bishop(ChessPiece.PieceColor.black, 2, 0);
    private Bishop blackBishop1 = new Bishop(ChessPiece.PieceColor.black, 5, 0);
    private Queen blackQueen = new Queen(ChessPiece.PieceColor.black, 3, 0);
    private Queen whiteQueen = new Queen(ChessPiece.PieceColor.white, 3, 7);


    public Board() throws HeadlessException {
        this.boardSize = 8;
        liveChessPieceList.add(blackKing);
        liveChessPieceList.add(whiteKing);
        liveChessPieceList.add(whitePawn0);
        liveChessPieceList.add(whitePawn1);
        liveChessPieceList.add(whitePawn2);
        liveChessPieceList.add(whitePawn3);
        liveChessPieceList.add(whitePawn4);
        liveChessPieceList.add(whitePawn5);
        liveChessPieceList.add(whitePawn6);
        liveChessPieceList.add(whitePawn7);
        liveChessPieceList.add(blackPawn0);
        liveChessPieceList.add(blackPawn1);
        liveChessPieceList.add(blackPawn2);
        liveChessPieceList.add(blackPawn3);
        liveChessPieceList.add(blackPawn4);
        liveChessPieceList.add(blackPawn5);
        liveChessPieceList.add(blackPawn6);
        liveChessPieceList.add(blackPawn7);
        liveChessPieceList.add(whiteRook0);
        liveChessPieceList.add(whiteRook1);
        liveChessPieceList.add(blackRook0);
        liveChessPieceList.add(blackRook1);
        liveChessPieceList.add(whiteKnight0);
        liveChessPieceList.add(whiteKnight1);
        liveChessPieceList.add(blackKnight0);
        liveChessPieceList.add(blackKnight1);
        liveChessPieceList.add(whiteBishop0);
        liveChessPieceList.add(whiteBishop1);
        liveChessPieceList.add(blackBishop0);
        liveChessPieceList.add(blackBishop1);
        liveChessPieceList.add(whiteQueen);
        liveChessPieceList.add(blackQueen);

        setSize(1080, 1080);
        setTitle("Simon's Chess");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GridLayout gridLayout = new GridLayout(boardSize, boardSize);
        labels = new JLabel[boardSize][boardSize];
        setLayout(gridLayout);
        SetupBoard();
        setupColor();
        SetupIcons();
        addMouseListener(this);
        setVisible(true);
    }


    public void SetupIcons() {
        labels[blackKing.getyLocation()][blackKing.getxLocation()].setIcon(blackKing.getImg());
        labels[whiteKing.getyLocation()][whiteKing.getxLocation()].setIcon(whiteKing.getImg());
        labels[whitePawn0.getyLocation()][whitePawn0.getxLocation()].setIcon(whitePawn0.getImg());
        labels[whitePawn1.getyLocation()][whitePawn1.getxLocation()].setIcon(whitePawn1.getImg());
        labels[whitePawn2.getyLocation()][whitePawn2.getxLocation()].setIcon(whitePawn2.getImg());
        labels[whitePawn3.getyLocation()][whitePawn3.getxLocation()].setIcon(whitePawn3.getImg());
        labels[whitePawn4.getyLocation()][whitePawn4.getxLocation()].setIcon(whitePawn4.getImg());
        labels[whitePawn5.getyLocation()][whitePawn5.getxLocation()].setIcon(whitePawn5.getImg());
        labels[whitePawn6.getyLocation()][whitePawn6.getxLocation()].setIcon(whitePawn6.getImg());
        labels[whitePawn7.getyLocation()][whitePawn7.getxLocation()].setIcon(whitePawn7.getImg());
        labels[blackPawn0.getyLocation()][blackPawn0.getxLocation()].setIcon(blackPawn0.getImg());
        labels[blackPawn1.getyLocation()][blackPawn1.getxLocation()].setIcon(blackPawn1.getImg());
        labels[blackPawn2.getyLocation()][blackPawn2.getxLocation()].setIcon(blackPawn2.getImg());
        labels[blackPawn3.getyLocation()][blackPawn3.getxLocation()].setIcon(blackPawn3.getImg());
        labels[blackPawn4.getyLocation()][blackPawn4.getxLocation()].setIcon(blackPawn4.getImg());
        labels[blackPawn5.getyLocation()][blackPawn5.getxLocation()].setIcon(blackPawn5.getImg());
        labels[blackPawn6.getyLocation()][blackPawn6.getxLocation()].setIcon(blackPawn6.getImg());
        labels[blackPawn7.getyLocation()][blackPawn7.getxLocation()].setIcon(blackPawn7.getImg());
        labels[blackRook0.getyLocation()][blackRook0.getxLocation()].setIcon(blackRook0.getImg());
        labels[blackRook1.getyLocation()][blackRook1.getxLocation()].setIcon(blackRook1.getImg());
        labels[whiteRook0.getyLocation()][whiteRook0.getxLocation()].setIcon(whiteRook0.getImg());
        labels[whiteRook1.getyLocation()][whiteRook1.getxLocation()].setIcon(whiteRook1.getImg());
        labels[whiteKnight0.getyLocation()][whiteKnight0.getxLocation()].setIcon(whiteKnight0.getImg());
        labels[whiteKnight1.getyLocation()][whiteKnight1.getxLocation()].setIcon(whiteKnight1.getImg());
        labels[blackKnight0.getyLocation()][blackKnight0.getxLocation()].setIcon(blackKnight0.getImg());
        labels[blackKnight1.getyLocation()][blackKnight1.getxLocation()].setIcon(blackKnight1.getImg());
        labels[whiteBishop0.getyLocation()][whiteBishop0.getxLocation()].setIcon(whiteBishop0.getImg());
        labels[whiteBishop1.getyLocation()][whiteBishop1.getxLocation()].setIcon(whiteBishop1.getImg());
        labels[blackBishop0.getyLocation()][blackBishop0.getxLocation()].setIcon(blackBishop0.getImg());
        labels[blackBishop0.getyLocation()][blackBishop1.getxLocation()].setIcon(blackBishop1.getImg());
        labels[whiteQueen.getyLocation()][whiteQueen.getxLocation()].setIcon(whiteQueen.getImg());
        labels[blackQueen.getyLocation()][blackQueen.getxLocation()].setIcon(blackQueen.getImg());
    }

    public void SetupBoard() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                labels[i][j] = new JLabel();
                labels[i][j].setName(j + " " + i);
                add(labels[i][j]);
                labels[i][j].addMouseListener(this);
                labels[i][j].setOpaque(true);
                labels[i][j].setHorizontalAlignment(JLabel.CENTER);
                labels[i][j].setVerticalAlignment(JLabel.CENTER);
            }
        }
    }

    public void setupColor() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        labels[i][j].setBackground(Color.white);
                    } else {
                        labels[i][j].setBackground(Color.darkGray);
                    }
                } else {
                    if (j % 2 == 1) {
                        labels[i][j].setBackground(Color.white);
                    } else {
                        labels[i][j].setBackground(Color.darkGray);
                    }
                }
            }
        }
    }

    private void kingCastlingColor() {
        if (chosenPiece instanceof King && ((isBlackTurn && chosenPiece.getPieceColor().equals(ChessPiece.PieceColor.black)) ||
                (!isBlackTurn && chosenPiece.getPieceColor().equals(ChessPiece.PieceColor.white)))) {
            List<Rook> rookList = new ArrayList<>();
            for (int j = 0; j < liveChessPieceList.size(); j++) {
                if (liveChessPieceList.get(j) instanceof Rook) {
                    rookList.add((Rook) liveChessPieceList.get(j));
                }
            }
            ((King) chosenPiece).castling(labels, rookList);
        }
    }

    private void executeCastling(JLabel label) {
        if (label.getBackground() == Color.orange) {
            for (int i = 0; i < liveChessPieceList.size(); i++) {
                if (boardLocationX == 6 && liveChessPieceList.get(i) instanceof Rook && liveChessPieceList.get(i).getPieceColor().equals(chosenPiece.getPieceColor())
                        && liveChessPieceList.get(i).getxLocation() == 7) {
                    labels[liveChessPieceList.get(i).getyLocation()][liveChessPieceList.get(i).getxLocation()].setIcon(null);
                    labels[chosenPiece.getyLocation()][5].setIcon(liveChessPieceList.get(i).getImg());
                    liveChessPieceList.get(i).setyLocation(chosenPiece.getyLocation());
                    liveChessPieceList.get(i).setxLocation(5);
                    break;
                } else if (boardLocationX == 2 && liveChessPieceList.get(i) instanceof Rook && liveChessPieceList.get(i).getPieceColor().equals(chosenPiece.getPieceColor())
                        && liveChessPieceList.get(i).getxLocation() == 0) {
                    labels[liveChessPieceList.get(i).getyLocation()][liveChessPieceList.get(i).getxLocation()].setIcon(null);
                    labels[chosenPiece.getyLocation()][3].setIcon(liveChessPieceList.get(i).getImg());
                    liveChessPieceList.get(i).setyLocation(chosenPiece.getyLocation());
                    liveChessPieceList.get(i).setxLocation(3);
                    break;
                }
            }
        }
    }

    private void executeMove(JLabel label) {
        if (label.getBackground() == Color.green || label.getBackground() == Color.red || label.getBackground() == Color.orange) {
            label.setIcon(chosenPiece.getImg());
            chosenPiece.setxLocation(boardLocationX);
            chosenPiece.setyLocation(boardLocationY);
            isMoved = true;
            chosenLabel.setIcon(null);
        }
    }

    private void chessPieceKnock(JLabel label) {
        if (label.getBackground() == Color.red) {
            label.setIcon(null);
            for (int i = 0; i < liveChessPieceList.size(); i++) {
                if (liveChessPieceList.get(i).getxLocation() == boardLocationX
                        && liveChessPieceList.get(i).getyLocation() == boardLocationY) {
                    liveChessPieceList.get(i).setyLocation(-1);
                    liveChessPieceList.get(i).setxLocation(-1);
                    deadChessPieceList.add(liveChessPieceList.remove(i));
                }
            }
        }

    }

    private void checkMateList() {
        checkMateList = new HashSet<>();

        for (ChessPiece chessPiece : liveChessPieceList) {
            if (chessPiece instanceof Pawn) {
                if (isBlackTurn && chessPiece.getPieceColor().equals(ChessPiece.PieceColor.black)) {
                    ((Pawn) chessPiece).checkMateColor(labels, liveChessPieceList);
                } else if (!isBlackTurn && chessPiece.getPieceColor().equals(ChessPiece.PieceColor.white)) {
                    ((Pawn) chessPiece).checkMateColor(labels, liveChessPieceList);
                }
            } else {
                if (isBlackTurn && chessPiece.getPieceColor().equals(ChessPiece.PieceColor.black)) {
                    chessPiece.validMoveColor(chessPiece.getxLocation(), chessPiece.getyLocation(), labels, liveChessPieceList);
                } else if (!isBlackTurn && chessPiece.getPieceColor().equals(ChessPiece.PieceColor.white)) {
                    chessPiece.validMoveColor(chessPiece.getxLocation(), chessPiece.getyLocation(), labels, liveChessPieceList);
                }
            }
        }

        for (int i = 0; i < labels.length; i++) {
            for (int j = 0; j < labels.length; j++) {
                if (labels[i][j].getBackground().equals(Color.red) || labels[i][j].getBackground().equals(Color.green)) {
                    checkMateList.add(labels[i][j].getName());
                }
            }
        }
        setupColor();
        for (String checkMate : checkMateList) {
            String[] checkMateLocations = checkMate.split(" ");
            if (!isBlackTurn) {
                if (Integer.parseInt(checkMateLocations[0]) == blackKing.getxLocation() && Integer.parseInt(checkMateLocations[1]) == blackKing.getyLocation()) {
                    labels[blackKing.getyLocation()][blackKing.getxLocation()].setBackground(new Color(255, 0, 0));

                }
            } else {
                if (Integer.parseInt(checkMateLocations[0]) == whiteKing.getxLocation() && Integer.parseInt(checkMateLocations[1]) == whiteKing.getyLocation()) {
                    labels[whiteKing.getyLocation()][whiteKing.getxLocation()].setBackground(new Color(255, 0, 0));
                }
            }


        }
    }


    private void moveControl(JLabel label) {

        chessPieceKnock(label);

        executeCastling(label);

        executeMove(label);

        setupColor();

        if (!isMoved) {

            for (int i = 0; i < liveChessPieceList.size(); i++) {
                if (liveChessPieceList.get(i).getxLocation() == boardLocationX
                        && liveChessPieceList.get(i).getyLocation() == boardLocationY) {
                    this.chosenPiece = liveChessPieceList.get(i);
                    if (isBlackTurn && chosenPiece.getPieceColor() == ChessPiece.PieceColor.white
                            || !isBlackTurn && chosenPiece.getPieceColor() == ChessPiece.PieceColor.black) {
                        break;
                    }
                    chosenPiece.validMoveColor(boardLocationX, boardLocationY, labels, liveChessPieceList);
                    this.chosenLabel = label;
                }
            }
            kingCastlingColor();


        } else if (isMoved) {

            if (chosenPiece instanceof Rook) {
                ((Rook) chosenPiece).setMoved(true);
            } else if (chosenPiece instanceof King) {
                ((King) chosenPiece).setMoved(true);
            }
            setupColor();

            checkMateList();

            isBlackTurn = !isBlackTurn;
            PawnReplacer pawnReplacer = new PawnReplacer(liveChessPieceList, deadChessPieceList, labels, this);
            pawnReplacer.setLocationRelativeTo(this);
            for (int i = 0; i < liveChessPieceList.size(); i++) {
                if (liveChessPieceList.get(i) instanceof Pawn) {
                    if (liveChessPieceList.get(i).getyLocation() == 0
                            && liveChessPieceList.get(i).getPieceColor() == ChessPiece.PieceColor.white) {
                        pawnReplacer.setWhiteDialog();
                        break;
                    } else if (liveChessPieceList.get(i).getyLocation() == 7
                            && liveChessPieceList.get(i).getPieceColor() == ChessPiece.PieceColor.black) {
                        pawnReplacer.setBlackDialog();
                        break;
                    }
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() instanceof JLabel) {
            String[] location = ((JLabel) e.getSource()).getName().split(" ");
            this.isMoved = false;
            this.boardLocationX = Integer.parseInt(location[0]);
            this.boardLocationY = Integer.parseInt(location[1]);
            if (chosenLabel == e.getSource()) {
                setupColor();
                chosenLabel = null;
            } else {
                moveControl(((JLabel) e.getSource()));
            }
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
