package com.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UserInformation.class)
public abstract class UserInformation_ extends com.model.BaseEntity_ {

	public static volatile SingularAttribute<UserInformation, String> telephoneNumber;
	public static volatile SingularAttribute<UserInformation, String> address;
	public static volatile SingularAttribute<UserInformation, User> user;

}

