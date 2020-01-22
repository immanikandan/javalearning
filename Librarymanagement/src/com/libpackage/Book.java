package com.libpackage;

public class Book {
	private int sN0;
	private String bookName;
	private String authorName;
	private int publishedYear;
	public int getsN0() {
		return sN0;
	}
	public void setsN0(int sN0) {
		this.sN0 = sN0;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public int getPublishedYear() {
		return publishedYear;
	}
	public void setPublishedYear(int publishedYear) {
		this.publishedYear = publishedYear;
	}
}