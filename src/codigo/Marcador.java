

package codigo;

import java.awt.Color;
import java.awt.Font;

import acm.graphics.GLabel;
import acm.graphics.GRect;


public class Marcador extends GRect{

	GLabel texto = new GLabel("");

	public Marcador(double width, double height){// Arkanoid_arkanoid
		super(width, height);
		setFilled(true);
		setFillColor(Color.WHITE);
		texto.setLabel("HOLA");
		texto.setFont(new Font("Arial", Font.BOLD, 18));
		//_arkanoid 
	}
	public void dibuja(Arkanoid _arkanoid){
		_arkanoid.add(this, _arkanoid.getWidth() - 40, getY());	
		_arkanoid.add(texto, _arkanoid.getWidth() - 40, getY()+30);
	}
}
