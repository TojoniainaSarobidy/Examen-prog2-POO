import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class MatchTest {

    private Combattant c1;
    private Combattant c2;

    @BeforeEach
    public void setup() {
        c1 = new Combattant("1", "Zoe", "Francis", "Predator", 119);
        c2 = new Combattant("2", "John", "Calvin", "Stone", 118);
    }

    @Test
    public void testMatchAmicalNeModifiePasPalmares() {
        MatchAmical match = new MatchAmical("Match1", LocalDate.now(), "Allemagne", c1, c2);
        match.setPoints(10, 9);
        match.terminer();

        assertEquals(0, c1.getVictoires());
        assertEquals(0, c2.getDefaites());
        assertEquals(0, c1.getEgalites());
        assertEquals(0, c2.getEgalites());
        assertTrue(c1.getTitres().isEmpty());
        assertTrue(c2.getTitres().isEmpty());
    }

    @Test
    public void testMatchOfficielVictoireEtDefaite() {
        MatchOfficiel match = new MatchOfficiel("Match2", LocalDate.now(), "Madagascar", c1, c2);
        match.setPoints(8, 10);
        match.terminer();

        assertEquals(0, c1.getVictoires());
        assertEquals(1, c1.getDefaites());
        assertEquals(1, c2.getVictoires());
        assertEquals(0, c2.getDefaites());
    }

    @Test
    public void testMatchOfficielEgalite() {
        MatchOfficiel match = new MatchOfficiel("Match3", LocalDate.now(), "New York", c1, c2);
        match.setPoints(9, 9);
        match.terminer();

        assertEquals(1, c1.getEgalites());
        assertEquals(1, c2.getEgalites());
    }

    @Test
    public void testMatchTitreVictoireEtAjoutTitre() {
        MatchTitre match = new MatchTitre("Match4", LocalDate.now(), "Paris", c1, c2, "Champion du Monde");
        match.setPoints(11, 9);
        match.terminer();

        assertEquals(1, c1.getVictoires());
        assertEquals(0, c1.getDefaites());
        assertEquals(0, c1.getEgalites());
        assertTrue(c1.getTitres().contains("Champion du Monde"));

        assertEquals(0, c2.getVictoires());
        assertEquals(1, c2.getDefaites());
        assertEquals(0, c2.getEgalites());
        assertTrue(c2.getTitres().isEmpty());
    }

    @Test
    public void testMatchTitreEgaliteSansTitre() {
        MatchTitre match = new MatchTitre("M5", LocalDate.now(), "Tokyo", c1, c2, "Champion Asie");
        match.setPoints(10, 10);
        match.terminer();

        assertEquals(1, c1.getEgalites());
        assertEquals(1, c2.getEgalites());
        assertTrue(c1.getTitres().isEmpty());
        assertTrue(c2.getTitres().isEmpty());
    }
}