package juego;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;

import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import java.awt.Component;

public class Interfaz {
	/*
	 * private JFrame inicio; private JButton try4x4; private JButton try5x5;
	 * private JButton try6x6;
	 */

	private JFrame frmJuego;
	private JTextField paneScore;
	private Tablero tablero;
	private JTextField pantallaEnd;
	private JButton tryAgain;
	private JButton seguirJugando;
	private JPanel tableroPanel;
	private Font fuenteNormal = new Font("Tahoma", Font.BOLD, 50);
	private boolean sigueJugando;
	private boolean movimientoHabilitado;
	private int tamanioTablero = 5;

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
		JFrame inicio = new JFrame();
		String[] options = new String[2];
		options[0] = new String("4x4");
		options[1] = new String("5x5");
		int eleccionUsuario = JOptionPane.showOptionDialog(inicio.getContentPane(),
				"Seleccione la dificultad del juego", "Dificultad", 0, JOptionPane.QUESTION_MESSAGE, null, options,
				null);
		if (eleccionUsuario == JOptionPane.YES_OPTION) {
			tamanioTablero = 4;
		} else if (eleccionUsuario == JOptionPane.NO_OPTION) {
			tamanioTablero = 5;
		} else {
			System.exit(0);
		}

		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		// crea un tablero
		tablero = new Tablero(tamanioTablero);
		JLabel[][] tableroLabels = new JLabel[tamanioTablero][tamanioTablero];
		movimientoHabilitado = true;
		// cositas de diseño random

		frmJuego = new JFrame();
		frmJuego.setTitle("Juego 2048");
		frmJuego.getContentPane().setEnabled(false);
		frmJuego.getContentPane().setBackground(new Color(255, 204, 153));
		frmJuego.setBounds(100, 100, 125 * tamanioTablero, 150 * tamanioTablero);
		frmJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJuego.getContentPane().setLayout(null);

		JEditorPane fondoJuego = new JEditorPane();
		fondoJuego.setEditable(false);

		fondoJuego.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_UP && movimientoHabilitado) {
					tablero.mover("arriba");
					actualizarTablero(tableroLabels);
				}
				if (e.getKeyCode() == KeyEvent.VK_LEFT && movimientoHabilitado) {
					tablero.mover("izquierda");
					actualizarTablero(tableroLabels);
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN && movimientoHabilitado) {
					tablero.mover("abajo");
					actualizarTablero(tableroLabels);
				}
				if (e.getKeyCode() == KeyEvent.VK_RIGHT && movimientoHabilitado) {
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
				tablero = new Tablero(tamanioTablero);
				sigueJugando = false;
				actualizarTablero(tableroLabels);
				movimientoHabilitado = true;
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
				sigueJugando = true;
				movimientoHabilitado = true;
			}
		});

		// botones y carteles de fin de juego
		seguirJugando.setBounds(50 * tamanioTablero, 70 * tamanioTablero, 140, 23);
		frmJuego.getContentPane().add(seguirJugando);

		tryAgain.setBounds(50 * tamanioTablero, 80 * tamanioTablero, 140, 23);
		frmJuego.getContentPane().add(tryAgain);

		pantallaEnd.setText("Game over!");
		pantallaEnd.setFont(new Font("Tahoma", Font.BOLD, 40));
		pantallaEnd.setBackground(new Color(150, 150, 150));
		pantallaEnd.setBounds(17, 60, 120 * tamanioTablero, 80 * tamanioTablero);

		frmJuego.getContentPane().add(pantallaEnd);

		fondoJuego.setFont(new Font("Tahoma", Font.BOLD, 25));
		fondoJuego.setText("2048");
		fondoJuego.setBackground(new Color(255, 204, 153));
		fondoJuego.setBounds(10, 11, 78, 37);
		frmJuego.getContentPane().add(fondoJuego);

		tableroPanel = new JPanel();
		tableroPanel.setBorder(new LineBorder(new Color(150, 150, 150), 20));
		tableroPanel.setBounds(17, 60, 114 * tamanioTablero, 121 * tamanioTablero);
		tableroPanel.setBackground(new Color(150, 150, 150));
		tableroPanel.setLayout(new GridLayout(tamanioTablero, tamanioTablero, tamanioTablero * 2, tamanioTablero * 2));
		frmJuego.getContentPane().add(tableroPanel);

		for (int eje1 = 0; eje1 < tamanioTablero; eje1++) {
			for (int eje2 = 0; eje2 < tamanioTablero; eje2++) {
				JLabel casilla = new JLabel(tablero.obtenerCasillero(eje1, eje2));
				tableroPanel.add(casilla);
				casilla.setBackground(changeColor(tablero.obtenerCasillero(eje1, eje2)));
				casilla.setOpaque(true);
				casilla.setHorizontalAlignment(SwingConstants.CENTER);
				casilla.setFont(fuenteNormal);
				tableroLabels[eje1][eje2] = casilla;
			}
		}

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
		for (int i = 0; i < tamanioTablero; i++) {
			for (int j = 0; j < tamanioTablero; j++) {
				String number = tablero.obtenerCasillero(i, j);
				tableroLabels[i][j].setText(number);
				tableroLabels[i][j].setForeground(new Color(0, 0, 0));
				tableroLabels[i][j].setBackground(changeColor(number));
				tableroLabels[i][j].setOpaque(true);

				paneScore.setText("SCORE: " + tablero.getScore());
				if (number.length() > 2) {
					tableroLabels[i][j].setFont(new Font("Tahoma", Font.BOLD, 114 / number.length()));
				} else {
					tableroLabels[i][j].setFont(new Font("Tahoma", Font.BOLD, 50));
				}

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
		movimientoHabilitado = false;
		tableroPanel.setVisible(!value);
		pantallaEnd.setVisible(value);
		tryAgain.setVisible(value);
		seguirJugando.setVisible(value);
		if (resultado == 0) {
			pantallaEnd.setText("Game over!");
			tryAgain.setText("Volver a intentar");
			seguirJugando.setVisible(!value);
		} else if (resultado == 1) {
			pantallaEnd.setText("Ganaste!");
			seguirJugando.setText("Seguir jugando");
			tryAgain.setText("Volver a empezar");
			seguirJugando.setVisible(value);
		}
	}

	private Color changeColor(String valor) {
		if (valor.equals("0") || valor.equals("")) {
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