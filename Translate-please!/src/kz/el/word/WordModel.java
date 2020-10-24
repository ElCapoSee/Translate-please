package kz.el.word;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import kz.el.Main;
import kz.el.readwrite.WriteFile;

public class WordModel implements TableModel {
	private ArrayList<TableModelListener> listener;

	public WordModel() {
		listener = new ArrayList<>();
	}
	
	@Override
	public void addTableModelListener(TableModelListener l) {
		listener.add(l);
		
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}
	
	@Override
	public int getColumnCount() {
		return 2;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		String return_string = "";
		switch(columnIndex) {
		case 0:
			return_string = "English";
			break;
		case 1:
			return_string = "Russian";
			break;
		}
		return return_string;
	}

	@Override
	public int getRowCount() {
		return Main.words.size();
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object return_object = null;
		switch(columnIndex) {
		case 0:
			return_object =  Main.words.get(rowIndex).getEnglish();
			break;
		case 1:
			return_object =  Main.words.get(rowIndex).getRussian();
			break;
		}
		return return_object;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		WriteFile write = new WriteFile();
		switch(columnIndex) {
		case 0:
			Main.words.get(rowIndex).setEnglish((String) aValue);
			break;
		case 1:
			Main.words.get(rowIndex).setRussian((String) aValue);
			break;
		}
		try {
			write.writeToFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		listener.remove(l);
		
	}
}
