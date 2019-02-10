package xyz.hippogriff.hamzah.mp.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import xyz.hippogriff.hamzah.mp.entities.MpGovernorate;
import xyz.hippogriff.hamzah.mp.entities.MpService;
import xyz.hippogriff.hamzah.mp.entities.MpStreet;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-24T20:14:41")
@StaticMetamodel(MpDirectorate.class)
public class MpDirectorate_ { 

    public static volatile SingularAttribute<MpDirectorate, MpGovernorate> goId;
    public static volatile ListAttribute<MpDirectorate, MpService> mpServiceList;
    public static volatile SingularAttribute<MpDirectorate, String> name;
    public static volatile SingularAttribute<MpDirectorate, Long> id;
    public static volatile ListAttribute<MpDirectorate, MpStreet> mpStreetList;

}