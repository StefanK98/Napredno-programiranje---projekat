/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import controller.ServerController;
import domain.Korisnik;
import domain.PomocniTrener;
import domain.Trening;
import domain.VezbaZaTermin;
import domain.ZakazanTermin;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import transfer.Request;
import transfer.Response;
import transfer.util.Operation;
import transfer.util.ResponseStatus;

/**
 *
 * @author Kujovic
 */
public class ThreadClient extends Thread {

    private Socket socket;

    public ThreadClient(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                Request req = (Request) in.readObject();
                Response res = handleRequest(req);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(res);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Response handleRequest(Request req) {
        Response res = new Response(null, null, ResponseStatus.Success);
        try {
            switch (req.getOperation()) {
                case Operation.ADD_POMOCNITRENER:
                    ServerController.getInstance().addPomocniTrener((PomocniTrener) req.getData());
                    break;
                case Operation.ADD_KORISNIK:
                    ServerController.getInstance().addKorisnik((Korisnik) req.getData());
                    break;
                case Operation.ADD_TRENING:
                    ServerController.getInstance().addTrening((Trening) req.getData());
                    break;
                case Operation.ADD_ZAKAZAN_TERMIN:
                    ServerController.getInstance().addZakazanTermin((ZakazanTermin) req.getData());
                    break;
                case Operation.ADD_VEZBA_ZA_TERMIN:
                    ServerController.getInstance().addVezbaZaTermin((VezbaZaTermin) req.getData());
                    break;
                case Operation.DELETE_POMOCNITRENER:
                    ServerController.getInstance().deletePomocniTrener((PomocniTrener) req.getData());
                    break;
                case Operation.DELETE_KORISNIK:
                    ServerController.getInstance().deleteKorisnik((Korisnik) req.getData());
                    break;
                case Operation.DELETE_TRENING:
                    ServerController.getInstance().deleteTrening((Trening) req.getData());
                    break;
                case Operation.DELETE_ZAKAZAN_TERMIN:
                    ServerController.getInstance().deleteZakazanTermin((ZakazanTermin) req.getData());
                    break;
                case Operation.DELETE_VEZBA_ZA_TERMIN:
                    ServerController.getInstance().deleteVezbaZaTermin((VezbaZaTermin) req.getData());
                    break;
                case Operation.EDIT_POMOCNITRENER:
                    ServerController.getInstance().editPomocniTrener((PomocniTrener) req.getData());
                    break;
                case Operation.EDIT_KORISNIK:
                    ServerController.getInstance().editKorisnik((Korisnik) req.getData());
                    break;
                case Operation.EDIT_TRENING:
                    ServerController.getInstance().editTrening((Trening) req.getData());
                    break;
                case Operation.GET_ALL_POMOCNITRENER:
                    res.setData(ServerController.getInstance().getAllPomocniTrener());
                    break;
                case Operation.GET_ALL_KORISNIK:
                    res.setData(ServerController.getInstance().getAllKorisnik());
                    break;
                case Operation.GET_ALL_TRENING:
                    res.setData(ServerController.getInstance().getAllTrening());
                    break;
                case Operation.GET_ALL_ZAKAZAN_TERMIN:
                    res.setData(ServerController.getInstance().getAllZakazanTermin());
                    break;
                case Operation.GET_ALL_VEZBA_ZA_TERMIN:
                    res.setData(ServerController.getInstance().getAllVezbaZaTermin());
                    break;
                case Operation.GET_ALL_TIP_KORISNIKA:
                    res.setData(ServerController.getInstance().getAllTipKorisnika());
                    break;  
                case Operation.GET_ALL_VRSTA_TRENINGA:
                    res.setData(ServerController.getInstance().getAllVrstaTreninga());
                    break;
                case Operation.LOGIN:
                    ArrayList<PomocniTrener> listaPomocnihTrenera
                            = ServerController.getInstance().getAllPomocniTrener();

                    PomocniTrener pt = (PomocniTrener) req.getData();
                    for (PomocniTrener pomocniTrener : listaPomocnihTrenera) {
                        if (pomocniTrener.getKorisnickoIme().equals(pt.getKorisnickoIme())
                                && pomocniTrener.getLozinka().equals(pt.getLozinka())) {
                            res.setData(pomocniTrener);
                        }
                    }
                    if (res.getData() == null) {
                        throw new Exception("Ne postoji pomocni trener sa tim kredencijalima.");
                    } else {
                        break;
                    }
                default:
                    return null;
            }
        } catch (Exception e) {
            res.setError(e);
            res.setData(null);
            res.setResponseStatus(ResponseStatus.Error);
        }
        return res;
    }
}


