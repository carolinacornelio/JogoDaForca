package JogoDaForca;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Forca extends JFrame {
	int tentativas=6;
	String palavra = Jogador1.palavraTXT.getText().toUpperCase();
	char[] palavraSecreta = new char[palavra.length()];
	String[] tracos = new String[palavra.length()];
	private static final long serialVersionUID = 1L;
	private JPanel Fundo;
	private JTextField Letra;
	String umTracin = "_ ";

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Forca forca = new Forca();
					forca.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Forca() {
		
		for (int i=0 ; i<palavra.length(); i++) {
			palavraSecreta[i] = palavra.charAt(i);
			tracos[i] = umTracin;
		}
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Forca.class.getResource("/img/Icone.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 680);
		setLocationRelativeTo(null);
		Fundo = new JPanel();
		Fundo.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(Fundo);
		Fundo.setLayout(null);
		
		String calculada = "";
		for(String traco : tracos) {
			calculada = calculada + "_ ";
		}
		
		JLabel tracin = new JLabel(calculada);
		tracin.setBounds(150, 454, 1000, 96);
		tracin.setHorizontalAlignment(SwingConstants.CENTER);
		tracin.setForeground(Color.WHITE);
		tracin.setFont(new Font("Tahoma", Font.PLAIN, 95));
		Fundo.add(tracin);
		
		JLabel digiteTXT = new JLabel("Digite a letra:");
		digiteTXT.setBounds(524, 184, 99, 96);
		digiteTXT.setHorizontalAlignment(SwingConstants.CENTER);
		digiteTXT.setForeground(Color.WHITE);
		digiteTXT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Fundo.add(digiteTXT);

		JLabel Forca = new JLabel("");
		Forca.setBounds(23, 57, 287, 493);
		Forca.setIcon(new ImageIcon(Forca.class.getResource("/img/forca0.png")));
		Fundo.add(Forca);
		
		JButton Enter = new JButton("OK");
		Enter.setBounds(667, 247, 76, 49);
		Enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char letraDigitada = Letra.getText().toUpperCase().charAt(0);
                boolean letraEncontrada = false;
				for (int i=0 ; i<palavra.length() ; i++) {
					if(palavraSecreta[i] == Letra.getText().charAt(0)) {
						tracos[i] = " " + letraDigitada + " ";
                        letraEncontrada = true;
					} 
				}
				if (!letraEncontrada) {
                    tentativas--;
				}
				String novaExibicao = "";
                for (String traco : tracos) {
                    novaExibicao += traco;
                }
                tracin.setText(novaExibicao);
                
                if (tentativas == 0) {
                    JOptionPane.showMessageDialog(null, "Você perdeu! A palavra era: " + palavra);
                    setVisible(false);
                    TelaInicial inicio = new TelaInicial();
                    inicio.setVisible(true);
                } else if (!novaExibicao.contains("_")) {
                	Forca.setIcon(new ImageIcon(".//src//img//Forca6.png"));
                    JOptionPane.showMessageDialog(null, Cadastro.user1.getText() + " ganhou de " + Cadastro.user2.getText() + "! A palavra era: " + palavraSecreta);
                    setVisible(false);
                    TelaInicial inicio = new TelaInicial();
        			inicio.setVisible(true);
                }
                /* else if (!novaExibicao.contains("_")) {
                    JOptionPane.showMessageDialog(null, "Parabéns, você ganhou!");
                    setVisible(false);
                    TelaInicial inicio = new TelaInicial();
                    inicio.setVisible(true);
                }*/
                
                switch (tentativas) {
                case 5:
                    Forca.setIcon(new ImageIcon(".//src//img//Forca1.png"));
                    break;
                case 4:
                    Forca.setIcon(new ImageIcon(".//src//img//Forca2.png"));
                    break;
                case 3:
                    Forca.setIcon(new ImageIcon(".//src//img//Forca3.png"));
                    break;
                case 2:
                    Forca.setIcon(new ImageIcon(".//src//img//Forca4.png"));
                    break;
                case 1:
                    Forca.setIcon(new ImageIcon(".//src//img//Forca5.png"));
                    break;
               /* case 0:
                    Forca.setIcon(new ImageIcon(".//src//img//Forca6.png"));
                    JOptionPane.showMessageDialog(null, Cadastro.user1.getText() + " ganhou de " + Cadastro.user2.getText() + "! A palavra era: " + palavraSecreta);
                    setVisible(false);
                    TelaInicial inicio = new TelaInicial();
        			inicio.setVisible(true);
                    break;*/
            }
			}
		});
		Fundo.add(Enter);
		
		Letra = new JTextField();
		Letra.setBounds(524, 247, 99, 49);
		Fundo.add(Letra);
		Letra.setColumns(10);
		
		JLabel dica = new JLabel("A dica é: " + Jogador1.dicaTXT.getText());
		dica.setBounds(424, 86, 434, 96);
		dica.setHorizontalAlignment(SwingConstants.CENTER);
		dica.setForeground(Color.WHITE);
		dica.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Fundo.add(dica);
									
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 1186, 643);
		lblNewLabel.setIcon(new ImageIcon(Forca.class.getResource("/img/Fundo.png")));
		Fundo.add(lblNewLabel);
		
		for(int i = 0; i < palavra.length(); i++) {
			
		}
	}
}