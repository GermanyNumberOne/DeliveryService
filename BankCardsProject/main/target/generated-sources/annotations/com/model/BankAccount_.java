package com.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BankAccount.class)
public abstract class BankAccount_ extends com.model.BaseEntity_ {

	public static volatile ListAttribute<BankAccount, Operation> operations;
	public static volatile ListAttribute<BankAccount, User> users;

}

