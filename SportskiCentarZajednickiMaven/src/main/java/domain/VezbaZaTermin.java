/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Kujovic
 */
public class VezbaZaTermin extends AbstractDomainObject implements Serializable{
    
    private ZakazanTermin zakazanTermin;
    private int redniBroj;
    private String vezba;
    private int brojPonavljanja;

    public VezbaZaTermin() {
    }

    public VezbaZaTermin(ZakazanTermin zakazanTermin, int redniBroj, String vezba, int brojPonavljanja) {
        this.zakazanTermin = zakazanTermin;
        this.redniBroj = redniBroj;
        this.vezba = vezba;
        this.brojPonavljanja = brojPonavljanja;
    }

    /**
     * @return the zakazanTermin
     */
    public ZakazanTermin getZakazanTermin() {
        return zakazanTermin;
    }

    /**
     * @param zakazanTermin the zakazanTermin to set
     */
    public void setZakazanTermin(ZakazanTermin zakazanTermin) {
        this.zakazanTermin = zakazanTermin;
    }

    /**
     * @return the redniBroj
     */
    public int getRedniBroj() {
        return redniBroj;
    }

    /**
     * @param redniBroj the redniBroj to set
     */
    public void setRedniBroj(int redniBroj) {
        this.redniBroj = redniBroj;
    }

    /**
     * @return the vezba
     */
    public String getVezba() {
        return vezba;
    }

    /**
     * @param vezba the vezba to set
     */
    public void setVezba(String vezba) {
        this.vezba = vezba;
    }

    /**
     * @return the brojPonavljanja
     */
    public int getBrojPonavljanja() {
        return brojPonavljanja;
    }

    /**
     * @param brojPonavljanja the brojPonavljanja to set
     */
    public void setBrojPonavljanja(int brojPonavljanja) {
        this.brojPonavljanja = brojPonavljanja;
    }

    @Override
    public String nazivTabele() {
        return " vezbezatermin ";
    }

    @Override
    public String alijas() {
        return " vzt ";
    }

    @Override
    public String join() {
        return " JOIN zakazantermin zt ON (zt.zakazanterminid = vzt.zakazanterminid) "
                + "JOIN pomocnitrener pt ON (zt.pomocnitrenerid = pt.pomocnitrenerid) "
                + "JOIN korisnik k ON (zt.korisnikid = k.korisnikid) "
                + "JOIN trening t ON (zt.treningid = t.treningid) "
                + "JOIN vrstatreninga vt ON (t.vrstatreningaid = vt.vrstatreningaid) "
                + "JOIN tipkorisnika tk ON (tk.tipkorisnikaid = k.tipkorisnikaid) ";
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

            lista.add(vzt);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (ZakazanTerminID, RedniBroj, Vezba, BrojPonavljanja) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " ZakazanTerminID = " + zakazanTermin.getZakazanTerminID() + " AND "
                + "RedniBroj = " + redniBroj;
    }

    @Override
    public String vrednostiZaInsert() {
        return " " + zakazanTermin.getZakazanTerminID() + ", " + redniBroj + ", "
                + "'" + vezba + "', " + brojPonavljanja + " ";
        
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }
    
    
    
}
