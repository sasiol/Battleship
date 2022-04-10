package fi.utu.tech.gui.javafx;

import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

public class ValueFactory<T> extends SpinnerValueFactory<Integer> {

	private Spinner<Integer> alus;
	private int aluksenRuudut; // montako ruutua alus vie
	private int maara; // montako tätä alusta voi olla
	private Label ruudut; // montako ruutua on käytössä aluksille

	public ValueFactory(Spinner<Integer> alus, int aluksenRuudut, int maara, Label ruudut) {
		super();
		this.alus = alus;
		this.aluksenRuudut = aluksenRuudut;
		this.maara = maara;
		this.ruudut = ruudut;
		this.setValue(0);
	}

	// aluksen määrää vähennettäessä tarkistetaan, ettei arvo ole jo 0
	@Override
	public void decrement(int steps) {

		int ruutuMaara = Integer.parseInt(this.ruudut.getText());
		int nyt = (int) alus.getValue();
		if (nyt > 0) {
			this.setValue(Integer.valueOf(nyt - 1));
			ruudut.setText(String.valueOf(ruutuMaara + aluksenRuudut));
		} else {
			this.setValue(nyt);
		}
	}

	// aluksen määrää lisätessä tarkistetaan, että ruutuja on tarpeeksi
	// käytettävissä
	// eikä alusten määrä ylitä sallittua
	@Override
	public void increment(int steps) {
		int ruutuMaara = Integer.parseInt(this.ruudut.getText());
		System.out.println("eka" + ruudut);
		int nyt = (int) alus.getValue(); // alusten määrä atm
		if (nyt < maara && ruutuMaara >= aluksenRuudut) {
			this.setValue(nyt + 1);
			ruudut.setText(String.valueOf(ruutuMaara - aluksenRuudut));
			System.out.println("sitten" + ruudut);
		} else {
			this.setValue(nyt);
		}
	}
}
