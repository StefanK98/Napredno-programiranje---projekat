package domain;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Interfejs koji definiše osnovne operacije koje se vrše nad svim domenskim
 * objektima u projektu Sportski centar.
 * 
 * Nasleđuje interfejs Serializable.
 * 
 */
public abstract class AbstractDomainObject implements Serializable{
    /**
     * Metoda koja vraća naziv tabele u bazi.
     * 
     * @return Naziv tabele u bazi kao String. 
     */
    public abstract String nazivTabele();
    
    /**
     * Metoda koja vraća alijas tabele u bazi koji koristimo pri pisanju upita.
     * 
     * @return Alijas tabele u bazi kao String.
     */
    public abstract String alijas();
    
    /**
     * Metoda koja vraća kriterijum po kome se vrši join u SQL upitima.
     * 
     * @return Vraća kriterijum po kome se vrši join u SQL upitima, kao String.
	 *     Vraća null ili prazan string ako se nad tom tabelom ne vrši nikakvo 
         *     spajanje sa drugom tabelom.
     */
    public abstract String join();
    
    /**
     * Metoda koja vraća listu objekata tipa AbstractDomainObject 
     * 
     * @param rs Tabela koja je tipa ResultSet.
     * @return Vraća listu objekata tipa AbstractDomainObject. 
     * @throws SQLException Greška pri izvlačenju kolona iz baze.
     */
    public abstract ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException;
    
    /**
     * Metoda koja vraća nazive kolona nad kojima vršimo insert upit.
     * 
     * @return Vraća kolone naše tabele nad kojom vršimo INSERT, tipa String.
     */
    public abstract String koloneZaInsert();
    
    /**
     * Metoda koja vraća vrednosti primarnog ključa odabrane tabele.
     * 
     * @return Vrednost primarnog ključa tipa Long.
     */
    public abstract String vrednostZaPrimarniKljuc();
    
    /**
     * Metoda koja vraća sve vrednosti atributa objekta koje mogu da se menjaju operacijom
       ubacivanja (INSERT).
     * 
     * @return Vraća sve vrednosti atributa objekta koje mogu da se menjaju
   	 *     operacijom ubacivanja(INSERT), tipa String.
     */
    public abstract String vrednostiZaInsert();
    
    /**
     * Metoda koja vraća sve vrednosti atributa objekta koje mogu da se menjaju operacijom
     * ažuriranja(UPDATE).
     * 
     * @return Vraća sve vrednosti atributa objekta koje mogu da se menjaju
	 *     operacijom ažuriranja(UPDATE), tipa String.
     */
    public abstract String vrednostiZaUpdate();
    
    
}
