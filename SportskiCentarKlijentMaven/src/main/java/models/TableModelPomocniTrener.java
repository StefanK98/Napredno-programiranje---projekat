/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.ClientController;
import domain.PomocniTrener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Kujovic
 */
public class TableModelPomocniTrener extends AbstractTableModel implements Runnable{

    private List<PomocniTrener> listaPomocnihTrenera;
    private String[] kolone = {"ID", "Ime", "Prezime", "Username"};
    private String parametar = "";

    public TableModelPomocniTrener() {
        try{
            listaPomocnihTrenera = ClientController.getInstance().getAllPomocniTrener();
        }catch(Exception ex){
            Logger.getLogger(TableModelPomocniTrener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    @Override
    public int getRowCount() {
        return listaPomocnihTrenera.size();
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
        PomocniTrener pt = listaPomocnihTrenera.get(i);
        
        switch(i1){
            case 0: return pt.getPomocniTrenerID();
            case 1: return pt.getIme();
            case 2: return pt.getPrezime();
            case 3: return pt.getKorisnickoIme();
            
            default: return null;
        }
    }
    public PomocniTrener getSelectedPomocniTrener(int i){
        return listaPomocnihTrenera.get(i);
    }
    @Override
    public void run() {
        try {
            while(!Thread.currentThread().isInterrupted()){
                    Thread.sleep(5000);
                    osveziTabelu();
            }
        } catch (InterruptedException ex) {
                Logger.getLogger(TableModelPomocniTrener.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public void setParametar(String parametar) {
        this.parametar = parametar;
        osveziTabelu();
    }
    
    private void osveziTabelu() {
        try{
            listaPomocnihTrenera = ClientController.getInstance().getAllPomocniTrener();
            if(!parametar.equals("")){
                List<PomocniTrener> novaLista=new ArrayList<>();
                for(PomocniTrener pt : listaPomocnihTrenera)
                    if(pt.getIme().toLowerCase().contains(parametar.toLowerCase())
                            || pt.getPrezime().toLowerCase().contains(parametar.toLowerCase())
                            || pt.getKorisnickoIme().toLowerCase().contains(parametar.toLowerCase()))
                        novaLista.add(pt);
                listaPomocnihTrenera=novaLista;
            }else{
                
            }
            fireTableDataChanged();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public void refreshTable() {
        try {
            listaPomocnihTrenera = ClientController.getInstance().getAllPomocniTrener();
        } catch (Exception ex) {
            Logger.getLogger(TableModelPomocniTrener.class.getName()).log(Level.SEVERE, null, ex);
        }
        fireTableDataChanged();
    }
    
}
