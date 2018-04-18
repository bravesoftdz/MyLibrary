package by.htp.library.bean;

public class BookCountReadEmployee {

	private int kodeEmployee;
	private String nameEmployee;
	private int countBook;
	private int dateBirth;

	public int getKodeEmployee() {
		return kodeEmployee;
	}

	public void setKodeEmployee(int kodeEmployee) {
		this.kodeEmployee = kodeEmployee;
	}

	public String getNameEmployee() {
		return nameEmployee;
	}

	public void setNameEmployee(String nameEmployee) {
		this.nameEmployee = nameEmployee;
	}

	public int getCountBook() {
		return countBook;
	}

	public void setCountBook(int countBook) {
		this.countBook = countBook;
	}

	public int getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(int dateBirth) {
		this.dateBirth = dateBirth;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + countBook;
		result = prime * result + dateBirth;
		result = prime * result + kodeEmployee;
		result = prime * result + ((nameEmployee == null) ? 0 : nameEmployee.hashCode());
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
		BookCountReadEmployee other = (BookCountReadEmployee) obj;
		if (countBook != other.countBook)
			return false;
		if (dateBirth != other.dateBirth)
			return false;
		if (kodeEmployee != other.kodeEmployee)
			return false;
		if (nameEmployee == null) {
			if (other.nameEmployee != null)
				return false;
		} else if (!nameEmployee.equals(other.nameEmployee))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EmployeeBookFirstReport [kodeEmployee=" + kodeEmployee + ", nameEmployee=" + nameEmployee
				+ ", countBook=" + countBook + ", dateBirth=" + dateBirth + "]";
	}

}
