package by.htp.library.service.model;

public class IssueBook {

	private int idIssue;
	private int idEmployee;
	private String nameEmployee;
	private int idBook;
	private String nameBook;
	private long dateOn;
	private long dateOff;
	private String status;
	private int countDay;

	public int getIdIssue() {
		return idIssue;
	}

	public void setIdIssue(int idIssue) {
		this.idIssue = idIssue;
	}

	public int getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}

	public String getNameEmployee() {
		return nameEmployee;
	}

	public void setNameEmployee(String nameEmployee) {
		this.nameEmployee = nameEmployee;
	}

	public int getIdBook() {
		return idBook;
	}

	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}

	public String getNameBook() {
		return nameBook;
	}

	public void setNameBook(String nameBook) {
		this.nameBook = nameBook;
	}

	public long getDateOn() {
		return dateOn;
	}

	public void setDateOn(long dateOn) {
		this.dateOn = dateOn;
	}

	public long getDateOff() {
		return dateOff;
	}

	public void setDateOff(long dateOff) {
		this.dateOff = dateOff;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCountDay() {
		return countDay;
	}

	public void setCountDay(int countDay) {
		this.countDay = countDay;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + countDay;
		result = prime * result + (int) (dateOff ^ (dateOff >>> 32));
		result = prime * result + (int) (dateOn ^ (dateOn >>> 32));
		result = prime * result + idBook;
		result = prime * result + idEmployee;
		result = prime * result + idIssue;
		result = prime * result + ((nameBook == null) ? 0 : nameBook.hashCode());
		result = prime * result + ((nameEmployee == null) ? 0 : nameEmployee.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		IssueBook other = (IssueBook) obj;
		if (countDay != other.countDay)
			return false;
		if (dateOff != other.dateOff)
			return false;
		if (dateOn != other.dateOn)
			return false;
		if (idBook != other.idBook)
			return false;
		if (idEmployee != other.idEmployee)
			return false;
		if (idIssue != other.idIssue)
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
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "IssueBook [idIssue=" + idIssue + ", idEmployee=" + idEmployee + ", nameEmployee=" + nameEmployee
				+ ", idBook=" + idBook + ", nameBook=" + nameBook + ", dateOn=" + dateOn + ", dateOff=" + dateOff
				+ ", status=" + status + ", countDay=" + countDay + "]";
	}

}
