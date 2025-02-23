import java.util.*;


public class GestionBanque {
	private static HashMap<Integer,Compte<?>> comptes=new HashMap<>();
	
	public static <T> void transfert(Compte<T> emetteur,Compte<T> destinataire,double montant) {
		try {
		if(emetteur.solde>=montant) {
			emetteur.retirer(montant);
			destinataire.deposer(montant);
			System.out.println("Transfert réussi");
		}
		else
			System.out.println("Solde insuffisant");
		}catch(AccesInterditException e) {
			System.out.println("Erreur de transfert");
		}
		
	}
	public static void ajouterCompte(Compte<?> cpt) {
		comptes.put(cpt.numeroCompte,cpt);
	}
	public static Compte<?> rechercherCompte(int numCompte){
		return comptes.get(numCompte);
	}
	public static void supprimerCpt(int numCompte) {
		comptes.remove(numCompte);
	}
	public static void afficherComptes() {
	    List<Map.Entry<Integer, Compte<?>>>listeComptes=new ArrayList<>(comptes.entrySet());
	    listeComptes.sort((e1,e2)->Double.compare(e2.getValue().solde,e1.getValue().solde));
	    System.out.println("Comptes triés par solde:");
	    for (Map.Entry<Integer,Compte<?>> compte:listeComptes) {
	    	System.out.println("Compte N°"+compte.getKey()+" - Solde: "+compte.getValue().solde);
	    }
	}
	
	
	
}
