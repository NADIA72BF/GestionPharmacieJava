package pharmacie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class DossierPharmacie {
	
	private String nom ;
	private HashMap <String , Patient > patients ;
	
	public DossierPharmacie (String n){
		nom =n;
		patients = new HashMap <String , Patient >();
	}
	
	void nouveauPatient ( String nom , String [] ord) {
		Patient p=new Patient(nom);
		for (int i=0;i<ord.length;i++) {
			p.ajoutMedicament(ord[i]);
		}
		patients.put(nom, p);
	}
	public boolean ajoutMedicament (String nom, String m){
		Patient p =patients.get(nom);
		if(p== null) {
			return false;
		}else {
			p.ajoutMedicament(m);
		}
		return true;
	}
	public void affichePatient (String nom){
		Patient p=patients.get(nom);
		p.affiche();
	}
	
	@Override
	public String toString() {
		return "DossierPharmacie [nom=" + nom + ", patients=" + patients + "]";
	}

	public void affiche() {
		System.out.println(toString());
	}
	public Collection <Patient > affichePatientAvecMedicament (String m){
		Collection<Patient> ln = new ArrayList<>();
		Collection<Patient>lp=patients.values();
		Iterator<Patient> it=lp.iterator();
		while (it.hasNext()) {
			Patient p=it.next();
			if(p.contientMedicament(m)) {
				ln.add(p);
			}
		}
		return ln;
	}

	public void enleverPatientOrdonnanceVide() {
	    Iterator<String> it = patients.keySet().iterator();
	    while (it.hasNext()) {
	        String nom = it.next();
	        if (patients.get(nom).ordonnanceVide()) {
	            it.remove();  
	        }
	    }
	}
	
	

}
