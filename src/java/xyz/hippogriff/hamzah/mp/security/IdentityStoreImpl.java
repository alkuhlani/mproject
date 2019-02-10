package xyz.hippogriff.hamzah.mp.security;



import java.util.HashSet;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.security.enterprise.CallerPrincipal;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import static javax.security.enterprise.identitystore.CredentialValidationResult.INVALID_RESULT;
import static javax.security.enterprise.identitystore.CredentialValidationResult.NOT_VALIDATED_RESULT;
import javax.security.enterprise.identitystore.IdentityStore;
import xyz.hippogriff.hamzah.mp.ejbs.DataAccessObject;
import xyz.hippogriff.hamzah.mp.entities.security.SecurityUser;

/**
 *
 * @author mohammed
 */
@RequestScoped
public class IdentityStoreImpl implements IdentityStore {

    @Inject
    private DataAccessObject userService;


    @Override
    public CredentialValidationResult validate(Credential credential) {
        System.out.println("IdentityStoreImpl : validate");
        if (credential instanceof UsernamePasswordCredential) {
            System.out.println("in if");
            return validate((UsernamePasswordCredential) credential);
        }
        System.out.println("out if");
        System.out.println(""+credential.toString());
        System.out.println(""+credential.getClass());
        System.out.println(""+credential.isValid());
        System.out.println(""+credential.isCleared());
        return NOT_VALIDATED_RESULT;
    }

    private CredentialValidationResult validate(UsernamePasswordCredential usernamePasswordCredential) {
        System.out.println("IdentityStoreImpl : CredentialValidationResult validate()");
        SecurityUser user = userService.findByUserNamePassword(usernamePasswordCredential.getCaller(), usernamePasswordCredential.getPasswordAsString());
        System.out.println("hello");
        if (Objects.nonNull(user)) {
            if(user.getLang()=='e'){
                FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("en"));
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("language","en");
            }else{
                FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("ar"));
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("language","ar");
            }
            
            Set<String> groups = new HashSet<>();
            user.getGroups().forEach((group) -> {
                group.getPermissions().forEach((permission) -> {
                    groups.add(permission.getName());
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(permission.getName(),true);
                    System.out.println(" in groups:"+permission.getName());
                });
            });
            user.getPermissions().forEach((permission) -> {
                groups.add(permission.getName());
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(permission.getName(),true);
                System.out.println("in (permission) groups:"+permission.getName());
            });
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userId", user.getId());
            return new CredentialValidationResult(new CallerPrincipal(user.getUserName()), groups);
        }
        if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("service.all").equals(true)){
        }
        return INVALID_RESULT;
    }
}
