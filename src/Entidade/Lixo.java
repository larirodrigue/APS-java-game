package Entidade;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.JPanel;

import GUI.Frame;

public class Lixo {
	private Random a;
	private int posX,posY;
	private JPanel comp;
	
	public Lixo(Random a, int posX, int posY, JPanel comp) {
		this.a = a;
		this.posX = posX;
		this.posY = posY;
		this.comp = comp;
	}

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

	public Lixo() {
		a = new Random();
		posX = a.nextInt(Frame.tela.getWidth()-16);
		posY = a.nextInt(Frame.tela.getHeight()-38);
	}
	
	public void criarLocal3(){
		posX = a.nextInt(Frame.tela.getWidth()-16);
		posY = a.nextInt(Frame.tela.getHeight()-38);
	}
	
	public void paint(Graphics g){
		g.drawImage(Toolkit.getDefaultToolkit().getImage("macadourada.png"),
				posX, posY, comp);
	}
} 
