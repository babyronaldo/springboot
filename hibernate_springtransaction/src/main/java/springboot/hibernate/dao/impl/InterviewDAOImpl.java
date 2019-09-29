package springboot.hibernate.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springboot.hibernate.dao.InterviewDAO;
import springboot.hibernate.entity.Interview;

@Repository("interviewDAO")
public class InterviewDAOImpl implements InterviewDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(Interview interview) {
        // TODO Auto-generated method stub
        sessionFactory.getCurrentSession().merge(interview);
    }

    @Override
    public void remove(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        String queryString = "UPDATE Interview i SET i.isDeleted = 1 WHERE i.interviewId = :id";
        Query query = session.createQuery(queryString);
        query.setParameter("id", id);
        query.executeUpdate();
        //        sessionFactory.getCurrentSession().delete(interview);
    }

    @Override
    public void edit(Interview interview) {
        // TODO Auto-generated method stub
        sessionFactory.getCurrentSession().saveOrUpdate(interview);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Interview> findAll() {
        String query = "from Interview i where i.isDeleted is null";
        Session session = this.sessionFactory.getCurrentSession();
        List<Interview> interviewList = session.createQuery(query, Interview.class).getResultList();
        return interviewList;
//        return sessionFactory.getCurrentSession().createCriteria(Interview.class).list();
    }
    //
    // @Override
    // public List<Interview> findByInterviewID(int id)
    // {
    // // TODO Auto-generated method stub
    // return
    // }

    @Override
    public Interview find(int id) {
        // TODO Auto-generated method stub
        return (Interview) sessionFactory.getCurrentSession().get(Interview.class, id);
    }

    @Override
    @Transactional
    public List<Interview> viewAllInterview(int result, int offsetreal) {
        // TODO Auto-generated method stub
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Interview.class);
        criteria.setFirstResult(offsetreal);
        criteria.setMaxResults(result);
        @SuppressWarnings("unchecked")
        List<Interview> interview = (List<Interview>) criteria.list();
        return interview;
    }

    @Override
    public void save(Interview interview) {
        // TODO Auto-generated method stub
        sessionFactory.getCurrentSession().save(interview);
    }

    @Override
    public int getSize() {
        return sessionFactory.getCurrentSession().createCriteria(Interview.class).list().size();
    }

    //QUERY

    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public List<Interview> Weekly(boolean result, int quantity) {
        // TODO Auto-generated method stub
        Session session = this.sessionFactory.getCurrentSession();
        List<Interview> listInterview = new ArrayList<Interview>();
        listInterview = session.createQuery("from Interview i where i.result = :result" + " and WEEK(i.date) = :quantity").setParameter("result", result).setParameter("quantity", quantity).list();
        if (listInterview.size() > 0) {
            return listInterview;
        } else {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public List<Interview> Monthly(boolean result, int quantity) {
        // TODO Auto-generated method stub
        Session session = this.sessionFactory.getCurrentSession();
        List<Interview> listInterview = new ArrayList<Interview>();
        listInterview = session.createQuery("from Interview i where i.result = :result" + " and MONTH(i.date) = :quantity").setParameter("result", result).setParameter("quantity", quantity).list();
        if (listInterview.size() > 0) {
            return listInterview;
        } else {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public List<Interview> Quarterly(boolean result, int quantity) {
        // TODO Auto-generated method stub
        Session session = this.sessionFactory.getCurrentSession();
        List<Interview> listInterview = new ArrayList<Interview>();
        listInterview = session.createQuery("from Interview i where i.result = :result" + " and QUARTER(i.date) = :quantity").setParameter("result", result).setParameter("quantity", quantity).list();
        if (listInterview.size() > 0) {
            return listInterview;
        } else {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Interview> fromDatetoDate(boolean result, Date from, Date to) {
        // TODO Auto-generated method stub
        Session session = this.sessionFactory.getCurrentSession();
        List<Interview> listInterview = new ArrayList<Interview>();
        listInterview = session.createQuery("FROM Interview i WHERE i.date > :from AND i.date < :to AND i.result = :result").setParameter("result", result).setParameter("from", from).setParameter("to", to).list();
        if (listInterview.size() > 0) {
            return listInterview;
        } else {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Interview> UniName(String name) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Interview> listInterview = new ArrayList<Interview>();
        listInterview = session.createQuery("FROM Interview i WHERE i.candidate.uniName = :name").setParameter("name", name).list();
        if (listInterview.size() > 0) {
            return listInterview;
        } else {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Interview> GPA(float from, float to) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Interview> listInterview = new ArrayList<Interview>();
        listInterview = session.createQuery("FROM Interview i WHERE i.candidate.gpa >= :from AND i.candidate.gpa <= :to").setParameter("from", from).setParameter("to", to).list();
        if (listInterview.size() > 0) {
            return listInterview;
        } else {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Interview> Faculty(String skill) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Interview> listInterview = new ArrayList<Interview>();
        listInterview = session.createQuery("FROM Interview i WHERE i.candidate.skill = :skill").setParameter("skill", skill).list();
        if (listInterview.size() > 0) {
            return listInterview;
        } else {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Interview> GraYear(String year) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Interview> listInterview = new ArrayList<Interview>();
        listInterview = session.createQuery("FROM Interview i WHERE i.candidate.graduateYear = :year").setParameter("year", year).list();
        if (listInterview.size() > 0) {
            return listInterview;
        } else {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Interview> Toeic(int toeicfrom, int toeicto) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Interview> listInterview = new ArrayList<Interview>();
        listInterview = session.createQuery("FROM Interview i WHERE i.toeic >= :toeicfrom And i.toeic <= :toeicto").setParameter("toeicfrom", toeicfrom).setParameter("toeicto", toeicto).list();
        if (listInterview.size() > 0) {
            return listInterview;
        } else {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Interview> Result(boolean result) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Interview> listInterview = new ArrayList<Interview>();
        listInterview = session.createQuery("FROM Interview i WHERE i.result = :result").setParameter("result", result).list();
        if (listInterview.size() > 0) {
            return listInterview;
        } else {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Interview> Source(String source) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Interview> listInterview = new ArrayList<Interview>();
        listInterview = session.createQuery("FROM Interview i WHERE i.source = :source").setParameter("source", source).list();
        if (listInterview.size() > 0) {
            return listInterview;
        } else {
            return null;
        }
    }

}
