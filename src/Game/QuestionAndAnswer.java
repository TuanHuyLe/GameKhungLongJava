package Game;

public class QuestionAndAnswer {
	String cauHoi;
	String dapAnA;
	String dapAnB;
	String dapAnC;
	String dapAnD;
	String dung;
	public QuestionAndAnswer() {
		this.cauHoi = "";
		this.dapAnA = "";
		this.dapAnB = "";
		this.dapAnC = "";
		this.dapAnD = "";
		this.dung = "";
	}
	public QuestionAndAnswer(String cauHoi, String dapAnA, String dapAnB, String dapAnC, String dapAnD, String dung) {
		super();
		this.cauHoi = cauHoi;
		this.dapAnA = dapAnA;
		this.dapAnB = dapAnB;
		this.dapAnC = dapAnC;
		this.dapAnD = dapAnD;
		this.dung = dung;
	}
	public String getCauHoi() {
		return cauHoi;
	}
	public void setCauHoi(String cauHoi) {
		this.cauHoi = cauHoi;
	}
	public String getDapAnA() {
		return dapAnA;
	}
	public void setDapAnA(String dapAnA) {
		this.dapAnA = dapAnA;
	}
	public String getDapAnB() {
		return dapAnB;
	}
	public void setDapAnB(String dapAnB) {
		this.dapAnB = dapAnB;
	}
	public String getDapAnC() {
		return dapAnC;
	}
	public void setDapAnC(String dapAnC) {
		this.dapAnC = dapAnC;
	}
	public String getDapAnD() {
		return dapAnD;
	}
	public void setDapAnD(String dapAnD) {
		this.dapAnD = dapAnD;
	}
	public String getDung() {
		return dung;
	}
	public void setDung(String dung) {
		this.dung = dung;
	}

}
