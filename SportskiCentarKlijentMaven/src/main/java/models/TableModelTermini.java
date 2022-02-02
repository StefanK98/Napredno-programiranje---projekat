/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.ClientController;
import domain.ZakazanTermin;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Kujovic
 */
public class TableModelTermini extends AbstractTableModel implements Runnable{

    private List<ZakazanTermin> listaTermina;
    private String[] kolone = {"ID", "Datum i vreme", "Trening"};
    private String parametar = "";
    
    public TableModelTermini() {
        try {
            listaTermina = ClientController.getInstance().getAllZakazanTermin();
        } catch (Exception ex) {
            Logger.getLogger(TableModelTermini.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public int getRowCount() {
        return listaTermina.size();
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
        ZakazanTermin zt = listaTermina.get(i);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm");
        switch(i1){
            case 0: return zt.getZakazanTerminID();
            case 1: return sdf.format(zt.getDatumVreme());
            case 2: return zt.getTrening();
            
            default: return null;
        }
    }
    
    public ZakazanTermin getSelectedZakazanTermin(int i){
        return listaTermina.get(i);
    }

    @Override
    public void run() {
        try {
            while(!Thread.currentThread().isInterrupted()){
                    Thread.sleep(5000);
                    osveziTabelu();
            }
        } catch (InterruptedException ex) {
                Logger.getLogger(TableModelTermini.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        osveziTabelu();
    }

    private void osveziTabelu() {
        try{
            listaTermina = ClientController.getInstance().getAllZakazanTermin();
            if(!parametar.equals("")){
                List<ZakazanTermin> novaLista=new ArrayList<>();
                for(ZakazanTermin zt: listaTermina)
                    if(zt.getPomocniTrener().getIme().toLowerCase().contains(parametar.toLowerCase())
                            || zt.getPomocniTrener().getPrezime().toLowerCase().contains(parametar.toLowerCase())
                            || zt.getKorisnik().getIme().toLowerCase().contains(parametar.toLowerCase())
                            || zt.getKorisnik().getIme().toLowerCase().contains(parametar.toLowerCase())
                            || zt.getTrening().getNazivTreninga().toLowerCase().contains(parametar.toLowerCase()))
                        novaLista.add(zt);
                listaTermina=novaLista;
            }else{
                
            }
            fireTableDataChanged();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void refreshTable() {
        try {
            listaTermina = ClientController.getInstance().getAllZakazanTermin();
        } catch (Exception ex) {
            Logger.getLogger(TableModelTermini.class.getName()).log(Level.SEVERE, null, ex);
        }
        fireTableDataChanged();
    }
    
}