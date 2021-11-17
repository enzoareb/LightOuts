package Visual;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Toolkit;
import Controlador.Controlador;


public class MainVisual {

	private JFrame frame;
	private TableroDeBotones botones;
	private Fondo fondo;

	

	public MainVisual(JFrame frame, Fondo fondo) {
		this.frame = frame;
		this.fondo = fondo;
		
	}	
	

	public void initialize() {
		
		// Inicializa los contenidos del frame
		frame = new JFrame();
		frame.setContentPane(fondo);
		this.frame.setBounds(350, 100, 650, 500);
		
		this.frame.getContentPane().setLayout(new GridLayout(4, 4, 0, 0));
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setVisible(true);
		this.frame.setTitle("Ligths Out!   " + "   Movimientos: " + Controlador.getCantMov());
		this.frame.setIconImage(Toolkit.getDefaultToolkit().getImage(MainVisual.class.getResource("/imagenes/boton_rojo_encendido(100px).png")));
		
		// Crea el tablero visual y lo llena de botones
		botones = new TableroDeBotones(frame, 4);
		botones.llenarTablero();
		

	}
	

}
			


