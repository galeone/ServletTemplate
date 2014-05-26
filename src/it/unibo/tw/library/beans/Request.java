package it.unibo.tw.library.beans;

import java.io.Serializable;

public class Request implements Serializable {

	private static final long serialVersionUID = 1L;
	private String cf, surname, title, returnDate, collectionDate;
	
	public Request(String cf , String surname, String title, String returnDate, String collectionDate) {
		setCf(cf);
		setSurname(surname);
		setTitle(title);
		setReturnDate(returnDate);
		setCollectionDate(collectionDate);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cf == null) ? 0 : cf.hashCode());
		result = prime * result
				+ ((collectionDate == null) ? 0 : collectionDate.hashCode());
		result = prime * result
				+ ((returnDate == null) ? 0 : returnDate.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Request other = (Request) obj;
		if (cf == null) {
			if (other.cf != null)
				return false;
		} else if (!cf.equals(other.cf))
			return false;
		if (collectionDate == null) {
			if (other.collectionDate != null)
				return false;
		} else if (!collectionDate.equals(other.collectionDate))
			return false;
		if (returnDate == null) {
			if (other.returnDate != null)
				return false;
		} else if (!returnDate.equals(other.returnDate))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public String getCollectionDate() {
		return collectionDate;
	}

	public void setCollectionDate(String collectionDate) {
		this.collectionDate = collectionDate;
	}
}
