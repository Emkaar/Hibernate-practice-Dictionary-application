package app.repo;

import app.models.User;
import app.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@Transactional
public class UserRepositoryImpl implements RepositoryI<User> {

    SessionFactory sessionFactory;

    public UserRepositoryImpl() {
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
        User item = (User) session.get(User.class, id);
        session.close();
        return item;
    }
}
