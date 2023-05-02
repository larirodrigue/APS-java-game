package Entidade;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import GUI.Frame;

public class Cobra extends Thread implements KeyListener {
	private int nroNos;
	private No primeiro;
	private No ultimo;
	private int posicao;
	private JPanel comp;
	
	public Cobra(int tamanho,JPanel comp){
		nroNos = 0;
		posicao = 3;
		this.comp = comp;
		primeiro = null;
		ultimo = null;
		for(int i = 0;i < tamanho;i++){
			Corpo corpo = new Corpo();
			corpo.setPosX(100 - (i * 10));
			corpo.setPosY(100);
			addCorpo(corpo);
		}
	}
	
	private void listaTodos(){
		No noTemp = primeiro;
		for(int i = 0;i<nroNos;i++){
		System.out.println(nroNos+"  "+noTemp.getCorpo().getPosX()+" "+noTemp.getCorpo().getPosY());
		noTemp = noTemp.getProx();
		}
	}
	
	private boolean isVazia(){
		return (primeiro == null && ultimo == null);
	}
	private void seColide(){
		No noTemp = primeiro.getProx();
		for(int i =1;i<nroNos;i++){
			if((primeiro.getCorpo().getPosX() == noTemp.getCorpo().getPosX())&&
					(primeiro.getCorpo().getPosY() == noTemp.getCorpo().getPosY())){
				JOptionPane.showMessageDialog(comp, "FIM DE JOGO\n\nPONTUAÇÃO: "+(nroNos*10));
				System.exit(0);
			}else{
				noTemp = noTemp.getProx();
			}
		}
	}
	
	private boolean Bateu(){
		return (((primeiro.getCorpo().getPosX() < 0)||(primeiro.getCorpo().getPosX()+10<0))
				|| ((primeiro.getCorpo().getPosX() > Frame.tela.getWidth())
						||(primeiro.getCorpo().getPosX()+10 > Frame.tela.getWidth()))
				|| ((primeiro.getCorpo().getPosY() < 0)||(primeiro.getCorpo().getPosY()+10 < 0))
				|| ((primeiro.getCorpo().getPosY() > Frame.tela.getHeight()-30)
						||(primeiro.getCorpo().getPosY()+10 > Frame.tela.getHeight()-30)));
	}
	
 	private void addCorpo(Corpo corpo){
		nroNos++;
		No novoNo = new No(corpo);
		if(isVazia()){
			ultimo = novoNo;
			primeiro = novoNo;
		}
		else{
			novoNo.setProx(primeiro);
			ultimo.setProx(novoNo);
			primeiro = novoNo;
		}
	}



	public boolean crescer(Fruta fruta){
		Corpo corpo = ultimo.getCorpo();
		if(((corpo.getPosX() >= fruta.getPosX() && corpo.getPosX() <=fruta.getPosX()+10)||
				(corpo.getPosX()+10>= fruta.getPosX() && corpo.getPosX()+10 <=fruta.getPosX()+10)) &&
				((corpo.getPosY()>=fruta.getPosY() && corpo.getPosY() <= fruta.getPosY()+10)||
				(corpo.getPosY()+10>=fruta.getPosY()&&corpo.getPosY()+7<=fruta.getPosY()+10))){
			corpo = new Corpo();
			addCorpo(corpo);
			return true;
		}
		return false;
	}
	public boolean crescer(FrutaDourada frutadourada){
		Corpo corpo = ultimo.getCorpo();
		if(((corpo.getPosX() >= frutadourada.getPosX() && corpo.getPosX() <=frutadourada.getPosX()+20)||
				(corpo.getPosX()+20>= frutadourada.getPosX() && corpo.getPosX()+20 <=frutadourada.getPosX()+20)) &&
				((corpo.getPosY()>=frutadourada.getPosY() && corpo.getPosY() <= frutadourada.getPosY()+20)||
				(corpo.getPosY()+20>=frutadourada.getPosY()&&corpo.getPosY()+7<=frutadourada.getPosY()+20))){
			corpo = new Corpo();
			addCorpo(corpo);
			return true;
		}
		return false;
	}
	
	public void mover(int posicao){
		if(posicao == 1){
			primeiro.getCorpo().setPosX(ultimo.getCorpo().getPosX());
			primeiro.getCorpo().setPosY(ultimo.getCorpo().getPosY()-10);
			listaTodos();
		}
		else if(posicao == 2){
			primeiro.getCorpo().setPosX(ultimo.getCorpo().getPosX());
			primeiro.getCorpo().setPosY(ultimo.getCorpo().getPosY()+10);
			listaTodos();
		}
		else if(posicao == 3){
			primeiro.getCorpo().setPosX(ultimo.getCorpo().getPosX()+10);
			primeiro.getCorpo().setPosY(ultimo.getCorpo().getPosY());
			listaTodos();
		}
		else if(posicao == 4){
			primeiro.getCorpo().setPosX(ultimo.getCorpo().getPosX()-10);
			primeiro.getCorpo().setPosY(ultimo.getCorpo().getPosY());
			listaTodos();
		}
		seColide();
		if (Bateu()){
			JOptionPane.showMessageDialog(comp, "FIM DE JOGO\n\nPONTUAÇÃO: "+(nroNos*10));
			System.exit(0);
		}
		ultimo = primeiro;
		primeiro = primeiro.getProx();
	}
	
	public void paint(Graphics g) {
		No noTemp = ultimo;

		g.drawImage(Toolkit.getDefaultToolkit().getImage("cobraa.png"),
			noTemp.getCorpo().getPosX(), noTemp.getCorpo().getPosY(), comp);
		noTemp = noTemp.getProx();

		for(int i = 1;i<nroNos;i++){ 
			g.drawImage(Toolkit.getDefaultToolkit().getImage("cobracorpo.png"),
			noTemp.getCorpo().getPosX(), noTemp.getCorpo().getPosY(), comp);
			noTemp = noTemp.getProx();
		}
	}
	@Override
	public void run() {
		while (true) {
			// TODO Auto-generated method stub
			this.mover(posicao);
			comp.repaint();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == 38) {
			if (posicao != 2)
				posicao = 1;
		} else if (e.getKeyCode() == 40) {
			if (posicao != 1)
				posicao = 2;
		} else if (e.getKeyCode() == 39) {
			if (posicao != 4)
				posicao = 3;
		} else if (e.getKeyCode() == 37) {
			if (posicao != 3)
				posicao = 4;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
