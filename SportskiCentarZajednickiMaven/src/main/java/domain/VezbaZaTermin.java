package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Klasa koja predstavlja vezbe za termin.
 * 
 * VezbaZaTermin ima atribute:
 * zakazanTermin tipa ZakazanTermin (objekat klase ZakazanTermin)
 * redniBroj tipa int
 * vezba tipa String
 * broj ponavljanja tipa int
 */
public class VezbaZaTermin extends AbstractDomainObject implements Serializable{
    /**
     * Zakazan Termin tipa ZakazanTermin.
     */
    private ZakazanTermin zakazanTermin;
    
    /**
     * Redni broj vežbe tipa int.
     */
    private int redniBroj;
    
    /**
     * Vežba tipa String.
     */
    private String vezba;
    
    /**
     * Broj ponavljanja vežbe tipa int.
     */
    private int brojPonavljanja;

    /**
     * Konstruktor koji inicijalizuje objekat klase VezbaZaTermin.
     */
    public VezbaZaTermin() {
    }

    /**
     * Konstruktor koji inicijalizuje objekat i postavlja vrednost svih atributa klase VezbaZaTermin.
     * 
     * @param zakazanTermin Zakazan termin tipa ZakazanTermin.
     * @param redniBroj Redni broj vežbe tipa int.
     * @param vezba Vežba tipa int.
     * @param brojPonavljanja Broj ponavljanja vežbe tipa int.
     */
    public VezbaZaTermin(ZakazanTermin zakazanTermin, int redniBroj, String vezba, int brojPonavljanja) {
        this.zakazanTermin = zakazanTermin;
        this.redniBroj = redniBroj;
        this.vezba = vezba;
        this.brojPonavljanja = brojPonavljanja;
    }

    /**
     * Vraća objekat klase ZakazanTermin.
     * 
     * @return Objekat klase ZakazanTermin.
     */
    public ZakazanTermin getZakazanTermin() {
        return zakazanTermin;
    }

    /**
     * Postavlja zakazan termin na novu vrednost.
     * 
     * @param zakazanTermin Objekat klase ZakazanTermin.
     */
    public void setZakazanTermin(ZakazanTermin zakazanTermin) {
        this.zakazanTermin = zakazanTermin;
    }

    /**
     * Vraća redni broj vežbe.
     * 
     * @return Redni broj vežbe tipa int.
     */
    public int getRedniBroj() {
        return redniBroj;
    }

    /**
     * Postavlja redni broj na novu vrednost.
     * 
     * @param redniBroj Redni broj vežbe tipa int.
     */
    public void setRedniBroj(int redniBroj) {
        this.redniBroj = redniBroj;
    }

    /**
     * Vraća vežbu.
     * 
     * @return Vežba tipa String.
     */
    public String getVezba() {
        return vezba;
    }

    /**
     * Postavlja vežbu na novu vrednost.
     * 
     * @param vezba Vežba tipa String.
     */
    public void setVezba(String vezba) {
        this.vezba = vezba;
    }

    /**
     * Vraća broj ponavljanja vežbe.
     * 
     * @return Broj ponavljanja vežbe tipa int.
     */
    public int getBrojPonavljanja() {
        return brojPonavljanja;
    }

    /**
     * Postavlja broj ponavljanja vežbe na novu vrednost.
     * 
     * @param brojPonavljanja Broj ponavljanja vežbe tipa int.
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
