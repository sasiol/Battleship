package fi.utu.tech.gui.javafx;

import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

public class ValueFactory<T> extends SpinnerValueFactory<Integer>{
	
	private Spinner<Integer> alus;
	private int aluksenRuudut; // montako ruutua alus vie
	private int maara; // montako tätä alusta voi olla
	private int ruudut; // montako ruutua on käytössä aluksille

	public ValueFactory(Spinner<Integer> alus, int aluksenRuudut, int maara, int ruudut) {
		super();
		this.alus = alus;
		this.aluksenRuudut = aluksenRuudut;
		this.maara = maara;
		this.ruudut = ruudut;
		this.setValue(0);
	}

	@Override
	public void decrement(int steps) {
		int nyt = (int) alus.getValue();
		if (ruudut > aluksenRuudut) {
			this.setValue(Integer.valueOf(nyt-1));
			ruudut = ruudut + aluksenRuudut;
		}else {
			this.setValue(nyt);
		}
	}

	@Override
	public void increment(int steps) {
		int nyt = (int) alus.getValue();
		if(nyt < maara) {
			this.setValue(nyt+1);
			ruudut = ruudut - aluksenRuudut;
		}else {
			this.setValue(nyt);
		}
	}
	
	public int getRuudut() {
		return ruudut;
	}

	public void setRuudut(int ruudut) {
		this.ruudut = ruudut;
	}
}
