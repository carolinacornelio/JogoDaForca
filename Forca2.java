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

public class Forca2 extends JFrame {
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
					Forca2 forca2 = new Forca2();
					forca2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Forca2() {
		setTitle("JOGO DA FORCA COM DOIS JOGADORES");
		setResizable(false);
		
		for (int i=0 ; i<palavra.length(); i++) {
			palavraSecreta[i] = palavra.charAt(i);
			tracos[i] = umTracin;
		}
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Forca2.class.getResource("/img/Icone.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 680);
		setLocationRelativeTo(null);
		Fundo = new JPanel();
		Fundo.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(Fundo);
		Fundo.setLayout(null);
		
		String calculada = "";
		for(String traco : tracos) {
			calculada += "_ ";
		}
		
		JLabel tentativa = new JLabel("");
		tentativa.setIcon(new ImageIcon(Forca2.class.getResource("/img/tentativa6.png")));
		tentativa.setBounds(742, 39, 434, 63);
		Fundo.add(tentativa);
		
		JLabel tracin = new JLabel(calculada);
		tracin.setBounds(154, 497, 1000, 96);
		tracin.setHorizontalAlignment(SwingConstants.CENTER);
		tracin.setForeground(Color.WHITE);
		tracin.setFont(new Font("Tahoma", Font.PLAIN, 80));
		Fundo.add(tracin);
		
		JLabel digiteTXT = new JLabel("Digite a letra:");
		digiteTXT.setBounds(524, 184, 99, 96);
		digiteTXT.setHorizontalAlignment(SwingConstants.CENTER);
		digiteTXT.setForeground(Color.WHITE);
		digiteTXT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Fundo.add(digiteTXT);
		JLabel Forca = new JLabel("");
		Forca.setBounds(23, 57, 287, 493);
		Forca.setIcon(new ImageIcon(Forca2.class.getResource("/img/forca0.png")));
		Fundo.add(Forca);
		
		JButton Enter = new JButton("OK");
		Enter.setBounds(667, 247, 76, 49);
		Enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			char letraDigitada = Letra.getText().toUpperCase().charAt(0);
               boolean letraEncontrada = false;
				for (int i=0 ; i<palavra.length() ; i++) {
					if((palavraSecreta[i]+"").equalsIgnoreCase(Letra.getText().charAt(0)+"")) {
						tracos[i] = " " + letraDigitada + " ";
                       letraEncontrada = true;
					}
				}
				if (!letraEncontrada) {					
                   tentativas--;
				}
				String novaCalculada = "";
				for (String traco : tracos) {
                   novaCalculada += traco;
               }
               tracin.setText(novaCalculada);
             
               if (!novaCalculada.contains("_")) {
               	Forca.setIcon(new ImageIcon(".//src//img//Venceu.png"));
                   JOptionPane.showMessageDialog(null, Cadastro.user2.getText() + " ganhou de " + Cadastro.user1.getText() + "! A palavra era: " + palavra);
                   setVisible(false);
                   TelaInicial inicio = new TelaInicial();
       				inicio.setVisible(true);
               }
              
               switch (tentativas) {
               case 5:
                   Forca.setIcon(new ImageIcon(".//src//img//Forca1.png"));
                   tentativa.setIcon(new ImageIcon(Forca2.class.getResource("/img/tentativa5.png")));
                   break;
               case 4:
                   Forca.setIcon(new ImageIcon(".//src//img//Forca2.png"));
                   tentativa.setIcon(new ImageIcon(Forca2.class.getResource("/img/tentativa4.png")));
                   break;
               case 3:
                   Forca.setIcon(new ImageIcon(".//src//img//Forca3.png"));
                   tentativa.setIcon(new ImageIcon(Forca2.class.getResource("/img/tentativa3.png")));
                   break;
               case 2:
                   Forca.setIcon(new ImageIcon(".//src//img//Forca4.png"));
                   tentativa.setIcon(new ImageIcon(Forca2.class.getResource("/img/tentativa2.png")));
                   break;
               case 1:
                   Forca.setIcon(new ImageIcon(".//src//img//Forca5.png"));
                   tentativa.setIcon(new ImageIcon(Forca2.class.getResource("/img/tentativa1.png")));
                   break;
               case 0:
               	Forca.setIcon(new ImageIcon(".//src//img//Forca6.png"));
                tentativa.setIcon(new ImageIcon(Forca2.class.getResource("")));
               	JOptionPane.showMessageDialog(null, Cadastro.user2.getText() + " perdeu! A palavra era: " + palavra + "! " + Cadastro.user1.getText() + " ganhou");    
                   setVisible(false);
                   TelaInicial inicio = new TelaInicial();
                   inicio.setVisible(true);
                   break;
           }
               Letra.setText("");
			}
		});
		Fundo.add(Enter);
		
		Letra = new JTextField();
		Letra.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Letra.setHorizontalAlignment(SwingConstants.CENTER);
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
		lblNewLabel.setBounds(0, -13, 1186, 654);
		lblNewLabel.setIcon(new ImageIcon(Forca2.class.getResource("/img/Fundo.png")));
		Fundo.add(lblNewLabel);
		
	}
}