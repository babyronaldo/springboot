package springboot.hibernate.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.hibernate.dao.InterviewerDAO;
import springboot.hibernate.entity.Interviewer;
import springboot.hibernate.service.InterviewerService;

@Service("interviewerService")
@Transactional
public class InterviewerServiceImpl implements InterviewerService
{
	@Autowired
	private InterviewerDAO interviewerDAO;

	@Override
	public void create(Interviewer interviewer)
	{
		// TODO Auto-generated method stub
		interviewerDAO.create(interviewer);
	}

	@Override
	public void remove(Interviewer interviewer)
	{
		// TODO Auto-generated method stub
		interviewerDAO.remove(interviewer);
	}

	@Override
	public void edit(Interviewer interviewer)
	{
		// TODO Auto-generated method stub
		interviewerDAO.edit(interviewer);
	}

	@Override
	public List<Interviewer> findAll()
	{
		// TODO Auto-generated method stub
		return interviewerDAO.findAll();
	}

	@Override
	public Interviewer find(int id)
	{
		// TODO Auto-generated method stub
		return interviewerDAO.find(id);
	}

	@Override
	public Interviewer findInterviewerbyUserName(String name) {
		// TODO Auto-generated method stub
		return this.interviewerDAO.findInterviewerbyUserName(name);
	}

}
