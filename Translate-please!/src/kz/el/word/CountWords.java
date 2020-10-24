package kz.el.word;

public class CountWords {
	static WordModel model;
	static String countWords;

	
	public static int getIntCountWords() {
		model = new WordModel();
		int temp = model.getRowCount();
		return temp;
	}
	public static String getCountWords() {
		countWords = Integer.toString(getIntCountWords());
		return countWords;
	}
}
