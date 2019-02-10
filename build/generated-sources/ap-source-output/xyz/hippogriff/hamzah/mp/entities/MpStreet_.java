package xyz.hippogriff.hamzah.mp.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import xyz.hippogriff.hamzah.mp.entities.MpDirectorate;
import xyz.hippogriff.hamzah.mp.entities.MpService;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-08T22:39:27")
@StaticMetamodel(MpStreet.class)
public class MpStreet_ { 

    public static volatile ListAttribute<MpStreet, MpService> mpServiceList;
    public static volatile SingularAttribute<MpStreet, String> name;
    public static volatile SingularAttribute<MpStreet, MpDirectorate> dirId;
    public static volatile SingularAttribute<MpStreet, Long> id;

}