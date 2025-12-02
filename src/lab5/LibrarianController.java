package lab5;

public class LibrarianController {
	
	private Library library; // Library dependency
	PaperBookCreator paperBookFactory;
	EBookCreator eBookFactory;
	AudioBookCreator audioBookFactory;
	private BorrowingService borrowingService;
	
	public LibrarianController( ) {
		this.library = new Library(); // Constructor injection
		this.paperBookFactory = new PaperBookCreator();
		this.eBookFactory = new EBookCreator();
		this.audioBookFactory = new AudioBookCreator();
		this.borrowingService = BorrowingService.getInstance();
	}
	public Library getLibrary() {
		return this.library;
	}
	public void showBooks() {
		library.showBooks();
	}
	public void showMembers() {
		library.showMembers();
	}
	public void addPaperBook(String title) {
		//library.addBook(new PaperBook(title));  // Book class constructor dependency
		addBook(paperBookFactory, title);
	}
	public void addEbook(String title) {
		//library.addBook(new Ebook(title));  // Book class constructor dependency
		addBook(eBookFactory, title);
	}
	public void addAudioBook(String title) {
		//library.addBook(new AudioBook(title));  // Book class constructor dependency
		addBook(audioBookFactory, title);
	}
	public void addMember(String name) {
		library.addMember(new Member(name, borrowingService));
//		library.addMember(new Member(name)); // Member class constructor dependency
	}
	public void removeBook(String title) {
		library.removeBook(title); // remove 
	}
	public void removeMember(String name) {
		library.removeMember(name);
	}
	public void showMember(String name) {
		Member member = library.findMemberByName(name);
		if (member != null)
			System.out.println(member);
		else 
			System.out.println("Member " + name + " not found.");
	}
	public void showBook(String title) {
		Book book = library.findBookByTitle(title);
		if (book != null)
			System.out.println(book);
		else 
			System.out.println("Book " + title + " not found.");
	}
	public void showMemberBooks(String name) {
		Member member = library.findMemberByName(name);
		if (member != null)
			member.listBorrowedBooks();
		else 
			System.out.println("Member " + name + " not found.");
	}
	
	public void borrowBookByMember(String title, String name) {
		Member member = library.findMemberByName(name); // use library for search
		Book book = library.findBookByTitle(title);  // use library for search
		if (book != null && member != null)
			member.borrowBook(book); // member borrows a book, not library 
		else 	
			System.out.println("Either book " + title + " or member " + name + " not found.");
	}
	
	public void returnBookByMember(String title, String name) {
		Member member = library.findMemberByName(name); // use library for search
		Book book = library.findBookByTitle(title); // use library for search 
		if (book != null && member != null)
			member.returnBook(book); // members returns book. 
		else  	
			System.out.println("Either book " + title + " or member " + name + " not found.");
	}
	
	public void addBook(BookFactory factory, String title) {
		library.addBook(factory.createBook(title));
	}
}
