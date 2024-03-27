package JogoDaForca;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Iterator;

public class TelaInicial extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial inicio = new TelaInicial();
					inicio.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaInicial() {
		setTitle("JOGO DA FORCA");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaInicial.class.getResource("/img/Icone.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 680);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Botao2jog = new JLabel("");
		Botao2jog.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Cadastro cadastro = new Cadastro();
				cadastro.setVisible(true);
				setVisible(false);
			}
		});
		Botao2jog.setIcon(new ImageIcon(TelaInicial.class.getResource("/img/2jogadoresB.png")));
		Botao2jog.setBounds(830, 483, 260, 64);
		contentPane.add(Botao2jog);
		
		JLabel Botao1jog = new JLabel("");
		Botao1jog.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Forca1 forca1 = new Forca1();
				forca1.setVisible(true);
				setVisible(false);
			}
		});
		Botao1jog.setIcon(new ImageIcon(TelaInicial.class.getResource("/img/1jogadorB.png")));
		Botao1jog.setBounds(553, 483, 260, 64);
		contentPane.add(Botao1jog);
		
		JLabel ForcaInicio = new JLabel("");
		ForcaInicio.setIcon(new ImageIcon(TelaInicial.class.getResource("/img/ForcaInicio.png")));
		ForcaInicio.setBounds(34, 93, 460, 436);
		contentPane.add(ForcaInicio);
		
		JLabel FundoInicio = new JLabel("");
		FundoInicio.setIcon(new ImageIcon(TelaInicial.class.getResource("/img/FundoInicio.png")));
		FundoInicio.setBounds(-14, 0, 1200, 680);
		contentPane.add(FundoInicio);
	}
}