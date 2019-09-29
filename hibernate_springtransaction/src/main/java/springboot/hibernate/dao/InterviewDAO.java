package springboot.hibernate.dao;

import java.util.Date;
import java.util.List;

import springboot.hibernate.entity.Interview;

public interface InterviewDAO {
    public void create(Interview interview);

    public void remove(int id);

    public void edit(Interview interview);

    public List<Interview> findAll();

    // public List<Interview> findByInterviewID(int id);

    public Interview find(int id);

    public List<Interview> viewAllInterview(int result, int offsetreal);

    void save(Interview interview);

    int getSize();

    //query
    public List<Interview> Weekly(boolean result, int quantity);

    public List<Interview> Monthly(boolean result, int quantity);

    public List<Interview> Quarterly(boolean result, int quantity);

    public List<Interview> fromDatetoDate(boolean result, Date from, Date to);

    //query2
    public List<Interview> UniName(String name);

    public List<Interview> GPA(float from, float to);

    public List<Interview> Faculty(String skill);

    public List<Interview> GraYear(String year);

    public List<Interview> Toeic(int toeicfrom, int toeicto);

    public List<Interview> Result(boolean result);

    public List<Interview> Source(String source);

}
