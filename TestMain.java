
public class TestMain {
	public static void main(String[] args) {
		GestionBanque banque =new GestionBanque();
		CompteCourant<String> cptCourant= new CompteCourant<>(1,1200,"TND",500);
		CompteEpargne<String> cptEpargne= new CompteEpargne<>(2,2500,"EUR",0.04);
		ComteCourantSecurise<String> cptSecurise= new ComteCourantSecurise<>(3,3000,"TND",100,"hayfamn");
		banque.ajouterCompte(cptCourant);
		banque.ajouterCompte(cptEpargne);
		banque.ajouterCompte(cptSecurise);
		banque.afficherComptes();
		try {
			if(cptSecurise.verifierIdentite("hayfamn")) {
				cptSecurise.deposer(500);
				cptSecurise.retirer(1000);
				cptSecurise.afficherSolde();}
			else
				System.out.println("Id incorrect!");
		}
		catch(AccesInterditException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			cptSecurise.retirer(1000);
		}catch(AccesInterditException e) {}
		System.out.println("Recherche de compte N°2");
		try {

			Compte<?> cptAchercher=banque.rechercherCompte(2);
			if(cptAchercher!=null)
				cptAchercher.afficherSolde();}
		catch(AccesInterditException e) {
			System.out.println("Affichage de solde interdit");
		}
		
		
		

	}
}
