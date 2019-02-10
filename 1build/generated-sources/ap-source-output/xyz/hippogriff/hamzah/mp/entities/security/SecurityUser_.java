package xyz.hippogriff.hamzah.mp.entities.security;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import xyz.hippogriff.hamzah.mp.entities.security.SecurityGroup;
import xyz.hippogriff.hamzah.mp.entities.security.SecurityPermission;
import xyz.hippogriff.hamzah.mp.entities.security.SecurityUser;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-24T20:14:41")
@StaticMetamodel(SecurityUser.class)
public class SecurityUser_ { 

    public static volatile SingularAttribute<SecurityUser, String> password;
    public static volatile SingularAttribute<SecurityUser, Date> createTime;
    public static volatile ListAttribute<SecurityUser, SecurityPermission> permissions;
    public static volatile SingularAttribute<SecurityUser, String> name;
    public static volatile ListAttribute<SecurityUser, SecurityGroup> groups;
    public static volatile SingularAttribute<SecurityUser, SecurityUser> updateUser;
    public static volatile SingularAttribute<SecurityUser, Date> updateTime;
    public static volatile SingularAttribute<SecurityUser, SecurityUser> createUser;
    public static volatile SingularAttribute<SecurityUser, Long> id;
    public static volatile SingularAttribute<SecurityUser, String> userName;
    public static volatile SingularAttribute<SecurityUser, Character> lang;

}