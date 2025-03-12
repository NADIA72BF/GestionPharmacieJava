package pharmacie;


import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Patient {
	
	private String nom ;
	private Set <String > ordonnance ;
	
	public Patient (String n){
	nom = n ;
	ordonnance = new HashSet <String >();
	}
	
	public String getNom () { 
		return nom ;
	}
	public boolean ordonnanceVide() {
		return ordonnance.isEmpty();
	}
	public void ajoutMedicament(String m) {
		ordonnance.add(m);
	}
	
	@Override
	public String toString() {
		return "patient [nom=" + nom + ", ordonnance=" + ordonnance + "]";
	}
	
	public void affiche() {
		System.out.println(toString());
	}
	public boolean contientMedicament (String m) {
		return ordonnance.contains(m);
	}
	public void trieOrdonnace() {
		TreeSet<String> sortedOrd=new TreeSet<>(ordonnance);
		System.out.println("the sorted set is : " + sortedOrd );
	}

}

