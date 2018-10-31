import com.jwebmp.guicedhazelcast.HazelcastBinderGuice;
import com.jwebmp.guicedhazelcast.HazelcastConfigHandler;
import com.jwebmp.guicedhazelcast.HazelcastEntityManagerProperties;
import com.jwebmp.guicedhazelcast.HazelcastPostStartup;
import com.jwebmp.guicedhazelcast.services.IGuicedHazelcastClientConfig;
import com.jwebmp.guicedinjection.interfaces.IFileContentsScanner;
import com.jwebmp.guicedinjection.interfaces.IGuiceDefaultBinder;
import com.jwebmp.guicedinjection.interfaces.IGuicePostStartup;

module com.jwebmp.guicedhazelcast {
	exports com.jwebmp.guicedhazelcast;

	requires com.google.guice;
	requires hazelcast.all;

	requires com.jwebmp.guicedinjection;
	requires com.jwebmp.logmaster;
	requires java.logging;
	requires cache.annotations.ri.guice;
	requires java.validation;

	requires com.jwebmp.guicedpersistence;
	requires org.hibernate.orm.jcache;
	requires cache.api;
	requires io.github.classgraph;
	requires org.apache.commons.io;

	requires com.google.common;

	requires com.jwebmp.guicedpersistence.readers.hibernateproperties;
	requires javax.inject;

	uses IGuicedHazelcastClientConfig;

	provides com.jwebmp.guicedpersistence.services.PropertiesEntityManagerReader with HazelcastEntityManagerProperties;

	provides IFileContentsScanner with HazelcastConfigHandler;
	provides IGuiceDefaultBinder with HazelcastBinderGuice;
	provides IGuicePostStartup with HazelcastPostStartup;
}
