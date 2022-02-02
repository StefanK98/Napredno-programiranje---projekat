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
public class PomocniTrener extends AbstractDomainObject implements Serializable{
    
    private Long pomocniTrenerID;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String lozinka;

    public PomocniTrener() {
    }

    public PomocniTrener(Long pomocniTrenerID, String ime, String prezime, String korisnickoIme, String lozinka) {
        this.pomocniTrenerID = pomocniTrenerID;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }
    /**
     * @return the pomocniTrenerID
     */
    public Long getPomocniTrenerID() {
        return pomocniTrenerID;
    }

    /**
     * @param pomocniTrenerID the pomocniTrenerID to set
     */
    public void setPomocniTrenerID(Long pomocniTrenerID) {
        this.pomocniTrenerID = pomocniTrenerID;
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
     * @return the korisnickoIme
     */
    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    /**
     * @param korisnickoIme the korisnickoIme to set
     */
    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    /**
     * @return the lozinka
     */
    public String getLozinka() {
        return lozinka;
    }

    /**
     * @param lozinka the lozinka to set
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
        
        while(rs.next()){
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
