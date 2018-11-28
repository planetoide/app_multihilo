/**
* Programa realizado para el estudio de la implementacion de hilos
*
* @author  Elvis Martínez
* @version 1.0
* @since   2018-10-25 
*/

package tarea_multihilo;

public class Main {

	public static void main(String[] args) {
		//creacion del panel para la interfaz de usuario
		Panel ventana = new Panel();
		ventana.setSize(1300,450);
		ventana.setResizable(false);
		ventana.setLocationRelativeTo(null);
		ventana.setTitle("Aplicacion multi-hilos");
		ventana.setVisible(true);
	}

}
