package JogoDaForca;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Forca1 extends JFrame {
	String[] frutas = {"MORANGO","KIWI","BANANA","TAMARINDO","ABACAXI"};
	String[] esportes = {"BASQUETE","FUTEBOL","XADREZ","CORRIDA","SALTO"};
	String[] paises = {"EGITO","ARGENTINA","PERU","ALEMANHA","BANGLADESH"};
	String[] animais = {"CACHORRO","LEOPARDO","COBRA","GATO","GUAXINIM"};
	String[] profissoes = {"ADVOGADO","DENTISTA","POLICIAL","OTORRINO","DIPLOMATA"};
	String[] cores = {"AZUL","VERMELHO","DOURADO","PRETO","CINZA"};
	String[] transportes = {"CARRO","BICICLETA","MOTO","SKATE","NAVIO"};
	String[] planetas = {"MARTE","NETUNO","TERRA","SATURNO","URANO"};
	String[] instrumentos = {"FLAUTA","PIANO","HARPA","PANDEIRO","TAMBOR"};
	String[] estados = {"PERNAMBUCO","BAHIA","AMAZONAS","ACRE","SERGIPE"};	
	String[] categorias = {"Fruta","Esporte","País","Animal","Profissão","Cor","Transporte","Planeta","Instrumento","Estado"};
	double x = Math.random()*10;
	int num = (int)x;
	String palavra = "";
	public static String dica="";
	int tentativas=6;
	String umTracin = "_ ";
	private JTextField Letra;
	private static final long serialVersionUID = 1L;
	private JPanel Fundo;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Forca1 forca1 = new Forca1();
					forca1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Forca1() {
		setTitle("JOGO DA FORCA COM UM JOGADOR");
		setResizable(false);

		int indice = (int)(Math.random()*5);
		switch (num) {
		case 0:
			palavra = frutas[indice];
			dica = "É uma fruta";
			break;
		case 1:
			palavra = esportes[indice];
			dica = "É um esporte";
			break;
		case 2:
			palavra = paises[indice];
			dica = "É um país";
			break;
		case 3:
			palavra = animais[indice];
			dica = "É um animal";
			break;
		case 4:
			palavra = profissoes[indice];
			dica = "É uma profissão";
			break;
		case 5:
			palavra = cores[indice];
			dica = "É uma cor";
			break;
		case 6:
			palavra = transportes[indice];
			dica = "É um meio de transporte";
			break;
		case 7:
			palavra = planetas[indice];
			dica = "É um planeta do sistema solar";
			break;
		case 8:
			palavra = instrumentos[indice];
			dica = "É um instrumento musical";
			break;
		case 9:
			palavra = estados[indice];
			dica = "É um estado do Brasil";
			break;
		}

		char[] palavraSecreta = new char[palavra.length()];
		String[] tracos = new String[palavra.length()];

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
					JOptionPane.showMessageDialog(null, " Você ganhouuu!! A palavra era: " + palavra);
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
					JOptionPane.showMessageDialog(null,"Você perdeu! :(  A palavra era: " + palavra);    
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

		JLabel dica = new JLabel("A dica é: " + JogoDaForca.Forca1.dica);
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