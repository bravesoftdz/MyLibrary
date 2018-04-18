package by.htp.library.service.model;

public class CountBookRead {

	private int idBook;
	private String nameBook;
	private int dateOn;
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
	public int getDateOn() {
		return dateOn;
	}
	public void setDateOn(int dateOn) {
		this.dateOn = dateOn;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dateOn;
		result = prime * result + idBook;
		result = prime * result + ((nameBook == null) ? 0 : nameBook.hashCode());
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
		CountBookRead other = (CountBookRead) obj;
		if (dateOn != other.dateOn)
			return false;
		if (idBook != other.idBook)
			return false;
		if (nameBook == null) {
			if (other.nameBook != null)
				return false;
		} else if (!nameBook.equals(other.nameBook))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CountBookRead [idBook=" + idBook + ", nameBook=" + nameBook + ", dateOn=" + dateOn + "]";
	}
	
	
	
}
