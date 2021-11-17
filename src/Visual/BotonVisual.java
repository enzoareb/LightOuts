package Visual;

import javax.swing.JButton;

public class BotonVisual {
	private JButton jButton;
	private int fila;
	private int columna;
	
	public BotonVisual(JButton jBoton, int fila, int columna) {
		this.jButton = jBoton;
		this.fila = fila;
		this.columna = columna;
	}
	
	/*Getters y Setters*/
	public JButton getJButon() {
		return this.jButton;
	}
	
	public int getFila() {
		return this.fila;
	}
	
	public int getColumna() {
		return this.columna;
	}
	
}
