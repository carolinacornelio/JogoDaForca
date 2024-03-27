package JogoDaForca;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Cadastro extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTextField user1;
	public static JTextField user2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro cadastro = new Cadastro();
					cadastro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Cadastro() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(".//src//img//Icone.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 680);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel comandanteTXT = new JLabel("OBS: o jogador 1 irá escolher a palavra");
		comandanteTXT.setForeground(new Color(255, 255, 255));
		comandanteTXT.setHorizontalAlignment(SwingConstants.CENTER);
		comandanteTXT.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comandanteTXT.setBounds(428, 388, 344, 27);
		contentPane.add(comandanteTXT);
		
		JLabel EntrarB = new JLabel("");
		EntrarB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (user1.getText().isEmpty() || user2.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha os dois campos!");
				} else if (user1.getText().equals(user2.getText())){
					JOptionPane.showMessageDialog(null, "Os nomes precisam ser diferentes!");
				} else {
					JOptionPane.showMessageDialog(null, user1.getText() + ", não deixe " + user2.getText() + " ver a próxima página");
					Jogador1 jogador = new Jogador1();
					jogador.setVisible(true);
					setVisible(false);
				}
			}
		});
		
		EntrarB.setIcon(new ImageIcon(Cadastro.class.getResource("/img/EntrarB.png")));
		EntrarB.setBounds(460, 451, 261, 68);
		contentPane.add(EntrarB);
		
		user2 = new JTextField();
		user2.setColumns(10);
		user2.setBounds(669, 287, 271, 40);
		contentPane.add(user2);
		
		JLabel player2TXT = new JLabel("Player 2:");
		player2TXT.setForeground(new Color(255, 255, 255));
		player2TXT.setHorizontalAlignment(SwingConstants.LEFT);
		player2TXT.setFont(new Font("Tahoma", Font.ITALIC, 20));
		player2TXT.setBounds(668, 235, 215, 65);
		contentPane.add(player2TXT);
		
		JLabel player1TXT = new JLabel("Player 1:");
		player1TXT.setForeground(new Color(255, 255, 255));
		player1TXT.setHorizontalAlignment(SwingConstants.LEFT);
		player1TXT.setFont(new Font("Tahoma", Font.ITALIC, 20));
		player1TXT.setBounds(241, 235, 215, 65);
		contentPane.add(player1TXT);
		
		user1 = new JTextField();
		user1.setColumns(10);
		user1.setBounds(241, 287, 271, 40);
		contentPane.add(user1);
		
		JLabel Carinha = new JLabel("");
		Carinha.setIcon(new ImageIcon(Cadastro.class.getResource("/img/Carinha.png")));
		Carinha.setBounds(536, 81, 128, 146);
		contentPane.add(Carinha);
		
		JLabel FundoCadastro = new JLabel("");
		FundoCadastro.setIcon(new ImageIcon(Cadastro.class.getResource("/img/FundoCadastro.png")));
		FundoCadastro.setBounds(0, 0, 1186, 643);
		contentPane.add(FundoCadastro);
	}
}