package juego;

import java.util.ArrayList;

public class Tablero {
	private Casillero [][] tablero;
	
	public Tablero() 
	{		
		/*crea un tablero de 4x4 de tipo Casillero 
		   0 1 2 3
		  0
		  1
		  2
		  3 
		  
		  y lo llena con Casilleros en 0
		
		*/
		tablero = new Casillero [4][4];
		
		llenarTablero();		
		
		//**crea 2 valores randoms entre 2 y 4 en cualquier ubicacio
		 
		numeroRandomEnPosicionRandom();
		
		numeroRandomEnPosicionRandom();

		
	}
	
	public void llenarTablero() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				tablero[i][j] = new Casillero(0);				
			}
		}
		
	}
	
	
	public Casillero casilleroRandomVacio() {
		
		ArrayList<Casillero> posicionesVacias = new ArrayList<Casillero>();
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (tablero[i][j].estaVacio()) {
					Casillero posicionVacia = new Casillero (i, j, 0);
					posicionesVacias.add(posicionVacia);
				}
			}
		}
		
		int posicionRandom = (int) (Math.random() * (posicionesVacias.size() - 1));
		
		return posicionesVacias.get(posicionRandom);
		
	}
	
	
	public String obtenerCasillero(int x, int y) {
		return Integer.toString(this.tablero[x][y].getValor());
	}
	
	
	private void numeroRandomEnPosicionRandom() {
		Casillero primerValor = casilleroRandomVacio();
		tablero[primerValor.getX()][primerValor.getY()].setNumeroRandom();
	}
	
	//-----------------------------------------------------------//
	
	public void imprimir () {
		for (int i = 0; i <= 3; i++) {
			System.out.println("\n");
			for (int j = 0; j <= 3; j++) {
				System.out.print(tablero[i][j].getValor() + " ");
			}
		}
		
	}
	
	
	
	
	
	
	public static void main (String [] strg) {
		Tablero tablero = new Tablero();
		
		tablero.imprimir();;
	}

	
	

}
