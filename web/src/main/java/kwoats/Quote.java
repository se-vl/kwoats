package kwoats;

public class Quote {
	private String text;
	private String author;
	private int year;

	public Quote() {
	}

	public Quote(String text, String author, int year) {
		this.text = text;
		this.author = author;
		this.year = year;
	}

	public String getText() {
		return text;
	}

	public String getAuthor() {
		return author;
	}

	public int getYear() {
		return year;
	}
}
