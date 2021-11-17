package Logica;

public class Casillero {
	
	private boolean state;
	private int fila;
	private int columna;
	
	public Casillero(boolean estado, int fila, int columna) {
		this.state = estado;
		this.fila = fila;
		this.columna = columna;
	}
	
	public void setState(boolean estado) {
		this.state = estado;
	}

	public boolean isState() {
		return state;
	}
	
	public int getFilaCasillero() {
		return this.fila;
	}
	
	public int getColumnaCasillero() {
		return this.columna;
	}
}

	
