package domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Kujovic
 */
class VrstaTreningaTest extends AbstractDomainObjectTest{
	VrstaTreninga vt;
	
	@BeforeEach
	void setUp() throws Exception {
		ado = new VrstaTreninga();
		vt = new VrstaTreninga();
	}

	@AfterEach
	void tearDown() throws Exception {
		ado = null;
		vt = null;
	}

	@Test
	void testVrstaTreninga() {
		vt = new VrstaTreninga();
		assertNotNull(vt);
	}

	@Test
	void testVrstaTreningaLongString() {
		vt = new VrstaTreninga(1L, "grupni");
		assertNotNull(vt);
		assertTrue(vt.getVrstaTreningaID().equals(1L));
		assertEquals("grupni", vt.getNazivVrsteTreninga());
	}

	@Test
	void testSetVrstaTreningaID() {
		vt.setVrstaTreningaID(2L);
		assertTrue(vt.getVrstaTreningaID().equals(2L));
	}

	@Test
	void testSetNazivVrsteTreninga() {
		vt.setNazivVrsteTreninga("grupni");
		assertEquals("grupni", vt.getNazivVrsteTreninga());
	}

}
