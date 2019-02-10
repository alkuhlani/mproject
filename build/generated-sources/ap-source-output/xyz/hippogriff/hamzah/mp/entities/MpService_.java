package xyz.hippogriff.hamzah.mp.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import xyz.hippogriff.hamzah.mp.entities.MpDirectorate;
import xyz.hippogriff.hamzah.mp.entities.MpGeneralMajor;
import xyz.hippogriff.hamzah.mp.entities.MpNickname;
import xyz.hippogriff.hamzah.mp.entities.MpStreet;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-08T22:39:27")
@StaticMetamodel(MpService.class)
public class MpService_ { 

    public static volatile SingularAttribute<MpService, String> viewes;
    public static volatile SingularAttribute<MpService, String> smTwitter;
    public static volatile SingularAttribute<MpService, String> smWhatsapp;
    public static volatile SingularAttribute<MpService, String> smFb;
    public static volatile SingularAttribute<MpService, MpDirectorate> directorateId;
    public static volatile SingularAttribute<MpService, Character> gender;
    public static volatile SingularAttribute<MpService, MpNickname> nicknameId;
    public static volatile SingularAttribute<MpService, String> desci;
    public static volatile SingularAttribute<MpService, String> streetName;
    public static volatile SingularAttribute<MpService, String> rateNo;
    public static volatile SingularAttribute<MpService, String> comobileNo;
    public static volatile SingularAttribute<MpService, String> smInstegram;
    public static volatile SingularAttribute<MpService, String> costMoney;
    public static volatile SingularAttribute<MpService, Long> id;
    public static volatile SingularAttribute<MpService, String> info;
    public static volatile SingularAttribute<MpService, String> address;
    public static volatile SingularAttribute<MpService, String> addressMap;
    public static volatile SingularAttribute<MpService, String> fullName;
    public static volatile SingularAttribute<MpService, String> smlinkedIn;
    public static volatile SingularAttribute<MpService, String> visitors;
    public static volatile SingularAttribute<MpService, String> cophoneNo;
    public static volatile SingularAttribute<MpService, String> services2;
    public static volatile SingularAttribute<MpService, MpGeneralMajor> geMaId;
    public static volatile SingularAttribute<MpService, String> waitTime;
    public static volatile SingularAttribute<MpService, String> services1;
    public static volatile SingularAttribute<MpService, MpStreet> streetId;

}