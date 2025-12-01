package lab5;

public class EBookCreator extends BookFactory{

	@Override
	public Book createBook(String title) {
		return new Ebook(title);
	}

}
