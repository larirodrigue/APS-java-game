package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame {
	public static JFrame tela;
	public static JPanel panel;
	
	/*@Override
	public void paint(Graphics arg0) {
		// TODO Auto-generated method stub
		super.paint(arg0);
		Graphics2D g2 = (Graphics2D) arg0;
		g2.drawImage(imagem, 0, 0, this.getWidth(), this.getHeight(), null);
	}*/
	
	public static void main(String[] args){
		
		
		tela = new JFrame();
		tela.setLayout(null);
		tela.setSize(760, 510);
		tela.setResizable(false);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setLocationRelativeTo(null);
		panel = new Inicio();
		tela.add(panel);
		tela.setVisible(true);
		
	}

}
