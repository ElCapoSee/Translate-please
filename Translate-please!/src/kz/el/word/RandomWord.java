package kz.el.word;

public class RandomWord {

	static WordModel model = new WordModel();
	
	private static String engWord = "";
	private static String rusWord = "";
	
	public static String getEngWord() {
		return engWord;

	}
	public static void setEngWord(String EngWord) {
		engWord = EngWord;
	}
	public static String getRusWord() {
		return rusWord;
	}
	public static void setRusWord(String RusWord) {
		rusWord = RusWord;
	}
	
	public static void setRandomEngRusWords() {
		int rowEng = model.getRowCount();
		int indexEngWord = (int) ( Math.random() * rowEng);
		String randomEngWord = String.valueOf(model.getValueAt(indexEngWord, 0));	
		int rowRus = model.getRowCount();
		int indexRusWord = (int) ( Math.random() * rowRus);
		String randomRusWord = String.valueOf(model.getValueAt(indexRusWord, 1));
		setEngWord(randomEngWord);
		setRusWord(randomRusWord);
	}

	public static void getRandomEngWord() {
		int row = model.getRowCount();
		int indexWord = (int) ( Math.random() * row);
		String randomWord = String.valueOf(model.getValueAt(indexWord, 0));
		String randomRusWord = String.valueOf(model.getValueAt(indexWord, 1));
		setEngWord(randomWord);
		setRusWord(randomRusWord);
	}
	public static void getRandomRusWord() {
		int row = model.getRowCount();
		int indexWord = (int) ( Math.random() * row);
		String randomWord = String.valueOf(model.getValueAt(indexWord, 1));
		String randomEngWord = String.valueOf(model.getValueAt(indexWord, 0));
		setRusWord(randomWord);
		setEngWord(randomEngWord);


	}
}


