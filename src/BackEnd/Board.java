package BackEnd;

import FrontEnd.Dialogs.PawnReplaceDialog;
import FrontEnd.Dialogs.WinnerDialog;
import FrontEnd.ChessMenuBar;
import FrontEnd.NorthPanelPackage.NorthPanel;
import BackEnd.Pieces.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Board extends JFrame implements MouseListener {

    public JLabel[][] labels;
    public int boardSize;
    private int boardLocationX;
    private int boardLocationY;
    private ChessPiece chosenPiece;
    private JLabel chosenLabel;
    private boolean isMoved;
    public boolean isBlackTurn;
    public List<ChessPiece> liveChessPieceList;
    public List<ChessPiece> deadChessPieceList;
    private HashSet<String> checkMateList;
    private ChessMenuBar menuBar;
    private JPanel centerPanel;
    private NorthPanel northPanel;

    public King blackKing = new King(ChessPiece.PieceColor.black, 4, 0);
    public King whiteKing = new King(ChessPiece.PieceColor.white, 4, 7);
    public Pawn whitePawn0 = new Pawn(ChessPiece.PieceColor.white, 0, 6);
    public Pawn whitePawn1 = new Pawn(ChessPiece.PieceColor.white, 1, 6);
    public Pawn whitePawn2 = new Pawn(ChessPiece.PieceColor.white, 2, 6);
    public Pawn whitePawn3 = new Pawn(ChessPiece.PieceColor.white, 3, 6);
    public Pawn whitePawn4 = new Pawn(ChessPiece.PieceColor.white, 4, 6);
    public Pawn whitePawn5 = new Pawn(ChessPiece.PieceColor.white, 5, 6);
    public Pawn whitePawn6 = new Pawn(ChessPiece.PieceColor.white, 6, 6);
    public Pawn whitePawn7 = new Pawn(ChessPiece.PieceColor.white, 7, 6);
    public Pawn blackPawn0 = new Pawn(ChessPiece.PieceColor.black, 0, 1);
    public Pawn blackPawn1 = new Pawn(ChessPiece.PieceColor.black, 1, 1);
    public Pawn blackPawn2 = new Pawn(ChessPiece.PieceColor.black, 2, 1);
    public Pawn blackPawn3 = new Pawn(ChessPiece.PieceColor.black, 3, 1);
    public Pawn blackPawn4 = new Pawn(ChessPiece.PieceColor.black, 4, 1);
    public Pawn blackPawn5 = new Pawn(ChessPiece.PieceColor.black, 5, 1);
    public Pawn blackPawn6 = new Pawn(ChessPiece.PieceColor.black, 6, 1);
    public Pawn blackPawn7 = new Pawn(ChessPiece.PieceColor.black, 7, 1);
    public Rook blackRook0 = new Rook(ChessPiece.PieceColor.black, 0, 0);
    public Rook blackRook1 = new Rook(ChessPiece.PieceColor.black, 7, 0);
    public Rook whiteRook0 = new Rook(ChessPiece.PieceColor.white, 0, 7);
    public Rook whiteRook1 = new Rook(ChessPiece.PieceColor.white, 7, 7);
    public Knight blackKnight0 = new Knight(ChessPiece.PieceColor.black, 1, 0);
    public Knight blackKnight1 = new Knight(ChessPiece.PieceColor.black, 6, 0);
    public Knight whiteKnight0 = new Knight(ChessPiece.PieceColor.white, 1, 7);
    public Knight whiteKnight1 = new Knight(ChessPiece.PieceColor.white, 6, 7);
    public Bishop whiteBishop0 = new Bishop(ChessPiece.PieceColor.white, 2, 7);
    public Bishop whiteBishop1 = new Bishop(ChessPiece.PieceColor.white, 5, 7);
    public Bishop blackBishop0 = new Bishop(ChessPiece.PieceColor.black, 2, 0);
    public Bishop blackBishop1 = new Bishop(ChessPiece.PieceColor.black, 5, 0);
    public Queen blackQueen = new Queen(ChessPiece.PieceColor.black, 3, 0);
    public Queen whiteQueen = new Queen(ChessPiece.PieceColor.white, 3, 7);


    public void setBlackTurn(boolean blackTurn) {
        isBlackTurn = blackTurn;
    }

    public Board() throws HeadlessException {
        this.boardSize = 8;
        liveChessPieceList = new ArrayList<>();
        deadChessPieceList = new ArrayList<>();
        labels = new JLabel[boardSize][boardSize];
        menuBar = new ChessMenuBar();
        isBlackTurn = false;

        setLayout(new BorderLayout());
        fillLiveChessList();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1080, 1080);
        setTitle("Simon's Chess");

        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(boardSize, boardSize));
        add(centerPanel, BorderLayout.CENTER);
        northPanel = new NorthPanel();
        add(northPanel, BorderLayout.NORTH);
        menuBar.addActionListeners(this, northPanel);
        setJMenuBar(menuBar);
        setupBoard();
        setupBoardColor();
        setupIcons();
        addMouseListener(this);
        setVisible(true);
    }

    private void fillLiveChessList() {
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
    }

    public void SetupNewGame() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                labels[i][j].setIcon(null);
            }
            blackKing = new King(ChessPiece.PieceColor.black, 4, 0);
            whiteKing = new King(ChessPiece.PieceColor.white, 4, 7);
            whitePawn0 = new Pawn(ChessPiece.PieceColor.white, 0, 6);
            whitePawn1 = new Pawn(ChessPiece.PieceColor.white, 1, 6);
            whitePawn2 = new Pawn(ChessPiece.PieceColor.white, 2, 6);
            whitePawn3 = new Pawn(ChessPiece.PieceColor.white, 3, 6);
            whitePawn4 = new Pawn(ChessPiece.PieceColor.white, 4, 6);
            whitePawn5 = new Pawn(ChessPiece.PieceColor.white, 5, 6);
            whitePawn6 = new Pawn(ChessPiece.PieceColor.white, 6, 6);
            whitePawn7 = new Pawn(ChessPiece.PieceColor.white, 7, 6);
            blackPawn0 = new Pawn(ChessPiece.PieceColor.black, 0, 1);
            blackPawn1 = new Pawn(ChessPiece.PieceColor.black, 1, 1);
            blackPawn2 = new Pawn(ChessPiece.PieceColor.black, 2, 1);
            blackPawn3 = new Pawn(ChessPiece.PieceColor.black, 3, 1);
            blackPawn4 = new Pawn(ChessPiece.PieceColor.black, 4, 1);
            blackPawn5 = new Pawn(ChessPiece.PieceColor.black, 5, 1);
            blackPawn6 = new Pawn(ChessPiece.PieceColor.black, 6, 1);
            blackPawn7 = new Pawn(ChessPiece.PieceColor.black, 7, 1);
            blackRook0 = new Rook(ChessPiece.PieceColor.black, 0, 0);
            blackRook1 = new Rook(ChessPiece.PieceColor.black, 7, 0);
            whiteRook0 = new Rook(ChessPiece.PieceColor.white, 0, 7);
            whiteRook1 = new Rook(ChessPiece.PieceColor.white, 7, 7);
            blackKnight0 = new Knight(ChessPiece.PieceColor.black, 1, 0);
            blackKnight1 = new Knight(ChessPiece.PieceColor.black, 6, 0);
            whiteKnight0 = new Knight(ChessPiece.PieceColor.white, 1, 7);
            whiteKnight1 = new Knight(ChessPiece.PieceColor.white, 6, 7);
            whiteBishop0 = new Bishop(ChessPiece.PieceColor.white, 2, 7);
            whiteBishop1 = new Bishop(ChessPiece.PieceColor.white, 5, 7);
            blackBishop0 = new Bishop(ChessPiece.PieceColor.black, 2, 0);
            blackBishop1 = new Bishop(ChessPiece.PieceColor.black, 5, 0);
            blackQueen = new Queen(ChessPiece.PieceColor.black, 3, 0);
            whiteQueen = new Queen(ChessPiece.PieceColor.white, 3, 7);

            isBlackTurn = false;
            northPanel.colorLabel.setText("WHITE'S TURN");
            liveChessPieceList = new ArrayList<>();
            deadChessPieceList = new ArrayList<>();
            fillLiveChessList();
            setupIcons();
            setupBoardColor();
            northPanel.whiteTimerValue = 10;
            northPanel.blackTimerValue = -2;
            northPanel.blackTimerLabel.setText("0:10");
        }
    }


    public void setupIcons() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                for (ChessPiece liveChessPiece : liveChessPieceList) {
                    if (i == liveChessPiece.getyLocation() && j == liveChessPiece.getxLocation()) {
                        labels[i][j].setIcon(liveChessPiece.getImg());
                    }
                }
            }
        }
    }

    private void setupBoard() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                labels[i][j] = new JLabel();
                labels[i][j].setName(j + " " + i);
                centerPanel.add(labels[i][j]);
                labels[i][j].addMouseListener(this);
                labels[i][j].setOpaque(true);
                labels[i][j].setHorizontalAlignment(JLabel.CENTER);
                labels[i][j].setVerticalAlignment(JLabel.CENTER);
            }
        }

    }

    public void setupBoardColor() {
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
            for (ChessPiece liveChessPiece : liveChessPieceList) {
                if (liveChessPiece instanceof Rook) {
                    rookList.add((Rook) liveChessPiece);
                }
            }
            ((King) chosenPiece).castlingColor(labels, rookList, checkMateList);
        }
    }

    private void executeCastling(JLabel label) {
        if (label.getBackground() == Color.orange) {
            for (ChessPiece liveChessPiece : liveChessPieceList) {
                if (boardLocationX == 6 && liveChessPiece instanceof Rook && liveChessPiece.getPieceColor().equals(chosenPiece.getPieceColor())
                        && liveChessPiece.getxLocation() == 7) {
                    labels[liveChessPiece.getyLocation()][liveChessPiece.getxLocation()].setIcon(null);
                    labels[chosenPiece.getyLocation()][5].setIcon(liveChessPiece.getImg());
                    liveChessPiece.setyLocation(chosenPiece.getyLocation());
                    liveChessPiece.setxLocation(5);
                    break;
                } else if (boardLocationX == 2 && liveChessPiece instanceof Rook && liveChessPiece.getPieceColor().equals(chosenPiece.getPieceColor())
                        && liveChessPiece.getxLocation() == 0) {
                    labels[liveChessPiece.getyLocation()][liveChessPiece.getxLocation()].setIcon(null);
                    labels[chosenPiece.getyLocation()][3].setIcon(liveChessPiece.getImg());
                    liveChessPiece.setyLocation(chosenPiece.getyLocation());
                    liveChessPiece.setxLocation(3);
                    break;
                }
            }
        }
    }

    private void executeMove(JLabel label) {
        if (label.getBackground() == Color.green || label.getBackground() == Color.red || label.getBackground() == Color.orange || label.getBackground() == Color.pink) {
            if (chosenPiece instanceof Pawn) {
                for (ChessPiece liveChessPiece : liveChessPieceList) {
                    if (liveChessPiece instanceof Pawn && !liveChessPiece.getPieceColor().equals(chosenPiece.getPieceColor())) {
                        if ((chosenPiece.getPieceColor().equals(ChessPiece.PieceColor.black) && chosenPiece.getyLocation() == 1 && boardLocationY == 3 &&
                                liveChessPiece.getyLocation() == chosenPiece.getyLocation() + 2 &&
                                (liveChessPiece.getxLocation() == chosenPiece.getxLocation() - 1 || liveChessPiece.getxLocation() == chosenPiece.getxLocation() + 1)) ||
                                (chosenPiece.getPieceColor().equals(ChessPiece.PieceColor.white) && chosenPiece.getyLocation() == 6 && boardLocationY == 4) &&
                                        liveChessPiece.getyLocation() == chosenPiece.getyLocation() - 2 &&
                                        (liveChessPiece.getxLocation() == chosenPiece.getxLocation() - 1 || liveChessPiece.getxLocation() == chosenPiece.getxLocation() + 1)) {
                            ((Pawn) chosenPiece).setDoubleMoved(true);
                        }
                    }
                }
            }
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
                    if (liveChessPieceList.get(i) instanceof King) {
                        new WinnerDialog(this);
                    }
                    deadChessPieceList.add(liveChessPieceList.remove(i));
                }
            }
        } else if (label.getBackground() == Color.pink) {
            for (int i = 0; i < liveChessPieceList.size(); i++) {
                if (liveChessPieceList.get(i).getxLocation() == boardLocationX
                        && liveChessPieceList.get(i).getyLocation() == boardLocationY + 1) {
                    labels[boardLocationY + 1][boardLocationX].setIcon(null);
                    liveChessPieceList.get(i).setyLocation(-1);
                    liveChessPieceList.get(i).setxLocation(-1);
                    deadChessPieceList.add(liveChessPieceList.remove(i));
                } else if (liveChessPieceList.get(i).getxLocation() == boardLocationX
                        && liveChessPieceList.get(i).getyLocation() == boardLocationY - 1) {
                    labels[boardLocationY - 1][boardLocationX].setIcon(null);
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
                    ((Pawn) chessPiece).checkMateColor(labels);
                } else if (!isBlackTurn && chessPiece.getPieceColor().equals(ChessPiece.PieceColor.white)) {
                    ((Pawn) chessPiece).checkMateColor(labels);
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
                labels[i][j].setToolTipText(null);
                if (labels[i][j].getBackground().equals(Color.red) || labels[i][j].getBackground().equals(Color.green)) {
                    checkMateList.add(labels[i][j].getName());
                    labels[i][j].setToolTipText("Ütésbe lépsz.");
                }
            }
        }
        setupBoardColor();
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

        setupBoardColor();

        if (!isMoved) {

            for (ChessPiece liveChessPiece : liveChessPieceList) {
                if (liveChessPiece.getxLocation() == boardLocationX
                        && liveChessPiece.getyLocation() == boardLocationY) {
                    this.chosenPiece = liveChessPiece;
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
            setupBoardColor();

            checkMateList();

            isBlackTurn = !isBlackTurn;

            northPanel.setTimerAfterMove(this);

            PawnReplaceDialog pawnReplacer = new PawnReplaceDialog(liveChessPieceList, deadChessPieceList, labels, this);
            pawnReplacer.setLocationRelativeTo(this);
            for (ChessPiece liveChessPiece : liveChessPieceList) {
                if (liveChessPiece instanceof Pawn) {
                    if (liveChessPiece.getyLocation() == 0
                            && liveChessPiece.getPieceColor() == ChessPiece.PieceColor.white) {
                        pawnReplacer.setWhiteDialog();
                        break;
                    } else if (liveChessPiece.getyLocation() == 7
                            && liveChessPiece.getPieceColor() == ChessPiece.PieceColor.black) {
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
                setupBoardColor();
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