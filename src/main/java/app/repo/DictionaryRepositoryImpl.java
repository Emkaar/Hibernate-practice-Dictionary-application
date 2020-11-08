package app.repo;

import app.util.HibernateUtil;
import models.Dictionary;
import models.User;
import models.Word;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class DictionaryRepositoryImpl implements RepositoryI<Dictionary> {

    SessionFactory sessionFactory;
    DictionaryRepositoryImpl(){
        sessionFactory = HibernateUtil.getSessionFactory();
    }
    @Override
    public void save(Dictionary item) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Dictionary item) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(item);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Dictionary> getAll() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Dictionary.class);
        Root<Dictionary> root = cq.from(Dictionary.class);
        List<Dictionary> itemList =  session.createQuery(cq).getResultList();
        session.close();
        return itemList;
    }

    @Override
    public List<Dictionary> getListWithParam(String field, Object param) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Dictionary.class);
        Root<Dictionary> root = cq.from(Dictionary.class);
        cq.select(root);
        cq.where(cb.equal(root.get(field), param));
        List<Dictionary> itemList =  session.createQuery(cq).getResultList();
        session.close();
        return itemList;
    }

    @Override
    public Dictionary getById(Integer id) {
        Session session = sessionFactory.openSession();
        Dictionary dictionary = session.find(Dictionary.class, id);
        return dictionary;
    }
}
