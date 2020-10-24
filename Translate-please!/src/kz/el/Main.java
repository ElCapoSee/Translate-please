package kz.el;

import java.util.ArrayList;
import kz.el.window.MainWindow;
import kz.el.word.Word;

public class Main {
	public static ArrayList<Word> words = new ArrayList<>();

	public static void main(String[] args) {
		new MainWindow();
	}

}
