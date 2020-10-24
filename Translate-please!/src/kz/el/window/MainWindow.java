package kz.el.window;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import kz.el.Main;
import kz.el.readwrite.ReadFile;
import kz.el.readwrite.WriteFile;
import kz.el.word.CountWords;
import kz.el.word.RandomWord;
import kz.el.word.Word;
import kz.el.word.WordModel;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import java.awt.HeadlessException;

import javax.swing.JPanel;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class MainWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private WordModel model;
	private JTable table;
	private JTextField textCountWords;
	public WriteFile write;
	private JTextField textGetWord;
	private JTextField textSetWord;
	public TranslateWindow response;
	public RandomWord randomWord;
	public int height;
	public int width;

	public MainWindow() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\El\\Downloads\\globe_geography_global_international_education_icon_141976.png"));
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		height = screenSize.height;
		width = screenSize.width;
		setSize(575, 440);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Translate, please!");
		setLocationRelativeTo(null);
		setSize(575, 437);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 40, 569, 406);
		getContentPane().add(tabbedPane);
		
		JPanel translate = new JPanel();
		tabbedPane.addTab("Translate", null, translate, null);
		translate.setLayout(null);
		
		textGetWord = new JTextField();
		textGetWord.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textGetWord.setEditable(false);
		textGetWord.setBounds(171, 63, 174, 39);
		translate.add(textGetWord);
		textGetWord.setColumns(10);
		
		JLabel lblTranslatePlease = new JLabel("Translate, please!");
		lblTranslatePlease.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTranslatePlease.setBounds(171, 26, 149, 26);
		translate.add(lblTranslatePlease);
		
		textSetWord = new JTextField();
		textSetWord.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textSetWord.setBounds(171, 158, 174, 39);
		translate.add(textSetWord);
		textSetWord.setColumns(10);
		
		JLabel lblYourOption = new JLabel("Your option:");
		lblYourOption.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblYourOption.setBounds(171, 121, 149, 26);
		translate.add(lblYourOption);
		
		JLabel lblSuccessScore = new JLabel();
		lblSuccessScore.setForeground(new Color(0, 128, 0));
		lblSuccessScore.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSuccessScore.setBounds(478, 198, 46, 29);
		
		JLabel lblErrorScore = new JLabel();
		lblErrorScore.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblErrorScore.setForeground(new Color(255, 0, 0));
		lblErrorScore.setBounds(478, 238, 46, 27);
		tabbedPane.setEnabledAt(0, true);
		
		JLabel lblResult = new JLabel("",SwingConstants.CENTER);
		lblResult.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblResult.setBounds(220, 208, 59, 23);
		lblResult.setText(TranslateWindow.getRESPONSE());
		
		

		
		
		translate.add(lblResult);
		translate.add(lblSuccessScore);
		translate.add(lblErrorScore);
		
		JRadioButton rdbtnEngRus = new JRadioButton("Eng-Rus");
		rdbtnEngRus.setSelected(true);
		rdbtnEngRus.setBounds(462, 16, 89, 23);
		translate.add(rdbtnEngRus);
		
		JRadioButton rdbtnRusEng = new JRadioButton("Rus-Eng");
		rdbtnRusEng.setBounds(462, 42, 89, 23);
		translate.add(rdbtnRusEng);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnEngRus);
		group.add(rdbtnRusEng);
		

		
		JPanel words = new JPanel();
		tabbedPane.addTab("Words", null, words, null);
		words.setLayout(null);
		
		model = new WordModel();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 380, 262);
		words.add(scrollPane);
		table = new JTable(model);
		scrollPane.setViewportView(table);
	
		
		JButton btnNewAdd = new JButton("add");
		btnNewAdd.setBounds(465, 11, 89, 23);
		words.add(btnNewAdd);
		btnNewAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Word word = new Word();
				WriteFile fileName = new WriteFile();
				FileWriter nFile = null;
				try {
					nFile = new FileWriter(fileName.getFileNameTxt(), true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					nFile.write(JOptionPane.showInputDialog("Enter an english word: "));
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					nFile.write("`");
				} catch (IOException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				try {
					nFile.write(JOptionPane.showInputDialog("Enter an russian word: "));
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					nFile.write("`");
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					nFile.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// check.setContent((String) response);
				try {
					ReadFile.readFromFile();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				word.setEnglish(ReadFile.readFiles.get(ReadFile.readFiles.size() - 2));
				word.setRussian(ReadFile.readFiles.get(ReadFile.readFiles.size() - 1));
				Main.words.add(word);
				textCountWords.setText(CountWords.getCountWords());
				table.updateUI();
			}
		});
		
		JButton btnNewRemove = new JButton("remove");
		btnNewRemove.setBounds(465, 45, 89, 23);
		words.add(btnNewRemove);
		btnNewRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WriteFile write = new WriteFile();
				if (table.getSelectedRow() == -1 || Main.words.size() <= 0) {
					return;
				}
				Main.words.remove(table.getSelectedRow());
				try {
					write.writeToFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textCountWords.setText(CountWords.getCountWords());
				table.updateUI();
			}
		});
		
		textCountWords = new JTextField();
		textCountWords.setEditable(false);
		textCountWords.setBounds(486, 253, 68, 20);
		words.add(textCountWords);
		textCountWords.setColumns(10);
		
		JLabel lblWordCount = new JLabel("Word count:");
		lblWordCount.setBounds(410, 253, 89, 20);
		words.add(lblWordCount);
		JLabel lblNewLabel = new JLabel("Current file: ");
		lblNewLabel.setBounds(410, 222, 100, 20);
		words.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		
		write = new WriteFile();
				JTextPane textGetFileName = new JTextPane();
				textGetFileName.setFont(new Font("Tahoma", Font.BOLD, 11));
				textGetFileName.setBounds(486, 222, 68, 20);
				words.add(textGetFileName);
				textGetFileName.setBackground(SystemColor.activeCaption);
				textGetFileName.setEditable(false);
				textGetFileName.setText(write.getFileName());
				
				JButton btnUpdate = new JButton("Update");
				btnUpdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						WriteFile writeFileName = new WriteFile();
						File currentFileName = new File(writeFileName.getFileNameTxt());
						if (!currentFileName.exists()) {
							Component f = null;
							String TEMP = JOptionPane.showInputDialog(f, "Enter new file name");
							// if OK
							if (TEMP.equals("")) {
								JOptionPane.showMessageDialog(f, "The input field is empty.", "Error file name",
										JOptionPane.ERROR_MESSAGE);
								return;
							}
							// if CENCEL
							if (TEMP != null) {
								writeFileName.setFileName(TEMP);
								File checkFile = new File(writeFileName.getFileNameTxt());
								if (!checkFile.exists()) {
									JOptionPane.showMessageDialog(f, "File Not Found.", "Alert", JOptionPane.WARNING_MESSAGE);
								} else {
									Main.words.clear();
									try {
										ReadFile.readFromFile();
									} catch (Exception e1) {
										JOptionPane.showMessageDialog(f, "File is empty.", "Alert",
												JOptionPane.WARNING_MESSAGE);
										e1.printStackTrace();
									}
									if (table.getRowCount() == ReadFile.readFiles.size() / 4) {
										return;
									} else {
										ReadFile.upload();
									}
									textCountWords.setText(CountWords.getCountWords());
									textGetFileName.setText(write.getFileName());
									table.updateUI();
									JOptionPane.showMessageDialog(f,
											"This file is being viewed: " + writeFileName.getFileName());
								}
							}

						}
						Main.words.clear();
						try {
							ReadFile.readFromFile();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						if (ReadFile.readFiles.size() > 0 && table.getRowCount() <= 0) {
							if (table.getRowCount() == ReadFile.readFiles.size() / 4) {
								return;
							} else {
								ReadFile.upload();
							}
						} else {
							return;
						}
						textCountWords.setText(CountWords.getCountWords());
						table.updateUI();
					}
				});
				btnUpdate.setBounds(465, 79, 89, 23);
				words.add(btnUpdate);
				
				JLabel lblInfo = new JLabel("Press the UPDATE button to start");
				lblInfo.setForeground(Color.GRAY);
				lblInfo.setBackground(Color.WHITE);
				lblInfo.setBounds(10, 284, 441, 14);
				words.add(lblInfo);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 255, 255));
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		mnFile.setBackground(new Color(220, 220, 220));
		menuBar.add(mnFile);

		JMenuItem mntmCreateNewFile = new JMenuItem("Create new file");
		mntmCreateNewFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Component f = null;
				WriteFile writeFileName = new WriteFile();
				String TEMP = JOptionPane.showInputDialog("Enter file name:");
				File newFileName;
				File tempFile;
				// if OK
				if (TEMP.equals("")) {
					JOptionPane.showMessageDialog(f, "The input field is empty.", "Error file name",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				// if CENCEL
				if (TEMP != null) {
					// if File already exists
					tempFile = new File(TEMP + ".txt");
					if (tempFile.exists()) {
						JOptionPane.showMessageDialog(f, "The file name already exists.", "Error file name",
								JOptionPane.ERROR_MESSAGE);
						return;
					} else {
						newFileName = new File(TEMP + ".txt");
						try {
							// new File
							newFileName.createNewFile();

						} catch (IOException e1) {
							JOptionPane.showMessageDialog(f, "Error creating file.", "Alert",
									JOptionPane.ERROR_MESSAGE);
							e1.printStackTrace();
						}
						try {
							FileWriter writeFile = new FileWriter(TEMP + ".txt");
							System.out.println(TEMP);
							writeFile.write("new file");
							writeFile.write("`");
							writeFile.write("delete this string");
							writeFile.write("`");
							writeFile.write("0");
							writeFile.write("`");
							writeFile.write("delete this string");
							writeFile.write("`");
							writeFile.close();
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						Main.words.clear();
						writeFileName.setFileName(TEMP);
						try {
							ReadFile.readFromFile();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						if (table.getRowCount() == ReadFile.readFiles.size() / 4) {
							return;
						} else {
							ReadFile.upload();
						}
						textCountWords.setText(CountWords.getCountWords());
						textGetFileName.setText(write.getFileName());
						table.updateUI();
						JOptionPane.showMessageDialog(f, "File created successfully.\nThis file is being viewed: "
								+ writeFileName.getFileName());

					}
				}
			}
		});
		mnFile.add(mntmCreateNewFile);

		JMenuItem mntmRenameFile = new JMenuItem("Rename file");
		mntmRenameFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WriteFile writeFileName = new WriteFile();
				Component f = null;
				String TEMP = JOptionPane.showInputDialog("Enter current file name:");
				File currentFileName = new File(TEMP + ".txt");
				// if OK
				if (TEMP.equals("")) {
					JOptionPane.showMessageDialog(f, "The input field is empty.", "Error file name",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				// if CENCEL
				if (TEMP != null) {
					// if File not found
					if (!currentFileName.exists()) {
						JOptionPane.showMessageDialog(f, "File not found.", "Error file name",
								JOptionPane.ERROR_MESSAGE);
						return;
					} else {
						String newTEMP = JOptionPane.showInputDialog(f, "Enter new file name");
						File newFileName = new File(newTEMP + ".txt");
						if (newTEMP.equals("")) {
							JOptionPane.showMessageDialog(f, "The input field is empty.", "Error file name",
									JOptionPane.ERROR_MESSAGE);
							return;
						}
						if (newTEMP != null) {
							currentFileName.renameTo(newFileName);
							System.out.println(writeFileName.getFileName());
							System.out.println(TEMP);
							if (writeFileName.getFileName() != TEMP) {
								System.out.println(TEMP);
								Main.words.clear();
								writeFileName.setFileName(newTEMP);
								try {
									ReadFile.readFromFile();
								} catch (Exception e1) {
									e1.printStackTrace();
								}
								if (table.getRowCount() == ReadFile.readFiles.size() / 4) {
									return;
								} else {
									ReadFile.upload();
								}
								textCountWords.setText(CountWords.getCountWords());
								textGetFileName.setText(write.getFileName());
								table.updateUI();
								JOptionPane.showMessageDialog(f,
										"File created successfully.\nThis file is being viewed: "
												+ writeFileName.getFileName());
							} else {
								JOptionPane.showMessageDialog(f, "File renamed successfully.");
							}
						}
						return;
					}
				}
			}
		});
		mnFile.add(mntmRenameFile);

		JMenuItem mntmViewFile = new JMenuItem("View File");
		mntmViewFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WriteFile writeFile = new WriteFile();
				Component f = null;
				String TEMP = JOptionPane.showInputDialog(f, "Enter new file name");
				// if OK
				if (TEMP.equals("")) {
					JOptionPane.showMessageDialog(f, "The input field is empty.", "Error file name",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				// if CENCEL
				if (TEMP != null) {
					writeFile.setFileName(TEMP);
					File checkFile = new File(writeFile.getFileNameTxt());
					if (!checkFile.exists()) {
						JOptionPane.showMessageDialog(f, "File Not Found.", "Alert", JOptionPane.WARNING_MESSAGE);
					} else {
						Main.words.clear();
						try {
							ReadFile.readFromFile();
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(f, "File is empty.", "Alert", JOptionPane.WARNING_MESSAGE);
							e1.printStackTrace();
						}
						if (table.getRowCount() == ReadFile.readFiles.size() / 4) {
							return;
						} else {
							ReadFile.upload();
						}
						textCountWords.setText(CountWords.getCountWords());
						textGetFileName.setText(write.getFileName());
						table.updateUI();
						JOptionPane.showMessageDialog(f, "This file is being viewed: " + writeFile.getFileName());
					}
				}
			}
		});
		mnFile.add(mntmViewFile);

		JMenuItem mntmDelete = new JMenuItem("Delete");
		mntmDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Component f = null;
				String TEMP = JOptionPane.showInputDialog(f, "Enter file name");
				// if OK
				if (TEMP.equals("")) {
					JOptionPane.showMessageDialog(f, "The input field is empty.", "Error file name",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				// if CENCEL
				if (TEMP != null) {
					File fileDelete = new File(TEMP + ".txt");
					if (!fileDelete.exists()) {
						JOptionPane.showMessageDialog(f, "File Not Found.", "Alert", JOptionPane.WARNING_MESSAGE);
					} else {
						fileDelete.delete();
						JOptionPane.showMessageDialog(f, "File successfully deleted.");
						File checkFile = new File(write.getFileNameTxt());
						if (!checkFile.exists()) {
							write.setFileName("");
							textGetFileName.setText(write.getFileName());
							Main.words.clear();
							table.updateUI();
						}
					}
				}
			}
		});
		mnFile.add(mntmDelete);

		JMenu mnOptions = new JMenu("Options");
		menuBar.add(mnOptions);
		


		JMenuItem mntmUpdate = new JMenuItem("Update");
		mntmUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WriteFile writeFileName = new WriteFile();
				File currentFileName = new File(writeFileName.getFileNameTxt());
				if (!currentFileName.exists()) {
					Component f = null;
					String TEMP = JOptionPane.showInputDialog(f, "Enter new file name");
					// if OK
					if (TEMP.equals("")) {
						JOptionPane.showMessageDialog(f, "The input field is empty.", "Error file name",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					// if CENCEL
					if (TEMP != null) {
						writeFileName.setFileName(TEMP);
						File checkFile = new File(writeFileName.getFileNameTxt());
						if (!checkFile.exists()) {
							JOptionPane.showMessageDialog(f, "File Not Found.", "Alert", JOptionPane.WARNING_MESSAGE);
						} else {
							Main.words.clear();
							try {
								ReadFile.readFromFile();
							} catch (Exception e1) {
								JOptionPane.showMessageDialog(f, "File is empty.", "Alert",
										JOptionPane.WARNING_MESSAGE);
								e1.printStackTrace();
							}
							if (table.getRowCount() == ReadFile.readFiles.size() / 4) {
								return;
							} else {
								ReadFile.upload();
							}
							textCountWords.setText(CountWords.getCountWords());
							textGetFileName.setText(write.getFileName());
							table.updateUI();
							JOptionPane.showMessageDialog(f,
									"This file is being viewed: " + writeFileName.getFileName());
						}
					}

				}
				Main.words.clear();
				try {
					ReadFile.readFromFile();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (ReadFile.readFiles.size() > 0 && table.getRowCount() <= 0) {
					if (table.getRowCount() == ReadFile.readFiles.size() / 4) {
						return;
					} else {
						ReadFile.upload();
					}
				} else {
					return;
				}
				textCountWords.setText(CountWords.getCountWords());
				table.updateUI();
			}
		});
		mnOptions.add(mntmUpdate);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int res = JOptionPane.showConfirmDialog(null, "Exit the program?");
				if (res == JOptionPane.YES_OPTION)
					System.exit(0);

			}
		});
		mnOptions.add(mntmExit);

		JMenu mnAbout = new JMenu("About");
		mnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		menuBar.add(mnAbout);

		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Component frame = null;
				JOptionPane.showMessageDialog(frame,
						"Translate, please!\nThese is desktop application. English Practice Apps. \r\n" + 
						"You can learn new words or repeat old ones. By filling\n out the word database you can practice your knowledge\n of words. You can add a new word to the base or delete a word.\n Before viewing the data in the database, you need to update, that\n is, click the Update button. Words from the database are displayed\n in the Translate tab",
						"About", JOptionPane.PLAIN_MESSAGE);
			}
		});
		mnAbout.add(mntmAbout);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WriteFile writeFileName = new WriteFile();
				File currentFileName = new File(writeFileName.getFileNameTxt());
				if (!currentFileName.exists()) {
					Component f = null;
					String TEMP = JOptionPane.showInputDialog(f, "Enter new file name");
					// if OK
					if (TEMP.equals("")) {
						JOptionPane.showMessageDialog(f, "The input field is empty.", "Error file name",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					// if CENCEL
					if (TEMP != null) {
						writeFileName.setFileName(TEMP);
						File checkFile = new File(writeFileName.getFileNameTxt());
						if (!checkFile.exists()) {
							JOptionPane.showMessageDialog(f, "File Not Found.", "Alert", JOptionPane.WARNING_MESSAGE);
						} else {
							Main.words.clear();
							try {
								ReadFile.readFromFile();
							} catch (Exception e1) {
								JOptionPane.showMessageDialog(f, "File is empty.", "Alert",
										JOptionPane.WARNING_MESSAGE);
								e1.printStackTrace();
							}
							if (table.getRowCount() == ReadFile.readFiles.size() / 4) {
								return;
							} else {
								ReadFile.upload();
							}
							textCountWords.setText(CountWords.getCountWords());
							textGetFileName.setText(write.getFileName());
							table.updateUI();
							JOptionPane.showMessageDialog(f,
									"This file is being viewed: " + writeFileName.getFileName());
						}
					}

				}
				Main.words.clear();
				try {
					ReadFile.readFromFile();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (ReadFile.readFiles.size() > 0 && table.getRowCount() <= 0) {
					if (table.getRowCount() == ReadFile.readFiles.size() / 4) {
						return;
					} else {
						ReadFile.upload();
					}
				} else {
					return;
				}
				textCountWords.setText(CountWords.getCountWords());
				table.updateUI();
				
				
				if (textGetWord.getText().equals("")) {
					if (rdbtnEngRus.isSelected()) {
						RandomWord.getRandomEngWord();
				textGetWord.setText(RandomWord.getEngWord());
				System.out.println(RandomWord.getEngWord());
					} else {
						RandomWord.getRandomRusWord();
						textGetWord.setText(RandomWord.getRusWord());
						System.out.println(RandomWord.getRusWord());
					}
				} else {return;}
				
			}
		});
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnStart.setBounds(10, 11, 89, 26);
		translate.add(btnStart);
		
		JLabel lblOver = new JLabel("");
		lblOver.setBounds(227, 283, 59, 14);
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Component f = null;
				if(!textSetWord.getText().equals("")) {
					//Success
					String getWord;
					if (rdbtnEngRus.isSelected()) {
						getWord = RandomWord.getRusWord();
					} else {
						getWord = RandomWord.getEngWord();
					}
					System.out.println(getWord);
				if(textSetWord.getText().toLowerCase().equals(getWord.toLowerCase())) {
					TranslateWindow.setRESPONSE(TranslateWindow.getSuccessResponse());
					TranslateWindow.setScoreSUCCESS(TranslateWindow.getScoreSUCCESS());
					lblResult.setText(TranslateWindow.getRESPONSE());
					lblResult.setForeground(new Color(0, 128, 0));
					lblSuccessScore.setText(Integer.toString(TranslateWindow.getScoreSUCCESS()));
				} else { //Error
					TranslateWindow.setRESPONSE(TranslateWindow.getErrorResponse());
					TranslateWindow.setScoreERROR(TranslateWindow.getScoreERROR());
					lblResult.setText(TranslateWindow.getRESPONSE());
					lblResult.setForeground(new Color(255, 0, 0));
					lblErrorScore.setText(Integer.toString(TranslateWindow.getScoreERROR()));
				}
				} else {
					JOptionPane.showMessageDialog(f, "The input field is empty.", "Error input field", JOptionPane.ERROR_MESSAGE);
				}
				if (!textGetWord.getText().equals("")) {
					if (rdbtnEngRus.isSelected()) {
						RandomWord.getRandomEngWord();
						textGetWord.setText(RandomWord.getEngWord());
						textSetWord.setText("");
						System.out.println(RandomWord.getEngWord());
					} else {
						RandomWord.getRandomRusWord();
						textGetWord.setText(RandomWord.getRusWord());
						textSetWord.setText("");
						System.out.println(RandomWord.getRusWord());
					}
				} else {return;}
				TranslateWindow.setTotalNum(TranslateWindow.getScoreSUCCESS() + TranslateWindow.getScoreERROR());
				lblOver.setText("Total: " + TranslateWindow.getTotalNum());
				textSetWord.setForeground(Color.black);
			}
		});
		btnNewButton.setBounds(206, 242, 89, 29);
		translate.add(btnNewButton);
		
		JLabel lblHelpNum = new JLabel("");
		lblHelpNum.setBounds(10, 251, 89, 14);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnEngRus.isSelected()) {
					textSetWord.setText(RandomWord.getRusWord());
					textSetWord.setForeground(Color.gray);
				} else {
					textSetWord.setText(RandomWord.getEngWord());
					textSetWord.setForeground(Color.gray);
				}
				if (!textGetWord.getText().equals("")) {
				TranslateWindow.setHelpNum(TranslateWindow.getHelpNum() + 1);
				lblHelpNum.setText("Help: " + TranslateWindow.getHelpNum());
				}
			}
		});
		btnHelp.setBounds(10, 274, 66, 23);
		translate.add(btnHelp);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblResult.setText("");
				lblSuccessScore.setText("");
				lblErrorScore.setText("");
				TranslateWindow.setScoreSUCCESS(-1);
				TranslateWindow.setScoreERROR(-1);
				TranslateWindow.setHelpNum(0);
				lblHelpNum.setText("");
				lblOver.setText("");
				textSetWord.setText("");
				textGetWord.setText("");
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnReset.setBounds(10, 50, 89, 26);
		translate.add(btnReset);
		
		translate.add(lblHelpNum);
		
		translate.add(lblOver);
		

		setVisible(true);
	}
}
