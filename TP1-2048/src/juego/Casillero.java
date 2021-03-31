package juego;

public class Casillero {

	private int valor;
	private int posX;
	private int posY;
	
	
	public Casillero (int valor) {

		this.valor = valor;
		
	}
	
	public Casillero (int posX, int posY, int valor) {
		this.valor=valor;
		this.posX=posX;
		this.posY=posY;
	}

	public void setValor(int i) {
		this.valor = i;
		
	}
	
	public int getValor() {
		return this.valor;
	}
	
	public boolean estaVacio() {
		return this.valor==0; 
	}
	
	public void fusionar () {
		this.valor += this.valor;
	}
	
	public void setPosicion(int x, int y) {
		this.posX=x;
		this.posY=y;		
	}
	
	public int getX() {
		return this.posX;
	}
	
	public int getY() {
		return this.posY;
	}
	
	public void setNumeroRandom() {
		int random = (int) (Math.random() * 2+1); 
		setValor(random * 2);		
	}

}
