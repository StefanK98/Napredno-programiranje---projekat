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
public class TipKorisnikaTest extends AbstractDomainObjectTest{
    
    TipKorisnika tk;

	@BeforeEach
	void setUp() throws Exception {
		ado = new TipKorisnika();
		tk = new TipKorisnika();
	}

	@AfterEach
	void tearDown() throws Exception {
		ado = null;
		tk = null;		
	}

	@Test
	void testTipKorisnika() {
		tk = new TipKorisnika();		
		assertNotNull(tk);
	}

	@Test
	void testTipKorisnikaLongStringString() {
		tk = new TipKorisnika(1L, "takmicar", "grupni");
		assertNotNull(tk);
		assertTrue(tk.getTipKorisnikaID().equals(1L));
		assertEquals("takmicar", tk.getNazivTipaKorisnika());
		assertEquals("grupni", tk.getOpis());
	}

	@Test
	void testSetTipKlijentaID() {
		tk.setTipKorisnikaID(13L);
		assertTrue(tk.getTipKorisnikaID().equals(13L));
	}

	@Test
	void testSetNazivTipaKlijenta() {
		tk.setNazivTipaKorisnika("takmicar");
		assertEquals("takmicar", tk.getNazivTipaKorisnika());
	}

	@Test
	void testSetOpis() {
		tk.setOpis("individualno");
		assertEquals("individualno", tk.getOpis());
	}
    
}
