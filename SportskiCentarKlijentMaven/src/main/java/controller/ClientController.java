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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import session.Session;
import transfer.Request;
import transfer.Response;
import transfer.util.Operation;
import transfer.util.ResponseStatus;

/**
 *
 * @author Kujovic
 */
public class ClientController {
    private static ClientController instance;

    public ClientController() {
    }

    public static ClientController getInstance() {
        if(instance == null)
            instance = new ClientController();
        return instance;
    }
    
    public PomocniTrener login(PomocniTrener administrator) throws Exception{
        return (PomocniTrener)sendRequest(Operation.LOGIN, administrator);
    }
    
     public void addKorisnik(Korisnik korisnik) throws Exception{
         sendRequest(Operation.ADD_KORISNIK, korisnik);
     }

     public void addTrening(Trening trening) throws Exception{
         sendRequest(Operation.ADD_TRENING, trening);
     }

     public void addZakazanTermin(ZakazanTermin zakazanTermin) throws Exception{
         sendRequest(Operation.ADD_ZAKAZAN_TERMIN, zakazanTermin);
     }
     
     public void addVezbaZaTermin(VezbaZaTermin vezbaZaTermin) throws Exception{
         sendRequest(Operation.ADD_VEZBA_ZA_TERMIN, vezbaZaTermin);
     }

     public void addPomocniTrener(PomocniTrener pomocniTrener) throws Exception{
         sendRequest(Operation.ADD_POMOCNITRENER, pomocniTrener);
     }

     public void deleteKorisnik(Korisnik korisnik) throws Exception{
         sendRequest(Operation.DELETE_KORISNIK, korisnik);
     }

     public void deleteTrening(Trening trening) throws Exception{
         sendRequest(Operation.DELETE_TRENING, trening);
     }

     public void deleteZakazanTermin(ZakazanTermin zakazanTermin) throws Exception{
         sendRequest(Operation.DELETE_ZAKAZAN_TERMIN, zakazanTermin);
     }
     
     public void deleteVezbaZaTermin(VezbaZaTermin vezbaZaTermin) throws Exception{
         sendRequest(Operation.DELETE_VEZBA_ZA_TERMIN, vezbaZaTermin);
     }

     public void deletePomocniTrener(PomocniTrener pomocniTrener) throws Exception{
         sendRequest(Operation.DELETE_POMOCNITRENER, pomocniTrener);
     }

     public void editKorisnik(Korisnik korisnik) throws Exception{
         sendRequest(Operation.EDIT_KORISNIK, korisnik);
     }

     public void editTrening(Trening trening) throws Exception{
         sendRequest(Operation.EDIT_TRENING, trening);
     }

     public void editPomocniTrener(PomocniTrener pomocniTrener) throws Exception{
         sendRequest(Operation.EDIT_POMOCNITRENER, pomocniTrener);
     }

     public ArrayList<Korisnik> getAllKorisnik() throws Exception{
         return (ArrayList<Korisnik>)sendRequest(Operation.GET_ALL_KORISNIK, null);
     }

     public ArrayList<Trening> getAllTrening() throws Exception{
         return (ArrayList<Trening>)sendRequest(Operation.GET_ALL_TRENING, null);
     }

     public ArrayList<ZakazanTermin> getAllZakazanTermin() throws Exception{
         return (ArrayList<ZakazanTermin>)sendRequest(Operation.GET_ALL_ZAKAZAN_TERMIN, null);
     }
     
     public ArrayList<VezbaZaTermin> getAllVezbaZaTermin() throws Exception{
         return (ArrayList<VezbaZaTermin>)sendRequest(Operation.GET_ALL_VEZBA_ZA_TERMIN, null);
     }

     public ArrayList<PomocniTrener> getAllPomocniTrener() throws Exception{
         return (ArrayList<PomocniTrener>)sendRequest(Operation.GET_ALL_POMOCNITRENER, null);
     }
     
     public ArrayList<TipKorisnika> getAllTipKorisnika() throws Exception{
         return (ArrayList<TipKorisnika>)sendRequest(Operation.GET_ALL_TIP_KORISNIKA, null);
     }
     
     public ArrayList<VrstaTreninga> getAllVrstaTreninga() throws Exception{
         return (ArrayList<VrstaTreninga>)sendRequest(Operation.GET_ALL_VRSTA_TRENINGA, null);
     }
    
    private Object sendRequest(int operation,Object data) throws Exception{
        Request req = new Request(operation, data);
        ObjectOutputStream out = new ObjectOutputStream(Session.getInstance().getSocket().getOutputStream());
        out.writeObject(req);
        ObjectInputStream in = new ObjectInputStream(Session.getInstance().getSocket().getInputStream());
        Response res = (Response)in.readObject();
        if(res.getResponseStatus().equals(ResponseStatus.Error))
            throw res.getError();
        else 
            return res.getData();
    }
}
