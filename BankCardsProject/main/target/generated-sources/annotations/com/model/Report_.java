package com.model;

import com.model.enums.OperationCategories;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Report.class)
public abstract class Report_ extends com.model.BaseEntity_ {

	public static volatile SingularAttribute<Report, Operation> operation;
	public static volatile SingularAttribute<Report, OperationCategories> operationCategory;
	public static volatile SingularAttribute<Report, Boolean> isSuccess;

}

