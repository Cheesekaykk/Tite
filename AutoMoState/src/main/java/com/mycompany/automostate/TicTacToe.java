/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.automostate;

/**
 *
 * @author Jp Miravalles
 */
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import javax.swing.*;

public class TicTacToe extends JPanel {

    private JButton[] buttons;
    private Queue<Integer> moves;
    private Stack<Integer> undoMoves;
    private boolean player1Turn = true;
    private JButton undoButton;
    private JButton redoButton;

    public TicTacToe() {
        setLayout(new BorderLayout());

        JPanel boardPanel = new JPanel(new GridLayout(3, 3));
        buttons = new JButton[9];
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton("");
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton button = (JButton) e.getSource();
                    int index = getIndex(button);
                    if (player1Turn) {
                        button.setText("X");
                        moves.add(index);
                    } else {
                        button.setText("O");
                        moves.add(index);
                    }
                    player1Turn = !player1Turn;
                    boolean winner = checkWinner();
                    if (winner) {
                        JOptionPane.showMessageDialog(null, "Player " + (player1Turn ? "1" : "2") + " has won!");
                        resetGame();
                    } else if (moves.size() == 9) {
                        JOptionPane.showMessageDialog(null, "The game is a tie!");
                        resetGame();
                    }
                }
            });
            boardPanel.add(buttons[i]);
        }

        moves = new LinkedList<>();
        undoMoves = new Stack<>();

        undoButton = new JButton("Undo");
        undoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!moves.isEmpty()) {
                    int index = moves.remove();
                    undoMoves.push(index);
                    buttons[index].setText("");
                    player1Turn = !player1Turn;
                }
            }
        });

        redoButton = new JButton("Redo");
        redoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!undoMoves.isEmpty()) {
                    int index = undoMoves.pop();
                    moves.add(index);
                    if (player1Turn) {
                        buttons[index].setText("X");
                    } else {
                        buttons[index].setText("O");
                    }
                    player1Turn = !player1Turn;
                }
            }
        });

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(undoButton);
        buttonPanel.add(redoButton);

        add(boardPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        resetGame();
    }

    private int getIndex(JButton button) {
        for (int i = 0; i < buttons.length; i++) {
            if (button == buttons[i]) {
                return i;
            }
        }
        return -1;
    }

    private boolean checkWinner() {
        // Check for rows
        for (int i = 0; i < 3; i++) {
            if (buttons[i * 3].getText().equals(buttons[i * 3 + 1].getText()) &&
                    buttons[i * 3 + 1].getText().equals(buttons[i * 3 + 2].getText()) &&
                    buttons[i * 3].getText().length() > 0) {
                return true;
            }
        }

        // Check for columns
        for (int i = 0; i < 3; i++) {
            if (buttons[i].getText().equals(buttons[i + 3].getText()) &&
                    buttons[i + 3].getText().equals(buttons[i + 6].getText()) &&
                    buttons[i].getText().length() > 0) {
                return true;
            }
        }

        // Check for diagonals
        if (buttons[0].getText().equals(buttons[4].getText()) &&
                buttons[4].getText().equals(buttons[8].getText()) &&
                buttons[0].getText().length() > 0) {
            return true;
        }

        if (buttons[2].getText().equals(buttons[4].getText()) &&
                buttons[4].getText().equals(buttons[6].getText()) &&
                buttons[2].getText().length() > 0) {
            return true;
        }
        return false;

   

       
    }
      private void resetGame() {
        for (int i = 0; i < 9; i++) {
            buttons[i].setText("");
        }
        moves.clear();
        undoMoves.clear();
        player1Turn = true;
    }

    public static void main(String[] args) {
        new TicTacToe();
    }
}
