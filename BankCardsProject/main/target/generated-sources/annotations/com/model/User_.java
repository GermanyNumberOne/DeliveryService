package com.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ extends com.model.BaseEntity_ {

	public static volatile SingularAttribute<User, BankAccount> bankAccount;
	public static volatile ListAttribute<User, Card> userCards;
	public static volatile SingularAttribute<User, UserInformation> userInfo;
	public static volatile SingularAttribute<User, String> firstname;
	public static volatile SingularAttribute<User, String> surname;

}

