package lab5;

public class AudioBookCreator extends BookFactory{

	@Override
	public Book createBook(String title) {
		return new AudioBook(title);
	}

}
