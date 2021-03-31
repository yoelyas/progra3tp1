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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Interfaz {

	private JFrame frmJuego;

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
		Tablero tablero = new Tablero();

		JLabel[][] tableroLabels = new JLabel[4][4];

		// cositas de diseño random

		frmJuego = new JFrame();
		frmJuego.setTitle("Juego 2048 :)");
		frmJuego.getContentPane().setEnabled(false);
		frmJuego.getContentPane().setBackground(new Color(255, 204, 153));
		frmJuego.setBounds(100, 100, 500, 564);
		frmJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJuego.getContentPane().setLayout(null);

		// detecta cuando pulsamos flecha arriba

		JEditorPane editorPane = new JEditorPane();
		editorPane.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// Podemos tener 1 solo mover publico en tablero, los mover en x direccion
				// privados
				// Habria que pasar como parametro la dirección en todo caso
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					tablero.moverArriba();
					actualizarTablero();

				}
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					tablero.moverIzquierda();
					actualizarTablero();

				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					tablero.moverAbajo();
					actualizarTablero();

				}
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					tablero.moverDerecha();
					actualizarTablero();

				}

			}

			private void actualizarTablero() {
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 4; j++) {
						String number =  tablero.obtenerCasillero(i, j);
						tableroLabels[i][j].setText(number);
						tableroLabels[i][j].setForeground(new Color(0, 0, 0));
						tableroLabels[i][j].setBackground(changeColor(number));
						tableroLabels[i][j].setOpaque(true);
						if (number.length()==4) {
							tableroLabels[i][j].setFont(new Font("Tahoma", Font.BOLD, 34));
						}
						/*if(Integer.valueOf(number) == 2048) {
							System.out.println("ganaste");
						}*/
					}
				}

			}
		});

		editorPane.setEditable(false);
		editorPane.setFont(new Font("Tahoma", Font.BOLD, 25));
		editorPane.setText("2048");
		editorPane.setBackground(new Color(255, 204, 153));
		editorPane.setBounds(10, 11, 78, 37);
		frmJuego.getContentPane().add(editorPane);

		// labels de c/u de los cuadrados de los numeros con su numero respectivamente,
		// (no funciona bien)

		JLabel label0x0 = new JLabel(tablero.obtenerCasillero(0, 0));
		label0x0.setBackground(new Color(204, 192, 179));
		label0x0.setOpaque(true);
		label0x0.setHorizontalAlignment(SwingConstants.CENTER);
		label0x0.setFont(new Font("Tahoma", Font.BOLD, 40));
		label0x0.setBounds(33, 73, 90, 90);
		frmJuego.getContentPane().add(label0x0);
		tableroLabels[0][0] = label0x0;

		JLabel label0x1 = new JLabel(tablero.obtenerCasillero(0, 1));
		label0x1.setBackground(new Color(204, 192, 179));
		label0x1.setOpaque(true);
		label0x1.setHorizontalAlignment(SwingConstants.CENTER);
		label0x1.setFont(new Font("Tahoma", Font.BOLD, 40));
		label0x1.setBounds(143, 73, 90, 90);
		frmJuego.getContentPane().add(label0x1);
		tableroLabels[0][1] = label0x1;

		JLabel label0x2 = new JLabel(tablero.obtenerCasillero(0, 2));
		label0x2.setBackground(new Color(204, 192, 179));
		label0x2.setOpaque(true);
		label0x2.setHorizontalAlignment(SwingConstants.CENTER);
		label0x2.setFont(new Font("Tahoma", Font.BOLD, 40));
		label0x2.setBounds(253, 73, 90, 90);
		frmJuego.getContentPane().add(label0x2);
		tableroLabels[0][2] = label0x2;

		JLabel label0x3 = new JLabel(tablero.obtenerCasillero(0, 3));
		label0x3.setBackground(new Color(204, 192, 179));
		label0x3.setOpaque(true);
		label0x3.setHorizontalAlignment(SwingConstants.CENTER);
		label0x3.setFont(new Font("Tahoma", Font.BOLD, 40));
		label0x3.setBounds(363, 73, 90, 90);
		frmJuego.getContentPane().add(label0x3);
		tableroLabels[0][3] = label0x3;

		JLabel label1x0 = new JLabel(tablero.obtenerCasillero(1, 0));
		label1x0.setBackground(new Color(204, 192, 179));
		label1x0.setOpaque(true);
		label1x0.setHorizontalAlignment(SwingConstants.CENTER);
		label1x0.setFont(new Font("Tahoma", Font.BOLD, 40));
		label1x0.setBounds(33, 183, 90, 90);
		frmJuego.getContentPane().add(label1x0);
		tableroLabels[1][0] = label1x0;

		JLabel label1x1 = new JLabel(tablero.obtenerCasillero(1, 1));
		label1x1.setBackground(new Color(204, 192, 179));
		label1x1.setOpaque(true);
		label1x1.setForeground(new Color(0, 0, 0));
		label1x1.setHorizontalAlignment(SwingConstants.CENTER);
		label1x1.setFont(new Font("Tahoma", Font.BOLD, 40));
		label1x1.setBounds(143, 183, 90, 90);
		frmJuego.getContentPane().add(label1x1);
		tableroLabels[1][1] = label1x1;

		JLabel label1x2 = new JLabel(tablero.obtenerCasillero(1, 2));
		label1x2.setBackground(new Color(204, 192, 179));
		label1x2.setOpaque(true);
		label1x2.setHorizontalAlignment(SwingConstants.CENTER);
		label1x2.setFont(new Font("Tahoma", Font.BOLD, 40));
		label1x2.setBounds(253, 183, 90, 90);
		frmJuego.getContentPane().add(label1x2);
		tableroLabels[1][2] = label1x2;

		JLabel label1x3 = new JLabel(tablero.obtenerCasillero(1, 3));
		label1x3.setBackground(new Color(204, 192, 179));
		;
		label1x3.setOpaque(true);
		label1x3.setHorizontalAlignment(SwingConstants.CENTER);
		label1x3.setFont(new Font("Tahoma", Font.BOLD, 40));
		label1x3.setBounds(363, 183, 90, 90);
		frmJuego.getContentPane().add(label1x3);
		tableroLabels[1][3] = label1x3;

		JLabel label2x0 = new JLabel(tablero.obtenerCasillero(2, 0));
		label2x0.setBackground(new Color(204, 192, 179));
		label2x0.setOpaque(true);
		label2x0.setHorizontalAlignment(SwingConstants.CENTER);
		label2x0.setFont(new Font("Tahoma", Font.BOLD, 40));
		label2x0.setBounds(33, 293, 90, 90);
		frmJuego.getContentPane().add(label2x0);
		tableroLabels[2][0] = label2x0;

		JLabel label2x1 = new JLabel(tablero.obtenerCasillero(2, 1));
		label2x1.setBackground(new Color(204, 192, 179));
		label2x1.setOpaque(true);
		label2x1.setHorizontalAlignment(SwingConstants.CENTER);
		label2x1.setFont(new Font("Tahoma", Font.BOLD, 40));
		label2x1.setBounds(143, 293, 90, 90);
		frmJuego.getContentPane().add(label2x1);
		tableroLabels[2][1] = label2x1;

		JLabel label2x2 = new JLabel(tablero.obtenerCasillero(2, 2));
		label2x2.setBackground(new Color(204, 192, 179));
		label2x2.setOpaque(true);
		label2x2.setHorizontalAlignment(SwingConstants.CENTER);
		label2x2.setFont(new Font("Tahoma", Font.BOLD, 40));
		label2x2.setBounds(253, 293, 90, 90);
		frmJuego.getContentPane().add(label2x2);
		tableroLabels[2][2] = label2x2;

		JLabel label2x3 = new JLabel(tablero.obtenerCasillero(2, 3));
		label2x3.setBackground(new Color(204, 192, 179));
		label2x3.setOpaque(true);
		label2x3.setHorizontalAlignment(SwingConstants.CENTER);
		label2x3.setFont(new Font("Tahoma", Font.BOLD, 40));
		label2x3.setBounds(363, 293, 90, 90);
		frmJuego.getContentPane().add(label2x3);
		tableroLabels[2][3] = label2x3;

		JLabel label3x0 = new JLabel(tablero.obtenerCasillero(3, 0));
		label3x0.setBackground(new Color(204, 192, 179));
		label3x0.setOpaque(true);
		label3x0.setHorizontalAlignment(SwingConstants.CENTER);
		label3x0.setFont(new Font("Tahoma", Font.BOLD, 40));
		label3x0.setBounds(33, 403, 90, 90);
		frmJuego.getContentPane().add(label3x0);
		tableroLabels[3][0] = label3x0;

		JLabel label3x1 = new JLabel(tablero.obtenerCasillero(3, 1));
		label3x1.setBackground(new Color(204, 192, 179));
		label3x1.setOpaque(true);
		label3x1.setHorizontalAlignment(SwingConstants.CENTER);
		label3x1.setFont(new Font("Tahoma", Font.BOLD, 40));
		label3x1.setBounds(143, 403, 90, 90);
		frmJuego.getContentPane().add(label3x1);
		tableroLabels[3][1] = label3x1;

		JLabel label3x2 = new JLabel(tablero.obtenerCasillero(3, 2));
		label3x2.setBackground(new Color(204, 192, 179));
		label3x2.setOpaque(true);
		label3x2.setHorizontalAlignment(SwingConstants.CENTER);
		label3x2.setFont(new Font("Tahoma", Font.BOLD, 40));
		label3x2.setBounds(253, 403, 90, 90);
		frmJuego.getContentPane().add(label3x2);
		tableroLabels[3][2] = label3x2;

		JLabel label3x3 = new JLabel(tablero.obtenerCasillero(3, 3));
		label3x3.setBackground(new Color(204, 192, 179));
		label3x3.setOpaque(true);
		label3x3.setHorizontalAlignment(SwingConstants.CENTER);
		label3x3.setFont(new Font("Tahoma", Font.BOLD, 40));
		label3x3.setBounds(363, 403, 90, 90);
		frmJuego.getContentPane().add(label3x3);
		tableroLabels[3][3] = label3x3;

		JEditorPane editorPane_1 = new JEditorPane();
		editorPane_1.setToolTipText("");
		editorPane_1.setBackground(new Color(150, 150, 150));
		editorPane_1.setEditable(false);
		editorPane_1.setBounds(12, 53, 460, 460);
		frmJuego.getContentPane().add(editorPane_1);

	}

	public Color changeColor(String valor) {
		if (valor.equals("2")) {
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
		} else {
			return new Color(204, 192, 179);
		}
	}

}