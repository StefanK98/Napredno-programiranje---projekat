/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Kujovic
 */
public class ZakazanTermin extends AbstractDomainObject implements Serializable{
    
    private Long zakazanTerminID;
    private Date datumVreme;
    private PomocniTrener pomocniTrener;
    private Korisnik korisnik;
    private Trening trening;
    private ArrayList<VezbaZaTermin> vezbeZaTermin;

    public ZakazanTermin() {
    }

    public ZakazanTermin(Long zakazanTerminID, Date datumVreme, PomocniTrener pomocniTrener, Korisnik korisnik, Trening trening, ArrayList<VezbaZaTermin> vezbeZaTermin) {
        this.zakazanTerminID = zakazanTerminID;
        this.datumVreme = datumVreme;
        this.pomocniTrener = pomocniTrener;
        this.korisnik = korisnik;
        this.trening = trening;
        this.vezbeZaTermin = vezbeZaTermin;
    }

    /**
     * @return the zakazanTerminID
     */
    public Long getZakazanTerminID() {
        return zakazanTerminID;
    }

    /**
     * @param zakazanTerminID the zakazanTerminID to set
     */
    public void setZakazanTerminID(Long zakazanTerminID) {
        this.zakazanTerminID = zakazanTerminID;
    }

    /**
     * @return the datumVreme
     */
    public Date getDatumVreme() {
        return datumVreme;
    }

    /**
     * @param datumVreme the datumVreme to set
     */
    public void setDatumVreme(Date datumVreme) {
        this.datumVreme = datumVreme;
    }

    /**
     * @return the pomocniTrener
     */
    public PomocniTrener getPomocniTrener() {
        return pomocniTrener;
    }

    /**
     * @param pomocniTrener the pomocniTrener to set
     */
    public void setPomocniTrener(PomocniTrener pomocniTrener) {
        this.pomocniTrener = pomocniTrener;
    }

    /**
     * @return the korisnik
     */
    public Korisnik getKorisnik() {
        return korisnik;
    }

    /**
     * @param korisnik the korisnik to set
     */
    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    /**
     * @return the trening
     */
    public Trening getTrening() {
        return trening;
    }

    /**
     * @param trening the trening to set
     */
    public void setTrening(Trening trening) {
        this.trening = trening;
    }

    /**
     * @return the vezbeZaTermin
     */
    public ArrayList<VezbaZaTermin> getVezbeZaTermin() {
        return vezbeZaTermin;
    }

    /**
     * @param vezbeZaTermin the vezbeZaTermin to set
     */
    public void setVezbeZaTermin(ArrayList<VezbaZaTermin> vezbeZaTermin) {
        this.vezbeZaTermin = vezbeZaTermin;
    }

    @Override
    public String nazivTabele() {
        return " zakazantermin ";
    }

    @Override
    public String alijas() {
        return " zt ";
    }

    @Override
    public String join() {
        return "JOIN pomocnitrener pt ON (pt.pomocnitrenerid = zt.pomocnitrenerid) "
                + "JOIN korisnik k ON (k.korisnikid = zt.korisnikid) "
                + "JOIN trening tk ON (tk.treningid = zt.treningid) "
                + "JOIN vrstatreninga vt ON (vt.vrstatreningaid = tk.vrstatreningaid) "
                + "JOIN tipkorisnika tipk ON (tipk.tipkorisnikaid = k.tipkorisnikaid) "
                + "JOIN vezbezatermin vzt ON (vzt.zakazanterminid = zt.zakazanterminid) "
                + "GROUP BY zt.zakazanterminid";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            PomocniTrener pt = new PomocniTrener(rs.getLong("PomocniTrenerID"),
                    rs.getString("Ime"), rs.getString("Prezime"),
                    rs.getString("KorisnickoIme"), rs.getString("Lozinka"));

            VrstaTreninga vt = new VrstaTreninga(rs.getLong("VrstaTreningaID"),
                    rs.getString("NazivVrsteTreninga"));

            Trening trening = new Trening(rs.getLong("TreningID"),
                    rs.getString("NazivTreninga"), vt);

            TipKorisnika tipKorisnika = new TipKorisnika(rs.getLong("TipKorisnikaID"),
                    rs.getString("NazivTipaKorisnika"), rs.getString("Opis"));

            Korisnik k = new Korisnik(rs.getLong("KorisnikID"), rs.getString("Ime"),
                    rs.getString("Prezime"), rs.getString("BrojTelefona"),
                    rs.getString("Email"), tipKorisnika);

            ZakazanTermin zt = new ZakazanTermin(rs.getLong("ZakazanTerminID"),
                    rs.getTimestamp("DatumVreme"),
                    pt, k, trening, null);

            VezbaZaTermin vzt = new VezbaZaTermin(zt, rs.getInt("RedniBroj"),
                    rs.getString("Vezba"), rs.getInt("BrojPonavljanja"));

            ArrayList<VezbaZaTermin> vezbeZaTermin = new ArrayList<>();
            vezbeZaTermin.add(vzt);
            zt.setVezbeZaTermin(vezbeZaTermin);

            if (lista.contains(zt)) {
                int index = lista.indexOf(zt);
                ZakazanTermin zakTer = (ZakazanTermin) lista.get(index);
                vzt.setZakazanTermin(zakTer);
                zakTer.getVezbeZaTermin().add(vzt);
            } else {
                lista.add(zt);
            }

        }
        rs.close();
        return lista;
    }
    
    @Override
    public String koloneZaInsert() {
        return " (DatumVreme, PomocniTrenerID, KorisnikID, TreningID) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " ZakazanTerminID = " + zakazanTerminID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + new Timestamp(datumVreme.getTime()) + "', " + pomocniTrener.getPomocniTrenerID()+ ", "
                + "" + korisnik.getKorisnikID()+ ", " + trening.getTreningID() + " ";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }
    
    
}
