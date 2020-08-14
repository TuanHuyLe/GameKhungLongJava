package Game;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;

public class MenuGame extends JFrame implements itfGame, ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btPlay;
	private JButton btHighScore;
	private JButton btQuit;
	private IOdata load;
	private String first = "D:\\Documents\\GameJava\\src\\Game\\beautiful-landscape.jpg";
	private String second = "D:\\Documents\\GameJava\\src\\Game\\kiKor7zqT.jpg";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuGame frame = new MenuGame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuGame() {
		super();
		this.setTitle("Learn English");
		this.setSize(700, 600);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.init();
	}
	
	private void init() {
		createPanel(first);
		load = new IOdata();
		load.loadSound("Cids.wav");
		btPlay.addActionListener(this);
		btHighScore.addActionListener(this);
		btQuit.addActionListener(this);
		this.setContentPane(contentPane);
	}
	
	@Override
	public void createPanel(String name) {
		contentPane = new SetLayout(name);

		JLabel lblLearnEnglish = new JLabel("Learn English");
		lblLearnEnglish.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblLearnEnglish.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label = new JLabel("");
		
		JPanel panelControl = new JPanel();
		GroupLayout gl_panelF = new GroupLayout(contentPane);
		gl_panelF.setHorizontalGroup(
			gl_panelF.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelF.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelF.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblLearnEnglish, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
						.addComponent(label, Alignment.LEADING)
						.addComponent(panelControl, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelF.setVerticalGroup(
			gl_panelF.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelF.createSequentialGroup()
					.addGap(5)
					.addComponent(lblLearnEnglish, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addGap(105)
					.addComponent(label)
					.addGap(43)
					.addComponent(panelControl, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(85, Short.MAX_VALUE))
		);
		
		btPlay = new JButton("Play");
		btPlay.setFont(new Font("Tahoma", Font.BOLD, 18));
		btPlay.setBackground(new Color(153,255,102));
		
		btHighScore = new JButton("High Score");
		btHighScore.setFont(new Font("Tahoma", Font.BOLD, 18));
		btHighScore.setBackground(new Color(153,255,102));
		
		btQuit = new JButton("Quit");
		btQuit.setFont(new Font("Tahoma", Font.BOLD, 18));
		btQuit.setBackground(new Color(153,255,102));
		
		GroupLayout gl_panelControl = new GroupLayout(panelControl);
		gl_panelControl.setHorizontalGroup(
			gl_panelControl.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelControl.createSequentialGroup()
					.addGap(172)
					.addGroup(gl_panelControl.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btQuit, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btHighScore, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btPlay, GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE))
					.addContainerGap(171, Short.MAX_VALUE))
		);
		gl_panelControl.setVerticalGroup(
			gl_panelControl.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelControl.createSequentialGroup()
					.addContainerGap()
					.addComponent(btPlay, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btHighScore, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btQuit, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(33, Short.MAX_VALUE))
		);
		panelControl.setLayout(gl_panelControl);
		panelControl.setOpaque(false);
		contentPane.setLayout(gl_panelF);
		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		String name = e.getActionCommand();
		if("Play".equalsIgnoreCase(name)) {
			XuLyGame game = new XuLyGame(second);
			load.turnOffSound();
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
			try {
				game.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if("High Score".equalsIgnoreCase(name)) {
			JOptionPane.showMessageDialog(null, "High Score: "+(load.getScore()-48));
		}
		if("Quit".equalsIgnoreCase(name)) {
			System.exit(0);
		}
	}
	
}
