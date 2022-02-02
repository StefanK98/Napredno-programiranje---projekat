package domain;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Kujovic
 */
class KorisnikTest extends AbstractDomainObjectTest{
	Korisnik k;
		
@BeforeEach
	void setUp() throws Exception {
		ado = new Korisnik();
		k = new Korisnik();
	}

	@AfterEach
	void tearDown() throws Exception {
		k = null;
		ado = null;
	}

	@Test
	void testKorisnik() {
		k = new Korisnik();
		assertNotNull(k);
	}

	@Test
	void testKorisnikLongStringStringStringStringTipKlijenta() {
		TipKorisnika tk = new TipKorisnika(1L, "tip korisnika", "opis");
		k = new Korisnik(11L, "Stefan", "Kujovic", "0654443332", "skujovic@gmail.com", tk);
		assertNotNull(k);
		assertTrue(k.getKorisnikID().equals(11L));
		assertEquals("Stefan", k.getIme());
		assertEquals("Kujovic", k.getPrezime());
		assertEquals("0654443332", k.getBrojTelefona());
		assertEquals("skujovic@gmail.com", k.getEmail());
		assertTrue(tk.getTipKorisnikaID().equals(k.getTipKorisnika().getTipKorisnikaID()));
		assertTrue(tk.getNazivTipaKorisnika().equals(k.getTipKorisnika().getNazivTipaKorisnika()));
		assertTrue(tk.getOpis().equals(k.getTipKorisnika().getOpis()));		
	}

	@Test
	void testSetKorisnikID() {
		k.setKorisnikID(10L);
		assertTrue(k.getKorisnikID().equals(10L));
	}

	@Test
	void testSetIme() {
		k.setIme("Stefan");
		assertEquals("Stefan", k.getIme());
	}

	@Test
	void testSetPrezime() {
		k.setPrezime("Kujovic");
		assertEquals("Kujovic", k.getPrezime());
	}

	@Test
	void testSetBrojTelefona() {
		k.setBrojTelefona("0654443332");
		assertEquals("0654443332", k.getBrojTelefona());
	}

	@Test
	void testSetEmail() {
		k.setEmail("skujovic@gmail.com");
		assertEquals("skujovic@gmail.com", k.getEmail());
	}

	@Test
	void testSetTipKorisnika() {
		TipKorisnika tk = new TipKorisnika(10L, "Takmičar", "individualno");
		k.setTipKorisnika(tk);		
		assertTrue(tk.getTipKorisnikaID().equals(k.getTipKorisnika().getTipKorisnikaID()));
		assertTrue(tk.getNazivTipaKorisnika().equals(k.getTipKorisnika().getNazivTipaKorisnika()));
		assertTrue(tk.getOpis().equals(k.getTipKorisnika().getOpis()));		
		
	}
}