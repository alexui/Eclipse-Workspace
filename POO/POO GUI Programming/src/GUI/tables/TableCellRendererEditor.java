package GUI.tables;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.event.TableColumnModelListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class TableCellRendererEditor extends JFrame {
	private static final long serialVersionUID = -1528983036240101920L;

	// Create table column names
	private String[] columnNames = { "Title", "Percentage sold",
			"Copies Needed", "Publisher", "Date Published", "In-stock" };

	// Create table data
	private Object[][] rowData = {
			{ "Introduction to <b>Java Programming</b>", 10, 120,
					"Que Education & Training",
					new GregorianCalendar(1998, 1 - 1, 6).getTime(), false },
			{ "Introduction to <i>Java Programming</i>, 2E", 50, 220,
					"Que Education & Training",
					new GregorianCalendar(1999, 1 - 1, 6).getTime(), false },
			{ "Introduction to <b><i>Java Programming</i></b>, 3E", 90, 220,
					"Prentice Hall",
					new GregorianCalendar(2000, 12 - 1, 0).getTime(), true }, };

	// Create a table model
	private MyTableModel tableModel = new MyTableModel(rowData, columnNames);

	// Create a table
	private JTable jTable1 = new MyTable(tableModel);

	public TableCellRendererEditor() {
		this.setSize(1000, 300);
		jTable1.setRowHeight(60);
		jTable1.setAutoCreateRowSorter(true);
		jTable1.getColumnModel().getColumn(0).setMinWidth(300);
		jTable1.getColumnModel().getColumn(0).setMaxWidth(300);
		jTable1.getColumnModel().getColumn(0).setPreferredWidth(300);
		jTable1.setFillsViewportHeight(true);
		add(new JScrollPane(jTable1), BorderLayout.CENTER);

		tableModel.addTableModelListener(new TableModelListener() {
			public void tableChanged(TableModelEvent e) {
				System.out.println("Table changed at row " + e.getFirstRow()
						+ " and column " + e.getColumn() + "\n");
			}
		});

		jTable1.getColumnModel().addColumnModelListener(
				new TableColumnModelListener() {
					public void columnRemoved(TableColumnModelEvent e) {
					}

					public void columnAdded(TableColumnModelEvent e) {
					}

					public void columnMoved(TableColumnModelEvent e) {
						System.out.println("Column indexed at "
								+ e.getFromIndex() + " is moved \n");
					}

					public void columnMarginChanged(ChangeEvent e) {
					}

					public void columnSelectionChanged(ListSelectionEvent e) {
					}
				});
	}

	public static void main(String[] args) {
		adjustToSystemGraphics();

		JFrame frame = new TableCellRendererEditor();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Table Cell Renderer and Editor Demo");
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((d.width - frame.getSize().width) / 2,
				(d.height - frame.getSize().height) / 2);
		frame.setVisible(true);
	}

	private static void adjustToSystemGraphics() {
		for (UIManager.LookAndFeelInfo info : UIManager
				.getInstalledLookAndFeels()) {
			if ("Nimbus".equals(info.getName())) {
				try {
					UIManager.setLookAndFeel(info.getClassName());
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				}
			}
		}
	}
}