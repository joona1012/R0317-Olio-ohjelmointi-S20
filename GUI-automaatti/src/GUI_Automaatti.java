import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GUI_Automaatti extends JFrame {

	// Luokkamuuttujat
	// Esitell‰‰n t‰‰ll‰ jotta komponentteihin voidaan viitata mist‰ tahansa luokan
	// sis‰lt‰

	JPanel contentPane;
	private JMenuItem mntmTallennaAutomaatinTila;
	private JMenuItem mntmLataaAutomaatti;
	private JTextField txtKahvi;
	private JTextField txtTee;
	private JTextField txtKaakao;
	private JLabel KahviLabel;
	private JLabel TeeLabel;
	private JLabel KaakaoLabel;

	/**
	 * Main-metodi, joka k‰ynnist‰‰ sovelluksen
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Luodaan ensmin uusi JuomaAutomaatti-olio
					JuomaAutomaatti ja = new JuomaAutomaatti();

					// K‰yttˆliittym‰ saa parametrina olion, jonka tiedot se n‰ytt‰‰
					GUI_Automaatti frame = new GUI_Automaatti(ja);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Konstruktorissa rakennetaan k‰yttˆliittym‰. Huomaa, ett‰ otetaan parametrina
	 * vastaan alussa luotu juoma-automaatti. T‰m‰ siksi, ett‰ voidaan n‰ytt‰‰ sen
	 * tiedot GUI:ssa
	 */
	public GUI_Automaatti(JuomaAutomaatti ja) {

		// Ikkunan otsikko ja koko
		setTitle("Kahviautomaatti GUI v. 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 705);
		setLocationRelativeTo(null);

	 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnKahvi = new JButton("New button");
		btnKahvi.setIcon(new ImageIcon("img/coffee.jpg"));
		btnKahvi.setBounds(46, 75, 122, 111);
		contentPane.add(btnKahvi);
		btnKahvi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)	{
				ja.valmistaKahvi();
				int KahviaJ‰ljell‰ = ja.getKahvi();
				ja.setKahvi(KahviaJ‰ljell‰);	
				KahviLabel.setText("Kahvia j‰ljell‰: " +KahviaJ‰ljell‰);
				KahviLabel.setForeground(Color.BLACK);
				if (KahviaJ‰ljell‰ <20)	{
					KahviLabel.setForeground(Color.RED);
			}
			}});
		
		JButton btnTee = new JButton("New button");
		btnTee.setIcon(new ImageIcon("img/tea.jpg"));
		btnTee.setBounds(46, 252, 122, 111);
		contentPane.add(btnTee);
		btnTee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)	{
				ja.valmistaTee();
				int Teet‰J‰ljell‰ = ja.getTee();
				ja.setTee(Teet‰J‰ljell‰);
				TeeLabel.setText("Teet‰ j‰ljell‰: " +Teet‰J‰ljell‰);
				TeeLabel.setForeground(Color.BLACK);
				if (Teet‰J‰ljell‰ <20)	{
					TeeLabel.setForeground(Color.RED);
			}
			}});
			
		JButton btnKaakao = new JButton("New button");
		btnKaakao.setIcon(new ImageIcon("img/cocoa.jpg"));
		btnKaakao.setBounds(46, 435, 122, 111);
		contentPane.add(btnKaakao);
		btnKaakao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)	{
				ja.valmistaKaakao();
				int KaakaotaJ‰ljell‰ = ja.getKaakao();
				ja.setKaakao(KaakaotaJ‰ljell‰);
				KaakaoLabel.setText("Kaakaota j‰ljell‰: " +KaakaotaJ‰ljell‰);
				KaakaoLabel.setForeground(Color.BLACK);
				if (KaakaotaJ‰ljell‰ <20)	{
					KaakaoLabel.setForeground(Color.RED);
			}			
			}});
		
		
		txtKahvi = new JTextField();
		txtKahvi.setFont(new Font("Garamond", Font.PLAIN, 14));
		txtKahvi.setHorizontalAlignment(SwingConstants.CENTER);
		txtKahvi.setBackground(UIManager.getColor("Button.background"));
		txtKahvi.setText("Kahvi");
		txtKahvi.setBounds(56, 197, 86, 20);
		contentPane.add(txtKahvi);
		txtKahvi.setColumns(10);
		
		txtTee = new JTextField();
		txtTee.setFont(new Font("Garamond", Font.PLAIN, 14));
		txtTee.setHorizontalAlignment(SwingConstants.CENTER);
		txtTee.setBackground(UIManager.getColor("Button.background"));
		txtTee.setText("Tee");
		txtTee.setColumns(10);
		txtTee.setBounds(56, 374, 86, 20);
		contentPane.add(txtTee);
		
		txtKaakao = new JTextField();
		txtKaakao.setFont(new Font("Garamond", Font.PLAIN, 14));
		txtKaakao.setHorizontalAlignment(SwingConstants.CENTER);
		txtKaakao.setBackground(UIManager.getColor("Button.background"));
		txtKaakao.setText("Kaakao");
		txtKaakao.setColumns(10);
		txtKaakao.setBounds(56, 556, 86, 20);
		contentPane.add(txtKaakao);
		
		
		KahviLabel = new JLabel("Kahvia j‰ljell‰ " +ja.getKahvi());
		KahviLabel.setFont(new Font("Book Antiqua", Font.PLAIN, 13));
		KahviLabel.setBounds(227, 86, 151, 51);
		contentPane.add(KahviLabel);
		
		TeeLabel = new JLabel("Teet‰ j‰ljell‰: " +ja.getTee());
		TeeLabel.setFont(new Font("Book Antiqua", Font.PLAIN, 13));
		TeeLabel.setBounds(227, 263, 151, 51);
		contentPane.add(TeeLabel);
		
		KaakaoLabel = new JLabel("Kaakaota j‰ljell‰: " +ja.getKaakao());
		KaakaoLabel.setFont(new Font("Book Antiqua", Font.PLAIN, 13));
		KaakaoLabel.setBounds(227, 446, 151, 51);
		contentPane.add(KaakaoLabel);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 449, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Yll\u00E4pito");
		menuBar.add(mnNewMenu);
		
		JMenuItem kahvinAsetus = new JMenuItem("Aseta kahvin m\u00E4\u00E4r\u00E4");
		kahvinAsetus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try	{
				String uusiArvo = JOptionPane.showInputDialog(null, "Anna uusi arvo: ");
				int uusiKahvi = Integer.parseInt(uusiArvo);
				if	((uusiKahvi>0) && (uusiKahvi<150))	{
				ja.setKahvi(uusiKahvi);
				}
			}catch(Exception i)	{
				JOptionPane.showInputDialog("Tarkista syˆte!");
			}
			}});		
		mnNewMenu.add(kahvinAsetus);
		
		JMenuItem teenAsetus = new JMenuItem("Aseta teen m\u00E4\u00E4r\u00E4");
		teenAsetus.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try	{
					String arvo2 = JOptionPane.showInputDialog(null, "Anna uusi arvo: ");
					int uusiTee = Integer.parseInt(arvo2);
					if	((uusiTee>0) && (uusiTee<150))	{
					ja.setTee(uusiTee);
					}
			}catch(Exception i)	{
				JOptionPane.showInputDialog("Tarkista syˆte!");
			}
			}});
		mnNewMenu.add(teenAsetus);
		
		JMenuItem kaakaonAsetus = new JMenuItem("Aseta kaakaon m\u00E4\u00E4r\u00E4");
		kaakaonAsetus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try	{
				String arvo3 = JOptionPane.showInputDialog(null, "Anna uusi arvo: ");
				int uusiKaakao = Integer.parseInt(arvo3);
				if	((uusiKaakao>0) && (uusiKaakao<150))	{
				ja.setKaakao(uusiKaakao);
				}
			}catch(Exception i)	{
				JOptionPane.showInputDialog("Tarkista syˆte!");
			}
			}});
		mnNewMenu.add(kaakaonAsetus);
		
		
		//Tallennusta ja lataamista en ihan saanut toimimaan.
		JMenuItem TallennaTila = new JMenuItem("Tallenna automaatin tila");
		mnNewMenu.add(TallennaTila);
		JMenuItem LataaTila = new JMenuItem("Lataa automaatti");
		mnNewMenu.add(LataaTila);
		
		JMenuItem Lopeta = new JMenuItem("Lopeta");
		Lopeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnNewMenu.add(Lopeta);
		
		JMenu OhjelmaTiedot = new JMenu("Tietoja ohjelmasta");
		menuBar.add(OhjelmaTiedot);
		
		JMenuItem Tietoja = new JMenuItem("Versiotiedot");
		Tietoja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Versiotiedot ikkuna = new Versiotiedot();
				ikkuna.setVisible(true);
			
			}
		});
		OhjelmaTiedot.add(Tietoja);
		
		}{;
		
		
		
	}
}
