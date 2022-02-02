package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 * Klasa koja predstavlja jedan zakazan termin.
 * 
 * Zakazan termin ima atribute:
 * zakazanTerminID tipa Long
 * datumVreme tipa Date
 * pomocniTrener tipa PomocniTrener (objekat klase PomocniTrener)
 * korisnik tipa Korisnik (objekat klase Korisnik)
 * trening tipa Trening (objekat klase Trening)
 * vezbeZaTermin tipa ArrayList (čiju listu čine objekti klase VezbaZaTermin)
 */
public class ZakazanTermin extends AbstractDomainObject implements Serializable{
    /**
     * Jedinstvena šifra zakazanog termina, tipa Long.
     */
    private Long zakazanTerminID;
    
    /**
     * Datum i vreme zakazanog termina, tipa Date.
     */
    private Date datumVreme;
    
    /**
     * Objekat klase PomocniTrener.
     */
    private PomocniTrener pomocniTrener;
    
    /**
     * Objekat klase Korisnik.
     */
    private Korisnik korisnik;
    
    /**
     * Objekat klase Trening.
     */
    private Trening trening;
    
    /**
     * Lista vežbi za termin, tipa ArrayList.
     */
    private ArrayList<VezbaZaTermin> vezbeZaTermin;

    /**
     * Konstruktor koji inicijalizuje objekat klase ZakazanTermin.
     */
    public ZakazanTermin() {
    }

    /**
     * Konstruktor koji inicijalizuje objekat i postavlja vrednost svih atributa klase ZakazanTermin.
     * 
     * @param zakazanTerminID Jedinstvena šifra zakazanog termina tipa Long.
     * @param datumVreme Datum i vreme zakazanog termina, tipa Date.
     * @param pomocniTrener Objekat klase PomocniTrener.
     * @param korisnik Objekat klase Korisnik.
     * @param trening Objekat klase Trening.
     * @param vezbeZaTermin Lista objekata vezba za termin klase VezbaZaTermin.
     */
    public ZakazanTermin(Long zakazanTerminID, Date datumVreme, PomocniTrener pomocniTrener, Korisnik korisnik, Trening trening, ArrayList<VezbaZaTermin> vezbeZaTermin) {
        this.zakazanTerminID = zakazanTerminID;
        this.datumVreme = datumVreme;
        this.pomocniTrener = pomocniTrener;
        this.korisnik = korisnik;
        this.trening = trening;
        this.vezbeZaTermin = vezbeZaTermin;
    }

    /**
     * Vraća šifru zakazanog termina.
     * 
     * @return Šifra zakazanog termina, tipa Long.
     */
    public Long getZakazanTerminID() {
        return zakazanTerminID;
    }

    /**
     * Postavlja  šifru zakazanog termina na novu vrednost.
     * 
     * @param zakazanTerminID Šifra zakazanog termina, tipa Long.
     */
    public void setZakazanTerminID(Long zakazanTerminID) {
        this.zakazanTerminID = zakazanTerminID;
    }

    /**
     * Vraća datum i vreme zakazanog termina.
     * 
     * @return Datum i vreme zakazanog termina, tipa Date.
     */
    public Date getDatumVreme() {
        return datumVreme;
    }

    /**
     * Vraća datum i vreme zakazanog termina.
     * 
     * @param datumVreme Datum i vreme zakazanog termina, tipa Date.
     */
    public void setDatumVreme(Date datumVreme) {
        this.datumVreme = datumVreme;
    }

    /**
     * Vraća pomoćnog trenera.
     * 
     * @return Pomoćni trener zakazanog termina, tipa PomocniTrener.
     */
    public PomocniTrener getPomocniTrener() {
        return pomocniTrener;
    }

    /**
     * Postavlja pomoćnog trenera zakazanog termina na novu vrednost.
     * 
     * @param pomocniTrener Objekat klase PomocniTrener.
     */
    public void setPomocniTrener(PomocniTrener pomocniTrener) {
        this.pomocniTrener = pomocniTrener;
    }

    /**
     * Vraća korisnika zakazanog termina.
     * 
     * @return Korisnik zakazanog termina, tipa Korisnik.
     */
    public Korisnik getKorisnik() {
        return korisnik;
    }

    /**
     * Postavlja korisnika zakazanog termina na novu vrednost.
     * 
     * @param korisnik Objekat klase Korisnik.
     */
    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    /**
     * Vraća trening zakazanog termina.
     * 
     * @return Trening zakazanog termina, tipa Trening.
     */
    public Trening getTrening() {
        return trening;
    }

    /**
     * Postavlja trening zakazanog termina na novu vrednost.
     * 
     * @param trening Objekat klase Trening.
     */
    public void setTrening(Trening trening) {
        this.trening = trening;
    }

    /**
     * Vraća listu vežbi zakazanog termina.
     * 
     * @return Vežbe zakazanog termina, tipa ArrayList.
     */
    public ArrayList<VezbaZaTermin> getVezbeZaTermin() {
        return vezbeZaTermin;
    }

    /**
     * Postavlja listu vežbi zakazanog termina na novu vrednost.
     * 
     * @param vezbeZaTermin Lista objekata vežbi za termin klase VezbaZaTermin .
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
