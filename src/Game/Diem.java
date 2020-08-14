package Game;

public class Diem implements itfDiem{
	private int diem;

	public Diem() {
		super();
		diem = 0;
	}

	public int getDiem() {
		return diem;
	}

	public void setDiem(int diem) {
		this.diem = diem;
	}

	@Override
	public boolean checkHighScore(int score) {
		if(score < this.diem) {
			return true;
		}
		return false;
	}

	@Override
	public void upScore() {
		diem ++;
	}

}
