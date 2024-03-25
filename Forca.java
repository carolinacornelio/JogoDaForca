package JogoDaForca;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Forca extends JFrame {
	int tentativas=6;
	private static final long serialVersionUID = 1L;
	private JPanel Fundo;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\corne\\Downloads\\JogoDaForca\\Icone.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 680);
		setLocationRelativeTo(null);
		Fundo = new JPanel();
		Fundo.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(Fundo);
		Fundo.setLayout(null);
		
		JLabel Forca = new JLabel("");
		Forca.setIcon(new ImageIcon("C:\\Users\\corne\\Downloads\\JogoDaForca\\forca0.png"));
		Forca.setBounds(-174, 39, 568, 444);
		Fundo.add(Forca);			
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\corne\\Downloads\\JogoDaForca\\Fundo.png"));
		lblNewLabel.setBounds(0, 0, 1186, 643);
		Fundo.add(lblNewLabel);
		
	/*switch (tentativas) {
        case 5:
            Forca.setIcon(new ImageIcon("C:\\Users\\corne\\Downloads\\JogoDaForca\\forca1.png"));
            break;
        case 4:
            Forca.setIcon(new ImageIcon("C:\\Users\\corne\\Downloads\\JogoDaForca\\forca2.png"));
            break;
        case 3:
            Forca.setIcon(new ImageIcon("C:\\Users\\corne\\Downloads\\JogoDaForca\\forca3.png"));
            break;
        case 2:
            Forca.setIcon(new ImageIcon("C:\\Users\\corne\\Downloads\\JogoDaForca\\forca4.png"));
            break;
        case 1:
            Forca.setIcon(new ImageIcon("C:\\Users\\corne\\Downloads\\JogoDaForca\\forca5.png"));
            break;
        case 0:
            Forca.setIcon(new ImageIcon("C:\\Users\\corne\\Downloads\\JogoDaForca\\forca6.png"));
            break;
    }*/
	}
}