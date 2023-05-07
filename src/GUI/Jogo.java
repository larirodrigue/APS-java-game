package GUI;

import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JPanel;
import Entidade.Cobra;
import Entidade.Fruta;
import Entidade.FrutaDourada;
import Entidade.Lixo;

public class Jogo extends JPanel {

	private static final long serialVersionUID = 1L;
	private Fruta fruta;
	private Cobra cobra;
	private FrutaDourada frutadourada;
	private Lixo lixo;
	private boolean perdeu = false;

	public Jogo() {
		cobra = new Cobra(2, this);
		fruta = new Fruta();
		frutadourada = new FrutaDourada();
		lixo = new Lixo();
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
				0, 749, 480, this);
		if(perdeu != true){
		fruta.paint(g);
		frutadourada.paint(g);
		lixo.paint(g);
		//snake.paint(g);
		cobraCresce();
		cobra.paint(g);
		}
	}
	
	public void cobraCresce(){
		if(cobra.crescer(fruta)){
			fruta.criarLocal();
		}
		else if(cobra.crescer(frutadourada)){
			frutadourada.criarLocal2();
		}
		else if(cobra.morrer(lixo)){
			perdeu = cobra.morrer(lixo);
		}
	}
	
}