package springboot.hibernate.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.hibernate.dao.CandidateDAO;
import springboot.hibernate.entity.Candidate;
import springboot.hibernate.service.CandidateService;

@Service("candidateService")
@Transactional
public class CandidateServiceImpl implements CandidateService {

	@Autowired
	private CandidateDAO candidateDAO;

	@Override
	public void create(Candidate candidate) {
		// TODO Auto-generated method stub
		candidateDAO.create(candidate);
	}

	@Override
	public void remove(Candidate candidate) {
		// TODO Auto-generated method stub
		candidateDAO.remove(candidate);
	}

	@Override
	public void edit(Candidate candidate) {
		// TODO Auto-generated method stub
		candidateDAO.edit(candidate);
	}

	@Override
	public List<Candidate> findAll() {
		// TODO Auto-generated method stub
		return candidateDAO.findAll();
	}

	@Override
	public Candidate find(int id) {
		// TODO Auto-generated method stub
		return candidateDAO.find(id);
	}

	@Override
	public List<Candidate> viewAllCandidate(int result, int offsetreal) {
		// TODO Auto-generated method stub
		return candidateDAO.viewAllCandidate(result, offsetreal);
	}

	@Override
	public void save(Candidate candidate) {
		// TODO Auto-generated method stub
		candidateDAO.save(candidate);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return candidateDAO.getSize();
	}

	// @Override
	// public List<Candidate> findByInterviewID(int id)
	// {
	// // TODO Auto-generated method stub
	// return candidateDAO.findByInterviewID(id);
	// }

}
