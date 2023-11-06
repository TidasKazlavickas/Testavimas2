package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGame {
    private JFrame frame;
    private int boardSize;
    public JButton[][] board;
    private String currentPlayer;
    private boolean gameEnded;

    public TicTacToeGame(int boardSize, String startingSymbol) {
        this.boardSize = boardSize;
        this.board = new JButton[boardSize][boardSize];
        this.currentPlayer = startingSymbol; // Pradinis simbolis ("X" arba "O")
        this.gameEnded = false;

        frame = new JFrame("Kryžiukai-Nuliukai");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 350);
        frame.setLayout(new BorderLayout());

        initializeBoard();
        createMenu();
        createRestartButton();

        frame.setVisible(true);
    }

    public TicTacToeGame(int boardSize, String x, String o) {
    }

    private void initializeBoard() {
        JPanel boardPanel = new JPanel(new GridLayout(boardSize, boardSize));
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = new JButton();
                board[i][j].setFont(new Font("Arial", Font.PLAIN, 40));
                board[i][j].setFocusPainted(false);
                board[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (!gameEnded) {
                            JButton button = (JButton) e.getSource();
                            if (button.getText().equals("")) {
                                button.setText(currentPlayer);
                                button.setEnabled(false);
                                if (checkWinner()) {
                                    JOptionPane.showMessageDialog(frame, "Winner: " + currentPlayer);
                                    gameEnded = true;
                                } else if (isBoardFull()) {
                                    JOptionPane.showMessageDialog(frame, "It's a tie!");
                                    gameEnded = true;
                                } else {
                                    currentPlayer = (currentPlayer.equals("X")) ? "O" : "X";
                                }
                            }
                        }
                    }
                });
                boardPanel.add(board[i][j]);
            }
        }
        frame.add(boardPanel, BorderLayout.CENTER);
    }

    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu sizeMenu = new JMenu("Board Size");
        JMenuItem size3x3 = new JMenuItem("3x3");
        JMenuItem size4x4 = new JMenuItem("4x4");
        JMenuItem size5x5 = new JMenuItem("5x5");

        size3x3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new TicTacToeGame(3, currentPlayer);
            }
        });

        size4x4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new TicTacToeGame(4, currentPlayer);
            }
        });

        size5x5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new TicTacToeGame(5, currentPlayer);
            }
        });

        sizeMenu.add(size3x3);
        sizeMenu.add(size4x4);
        sizeMenu.add(size5x5);
        menuBar.add(sizeMenu);
        frame.setJMenuBar(menuBar);
    }

    public boolean checkWinner() {
        for (int i = 0; i < boardSize; i++) {
            if (board[i][0].getText().equals(currentPlayer) && board[i][1].getText().equals(currentPlayer) && board[i][2].getText().equals(currentPlayer)) {
                return true;
            }
            if (board[0][i].getText().equals(currentPlayer) && board[1][i].getText().equals(currentPlayer) && board[2][i].getText().equals(currentPlayer)) {
                return true;
            }
        }
        if (board[0][0].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[2][2].getText().equals(currentPlayer)) {
            return true;
        }
        return board[0][2].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[2][0].getText().equals(currentPlayer);
    }

    public boolean isBoardFull() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (board[i][j].getText().equals("")) {
                    return false;
                }
            }
        }
        return true;
    }

    private void createRestartButton() {
        JButton restartButton = new JButton("Restart Game");
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new TicTacToeGame(boardSize, currentPlayer);
            }
        });
        frame.add(restartButton, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        String[] symbols = {"X", "O"};
        String startingSymbol = (String) JOptionPane.showInputDialog(null, "Select the starting symbol:", "Starting Symbol", JOptionPane.PLAIN_MESSAGE, null, symbols, symbols[0]);
        new TicTacToeGame(3, startingSymbol);
    }

    public boolean checkWinner(String x) {
        return false;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(String currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}
