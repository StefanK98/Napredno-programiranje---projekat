/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer.util;

/**
 *
 * @author Kujovic
 */
public interface Operation {
    
    public static final int LOGIN = 0;
    
    public static final int ADD_POMOCNITRENER = 1;
    public static final int DELETE_POMOCNITRENER = 2;
    public static final int EDIT_POMOCNITRENER = 3;
    public static final int GET_ALL_POMOCNITRENER = 4;
    
    public static final int ADD_KORISNIK = 5;
    public static final int DELETE_KORISNIK = 6;
    public static final int EDIT_KORISNIK = 7;
    public static final int GET_ALL_KORISNIK = 8;
    
    public static final int ADD_TRENING = 9;
    public static final int DELETE_TRENING = 10;
    public static final int EDIT_TRENING = 11;
    public static final int GET_ALL_TRENING = 12;
    
    public static final int ADD_ZAKAZAN_TERMIN = 13;
    public static final int DELETE_ZAKAZAN_TERMIN = 14;
    public static final int GET_ALL_ZAKAZAN_TERMIN = 15;
    
    public static final int ADD_VEZBA_ZA_TERMIN = 16;
    public static final int DELETE_VEZBA_ZA_TERMIN = 17;
    public static final int GET_ALL_VEZBA_ZA_TERMIN = 18;
    
    public static final int GET_ALL_TIP_KORISNIKA = 19;
    
    public static final int GET_ALL_VRSTA_TRENINGA = 20;

}
