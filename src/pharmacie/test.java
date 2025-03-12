package pharmacie;

import java.util.Collection;

public class test {
	public static void main(String[] args) {
	    DossierPharmacie dp = new DossierPharmacie("Pharmacie Centrale");

	    dp.nouveauPatient("Ali", new String[]{"Doliprane", "Aspirine"});
	    dp.nouveauPatient("Karim", new String[]{});
	    dp.nouveauPatient("Sana", new String[]{"Ibuprofène"});

	    System.out.println("Avant suppression :");
	    dp.affiche();
	    
	    System.out.println("\n--- Affichage du patient Ali ---");
        dp.affichePatient("Ali");
        
        System.out.println("\n--- Ajout de médicament 'Vitamine C' à Ali ---");
        dp.ajoutMedicament("Ali", "Vitamine C");
        dp.affichePatient("Ali");
        
        System.out.println("\n--- Patients ayant 'Ibuprofène' ---");
        Collection<Patient> patientsAvecMedicament = dp.affichePatientAvecMedicament("Ibuprofène");
        for (Patient p : patientsAvecMedicament) {
            p.affiche();
        }
        
        System.out.println("\n--- Suppression des patients avec ordonnance vide ---");
        dp.enleverPatientOrdonnanceVide();
        dp.affiche();
        
        
        System.out.println("\n--- Tri de l'ordonnance du patient Ali ---");
        dp.affichePatient("Ali");
        Patient ali = dp.affichePatientAvecMedicament("Doliprane").iterator().next();
        ali.trieOrdonnace();
	}
}
