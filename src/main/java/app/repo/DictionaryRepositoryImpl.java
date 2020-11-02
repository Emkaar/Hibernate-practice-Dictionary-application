package app.repo;

import app.models.Dictionary;
import app.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;
import java.util.List;

@Component
public class DictionaryRepositoryImpl implements RepositoryI<Dictionary> {

    SessionFactory sessionFactory;

    public DictionaryRepositoryImpl() {
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
        Selection[] selections = {root.get("id"), root.get("learningLanguage")};
        cq.select(cb.construct(Dictionary.class, selections));
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
        session.beginTransaction();
        Dictionary item = (Dictionary) session.get(Dictionary.class, id);
        session.close();
        return item;
    }
}
