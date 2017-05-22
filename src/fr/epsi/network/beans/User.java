package fr.epsi.network.beans;


public class User {

	private String id;
	private String password;
	private Boolean administrator;
	
	public User(){
		super();
	}
	
	public User(String id, String password, Boolean administrator) {
		super();
		this.id = id;
		this.password = password;
		this.administrator = administrator;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getAdministrator() {
		return administrator;
	}
	public void setAdministrator(Boolean administrator) {
		this.administrator = administrator;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", administrator=" + administrator + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((administrator == null) ? 0 : administrator.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (administrator == null) {
			if (other.administrator != null)
				return false;
		} else if (!administrator.equals(other.administrator))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
	
	
	
	
	
}
