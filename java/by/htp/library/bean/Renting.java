package by.htp.library.bean;

public class Renting {

	private int idRent;
	private int idBook;
	private int idEmployee;
	private String nameBook;
	private String nameEmployee;
	private String emailEmployee;
	private long dateOnRenting;
	private String statusRenting;

	public int getIdRent() {
		return idRent;
	}

	public void setIdRent(int idRent) {
		this.idRent = idRent;
	}

	public int getIdBook() {
		return idBook;
	}

	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}

	public int getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}

	public String getNameBook() {
		return nameBook;
	}

	public void setNameBook(String nameBook) {
		this.nameBook = nameBook;
	}

	public String getNameEmployee() {
		return nameEmployee;
	}

	public void setNameEmployee(String nameEmployee) {
		this.nameEmployee = nameEmployee;
	}

	public String getEmailEmployee() {
		return emailEmployee;
	}

	public void setEmailEmployee(String emailEmployee) {
		this.emailEmployee = emailEmployee;
	}

	public long getDateOnRenting() {
		return dateOnRenting;
	}

	public void setDateOnRenting(long dateOnRenting) {
		this.dateOnRenting = dateOnRenting;
	}

	public String getStatusRenting() {
		return statusRenting;
	}

	public void setStatusRenting(String statusRenting) {
		this.statusRenting = statusRenting;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (dateOnRenting ^ (dateOnRenting >>> 32));
		result = prime * result + ((emailEmployee == null) ? 0 : emailEmployee.hashCode());
		result = prime * result + idBook;
		result = prime * result + idEmployee;
		result = prime * result + idRent;
		result = prime * result + ((nameBook == null) ? 0 : nameBook.hashCode());
		result = prime * result + ((nameEmployee == null) ? 0 : nameEmployee.hashCode());
		result = prime * result + ((statusRenting == null) ? 0 : statusRenting.hashCode());
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
		Renting other = (Renting) obj;
		if (dateOnRenting != other.dateOnRenting)
			return false;
		if (emailEmployee == null) {
			if (other.emailEmployee != null)
				return false;
		} else if (!emailEmployee.equals(other.emailEmployee))
			return false;
		if (idBook != other.idBook)
			return false;
		if (idEmployee != other.idEmployee)
			return false;
		if (idRent != other.idRent)
			return false;
		if (nameBook == null) {
			if (other.nameBook != null)
				return false;
		} else if (!nameBook.equals(other.nameBook))
			return false;
		if (nameEmployee == null) {
			if (other.nameEmployee != null)
				return false;
		} else if (!nameEmployee.equals(other.nameEmployee))
			return false;
		if (statusRenting == null) {
			if (other.statusRenting != null)
				return false;
		} else if (!statusRenting.equals(other.statusRenting))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Renting [idRent=" + idRent + ", idBook=" + idBook + ", idEmployee=" + idEmployee + ", nameBook="
				+ nameBook + ", nameEmployee=" + nameEmployee + ", emailEmployee=" + emailEmployee + ", dateOnRenting="
				+ dateOnRenting + ", statusRenting=" + statusRenting + "]";
	}

}
