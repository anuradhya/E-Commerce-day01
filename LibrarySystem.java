class Book{
	private String title;
	private String author;
	private int year;
	
	public Book(String title,String author,int year){
		this.title=title;
		this.author=author;
		this.year=year;
	}
	
	public String getTitle(){
		return title;
	}
	public void setTitle(String Title){
		this.title=title;
	}
	public String getAuthor(){
		return author;
	}
	public void setAuthor(String author){
		this.author=author;
	}
	public int getYear(){
		return year;
	}
	public void setYear(int year){
		this.year=year;
	}
	
	public void displayInfo(){
		System.out.println("Title: "+title);
		System.out.println("Author: "+author);
		System.out.println("Year: "+year);
	}
	
}

class PrintedBook extends Book{
	private String isbn;
	
	public PrintedBook(String title,String author,int year,String isbn){
		super(title,author,year);
		this.isbn=isbn;
	}
	public String getIsbn(){
		return isbn;
	}
	public void setIsbn(String isbn){
		this.isbn=isbn;
	}
	
	@Override
	public void displayInfo(){
		super.displayInfo();
		System.out.println("ISBN: "+isbn);
	}
}

class EBook extends Book{
	private String ebook;
	
	public PrintedBook(String title,String author,int year,String ebook){
		super(title,author,year);
		this.ebook=ebook;
	}
	public String getEbook(){
		return ebook;
	}
	public void setEbook(String ebook){
		this.ebook=ebook;
	}
	
	@Override
	public void displayInfo(){
		super.sidplayInfo();
		System.out.println("EBOOK: "+ebook);
	}
}
	
class AudioBooks extends Book{
	private String aubook;
	
	public AudioBook(String title,String author,int year,String aubook){
		super(title,author,year);
		this.aubook=aubook;
	}
	public String getEbook(){
		return aubook;
	}
	public void setAubook(String aubook){
		this.aubook=aubook;
	}
	
	@Override
	public void displayInfo(){
		super.sidplayInfo();
		System.out.println("AUTHORBOOK: "+aubook);
	}
}

class Library{
	private Book[] books;
	private int count;
	
	public Library(int size){
		books=new Book[size];
		count=0;
	}
	public void addBook(Book book){
		if(count<books.length){
			books[count]=book;
			count++;
		}
		else{
			System.out.println("Library is full");
		}
	}
	public void displayBooks(){
		for(int i=0; i<count; i++){
			books[i].displayInfo();
			System.out.print("-------------------");
		}
	}
}
public class LibrarySystem{
	public static void main(String[] args){
		PrintedBook printedbook=new PrintedBook("Gamperaliya","Martin Wickramasinghe",1925,"125-568");
		EBook ebook=new EBook("Digital Marketing","Neil Patel",2020,"PDF");
		AudioBook audiobook=new AudioBook("Heensare","Kumarathunga Munidasa",1958,10.5);
		
		Library library=new Library(5);
		library.addBook(printedBook);
		library.addBook(eBook);
		library.addBook(audioBook);
		
		library.displayAllBooks();
	}
}
			
	