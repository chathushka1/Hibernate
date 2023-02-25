package lk.ijse.hibernate.util;


import lk.ijse.hibernate.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryConfiguration {
    private static SessionFactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;

    private SessionFactoryConfiguration(){
        sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder()
                .configure().build()).addAnnotatedClass(Customer.class).
                getMetadataBuilder().
                applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE).build().
                getSessionFactoryBuilder().build();
    }


    public static SessionFactoryConfiguration getInstance(){
        return (null== factoryConfiguration)
                ? factoryConfiguration = new SessionFactoryConfiguration() :
                factoryConfiguration;
    }
    public Session getSession(){
        //

       return sessionFactory.openSession();
    }
}
