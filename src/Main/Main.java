package Main;

import java.awt.EventQueue;
import javax.swing.UIManager;
import Controlador.Controlador;
import Visual.Fondo;
import Visual.MainVisual;


import javax.swing.JFrame;

public class Main {
	
	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e) 
		{}
		
		EventQueue.invokeLater(new Runnable() {
			
			//Creamos lo visual
			JFrame frame = new JFrame();
			Fondo fondo = new Fondo();
			MainVisual ventana = new MainVisual(frame,fondo);
			
			//Creamos el controlador
			Controlador controlador = new Controlador();
			
			public void run() {
				try {
					//iniciar parte logica y visual
					controlador.inicializarTableroLogico();
					ventana.initialize();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	
}
