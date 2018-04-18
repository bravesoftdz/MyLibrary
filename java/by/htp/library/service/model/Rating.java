package by.htp.library.service.model;

public class Rating {

	private int idBook;
	private String nameBook;
	private int cntBook;
	private int cntIssue;
	private double rating;

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

	public int getCntBook() {
		return cntBook;
	}

	public void setCntBook(int cntBook) {
		this.cntBook = cntBook;
	}

	public int getCntIssue() {
		return cntIssue;
	}

	public void setCntIssue(int cntIssue) {
		this.cntIssue = cntIssue;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cntBook;
		result = prime * result + cntIssue;
		result = prime * result + idBook;
		result = prime * result + ((nameBook == null) ? 0 : nameBook.hashCode());
		long temp;
		temp = Double.doubleToLongBits(rating);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Rating other = (Rating) obj;
		if (cntBook != other.cntBook)
			return false;
		if (cntIssue != other.cntIssue)
			return false;
		if (idBook != other.idBook)
			return false;
		if (nameBook == null) {
			if (other.nameBook != null)
				return false;
		} else if (!nameBook.equals(other.nameBook))
			return false;
		if (Double.doubleToLongBits(rating) != Double.doubleToLongBits(other.rating))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Rating [idBook=" + idBook + ", nameBook=" + nameBook + ", cntBook=" + cntBook + ", cntIssue=" + cntIssue
				+ ", rating=" + rating + "]";
	}

}
