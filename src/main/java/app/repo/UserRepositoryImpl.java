package app.repo;

import app.util.HibernateUtil;
import models.User;

import org.graalvm.compiler.lir.LIRInstruction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserRepositoryImpl implements RepositoryI<User> {

    SessionFactory sessionFactory;
    public UserRepositoryImpl(){
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public void save(User item) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(User item) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(item);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<User> getAll() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(User.class);
        Root<User> root = cq.from(User.class);
        List<User> itemList =  session.createQuery(cq).getResultList();
        session.close();
        return itemList;
    }



    @Override
    public List<User> getListWithParam(String field, Object param) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(User.class);
        Root<User> root = cq.from(User.class);
        cq.select(root);
        cq.where(cb.equal(root.get(field), param));
        List<User> itemList =  session.createQuery(cq).getResultList();
        session.close();
        return itemList;
    }

    @Override
    public User getById(Integer id) {
        Session session = sessionFactory.openSession();
        User user = session.find(User.class, id);
        return user;
    }
}
