package juego;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

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
		
		
		//cositas de diseño random
		
		frame = new JFrame();
		frame.getContentPane().setEnabled(false);
		frame.getContentPane().setBackground(new Color(255, 204, 153));
		frame.setBounds(100, 100, 340, 414);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		 
		JEditorPane editorPane = new JEditorPane();
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
		
		JLabel label0x1 = new JLabel(tablero.obtenerCasillero(0, 1));
		label0x1.setHorizontalAlignment(SwingConstants.CENTER);
		label0x1.setFont(new Font("Tahoma", Font.BOLD, 41));
		label0x1.setBounds(112, 68, 70, 70);
		frame.getContentPane().add(label0x1);
		
		JLabel label0x2 = new JLabel(tablero.obtenerCasillero(0, 2));
		label0x2.setHorizontalAlignment(SwingConstants.CENTER);
		label0x2.setFont(new Font("Tahoma", Font.BOLD, 41));
		label0x2.setBounds(223, 68, 70, 70);
		frame.getContentPane().add(label0x2);
		
		JLabel label1x0 = new JLabel(tablero.obtenerCasillero(1, 0));
		label1x0.setHorizontalAlignment(SwingConstants.CENTER);
		label1x0.setFont(new Font("Tahoma", Font.BOLD, 41));
		label1x0.setBounds(18, 159, 70, 70);
		frame.getContentPane().add(label1x0);

		JLabel label1x1 = new JLabel(tablero.obtenerCasillero(1, 1));
		label1x1.setHorizontalAlignment(SwingConstants.CENTER);
		label1x1.setFont(new Font("Tahoma", Font.BOLD, 41));
		label1x1.setBounds(122, 159, 70, 70);
		frame.getContentPane().add(label1x1);
		
		JLabel label1x2 = new JLabel(tablero.obtenerCasillero(1, 2));
		label1x2.setHorizontalAlignment(SwingConstants.CENTER);
		label1x2.setFont(new Font("Tahoma", Font.BOLD, 41));
		label1x2.setBounds(223, 159, 70, 70);
		frame.getContentPane().add(label1x2);
		
		JLabel label2x2 = new JLabel(tablero.obtenerCasillero(2, 2));
		label2x2.setHorizontalAlignment(SwingConstants.CENTER);
		label2x2.setFont(new Font("Tahoma", Font.BOLD, 41));
		label2x2.setBounds(223, 273, 70, 70);
		frame.getContentPane().add(label2x2);
		
		JLabel label2x1 = new JLabel(tablero.obtenerCasillero(2, 1));
		label2x1.setHorizontalAlignment(SwingConstants.CENTER);
		label2x1.setFont(new Font("Tahoma", Font.BOLD, 41));
		label2x1.setBounds(132, 273, 70, 70);
		frame.getContentPane().add(label2x1);
		
		JLabel label2x0 = new JLabel(tablero.obtenerCasillero(2, 0));
		label2x0.setHorizontalAlignment(SwingConstants.CENTER);
		label2x0.setFont(new Font("Tahoma", Font.BOLD, 41));
		label2x0.setBounds(32, 273, 70, 70);
		frame.getContentPane().add(label2x0);
		
		
		JEditorPane editorPane_1 = new JEditorPane();
		editorPane_1.setToolTipText("");
		editorPane_1.setBackground(new Color(153, 102, 0));
		editorPane_1.setEditable(false);
		editorPane_1.setBounds(10, 59, 300, 300);
		frame.getContentPane().add(editorPane_1);
		
		
	}
}
