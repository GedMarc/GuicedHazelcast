module com.guicedee.guicedhazelcast {
	exports com.guicedee.guicedhazelcast;
	exports com.guicedee.guicedhazelcast.services;

	requires cache.annotations.ri.guice;
	requires java.logging;


	requires transitive com.hazelcast.all;
	requires transitive org.apache.commons.io;

	requires transitive com.guicedee.guicedinjection;

	uses com.guicedee.guicedhazelcast.services.IGuicedHazelcastClientConfig;
	uses com.guicedee.guicedhazelcast.services.IGuicedHazelcastServerConfig;

	provides com.guicedee.guicedinjection.interfaces.IGuicePreDestroy with com.guicedee.guicedhazelcast.implementations.HazelcastClientProvider,
			                                                                  com.guicedee.guicedhazelcast.services.HazelcastPreStartup,
			                                                                  com.guicedee.guicedhazelcast.services.HazelcastClientPreStartup;
	provides com.guicedee.guicedinjection.interfaces.IGuiceDefaultBinder with com.guicedee.guicedhazelcast.implementations.HazelcastBinderGuice;

	provides com.guicedee.guicedinjection.interfaces.IGuicePreStartup with com.guicedee.guicedhazelcast.services.HazelcastPreStartup,
			                                                                  com.guicedee.guicedhazelcast.services.HazelcastClientPreStartup;

	opens com.guicedee.guicedhazelcast to com.google.guice;
	opens com.guicedee.guicedhazelcast.annotations to com.google.guice;
	opens com.guicedee.guicedhazelcast.implementations to com.google.guice;
	opens com.guicedee.guicedhazelcast.services to com.google.guice;
}
