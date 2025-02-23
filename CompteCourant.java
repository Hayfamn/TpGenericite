

public class CompteCourant<T> extends Compte{
	protected double limiteAutorisation;

	public CompteCourant(int numeroCompte, double solde, T devise, double limiteAutorisation) {
		super(numeroCompte, solde, devise);
		this.limiteAutorisation = limiteAutorisation;
	}
	
	public void retirer(double montant) throws AccesInterditException{
		if((solde-montant)>= -limiteAutorisation) 
			solde-=montant;
		else
			System.out.println("Limite autorisée depassée");
	}
	public void afficherSolde() throws AccesInterditException {
		System.out.println("Compte Courant - Solde: "+solde+" "+devise);
	}
	public double getLimiteAutorisation() {
		return limiteAutorisation;
	}
	public void setLimiteAutorisation(double limiteAutorisation) {
		this.limiteAutorisation=limiteAutorisation;
	}
	
	
}
