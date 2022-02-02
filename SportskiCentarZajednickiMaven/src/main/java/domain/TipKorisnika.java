package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Klasa koja predstavlja tip korisnika.
 * 
 * Tip korisnika ima atribute:
 * tipKorisnikaID tipa Long
 * nazivTipaKorisnika tipa String
 * opis tipa String
 */
public class TipKorisnika extends AbstractDomainObject implements Serializable{
    /**
     * Jedinstvena šifra tipa korisnika tipa Long.
     */
    private Long tipKorisnikaID;
    
    /**
     * Naziv tipa korisnika tipa String.
     */
    private String nazivTipaKorisnika;
    
    /**
     * Opis tipa korisnika tipa String.
     */
    private String opis;

    /**
     * Konstruktor koji inicijalizuje objekat klase TipKorisnika.
     */
    public TipKorisnika() {
    }
    
    /**
     * Konstruktor koji inicijalizuje objekat i postavlja vrednost svih atributa
     * tipa korisnika
     * .
     * @param tipKorisnikaID Jedinstvena šifra tipa korisnika tipa Long.
     * @param nazivTipaKorisnika Naziv tipa korisnika tipa String.
     * @param opis Opis tipa korisnika tipa String.
     */
    public TipKorisnika(Long tipKorisnikaID, String nazivTipaKorisnika, String opis) {
        this.tipKorisnikaID = tipKorisnikaID;
        this.nazivTipaKorisnika = nazivTipaKorisnika;
        this.opis = opis;
    }

    /**
     * Vraća šifru tipa korisnika.
     * 
     * @return Šifra tipa korisnika tipa Long.
     */
    public Long getTipKorisnikaID() {
        return tipKorisnikaID;
    }

    /**
     * Postavlja šifru tipa korisnika na novu vrednost.
     * 
     * @param tipKorisnikaID Šifra tipa korisnika tipa Long.
     */
    public void setTipKorisnikaID(Long tipKorisnikaID) {
        this.tipKorisnikaID = tipKorisnikaID;
    }

    /**
     * Vraća naziv tipa korisnika.
     * 
     * @return Naziv tipa korisnika tipa String.
     */
    public String getNazivTipaKorisnika() {
        return nazivTipaKorisnika;
    }

    /**
     * Postavlja naziv tipa klijenta na novu vrednost.
     * 
     * @param nazivTipaKorisnika Naziv tipa korisnika tipa String.
     */
    public void setNazivTipaKorisnika(String nazivTipaKorisnika) {
        this.nazivTipaKorisnika = nazivTipaKorisnika;
    }

    /**
     * Vraća opis tipa korisnika.
     * 
     * @return Opis tipa korisnika tipa String.
     */
    public String getOpis() {
        return opis;
    }

    /**
     * Postavlja opis tipa korisnika na novu vrednost.
     * 
     * @param opis Opis tipa korisnika tipa String.
     */
    public void setOpis(String opis) {
        this.opis = opis;
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
        final TipKorisnika other = (TipKorisnika) obj;
        if (!Objects.equals(this.nazivTipaKorisnika, other.nazivTipaKorisnika)) {
            return false;
        }
        if (!Objects.equals(this.opis, other.opis)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nazivTipaKorisnika;
    }
    
    @Override
    public String nazivTabele() {
        return " tipkorisnika ";
    }

    @Override
    public String alijas() {
        return " tk ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        
        while(rs.next()){
            TipKorisnika tk = new TipKorisnika(rs.getLong("TipKorisnikaID"), 
                    rs.getString("NazivTipaKorisnika"), rs.getString("Opis"));
            
            lista.add(tk);
        }
        
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " TipKorisnikaID = " + tipKorisnikaID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }
    
    
}
