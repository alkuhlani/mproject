package xyz.hippogriff.hamzah.mp.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import xyz.hippogriff.hamzah.mp.entities.MpGeneralMajor;
import xyz.hippogriff.hamzah.mp.entities.MpMedicalService;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-24T20:14:41")
@StaticMetamodel(MpMajor.class)
public class MpMajor_ { 

    public static volatile ListAttribute<MpMajor, MpMedicalService> mpMedicalServiceList;
    public static volatile SingularAttribute<MpMajor, String> name;
    public static volatile SingularAttribute<MpMajor, Long> id;
    public static volatile SingularAttribute<MpMajor, MpGeneralMajor> geMaId;

}