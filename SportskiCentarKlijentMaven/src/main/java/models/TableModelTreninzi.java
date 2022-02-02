/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.ClientController;
import domain.Trening;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Kujovic
 */
public class TableModelTreninzi extends AbstractTableModel implements Runnable {

    private List<Trening> listaTreninga;
    private String[] kolone = {"ID", "Naziv treninga", "Vrsta treninga"};
    private String parametar = "";

    public TableModelTreninzi() {
        try {
            listaTreninga = ClientController.getInstance().getAllTrening();
        } catch (Exception ex) {
            Logger.getLogger(TableModelTreninzi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getRowCount() {
        return listaTreninga.size();
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
        Trening t = listaTreninga.get(i);

        switch (i1) {
            case 0:
                return t.getTreningID();
            case 1:
                return t.getNazivTreninga();
            case 2:
                return t.getVrstaTreninga();

            default:
                return null;
        }
    }

    public Trening getSelectedTrening(int i) {
        return listaTreninga.get(i);
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(5000);
                osveziTabelu();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(TableModelTreninzi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        osveziTabelu();
    }

    private void osveziTabelu() {
        try {
            listaTreninga = ClientController.getInstance().getAllTrening();
            if (!parametar.equals("")) {
                List<Trening> novaLista = new ArrayList<>();
                for (Trening t : listaTreninga) {
                    if (t.getNazivTreninga().toLowerCase().contains(parametar.toLowerCase())) {
                        novaLista.add(t);
                    }
                }
                listaTreninga = novaLista;
            } else {

            }
            fireTableDataChanged();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void refreshTable() {
        try {
            listaTreninga = ClientController.getInstance().getAllTrening();
        } catch (Exception ex) {
            Logger.getLogger(TableModelTreninzi.class.getName()).log(Level.SEVERE, null, ex);
        }
        fireTableDataChanged();
    }

}