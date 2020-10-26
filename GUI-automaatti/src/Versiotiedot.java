import javax.swing.JFrame;

import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Color;


public class Versiotiedot extends JFrame {
	public Versiotiedot() {
		getContentPane().setBackground(Color.WHITE);
		setTitle("Versiotiedot");
		setBounds(100, 100, 465, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		JTextPane otsikko = new JTextPane();
		otsikko.setBounds(101, 11, 260, 62);
		otsikko.setFont(new Font("Monospaced", Font.BOLD, 19));
		otsikko.setText("JUOMA-AUTOMAATTI V. 1.0");
		getContentPane().add(otsikko);
		JTextPane madeby = new JTextPane();
		madeby.setBounds(106, 117, 333, 94);
		madeby.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 17));
		madeby.setText("Tekij\u00E4: Joona Laakso");
		getContentPane().add(madeby);
	}
}
