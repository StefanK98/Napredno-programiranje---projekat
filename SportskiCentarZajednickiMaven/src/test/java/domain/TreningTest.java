package domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Kujovic
 */
class TreningTest extends AbstractDomainObjectTest {
	Trening t;

	@BeforeEach
	void setUp() throws Exception {
		ado = new Trening();
		t = new Trening();
	}

	@AfterEach
	void tearDown() throws Exception {
		ado = null;
		t = null;
	}

	@Test
	void testTrening() {
		t = new Trening();
		assertNotNull(t);
	}

	@Test
	void testTreningLongStringVrstaTreninga() {
		VrstaTreninga vt = new VrstaTreninga(1L, "grupni");
		t = new Trening(1L, "Crossfit", vt);
		assertNotNull(t);
		assertTrue(t.getTreningID().equals(1L));
		assertEquals("Crossfit", t.getNazivTreninga());
		assertTrue(vt.getVrstaTreningaID().equals(t.getVrstaTreninga().getVrstaTreningaID()));
		assertEquals(vt.getNazivVrsteTreninga(), t.getVrstaTreninga().getNazivVrsteTreninga());		
	}

	@Test
	void testSetVrstaTreninga() {
		VrstaTreninga vt = new VrstaTreninga(2L, "individualni");
		t.setVrstaTreninga(vt);
		assertTrue(vt.getVrstaTreningaID().equals(t.getVrstaTreninga().getVrstaTreningaID()));
		assertEquals(vt.getNazivVrsteTreninga(), t.getVrstaTreninga().getNazivVrsteTreninga());	
	}

	@Test
	void testSetTreningID() {
		t.setTreningID(20L);
		assertTrue(t.getTreningID().equals(20L));
	}

	@Test
	void testSetNazivTreninga() {
		t.setNazivTreninga("Crossfit");
		assertEquals("Crossfit", t.getNazivTreninga());
	}

}