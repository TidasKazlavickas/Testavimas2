package org.example;

import javax.swing.*;

public class TicTacToeApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            String[] symbols = {"X", "O"};
            String startingSymbol = (String) JOptionPane.showInputDialog(null, "Select the starting symbol:", "Starting Symbol", JOptionPane.PLAIN_MESSAGE, null, symbols, symbols[0]);
            new TicTacToeGame(3, startingSymbol);
        });
    }
}
