package Visual;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import Controlador.Controlador;



public class TableroDeBotones {
	private JFrame frame;
	public static BotonVisual[][] botones;
	
	
	public TableroDeBotones(JFrame frame, int cantidad) {
		this.frame = frame;
		botones = new BotonVisual[cantidad][cantidad];
		
	}
	
	public void llenarTablero() {
		
		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones[0].length; j++) {

				JButton jboton = new JButton();
				BotonVisual boton = new BotonVisual(jboton, i, j);
				
				setIconoBoton(boton);
				agregarEventoBoton(boton);
				
				boton.getJButon().setContentAreaFilled(false);
				
				frame.getContentPane().add(boton.getJButon());
				botones[i][j] = boton;
				
			}
		}
	}
	
	private void agregarEventoBoton(BotonVisual boton) {
		boton.getJButon().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				realizarJugada(boton);
				if(Controlador.hayGanador()) {
					//pantallita de ganador
					desactivarBotones();
					frame.setTitle("Ligths Out!   " + "   Movimientos : " + Controlador.getCantMov());
					JOptionPane.showMessageDialog(frame, "Felicitaciones has ganado el juego!" 
					+ "\nMovimientos Totales: " + Controlador.getCantMov());
					return;
				}
				
				frame.setTitle("Ligths Out!   " + "   Movimientos: " + Controlador.getCantMov());
			}
		});	
		
		boton.getJButon().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				//cuando el cursor entra dentro del boton ocurre el evento y cambia el boton de color
				setIconoBotonOpuesto(boton);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				//cuando sale el cursor del boton el color de ese boton se setea como debe ser
				setIconoBoton(boton);
			}
		});
	}
	
	private void setIconoBoton(BotonVisual boton) {
		//llama al controlador que verifica el estado del boton llamando al metodo Logico y le asigna la
		//imagen que le corresponde de acuerdo a su estado
		if(Controlador.getEstadoBoton(boton.getFila(), boton.getColumna())) {
			
			boton.getJButon().setIcon(new ImageIcon(TableroDeBotones.class.getResource("/imagenes/boton_rojo_encendido(100px).png")));
		}
		else {
			boton.getJButon().setIcon(new ImageIcon(TableroDeBotones.class.getResource("/imagenes/boton_rojo_apagado(95px).png")));
		}
		
	}
	
	private void realizarJugada(BotonVisual boton) {
		//realiza una jugada en la matriz logica, actualizando el estado, llamando al controlador
		Controlador.actualizarJugadaMatriz(boton.getFila(), boton.getColumna());
		//establece la imagen correspondiente al nuevo estado del tablero
		setIconoBotones();
	}
	
	private void setIconoBotonOpuesto(BotonVisual boton) {
		//llama al controlador que verifica el estado del boton llamando al metodo Logico y le asigna la
		//imagen que le corresponde de acuerdo a su estado
		if(Controlador.getEstadoBoton(boton.getFila(), boton.getColumna())) {
			
			boton.getJButon().setIcon(new ImageIcon(TableroDeBotones.class.getResource("/imagenes/boton_rojo_apagado(100px).png")));
		}
		else {
			boton.getJButon().setIcon(new ImageIcon(TableroDeBotones.class.getResource("/imagenes/boton_rojo_encendido(100px).png")));
		}
		
	}
	
	private void setIconoBotones() {
		
		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones[0].length; j++) {
				setIconoBoton(botones[i][j]);
			}
		}
	}
	
	private void desactivarBotones() {
		//Desactiva los botones una vez que se determina una partida ganada
		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones[0].length; j++) {
				botones[i][j].getJButon().setEnabled(false);
			}
		}
	}
	
}



