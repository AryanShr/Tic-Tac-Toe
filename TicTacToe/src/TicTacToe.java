import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {
	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel titlepanel = new JPanel();
	JPanel buttonpanel = new JPanel();
	JLabel textfield = new JLabel();
	JButton[] buttons = new JButton[9];// defining buttons
	boolean playerturn; // checking which player will play
	int totalturns;

	TicTacToe() {

		/*Setting all the frame methods*/
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		frame.getContentPane().setBackground(new Color(50, 50, 50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);

		/*All textfield methods*/
		textfield.setBackground(new Color(25, 125, 135));
		textfield.setForeground(new Color(215, 255, 0));
		textfield.setFont(new Font("SansSerif", Font.BOLD, 75));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setOpaque(true);
		/*JPanel methods*/
		titlepanel.setLayout(new BorderLayout());
		titlepanel.setBounds(0, 0, 800, 100);

		/*Setting the buttons for x and o*/
		buttonpanel.setLayout(new GridLayout(3, 3));
		buttonpanel.setBackground(new Color(180, 150, 180));

		for (int i = 0; i < 9; i++) {
			buttons[i] = new JButton();
			buttonpanel.add(buttons[i]);
			buttons[i].setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}

		titlepanel.add(textfield);
		frame.add(titlepanel, BorderLayout.NORTH);
		frame.add(buttonpanel);
		totalturns = 0;
		firstTurn();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 9; i++) {
			if (e.getSource() == buttons[i]) {
				if (playerturn) {
					if (buttons[i].getText() == "") {
						buttons[i].setForeground(new Color(255, 0, 0));
						buttons[i].setText("X");
						playerturn = false;
						textfield.setText("O turn");
						totalturns++;
						check();
					}
				} else {
					if (buttons[i].getText() == "") {
						buttons[i].setForeground(new Color(0, 0, 255));
						buttons[i].setText("O");
						playerturn = true;
						textfield.setText("X turn");
						totalturns++;
						check();
					}
				}
			}
		}
	}

	public void firstTurn() {
		if (random.nextInt(1) == 0) {
			playerturn = true;
			textfield.setText("X turn");
		} else {
			playerturn = false;
			textfield.setText("O turn");
		}
	}

	public void check() {
		// check X win conditions
		if ((buttons[0].getText() == "X") &&
				(buttons[1].getText() == "X") &&
				(buttons[2].getText() == "X")) {
			xWins(0, 1, 2);
		} else if ((buttons[3].getText() == "X") &&
				(buttons[4].getText() == "X") &&
				(buttons[5].getText() == "X")) {
			xWins(3, 4, 5);
		} else if ((buttons[6].getText() == "X") &&
				(buttons[7].getText() == "X") &&
				(buttons[8].getText() == "X")) {
			xWins(6, 7, 8);
		} else if ((buttons[0].getText() == "X") &&
				(buttons[3].getText() == "X") &&
				(buttons[6].getText() == "X")) {
			xWins(0, 3, 6);
		} else if ((buttons[1].getText() == "X") &&
				(buttons[4].getText() == "X") &&
				(buttons[7].getText() == "X")) {
			xWins(1, 4, 7);
		} else if ((buttons[2].getText() == "X") &&
				(buttons[5].getText() == "X") &&
				(buttons[8].getText() == "X")) {
			xWins(2, 5, 8);
		} else if ((buttons[0].getText() == "X") &&
				(buttons[4].getText() == "X") &&
				(buttons[8].getText() == "X")) {
			xWins(0, 4, 8);
		} else if ((buttons[2].getText() == "X") &&
				(buttons[4].getText() == "X") &&
				(buttons[6].getText() == "X")) {
			xWins(2, 4, 6);
		}
		// check O win conditions
		else if ((buttons[0].getText() == "O") &&
				(buttons[1].getText() == "O") &&
				(buttons[2].getText() == "O")) {
			oWins(0, 1, 2);
		} else if ((buttons[3].getText() == "O") &&
				(buttons[4].getText() == "O") &&
				(buttons[5].getText() == "O")) {
			oWins(3, 4, 5);
		} else if ((buttons[6].getText() == "O") &&
				(buttons[7].getText() == "O") &&
				(buttons[8].getText() == "O")) {
			oWins(6, 7, 8);
		} else if ((buttons[0].getText() == "O") &&
				(buttons[3].getText() == "O") &&
				(buttons[6].getText() == "O")) {
			oWins(0, 3, 6);
		} else if ((buttons[1].getText() == "O") &&
				(buttons[4].getText() == "O") &&
				(buttons[7].getText() == "O")) {
			oWins(1, 4, 7);
		} else if ((buttons[2].getText() == "O") &&
				(buttons[5].getText() == "O") &&
				(buttons[8].getText() == "O")) {
			oWins(2, 5, 8);
		} else if ((buttons[0].getText() == "O") &&
				(buttons[4].getText() == "O") &&
				(buttons[8].getText() == "O")) {
			oWins(0, 4, 8);
		} else if ((buttons[2].getText() == "O") &&
				(buttons[4].getText() == "O") &&
				(buttons[6].getText() == "O")) {
			oWins(2, 4, 6);
		} else if (draw()) {
			textfield.setText("Draw");
		}
	}

	public void xWins(int a, int b, int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		for (int i = 0; i < 9; i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("X wins");
	}

	public void oWins(int a, int b, int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		for (int i = 0; i < 9; i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("O wins");
	}

	public boolean draw() {
		boolean isdraw = true;
		if (totalturns == 9) {
			isdraw = true;
		} else {
			isdraw = false;
		}
		return isdraw;
	}
}