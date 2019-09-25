package springboot.hibernate.entity;

import javax.persistence.Entity;

import org.hibernate.validator.constraints.NotEmpty;

public class ChangePass {
	private int id;
	private String Username;

	private String NewPass;

	private String ReNewPass;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	@NotEmpty
	public String getNewPass() {
		return NewPass;
	}

	public void setNewPass(String newPass) {
		NewPass = newPass;
	}

	@NotEmpty
	public String getReNewPass() {
		return ReNewPass;
	}

	public void setReNewPass(String reNewPass) {
		ReNewPass = reNewPass;
	}

	public ChangePass(int id, String username, String newPass, String reNewPass) {
		super();
		this.id = id;
		Username = username;
		NewPass = newPass;
		ReNewPass = reNewPass;
	}

	public ChangePass() {
		super();
	}

}
