package springboot.hibernate.entity;

public class CandidateReport {

	private String filterType;
	private boolean result;
	private String uniName;
	private float gpafrom;
	private float gpato;
	private String skill;
	private String year;
	private int toeicfrom;
	private int toeicto;
	private String source;
	
	
	
	
	public CandidateReport() {
		super();
	}
	public CandidateReport(String filterType, boolean result, String uniName, float gpafrom, float gpato, String skill,
			String year, int toeicfrom, int toeicto, String source) {
		super();
		this.filterType = filterType;
		this.result = result;
		this.uniName = uniName;
		this.gpafrom = gpafrom;
		this.gpato = gpato;
		this.skill = skill;
		this.year = year;
		this.toeicfrom = toeicfrom;
		this.toeicto = toeicto;
		this.source = source;
	}
	public String getFilterType() {
		return filterType;
	}
	public void setFilterType(String filterType) {
		this.filterType = filterType;
	}
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public String getUniName() {
		return uniName;
	}
	public void setUniName(String uniName) {
		this.uniName = uniName;
	}
	public float getGpafrom() {
		return gpafrom;
	}
	public void setGpafrom(float gpafrom) {
		this.gpafrom = gpafrom;
	}
	public float getGpato() {
		return gpato;
	}
	public void setGpato(float gpato) {
		this.gpato = gpato;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public int getToeicfrom() {
		return toeicfrom;
	}
	public void setToeicfrom(int toeicfrom) {
		this.toeicfrom = toeicfrom;
	}
	public int getToeicto() {
		return toeicto;
	}
	public void setToeicto(int toeicto) {
		this.toeicto = toeicto;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	
	
	
	
	
}
