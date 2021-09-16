package application;

public class Book {
	private int id;
	private String title;
	private String authorName;
	private double average_rating;
	private long isbn;
	private String language_code;
	private int num_pages;
	private String publishDate;
	private String publisher;
	
	public Book() {
		super();
	}
	public Book(int id, String title, String authorName, double average_rating, long isbn, String language_code,
			int num_pages, String publishDate, String publisher) {
		super();
		this.id = id;
		this.title = title;
		this.authorName = authorName;
		this.average_rating = average_rating;
		this.isbn = isbn;
		this.language_code = language_code;
		this.num_pages = num_pages;
		this.publishDate = publishDate;
		this.publisher = publisher;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public double getAverage_rating() {
		return average_rating;
	}
	public void setAverage_rating(double average_rating) {
		this.average_rating = average_rating;
	}
	public long getIsbn() {
		return isbn;
	}
	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}
	public String getLanguage_code() {
		return language_code;
	}
	public void setLanguage_code(String language_code) {
		this.language_code = language_code;
	}
	public int getNum_pages() {
		return num_pages;
	}
	public void setNum_pages(int num_pages) {
		this.num_pages = num_pages;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String commaSeperate() {
		return id + "," + title + "," + authorName + ","
				+ average_rating + "," + isbn + "," + language_code + "," + num_pages
				+ "," + publishDate + "," + publisher + "\n";
	}
	@Override
	public String toString() {
		return "Book:\nId:" + id + "\nTitle:" + title + "\nAuthorName=" + authorName + "\nAverage Rating:"
				+ average_rating + "\nISBN:" + isbn + "\nLanguage code=" + language_code + "\nTotal Page=" + num_pages
				+ "\nPublished Date=" + publishDate + "\nPublisher:" + publisher + "\n";
	}
}
