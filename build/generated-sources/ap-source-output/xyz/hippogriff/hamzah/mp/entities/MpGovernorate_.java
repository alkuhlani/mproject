package xyz.hippogriff.hamzah.mp.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import xyz.hippogriff.hamzah.mp.entities.MpCountry;
import xyz.hippogriff.hamzah.mp.entities.MpDirectorate;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-08T22:39:27")
@StaticMetamodel(MpGovernorate.class)
public class MpGovernorate_ { 

    public static volatile ListAttribute<MpGovernorate, MpDirectorate> mpDirectorateList;
    public static volatile SingularAttribute<MpGovernorate, String> name;
    public static volatile SingularAttribute<MpGovernorate, MpCountry> coId;
    public static volatile SingularAttribute<MpGovernorate, Long> id;

}