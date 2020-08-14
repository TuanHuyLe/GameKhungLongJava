package Game;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.Timer;

import javax.swing.JButton;

public class XuLyGame extends JFrame implements itfGame, ActionListener {

	private JPanel contentPane;
	private JPanel panelTop;
	private JPanel pnCauHoi;
	private JPanel pnDapAn;
	private JPanel pnBottom;
	private JButton btReady;
	private JButton btnBack;
	private JButton btDapAnA;
	private JButton btDapAnB;
	private JButton btDapAnC;
	private JButton btDapAnD;
	private JLabel lbQuestions;
	private JLabel lbScore;
	private JLabel lbTimes;

	private Diem diem;
	private IOdata load;
	private QuestionAndAnswer cauHoi;
	private ListCauHoi list;
	private int i; // so cau hoi thu i
	private int size;
	private Timer time;
	private int t; // thoi gian chay
	private boolean flag = false; // set enable 4 dap an
	private boolean fl = true; // thoi gian dung khi het cau hoi

	/**
	 * Create the frame.
	 */
	public XuLyGame(String name) {
		super();
		this.setTitle("Learn English");
		diem = new Diem();
		load = new IOdata();
		load.loadSound("Illusion.wav");
		cauHoi = new QuestionAndAnswer();
		i = 0;
		this.setSize(700, 600);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.init(name);
	}

	public void init(String name) {
		createPanel(name);
		this.setEnable();
		btDapAnA.addActionListener(this);
		btDapAnB.addActionListener(this);
		btDapAnC.addActionListener(this);
		btDapAnD.addActionListener(this);
		btReady.addActionListener(this);
		btnBack.addActionListener(this);
		this.setContentPane(contentPane);
	}

	public void setEnable() {
		btDapAnA.setEnabled(flag);
		btDapAnB.setEnabled(flag);
		btDapAnC.setEnabled(flag);
		btDapAnD.setEnabled(flag);
	}

	@Override
	public void createPanel(String name) {
		contentPane = new SetLayout(name);
		Font f = new Font("Tahoma", Font.BOLD, 19);
		panelTop = new JPanel();
		pnCauHoi = new JPanel();
		pnDapAn = new JPanel();
		pnBottom = new JPanel();
		btReady = new JButton("Ready");
		btReady.setFont(f);
		btnBack = new JButton("Back");
		btnBack.setFont(f);
		btDapAnA = new JButton("A");
		btDapAnA.setFont(f);
		btDapAnA.setBackground(new Color(255, 255, 51));
		btDapAnB = new JButton("B");
		btDapAnB.setFont(f);
		btDapAnB.setBackground(new Color(255, 255, 51));
		btDapAnC = new JButton("C");
		btDapAnC.setFont(f);
		btDapAnC.setBackground(new Color(255, 255, 51));
		btDapAnD = new JButton("D");
		btDapAnD.setFont(f);
		btDapAnD.setBackground(new Color(255, 255, 51));

		JLabel lblLearnEnglish = new JLabel("Learn English");
		lblLearnEnglish.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblLearnEnglish.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel label = new JLabel("");

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblLearnEnglish, GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup().addComponent(label)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(pnCauHoi, GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
										.addComponent(panelTop, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(pnDapAn, GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
										.addComponent(pnBottom, GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE))))
				.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addComponent(lblLearnEnglish, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(24).addComponent(label))
						.addGroup(gl_contentPane.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panelTop, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)))
				.addGap(38).addComponent(pnCauHoi, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(pnDapAn, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(pnBottom, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(20, Short.MAX_VALUE)));

		GroupLayout gl_pnBottom = new GroupLayout(pnBottom);
		gl_pnBottom.setHorizontalGroup(gl_pnBottom.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnBottom.createSequentialGroup().addGap(54)
						.addComponent(btReady, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
						.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
						.addGap(59)));
		gl_pnBottom.setVerticalGroup(gl_pnBottom.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnBottom.createSequentialGroup().addContainerGap()
						.addGroup(gl_pnBottom.createParallelGroup(Alignment.LEADING)
								.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
								.addComponent(btReady, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(19, Short.MAX_VALUE)));
		pnBottom.setLayout(gl_pnBottom);
		pnDapAn.setLayout(new GridLayout(2, 2, 20, 20));
		pnDapAn.add(btDapAnA);
		pnDapAn.add(btDapAnB);
		pnDapAn.add(btDapAnC);
		pnDapAn.add(btDapAnD);

		lbQuestions = new JLabel("Questions");
		lbQuestions.setFont(new Font("Tahoma", Font.BOLD, 18));
		pnCauHoi.add(lbQuestions);

		JLabel lblScore = new JLabel("Score");
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setFont(new Font("Tahoma", Font.BOLD, 19));

		JLabel lblTime = new JLabel("Times");
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 19));

		lbScore = new JLabel("0");
		lbScore.setFont(new Font("Tahoma", Font.BOLD, 19));
		lbScore.setHorizontalAlignment(SwingConstants.CENTER);

		lbTimes = new JLabel("15");
		lbTimes.setHorizontalAlignment(SwingConstants.CENTER);
		lbTimes.setFont(new Font("Tahoma", Font.BOLD, 19));
		GroupLayout gl_panelTop = new GroupLayout(panelTop);
		gl_panelTop.setHorizontalGroup(gl_panelTop.createParallelGroup(Alignment.LEADING).addGroup(gl_panelTop
				.createSequentialGroup().addGap(54)
				.addGroup(gl_panelTop.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lbScore, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(lblScore, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
				.addGap(344)
				.addGroup(gl_panelTop.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTime, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbTimes, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
				.addGap(56)));
		gl_panelTop.setVerticalGroup(gl_panelTop.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTop.createSequentialGroup()
						.addGroup(gl_panelTop.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblScore, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTime, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelTop.createParallelGroup(Alignment.LEADING)
								.addComponent(lbScore, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbTimes, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelTop.setLayout(gl_panelTop);
		contentPane.setLayout(gl_contentPane);

		panelTop.setOpaque(false);
		pnBottom.setOpaque(false);
		pnCauHoi.setOpaque(false);
		pnDapAn.setOpaque(false);

		btnBack.setBackground(new Color(153, 255, 102));
		btReady.setBackground(new Color(153, 255, 102));

	}

	public class Time implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (t > 0 && fl) {
				t--;
				lbTimes.setText(t + "");
			} else {
				if (t < 1) {
					t = 15;
					loadCauHoi();
					lbTimes.setText(t + "");
					time.start();
				}

			}
		}

	}

	private void checkGame(String action, String ans) {
		if (ans.equalsIgnoreCase(action)) {
			diem.upScore();
			lbScore.setText(diem.getDiem() + "");
			loadCauHoi();
			t = 15;
			lbTimes.setText(t + "");
			time.start();
		} else {
			loadCauHoi();
			t = 15;
			lbTimes.setText(t + "");
			time.start();
		}
		int score = load.getScore();
		if (diem.checkHighScore(score)) {
			load.saveScore(diem.getDiem());
		}

	}

	public void loadCauHoi() {
		if (i < size) {
			cauHoi = list.get();
			i++;
			lbQuestions.setText(i + ". " + cauHoi.getCauHoi());
			btDapAnA.setText(cauHoi.getDapAnA());
			btDapAnB.setText(cauHoi.getDapAnB());
			btDapAnC.setText(cauHoi.getDapAnC());
			btDapAnD.setText(cauHoi.getDapAnD());
		} else {
			btReady.setText("The End");
			btReady.setEnabled(false);
			load.turnOffSound();
			load.loadSound("Win.wav");
			JOptionPane.showMessageDialog(null, "Congratulations");
			fl = false;
			time.stop();
			flag = false; // disenabel button answers
			this.setEnable();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("Ready".equalsIgnoreCase(e.getActionCommand())) {
			load.turnOffSound();
			load.loadSound("ResidentEvil.wav");
			flag = true;
			this.setEnable();
			load.loadQuestion(); // doc file
			btReady.setText("Next");
			list = load.getList(); // lay list cau hoi trong file
			size = list.size(); // lay size cua list
			t = 15;
			time = new Timer(1000, new Time());
		}
		if ("Next".equalsIgnoreCase(e.getActionCommand())) {
			t = 15;
			time.start();
		}
		if (fl && !"Back".equalsIgnoreCase(e.getActionCommand())) {
			checkGame(e.getActionCommand(), cauHoi.getDung());
		}
		if ("Back".equalsIgnoreCase(e.getActionCommand())) {
			load.turnOffSound();
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
			new MenuGame().setVisible(true);
		}
		
	}

}
