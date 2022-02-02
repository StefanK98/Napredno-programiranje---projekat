/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    public void addPomocniTrener(PomocniTrener pomocniTrener) throws Exception{
        AbstractSO aso=new SOAddPomocniTrener();
        aso.templateExecute(pomocniTrener);
    }

    public void addKorisnik(Korisnik korisnik) throws Exception{
        AbstractSO aso=new SOAddKorisnik();
        aso.templateExecute(korisnik);
    }

    public void addTrening(Trening trening) throws Exception{
        AbstractSO aso=new SOAddTrening();
        aso.templateExecute(trening);
    }

    public void addZakazanTermin(ZakazanTermin zakazanTermin) throws Exception{
        AbstractSO aso=new SOAddZakazanTermin();
        aso.templateExecute(zakazanTermin);
    }
    
    public void addVezbaZaTermin(VezbaZaTermin vezbaZaTermin) throws Exception{
        AbstractSO aso=new SOAddVezbaZaTermin();
        aso.templateExecute(vezbaZaTermin);
    }

    public void deletePomocniTrener(PomocniTrener pomocniTrener) throws Exception{
        AbstractSO aso=new SODeletePomocniTrener();
        aso.templateExecute(pomocniTrener);
    }

    public void deleteKorisnik(Korisnik korisnik) throws Exception{
        AbstractSO aso=new SODeleteKorisnik();
        aso.templateExecute(korisnik);
    }

    public void deleteTrening(Trening trening) throws Exception{
        AbstractSO aso=new SODeleteTrening();
        aso.templateExecute(trening);
    }

    public void deleteZakazanTermin(ZakazanTermin zakazanTermin) throws Exception{
        AbstractSO aso=new SODeleteZakazanTermin();
        aso.templateExecute(zakazanTermin);
    }
    
    public void deleteVezbaZaTermin(VezbaZaTermin vezbaZaTermin) throws Exception{
        AbstractSO aso=new SODeleteVezbaZaTermin();
        aso.templateExecute(vezbaZaTermin);
    }

    public void editPomocniTrener(PomocniTrener pomocniTrener) throws Exception{
        AbstractSO aso=new SOEditPomocniTrener();
        aso.templateExecute(pomocniTrener);
    }

    public void editKorisnik(Korisnik korisnik) throws Exception{
        AbstractSO aso=new SOEditKorisnik();
        aso.templateExecute(korisnik);
    }

    public void editTrening(Trening trening) throws Exception{
        AbstractSO aso=new SOEditTrening();
        aso.templateExecute(trening);
    }
    
    public ArrayList<PomocniTrener> getAllPomocniTrener() throws Exception{
        SOGetAllPomocniTrener so=new SOGetAllPomocniTrener();
        so.templateExecute(new PomocniTrener());
        return so.getLista();
    }

    public ArrayList<Korisnik> getAllKorisnik() throws Exception{
        SOGetAllKorisnik so=new SOGetAllKorisnik();
        so.templateExecute(new Korisnik());
        return so.getLista();
    }

    public ArrayList<Trening> getAllTrening() throws Exception{
        SOGetAllTrening so=new SOGetAllTrening();
        so.templateExecute(new Trening());
        return so.getLista();
    }

    public ArrayList<ZakazanTermin> getAllZakazanTermin() throws Exception{
        SOGetAllZakazanTermin so=new SOGetAllZakazanTermin();
        so.templateExecute(new ZakazanTermin());
        return so.getLista();
    }
    
    public ArrayList<VezbaZaTermin> getAllVezbaZaTermin() throws Exception{
        SOGetAllVezbaZaTermin so=new SOGetAllVezbaZaTermin();
        so.templateExecute(new VezbaZaTermin());
        return so.getLista();
    }
    
    public ArrayList<TipKorisnika> getAllTipKorisnika() throws Exception{
        SOGetAllTipKorisnika so=new SOGetAllTipKorisnika();
        so.templateExecute(new TipKorisnika());
        return so.getLista();
    }
    
    public ArrayList<VrstaTreninga> getAllVrstaTreninga() throws Exception{
        SOGetAllVrstaTreninga so=new SOGetAllVrstaTreninga();
        so.templateExecute(new VrstaTreninga());
        return so.getLista();
    }
}
