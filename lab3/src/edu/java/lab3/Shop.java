package edu.java.lab3;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;

/**
 * @author Garifullin Marat
 * @version 1.3
 */
public class Shop {
	private JFrame shop;
	private DefaultTableModel sellersModel, productsModel;
	private JButton save, // ���������
			open, // ������� ����
			add, // �������� ������
			delete, // ������� ������
			edit, // �������� ������
			info, // ���������� � ��������
			tableSearchButton; // ����� �������
	private JToolBar toolBar; // ������ ������������
	private JScrollPane sellersScroll, // ��������� ������� ���������
			productsScroll; // ��������� ������� ���������
	private JTable sellersTable, // ������� ��������
			productsTable; // ������� �������
	private JLabel tableNameLabel, tableSearchLabel;
	private JComboBox tableNameBox, tableSearchSellersBox, tableSearchProductsBox;
	private JTextField tableSearchField; // ��������� ����
	private Box tableContainer, // ��������� ��� ������� � ����������� �����������
			tableNameContainer, // ��������� ��� ������ �������
			tableSearchContainer; // ��������� ��� ��������� ������ �� �������

	public void show() {
		// �������� ����
		shop = new JFrame("�������");
		shop.setSize(500, 300);
		shop.setLocation(100, 100);
		shop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// �������� ������
		save = new JButton(new ImageIcon("./icons/save.png"));
		open = new JButton(new ImageIcon("./icons/open.png"));
		add = new JButton(new ImageIcon("./icons/add.png"));
		delete = new JButton(new ImageIcon("./icons/delete.png"));
		edit = new JButton(new ImageIcon("./icons/edit.png"));
		info = new JButton(new ImageIcon("./icons/info.png"));

		// ��������� ��������� ��� ������
		save.setToolTipText("���������");
		open.setToolTipText("������� ����");
		add.setToolTipText("�������� ������");
		delete.setToolTipText("������� ������");
		edit.setToolTipText("�������� ������");
		info.setToolTipText("� ��������");

		// ���������� ������ �� ������ ������������
		toolBar = new JToolBar("������ ������������");
		toolBar.add(save);
		toolBar.add(open);
		toolBar.add(add);
		toolBar.add(delete);
		toolBar.add(edit);
		toolBar.add(info);

		// ���������� ������ ������������
		shop.setLayout(new BorderLayout());
		shop.add(toolBar, BorderLayout.NORTH);

		// �������� ������ ������ �������
		tableNameContainer = Box.createHorizontalBox();
		tableNameLabel = new JLabel("�������:");
		tableNameBox = new JComboBox(new String[] { "��������", "������" });
		tableNameBox.setMaximumSize(new Dimension(90, 25));
		tableNameContainer.add(tableNameLabel);
		tableNameContainer.add(Box.createHorizontalStrut(6));
		tableNameContainer.add(tableNameBox);
		tableNameContainer.add(Box.createHorizontalGlue());

		// �������� ������� � ������� ���������
		String sellersColumn[] = { "���", "���� ��������", "��������" };
		String sellersData[][] = { { "���������� ����� ����������", "13.02.2002", "0" },
				{ "������ ������ ��������", "12.12.1999", "30" } };
		sellersModel = new DefaultTableModel(sellersData, sellersColumn);
		sellersTable = new JTable(sellersModel);
		sellersScroll = new JScrollPane(sellersTable);

		// �������� ������� � ������� �������
		String productsColumn[] = { "�������� ������", "����", "����������" };
		String productsData[][] = { { "Sea of thieves", "3000", "3" }, { "Vampire Survivors", "81", "2000" } };
		productsModel = new DefaultTableModel(productsData, productsColumn);
		productsTable = new JTable(productsModel);
		productsScroll = new JScrollPane(productsTable);
		productsScroll.setVisible(false);

		// �������� ������ ������ �� �������
		tableSearchContainer = Box.createHorizontalBox();
		tableSearchLabel = new JLabel("����� ��:");
		tableSearchSellersBox = new JComboBox(new String[] { "���", "���� ��������", "��������" });
		tableSearchProductsBox = new JComboBox(new String[] { "�������� ������", "����", "����������" });
		tableSearchProductsBox.setVisible(false);
		tableSearchField = new JTextField("�����");
		tableSearchButton = new JButton("�����");
		tableSearchButton.setFocusPainted(false);
		tableSearchContainer.add(tableSearchLabel);
		tableSearchContainer.add(Box.createHorizontalStrut(6));
		tableSearchContainer.add(tableSearchSellersBox);
		tableSearchContainer.add(tableSearchProductsBox);
		tableSearchContainer.add(Box.createHorizontalStrut(6));
		tableSearchContainer.add(tableSearchField);
		tableSearchContainer.add(Box.createHorizontalStrut(6));
		tableSearchContainer.add(tableSearchButton);

		// ���������� ������� � ����������� �����������
		tableContainer = Box.createVerticalBox();
		tableContainer.add(tableNameContainer);
		tableContainer.add(sellersScroll);
		tableContainer.add(productsScroll);
		tableContainer.add(tableSearchContainer);
		shop.add(tableContainer, BorderLayout.CENTER);

		// ���������� ����������
		addListeners();

		// ������������ �������� �����
		shop.setVisible(true);
	}

	private void addListeners() {
		// ���������� ����������
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
	 * @param arr - ������ ��� ���������� �� ��������
	 */
	private void sort(int[] arr) {
		int tmp;
		int len = arr.length;
		// ���������� �������
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

	// ����� ������������� �������
	public class FirstAction implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == save) {

			} else if (event.getSource() == open) {

			} else if (event.getSource() == add) {
				int currentTable = tableNameBox.getSelectedIndex();
				if (currentTable == 0) {
					System.out.println("la");
					SellerWindow s = new SellerWindow();
				} else if (currentTable == 1) {

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
						JOptionPane.showMessageDialog(shop, "�� �� ������� ������ ��� ��������!");
					}
				} else if (currentTable == 1) {
					int[] selectedRows = productsTable.getSelectedRows();
					if (selectedRows.length != 0) {
						sort(selectedRows);
						for (int i : selectedRows) {
							productsModel.removeRow(i);
						}
					} else {
						JOptionPane.showMessageDialog(shop, "�� �� ������� ������ ��� ��������!");
					}
				}
			} else if (event.getSource() == edit) {

			} else if (event.getSource() == info) {

			} else if (event.getSource() == tableNameBox) {
				int selectedIndex = tableNameBox.getSelectedIndex(); // 0 - ��������, 1 - ������
				if (selectedIndex == 0) {
					sellersScroll.setVisible(true);
					productsScroll.setVisible(false);
				} else if (selectedIndex == 1) {
					sellersScroll.setVisible(false);
					productsScroll.setVisible(true);
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

	// ������ ������� ����� ��� ���������� ��������
	public class SellerWindow extends JFrame {
		Box mainBox, box1, box2, box3;
		JPanel p;
		JLabel FIOLabel, birthDateLabel, salaryLabel;
		JTextField FIOField, birthDateField, salaryField;
		JButton addSeller;

		public SellerWindow() {
			setTitle("���������� ��������");
			setSize(500, 300);
			setLocation(200, 100);
			setDefaultCloseOperation(HIDE_ON_CLOSE);

			// �������� ��������
			FIOLabel = new JLabel("������� ���:");
			birthDateLabel = new JLabel("������� ���� ��������:");
			salaryLabel = new JLabel("������� ��������:");

			// �������� ����� ��� �����
			FIOField = new JTextField(20);
			birthDateField = new JTextField(20);
			salaryField = new JTextField();

			// �������� ������ ����������
			addSeller = new JButton("��������");

			// ���������� ��������
			p = new JPanel(new FlowLayout());
			p.add(FIOLabel);
			p.add(FIOField);
//			box1 = Box.createHorizontalBox();
//			box1.add(FIOLabel);
//			box1.add(Box.createHorizontalStrut(16));
//			box1.add(FIOField);
			box2 = Box.createHorizontalBox();
			box2.add(birthDateLabel);
			box2.add(Box.createHorizontalStrut(16));
			box2.add(birthDateField);
			box3 = Box.createHorizontalBox();
			box3.add(salaryLabel);
			box3.add(Box.createHorizontalStrut(16));
			box3.add(salaryField);
			mainBox = Box.createVerticalBox();
			mainBox.add(Box.createVerticalGlue());
			mainBox.add(p);
			mainBox.add(Box.createVerticalStrut(12));
			mainBox.add(box2);
			mainBox.add(box3);
			mainBox.add(addSeller);
			add(mainBox);
			setVisible(true);
		}
	}

	/**
	 * @param args - �������� ������
	 */
	public static void main(String[] args) {
		Shop shop = new Shop();
		shop.show();
	}
}
