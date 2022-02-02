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
public class TipKorisnika extends AbstractDomainObject implements Serializable{
    
    private Long tipKorisnikaID;
    private String nazivTipaKorisnika;
    private String opis;

    public TipKorisnika() {
    }

    public TipKorisnika(Long tipKorisnikaID, String nazivTipaKorisnika, String opis) {
        this.tipKorisnikaID = tipKorisnikaID;
        this.nazivTipaKorisnika = nazivTipaKorisnika;
        this.opis = opis;
    }

    /**
     * @return the tipKorisnikaID
     */
    public Long getTipKorisnikaID() {
        return tipKorisnikaID;
    }

    /**
     * @param tipKorisnikaID the tipKorisnikaID to set
     */
    public void setTipKorisnikaID(Long tipKorisnikaID) {
        this.tipKorisnikaID = tipKorisnikaID;
    }

    /**
     * @return the nazivTipaKorisnika
     */
    public String getNazivTipaKorisnika() {
        return nazivTipaKorisnika;
    }

    /**
     * @param nazivTipaKorisnika the nazivTipaKorisnika to set
     */
    public void setNazivTipaKorisnika(String nazivTipaKorisnika) {
        this.nazivTipaKorisnika = nazivTipaKorisnika;
    }

    /**
     * @return the opis
     */
    public String getOpis() {
        return opis;
    }

    /**
     * @param opis the opis to set
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
