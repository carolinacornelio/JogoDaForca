package JogoDaForca;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Jogador1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\corne\\Downloads\\JogoDaForca\\Icone.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 680);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\corne\\Downloads\\JogoDaForca\\JogarB.png"));
		lblNewLabel.setBounds(195, 499, 190, 64);
		contentPane.add(lblNewLabel);
		
		JLabel lblDigiteAlgumaDica = new JLabel("Digite alguma dica sobre a palavra:");
		lblDigiteAlgumaDica.setHorizontalAlignment(SwingConstants.LEFT);
		lblDigiteAlgumaDica.setForeground(Color.WHITE);
		lblDigiteAlgumaDica.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblDigiteAlgumaDica.setBounds(113, 334, 361, 55);
		contentPane.add(lblDigiteAlgumaDica);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(113, 399, 361, 49);
		contentPane.add(textField_1);
		
		JLabel TXT = new JLabel("Jogador 1, digite a palavra secreta: ");
		TXT.setHorizontalAlignment(SwingConstants.LEFT);
		TXT.setForeground(Color.WHITE);
		TXT.setFont(new Font("Tahoma", Font.ITALIC, 20));
		TXT.setBounds(113, 135, 361, 55);
		contentPane.add(TXT);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(113, 200, 361, 49);
		contentPane.add(textField);
		
		JLabel Xiu = new JLabel("");
		Xiu.setIcon(new ImageIcon("C:\\Users\\corne\\Downloads\\JogoDaForca\\Xiu.png"));
		Xiu.setBounds(668, 102, 393, 445);
		contentPane.add(Xiu);
		
		JLabel Fundo = new JLabel("");
		Fundo.setIcon(new ImageIcon("C:\\Users\\corne\\Downloads\\JogoDaForca\\Fundo.png"));
		Fundo.setBounds(0, 0, 1186, 643);
		contentPane.add(Fundo);
	}
}