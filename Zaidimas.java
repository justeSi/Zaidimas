package Zaidimas;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.TreeSet;
import java.awt.event.ActionEvent;

public class Zaidimas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfSk;
	private final static int MAX = 100;
	public int sk = atsitiktinis();
	private int count = 2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Zaidimas frame = new Zaidimas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static int atsitiktinis() {
		Random rand = new Random();
		int sk = rand.nextInt(MAX) + 1;
		return sk;
	}

	/**
	 * Create the frame.
	 */
	public Zaidimas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 373);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Atspėk Skaičių tarp 1 ir 100");
		lblNewLabel.setForeground(Color.PINK);
		lblNewLabel.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 419, 76);
		contentPane.add(lblNewLabel);

		tfSk = new JTextField();
		tfSk.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 15));
		tfSk.setBounds(92, 138, 79, 37);
		contentPane.add(tfSk);
		tfSk.setColumns(10);

		JButton btnSpeti = new JButton("Bandyti");
		btnSpeti.setFont(new Font("Open Sans", Font.BOLD, 15));
		btnSpeti.setBounds(202, 138, 164, 37);
		contentPane.add(btnSpeti);

		JLabel lbAts = new JLabel("");
		lbAts.setHorizontalAlignment(SwingConstants.CENTER);
		lbAts.setFont(new Font("Open Sans", Font.BOLD | Font.ITALIC, 19));
		lbAts.setBounds(10, 197, 419, 76);
		contentPane.add(lbAts);

		JButton btnExit = new JButton("Išeiti");
		btnExit.setFont(new Font("Open Sans", Font.BOLD, 15));
		btnExit.setBounds(302, 284, 127, 31);
		contentPane.add(btnExit);

		JButton btnReset = new JButton("Naujas žaidimas");
		btnReset.setFont(new Font("Open Sans", Font.BOLD, 15));
		btnReset.setBounds(202, 141, 164, 31);
		contentPane.add(btnReset);
		
		JLabel lbSp = new JLabel("1-as spėjimas!");
		lbSp.setHorizontalAlignment(SwingConstants.CENTER);
		lbSp.setForeground(new Color(0x53b581));
		lbSp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbSp.setBounds(10, 90, 419, 37);
		contentPane.add(lbSp);
		
		TreeSet<Integer> spejimai = new TreeSet<>();
		System.out.println(sk);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sk = atsitiktinis();
				tfSk.setText("");
				count = 2;
				btnSpeti.setVisible(true);
				btnReset.setVisible(false);
				spejimai.clear();
				lbSp.setForeground(new Color(0x53b581));
				lbSp.setText("1-as spėjimas!");
				
			}
		});
		
		btnSpeti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbSp.setForeground(new Color(0x53b581));
				lbSp.setText(count+"-as spėjimas!");
				int spejimas = Integer.parseInt(tfSk.getText());
				if (spejimas <= 100) {
					if (spejimai.contains(spejimas)) {
						lbAts.setForeground(new Color(0xde4035));
						lbAts.setText("Tokį skaičių jau spėjote!");
					} else if (sk > spejimas) {
						lbAts.setForeground(new Color(0x4879b8));
						lbAts.setText("Spėjamas skaičius per mažas.");
					} else if (sk < spejimas) {
						lbAts.setForeground(new Color(0xb848b6));
						lbAts.setText("Spėjamas skaičius per didelis.");
					} else {
						lbAts.setForeground(new Color(0x58ad62));
						lbAts.setText("Atspėjote!");
						btnSpeti.setVisible(false);
						btnReset.setVisible(true);
					}
					if (!spejimai.contains(spejimas)) {
						spejimai.add(spejimas);
						tfSk.setText("");
					}
					count++;
					System.out.println(spejimai);

				} else {
					lbAts.setForeground(new Color(0xde4035));
					lbAts.setText("Spėjamas skaičius tarp 1 - 100...");
				}
			}
		});

		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("Išeiti");

				if (JOptionPane.showConfirmDialog(frame, "Ar tikrai norite išeiti?", "Atspėk skaičių",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});

	}
}
