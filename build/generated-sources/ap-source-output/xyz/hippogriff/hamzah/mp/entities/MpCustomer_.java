package xyz.hippogriff.hamzah.mp.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import xyz.hippogriff.hamzah.mp.entities.MpCountry;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-08T22:39:27")
@StaticMetamodel(MpCustomer.class)
public class MpCustomer_ { 

    public static volatile SingularAttribute<MpCustomer, Date> birthday;
    public static volatile SingularAttribute<MpCustomer, String> fullName;
    public static volatile SingularAttribute<MpCustomer, MpCountry> coId;
    public static volatile SingularAttribute<MpCustomer, Long> id;
    public static volatile SingularAttribute<MpCustomer, String> mobileNo;
    public static volatile SingularAttribute<MpCustomer, String> email;

}