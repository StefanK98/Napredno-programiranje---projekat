/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.ClientController;
import domain.Korisnik;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Kujovic
 */
public class TableModelKorisnik extends AbstractTableModel implements Runnable{

    private List<Korisnik> listaKorisnika;
    private String[] kolone = {"ID", "Ime", "Prezime", "BrojTelefona", "Email", "Tip korisnika"};
    private String parametar = "";
    
    public TableModelKorisnik() {
        try {
            listaKorisnika = ClientController.getInstance().getAllKorisnik();
        } catch (Exception ex) {
            Logger.getLogger(TableModelKorisnik.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public int getRowCount() {
        return listaKorisnika.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int i) {
        return kolone[i];
    }
    
    @Override
    public Object getValueAt(int i, int i1) {
        Korisnik k = listaKorisnika.get(i);
        
        switch(i1){
            case 0: return k.getKorisnikID();
            case 1: return k.getIme();
            case 2: return k.getPrezime();
            case 3: return k.getBrojTelefona();
            case 4: return k.getEmail();
            case 5: return k.getTipKorisnika().getNazivTipaKorisnika();
            
            default: return null;
        }
    }
    
    public Korisnik getSelectedKorisnik(int i){
        return listaKorisnika.get(i);
    }

    @Override
    public void run() {
        try {
            while(!Thread.currentThread().isInterrupted()){
                    Thread.sleep(5000);
                    osveziTabelu();
            }
        } catch (InterruptedException ex) {
                Logger.getLogger(TableModelKorisnik.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        osveziTabelu();
    }

    private void osveziTabelu() {
        try{
            listaKorisnika = ClientController.getInstance().getAllKorisnik();
            if(!parametar.equals("")){
                List<Korisnik> novaLista=new ArrayList<>();
                for(Korisnik k: listaKorisnika)
                    if(k.getIme().toLowerCase().contains(parametar.toLowerCase())
                            || k.getPrezime().toLowerCase().contains(parametar.toLowerCase()))
                        novaLista.add(k);
                listaKorisnika=novaLista;
            }else{
                
            }
            fireTableDataChanged();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void refreshTable() {
        try {
            listaKorisnika = ClientController.getInstance().getAllKorisnik();
        } catch (Exception ex) {
            Logger.getLogger(TableModelKorisnik.class.getName()).log(Level.SEVERE, null, ex);
        }
        fireTableDataChanged();
    }
    
}