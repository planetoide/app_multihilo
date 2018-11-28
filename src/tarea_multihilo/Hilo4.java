package tarea_multihilo;

import java.util.Random;

import javax.swing.ImageIcon;

public class Hilo4 extends Thread {
	boolean activo=true; //determina si el hilo esta activado o desactivado
	Random img = new Random(); //para hacer random sobre los nombres de las imagenes
	Random time = new Random(); //para hacer un random en el tiempo
	int i=0; //determina los casos para el uso de las imagenes
	int tiempo=0; //especifica el tiempo de sleep para el hilo
	int c=0; //para determinar la coincidencia de imagenes
	 
	//definicion del metodo run propio de los threads
	@Override
	public void run(){
		while(activo==true){
			i=img.nextInt(5);
			tiempo=time.nextInt(100);
			if(i==1){
				Panel.cuatro.setIcon(new ImageIcon(Panel.img1));
				c=1;
			}
			if(i==2){
				Panel.cuatro.setIcon(new ImageIcon(Panel.img2));
				c=2;
			}
			if(i==3){
				Panel.cuatro.setIcon(new ImageIcon(Panel.img3));
				c=3;
			}
            if(i==4){
				Panel.cuatro.setIcon(new ImageIcon(Panel.img4));
				c=4;
			}
			try{
				sleep(tiempo);
			}catch(InterruptedException e){
				System.out.println("Ha ocurrido un error " + e);
			}
		}
	}
}
