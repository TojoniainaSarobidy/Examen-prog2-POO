import java.util.ArrayList;
import java.util.List;

public class Combattant {
    private String id;
    private String nom;
    private String prenom;
    private String nomCombattant;
    private double poids;
    private ArrayList<String> titres;
    private int victoires;
    private int defaites;
    private int egalites;

    public Combattant(String id, String nom, String prenom, String nomCombattant, double poids) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.nomCombattant = nomCombattant;
        this.poids = poids;
        this.titres = new ArrayList<>();
    }

    public void ajouterTitre(String titre) {
        titres.add(titre);
    }

    public void ajouterVictoire() {
        victoires++;
    }

    public void ajouterDefaite() {
        defaites++;
    }

    public void ajouterEgalite() {
        egalites++;
    }

    public String getId() {
        return id;
    }

    public String getNomComplet() {
        return prenom + " " + nom;
    }

    public String getNomCombattant() {
        return nomCombattant;
    }

    public List<String> getTitres() {
        return titres;
    }

    public int getVictoires() {
        return victoires;
    }

    public int getDefaites() {
        return defaites;
    }

    public int getEgalites() {
        return egalites;
    }

    @Override
    public String toString() {
        return nomCombattant + " (" + victoires + "Victoires " + defaites + "Défaites " + egalites + "Egalités)";
    }
}
