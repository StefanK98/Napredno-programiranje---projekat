package controller;

import domain.Korisnik;
import domain.PomocniTrener;
import domain.TipKorisnika;
import domain.Trening;
import domain.VezbaZaTermin;
import domain.VrstaTreninga;
import domain.ZakazanTermin;
import java.util.ArrayList;
import so.AbstractSO;
import so.korisnik.SOAddKorisnik;
import so.korisnik.SODeleteKorisnik;
import so.korisnik.SOEditKorisnik;
import so.korisnik.SOGetAllKorisnik;
import so.pomocnitrener.SOAddPomocniTrener;
import so.pomocnitrener.SODeletePomocniTrener;
import so.pomocnitrener.SOEditPomocniTrener;
import so.pomocnitrener.SOGetAllPomocniTrener;
import so.tipkorisnika.SOGetAllTipKorisnika;
import so.trening.SOAddTrening;
import so.trening.SODeleteTrening;
import so.trening.SOEditTrening;
import so.trening.SOGetAllTrening;
import so.vezbazatermin.SOAddVezbaZaTermin;
import so.vezbazatermin.SODeleteVezbaZaTermin;
import so.vezbazatermin.SOGetAllVezbaZaTermin;
import so.vrstatreninga.SOGetAllVrstaTreninga;
import so.zakazantermin.SOAddZakazanTermin;
import so.zakazantermin.SODeleteZakazanTermin;
import so.zakazantermin.SOGetAllZakazanTermin;

/**
 *
 * @author Kujovic
 */
public class ServerController {
    private static ServerController instance;

    public ServerController() {
    }

    public static ServerController getInstance() {
        if(instance==null)
            instance=new ServerController();
        return instance;
    }
    
    /**
     * Poziva sistemsku operaciju addPomocniTrener kojom dodaje pomoćnog trenera.
     * 
     * @param pomocniTrener Objekat klase PomocniTrener.
     * @throws Exception Ako prosleđeni objekat nije instanca klase PomocniTrener.
     */
    public void addPomocniTrener(PomocniTrener pomocniTrener) throws Exception{
        AbstractSO aso=new SOAddPomocniTrener();
        aso.templateExecute(pomocniTrener);
    }

    /**
     * Poziva sistemsku operaciju addKorisnik kojom dodaje korisnika.
     * 
     * @param korisnik Objekat klase Korisnik.
     * @throws Exception Ako prosleđeni objekat nije instanca klase Korisnik.
     */
    public void addKorisnik(Korisnik korisnik) throws Exception{
        AbstractSO aso=new SOAddKorisnik();
        aso.templateExecute(korisnik);
    }

    /**
     * Poziva sistemsku operaciju addTrening kojom dodaje trening.
     * 
     * @param trening Objekat klase Trening.
     * @throws Exception Ako prosleđeni objekat nije instanca klase Trening.
     */
    public void addTrening(Trening trening) throws Exception{
        AbstractSO aso=new SOAddTrening();
        aso.templateExecute(trening);
    }

    /**
     * Poziva sistemsku operaciju addZakazanTermin kojom dodaje zakazan termin.
     * 
     * @param zakazanTermin Objekat klase ZakazanTermin.
     * @throws Exception Ako prosleđeni objekat nije instanca klase ZakazanTermin.
     */
    public void addZakazanTermin(ZakazanTermin zakazanTermin) throws Exception{
        AbstractSO aso=new SOAddZakazanTermin();
        aso.templateExecute(zakazanTermin);
    }
    
    /**
     * Poziva sistemsku operaciju addVezbaZaTermin kojom dodaje vežbu za termin.
     * 
     * @param vezbaZaTermin Objekat klase VezbaZaTermin.
     * @throws Exception Ako prosleđeni objekat nije instanca klase VezbaZaTermin.
     */
    public void addVezbaZaTermin(VezbaZaTermin vezbaZaTermin) throws Exception{
        AbstractSO aso=new SOAddVezbaZaTermin();
        aso.templateExecute(vezbaZaTermin);
    }

    /**
     * Poziva sistemsku operaciju deletePomocniTrener kojom briše pomoćnog trenera.
     * 
     * @param pomocniTrener Objekat klase PomocniTrener.
     * @throws Exception Ako prosleđeni objekat nije instanca klase PomocniTrener.
     */
    public void deletePomocniTrener(PomocniTrener pomocniTrener) throws Exception{
        AbstractSO aso=new SODeletePomocniTrener();
        aso.templateExecute(pomocniTrener);
    }

    /**
     * Poziva sistemsku operaciju deleteKorisnik kojom briše korisnika.
     * 
     * @param korisnik Objekat klase Korisnik.
     * @throws Exception Ako prosleđeni objekat nije instanca klase Korisnik.
     */
    public void deleteKorisnik(Korisnik korisnik) throws Exception{
        AbstractSO aso=new SODeleteKorisnik();
        aso.templateExecute(korisnik);
    }

    /**
     * Poziva sistemsku operaciju deleteTrening kojom briše trening.
     * 
     * @param trening Objekat klase Trening.
     * @throws Exception Ako prosleđeni objekat nije instanca klase Trening.
     */
    public void deleteTrening(Trening trening) throws Exception{
        AbstractSO aso=new SODeleteTrening();
        aso.templateExecute(trening);
    }

    /**
     * Poziva sistemsku operaciju deleteZakazanTermin kojom briše zakazan termin.
     * 
     * @param zakazanTermin Objekat klase ZakazanTermin.
     * @throws Exception Ako prosleđeni objekat nije instanca klase ZakazanTermin.
     */
    public void deleteZakazanTermin(ZakazanTermin zakazanTermin) throws Exception{
        AbstractSO aso=new SODeleteZakazanTermin();
        aso.templateExecute(zakazanTermin);
    }
    
    /**
     * Poziva sistemsku operaciju deleteVezbaZaTermin kojom briše vežbu za termin.
     * 
     * @param vezbaZaTermin Objekat klase VezbaZaTermin.
     * @throws Exception Ako prosleđeni objekat nije instanca klase VezbaZaTermin.
     */
    public void deleteVezbaZaTermin(VezbaZaTermin vezbaZaTermin) throws Exception{
        AbstractSO aso=new SODeleteVezbaZaTermin();
        aso.templateExecute(vezbaZaTermin);
    }

    /**
     * Poziva sistemsku operaciju editPomocniTrener kojom izmenjuje pomoćnog trenera.
     * 
     * @param pomocniTrener Objekat klase PomocniTrener.
     * @throws Exception Ako prosleđeni objekat nije instanca klase PomocniTrener.
     */
    public void editPomocniTrener(PomocniTrener pomocniTrener) throws Exception{
        AbstractSO aso=new SOEditPomocniTrener();
        aso.templateExecute(pomocniTrener);
    }

    /**
     * Poziva sistemsku operaciju editKorisnik kojom izmenjuje korisnika.
     * 
     * @param korisnik Objekat klase Korisnik.
     * @throws Exception Ako prosleđeni objekat nije instanca klase Korisnik.
     */
    public void editKorisnik(Korisnik korisnik) throws Exception{
        AbstractSO aso=new SOEditKorisnik();
        aso.templateExecute(korisnik);
    }

    /**
     * Poziva sistemsku operaciju editTrening kojom izmenjuje trening.
     * 
     * @param trening Objekat klase Trening.
     * @throws Exception Ako prosleđeni objekat nije instanca klase Trening.
     */
    public void editTrening(Trening trening) throws Exception{
        AbstractSO aso=new SOEditTrening();
        aso.templateExecute(trening);
    }
    
    /**
     *Poziva sistemsku operaciju getAllPomocniTrener kojom vraća listu pomoćnih trenera.
     * 
     * @return Vraća listu svih pomoćnih trenera.
     * @throws Exception Ako prosleđeni objekat nije instanca klase PomocniTrener.
     */
    public ArrayList<PomocniTrener> getAllPomocniTrener() throws Exception{
        SOGetAllPomocniTrener so=new SOGetAllPomocniTrener();
        so.templateExecute(new PomocniTrener());
        return so.getLista();
    }

    /**
     * Poziva sistemsku operaciju getAllKorisnik kojom vraća listu korisnika.
     * 
     * @return Vraća listu svih korisnika.
     * @throws Exception Ako prosleđeni objekat nije instanca klase Korisnik.
     */
    public ArrayList<Korisnik> getAllKorisnik() throws Exception{
        SOGetAllKorisnik so=new SOGetAllKorisnik();
        so.templateExecute(new Korisnik());
        return so.getLista();
    }

    /**
     * Poziva sistemsku operaciju getAllTrening kojom vraća listu svih treninga.
     * 
     * @return Vraća listu svih treninga.
     * @throws Exception Ako prosleđeni objekat nije instanca klase Trening.
     */
    public ArrayList<Trening> getAllTrening() throws Exception{
        SOGetAllTrening so=new SOGetAllTrening();
        so.templateExecute(new Trening());
        return so.getLista();
    }

    /**
     * Poziva sistemsku operaciju getAllZakazanTermin kojom vraća sve zakazane termine.
     * 
     * @return Vraća listu svih zakazanih termina.
     * @throws Exception Ako prosleđeni objekat nije instanca klase ZakazanTermin.
     */
    public ArrayList<ZakazanTermin> getAllZakazanTermin() throws Exception{
        SOGetAllZakazanTermin so=new SOGetAllZakazanTermin();
        so.templateExecute(new ZakazanTermin());
        return so.getLista();
    }
    
    /**
     * Poziva sistemsku operaciju getAllVezbaZaTermin kojom vraća sve vežbe za termin.
     * 
     * @return Vraća listu svih vežbi za izabrani termin.
     * @throws Exception Ako prosleđeni objekat nije instanca klase VezbaZaTermin.
     */
    public ArrayList<VezbaZaTermin> getAllVezbaZaTermin() throws Exception{
        SOGetAllVezbaZaTermin so=new SOGetAllVezbaZaTermin();
        so.templateExecute(new VezbaZaTermin());
        return so.getLista();
    }
    
    /**
     * Poziva sistemsku operaciju getAllTipKorisnika kojom vraća sve tipove korisnika.
     * 
     * @return Vraća listu svih tipova korisnika.
     * @throws Exception Ako prosleđeni objekat nije instanca klase TipKorisnika.
     */
    public ArrayList<TipKorisnika> getAllTipKorisnika() throws Exception{
        SOGetAllTipKorisnika so=new SOGetAllTipKorisnika();
        so.templateExecute(new TipKorisnika());
        return so.getLista();
    }
    
    /**
     * Poziva sistemsku operaciju getAllVrstaTreninga kojom vraća sve vrste treninga.
     * 
     * @return Vraća listu svih vrsta treninga.
     * @throws Exception Ako prosleđeni objekat nije instanca klase VrstaTreninga.
     */
    public ArrayList<VrstaTreninga> getAllVrstaTreninga() throws Exception{
        SOGetAllVrstaTreninga so=new SOGetAllVrstaTreninga();
        so.templateExecute(new VrstaTreninga());
        return so.getLista();
    }
}
