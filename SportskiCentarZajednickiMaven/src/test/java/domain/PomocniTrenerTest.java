package domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *
 * @author Kujovic
 */
class PomocniTrenerTest extends AbstractDomainObjectTest {

    PomocniTrener pt;

    @BeforeEach
    void setUp() throws Exception {
        pt = new PomocniTrener();
        ado = new PomocniTrener();
    }

    @AfterEach
    void tearDown() throws Exception {
        ado = null;
        pt = null;
    }

    @Test
    void testPomocniTrener() {
        pt = new PomocniTrener();
        assertNotNull(pt);
    }

    @Test
    void testPomocniTrenerLongStringStringStringString() {
        pt = new PomocniTrener(1l, "Stefan", "Kujovic", "kuja", "kuja98");
        assertNotNull(pt);
        assertTrue(pt.getPomocniTrenerID().equals(1l));
        assertEquals("Stefan", pt.getIme());
        assertEquals("Kujovic", pt.getPrezime());
        assertEquals("kuja", pt.getKorisnickoIme());
        assertEquals("kuja98", pt.getLozinka());
    }

    @Test
    void testSetPomocniTrenerID() {
        pt.setPomocniTrenerID(2L);
         assertTrue(pt.getPomocniTrenerID().equals(2l));
    }

    @Test
    void testSetIme() {
        pt.setIme("Stefan");
        assertEquals("Stefan", pt.getIme());
    }

    @Test
    void testSetPrezime() {
        pt.setPrezime("Kujovic");
        assertEquals("Kujovic", pt.getPrezime());
    }

    @Test
    void testSetKorisnickoIme() {
        pt.setKorisnickoIme("kuja");
        assertEquals("kuja", pt.getKorisnickoIme());
    }

    @Test
    void testSetLozinka() {
        pt.setLozinka("kuja98");
        assertEquals("kuja98", pt.getLozinka());
    }
/*
    @ParameterizedTest
    @CsvSource({
        "1, Stefan, Kujovic, kuja, kuja98, 1, Stefan, Kujovic, kuja, kuja98, true",
        "1, Stefan, Kujovic, kuja, kuja98, 1, Stefan, Kujovic, kuja, kuja, false",
        "1, Stefan, Kujovic, kuja, kuja98, 1, Milos, Kujovic, kuja, kuja98, false",})
    void testEqualsObjects(Long ptID1, String ime1, String prezime1, String korisnickoIme1,
            String lozinka1, Long ptID2, String ime2, String prezime2, String korisnickoIme2, String lozinka2, boolean equals) {
        PomocniTrener pt1 = new PomocniTrener(ptID1, ime1, prezime1, korisnickoIme1, lozinka1);
        PomocniTrener pt2 = new PomocniTrener(ptID2, ime2, prezime2, korisnickoIme2, lozinka2);
        assertEquals(pt1.equals(pt2),equals);
    }
*/
    

}
