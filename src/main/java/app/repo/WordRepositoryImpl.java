package app.repo;

import app.util.HibernateUtil;
import models.User;
import models.Word;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class WordRepositoryImpl implements RepositoryI<Word>{

    SessionFactory sessionFactory;
    WordRepositoryImpl(){
        sessionFactory = HibernateUtil.getSessionFactory();
    }
    @Override
    public void save(Word item) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Word item) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(item);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Word> getAll() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Word.class);
        Root<Word> root = cq.from(Word.class);
        List<Word> itemList =  session.createQuery(cq).getResultList();
        session.close();
        return itemList;
    }

    @Override
    public List<Word> getListWithParam(String field, Object param) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Word.class);
        Root<Word> root = cq.from(Word.class);
        cq.select(root);
        cq.where(cb.equal(root.get(field), param));
        List<Word> itemList =  session.createQuery(cq).getResultList();
        session.close();
        return itemList;
    }

    @Override
    public Word getById(Integer id) {
        Session session = sessionFactory.openSession();
        Word word = session.find(Word.class, id);
        return word;
    }
}
