package xyz.hippogriff.hamzah.mp.entities.security;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import xyz.hippogriff.hamzah.mp.entities.security.SecurityGroup;
import xyz.hippogriff.hamzah.mp.entities.security.SecurityUser;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-24T20:14:41")
@StaticMetamodel(SecurityPermission.class)
public class SecurityPermission_ { 

    public static volatile SingularAttribute<SecurityPermission, Date> createTime;
    public static volatile SingularAttribute<SecurityPermission, String> name;
    public static volatile ListAttribute<SecurityPermission, SecurityGroup> groups;
    public static volatile SingularAttribute<SecurityPermission, SecurityUser> updateUser;
    public static volatile SingularAttribute<SecurityPermission, Date> updateTime;
    public static volatile SingularAttribute<SecurityPermission, SecurityUser> createUser;
    public static volatile SingularAttribute<SecurityPermission, Long> id;
    public static volatile ListAttribute<SecurityPermission, SecurityUser> users;

}