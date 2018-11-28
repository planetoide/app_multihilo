package tarea_multihilo;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Panel extends JFrame{
	//botones para interactuar con la interfaz
	JButton iniciar = new JButton("Jugar");
	JButton detener = new JButton("Detener");
	//carga de las imagenes
	public static String img1="images/campana.jpg",img2="images/cerezas.jpg",img3="images/uvas.jpg", img4="images/siete.jpg";
	//creacion de los contenedores para las imagenes
	public static JLabel uno = new JLabel();
	public static JLabel dos = new JLabel();
	public static JLabel tres = new JLabel();
    public static JLabel cuatro = new JLabel();
        
	//contenedor para los contenedores de imagenes y los botones
	JPanel botones = new JPanel();
	JPanel imagenes = new JPanel();
	
	//instancias para los ditintos hilos
	Hilo1 hilo1 = new Hilo1();
	Hilo2 hilo2 = new Hilo2();
	Hilo3 hilo3 = new Hilo3();
    Hilo4 hilo4 = new Hilo4();
	boolean z = false;
	//constructor
	public Panel(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		//agregar las imagenes a sus respectivos contenedores
		uno.setIcon(new ImageIcon(img1));
		dos.setIcon(new ImageIcon(img2));
		tres.setIcon(new ImageIcon(img3));
        cuatro.setIcon(new ImageIcon(img4));
		//creacion del layout de nuestro panel
		imagenes.setLayout(new FlowLayout());
		//agregar los contenedores de imagenes al layout
		imagenes.add(uno);
		imagenes.add(dos);
		imagenes.add(tres);
        imagenes.add(cuatro);
		//determinar otros layout para los botonesy agregarlos
		botones.setLayout(new GridLayout(2,2));
		botones.add(iniciar);
		botones.add(detener);
		add("Center",imagenes);
		add("South",botones);

	/*### Eventos para los botones, manejo de los hilos ###*/
	//boton de inicio
	iniciar.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent evt){
			if(hilo1.isAlive() == false){
				if(hilo2.isAlive() == false){
					if(hilo3.isAlive() == false){
						if(hilo4.isAlive() == false){
                              hilo1 = new Hilo1();
                              hilo2 = new Hilo2();
                              hilo3 = new Hilo3();
                              hilo4 = new Hilo4();
                              hilo1.activo=true;
                              hilo2.activo=true;
                              hilo3.activo=true;
                              hilo4.activo=true;
                              hilo1.start();
                              hilo2.start();
                              hilo3.start();
                              hilo4.start();
                              z=true;
                          }
					}
				}
			}
		}
	});
	//boton para detener
	detener.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent evt){
			if(z==true){
				hilo1.activo=false;
				hilo2.activo=false;
				hilo3.activo=false;
                hilo4.activo=false;
				if(hilo1.c==hilo2.c){
					if(hilo2.c==hilo3.c){
						if(hilo3.c==hilo4.c){
							JOptionPane.showMessageDialog(Panel.this," Haz ganado ");
                        }
					}
				}
			}
		}
	});

	}
}
