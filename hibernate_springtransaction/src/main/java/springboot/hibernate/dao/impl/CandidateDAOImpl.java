package springboot.hibernate.dao.impl;

import java.sql.Connection;

import java.sql.Statement;

import java.util.List;

import org.hibernate.Criteria;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springboot.hibernate.dao.CandidateDAO;
import springboot.hibernate.entity.Candidate;

@Repository("candidateDAO")
public class CandidateDAOImpl implements CandidateDAO {
//	private static int pageSize = 3;
	Statement stmt;

	Connection connection;

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void create(Candidate candidate) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().persist(candidate);
	}

	@Override
	public void remove(Candidate candidate) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(candidate);
	}

	@Override
	public void edit(Candidate candidate) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(candidate);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Candidate> findAll() {
//		String sql = "Select new " + Candidate.class.getName() //
//				+ "(c.gpa, c.name, c.email) " //
//				+ " from " + Candidate.class.getName() + " c ";
//		Session session = this.sessionFactory.getCurrentSession();
//		Query<Candidate> query = session.createQuery(sql, Candidate.class);
//		return query.getResultList();
		return sessionFactory.getCurrentSession().createCriteria(Candidate.class).list();
	}

	@Override
	public Candidate find(int id) {
		// TODO Auto-generated method stub
		return (Candidate) sessionFactory.getCurrentSession().get(Candidate.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Candidate> findByInterviewID(int id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(Candidate.class)
				.add(Restrictions.eq("InterviewID", id)).list();

	}

	@Override
	@Transactional
	public List<Candidate> viewAllCandidate(int result, int offsetreal) {
		// TODO Auto-generated method stub
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Candidate.class);
		criteria.setFirstResult(offsetreal);
		criteria.setMaxResults(result);
		List<Candidate> candidate = (List<Candidate>) criteria.list();
		return candidate;
	}

	@Override
	public void save(Candidate candidate) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(candidate);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(Candidate.class).list().size();
	}
}