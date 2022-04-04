package fi.utu.tech.gui.javafx;

import java.util.ArrayList;

public class Lauta {
	private int koko;
	private ArrayList<Integer> alukset = new ArrayList<>();

	public ArrayList<Integer> getAlukset() {
		return alukset;
	}

	public void setAlukset(ArrayList<Integer> alukset) {
		this.alukset = alukset;
	}

	public Lauta() {
		koko = getKoko();
	}

	public void setKoko(int k) {
		this.koko = k;
	}

	public int getKoko() {
		return this.koko;
	}

}
