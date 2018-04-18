package by.htp.library.bean;

public class Employee {

	private int id;
	private String name;
	private long dateBirth;
	private String email;
	private String userLoggin;
	private String userPassword;
	private String satatusAdmin;
	private String photoEmployee;
	private String tellNumber;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(long dateBirth) {
		this.dateBirth = dateBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserLoggin() {
		return userLoggin;
	}

	public void setUserLoggin(String userLoggin) {
		this.userLoggin = userLoggin;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getSatatusAdmin() {
		return satatusAdmin;
	}

	public void setSatatusAdmin(String satatusAdmin) {
		this.satatusAdmin = satatusAdmin;
	}

	public String getPhotoEmployee() {
		return photoEmployee;
	}

	public void setPhotoEmployee(String photoEmployee) {
		this.photoEmployee = photoEmployee;
	}

	public String getTellNumber() {
		return tellNumber;
	}

	public void setTellNumber(String tellNumber) {
		this.tellNumber = tellNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (dateBirth ^ (dateBirth >>> 32));
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((photoEmployee == null) ? 0 : photoEmployee.hashCode());
		result = prime * result + ((satatusAdmin == null) ? 0 : satatusAdmin.hashCode());
		result = prime * result + ((tellNumber == null) ? 0 : tellNumber.hashCode());
		result = prime * result + ((userLoggin == null) ? 0 : userLoggin.hashCode());
		result = prime * result + ((userPassword == null) ? 0 : userPassword.hashCode());
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
		Employee other = (Employee) obj;
		if (dateBirth != other.dateBirth)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (photoEmployee == null) {
			if (other.photoEmployee != null)
				return false;
		} else if (!photoEmployee.equals(other.photoEmployee))
			return false;
		if (satatusAdmin == null) {
			if (other.satatusAdmin != null)
				return false;
		} else if (!satatusAdmin.equals(other.satatusAdmin))
			return false;
		if (tellNumber == null) {
			if (other.tellNumber != null)
				return false;
		} else if (!tellNumber.equals(other.tellNumber))
			return false;
		if (userLoggin == null) {
			if (other.userLoggin != null)
				return false;
		} else if (!userLoggin.equals(other.userLoggin))
			return false;
		if (userPassword == null) {
			if (other.userPassword != null)
				return false;
		} else if (!userPassword.equals(other.userPassword))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dateBirth=" + dateBirth + ", email=" + email
				+ ", userLoggin=" + userLoggin + ", userPassword=" + userPassword + ", satatusAdmin=" + satatusAdmin
				+ ", photoEmployee=" + photoEmployee + ", tellNumber=" + tellNumber + "]";
	}

}
