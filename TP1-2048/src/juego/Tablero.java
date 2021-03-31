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
		if(posicionesVacias.size() >= 1 ) {
			int posicionRandom = (int) (Math.random() * (posicionesVacias.size() - 1));
			return posicionesVacias.get(posicionRandom);
		}
		
		return null;
		
	}
	
	
	public String obtenerCasillero(int x, int y) {
		String numerito = Integer.toString(this.tablero[x][y].getValor());
		return numerito.equals("0") ? "" : numerito;
	}
	
	
	private void numeroRandomEnPosicionRandom() {
		Casillero primerValor = casilleroRandomVacio();
		if(primerValor != null) {
		tablero[primerValor.getX()][primerValor.getY()].setNumeroRandom();
		}
	}
	
	public void moverArriba() {
		
		for (int i = 0; i < 4; i++) {
			int posicion = 0;
			int comparador = 1;
			int cursor = 0;
			
			while (posicion <= 3 && comparador < 4) {
				
				if (posicion < 3 && tablero[posicion][i].getValor() == tablero[comparador][i].getValor() && !tablero[posicion][i].estaVacio() && !tablero[comparador][i].estaVacio()) {
		
					tablero[posicion][i].fusionar();
					tablero[cursor][i].setValor(tablero[posicion][i].getValor());
					
					//tablero[posicion][i].setValor(0);
					tablero[comparador][i].setValor(0);;
					cursor++;
					posicion = comparador + 1;
					comparador += 2;
					
				} else if (tablero[posicion][i].estaVacio()) {
					posicion++;
					comparador++;
					
				} else if (tablero[comparador][i].estaVacio()) {
					comparador++;
					
				} else { // Ambos son diferentes de cero y diferentes entre
							// si
					int aux = tablero[posicion][i].getValor();
					tablero[posicion][i].setValor(0);
					tablero[cursor][i].setValor(aux);;
					cursor++;
					posicion = comparador;
					comparador++;
				}
			}
			if (posicion <= 3) {
				int aux = tablero[posicion][i].getValor();
				tablero[posicion][i].setValor(0);
				tablero[cursor][i].setValor(aux);

			}
			
		}
		numeroRandomEnPosicionRandom();
	}
public void moverIzquierda() {
		
		for (int i = 0; i < 4; i++) {
			int posicion = 0;
			int comparador = 1;
			int cursor = 0;
			while (posicion <= 3 && comparador < 4) {
				
				if (posicion < 3 && tablero[i][posicion].getValor() == tablero[i][comparador].getValor() && !tablero[i][posicion].estaVacio() && !tablero[i][comparador].estaVacio()) {
		
					tablero[i][posicion].fusionar();
					tablero[i][cursor].setValor(tablero[i][posicion].getValor());
					
					//tablero[posicion][i].setValor(0);
					tablero[i][comparador].setValor(0);;
					cursor++;
					posicion = comparador + 1;
					comparador += 2;
					
				} else if (tablero[i][posicion].estaVacio()) {
					posicion++;
					comparador++;
					
				} else if (tablero[i][comparador].estaVacio()) {
					comparador++;
					
				} else { // Ambos son diferentes de cero y diferentes entre
							// si
					int aux = tablero[i][posicion].getValor();
					tablero[i][posicion].setValor(0);
					tablero[i][cursor].setValor(aux);;
					cursor++;
					posicion = comparador;
					comparador++;
				}
			}
			if (posicion <= 3) {
				int aux = tablero[i][posicion].getValor();
				tablero[i][posicion].setValor(0);
				tablero[i][cursor].setValor(aux);

			}
		}
		numeroRandomEnPosicionRandom();
	}
public void moverAbajo() {
	
	for (int i = 0; i < 4; i++) {
		int posicion = 3;
		int comparador = 2;
		int cursor = 3;
		while (posicion >= 0 && comparador > -1) {
			
			if (posicion > 0 && tablero[posicion][i].getValor() == tablero[comparador][i].getValor() && !tablero[posicion][i].estaVacio() && !tablero[comparador][i].estaVacio()) {
	
				tablero[posicion][i].fusionar();
				tablero[cursor][i].setValor(tablero[posicion][i].getValor());
				
				//tablero[posicion][i].setValor(0);
				tablero[comparador][i].setValor(0);;
				cursor--;
				posicion = comparador - 1;
				comparador -= 2;
				
			} else if (tablero[posicion][i].estaVacio()) {
				posicion--;
				comparador--;
				
			} else if (tablero[comparador][i].estaVacio()) {
				comparador--;
				
			} else { // Ambos son diferentes de cero y diferentes entre
						// si
				int aux = tablero[posicion][i].getValor();
				tablero[posicion][i].setValor(0);
				tablero[cursor][i].setValor(aux);;
				cursor--;
				posicion = comparador;
				comparador--;
			}
		}
		if (posicion >= 0) {
			int aux = tablero[posicion][i].getValor();
			tablero[posicion][i].setValor(0);
			tablero[cursor][i].setValor(aux);

		}
	}
	numeroRandomEnPosicionRandom();
}
public void moverDerecha() {
	
	for (int i = 0; i < 4; i++) {
		int posicion = 3;
		int comparador = 2;
		int cursor = 3;
		while (posicion >= 0 && comparador > -1) {
			
			if (posicion > 0 && tablero[i][posicion].getValor() == tablero[i][comparador].getValor() && !tablero[i][posicion].estaVacio() && !tablero[i][comparador].estaVacio()) {
	
				tablero[i][posicion].fusionar();
				tablero[i][cursor].setValor(tablero[i][posicion].getValor());
				
				//tablero[posicion][i].setValor(0);
				tablero[i][comparador].setValor(0);;
				cursor--;
				posicion = comparador - 1;
				comparador -= 2;
				
			} else if (tablero[i][posicion].estaVacio()) {
				posicion--;
				comparador--;
				
			} else if (tablero[i][comparador].estaVacio()) {
				comparador--;
				
			} else { // Ambos son diferentes de cero y diferentes entre
						// si
				int aux = tablero[i][posicion].getValor();
				tablero[i][posicion].setValor(0);
				tablero[i][cursor].setValor(aux);;
				cursor--;
				posicion = comparador;
				comparador--;
			}
		}
		if (posicion >= 0) {
			int aux = tablero[i][posicion].getValor();
			tablero[i][posicion].setValor(0);
			tablero[i][cursor].setValor(aux);

		}
	}
	numeroRandomEnPosicionRandom();
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
		
		tablero.imprimir();
	}

	
	

}
