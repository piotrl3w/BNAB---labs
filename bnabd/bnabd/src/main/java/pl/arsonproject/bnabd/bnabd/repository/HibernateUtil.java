package pl.arsonproject.bnabd.bnabd.repository;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.security.core.session.SessionInformation;

import java.io.File;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try{
            final File configFile = new File("src\\main\\resources\\hibernate.cfg.xml");
            return new Configuration().configure(configFile).buildSessionFactory();
        }catch (Exception e){
            System.err.println("Session factory creation failed");
            throw new ExceptionInInitializerError();
        }
    }

    public static SessionFactory getSessionFactory(){
        return  sessionFactory;
    }

    public static void shutdown(){
        getSessionFactory().close();
    }
}
