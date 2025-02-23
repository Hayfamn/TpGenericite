

public class Compte<T>{
	int numeroCompte;
	double solde;
	T devise;
	public void deposer(double montant) throws AccesInterditException{
		solde+=montant;
	}
	public void retirer(double montant) throws AccesInterditException{
		if(montant<=solde)
			solde-=montant;
		else
			System.out.println("Solde insuffisanr");
	}
	public void afficherSolde() throws AccesInterditException{
		System.out.println("Solde: "+solde+" "+devise);
	}
	public Compte(int numeroCompte, double solde, T devise) {
		this.numeroCompte = numeroCompte;
		this.solde = solde;
		this.devise = devise;
	}
	
	
}
