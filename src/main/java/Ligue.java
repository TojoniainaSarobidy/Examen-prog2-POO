import java.util.ArrayList;

public class Ligue {
    private String nom;
    private ArrayList<Combattant> combattants;
    private ArrayList<Match> matchs;

    public Ligue(String nom) {
        this.nom = nom;
        this.combattants = new ArrayList<>();
        this.matchs = new ArrayList<>();
    }

    public void ajouterCombattant(Combattant c) {
        combattants.add(c);
    }

    public void ajouterMatch(Match m) {
        matchs.add(m);
    }

    public ArrayList<Match> getMatchsDuCombattant(Combattant c) {
        ArrayList<Match> resultats = new ArrayList<>();
        for (Match m : matchs) {
            if (m.getCombattant1().equals(c) || m.getCombattant2().equals(c)) {
                resultats.add(m);
            }
        }
        return resultats;
    }
}