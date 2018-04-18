package by.htp.library.bean;

public class BookAdditionalInfo {

	private int idBook;
	private String discriptionBook;
	private String nameImgBook;
	

	public int getIdBook() {
		return idBook;
	}

	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}

	public String getDiscriptionBook() {
		return discriptionBook;
	}

	public void setDiscriptionBook(String discriptionBook) {
		this.discriptionBook = discriptionBook;
	}

	public String getNameImgBook() {
		return nameImgBook;
	}

	public void setNameImgBook(String nameImgBook) {
		this.nameImgBook = nameImgBook;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((discriptionBook == null) ? 0 : discriptionBook.hashCode());
		result = prime * result + idBook;
		result = prime * result + ((nameImgBook == null) ? 0 : nameImgBook.hashCode());
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
		BookAdditionalInfo other = (BookAdditionalInfo) obj;
		if (discriptionBook == null) {
			if (other.discriptionBook != null)
				return false;
		} else if (!discriptionBook.equals(other.discriptionBook))
			return false;
		if (idBook != other.idBook)
			return false;
		if (nameImgBook == null) {
			if (other.nameImgBook != null)
				return false;
		} else if (!nameImgBook.equals(other.nameImgBook))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BookAdditionalInfo [idBook=" + idBook + ", discriptionBook=" + discriptionBook + ", nameImgBook="
				+ nameImgBook + "]";
	}

}
