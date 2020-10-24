package kz.el.readwrite;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import kz.el.Main;
import kz.el.word.Word;

public class ReadFile {
	public static ArrayList<String> readFiles = new ArrayList<>();
	public static WriteFile fileName = new WriteFile();
	public final static String FOOD = "Food";
	public final static String TRANSPORT = "Transport";
	public final static String CLOTHES = "Clothes";
	public final static String NEEDFUL = "Needful";
	public final static String OTHER = "Other";
	private static Scanner scan;

	public static void readFromFile() throws Exception {
		readFiles.clear();
		FileReader fr = new FileReader(fileName.getFileNameTxt());
		scan = new Scanner(fr);
		String result = null;
		while (scan.hasNextLine()) {
			result = scan.nextLine();
			if (result == null) {
				return;
			}
		}
		for (String cut : result.split("`")) {
			readFiles.add(cut);

		}
		fr.close();
		scan.close();
	}

	public static void readValue(int a) {
		if (readFiles.size() > 0) {
			int k = a;
			Word word = new Word();
			word.setEnglish(readFiles.get(k));
			k++;
			word.setRussian(readFiles.get(k));
			Main.words.add(word);
		}
	}

	public static void upload() {
		int k = 0;
		for (int i = 0; i < readFiles.size() / 2; i++) {
			ReadFile.readValue(k);
			k += 2;
		}
	}
}
