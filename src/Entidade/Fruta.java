package Entidade;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.JPanel;

import GUI.Frame;

public class Fruta {
	private Random r;
	private int posX,posY;
	private JPanel comp;
	
	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public Fruta() {
		r = new Random();
		posX = r.nextInt(Frame.tela.getWidth()-16);
		posY = r.nextInt(Frame.tela.getHeight()-38);
	}
	
	public void criarLocal(){
		posX = r.nextInt(Frame.tela.getWidth()-16);
		posY = r.nextInt(Frame.tela.getHeight()-38);
	}
	
	public void paint(Graphics g){
		g.drawImage(Toolkit.getDefaultToolkit().getImage("frutaa.png"),
				posX, posY, comp);
	}
}
