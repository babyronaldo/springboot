package springboot.hibernate.dao;

import java.util.List;

import springboot.hibernate.entity.Candidate;

public interface CandidateDAO {
    public void create(Candidate candidate);

    public void remove(Candidate candidate);

    public void edit(Candidate candidate);

    public List<Candidate> findAll();

    public List<Candidate> findByInterviewID(int id);

    public Candidate find(int id);

    public List<Candidate> viewAllCandidate(int result, int offsetreal);

    void save(Candidate candidate);

    int getSize();
}
