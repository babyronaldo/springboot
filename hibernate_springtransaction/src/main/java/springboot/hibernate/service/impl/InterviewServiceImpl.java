package springboot.hibernate.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.hibernate.dao.InterviewDAO;
import springboot.hibernate.entity.Interview;
import springboot.hibernate.service.InterviewService;

@Service("interviewService")
@Transactional
public class InterviewServiceImpl implements InterviewService
{
	@Autowired
	private InterviewDAO interviewDAO;

	@Override
	public void create(Interview interview)
	{
		// TODO Auto-generated method stub
		interviewDAO.create(interview);
	}

	@Override
	public void remove(Interview interview)
	{
		// TODO Auto-generated method stub
		interviewDAO.remove(interview);
	}

	@Override
	public void edit(Interview interview)
	{
		// TODO Auto-generated method stub
		interviewDAO.edit(interview);
	}

	@Override
	public List<Interview> findAll()
	{
		// TODO Auto-generated method stub
		return interviewDAO.findAll();
	}

	@Override
	public Interview find(int id)
	{
		// TODO Auto-generated method stub
		return interviewDAO.find(id);
	}

	@Override
	public List<Interview> viewAllInterview(int result, int offsetreal)
	{
		// TODO Auto-generated method stub
		return interviewDAO.viewAllInterview(result, offsetreal);
	}

	@Override
	public void save(Interview interview)
	{
		// TODO Auto-generated method stub
		interviewDAO.save(interview);
	}

	@Override
	public int getSize()
	{
		// TODO Auto-generated method stub
		return interviewDAO.getSize();
	}

	@Override
	public List<Interview> Weekly(boolean result, int quantity) {
		// TODO Auto-generated method stub
		return interviewDAO.Weekly(result, quantity);
	}

	@Override
	public List<Interview> Monthly(boolean result, int quantity) {
		// TODO Auto-generated method stub
		return interviewDAO.Monthly(result, quantity);
	}

	@Override
	public List<Interview> Quarterly(boolean result, int quantity) {
		// TODO Auto-generated method stub
		return interviewDAO.Quarterly(result, quantity);
	}

	@Override
	public List<Interview> fromDatetoDate(boolean result, Date from, Date to) {
		// TODO Auto-generated method stub
		return interviewDAO.fromDatetoDate(result, from, to);
	}

	@Override
	public List<Interview> UniName(String name) {
		// TODO Auto-generated method stub
		return interviewDAO.UniName(name);
	}

	@Override
	public List<Interview> GPA(float from, float to) {
		// TODO Auto-generated method stub
		return interviewDAO.GPA(from, to);
	}

	@Override
	public List<Interview> Faculty(String skill) {
		// TODO Auto-generated method stub
		return interviewDAO.Faculty(skill);
	}

	@Override
	public List<Interview> GraYear(String year) {
		// TODO Auto-generated method stub
		return interviewDAO.GraYear(year);
	}

	@Override
	public List<Interview> Toeic(int toeicfrom, int toeicto) {
		// TODO Auto-generated method stub
		return interviewDAO.Toeic(toeicfrom, toeicto);
	}

	@Override
	public List<Interview> Result(boolean result) {
		// TODO Auto-generated method stub
		return interviewDAO.Result(result);
	}

	@Override
	public List<Interview> Source(String source) {
		// TODO Auto-generated method stub
		return interviewDAO.Source(source);
	}

}
