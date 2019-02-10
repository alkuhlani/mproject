/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.hippogriff.hamzah.mp.util;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author said
 */
@Named(value = "helperMB")
@Dependent
public class HelperMB implements Serializable{

    /**
     * Creates a new instance of HelperMB
     */
    public HelperMB() {
    }
    
    public void outComeTo(String url){
        Helper.redirect(url);
    }
    
}
