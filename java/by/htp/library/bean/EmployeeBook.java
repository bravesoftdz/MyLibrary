package by.htp.library.bean;

public class EmployeeBook {

	private int id;
	private long dateTimeOn;
	private int bookId;
	private int employeeId;
	private long dateTimeReturn;
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getDateTimeOn() {
		return dateTimeOn;
	}

	public void setDateTimeOn(long dateTimeOn) {
		this.dateTimeOn = dateTimeOn;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public long getDateTimeReturn() {
		return dateTimeReturn;
	}

	public void setDateTimeReturn(long dateTimeReturn) {
		this.dateTimeReturn = dateTimeReturn;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bookId;
		result = prime * result + (int) (dateTimeOn ^ (dateTimeOn >>> 32));
		result = prime * result + (int) (dateTimeReturn ^ (dateTimeReturn >>> 32));
		result = prime * result + employeeId;
		result = prime * result + id;
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
		EmployeeBook other = (EmployeeBook) obj;
		if (bookId != other.bookId)
			return false;
		if (dateTimeOn != other.dateTimeOn)
			return false;
		if (dateTimeReturn != other.dateTimeReturn)
			return false;
		if (employeeId != other.employeeId)
			return false;
		if (id != other.id)
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
		return "EmployeeBook [id=" + id + ", dateTimeOn=" + dateTimeOn + ", bookId=" + bookId + ", employeeId="
				+ employeeId + ", dateTimeReturn=" + dateTimeReturn + ", status=" + status + "]";
	}

}
