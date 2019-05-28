package FrontEnd;

import BackEnd.Board;
import BackEnd.Pieces.*;
import FrontEnd.NorthPanelPackage.NorthPanel;

import javax.swing.*;
import java.io.*;
import java.util.List;

public class ChessMenuBar extends JMenuBar {
    private final JMenu fileMenu;
    private final JMenu modeMenu;
    private final JMenuItem normalModeMenuItem;
    private final JMenuItem tournamentModeMenuItem;
    private final JMenuItem trollGameMenuItem;
    private final JMenuItem newGameMenuItem;
    private final JMenuItem exitMenuItem;
    private final JMenuItem saveMenuItem;
    private final JMenuItem openMenuItem;

    public JMenu getFileMenu() {
        return fileMenu;
    }

    public JMenu getModeMenu() {
        return modeMenu;
    }

    public JMenuItem getNormalModeMenuItem() {
        return normalModeMenuItem;
    }

    public JMenuItem getTournamentModeMenuItem() {
        return tournamentModeMenuItem;
    }

    public JMenuItem getTrollGameMenuItem() {
        return trollGameMenuItem;
    }

    public JMenuItem getNewGameMenuItem() {
        return newGameMenuItem;
    }

    public JMenuItem getExitMenuItem() {
        return exitMenuItem;
    }

    public JMenuItem getSaveMenuItem() {
        return saveMenuItem;
    }

    public JMenuItem getOpenMenuItem() {
        return openMenuItem;
    }

    public ChessMenuBar() {
        fileMenu = new JMenu("File");
        modeMenu = new JMenu("Modes");
        newGameMenuItem = new JMenuItem("New Game");
        saveMenuItem = new JMenuItem("Save Game");
        openMenuItem = new JMenuItem("Open Game");
        exitMenuItem = new JMenuItem("Exit");
        tournamentModeMenuItem = new JMenuItem("Tournament");
        normalModeMenuItem = new JMenuItem("Normal");
        trollGameMenuItem = new JMenuItem("Cats vs. Dogs");

        this.add(fileMenu);
        this.add(modeMenu);
        fileMenu.add(newGameMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(exitMenuItem);
        modeMenu.add(normalModeMenuItem);
        modeMenu.add(tournamentModeMenuItem);
        modeMenu.add(trollGameMenuItem);
    }

    public void addActionListeners(Board board, NorthPanel northPanel) {

        this.getNewGameMenuItem().addActionListener(e -> board.SetupNewGame());

        this.getOpenMenuItem().addActionListener(e -> {

            FileInputStream fi = null;
            try {
                fi = new FileInputStream(new File("save.ser"));
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            try {
                ObjectInputStream oi = new ObjectInputStream(fi);
                board.isBlackTurn = oi.readBoolean();
                board.liveChessPieceList = (List<ChessPiece>) oi.readObject();
                board.deadChessPieceList = (List<ChessPiece>) oi.readObject();
                board.whiteKing = (King) oi.readObject();
                board.whiteQueen = (Queen) oi.readObject();
                board.whiteBishop0 = (Bishop) oi.readObject();
                board.whiteBishop1 = (Bishop) oi.readObject();
                board.whiteRook0 = (Rook) oi.readObject();
                board.whiteRook1 = (Rook) oi.readObject();
                board.whiteKnight0 = (Knight) oi.readObject();
                board.whiteKnight1 = (Knight) oi.readObject();
                board.whitePawn0 = (Pawn) oi.readObject();
                board.whitePawn1 = (Pawn) oi.readObject();
                board.whitePawn2 = (Pawn) oi.readObject();
                board.whitePawn3 = (Pawn) oi.readObject();
                board.whitePawn4 = (Pawn) oi.readObject();
                board.whitePawn5 = (Pawn) oi.readObject();
                board.whitePawn6 = (Pawn) oi.readObject();
                board.whitePawn7 = (Pawn) oi.readObject();
                board.blackKing = (King) oi.readObject();
                board.blackQueen = (Queen) oi.readObject();
                board.blackBishop0 = (Bishop) oi.readObject();
                board.blackBishop1 = (Bishop) oi.readObject();
                board.blackRook0 = (Rook) oi.readObject();
                board.blackRook1 = (Rook) oi.readObject();
                board.blackKnight0 = (Knight) oi.readObject();
                board.blackKnight1 = (Knight) oi.readObject();
                board.blackPawn0 = (Pawn) oi.readObject();
                board.blackPawn1 = (Pawn) oi.readObject();
                board.blackPawn2 = (Pawn) oi.readObject();
                board.blackPawn3 = (Pawn) oi.readObject();
                board.blackPawn4 = (Pawn) oi.readObject();
                board.blackPawn5 = (Pawn) oi.readObject();
                board.blackPawn6 = (Pawn) oi.readObject();
                board.blackPawn7 = (Pawn) oi.readObject();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            for (int i = 0; i < board.boardSize; i++) {
                for (int j = 0; j < board.boardSize; j++) {
                    board.labels[i][j].setIcon(null);
                }
            }
            if (board.isBlackTurn) {
                northPanel.colorLabel.setText("BLACK'S TURN");

            } else {
                northPanel.colorLabel.setText("WHITE'S TURN");
            }
            board.setupBoardColor();
            board.setupIcons();

        });

        this.getSaveMenuItem().addActionListener(e -> {
            FileOutputStream fout;
            ObjectOutputStream oos;
            try {
                fout = new FileOutputStream("save.ser");
                oos = new ObjectOutputStream(fout);
                oos.writeBoolean(board.isBlackTurn);
                oos.writeObject(board.liveChessPieceList);
                oos.writeObject(board.deadChessPieceList);
                oos.writeObject(board.whiteKing);
                oos.writeObject(board.whiteQueen);
                oos.writeObject(board.whiteBishop0);
                oos.writeObject(board.whiteBishop1);
                oos.writeObject(board.whiteRook0);
                oos.writeObject(board.whiteRook1);
                oos.writeObject(board.whiteKnight0);
                oos.writeObject(board.whiteKnight1);
                oos.writeObject(board.whitePawn0);
                oos.writeObject(board.whitePawn1);
                oos.writeObject(board.whitePawn2);
                oos.writeObject(board.whitePawn3);
                oos.writeObject(board.whitePawn4);
                oos.writeObject(board.whitePawn5);
                oos.writeObject(board.whitePawn6);
                oos.writeObject(board.whitePawn7);
                oos.writeObject(board.blackKing);
                oos.writeObject(board.blackQueen);
                oos.writeObject(board.blackBishop0);
                oos.writeObject(board.blackBishop1);
                oos.writeObject(board.blackRook0);
                oos.writeObject(board.blackRook1);
                oos.writeObject(board.blackKnight0);
                oos.writeObject(board.blackKnight1);
                oos.writeObject(board.blackPawn0);
                oos.writeObject(board.blackPawn1);
                oos.writeObject(board.blackPawn2);
                oos.writeObject(board.blackPawn3);
                oos.writeObject(board.blackPawn4);
                oos.writeObject(board.blackPawn5);
                oos.writeObject(board.blackPawn6);
                oos.writeObject(board.blackPawn7);

                oos.close();
                fout.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        this.getExitMenuItem().addActionListener(e -> board.dispose());

        this.getNormalModeMenuItem().addActionListener(e -> {
            northPanel.blackTimerLabel.setVisible(false);
            northPanel.whiteTimerLabel.setVisible(false);
            board.SetupNewGame();

            if (northPanel.threadTimer.isAlive()) {
                northPanel.threadTimer.stop();
            }
        });

        this.getTournamentModeMenuItem().addActionListener(e -> {
            northPanel.blackTimerLabel.setVisible(true);
            northPanel.whiteTimerLabel.setVisible(true);
            board.SetupNewGame();
            northPanel.whiteTimerValue = 10;
            northPanel.blackTimerValue = 0;
            northPanel.timer(board);
        });

        this.getTrollGameMenuItem().addActionListener(e -> {
            board.whiteKing.setImg(new ImageIcon("img/Cat_king.png"));
            board.whiteQueen.setImg(new ImageIcon("img/Cat_queen.png"));
            board.whitePawn0.setImg(new ImageIcon("img/Cat_pawn.png"));
            board.whitePawn1.setImg(new ImageIcon("img/Cat_pawn.png"));
            board.whitePawn2.setImg(new ImageIcon("img/Cat_pawn.png"));
            board.whitePawn3.setImg(new ImageIcon("img/Cat_pawn.png"));
            board.whitePawn4.setImg(new ImageIcon("img/Cat_pawn.png"));
            board.whitePawn5.setImg(new ImageIcon("img/Cat_pawn.png"));
            board.whitePawn6.setImg(new ImageIcon("img/Cat_pawn.png"));
            board.whitePawn7.setImg(new ImageIcon("img/Cat_pawn.png"));
            board.whiteBishop0.setImg(new ImageIcon("img/Cat_bishop.png"));
            board.whiteBishop1.setImg(new ImageIcon("img/Cat_bishop.png"));
            board.whiteKnight0.setImg(new ImageIcon("img/Cat_knight.png"));
            board.whiteKnight1.setImg(new ImageIcon("img/Cat_knight.png"));
            board.whiteRook0.setImg(new ImageIcon("img/Cat_rook.png"));
            board.whiteRook1.setImg(new ImageIcon("img/Cat_rook.png"));
            board.blackKing.setImg(new ImageIcon("img/Dog_king.png"));
            board.blackQueen.setImg(new ImageIcon("img/Dog_queen.png"));
            board.blackPawn0.setImg(new ImageIcon("img/Dog_pawn.png"));
            board.blackPawn1.setImg(new ImageIcon("img/Dog_pawn.png"));
            board.blackPawn2.setImg(new ImageIcon("img/Dog_pawn.png"));
            board.blackPawn3.setImg(new ImageIcon("img/Dog_pawn.png"));
            board.blackPawn4.setImg(new ImageIcon("img/Dog_pawn.png"));
            board.blackPawn5.setImg(new ImageIcon("img/Dog_pawn.png"));
            board.blackPawn6.setImg(new ImageIcon("img/Dog_pawn.png"));
            board.blackPawn7.setImg(new ImageIcon("img/Dog_pawn.png"));
            board.blackBishop0.setImg(new ImageIcon("img/Dog_bishop.png"));
            board.blackBishop1.setImg(new ImageIcon("img/Dog_bishop.png"));
            board.blackKnight0.setImg(new ImageIcon("img/Dog_knight.png"));
            board.blackKnight1.setImg(new ImageIcon("img/Dog_knight.png"));
            board.blackRook0.setImg(new ImageIcon("img/Dog_rook.png"));
            board.blackRook1.setImg(new ImageIcon("img/Dog_rook.png"));

            board.setupIcons();
        });

    }

}
