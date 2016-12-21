package GUI.tables;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class TableSortFilter extends JFrame {
	private static final long serialVersionUID = 1644926973549494532L;

	// Create table column names
	private String[] columnNames = { "Country", "Capital",
			"Population in Millions", "Democracy" };

	// Create table data
	private Object[][] data = { { "USA", "Washington DC", 280, true },
			{ "Canada", "Ottawa", 32, true },
			{ "United Kingdom", "London", 60, true },
			{ "Germany", "Berlin", 83, true }, { "France", "Paris", 60, true },
			{ "Norway", "Oslo", 4.5, true },
			{ "India", "New Delhi", 1046, true } };

	// Create a table
	private JTable jTable1 = new JTable(data, columnNames);

	// Create a TableRowSorter
	private TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(
			jTable1.getModel());

	private JTextField jtfFilter = new JTextField();
	private JButton btFilter = new JButton("Filter");

	public TableSortFilter() {
		// Enable auto sorter
		jTable1.setRowSorter(sorter);
		this.setSize(400, 320);

		JPanel panel = new JPanel(new java.awt.BorderLayout());
		panel.add(new JLabel("Specify a word to match:"), BorderLayout.WEST);
		panel.add(jtfFilter, BorderLayout.CENTER);
		panel.add(btFilter, BorderLayout.EAST);

		add(panel, BorderLayout.SOUTH);
		add(new JScrollPane(jTable1), BorderLayout.CENTER);

		btFilter.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				String text = jtfFilter.getText();
				if (text.trim().length() == 0)
					sorter.setRowFilter(null);
				else
					sorter.setRowFilter(RowFilter.regexFilter(text));
			}
		});
	}

	// Main method
	public static void main(String[] args) {
		JFrame frame = new TableSortFilter();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setTitle("TableSortFilter");
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
