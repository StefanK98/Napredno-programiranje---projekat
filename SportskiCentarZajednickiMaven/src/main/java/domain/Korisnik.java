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
import java.util.Objects;

/**
 *
 * @author Kujovic
 */
public class Korisnik extends AbstractDomainObject implements Serializable{
    
    private Long korisnikID;
    private String ime;
    private String prezime;
    private String brojTelefona;
    private String email;
    private TipKorisnika tipKorisnika;

    public Korisnik() {
    }

    public Korisnik(Long korisnikID, String ime, String prezime, String brojTelefona, String email, TipKorisnika tipKorisnika) {
        this.korisnikID = korisnikID;
        this.ime = ime;
        this.prezime = prezime;
        this.brojTelefona = brojTelefona;
        this.email = email;
        this.tipKorisnika = tipKorisnika;
    }

    /**
     * @return the korisnikID
     */
    public Long getKorisnikID() {
        return korisnikID;
    }

    /**
     * @param korisnikID the korisnikID to set
     */
    public void setKorisnikID(Long korisnikID) {
        this.korisnikID = korisnikID;
    }

    /**
     * @return the ime
     */
    public String getIme() {
        return ime;
    }

    /**
     * @param ime the ime to set
     */
    public void setIme(String ime) {
        this.ime = ime;
    }

    /**
     * @return the prezime
     */
    public String getPrezime() {
        return prezime;
    }

    /**
     * @param prezime the prezime to set
     */
    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    /**
     * @return the brojTelefona
     */
    public String getBrojTelefona() {
        return brojTelefona;
    }

    /**
     * @param brojTelefona the brojTelefona to set
     */
    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the tipKorisnika
     */
    public TipKorisnika getTipKorisnika() {
        return tipKorisnika;
    }

    /**
     * @param tipKorisnika the tipKorisnika to set
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
