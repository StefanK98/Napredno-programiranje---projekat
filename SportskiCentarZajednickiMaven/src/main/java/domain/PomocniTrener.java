package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Klasa koja predstavlja jednog pomoćnog trenera.
 *
 * Pomoćni trener ima atribute: pomocniTrenerID tipa Long ime tipa String
 * prezime tipa String korisnickoIme tipa String lozinka tipa String
 *
 */
public class PomocniTrener extends AbstractDomainObject implements Serializable {

    /**
     * Jedinstvena šifra pomoćnog trenera tipa Long.
     */
    private Long pomocniTrenerID;

    /**
     * Ime pomoćnog trenera tipa String.
     */
    private String ime;

    /**
     * Prezime pomoćnog trenera tipa String.
     */
    private String prezime;

    /**
     * Korisničko ime pomoćnog trenera tipa String.
     */
    private String korisnickoIme;

    /**
     * Lozinka pomoćnog trenera tipa String.
     */
    private String lozinka;

    /**
     * Konstruktor koji inicijalizuje objekat klase PomoćniTrener.
     */
    public PomocniTrener() {
    }

    /**
     * Konstruktor koji inicijalizuje objekat i postavlja vrednost svih atributa
     * klase PomoćniTrener.
     *
     * @param pomocniTrenerID Jedinstvena šifra pomoćnog trenera tipa Long.
     * @param ime Ime pomoćnog trenera tipa String.
     * @param prezime Prezime pomoćnog trenera tipa String.
     * @param korisnickoIme Korisničko ime pomoćnog trenera tipa String.
     * @param lozinka Lozinka pomoćnog trenera tipa String.
     */
    public PomocniTrener(Long pomocniTrenerID, String ime, String prezime, String korisnickoIme, String lozinka) {
        this.pomocniTrenerID = pomocniTrenerID;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }

    /**
     * Vraća šifru pomoćnog trenera.
     *
     * @return Šifra pomoćnog trenera tipa Long.
     */
    public Long getPomocniTrenerID() {
        return pomocniTrenerID;
    }

    /**
     * Postavlja šifru pomoćnog trenera na novu vrednost.
     *
     * @param pomocniTrenerID Šifra pomoćnog trenera tipa Long.
     */
    public void setPomocniTrenerID(Long pomocniTrenerID) {
        this.pomocniTrenerID = pomocniTrenerID;
    }

    /**
     * Vraća ime pomoćnog trenera.
     *
     * @return Ime pomoćnog trenera tipa String.
     */
    public String getIme() {
        return ime;
    }

    /**
     * Postavlja ime pomoćnog trenera na novu vrednost.
     *
     * @param ime Ime pomoćnog trenera tipa String.
     */
    public void setIme(String ime) {
        this.ime = ime;
    }

    /**
     * Vraća prezime pomoćnog trenera.
     *
     * @return Prezime pomoćnog trenera tipa String.
     */
    public String getPrezime() {
        return prezime;
    }

    /**
     * Postavlja prezime pomoćnog trenera na novu vrednost.
     *
     * @param prezime Prezime pomoćnog trenera tipa String.
     */
    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    /**
     * Vraća korisničko ime pomoćnog trenera.
     *
     * @return Korisničko ime pomoćnog trenera tipa String.
     */
    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    /**
     * Postavlja korisničko ime pomoćnog trenera na novu vrednost.
     *
     * @param korisnickoIme Prezime pomoćnog trenera tipa String.
     */
    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    /**
     * Vraća lozinku pomoćnog trenera.
     *
     * @return Lozinka pomoćnog trenera tipa String.
     */
    public String getLozinka() {
        return lozinka;
    }

    /**
     * Postavlja lozinku pomoćnog trenera na novu vrednost.
     *
     * @param lozinka Lozinka pomoćnog trenera tipa String.
     */
    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PomocniTrener other = (PomocniTrener) obj;
        if (!Objects.equals(this.pomocniTrenerID, other.pomocniTrenerID)) {
            return false;
        }
        if (!Objects.equals(this.ime, other.ime)) {
            return false;
        }
        if (!Objects.equals(this.prezime, other.prezime)) {
            return false;
        }
        if (!Objects.equals(this.korisnickoIme, other.korisnickoIme)) {
            return false;
        }
        if (!Objects.equals(this.lozinka, other.lozinka)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public String nazivTabele() {
        return " pomocnitrener ";
    }

    @Override
    public String alijas() {
        return " pt ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            PomocniTrener pt = new PomocniTrener(rs.getLong("PomocniTrenerID"),
                    rs.getString("Ime"), rs.getString("Prezime"),
                    rs.getString("KorisnickoIme"), rs.getString("Lozinka"));

            lista.add(pt);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (Ime, Prezime, KorisnickoIme, Lozinka) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " PomocniTrenerID = " + pomocniTrenerID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + ime + "', '" + prezime + "', "
                + "'" + korisnickoIme + "', '" + lozinka + "'";
    }

    @Override
    public String vrednostiZaUpdate() {
        return " Ime = '" + ime + "', Prezime = '" + prezime + "', "
                + "KorisnickoIme = '" + korisnickoIme + "', Lozinka = '" + lozinka + "' ";
    }

}
