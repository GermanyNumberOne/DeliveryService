package com.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Operation.class)
public abstract class Operation_ extends com.model.BaseEntity_ {

	public static volatile SingularAttribute<Operation, BankAccount> bankAccount;
	public static volatile SingularAttribute<Operation, Long> cost;
	public static volatile SingularAttribute<Operation, Report> report;

}

