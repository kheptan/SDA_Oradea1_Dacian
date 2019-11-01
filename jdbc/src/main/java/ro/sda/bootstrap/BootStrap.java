package ro.sda.bootstrap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AvailableSettings;

import ro.sda.entities.ClassRoom;
import ro.sda.entities.Person;
import ro.sda.entities.Team;

public class BootStrap {
	private static SessionFactory sessionFactory;
	
	private static SessionFactory bootStrapConfig() {
		StandardServiceRegistry standardRegistry =
		   new StandardServiceRegistryBuilder()
		        .applySetting(AvailableSettings.DRIVER,"com.mysql.cj.jdbc.Driver")
		        .applySetting(AvailableSettings.URL, "jdbc:mysql://localhost:3306/SdaScheduler?serverTimezone=UTC")
				.applySetting(AvailableSettings.USER, "root")        
				.applySetting(AvailableSettings.PASS, "pr0j3ct0")
				.applySetting(AvailableSettings.DIALECT, "org.hibernate.dialect.MySQL5Dialect")
				.applySetting(AvailableSettings.SHOW_SQL, "true").build();
		
		MetadataSources sources = new MetadataSources( standardRegistry );
		sources.addAnnotatedClass(Team.class);
		sources.addAnnotatedClass(Person.class);
		sources.addAnnotatedClass(ClassRoom.class);
		
		MetadataBuilder metadataBuilder = sources.getMetadataBuilder();
		
		Metadata metadata = metadataBuilder.build();
		
		return sessionFactory = metadata.getSessionFactoryBuilder().build();
	}

	private static SessionFactory getSessionFactory() {
		if(sessionFactory==null) {
			return bootStrapConfig();
		}
		return sessionFactory;
	}
	
	public static Session getSession() {
		return getSessionFactory().openSession();
	}
}
