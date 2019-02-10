package xyz.hippogriff.hamzah.mp.entities.security;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import xyz.hippogriff.hamzah.mp.entities.security.SecurityUser;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-24T20:14:41")
@StaticMetamodel(SecurityTracking.class)
public class SecurityTracking_ { 

    public static volatile SingularAttribute<SecurityTracking, Boolean> isLogin;
    public static volatile SingularAttribute<SecurityTracking, Date> loginTime;
    public static volatile SingularAttribute<SecurityTracking, String> loginIP;
    public static volatile SingularAttribute<SecurityTracking, SecurityUser> createUser;
    public static volatile SingularAttribute<SecurityTracking, Long> id;
    public static volatile SingularAttribute<SecurityTracking, String> userName;

}