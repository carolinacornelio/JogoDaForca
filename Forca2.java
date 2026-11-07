package JogoDaForca;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.Normalizer;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Forca2 extends JFrame {
	
	public static String removerAcentos(String str) {
	    return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("\\p{M}", "");
	}
	
	public void tocarSom(String caminhoSom) {
	    try {
	        URL url = Forca2.class.getResource(caminhoSom);
	        if (url != null) {
	            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
	            Clip clip = AudioSystem.getClip();
	            clip.open(audioIn);
	            clip.start();
	        } else {
	            System.out.println("Som não encontrado: " + caminhoSom);
	        }
	    } catch (Exception ex) {
	        System.out.println("Erro ao tocar o som.");
	        ex.printStackTrace();
	    }
	}
	
	int tentativas=6;
	String palavra = Jogador1.palavraTXT.getText().toUpperCase();
	char[] palavraSecreta = new char[palavra.length()];
	String letrasDigitadas = "";
	String letrasErradas = "";
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
		    if (palavra.charAt(i) == ' ') {
		        tracos[i] = "   "; 
		    } else {
		        tracos[i] = umTracin;
		    }
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
		    calculada += traco; 
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
		
		JLabel lblErradas = new JLabel("");
		lblErradas.setForeground(Color.WHITE); 
		lblErradas.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblErradas.setBounds(23, 60, 500, 40); 
		Fundo.add(lblErradas);
		
		JLabel digiteTXT = new JLabel("Digite a letra:");
		digiteTXT.setBounds(524, 184, 99, 96);
		digiteTXT.setHorizontalAlignment(SwingConstants.CENTER);
		digiteTXT.setForeground(Color.WHITE);
		digiteTXT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Fundo.add(digiteTXT);
		JLabel Forca = new JLabel("");
		Forca.setBounds(23, 100, 287, 493);
		Forca.setIcon(new ImageIcon(Forca2.class.getResource("/img/forca0.png")));
		Fundo.add(Forca);
		
		JButton Enter = new JButton("OK");
		Enter.setBounds(667, 247, 76, 49);
		getRootPane().setDefaultButton(Enter);
		Enter.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String textoDigitado = Letra.getText().toUpperCase();
		        if (textoDigitado.isEmpty()) {
		            return; 
		        }
		        
		        char caractereDigitado = textoDigitado.charAt(0);
		        if (!Character.isLetter(caractereDigitado)) {
		            JOptionPane.showMessageDialog(null, "Por favor, digite apenas letras válidas!");
		            Letra.setText("");
		            Letra.requestFocus();
		            return;
		        }
		        
		        String letraDigitadaSemAcento = removerAcentos(textoDigitado.substring(0, 1));
		        
		        if (letrasDigitadas.contains(letraDigitadaSemAcento)) {
		            JOptionPane.showMessageDialog(null, "Você já tentou a letra '" + letraDigitadaSemAcento + "'! Tente outra.");
		            Letra.setText("");
		            Letra.requestFocus();
		            return; 
		        }

		        letrasDigitadas += letraDigitadaSemAcento;
		        
		        boolean letraEncontrada = false;
		        for (int i=0 ; i<palavra.length() ; i++) {
		            String letraSecretaSemAcento = removerAcentos(String.valueOf(palavraSecreta[i]));

		            if(letraSecretaSemAcento.equalsIgnoreCase(letraDigitadaSemAcento)) {
		                tracos[i] = " " + palavraSecreta[i] + " ";
		                letraEncontrada = true;
		            }
		        }
		        
		        String novaCalculada = "";
		        for (String traco : tracos) {
		            novaCalculada += traco;
		        }
		        tracin.setText(novaCalculada); 

		        if (!letraEncontrada) {					
		            tentativas--;
		            letrasErradas += letraDigitadaSemAcento + " ";
		            lblErradas.setText("Letras erradas: " + letrasErradas);
		            if (tentativas == 0) {
		                tocarSom("/som/derrota.wav");
		            } else {
		                tocarSom("/som/erro.wav");
		            }
		        } else {
		            if (!novaCalculada.contains("_")) {
		                tocarSom("/som/vitoria.wav");
		            } else {
		                tocarSom("/som/acerto.wav"); 
		            }
		        }
		        
		        if (!novaCalculada.contains("_")) {
		            Forca.setIcon(new ImageIcon("./src//img//Venceu.png"));
		            JOptionPane.showMessageDialog(null, Cadastro.user2.getText() + " ganhou de " + Cadastro.user1.getText() + "! A palavra era: " + palavra);
		            setVisible(false);
		            TelaInicial inicio = new TelaInicial();
		            inicio.setVisible(true);
		        }
		      
		        switch (tentativas) {
		            case 5:
		            	Forca.setIcon(new ImageIcon(Forca1.class.getResource("/img/Forca1.png")));
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
		                tentativa.setIcon(new ImageIcon(Forca1.class.getResource(""))); 
		                
		                String revelada = "";
		                for (int i = 0; i < palavra.length(); i++) {
		                    if (palavra.charAt(i) == ' ') {
		                        revelada += "   "; 
		                    } else {
		                        revelada += " " + palavra.charAt(i) + " "; 
		                    }
		                }
		                tracin.setText(revelada);
		                tracin.setForeground(new Color(0,0,0)); 
		                tracin.paintImmediately(tracin.getVisibleRect()); 
		                
		                JOptionPane.showMessageDialog(null, Cadastro.user2.getText() + " perdeu! A palavra era: " + palavra + "! " + Cadastro.user1.getText() + " ganhou");    
		                setVisible(false);
		                TelaInicial inicio = new TelaInicial();
		                inicio.setVisible(true);
		                break;
		        }
		        Letra.setText("");
		        Letra.requestFocus();
		    }
		});
		Fundo.add(Enter);
		
		Letra = new JTextField();
		Letra.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Letra.setHorizontalAlignment(SwingConstants.CENTER);
		Letra.setBounds(524, 247, 99, 49);
		Fundo.add(Letra);
		Letra.setColumns(10);
		
		JLabel dica = new JLabel("<html><div style='text-align: center;'>Dica: " + Jogador1.dicaTXT.getText() + "</div></html>");
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