package GUI;

import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JPanel;
import Entidade.Cobra;
import Entidade.Fruta;

public class Jogo extends JPanel {

	private static final long serialVersionUID = 1L;
	private Fruta fruta;
	private Cobra cobra;

	public Jogo() {
		cobra = new Cobra(10, this);
		fruta = new Fruta();
		this.setSize(Frame.tela.getWidth()-6, Frame.tela.getHeight()-28);
		this.setFocusable(true);
		addKeyListener(cobra);
		cobra.start();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		// Plano de fundo
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Background1.png"), 0,
				0, 749, 470, this);
		
		fruta.paint(g);
		//snake.paint(g);
		cobraCresce();
		cobra.paint(g);
	}
	
	public void cobraCresce(){
		if(cobra.crescer(fruta)){
			fruta.criarLocal();
		}
	}
}