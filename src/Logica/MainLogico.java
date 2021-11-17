package Logica;

import java.util.Random;

public class MainLogico {
	
	private static Casillero[][] tablero;
	private static int cantMovimientos = 0;
	
	
	public static void inicializarTableroLogico(int cantidad) {
		//crea una matriz cuadrada de x cantidad y agrega valores booleanos random
		tablero = new Casillero[cantidad][cantidad];
		
		for (int i = 0; i < cantidad; i++) {
			for (int j = 0; j < cantidad; j++) {
				Random random = new Random();
				boolean valor = random.nextBoolean();
				//boolean valor = true;
				tablero[i][j] = new Casillero(valor, i, j);
			}
		}
	}
	
	private static void cambiarEstadoBoton(int i ,int j) {
		//cambia el estado del casillero al opuesto
		if (getEstadoCasillero(i, j)) {
			tablero[i][j].setState(false);
		}else {
			tablero[i][j].setState(true);;
		}
	}
	
	private static boolean existeBoton(int i,int j) {
		if ((i<0 || i >=tablero.length) || (j<0 || j >=tablero.length)) {
				return false;
		}
		return true;
	}
	
	private static void cambiarEstadoVecinos(int i,int j) {
		//cambia el estado de los casilleros adyacentes al pasado por parametro
		if(existeBoton(i-1, j)) 
			cambiarEstadoBoton(i-1, j);
		if(existeBoton(i+1, j)) 
			cambiarEstadoBoton(i+1, j);
		if(existeBoton(i, j-1)) 
			cambiarEstadoBoton(i, j-1);
		if(existeBoton(i, j+1)) 
			cambiarEstadoBoton(i, j+1);
	}
	
	public static void actualizarEstadoTablero(int i, int j) {
		//actualiza el estado de la matriz a partir del casillero pasado por parametro y aumenta el contador de mov
		cantMovimientos++;
		cambiarEstadoBoton(i, j);
		cambiarEstadoVecinos(i,j);
	}


	public static boolean getEstadoCasillero(int i, int j) {
		//retorna el estado actual del casillero
		return tablero[i][j].isState();
	}
	
	
	public static boolean validarPartida() {
		//recorre la matriz y verifica que todos sus valores sean falso
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[0].length; j++) {
				if (getEstadoCasillero(i, j))
					return false;
			}
		}
		return true;
	}
	
	public static int getCantMov() {
		return cantMovimientos;
	}
	
}
