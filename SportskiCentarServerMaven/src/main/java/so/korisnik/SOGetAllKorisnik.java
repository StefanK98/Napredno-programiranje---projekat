/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.korisnik;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Korisnik;
import java.sql.SQLException;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Kujovic
 */
public class SOGetAllKorisnik extends AbstractSO {
    private ArrayList<Korisnik> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Korisnik)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Korisnik!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        ArrayList<AbstractDomainObject> listaKorisnika = 
                      (ArrayList<AbstractDomainObject>) DBBroker.getInstance().select(ado);
        lista = (ArrayList<Korisnik>) (ArrayList<?>) listaKorisnika;
    }
    
    public ArrayList<Korisnik> getLista() {
        return lista;
    }
}
