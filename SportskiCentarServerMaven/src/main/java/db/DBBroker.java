/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domain.AbstractDomainObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Kujovic
 */
public class DBBroker {
    private static DBBroker instance;
    private Connection connection;

    public DBBroker() {
        try {
            connection=
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/sportskicentar", "root", "");
            connection.setAutoCommit(false);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public Connection getConnection() {
        return connection;
    }

    public static DBBroker getInstance() {
        if(instance==null)
            instance=new DBBroker();
        return instance;
    }
    
    public List<AbstractDomainObject> select(AbstractDomainObject ado) throws SQLException {
        String upit = "SELECT * FROM " + ado.nazivTabele() + " " + ado.alijas() + " " + ado.join() + " ";
        System.out.println(upit);
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery(upit);
        return ado.vratiListu(rs);
    }

    public PreparedStatement insert(AbstractDomainObject ado) throws SQLException {
        String upit = "INSERT INTO " + ado.nazivTabele() + " " + ado.koloneZaInsert() + " VALUES(" + ado.vrednostiZaInsert() + ")";
        System.out.println(upit);
        PreparedStatement ps = connection.prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);
        ps.executeUpdate();
        return ps;
    }

    public void update(AbstractDomainObject ado) throws SQLException {
        String upit = "UPDATE " + ado.nazivTabele() + " SET " + ado.vrednostiZaUpdate() + " WHERE " + ado.vrednostZaPrimarniKljuc();
        System.out.println(upit);
        Statement s = connection.createStatement();
        s.executeUpdate(upit);
    }

    public void delete(AbstractDomainObject ado) throws SQLException {
        String upit = "DELETE FROM " + ado.nazivTabele() + " WHERE " + ado.vrednostZaPrimarniKljuc();
        System.out.println(upit);
        Statement s = connection.createStatement();
        s.executeUpdate(upit);
    }
}
