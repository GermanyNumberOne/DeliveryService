package com.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Card.class)
public abstract class Card_ extends com.model.BaseEntity_ {

	public static volatile SingularAttribute<Card, String> number;
	public static volatile SingularAttribute<Card, Short> password;
	public static volatile SingularAttribute<Card, Long> money;
	public static volatile SingularAttribute<Card, User> user;

}

