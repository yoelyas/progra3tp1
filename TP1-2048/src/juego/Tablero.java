package juego;

import java.util.ArrayList;
import java.util.Iterator;

public class Tablero {
	private Casillero[][] tablero;
	private int score = 0;
	private int tamanioTablero = 0;

	public Tablero(int num) {
		tamanioTablero = num;
		tablero = new Casillero[tamanioTablero][tamanioTablero];

		llenarTablero();

		// **crea 2 valores randoms entre 2 y 4 en cualquier ubicacio

		numeroRandomEnPosicionRandom();

		numeroRandomEnPosicionRandom();

	}

	public void llenarTablero() {

		for (int i = 0; i < tamanioTablero; i++) {
			for (int j = 0; j < tamanioTablero; j++) {
				tablero[i][j] = new Casillero(0);
			}
		}

	}

	public Casillero casilleroRandomVacio() {

		ArrayList<Casillero> posicionesVacias = new ArrayList<Casillero>();

		for (int i = 0; i < tamanioTablero; i++) {
			for (int j = 0; j < tamanioTablero; j++) {
				if (tablero[i][j].estaVacio()) {
					Casillero posicionVacia = new Casillero(i, j, 0);
					posicionesVacias.add(posicionVacia);
				}
			}
		}
		if (posicionesVacias.size() >= 1) {
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
		if (primerValor != null) {
			tablero[primerValor.getX()][primerValor.getY()].setNumeroRandom();
		}
	}

	public void mover(String direccion) {

		int tamanio = tamanioTablero; // tamanio del tablero

		ArrayList<Integer> eje1 = new ArrayList<Integer>();
		ArrayList<Integer> eje2 = new ArrayList<Integer>();

		boolean porFila = false;
		boolean porColumna = false;

		int fila = 0;
		int columna = 0;

		switch (direccion) {

		case "arriba":
			// setear valores de los ejes
			for (int n = 0; n < tamanio; n++) {
				eje1.add(n);
				eje2.add(n);
			}

			porFila = false;
			porColumna = true;

			break;

		case "abajo":

			for (int n = 0; n < tamanio; n++) {
				eje1.add(n);
			}

			for (int m = tamanio - 1; m >= 0; m--) {
				eje2.add(m);

			}
			porFila = false;
			porColumna = true;

			break;

		case "izquierda":

			for (int n = 0; n < tamanio; n++) {
				eje1.add(n);
				eje2.add(n);
			}
			porFila = true;
			porColumna = false;

			break;

		case "derecha":

			for (int n = 0; n < tamanio; n++) {
				eje1.add(n);
			}
			for (int m = tamanio - 1; m >= 0; m--) {
				eje2.add(m);

			}
			porFila = true;
			porColumna = false;

			break;
		}

		boolean algunMovimiento = false;

		// Itero segun criterios (ejes - iterador principal y secundario)
		// Itero sobre el eje principal
		for (int i1 = 0; i1 < eje1.size(); i1++) {

			// flag de control para saber si ya finalizaron las operaciones de movimiento y
			// fusion
			boolean fin = false;

			// indice del casillero por el cual debe comenzarse a iterar
			// sera util al haber una fusion para evitar multiples fusiones
			int baseIteracion = 0;

			while (!fin) {

				boolean seMovio = false;

				// Recorro el eje secundario
				for (int i2 = baseIteracion; i2 < eje2.size() - 1; i2++) {

					fila = porFila ? eje1.get(i1) : eje2.get(i2);
					columna = porColumna ? eje1.get(i1) : eje2.get(i2);

					// si itero por fila solo incremento el indice del eje secundario (i2)
					int filaSiguiente = porFila ? eje1.get(i1) : eje2.get(i2 + 1);
					// si itero por columna solo incremento el indice secundario (i2)
					int columnaSiguiente = porColumna ? eje1.get(i1) : eje2.get(i2 + 1);

					if (tablero[fila][columna].estaVacio()) {

						if (!tablero[filaSiguiente][columnaSiguiente].estaVacio()) { // si esta vacio, la fila siguiente
																						// y la columna siguiente estan
																						// vacias settea el valor y
																						// actualiza el flag
							tablero[fila][columna].setValor(tablero[filaSiguiente][columnaSiguiente].getValor());
							tablero[filaSiguiente][columnaSiguiente].setValor(0);
							seMovio = true;

						}
						// aca ocurre la fusion
					} else if (!tablero[filaSiguiente][columnaSiguiente].estaVacio() && tablero[fila][columna]
							.getValor() == tablero[filaSiguiente][columnaSiguiente].getValor()) {

						tablero[fila][columna].fusionar();
						tablero[filaSiguiente][columnaSiguiente].setValor(0);
						baseIteracion = i2 + 1;
						seMovio = true;
						setScore(tablero[fila][columna].getValor());
					}

				}

				if (!seMovio) {
					fin = true;
				}

				algunMovimiento = algunMovimiento || seMovio;
			}
		}

		if (algunMovimiento) {
			numeroRandomEnPosicionRandom();
		}

	}

	public boolean jugable() {
		boolean ret = false;
		for (int i = 0; i < tamanioTablero; i++) {
			for (int j = 0; j < tamanioTablero; j++) {
				if (tablero[i][j].getValor() == 0) {
					ret = true;
				}
				ret = ret || cercanosDisponibles(i, j);

			}
		}
		return ret;
	}

	public boolean cercanosDisponibles(int i, int j) {
		ArrayList<Integer> arreglo = new ArrayList<Integer>();
		if (i + 1 <= tamanioTablero - 1) {
			arreglo.add(tablero[i + 1][j].getValor());
		}
		if (i - 1 >= 0) {
			arreglo.add(tablero[i - 1][j].getValor());
		}
		if (j + 1 <= tamanioTablero - 1) {
			arreglo.add(tablero[i][j + 1].getValor());
		}
		if (j - 1 >= 0) {
			arreglo.add(tablero[i][j - 1].getValor());
		}
		if (arreglo.contains(tablero[i][j].getValor())) {
			return true;
		}
		return false;

	}

	public void resetScore() {
		this.score = 0;
	}

	private void setScore(int valor) {
		this.score += valor;

	}

	public int getScore() {
		return this.score;
	}

}
