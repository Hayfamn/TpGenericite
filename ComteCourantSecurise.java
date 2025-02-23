
public class ComteCourantSecurise<T> extends CompteCourant<T> implements Securisable{
	private String identifiant;
	protected boolean acces;
	public ComteCourantSecurise(int numeroCompte, double solde, T devise, double limiteAutorisation,
			String identifiant) {
		super(numeroCompte, solde, devise, limiteAutorisation);
		this.identifiant = identifiant;
		acces=false;
	}

	public boolean verifierIdentite(String identifiant) {
		if( this.identifiant.equals(identifiant)) {
			acces=true;
			return true;
		}
		return false;
	}
	@Override
	public void retirer(double montant) throws AccesInterditException {
        if (!acces) {
            throw new AccesInterditException("Acces Interdit");}        
        super.retirer(montant);
    }
	@Override
	public void deposer(double montant) throws AccesInterditException{
		if(!acces)
		{	throw new AccesInterditException("Acces Interdit");}
		super.deposer(montant);
		
	}
	
	@Override
    public void afficherSolde() throws AccesInterditException {
        if (!acces) {
            throw new AccesInterditException("Accès interdit");
        }
        super.afficherSolde();
    }
	
}
