package springboot.hibernate.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springboot.hibernate.dao.InterviewerDAO;
import springboot.hibernate.entity.Interviewer;

@Repository("interviewerDAO")
public class InterviewerDAOImpl implements InterviewerDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(Interviewer interviewer) {
        // TODO Auto-generated method stub
        sessionFactory.getCurrentSession().persist(interviewer);
    }

    @Override
    public void remove(Interviewer interviewer) {
        // TODO Auto-generated method stub
        sessionFactory.getCurrentSession().delete(interviewer);
    }

    @Override
    public void edit(Interviewer interviewer) {
        // TODO Auto-generated method stub
        sessionFactory.getCurrentSession().saveOrUpdate(interviewer);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Interviewer> findAll() {
        // TODO Auto-generated method stub
        return sessionFactory.getCurrentSession().createCriteria(Interviewer.class).list();
    }

    @Override
    public Interviewer find(int id) {
        // TODO Auto-generated method stub
        return (Interviewer) sessionFactory.getCurrentSession().get(Interviewer.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Interviewer findInterviewerbyUserName(String name) {
        // TODO Auto-generated method stub
        Session session = this.sessionFactory.getCurrentSession();
        List<Interviewer> m = new ArrayList<Interviewer>();
        m = session.createQuery("from Interviewer where UserName=:name").setParameter("name", name).list();
        if (m.size() > 0) {
            return m.get(0);
        } else {
            return null;
        }
    }

}
