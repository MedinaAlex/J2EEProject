package fr.epsi.network.jmx;

public class Premier implements PremierMBean {
	
	private static String name = "PremierMBean";
	private int valeur = 100;
	
	public String getName() {
		return name;
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public void rafraichir() {
		System.out.println("Rafraichir les données");
	}

}
