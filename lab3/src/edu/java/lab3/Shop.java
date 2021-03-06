package edu.java.lab3;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
//lol kek???
/**
 * @author Garifullin Marat
 * @version 1.3
 */
public class Shop {
	private JFrame shop;
	private DefaultTableModel sellersModel, productsModel;
	private JButton save, // ?????????
			open, // ??????? ????
			add, // ???????? ??????
			delete, // ??????? ??????
			edit, // ???????? ??????
			info, // ?????????? ? ????????
			tableSearchButton; // ????? ???????
	private JToolBar toolBar; // ?????? ????????????
	private JScrollPane sellersScroll, // ????????? ??????? ?????????
			productsScroll; // ????????? ??????? ?????????
	private JTable sellersTable, // ??????? ????????
			productsTable; // ??????? ???????
	private JLabel tableNameLabel, tableSearchLabel;
	private JComboBox tableNameBox, tableSearchSellersBox, tableSearchProductsBox;
	private JTextField tableSearchField; // ????????? ????
	private Box tableContainer, // ????????? ??? ??????? ? ??????????? ???????????
			tableNameContainer, // ????????? ??? ?????? ???????
			tableSearchContainer; // ????????? ??? ????????? ?????? ?? ???????

	public void show() {
		// ???????? ????
		shop = new JFrame("???????");
		shop.setSize(500, 300);
		shop.setLocation(100, 100);
		shop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// ???????? ??????
		save = new JButton(new ImageIcon("./icons/save.png"));
		open = new JButton(new ImageIcon("./icons/open.png"));
		add = new JButton(new ImageIcon("./icons/add.png"));
		delete = new JButton(new ImageIcon("./icons/delete.png"));
		edit = new JButton(new ImageIcon("./icons/edit.png"));
		info = new JButton(new ImageIcon("./icons/info.png"));

		// ????????? ????????? ??? ??????
		save.setToolTipText("?????????");
		open.setToolTipText("??????? ????");
		add.setToolTipText("???????? ??????");
		delete.setToolTipText("??????? ??????");
		edit.setToolTipText("???????? ??????");
		info.setToolTipText("? ????????");

		// ?????????? ?????? ?? ?????? ????????????
		toolBar = new JToolBar("?????? ????????????");
		toolBar.add(save);
		toolBar.add(open);
		toolBar.add(add);
		toolBar.add(delete);
		toolBar.add(edit);
		toolBar.add(info);

		// ?????????? ?????? ????????????
		shop.setLayout(new BorderLayout());
		shop.add(toolBar, BorderLayout.NORTH);

		// ???????? ?????? ?????? ???????
		tableNameContainer = Box.createHorizontalBox();
		tableNameLabel = new JLabel("???????:");
		tableNameBox = new JComboBox(new String[] { "????????", "??????" });
		tableNameLabel.setLabelFor(tableNameBox);
		tableNameBox.setMaximumSize(new Dimension(90, 25));
		tableNameContainer.add(tableNameLabel);
		tableNameContainer.add(Box.createHorizontalStrut(6));
		tableNameContainer.add(tableNameBox);
		tableNameContainer.add(Box.createHorizontalGlue());

		// ???????? ??????? ? ??????? ?????????
		String sellersColumn[] = { "???", "???? ????????", "????????" };
		String sellersData[][] = { { "?????????? ????? ??????????", "13.02.2002", "0" },
				{ "?????? ?????? ????????", "12.12.1999", "30" } };
		sellersModel = new DefaultTableModel(sellersData, sellersColumn);
		sellersTable = new JTable(sellersModel);
		sellersScroll = new JScrollPane(sellersTable);

		// ???????? ??????? ? ??????? ???????
		String productsColumn[] = { "???????? ??????", "????", "??????????" };
		String productsData[][] = { { "Sea of thieves", "3000", "3" }, { "Vampire Survivors", "81", "2000" } };
		productsModel = new DefaultTableModel(productsData, productsColumn);
		productsTable = new JTable(productsModel);
		productsScroll = new JScrollPane(productsTable);
		productsScroll.setVisible(false);

		// ???????? ?????? ?????? ?? ???????
		tableSearchContainer = Box.createHorizontalBox();
		tableSearchLabel = new JLabel("????? ??:");
		tableSearchSellersBox = new JComboBox(new String[] { "???", "???? ????????", "????????" });
		tableSearchProductsBox = new JComboBox(new String[] { "???????? ??????", "????", "??????????" });
		tableSearchProductsBox.setVisible(false);
		tableSearchField = new JTextField("?????");
		tableSearchButton = new JButton("?????");
		tableSearchButton.setFocusPainted(false);
		tableSearchContainer.add(tableSearchLabel);
		tableSearchContainer.add(Box.createHorizontalStrut(6));
		tableSearchContainer.add(tableSearchSellersBox);
		tableSearchContainer.add(tableSearchProductsBox);
		tableSearchContainer.add(Box.createHorizontalStrut(6));
		tableSearchContainer.add(tableSearchField);
		tableSearchContainer.add(Box.createHorizontalStrut(6));
		tableSearchContainer.add(tableSearchButton);

		// ?????????? ??????? ? ??????????? ???????????
		tableContainer = Box.createVerticalBox();
		tableContainer.add(tableNameContainer);
		tableContainer.add(sellersScroll);
		tableContainer.add(productsScroll);
		tableContainer.add(tableSearchContainer);
		shop.add(tableContainer, BorderLayout.CENTER);

		// ?????????? ??????????
		addListeners();

		// ???????????? ???????? ?????
		shop.setVisible(true);
	}

	private void addListeners() {
		// ?????????? ??????????
		save.addActionListener(new FirstAction());
		open.addActionListener(new FirstAction());
		add.addActionListener(new FirstAction());
		delete.addActionListener(new FirstAction());
		edit.addActionListener(new FirstAction());
		info.addActionListener(new FirstAction());
		tableNameBox.addActionListener(new FirstAction());
		tableSearchSellersBox.addActionListener(new FirstAction());
	}

	/**
	 * @param arr - ?????? ??? ?????????? ?? ????????
	 */
	private void sort(int[] arr) {
		int tmp;
		int len = arr.length;
		// ?????????? ???????
		for (int i = 0; i < len; ++i) {
			for (int j = 0; j < len - i - 1; ++j) {
				if (arr[j] < arr[j + 1]) {
					tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
				}
			}
		}
	}

	// ????? ????????????? ???????
	public class FirstAction implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == save) {

			} else if (event.getSource() == open) {

			} else if (event.getSource() == add) {
				int currentTable = tableNameBox.getSelectedIndex();
				if (currentTable == 0) {
					SellerWindow seller = new SellerWindow();
				} else if (currentTable == 1) {
					ProductWindow product = new ProductWindow();
				}
			} else if (event.getSource() == delete) {
				int currentTable = tableNameBox.getSelectedIndex();
				if (currentTable == 0) {
					int[] selectedRows = sellersTable.getSelectedRows();
					if (selectedRows.length != 0) {
						sort(selectedRows);
						for (int i : selectedRows) {
							sellersModel.removeRow(i);
						}
					} else {
						JOptionPane.showMessageDialog(shop, "?? ?? ??????? ?????? ??? ????????!");
					}
				} else if (currentTable == 1) {
					int[] selectedRows = productsTable.getSelectedRows();
					if (selectedRows.length != 0) {
						sort(selectedRows);
						for (int i : selectedRows) {
							productsModel.removeRow(i);
						}
					} else {
						JOptionPane.showMessageDialog(shop, "?? ?? ??????? ?????? ??? ????????!");
					}
				}
			} else if (event.getSource() == edit) {

			} else if (event.getSource() == info) {

			} else if (event.getSource() == tableNameBox) {
				int selectedIndex = tableNameBox.getSelectedIndex(); // 0 - ????????, 1 - ??????
				if (selectedIndex == 0) {
					sellersScroll.setVisible(true);
					productsScroll.setVisible(false);
					tableSearchSellersBox.setVisible(true);
					tableSearchProductsBox.setVisible(false);
				} else if (selectedIndex == 1) {
					sellersScroll.setVisible(false);
					productsScroll.setVisible(true);
					tableSearchSellersBox.setVisible(false);
					tableSearchProductsBox.setVisible(true);
				}
				shop.setVisible(true);
			} else if (event.getSource() == tableSearchSellersBox) {
				System.out.println(tableSearchSellersBox.getSelectedIndex());
			}
		}
	}

	public class SecondAction implements ItemListener {
		public void itemStateChanged(ItemEvent event) {

		}
	}

	// ?????? ??????? ????? ??? ?????????? ????????
	public class SellerWindow extends JFrame {
		Container mainBox;
		JPanel panel1, panel2, panel3;
		JLabel FIOLabel, birthDateLabel, salaryLabel;
		JTextField FIOField, birthDateField, salaryField;
		JButton addSeller;
		SpringLayout layout, layout1, layout2, layout3;

		public SellerWindow() {
			this.setTitle("?????????? ????????");
			this.setBounds(200, 100, 500, 220);
			this.setDefaultCloseOperation(HIDE_ON_CLOSE);
			this.setResizable(false);

			// ???????? ????????
			FIOLabel = new JLabel("??????? ???:");
			birthDateLabel = new JLabel("??????? ???? ????????:");
			salaryLabel = new JLabel("??????? ????????:");

			// ???????? ????? ??? ?????
			FIOField = new JTextField();
			birthDateField = new JTextField();
			salaryField = new JTextField();

			// ???????? ?????? ??????????
			addSeller = new JButton("????????");

			//?????????? ?????????
			mainBox = this.getContentPane();
			layout = new SpringLayout();
			layout1 = new SpringLayout();
			layout2 = new SpringLayout();
			layout3 = new SpringLayout();
			panel1 = new JPanel();
			panel2 = new JPanel();
			panel3 = new JPanel();
			mainBox.setLayout(layout);
			panel1.setLayout(layout1);
			panel2.setLayout(layout2);
			panel3.setLayout(layout3);
			panel1.add(FIOLabel);
			panel1.add(FIOField);
			panel2.add(birthDateLabel);
			panel2.add(birthDateField);
			panel3.add(salaryLabel);
			panel3.add(salaryField);
			mainBox.add(panel1);
			mainBox.add(panel2);
			mainBox.add(panel3);
			mainBox.add(addSeller);
			//?????????? panel1
			layout.putConstraint(SpringLayout.WEST, panel1, 5, SpringLayout.WEST, mainBox);
			layout.putConstraint(SpringLayout.EAST, panel1, -5, SpringLayout.EAST, mainBox);
			layout.putConstraint(SpringLayout.NORTH, panel1, 10, SpringLayout.NORTH, mainBox);
			layout.putConstraint(SpringLayout.SOUTH, panel1, 35, SpringLayout.NORTH, panel1);
			//?????????? panel2
			layout.putConstraint(SpringLayout.NORTH, panel2, 10, SpringLayout.SOUTH, panel1);
			layout.putConstraint(SpringLayout.SOUTH, panel2, 35, SpringLayout.NORTH, panel2);
			layout.putConstraint(SpringLayout.WEST, panel2, 5, SpringLayout.WEST, mainBox);
			layout.putConstraint(SpringLayout.EAST, panel2, -5, SpringLayout.EAST, mainBox);
			//?????????? panel3
			layout.putConstraint(SpringLayout.NORTH, panel3, 10, SpringLayout.SOUTH, panel2);
			layout.putConstraint(SpringLayout.SOUTH, panel3, 35, SpringLayout.NORTH, panel3);
			layout.putConstraint(SpringLayout.WEST, panel3, 5, SpringLayout.WEST, mainBox);
			layout.putConstraint(SpringLayout.EAST, panel3, -5, SpringLayout.EAST, mainBox);
			//?????????? ?????? addSeller
			layout.putConstraint(SpringLayout.EAST, addSeller, -175, SpringLayout.EAST, mainBox);
			layout.putConstraint(SpringLayout.SOUTH, addSeller, -10, SpringLayout.SOUTH, mainBox);
			layout.putConstraint(SpringLayout.WEST, addSeller, 175, SpringLayout.WEST, mainBox);
			//?????????? ?????? panel1
			layout1.putConstraint(SpringLayout.WEST, FIOLabel, 5, SpringLayout.WEST, panel1);
			layout1.putConstraint(SpringLayout.NORTH, FIOLabel, 5, SpringLayout.NORTH, panel1);
			layout1.putConstraint(SpringLayout.SOUTH, FIOLabel, -5, SpringLayout.SOUTH, panel1);
			layout1.putConstraint(SpringLayout.NORTH, FIOField, 5, SpringLayout.NORTH, panel1);
			layout1.putConstraint(SpringLayout.EAST, FIOField, -30, SpringLayout.EAST, panel1);
			layout1.putConstraint(SpringLayout.SOUTH, FIOField, -5, SpringLayout.SOUTH, panel1);
			layout1.putConstraint(SpringLayout.WEST, FIOField, 170, SpringLayout.WEST, panel1);
			//?????????? ?????? panel2
			layout2.putConstraint(SpringLayout.WEST, birthDateLabel, 5, SpringLayout.WEST, panel2);
			layout2.putConstraint(SpringLayout.NORTH, birthDateLabel, 5, SpringLayout.NORTH, panel2);
			layout2.putConstraint(SpringLayout.SOUTH, birthDateLabel, -5, SpringLayout.SOUTH, panel2);
			layout2.putConstraint(SpringLayout.NORTH, birthDateField, 5, SpringLayout.NORTH, panel2);
			layout2.putConstraint(SpringLayout.EAST, birthDateField, -30, SpringLayout.EAST, panel2);
			layout2.putConstraint(SpringLayout.SOUTH, birthDateField, -5, SpringLayout.SOUTH, panel2);
			layout2.putConstraint(SpringLayout.WEST, birthDateField, 170, SpringLayout.WEST, panel2);
			//?????????? ?????? panel3
			layout3.putConstraint(SpringLayout.WEST, salaryLabel, 5, SpringLayout.WEST, panel3);
			layout3.putConstraint(SpringLayout.NORTH, salaryLabel, 5, SpringLayout.NORTH, panel3);
			layout3.putConstraint(SpringLayout.SOUTH, salaryLabel, -5, SpringLayout.SOUTH, panel3);
			layout3.putConstraint(SpringLayout.NORTH, salaryField, 5, SpringLayout.NORTH, panel3);
			layout3.putConstraint(SpringLayout.EAST, salaryField, -30, SpringLayout.EAST, panel3);
			layout3.putConstraint(SpringLayout.SOUTH, salaryField, -5, SpringLayout.SOUTH, panel3);
			layout3.putConstraint(SpringLayout.WEST, salaryField, 170, SpringLayout.WEST, panel3);
			
			this.setVisible(true);
		}
	}

	public class ProductWindow extends JFrame {
		Container mainBox;
		JPanel panel1, panel2, panel3;
		JLabel productNameLabel, priceLabel, numLabel;
		JTextField productNameField, priceField, numField;
		JButton addProduct;
		SpringLayout layout, layout1, layout2, layout3;

		public ProductWindow() {
			this.setTitle("?????????? ??????");
			this.setBounds(200, 100, 500, 220);
			this.setDefaultCloseOperation(HIDE_ON_CLOSE);
			this.setResizable(false);

			// ???????? ????????
			productNameLabel = new JLabel("??????? ????????:");
			priceLabel = new JLabel("??????? ????:");
			numLabel = new JLabel("??????? ??????????:");

			// ???????? ????? ??? ?????
			productNameField = new JTextField();
			priceField = new JTextField();
			numField = new JTextField();

			// ???????? ?????? ??????????
			addProduct = new JButton("????????");

			//?????????? ?????????
			mainBox = this.getContentPane();
			layout = new SpringLayout();
			layout1 = new SpringLayout();
			layout2 = new SpringLayout();
			layout3 = new SpringLayout();
			panel1 = new JPanel();
			panel2 = new JPanel();
			panel3 = new JPanel();
			mainBox.setLayout(layout);
			panel1.setLayout(layout1);
			panel2.setLayout(layout2);
			panel3.setLayout(layout3);
			panel1.add(productNameLabel);
			panel1.add(productNameField);
			panel2.add(priceLabel);
			panel2.add(priceField);
			panel3.add(numLabel);
			panel3.add(numField);
			mainBox.add(panel1);
			mainBox.add(panel2);
			mainBox.add(panel3);
			mainBox.add(addProduct);
			//?????????? panel1
			layout.putConstraint(SpringLayout.WEST, panel1, 5, SpringLayout.WEST, mainBox);
			layout.putConstraint(SpringLayout.EAST, panel1, -5, SpringLayout.EAST, mainBox);
			layout.putConstraint(SpringLayout.NORTH, panel1, 10, SpringLayout.NORTH, mainBox);
			layout.putConstraint(SpringLayout.SOUTH, panel1, 35, SpringLayout.NORTH, panel1);
			//?????????? panel2
			layout.putConstraint(SpringLayout.NORTH, panel2, 10, SpringLayout.SOUTH, panel1);
			layout.putConstraint(SpringLayout.SOUTH, panel2, 35, SpringLayout.NORTH, panel2);
			layout.putConstraint(SpringLayout.WEST, panel2, 5, SpringLayout.WEST, mainBox);
			layout.putConstraint(SpringLayout.EAST, panel2, -5, SpringLayout.EAST, mainBox);
			//?????????? panel3
			layout.putConstraint(SpringLayout.NORTH, panel3, 10, SpringLayout.SOUTH, panel2);
			layout.putConstraint(SpringLayout.SOUTH, panel3, 35, SpringLayout.NORTH, panel3);
			layout.putConstraint(SpringLayout.WEST, panel3, 5, SpringLayout.WEST, mainBox);
			layout.putConstraint(SpringLayout.EAST, panel3, -5, SpringLayout.EAST, mainBox);
			//?????????? ?????? addSeller
			layout.putConstraint(SpringLayout.EAST, addProduct, -175, SpringLayout.EAST, mainBox);
			layout.putConstraint(SpringLayout.SOUTH, addProduct, -10, SpringLayout.SOUTH, mainBox);
			layout.putConstraint(SpringLayout.WEST, addProduct, 175, SpringLayout.WEST, mainBox);
			//?????????? ?????? panel1
			layout1.putConstraint(SpringLayout.WEST, productNameLabel, 5, SpringLayout.WEST, panel1);
			layout1.putConstraint(SpringLayout.NORTH, productNameLabel, 5, SpringLayout.NORTH, panel1);
			layout1.putConstraint(SpringLayout.SOUTH, productNameLabel, -5, SpringLayout.SOUTH, panel1);
			layout1.putConstraint(SpringLayout.NORTH, productNameField, 5, SpringLayout.NORTH, panel1);
			layout1.putConstraint(SpringLayout.EAST, productNameField, -30, SpringLayout.EAST, panel1);
			layout1.putConstraint(SpringLayout.SOUTH, productNameField, -5, SpringLayout.SOUTH, panel1);
			layout1.putConstraint(SpringLayout.WEST, productNameField, 170, SpringLayout.WEST, panel1);
			//?????????? ?????? panel2
			layout2.putConstraint(SpringLayout.WEST, priceLabel, 5, SpringLayout.WEST, panel2);
			layout2.putConstraint(SpringLayout.NORTH, priceLabel, 5, SpringLayout.NORTH, panel2);
			layout2.putConstraint(SpringLayout.SOUTH, priceLabel, -5, SpringLayout.SOUTH, panel2);
			layout2.putConstraint(SpringLayout.NORTH, priceField, 5, SpringLayout.NORTH, panel2);
			layout2.putConstraint(SpringLayout.EAST, priceField, -30, SpringLayout.EAST, panel2);
			layout2.putConstraint(SpringLayout.SOUTH, priceField, -5, SpringLayout.SOUTH, panel2);
			layout2.putConstraint(SpringLayout.WEST, priceField, 170, SpringLayout.WEST, panel2);
			//?????????? ?????? panel3
			layout3.putConstraint(SpringLayout.WEST, numLabel, 5, SpringLayout.WEST, panel3);
			layout3.putConstraint(SpringLayout.NORTH, numLabel, 5, SpringLayout.NORTH, panel3);
			layout3.putConstraint(SpringLayout.SOUTH, numLabel, -5, SpringLayout.SOUTH, panel3);
			layout3.putConstraint(SpringLayout.NORTH, numField, 5, SpringLayout.NORTH, panel3);
			layout3.putConstraint(SpringLayout.EAST, numField, -30, SpringLayout.EAST, panel3);
			layout3.putConstraint(SpringLayout.SOUTH, numField, -5, SpringLayout.SOUTH, panel3);
			layout3.putConstraint(SpringLayout.WEST, numField, 170, SpringLayout.WEST, panel3);
			
			this.setVisible(true);
		}
	}
	/**
	 * @param args - ???????? ??????
	 */
	public static void main(String[] args) {
		Shop shop = new Shop();
		shop.show();
	}
}
