package codigo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import acm.graphics.GLabel;
import acm.graphics.GRect;

/*
 * Autor: Jorge Cisneros
 * 
 * El Arkanoid pero orientado a objetos
 */

public class Arkanoid extends acm.program.GraphicsProgram{

	Pelota pelota1 = new Pelota(7, Color.MAGENTA);//tamaño de la bola
	//Pelota pelota2 = new Pelota(30, Color.BLUE);
	Barra barra1 = new Barra(60, 15, Color.GREEN);//tamaño de la touch bar (x,y) 
	int anchoLadrillo = 25;
	int altoLadrillo = 15;
	int espacioMenu = 200;
	//El sistema del marcador
	int puntuacion = 0;
	Marcador marcador = new Marcador(20, 40);//tamaño del marcador (x,y)
	//GLabel marcador = new GLabel("0");
	//GRect cajaMarcador = new GRect(20, 40);

	public void init(){
		addMouseListeners();
		setSize(600, 600);//Define el tamaño de la consola predeterminado
		GRect lateral = new GRect(5, getWidth() + espacioMenu); //Tamaño de la barrita dre en medio, que dería saber moverlo por mi cuenta
		lateral.setFilled(true);//Define que es cierto que hay un lateral situado
		add(lateral, getWidth() - espacioMenu - lateral.getWidth() - pelota1.getWidth(), 0);//Indica
		add(pelota1, 0, getHeight()*0.60 - pelota1.getWidth());
		//add(pelota2, 0, getHeight()*0.70 - pelota2.getHeight());
		add(barra1, 0 , getHeight()*0.80);
		//cajaMarcador.setFilled(true);
		//cajaMarcador.setFillColor(Color.YELLOW);
	}

	public void run(){
		dibujaNivel01();
		marcador.dibuja(this);
		//add(marcador, 5, 0);
		add(marcador.texto, 300, 300);//lo de dentro modifica su ubicación en la consola (x, y)
		//add(cajaMarcador, 5, 0);
		//add(marcador, 10, 20);
		//marcador.setFont(new Font("Arial", Font.BOLD, 18));
		while (true){
			pelota1.muevete(this);
			//pelota2.muevete(this);
			barra1.mueveBarra((int)pelota1.getX(), getWidth() - espacioMenu);//(int)pelota1. entre mueve barra y el get x
			pause(2);
		}
	}

	public void mouseMoved (MouseEvent evento){
		barra1.mueveBarra(evento.getX(), getWidth() - espacioMenu);
	}

	private void dibujaNivel01(){
		int numLadrillos = 14; 
		for (int j=0; j < numLadrillos; j++){
			for(int i=j; i < numLadrillos; i++){
				Ladrillo miLadrillo =
						new Ladrillo(anchoLadrillo*i - anchoLadrillo*j/2,
								altoLadrillo*j,
								anchoLadrillo, 
								altoLadrillo, 
								Color.RED);

				add(miLadrillo);
				pause(7);
			}
		}
	}
}











