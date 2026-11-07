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
import java.text.Normalizer;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;
import java.util.ArrayList;	

public class Forca1 extends JFrame {
	
	public static String removerAcentos(String str) {
	    return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("\\p{M}", "");
	}
	
	public void tocarSom(String caminhoSom) {
	    try {
	        URL url = Forca1.class.getResource(caminhoSom);
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
	
	String[] pessoas = {"TURING","LOVELACE","BABBAGE","PAUL ALLEN","G HOPPER"};
	String[] maquinas = {"ÁBACO","PASCALINE","ENIAC","MARK I","TRANSISTOR"};
	String[] unidades = {"BIT","BYTE","GIGABYTE","HERTZ","KILOBYTE"};
	String[] bases = {"BINÁRIO","OCTAL","ASCII","OVERFLOW","UM ZERO"};
	String[] memoria = {"RAM","ROM","CACHE","SSD","VOLÁTIL"};
	String[] microprocessadores = {"ULA","NÚCLEO","CLOCK","PIPELINE","THREADS"};
	String[] linguagens = {"ASSEMBLY","FORTRAN","HTML","JAVASCRIPT","PYTHON"};
	String[] leis = {"LICENÇA","SHAREWARE","FREEWARE","LGPD","GDPR"};
	String[] ia = {"ROBÓTICA","MYCIN","LISP","PERCEPTRON","LLMS"};
	String[] es = {"KANBAN","SCRUM","SPRINTS","BACKLOG","CASCATA"};
	
	String[] pessoasd = {"Sobrenome do homem considerado o pai da computação e da Inteligência Artificial","Sobrenome de quem escreveu o primeiro algoritmo para uma máquina, sendo considerada a primeira programadora","Sobrenome do projetista da máquina analítica, precursor do computador moderno","Em parceria com Bill Gates, foi fundador da Microsoft, a maior e mais conhecida empresa de software do mundo","Criou o primeiro compilador e popularizou o termo 'bug'"};
	String[] maquinasd = {"O mais antigo instrumento de cálculo conhecido pela humanidade","Primeiro dispositivo mecânico de calcular","Primeiro computador eletrônico digital de grande escala; usava válvulas","Primeiro computador eletromecânico de propósito geral","Componente que substituiu as válvulas, permitindo computadores menores e mais rápidos"};
	String[] unidadesd = {"Menor unidade de informação, representada por zero ou um","Conjunto de 8 bits, usado para representar caracteres e símbolos","Unidade que equivale a 1024 Megabytes, comum em memórias e HDs","Medida de frequência que define a velocidade (clock) do processador","Unidade de medida que representa aproximadamente mil bytes"};
	String[] basesd = {"Sistema de numeração de base 2, única língua que o computador entende","Base 8 usada por programadores para representar endereços de memória","Tabela padrão que mapeia números para letras e símbolos do teclado","Erro que ocorre quando o resultado de um cálculo é maior que o espaço disponível","Forma correta de se ler resultado da operação 1+1 em binário"};
	String[] memoriad = {"Memória volátil que armazena os dados enquanto o computador está ligado","Memória apenas de leitura que contém as instruções de inicialização do sistema","Memória de acesso ultrarrápido localizada dentro do próprio processador","Armazenamento secundário moderno que substitui o HD por ser muito mais rápido","Característica de memórias que perdem os dados ao ficar sem energia"};
	String[] microprocessadoresd = {"O cérebro do computador, que faz os cálculos e comparações","Unidade de processamento independente dentro da CPU que consegue executar seu próprio ciclo de instrução","Sinal de sincronização que define o ritmo de trabalho do processador","Técnica que permite executar múltiplas instruções em diferentes estágios","Representam múltiplas tarefas executadas de forma concorrente ou paralela"};
	String[] linguagensd = {"Linguagem de nível imediatamente acima da linguagem de máquina","Primeira linguagem de programação de alto nível amplamente utilizada, criada em 1954","Linguagem de marcação muito utilizada em páginas web. Permite a formatação de textos e imagens","A linguagem padrão para criar interatividade e lógica em sites web","Linguagem de alto nível muito usada em Ciência de Dados e Automação"};
	String[] leisd = {"Documento que autoriza o uso do programa, enquanto a propriedade fica com o dono","Produto de software que pode ser copiado livremente para avaliação, mas que requer o pagamento de uma licença no caso de uso continuado","Software gratuito que pode ser utilizado livremente","Lei que regula o tratamento de dados pessoais por empresas, organizações ou órgãos públicos","Lei que estabelece direitos robustos para os indivíduos e exige que as organizações adotem medidas apropriadas para proteger os dados pessoais"};
	String[] iad = {"Disciplina que permite à máquina interagir com o mundo físico","Sistema especialista para diagnosticar infecções sanguíneas","Linguagem dominante na IA por 30 anos, definida por McCarthy","Modelo de neurônio artificial desenvolvido por Frank Rosenblatt","Sistemas de IA baseados em aprendizado profundo treinados com conjuntos massivos de textos"};
	String[] esd = {"Framework ágil que permite visualizar o fluxo de trabalho em um quadro","Metodologia muito utilizada para gerenciar projetos maiores e complexos","Reuniões de planejamento no Scrum que geralmente acontecem a cada quinzena","Lista organizada que reúne todos os requisitos de um projeto","Nome popular do ciclo de vida clássico que adota uma abordagem sequencial"};
	
	String[] categorias = {"pessoas","maquinas","unidades","bases","memoria","microprocessadores","linguagens","leis","ia","es"};
	
	public static ArrayList<String> sorteadas = new ArrayList<>();
 	String palavra = "";
 	String letrasDigitadas = "";
 	String letrasErradas = "";
 	String umTracin = "_ ";
 	private JTextField Letra;
 	public static String dica="";
	int tentativas=6;
	int num = (int) (Math.random()*categorias.length);
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
		
		if (sorteadas.size() >= 50) {
		    sorteadas.clear();
		}
		boolean jaSorteada;
		
		do {
		    num = (int) (Math.random() * categorias.length);
		    int indice = (int) (Math.random() * 5);

		    switch (num) {
		        case 0:
		            palavra = pessoas[indice];
		            dica = pessoasd[indice];
		            break;
		        case 1:
		            palavra = maquinas[indice];
		            dica = maquinasd[indice];
		            break;
		        case 2:
		            palavra = unidades[indice];
		            dica = unidadesd[indice];
		            break;
		        case 3:
		            palavra = bases[indice];
		            dica = basesd[indice];
		            break;
		        case 4:
		            palavra = memoria[indice];
		            dica = memoriad[indice];
		            break;
		        case 5:
		            palavra = microprocessadores[indice];
		            dica = microprocessadoresd[indice];
		            break;
		        case 6:
		            palavra = linguagens[indice];
		            dica = linguagensd[indice];
		            break;
		        case 7:
		            palavra = leis[indice];
		            dica = leisd[indice];
		            break;
		        case 8:
		            palavra = ia[indice];
		            dica = iad[indice];
		            break;
		        case 9:
		            palavra = es[indice];
		            dica = esd[indice];
		            break;
		    }

		    jaSorteada = sorteadas.contains(palavra);

		} while (jaSorteada);

		sorteadas.add(palavra);
		
		char[] palavraSecreta = new char[palavra.length()];
		String[] tracos = new String[palavra.length()];
		for (int i=0 ; i<palavra.length(); i++) {
		    palavraSecreta[i] = palavra.charAt(i);
		    if (palavra.charAt(i) == ' ') {
		        tracos[i] = "   "; 
		    } else {
		        tracos[i] = umTracin; 
		    }
		}
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Forca1.class.getResource("/img/Icone.jpg")));
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
		tentativa.setIcon(new ImageIcon(Forca1.class.getResource("/img/tentativa6.png")));
		tentativa.setBounds(742, 39, 434, 63);
		Fundo.add(tentativa);
		
		JLabel tracin = new JLabel(calculada);
		tracin.setBounds(154, 497, 1000, 96);
		tracin.setHorizontalAlignment(SwingConstants.CENTER);
		tracin.setForeground(Color.WHITE);
		tracin.setFont(new Font("Tahoma", Font.PLAIN, 80));
		Fundo.add(tracin);
		
		JLabel lblErradas = new JLabel("Letras erradas: ");
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
		Forca.setIcon(new ImageIcon(Forca1.class.getResource("/img/forca0.png")));
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
		            JOptionPane.showMessageDialog(null, " Você ganhouuu!! A palavra era: " + palavra);
		            setVisible(false);
		            TelaInicial inicio = new TelaInicial();
		            inicio.setVisible(true);
		        }
		      
		        switch (tentativas) {
		            case 5:
		            	Forca.setIcon(new ImageIcon(Forca1.class.getResource("/img/Forca1.png")));
		                tentativa.setIcon(new ImageIcon(Forca1.class.getResource("/img/tentativa5.png")));
		                break;
		            case 4:
		                Forca.setIcon(new ImageIcon(".//src//img//Forca2.png"));
		                tentativa.setIcon(new ImageIcon(Forca1.class.getResource("/img/tentativa4.png")));
		                break;
		            case 3:
		                Forca.setIcon(new ImageIcon(".//src//img//Forca3.png"));
		                tentativa.setIcon(new ImageIcon(Forca1.class.getResource("/img/tentativa3.png")));
		                break;
		            case 2:
		                Forca.setIcon(new ImageIcon(".//src//img//Forca4.png"));
		                tentativa.setIcon(new ImageIcon(Forca1.class.getResource("/img/tentativa2.png")));
		                break;
		            case 1:
		                Forca.setIcon(new ImageIcon(".//src//img//Forca5.png"));
		                tentativa.setIcon(new ImageIcon(Forca1.class.getResource("/img/tentativa1.png")));
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
		                
		                JOptionPane.showMessageDialog(null, " Você perdeu! A palavra era: " + palavra + "! ");    
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
		
		JLabel dica = new JLabel("<html><div style='text-align: center;'>Dica: " + Forca1.dica + "</div></html>");
		dica.setBounds(424, 90, 434, 96); 
		dica.setHorizontalAlignment(SwingConstants.CENTER);
		dica.setForeground(Color.WHITE);
		dica.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Fundo.add(dica);
		dica.setForeground(Color.WHITE);
		dica.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Fundo.add(dica);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, -13, 1186, 654);
		lblNewLabel.setIcon(new ImageIcon(Forca1.class.getResource("/img/Fundo.png")));
		Fundo.add(lblNewLabel);
	}
}
