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

public class Interfaz {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
					window.frame.setVisible(true);
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
		
		//crea un tablero 
		Tablero tablero = new Tablero();
		
		JLabel [][] tableroLabels = new JLabel [4][4];
		
		
		//cositas de diseño random
		
		frame = new JFrame();
		frame.getContentPane().setEnabled(false);
		frame.getContentPane().setBackground(new Color(255, 204, 153));
		frame.setBounds(100, 100, 469, 523);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		 
		
		//detecta cuando pulsamos flecha arriba 

		JEditorPane editorPane = new JEditorPane();
		editorPane.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// Podemos tener 1 solo mover publico en tablero, los mover en x direccion privados
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
						tableroLabels[i][j].setText(tablero.obtenerCasillero(i, j));
					}
				}

			}
		});
		
		
		editorPane.setEditable(false);
		editorPane.setFont(new Font("Tahoma", Font.BOLD, 25));
		editorPane.setText("2048");
		editorPane.setBackground(new Color(255, 204, 153));
		editorPane.setBounds(10, 11, 78, 37);
		frame.getContentPane().add(editorPane);
		
		//labels de c/u de los cuadrados de los numeros con su numero respectivamente, (no funciona bien)
		
		JLabel label0x0 = new JLabel(tablero.obtenerCasillero(0, 0));
		label0x0.setHorizontalAlignment(SwingConstants.CENTER);
		label0x0.setFont(new Font("Tahoma", Font.BOLD, 41));
		label0x0.setBounds(20, 68, 70, 70);
		frame.getContentPane().add(label0x0);
		tableroLabels[0][0] = label0x0;
		
		JLabel label0x1 = new JLabel(tablero.obtenerCasillero(0, 1));
		label0x1.setHorizontalAlignment(SwingConstants.CENTER);
		label0x1.setFont(new Font("Tahoma", Font.BOLD, 41));
		label0x1.setBounds(112, 68, 70, 70);
		frame.getContentPane().add(label0x1);
		tableroLabels[0][1] = label0x1;
		
		JLabel label0x2 = new JLabel(tablero.obtenerCasillero(0, 2));
		label0x2.setHorizontalAlignment(SwingConstants.CENTER);
		label0x2.setFont(new Font("Tahoma", Font.BOLD, 41));
		label0x2.setBounds(223, 68, 70, 70);
		frame.getContentPane().add(label0x2);
		tableroLabels[0][2] = label0x2;
		
		JLabel label0x3 = new JLabel(tablero.obtenerCasillero(0, 3));
		label0x3.setHorizontalAlignment(SwingConstants.CENTER);
		label0x3.setFont(new Font("Tahoma", Font.BOLD, 41));
		label0x3.setBounds(322, 68, 70, 70);
		frame.getContentPane().add(label0x3);
		tableroLabels[0][3] = label0x3;
		
		JLabel label1x0 = new JLabel(tablero.obtenerCasillero(1, 0));
		label1x0.setHorizontalAlignment(SwingConstants.CENTER);
		label1x0.setFont(new Font("Tahoma", Font.BOLD, 41));
		label1x0.setBounds(18, 159, 70, 70);
		frame.getContentPane().add(label1x0);
		tableroLabels[1][0] = label1x0;

		JLabel label1x1 = new JLabel(tablero.obtenerCasillero(1, 1));
		label1x1.setHorizontalAlignment(SwingConstants.CENTER);
		label1x1.setFont(new Font("Tahoma", Font.BOLD, 41));
		label1x1.setBounds(122, 159, 70, 70);
		frame.getContentPane().add(label1x1);
		tableroLabels[1][1] = label1x1;
		
		JLabel label1x2 = new JLabel(tablero.obtenerCasillero(1, 2));
		label1x2.setHorizontalAlignment(SwingConstants.CENTER);
		label1x2.setFont(new Font("Tahoma", Font.BOLD, 41));
		label1x2.setBounds(223, 159, 70, 70);
		frame.getContentPane().add(label1x2);
		tableroLabels[1][2] = label1x2;
		
		JLabel label1x3 = new JLabel(tablero.obtenerCasillero(1, 3));
		label1x3.setHorizontalAlignment(SwingConstants.CENTER);
		label1x3.setFont(new Font("Tahoma", Font.BOLD, 41));
		label1x3.setBounds(322, 159, 70, 70);
		frame.getContentPane().add(label1x3);
		tableroLabels[1][3] = label1x3;
		
		JLabel label2x2 = new JLabel(tablero.obtenerCasillero(2, 2));
		label2x2.setHorizontalAlignment(SwingConstants.CENTER);
		label2x2.setFont(new Font("Tahoma", Font.BOLD, 41));
		label2x2.setBounds(223, 273, 70, 70);
		frame.getContentPane().add(label2x2);
		tableroLabels[2][2] = label2x2;
		
		JLabel label2x1 = new JLabel(tablero.obtenerCasillero(2, 1));
		label2x1.setHorizontalAlignment(SwingConstants.CENTER);
		label2x1.setFont(new Font("Tahoma", Font.BOLD, 41));
		label2x1.setBounds(132, 273, 70, 70);
		frame.getContentPane().add(label2x1);
		tableroLabels[2][1] = label2x1;
		
		JLabel label2x0 = new JLabel(tablero.obtenerCasillero(2, 0));
		label2x0.setHorizontalAlignment(SwingConstants.CENTER);
		label2x0.setFont(new Font("Tahoma", Font.BOLD, 41));
		label2x0.setBounds(32, 273, 70, 70);
		frame.getContentPane().add(label2x0);
		tableroLabels[2][0] = label2x0;
		
		JLabel label2x3 = new JLabel(tablero.obtenerCasillero(2, 3));
		label2x3.setHorizontalAlignment(SwingConstants.CENTER);
		label2x3.setFont(new Font("Tahoma", Font.BOLD, 41));
		label2x3.setBounds(322, 273, 70, 70);
		frame.getContentPane().add(label2x3);
		tableroLabels[2][3] = label2x3;
		
		JLabel label3x0 = new JLabel(tablero.obtenerCasillero(3, 0));
		label3x0.setHorizontalAlignment(SwingConstants.CENTER);
		label3x0.setFont(new Font("Tahoma", Font.BOLD, 41));
		label3x0.setBounds(32, 366, 70, 70);
		frame.getContentPane().add(label3x0);
		tableroLabels[3][0] = label3x0;
		
		JLabel label3x1 = new JLabel(tablero.obtenerCasillero(3, 1));
		label3x1.setHorizontalAlignment(SwingConstants.CENTER);
		label3x1.setFont(new Font("Tahoma", Font.BOLD, 41));
		label3x1.setBounds(132, 366, 70, 70);
		frame.getContentPane().add(label3x1);
		tableroLabels[3][1] = label3x1;
		
		JLabel label3x2 = new JLabel(tablero.obtenerCasillero(3, 2));
		label3x2.setHorizontalAlignment(SwingConstants.CENTER);
		label3x2.setFont(new Font("Tahoma", Font.BOLD, 41));
		label3x2.setBounds(223, 366, 70, 70);
		frame.getContentPane().add(label3x2);
		tableroLabels[3][2] = label3x2;
		
		JLabel label3x3 = new JLabel(tablero.obtenerCasillero(3, 3));
		label3x3.setHorizontalAlignment(SwingConstants.CENTER);
		label3x3.setFont(new Font("Tahoma", Font.BOLD, 41));
		label3x3.setBounds(322, 366, 70, 70);
		frame.getContentPane().add(label3x3);
		tableroLabels[3][3] = label3x3;
		
		JEditorPane editorPane_1 = new JEditorPane();
		editorPane_1.setToolTipText("");
		editorPane_1.setBackground(new Color(153, 102, 0));
		editorPane_1.setEditable(false);
		editorPane_1.setBounds(10, 59, 422, 414);
		frame.getContentPane().add(editorPane_1);
		
		

		
		
		
		
		
	}
}
