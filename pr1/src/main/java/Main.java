import com.company.student;
import com.company.teacher;
import org.hibernate.*;
import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;

public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

        public static void main(final String[] args) throws Exception {
            final Session session = getSession();

            try {

                System.out.println("querying all the managed entities...");
                final Metamodel metamodel = session.getSessionFactory().getMetamodel();
                for (EntityType<?> entityType : metamodel.getEntities()) {
                    final String entityName = entityType.getName();
                    final Query query = session.createQuery("from " + entityName);
                    System.out.println("executing: " + query.getQueryString());
                    for (Object o : query.list()) {
                        System.out.println("  " + o);
                    }
                }
            } finally {
                session.close();
            }
        }


    // functions(add,delete,etc...)
    // function structure:
    //1-Create session
    //2-open transaction
    //3-Execute the operations
    //4-Commit transactions
    //5-caTCH ERRORs

    //use query language:
    //1-create session
    //2-enter query command as a string
    //3-create query object using string
    //4-pass result to an object
}