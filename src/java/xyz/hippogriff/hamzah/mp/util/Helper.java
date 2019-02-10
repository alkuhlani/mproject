package xyz.hippogriff.hamzah.mp.util;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author mohammed
 */
public class Helper {

    public static void message(Severity severity, String summary) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, msg(summary), null));
    }

    public static String msg(String key) {
        try {
            return FacesContext
                    .getCurrentInstance()
                    .getApplication()
                    .getResourceBundle(FacesContext.getCurrentInstance(), "msg").getString(key);
        } catch (Exception e) {
            return key;
        }
    }

    public static void redirect(String url) {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        try {
            context.redirect(context.getRequestContextPath() + url);
            FacesContext.getCurrentInstance().responseComplete();
        } catch (IOException ex) {
            Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static char getCompIdByMobileNo(String mobileNo){
        if(mobileNo.startsWith("77")){
            return '1';
        }else if(mobileNo.startsWith("73")){
            return '2';
        }else if(mobileNo.startsWith("71")){
            return '3';
        }else if(mobileNo.startsWith("70")){
            return '4';
        }else{
            return '0';
        } 
    }
}
