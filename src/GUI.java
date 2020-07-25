import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class GUI extends JFrame{
	
	private Container pane;
	private String currentPlayer;
	private JButton [][] board;
	private boolean checkWinner;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem quit;
	private JMenuItem newGame;
	private int counter;
	
	public GUI() {
		super();
		pane = getContentPane();
		pane.setLayout(new GridLayout(3, 3));
		setTitle("Tic Tac Toe");
		setSize(500, 500);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		currentPlayer = "X";
		board = new JButton[3][3];
		checkWinner = false;
		newBoard();
		initializeMenuBar();
		counter = 0;
	}
	
	private void initializeMenuBar() {
		menuBar = new JMenuBar();
		menu = new JMenu("Options");
		newGame = new JMenuItem("New Game");
		newGame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				resetBoard();
			}
		});
		
		quit = new JMenuItem("Quit");
		quit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menu.add(newGame);
		menu.add(quit);
		menuBar.add(menu);
		setJMenuBar(menuBar);	
	}
	
	private void resetBoard() {
		counter = 0;
		currentPlayer = "X";
		checkWinner = false;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j].setText("");
			}
		}
	}
	
	private void newBoard() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				JButton button = new JButton();
				button.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 150));
				button.setBackground(Color.white);
				board[i][j] = button;
				button.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if(((JButton) e.getSource()).getText().equals("") && checkWinner == false) {
							button.setText(currentPlayer);	
							counter++;
							checkWinner();
							togglePlayer();
						}
					}
				});
				pane.add(button);
			}
		}
	}
	
	private void togglePlayer() {
		if(currentPlayer.equals("X")) {
			currentPlayer = "O";
		}
		else {
			currentPlayer = "X";
		}	
	}
	
	private void checkWinner() {
		
		if(board[0][0].getText().equals(currentPlayer) && board[1][0].getText().equals(currentPlayer) && board[2][0].getText().equals(currentPlayer)) {
			JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
			checkWinner = true; 
		}
		else if(board[0][1].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[2][1].getText().equals(currentPlayer)) {
			JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
			checkWinner = true; 
		}
		else if(board[0][2].getText().equals(currentPlayer) && board[1][2].getText().equals(currentPlayer) && board[2][2].getText().equals(currentPlayer)) {
			JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
			checkWinner = true; 
		}
		else if(board[0][0].getText().equals(currentPlayer) && board[0][1].getText().equals(currentPlayer) && board[0][2].getText().equals(currentPlayer)) {
			JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
			checkWinner = true; 
		}
		else if(board[1][0].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[1][2].getText().equals(currentPlayer)) {
			JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
			checkWinner = true; 
		}
		else if(board[2][0].getText().equals(currentPlayer) && board[2][1].getText().equals(currentPlayer) && board[2][2].getText().equals(currentPlayer)) {
			JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
			checkWinner = true; 
		}
		else if(board[0][0].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[2][2].getText().equals(currentPlayer)) {
			JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
			checkWinner = true; 
		}
		else if(board[0][2].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[2][0].getText().equals(currentPlayer)) {
			JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
			checkWinner = true; 
		}
		else if(counter == 9) {
			JOptionPane.showMessageDialog(null, "It's a draw!");
		}
		else {
			checkWinner = false;
		}
	}
}
