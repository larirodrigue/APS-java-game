package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Inicio extends JPanel implements ActionListener {
	
	private ImageIcon imagem;
	private JButton btnNewGame;
	private JButton btnLoadGame;
	private JButton btnHighScoores;
	private JButton btnOptions;
	private JButton btnHelp;
	private JButton btnCredits;
	private JButton btnQuit;
	
	@Override
	public void actionPerformed(ActionEvent ar) {
		// TODO Auto-generated method stub
		if(ar.getSource() == btnQuit ){
			System.exit(0);
		}
		if(ar.getSource() == btnNewGame ){
			
			Jogo jogo = new Jogo();
			Frame.tela.removeNotify();
			Frame.tela = new JFrame();
			Frame.tela.setLayout(null);
			Frame.tela.setSize(760, 510);
			Frame.tela.setResizable(false);
			Frame.tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Frame.tela.setLocationRelativeTo(null);
			Frame.tela.add(jogo);
			Frame.tela.setVisible(true);
			//Frame.tela.validate();
			//Frame.tela.repaint();
		}
	}
	
	public Inicio() {
		this.setSize(Frame.tela.getWidth(), Frame.tela.getHeight());
		
		this.setLayout(null);
		
		btnNewGame = new JButton("NOVO JOGO");
		btnNewGame.setBounds(429, 85, 182, 30);
		btnNewGame.addActionListener(this);
		this.add(btnNewGame);
		
		btnLoadGame = new JButton("CARREGAR JOGO");
		btnLoadGame.setBounds(429, 133, 182, 30);
		this.add(btnLoadGame);
		
		btnHighScoores = new JButton("RECORDE");
		btnHighScoores.setBounds(429, 182, 182, 30);
		btnHighScoores.addActionListener(this);
		this.add(btnHighScoores);
		
		btnOptions = new JButton("OPÇÕES");
		btnOptions.setBounds(429, 233, 182, 30);
		btnOptions.addActionListener(this);
		this.add(btnOptions);
		
		btnHelp = new JButton("AJUDA");
		btnHelp.setBounds(429, 284, 182, 30);
		btnHelp.addActionListener(this);
		this.add(btnHelp);
		
		btnCredits = new JButton("CREDITOS");
		btnCredits.setBounds(429, 336, 182, 30);
		btnCredits.addActionListener(this);
		this.add(btnCredits);
		
		btnQuit = new JButton("SAIR");
		btnQuit.setBounds(429, 387, 182, 30);
		btnQuit.addActionListener(this);
		this.add(btnQuit);
		
		imagem = new ImageIcon("background2.png");
		JLabel lblNewLabel = new JLabel(imagem);
		lblNewLabel.setBounds(0, 0, 749,470);
		this.add(lblNewLabel);
	}
	
}
