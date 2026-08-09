package amjad.sms;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.ArrayList;
import java.util.List;

public class DAO {

    public DAO() { }

    public List<Student> retrieveAllRecords() {
        List<Student> students = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            students = session.createQuery("from Student", Student.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    public Student retrieveOneRecord(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Student.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addRecord(Student student) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(student);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateRecord(Student student) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(student); // merge handles updating existing detached entities
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteRecord(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Student student = session.get(Student.class, id);
            if (student != null) {
                session.remove(student);
                transaction.commit();
                return true;
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }
}