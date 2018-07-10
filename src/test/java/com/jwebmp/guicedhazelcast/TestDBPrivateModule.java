package com.jwebmp.guicedhazelcast;

import com.jwebmp.guicedpersistence.db.ConnectionBaseInfo;
import com.jwebmp.guicedpersistence.db.connectionbasebuilders.AbstractDatabaseProviderModule;
import com.jwebmp.guicedpersistence.jpa.JPAConnectionBaseInfo;
import com.oracle.jaxb21.PersistenceUnit;

import javax.validation.constraints.NotNull;
import java.lang.annotation.Annotation;
import java.util.Properties;

public class TestDBPrivateModule
		extends AbstractDatabaseProviderModule
{

	@Override
	protected @NotNull ConnectionBaseInfo getConnectionBaseInfo(PersistenceUnit unit, Properties filteredProperties)
	{
		return new JPAConnectionBaseInfo();
	}

	@Override
	protected String getJndiMapping()
	{
		return "jdbc/jndi";
	}

	@Override
	protected String getPersistenceUnitName()
	{
		return "guiceinjectionh2test";
	}

	@Override
	protected Class<? extends Annotation> getBindingAnnotation()
	{
		return TestCustomPersistenceLoader.class;
	}
}
