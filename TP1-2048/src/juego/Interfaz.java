package juego;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;

import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import java.awt.Component;

public class Interfaz {

	private JFrame frmJuego;
	private JTextField paneScore;
	private Tablero tablero;
	private JTextField pantallaEnd;
	private JButton tryAgain;
	private JButton seguirJugando;
	private JPanel tableroPanel;
	private boolean sigueJugando;
	private Font fuenteNormal = new Font("Tahoma", Font.BOLD, 40);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
					window.frmJuego.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interfaz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {

		// crea un tablero
		tablero = new Tablero();
		JLabel[][] tableroLabels = new JLabel[4][4];

		// cositas de diseño random


		frmJuego = new JFrame();
		frmJuego.setTitle("Juego 2048");
		frmJuego.getContentPane().setEnabled(false);
		frmJuego.getContentPane().setBackground(new Color(255, 204, 153));
		frmJuego.setBounds(100, 100, 500, 564);
		frmJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJuego.getContentPane().setLayout(null);

		// detecta cuando pulsamos flecha arriba

		JEditorPane fondoJuego = new JEditorPane();
		fondoJuego.setEditable(false);

		fondoJuego.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// Podemos tener 1 solo mover publico en tablero, los mover en x direccion
				// privados
				// Habria que pasar como parametro la dirección en todo caso
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					tablero.mover("arriba");
					actualizarTablero(tableroLabels);
				}
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					tablero.mover("izquierda");
					actualizarTablero(tableroLabels);
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					tablero.mover("abajo");
					actualizarTablero(tableroLabels);
				}
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					tablero.mover("derecha");
					actualizarTablero(tableroLabels);
				}
			}

		});
		
		pantallaEnd = new JTextField();
		pantallaEnd.setDisabledTextColor(Color.WHITE);
		pantallaEnd.setEditable(false);
		pantallaEnd.setVisible(false);
		pantallaEnd.setOpaque(false);
		pantallaEnd.setHorizontalAlignment(SwingConstants.CENTER);
		pantallaEnd.setBorder(null);
		
		tryAgain = new JButton("Volver a jugar");
		tryAgain.setRolloverEnabled(false);
		tryAgain.setForeground(Color.BLACK);
		tryAgain.setHorizontalTextPosition(SwingConstants.CENTER);
		tryAgain.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		tryAgain.setAlignmentX(Component.RIGHT_ALIGNMENT);
		tryAgain.setBackground(Color.WHITE);
		tryAgain.setBorder(UIManager.getBorder("CheckBox.border"));
		tryAgain.setVisible(false);
		tryAgain.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setupEndGameWindow(false, 2);
				tablero.resetScore();
				tablero = new Tablero();
				sigueJugando = false;
				actualizarTablero(tableroLabels);
			}
		});
		
		seguirJugando = new JButton("Seguir jugando");
		seguirJugando.setForeground(Color.BLACK);
		seguirJugando.setHorizontalTextPosition(SwingConstants.CENTER);
		seguirJugando.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		seguirJugando.setAlignmentX(Component.RIGHT_ALIGNMENT);
		seguirJugando.setBackground(Color.WHITE);
		seguirJugando.setBorder(UIManager.getBorder("CheckBox.border"));
		seguirJugando.setVisible(false);
		seguirJugando.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setupEndGameWindow(false, 2);
				//pantallaEnd.setVisible(false);
				//tableroPanel.setVisible(true);
				tryAgain.setVisible(false);
				seguirJugando.setVisible(false);
				sigueJugando = true;
			}
		});


		
		seguirJugando.setBounds(177, 383, 140, 23);
		frmJuego.getContentPane().add(seguirJugando);
		
		tryAgain.setBounds(143, 349, 200, 23);
		frmJuego.getContentPane().add(tryAgain);
		
		pantallaEnd.setText("Game over!");
		pantallaEnd.setFont(new Font("Tahoma", Font.BOLD, 40));
		pantallaEnd.setBackground(new Color(150, 150, 150));
		pantallaEnd.setBounds(17, 60, 450, 450);

		frmJuego.getContentPane().add(pantallaEnd);

		fondoJuego.setFont(new Font("Tahoma", Font.BOLD, 25));
		fondoJuego.setText("2048");
		fondoJuego.setBackground(new Color(255, 204, 153));
		fondoJuego.setBounds(10, 11, 78, 37);
		frmJuego.getContentPane().add(fondoJuego);

		tableroPanel = new JPanel();
		tableroPanel.setBorder(new LineBorder(new Color(150, 150, 150), 15));
		tableroPanel.setBounds(17, 60, 450, 450);
		tableroPanel.setBackground(new Color(150, 150, 150));
		tableroPanel.setLayout(new GridLayout(4, 4, 15, 15));
		frmJuego.getContentPane().add(tableroPanel);

		
		JLabel label0x0 = new JLabel(tablero.obtenerCasillero(0, 0));
		tableroPanel.add(label0x0);
		label0x0.setBackground(changeColor(tablero.obtenerCasillero(0, 0)));
		label0x0.setOpaque(true);
		label0x0.setHorizontalAlignment(SwingConstants.CENTER);
		label0x0.setFont(fuenteNormal);
		tableroLabels[0][0] = label0x0;

		JLabel label0x1 = new JLabel(tablero.obtenerCasillero(0, 1));
		tableroPanel.add(label0x1);
		label0x1.setBackground(changeColor(tablero.obtenerCasillero(0, 1)));
		label0x1.setOpaque(true);
		label0x1.setHorizontalAlignment(SwingConstants.CENTER);
		label0x1.setFont(fuenteNormal);
		tableroLabels[0][1] = label0x1;

		JLabel label0x2 = new JLabel(tablero.obtenerCasillero(0, 2));
		tableroPanel.add(label0x2);
		label0x2.setBackground(changeColor(tablero.obtenerCasillero(0, 2)));
		label0x2.setOpaque(true);
		label0x2.setHorizontalAlignment(SwingConstants.CENTER);
		label0x2.setFont(fuenteNormal);
		tableroLabels[0][2] = label0x2;

		JLabel label0x3 = new JLabel(tablero.obtenerCasillero(0, 3));
		tableroPanel.add(label0x3);
		label0x3.setBackground(changeColor(tablero.obtenerCasillero(0, 3)));
		label0x3.setOpaque(true);
		label0x3.setHorizontalAlignment(SwingConstants.CENTER);
		label0x3.setFont(fuenteNormal);
		tableroLabels[0][3] = label0x3;

		JLabel label1x0 = new JLabel(tablero.obtenerCasillero(1, 0));
		tableroPanel.add(label1x0);
		label1x0.setBackground(changeColor(tablero.obtenerCasillero(1, 0)));
		label1x0.setOpaque(true);
		label1x0.setHorizontalAlignment(SwingConstants.CENTER);
		label1x0.setFont(fuenteNormal);
		tableroLabels[1][0] = label1x0;

		JLabel label1x1 = new JLabel(tablero.obtenerCasillero(1, 1));
		tableroPanel.add(label1x1);
		label1x1.setBackground(changeColor(tablero.obtenerCasillero(1, 1)));
		label1x1.setOpaque(true);
		label1x1.setForeground(new Color(0, 0, 0));
		label1x1.setHorizontalAlignment(SwingConstants.CENTER);
		label1x1.setFont(fuenteNormal);
		tableroLabels[1][1] = label1x1;

		JLabel label1x2 = new JLabel(tablero.obtenerCasillero(1, 2));
		tableroPanel.add(label1x2);
		label1x2.setBackground(changeColor(tablero.obtenerCasillero(1, 2)));
		label1x2.setOpaque(true);
		label1x2.setHorizontalAlignment(SwingConstants.CENTER);
		label1x2.setFont(fuenteNormal);
		tableroLabels[1][2] = label1x2;

		JLabel label1x3 = new JLabel(tablero.obtenerCasillero(1, 3));
		tableroPanel.add(label1x3);
		label1x3.setBackground(changeColor(tablero.obtenerCasillero(1, 3)));
		label1x3.setOpaque(true);
		label1x3.setHorizontalAlignment(SwingConstants.CENTER);
		label1x3.setFont(fuenteNormal);
		tableroLabels[1][3] = label1x3;

		JLabel label2x0 = new JLabel(tablero.obtenerCasillero(2, 0));
		tableroPanel.add(label2x0);
		label2x0.setBackground(changeColor(tablero.obtenerCasillero(2, 0)));
		label2x0.setOpaque(true);
		label2x0.setHorizontalAlignment(SwingConstants.CENTER);
		label2x0.setFont(fuenteNormal);
		tableroLabels[2][0] = label2x0;

		JLabel label2x1 = new JLabel(tablero.obtenerCasillero(2, 1));
		tableroPanel.add(label2x1);
		label2x1.setBackground(changeColor(tablero.obtenerCasillero(2, 1)));
		label2x1.setOpaque(true);
		label2x1.setHorizontalAlignment(SwingConstants.CENTER);
		label2x1.setFont(fuenteNormal);
		tableroLabels[2][1] = label2x1;

		JLabel label2x2 = new JLabel(tablero.obtenerCasillero(2, 2));
		tableroPanel.add(label2x2);
		label2x2.setBackground(changeColor(tablero.obtenerCasillero(2, 2)));
		label2x2.setOpaque(true);
		label2x2.setHorizontalAlignment(SwingConstants.CENTER);
		label2x2.setFont(fuenteNormal);
		tableroLabels[2][2] = label2x2;

		JLabel label2x3 = new JLabel(tablero.obtenerCasillero(2, 3));
		tableroPanel.add(label2x3);
		label2x3.setBackground(changeColor(tablero.obtenerCasillero(2, 3)));
		label2x3.setOpaque(true);
		label2x3.setHorizontalAlignment(SwingConstants.CENTER);
		label2x3.setFont(fuenteNormal);
		tableroLabels[2][3] = label2x3;

		JLabel label3x0 = new JLabel(tablero.obtenerCasillero(3, 0));
		tableroPanel.add(label3x0);
		label3x0.setBackground(changeColor(tablero.obtenerCasillero(3, 0)));
		label3x0.setOpaque(true);
		label3x0.setHorizontalAlignment(SwingConstants.CENTER);
		label3x0.setFont(fuenteNormal);
		tableroLabels[3][0] = label3x0;

		JLabel label3x1 = new JLabel(tablero.obtenerCasillero(3, 1));
		tableroPanel.add(label3x1);
		label3x1.setBackground(changeColor(tablero.obtenerCasillero(3, 1)));
		label3x1.setOpaque(true);
		label3x1.setHorizontalAlignment(SwingConstants.CENTER);
		label3x1.setFont(fuenteNormal);
		tableroLabels[3][1] = label3x1;

		JLabel label3x2 = new JLabel(tablero.obtenerCasillero(3, 2));
		tableroPanel.add(label3x2);
		label3x2.setBackground(changeColor(tablero.obtenerCasillero(3, 2)));
		label3x2.setOpaque(true);
		label3x2.setHorizontalAlignment(SwingConstants.CENTER);
		label3x2.setFont(fuenteNormal);
		tableroLabels[3][2] = label3x2;

		JLabel label3x3 = new JLabel(tablero.obtenerCasillero(3, 3));
		tableroPanel.add(label3x3);
		label3x3.setBackground(changeColor(tablero.obtenerCasillero(3, 3)));
		label3x3.setOpaque(true);
		label3x3.setHorizontalAlignment(SwingConstants.CENTER);
		label3x3.setFont(fuenteNormal);
		tableroLabels[3][3] = label3x3;

		paneScore = new JTextField();
		paneScore.setEditable(false);
		paneScore.setBorder(null);
		paneScore.setHorizontalAlignment(SwingConstants.TRAILING);
		paneScore.setText("SCORE: " + tablero.getScore());
		paneScore.setBackground(new Color(255, 204, 153));
		paneScore.setFont(new Font("Tahoma", Font.BOLD, 25));
		paneScore.setBounds(272, 11, 200, 31);
		tablero.resetScore();
		frmJuego.getContentPane().add(paneScore);

	}

	private void actualizarTablero(JLabel[][] tableroLabels) {
		boolean won = false;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				String number = tablero.obtenerCasillero(i, j);
				tableroLabels[i][j].setText(number);
				tableroLabels[i][j].setForeground(new Color(0, 0, 0));
				tableroLabels[i][j].setBackground(changeColor(number));
				tableroLabels[i][j].setOpaque(true);

				paneScore.setText("SCORE: " + tablero.getScore());

				if (number.length() == 4) {
					tableroLabels[i][j].setFont(new Font("Tahoma", Font.BOLD, 34));
				}
				else
					tableroLabels[i][j].setFont(new Font("Tahoma", Font.BOLD, 40));
				won = won || number.equals("2048");
			}
		}
		if (won && sigueJugando == false) {
			setupEndGameWindow(true, 1);
			
		} 
		if (!tablero.jugable()) {
			setupEndGameWindow(true, 0);
		}
	}
	
	private void setupEndGameWindow(boolean value, int resultado) {
		tableroPanel.setVisible(!value);
		pantallaEnd.setVisible(value);
		tryAgain.setVisible(value);		
		seguirJugando.setVisible(value);
		if (resultado == 0) {
			pantallaEnd.setText("Game over!");
			tryAgain.setText("Volver a intentar");
			seguirJugando.setVisible(!value);
		}
		else if (resultado == 1){
			pantallaEnd.setText("Ganaste!");
			seguirJugando.setText("Seguir jugando");
			tryAgain.setText("Volver a empezar");
			seguirJugando.setVisible(value);
		}
		paneScore.setText("SCORE: " + tablero.getScore());
	}
	
	private Color changeColor(String valor) {
		if(valor.equals("0") || valor.equals("")) {
			return new Color(204, 192, 179);
		} else if (valor.equals("2")) {
			return new Color(238, 228, 218);
		} else if (valor.equals("4")) {
			return new Color(237, 224, 192);
		} else if (valor.equals("8")) {
			return new Color(242, 177, 121);
		} else if (valor.equals("16")) {
			return new Color(245, 149, 99);
		} else if (valor.equals("32")) {
			return new Color(237, 114, 90);
		} else if (valor.equals("64")) {
			return new Color(246, 94, 59);
		} else if (valor.equals("128")) {
			return new Color(237, 207, 114);
		} else if (valor.equals("256")) {
			return new Color(237, 204, 87);
		} else if (valor.equals("512")) {
			return new Color(237, 197, 60);
		} else if (valor.equals("1024")) {
			return new Color(237, 197, 63);
		} else if (valor.equals("2048")) {
			return new Color(237, 200, 53);
		} else {
			return new Color(204, 192, 0);
		}
	}
}