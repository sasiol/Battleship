package fi.utu.tech.gui.javafx;

public class Pelaaja {

	private String nimi;

	public Pelaaja() {
		this.nimi = getNimi();
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

}
