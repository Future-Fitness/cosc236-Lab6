package lab5;

public class PaperBookCreator extends BookFactory{

	@Override
	public Book createBook(String title) {
		return new PaperBook(title);
	}
	
}