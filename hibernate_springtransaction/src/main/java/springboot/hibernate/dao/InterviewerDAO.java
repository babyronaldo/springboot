package springboot.hibernate.dao;

import java.util.List;

import springboot.hibernate.entity.Interviewer;

public interface InterviewerDAO {
    public void create(Interviewer interviewer);

    public void remove(Interviewer interviewer);

    public void edit(Interviewer interviewer);

    public List<Interviewer> findAll();

    public Interviewer find(int id);

    public Interviewer findInterviewerbyUserName(String name);

}
