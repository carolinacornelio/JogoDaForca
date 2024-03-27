package JogoDaForca;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Jogador1 extends JFrame {
	// Palavra secreta: Jogador1.palavraTXT.getText();
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTextField palavraTXT;
	public static JTextField dicaTXT;
	
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jogador1 jogador = new Jogador1();
					jogador.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Jogador1() {
		setTitle("DEFINIÇÃO DE PALAVRA");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Jogador1.class.getResource("/img/Icone.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 680);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel JogarB = new JLabel("");
		JogarB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (palavraTXT.getText().isEmpty() || dicaTXT.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!");
				} else if (palavraTXT.getText().length()<2 || palavraTXT.getText().length()>10){
					JOptionPane.showMessageDialog(null, "A palavra deve ter entre 2 e 10 letras!");
				}
				else {
				Forca2 forca = new Forca2();
				forca.setVisible(true);
				setVisible(false);	
				}
			}
		});
		
		JLabel obsTXT = new JLabel("Obs: a palavra deve ter entre duas e dez letras");
		obsTXT.setHorizontalAlignment(SwingConstants.LEFT);
		obsTXT.setForeground(Color.WHITE);
		obsTXT.setFont(new Font("Tahoma", Font.ITALIC, 15));
		obsTXT.setBounds(113, 251, 361, 55);
		contentPane.add(obsTXT);
		
		JogarB.setHorizontalAlignment(SwingConstants.CENTER);
		JogarB.setIcon(new ImageIcon(Jogador1.class.getResource("/img/JogarB.png")));
		JogarB.setBounds(195, 499, 190, 64);
		contentPane.add(JogarB);
		
		JLabel lblDigiteAlgumaDica = new JLabel("Digite alguma dica sobre a palavra:");
		lblDigiteAlgumaDica.setHorizontalAlignment(SwingConstants.LEFT);
		lblDigiteAlgumaDica.setForeground(Color.WHITE);
		lblDigiteAlgumaDica.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblDigiteAlgumaDica.setBounds(113, 334, 361, 55);
		contentPane.add(lblDigiteAlgumaDica);
		
		dicaTXT = new JTextField();
		dicaTXT.setColumns(10);
		dicaTXT.setBounds(113, 399, 361, 49);
		contentPane.add(dicaTXT);
		
		JLabel TXT = new JLabel(Cadastro.user1.getText() + ", digite a palavra secreta: ");
		TXT.setHorizontalAlignment(SwingConstants.LEFT);
		TXT.setForeground(Color.WHITE);
		TXT.setFont(new Font("Tahoma", Font.ITALIC, 20));
		TXT.setBounds(113, 135, 361, 55);
		contentPane.add(TXT);
		
		palavraTXT = new JTextField();
		palavraTXT.setForeground(new Color(255, 255, 255));
		palavraTXT.setColumns(10);
		palavraTXT.setBounds(113, 200, 361, 49);
		contentPane.add(palavraTXT);
		
		JLabel Xiu = new JLabel("");
		Xiu.setIcon(new ImageIcon(Jogador1.class.getResource("/img/Xiu.png")));
		Xiu.setBounds(668, 102, 393, 445);
		contentPane.add(Xiu);
		
		JLabel Fundo = new JLabel("");
		Fundo.setIcon(new ImageIcon(Jogador1.class.getResource("/img/Fundo.png")));
		Fundo.setBounds(0, 0, 1186, 643);
		contentPane.add(Fundo);
	}
}