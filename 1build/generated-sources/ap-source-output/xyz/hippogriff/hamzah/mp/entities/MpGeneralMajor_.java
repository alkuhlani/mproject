package xyz.hippogriff.hamzah.mp.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import xyz.hippogriff.hamzah.mp.entities.MpMajor;
import xyz.hippogriff.hamzah.mp.entities.MpService;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-24T20:14:41")
@StaticMetamodel(MpGeneralMajor.class)
public class MpGeneralMajor_ { 

    public static volatile ListAttribute<MpGeneralMajor, MpMajor> mpMajorList;
    public static volatile ListAttribute<MpGeneralMajor, MpService> mpServiceList;
    public static volatile SingularAttribute<MpGeneralMajor, String> name;
    public static volatile SingularAttribute<MpGeneralMajor, Long> id;

}