package app.repo;

import app.models.Word;
import app.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;
import java.util.List;

public class WordRepositoryImpl implements RepositoryI<Word> {

    SessionFactory sessionFactory;

    public WordRepositoryImpl() {
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
        Selection[] selections = {root.get("id"),
                root.get("original"),
                root.get("translate"),
                root.get("learnIndex")};
        cq.select(cb.construct(Word.class, selections));
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
        session.beginTransaction();
        Word item = (Word) session.get(Word.class, id);
        session.close();
        return item;
    }
}
