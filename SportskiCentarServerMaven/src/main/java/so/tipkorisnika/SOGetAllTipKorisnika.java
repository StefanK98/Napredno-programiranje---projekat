/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.tipkorisnika;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.TipKorisnika;
import java.sql.SQLException;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Kujovic
 */
public class SOGetAllTipKorisnika extends AbstractSO {
    private ArrayList<TipKorisnika> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof TipKorisnika)) {
            throw new Exception("Prosledjeni objekat nije instanca klase TipKorisnika!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        ArrayList<AbstractDomainObject> listaTipova = 
                      (ArrayList<AbstractDomainObject>) DBBroker.getInstance().select(ado);
        lista = (ArrayList<TipKorisnika>) (ArrayList<?>)  listaTipova;
    }
    
    public ArrayList<TipKorisnika> getLista() {
        return lista;
    }
}
