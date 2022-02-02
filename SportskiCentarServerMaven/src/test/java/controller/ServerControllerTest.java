package controller;

import db.DBBroker;
import domain.Korisnik;
import domain.PomocniTrener;
import domain.TipKorisnika;
import domain.Trening;
import domain.VrstaTreninga;
import domain.ZakazanTermin;
import java.util.Date;
import static junit.framework.TestCase.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Kujovic
 */
class ServerControllerTest {
	private static PomocniTrener pt1, pt2;
	private static TipKorisnika tk1, tk2;
	private static VrstaTreninga vt1, vt2;
	private static Korisnik k1, k2;
	private static Trening t1, t2;
	private static ZakazanTermin zt1;
		
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		tk1 = new TipKorisnika(1L, "takmicar", "individualno");
		tk2 = new TipKorisnika(2L, "takmicar", "grupno");
		vt1 = new VrstaTreninga(1L, "individualni");
		vt2 = new VrstaTreninga(2L, "grupni");		
		
		pt1 = new PomocniTrener(1L, "Stefan", "Kujovic", "kuja", "kuja98");
		ServerController.getInstance().addPomocniTrener(pt1);		
		
		pt2 = new PomocniTrener(2L, "Milos", "Kujovic", "milos", "milos123");
		ServerController.getInstance().addPomocniTrener(pt2);		
		
		k1 = new Korisnik(1L, "Marko", "Djulcic", "062345678", "marko@gmail.com", tk1);
		ServerController.getInstance().addKorisnik(k1);
		
		k2 = new Korisnik(2L, "Nadja", "Babic", "061 111 222", "nadja@gmail.com", tk2);
		ServerController.getInstance().addKorisnik(k2);
		
		t1 = new Trening(1L, "crossfit", vt1);
		ServerController.getInstance().addTrening(t1);
		
		t2 = new Trening(2L, "dizanje tegova", vt2);
		ServerController.getInstance().addTrening(t2);
		
		zt1 = new ZakazanTermin(1L, new Date(), pt1, k1, t1, null);
		ServerController.getInstance().addZakazanTermin(zt1);		
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		ServerController.getInstance().deletePomocniTrener(pt1);
		ServerController.getInstance().deleteKorisnik(k1);
		ServerController.getInstance().deleteTrening(t1);
		ServerController.getInstance().deleteZakazanTermin(zt1);		
	}

	@Test
	void testAddPomocniTrener() throws Exception {		
		PomocniTrener pt3 = new PomocniTrener(3L, "Milos", "Lukovic", "marko1", "marko1!");
		ServerController.getInstance().addPomocniTrener(pt3);
		assertFalse(DBBroker.getInstance().select(pt3).isEmpty());
		ServerController.getInstance().deletePomocniTrener(pt3);
	}

	@Test
	void testAddKorisnik() throws Exception {
		Korisnik k = new Korisnik(3L, "Stefan", "Kujovic", "0656522211", "stefan@gmail.com", tk1);
		ServerController.getInstance().addKorisnik(k);
		assertFalse(DBBroker.getInstance().select(k).isEmpty());
		ServerController.getInstance().deleteKorisnik(k);
	}

	@Test
	void testAddTrening() throws Exception {
		Trening t = new  Trening(3L, "crossfit", vt1);
		ServerController.getInstance().addTrening(t);
		assertFalse(DBBroker.getInstance().select(t).isEmpty());
		ServerController.getInstance().deleteTrening(t);
	}

	@Test
	void testAddZakazanTermin() throws Exception {
	    Date date = new Date();
		ZakazanTermin zt = new  ZakazanTermin(2L, date, pt1, k1, t1, null);
		ServerController.getInstance().addZakazanTermin(zt);
		assertFalse(DBBroker.getInstance().select(zt).isEmpty());
		ServerController.getInstance().deleteZakazanTermin(zt);
	}
	
	@Test
	void testDeletePomocniTrener() throws Exception{
		ServerController.getInstance().deletePomocniTrener(pt2);
		assertTrue(DBBroker.getInstance().select(pt2).isEmpty());
	}

	@Test
	void testDeleteKorisnik() throws Exception {
		ServerController.getInstance().deleteKorisnik(k2);
		assertTrue(DBBroker.getInstance().select(k2).isEmpty());
	}

	@Test
	void testDeleteTrening() throws Exception {
		ServerController.getInstance().deleteTrening(t2);
		assertTrue(DBBroker.getInstance().select(t2).isEmpty());
	}

	@Test
	void testDeleteZakazanTermin() throws Exception {
		ServerController.getInstance().deleteZakazanTermin(zt1);
		assertTrue(DBBroker.getInstance().select(zt1).isEmpty());
	}	

	@Test
	void testEditPomocniTrener() throws Exception {
		PomocniTrener pt = ServerController.getInstance().getAllPomocniTrener().get(0);
		pt.setIme("Milos");
		ServerController.getInstance().editPomocniTrener(pt);
		PomocniTrener ptNakonIzmene = ServerController.getInstance().getAllPomocniTrener().get(0);
		assertEquals("Milos", ptNakonIzmene.getIme());		
	}

	@Test
	void testEditKorisnik() throws Exception {
		Korisnik k = ServerController.getInstance().getAllKorisnik().get(0);
		k.setIme("Anja");
		ServerController.getInstance().editKorisnik(k);
		Korisnik kNakonIzmene = ServerController.getInstance().getAllKorisnik().get(0);
		assertEquals("Anja", kNakonIzmene.getIme());	
	}

	@Test
	void testEditTrening() throws Exception {
		Trening t = ServerController.getInstance().getAllTrening().get(0);
		t.setNazivTreninga("izmenjen naziv");
		ServerController.getInstance().editTrening(t);
		Trening tNakonIzmene = ServerController.getInstance().getAllTrening().get(0);
		assertEquals("izmenjen naziv", tNakonIzmene.getNazivTreninga());	
	}

	@Test
	void testGetAllPomocniTrener() throws Exception {
		assertFalse(ServerController.getInstance().getAllPomocniTrener().isEmpty());
	}

	@Test
	void testGetAllKorisnik() throws Exception {
		assertFalse(ServerController.getInstance().getAllKorisnik().isEmpty());
	}

	@Test
	void testGetAllTrening() throws Exception {
		assertFalse(ServerController.getInstance().getAllTrening().isEmpty());
	}

	@Test
	void testGetAllZakazanTermin() throws Exception {
		assertFalse(ServerController.getInstance().getAllZakazanTermin().isEmpty());
	}	
}
