package Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListCauHoi {
	private List<QuestionAndAnswer> listCauHoi;
	private Random rd;

	public ListCauHoi() {
		super();
		rd = new Random();
		this.listCauHoi = new ArrayList<QuestionAndAnswer>();
	}

	public List<QuestionAndAnswer> getCauHoi() {
		return listCauHoi;
	}

	public void setCauHoi(List<QuestionAndAnswer> listCauHoi) {
		this.listCauHoi = listCauHoi;
	}
	
	public void add(QuestionAndAnswer cauHoi) {
		listCauHoi.add(cauHoi);
	}
	
	public int size() {
		return listCauHoi.size();
	}
	
	
	public QuestionAndAnswer get() {
		int i = rd.nextInt(this.size());
		QuestionAndAnswer cauHoi = listCauHoi.get(i);
		listCauHoi.remove(i);
		return cauHoi;
	}

}
