package Game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

public class IOdata implements itfIOdata {
	private File file;
	private Scanner sc = null;
	private ListCauHoi list;
	private BufferedReader br;
	private Clip clip;

	public IOdata() {
		super();
		file = new File("D:\\Documents\\GameJava\\src\\Game\\Questions.txt");
		list = new ListCauHoi();
	}

	@Override
	public void loadQuestion() {
		String ch, da, db, dc, dd, d;
		try {
			sc = new Scanner(file);
			while (sc.hasNext()) {
				ch = sc.nextLine();
				da = sc.nextLine();
				db = sc.nextLine();
				dc = sc.nextLine();
				dd = sc.nextLine();
				d = sc.nextLine();
				QuestionAndAnswer qaa = new QuestionAndAnswer(ch, da, db, dc, dd, d);
				list.add(qaa);
			}
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "File Questions not found");
			e.printStackTrace();
		}
	}

	@Override
	public int getScore() {
		int diem = 0;
		try {
			br = new BufferedReader(new FileReader("D:\\Documents\\GameJava\\src\\Game\\HighScore"));
			try {
				diem = br.read();
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "File HighScore not found");
			e.printStackTrace();
		}
		return diem;
	}

	@Override
	public void saveScore(int diem) {
		try {
			FileWriter fw = new FileWriter("D:\\Documents\\GameJava\\src\\Game\\HighScore");
			fw.write(diem+"");
			fw.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "File HighScore not found");
			e.printStackTrace();
		}
	}
	
	public ListCauHoi getList() {
		return list;
	}
	
	public void loadSound(String name) {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File("D:\\Documents\\GameJava\\src\\Game\\"+name).getAbsoluteFile());
			clip = AudioSystem.getClip();
		    clip.open(ais);
		    clip.start();
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}
	
	public void turnOffSound() {
		clip.stop();
	}

}
