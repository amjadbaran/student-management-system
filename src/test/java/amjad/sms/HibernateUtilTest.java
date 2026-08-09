package amjad.sms;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HibernateUtilTest {

    @Test
    public void testGetSessionFactory() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        assertNotNull(sessionFactory);
        assertFalse(sessionFactory.isClosed());
    }
}