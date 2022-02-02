package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Klasa koja predstavlja jednog korisnika.
 * 
 * Korisnik ima atribute:
 * korisnikID tipa Long
 * ime tipa String
 * prezime tipa String
 * brojTelefona tipa String
 * email tipa String
 * tipKorisnika objekat klase TipKorisnika
 */
public class Korisnik extends AbstractDomainObject implements Serializable{
    /**
     * Jedinstvena šifra korisnika tipa Long.
     */
    private Long korisnikID;
    
    /**
     * Ime korisnika tipa String.
     */
    private String ime;
    
    /**
     * Prezime korisnika tipa String.
     */
    private String prezime;
    
    /**
     * Broj telefona korisnika tipa String.
     */
    private String brojTelefona;
    
    /**
     * Email korisnika tipa String.
     */
    private String email;
    
    /**
     * Tip korisnika kao objekat klase TipKorisnika.
     */
    private TipKorisnika tipKorisnika;

    /**
     * Konstruktor koji inicijalizuje objekat klase Korisnik.
     */
    public Korisnik() {
    }

    /**
     * Konstruktor koji inicijalizuje objekat i postavlja vrednost svih atributa klase Korisnik.
     * 
     * @param korisnikID Jedinstvena šifra korisnika tipa Long.
     * @param ime Ime korisnika tipa String.
     * @param prezime Prezime korisnika tipa String.
     * @param brojTelefona Broj telefona korisnika tipa String.
     * @param email Email korisnika tipa String.
     * @param tipKorisnika Tip korisnika kao objekat klase TipKorisnika.
     */
    public Korisnik(Long korisnikID, String ime, String prezime, String brojTelefona, String email, TipKorisnika tipKorisnika) {
        this.korisnikID = korisnikID;
        this.ime = ime;
        this.prezime = prezime;
        this.brojTelefona = brojTelefona;
        this.email = email;
        this.tipKorisnika = tipKorisnika;
    }

    /**
     * Vraća šifru korisnika.
     * 
     * @return Šifra korisnika tipa Long.
     */
    public Long getKorisnikID() {
        return korisnikID;
    }

    /**
     * Postavlja šifru korisnika na novu vrednost.
     * 
     * @param korisnikID Šifra korisnika tipa Long.
     */
    public void setKorisnikID(Long korisnikID) {
        this.korisnikID = korisnikID;
    }

    /**
     * Vraća ime korisnika.
     * 
     * @return Ime korisnika tipa String.
     */
    public String getIme() {
        return ime;
    }

    /**
     * Postavlja ime korisnika na novu vrednost.
     * 
     * @param ime Ime korisnika tipa String.
     */
    public void setIme(String ime) {
        this.ime = ime;
    }

    /**
     * Vraća prezime korisnika.
     * 
     * @return Prezime korisnika tipa String.
     */
    public String getPrezime() {
        return prezime;
    }

    /**
     * Vraća prezime korisnika.
     * 
     * @param prezime Prezime korisnika tipa String.
     */
    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    /**
     * Vraća broj telefona korisnika.
     * 
     * @return Broj telefona korisnika tipa String.
     */
    public String getBrojTelefona() {
        return brojTelefona;
    }

    /**
     * Postavlja broj telefona korisnika na novu vrednost.
     * 
     * @param brojTelefona Broj telefona korisnika tipa String.
     */
    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    /**
     * Vraća email korisnika.
     * 
     * @return Email korisnika tipa String.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Postavlja email korisnika na novu vrednost.
     * 
     * @param email Email korisnika tipa String.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Vraća tip korisnika.
     * 
     * @return Tip korisnika kao objekat klase TipKorisnika.
     */
    public TipKorisnika getTipKorisnika() {
        return tipKorisnika;
    }

    /**
     * Postavlja tip korisnika na novu vrednost.
     * 
     * @param tipKorisnika Tip korisnika kao objekat klase TipKorisnika.
     */
    public void setTipKorisnika(TipKorisnika tipKorisnika) {
        this.tipKorisnika = tipKorisnika;
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
        final Korisnik other = (Korisnik) obj;
        if (!Objects.equals(this.ime, other.ime)) {
            return false;
        }
        if (!Objects.equals(this.prezime, other.prezime)) {
            return false;
        }
        if (!Objects.equals(this.brojTelefona, other.brojTelefona)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.tipKorisnika, other.tipKorisnika)) {
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
        return " korisnik ";
    }

    @Override
    public String alijas() {
        return " k ";
    }

    @Override
    public String join() {
        return " join tipkorisnika tk on (k.tipkorisnikaid = tk.tipkorisnikaid) ";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        
        while(rs.next()){
            
            TipKorisnika tk = new TipKorisnika(rs.getLong("TipKorisnikaID"),
                    rs.getString("NazivTipaKorisnika"), rs.getString("Opis"));
            
            Korisnik k = new Korisnik(rs.getLong("KorisnikID"), rs.getString("Ime"), 
                    rs.getString("Prezime"), rs.getString("BrojTelefona"),
                    rs.getString("Email"), tk);
            
            lista.add(k);
        }
        
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (Ime, Prezime, BrojTelefona, Email, TipKorisnikaID) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " KorisnikID = " + korisnikID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + ime + "', '" + prezime + "', "
                + "'" + brojTelefona + "', '" + email + "', " + tipKorisnika.getTipKorisnikaID();
    }

    @Override
    public String vrednostiZaUpdate() {
        return " BrojTelefona = '" + brojTelefona + "', Email = '" + email + "', "
                + "TipKorisnikaID = " + tipKorisnika.getTipKorisnikaID();
    }
}
