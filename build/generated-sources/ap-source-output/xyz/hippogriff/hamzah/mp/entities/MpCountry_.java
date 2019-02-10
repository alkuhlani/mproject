package xyz.hippogriff.hamzah.mp.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import xyz.hippogriff.hamzah.mp.entities.MpCustomer;
import xyz.hippogriff.hamzah.mp.entities.MpGovernorate;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-08T22:39:27")
@StaticMetamodel(MpCountry.class)
public class MpCountry_ { 

    public static volatile SingularAttribute<MpCountry, String> name;
    public static volatile ListAttribute<MpCountry, MpGovernorate> mpGovernorateList;
    public static volatile SingularAttribute<MpCountry, Long> id;
    public static volatile ListAttribute<MpCountry, MpCustomer> mpCustomerList;

}