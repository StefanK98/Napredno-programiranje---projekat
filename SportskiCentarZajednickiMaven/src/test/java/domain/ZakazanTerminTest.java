package domain;

import java.sql.Date;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Kujovic
 */
class ZakazanTerminTest extends AbstractDomainObjectTest{
	ZakazanTermin zt;

	@BeforeEach
	void setUp() throws Exception {
		ado = new ZakazanTermin();
		zt = new ZakazanTermin();
	}

	@AfterEach
	void tearDown() throws Exception {
		ado = null;
		zt = null;
	}

	@Test
	void testZakazanTermin() {
		zt = new ZakazanTermin();
		assertNotNull(zt);
	}

	@SuppressWarnings("deprecation")
	@Test
	void testZakazanTerminLongDatePomocniTrenerKorisnikTreningArrayListOfVezbaZaTermin() {		
		PomocniTrener a = new PomocniTrener(1L, "Stefan", "Kujovic", "kuja", "kuja98");
		TipKorisnika tk = new TipKorisnika(1L, "takmičar", "individualno");
		Korisnik k = new Korisnik(1L, "Nadja", "Babic", "0654443335", "nadja@gmail.com", tk);
		VrstaTreninga vt = new VrstaTreninga(1L, "individualni");
		Trening t = new Trening(1L, "Crossfit", vt);		
		zt = new ZakazanTermin(1L, new Date(2022, 2, 2), a, k, t, null);
		
		assertNotNull(zt);
		assertTrue(zt.getZakazanTerminID().equals(1L));
		assertTrue(a.getPomocniTrenerID().equals(zt.getPomocniTrener().getPomocniTrenerID()));
		assertTrue(k.getKorisnikID().equals(zt.getKorisnik().getKorisnikID()));
		assertTrue(t.getTreningID().equals(zt.getTrening().getTreningID()));
		assertEquals(new Date(2022, 2, 2), zt.getDatumVreme());				
	}

	@Test
	void testSetZakazanTerminID() {
		zt.setZakazanTerminID(2L);
		assertTrue(zt.getZakazanTerminID().equals(2L));
	}

	@SuppressWarnings("deprecation")
	@Test
	void testSetDatumVreme() {
		zt.setDatumVreme(new Date(2022, 2, 2));
		assertEquals(new Date(2022, 2, 2), zt.getDatumVreme());
	}

	@Test
	void testSetPomocniTrener() {
		PomocniTrener pt = new PomocniTrener(1L, "Stefan", "Kujovic", "kuja", "kuja98");
		zt.setPomocniTrener(pt);
		
		assertTrue(pt.getPomocniTrenerID().equals(zt.getPomocniTrener().getPomocniTrenerID()));
		assertEquals(pt.getIme(), zt.getPomocniTrener().getIme());
		assertEquals(pt.getPrezime(), zt.getPomocniTrener().getPrezime());
		assertEquals(pt.getKorisnickoIme(), zt.getPomocniTrener().getKorisnickoIme());
		assertEquals(pt.getLozinka(), zt.getPomocniTrener().getLozinka());
		
	}

	@Test
	void testSetKlijent() {
		Korisnik k = new Korisnik(1L, "Nadja", "Babic", "0654443335", "nadja@gmail.com", null);
		zt.setKorisnik(k);
		
		assertTrue(k.getKorisnikID().equals(zt.getKorisnik().getKorisnikID()));
		assertEquals(k.getIme(), zt.getKorisnik().getIme());
		assertEquals(k.getPrezime(), zt.getKorisnik().getPrezime());
		assertEquals(k.getEmail(), zt.getKorisnik().getEmail());
		assertEquals(k.getBrojTelefona(), zt.getKorisnik().getBrojTelefona());
		
	}

	@Test
	void testSetTrening() {		
		Trening t = new Trening(1L, "Crossfit", null);
		zt.setTrening(t);
		
		assertTrue(t.getTreningID().equals(zt.getTrening().getTreningID()));
		assertEquals(t.getNazivTreninga(), zt.getTrening().getNazivTreninga());
	}
}
