/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.pomocnitrener;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.PomocniTrener;
import java.sql.SQLException;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Kujovic
 */
public class SOGetAllPomocniTrener extends AbstractSO{

    private ArrayList<PomocniTrener> lista;
    
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof PomocniTrener)) {
            throw new Exception("Prosledjeni objekat nije instanca klase PomocniTrener!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        ArrayList<AbstractDomainObject> listaPomocnihTrenera = 
                      (ArrayList<AbstractDomainObject>) DBBroker.getInstance().select(ado);
        lista= (ArrayList<PomocniTrener>) (ArrayList<?>) listaPomocnihTrenera;
    }
    
    public ArrayList<PomocniTrener> getLista() {
        return lista;
    }
}
