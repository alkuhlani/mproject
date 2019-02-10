package xyz.hippogriff.hamzah.mp.security;

import static javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters.withParams;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.SecurityContext;
import javax.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.Password;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@CustomFormAuthenticationMechanismDefinition(loginToContinue = @LoginToContinue(loginPage = "/loginx.xhtml", errorPage = "/loginx.xhtml"))
@Named(value = "accountController")
@RequestScoped
public class AccountController {

    private String username;

    private String password;

    @Inject
    private SecurityContext securityContext;

  
    
    FacesContext context = FacesContext.getCurrentInstance();

    public void login() {
        System.out.println("login");
        System.out.println("login");
        System.out.println("login");
        Credential credential = new UsernamePasswordCredential(username, new Password(password));
        System.out.println("securityContext" + securityContext.authenticate((HttpServletRequest) context.getExternalContext().getRequest(),
                (HttpServletResponse) context.getExternalContext().getResponse(),
                withParams().credential(credential)));
        
        System.out.println("1 . 3");
        System.out.println("context.getApplication():-" + context.getApplication());
        System.out.println("context.getCurrentPhaseId():-" + context.getCurrentPhaseId());
        System.out.println("context.isValidationFailed():-" + context.isValidationFailed());
        System.out.println("context.isReleased():-" + context.isReleased());
        System.out.println("context.isProcessingEvents():-" + context.isProcessingEvents());
        System.out.println("context.isPostback():-" + context.isPostback());
//        System.out.println("securityContext.getCallerPrincipal().getName() :-"+securityContext.getCallerPrincipal().getName());
        System.out.println("getCurrentURL():-" + getCurrentURL());
//        if(!"/login.xhtml".equals(getCurrentURL())){
//            if(!"/index.xhtml".equals(getCurrentURL())){
//                Helper.redirect(getCurrentURL()+"?faces-redirect=true");
//            }
//            
//        }

        System.out.println(""+context.getRenderResponse());
        System.out.println(""+getRequest(context).isSecure());
        

    }

   
    public void logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }

    public void changeLanguage(String language) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("language", language);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCurrentURL() {
        return FacesContext.getCurrentInstance().getViewRoot().getViewId();
    }
    
    private static HttpServletResponse getResponse(FacesContext context) {
        return (HttpServletResponse) context
                .getExternalContext()
                .getResponse();
    }

    private static HttpServletRequest getRequest(FacesContext context) {
        return (HttpServletRequest) context
                .getExternalContext()
                .getRequest();
    }
}
