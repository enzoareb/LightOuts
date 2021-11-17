package Controlador;


import Logica.MainLogico;

public class Controlador {
	
	public Controlador() {}
	
	public void inicializarTableroLogico() {
		//crea una matriz logica de 4 x 4
		MainLogico.inicializarTableroLogico(4);
	}
	
	public static void actualizarJugadaMatriz(int fila, int columna) {
		//Cambia el estado logico de la matriz, del casillero y sus vecinos
		MainLogico.actualizarEstadoTablero(fila, columna);
	}

	public static boolean hayGanador() {
		//Determina si hay un ganador en la partida llamando al metodo logico de validar partida
		return MainLogico.validarPartida();
	}
		
	public static boolean getEstadoBoton(int i, int j) {
		return MainLogico.getEstadoCasillero(i, j);
	}
	
	public static int getCantMov() {
		return MainLogico.getCantMov();
	}
	
}
