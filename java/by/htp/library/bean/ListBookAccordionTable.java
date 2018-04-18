package by.htp.library.bean;

public class ListBookAccordionTable {

	private int idEmployee;
	private int idBook;
	private String brief;
	private long dateOn;

	public int getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}

	public int getIdBook() {
		return idBook;
	}

	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public long getDateOn() {
		return dateOn;
	}

	public void setDateOn(long dateOn) {
		this.dateOn = dateOn;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brief == null) ? 0 : brief.hashCode());
		result = prime * result + (int) (dateOn ^ (dateOn >>> 32));
		result = prime * result + idBook;
		result = prime * result + idEmployee;
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
		ListBookAccordionTable other = (ListBookAccordionTable) obj;
		if (brief == null) {
			if (other.brief != null)
				return false;
		} else if (!brief.equals(other.brief))
			return false;
		if (dateOn != other.dateOn)
			return false;
		if (idBook != other.idBook)
			return false;
		if (idEmployee != other.idEmployee)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AccordionListBook [idEmployee=" + idEmployee + ", idBook=" + idBook + ", brief=" + brief + ", dateOn="
				+ dateOn + "]";
	}

}
