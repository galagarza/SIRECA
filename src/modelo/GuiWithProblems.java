/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author aaron
 */
import java.util.Date;
import java.util.Random;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.AbstractCellEditor;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.table.TableCellEditor;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
public class GuiWithProblems extends JFrame {
	private static final long serialVersionUID = 1L;
	private DataTableModel model;
 
	public enum TableHeader {
		Date(Date.class), Counter(Integer.class), Name(String.class);
		Class< ?> currClass;
		private TableHeader(Class < ?>currClass) {this.currClass = currClass;}
		public Class < ?>getCurrClass() {return currClass;}
	}
 
	@SuppressWarnings("unchecked")
	public GuiWithProblems() {
		super("Simple GUI with JTable");
		setPreferredSize(new Dimension(600, 500));
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		@SuppressWarnings("unused")
		Vector< ?> data = new Vector();
		model = new DataTableModel();		
		JTable table = new JTable();
		table.setModel(model);
		table.setColumnSelectionAllowed(false);
		table.setRowSelectionAllowed(true);
		TableCellRenderer render = new GuiCellRenderer();
		TableColumn col = table.getColumnModel().getColumn(TableHeader.Name.ordinal());
		JButton editorBtn = new JButton();
		col.setCellEditor(new GuiCellEditor(table));
		col.setCellRenderer(new NameBtnCellRenderer(editorBtn));
		table.setDefaultRenderer(Date.class, render);
		table.setDefaultRenderer(Double.class, render);
		table.setDefaultRenderer(Long.class, render);
		table.setDefaultRenderer(Integer.class, render);
		table.setDefaultRenderer(String.class, render);
		getContentPane().add(new JScrollPane(table), BorderLayout.CENTER);
	}
 
	@SuppressWarnings("unchecked")
	private void addData() {
		Random random = new Random(new Date().getTime());
		for (int i = 0; i < 20; i++) {
			Vector data = new Vector();
			data.add(TableHeader.Date.ordinal(), new Date());
			data.add(TableHeader.Counter.ordinal(), i);
			data.add(TableHeader.Name.ordinal(), random.nextInt() + "");
			model.add(data);	
		}
	}
 
	final void showGui() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {	pack();	setVisible(true);}
		});
	}
 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final GuiWithProblems instance = new GuiWithProblems();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				instance.showGui();
				instance.addData();
			}
		});
 
	}
 
	public class DataTableModel extends AbstractTableModel {
		private static final long serialVersionUID = 769042563295665904L;
		@SuppressWarnings("unchecked")
		private Vector data;
 
		@SuppressWarnings("unchecked")
		public DataTableModel() {
			data = new Vector();
		}
 
		@Override
		public Class<?> getColumnClass(int columnIndex) {return TableHeader.values()[columnIndex].getCurrClass();}
 
		@Override
		public int getRowCount() {return data.size();}
 
		@SuppressWarnings("unchecked")
		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			Vector elem = (Vector) data.get(rowIndex);
			switch (TableHeader.values()[columnIndex]) {
			case Date: 
				return elem.get(TableHeader.Date.ordinal());
			case Counter: 
				return elem.get(TableHeader.Counter.ordinal());
			case Name:
				return elem.get(TableHeader.Name.ordinal());
			default: 
				return null;
			}
		}
 
		@Override
		public int getColumnCount() {return TableHeader.values().length;}
 
		@Override
		public String getColumnName(int column) {return TableHeader.values()[column].name();}
 
		@Override
		public boolean isCellEditable(int row, int column) {
			if (column == TableHeader.Name.ordinal()) return true; // ENABLE THE EDITOR JUST FOR THE NAME
			return false;
		}
 
		public void add(final Object elem) {
			SwingUtilities.invokeLater(new Runnable() {
				@SuppressWarnings("unchecked")
				public void run() {
					data.add(elem);
					int rows = getRowCount() - 1;
					fireTableRowsInserted(rows, rows);
				} 
			});
		}
	}
	// General editor
	class GuiCellRenderer extends DefaultTableCellRenderer  {
		private static final long serialVersionUID = 211718743340765799L;
		private SimpleDateFormat dForm;
		public GuiCellRenderer() {
			super();
			dForm = new SimpleDateFormat("hh:mm:ss a");
		}
 
		@Override
		public Component getTableCellRendererComponent(JTable table, Object val, boolean select, boolean focus, int row, int col) {
			super.getTableCellRendererComponent(table, val, select, focus, row, col); // Make sure gets called
			switch (TableHeader.values()[table.convertColumnIndexToModel(col)]) {
			case Date:
				setText(dForm.format((Date)val));
				break;
			case Counter:
				Integer iVal = (Integer) val;
				setText(iVal.toString());
				break;
			case Name:
				setText((String) val);
				break;
			default:
				setText(val.toString());
				break;
			}
			return this;
		}
	}
	// Renderer used only for the name, renders column as button
	class NameBtnCellRenderer extends DefaultTableCellRenderer  {
		private static final long serialVersionUID = 2L;
		private JButton btn;
		public NameBtnCellRenderer(final JButton aBtn) {
			super();
			btn = aBtn;
			btn.setFocusPainted(false);
		}
 
		@Override
		public Component getTableCellRendererComponent(JTable table, Object val, boolean select, boolean focus, int row, int col) {
			super.getTableCellRendererComponent(table, val, select, focus, row, col);
            if (focus)  {
            	btn.setForeground(table.getForeground());
            	btn.setBackground(UIManager.getColor("Button.background"));
            }
            else if (select) {
            	btn.setForeground(table.getSelectionForeground());
            	btn.setBackground(table.getSelectionBackground());
            } else {
            	btn.setForeground(table.getForeground());
            	btn.setBackground(UIManager.getColor("Button.background"));
            }
 
            btn.setText( (val == null) ? "" : val.toString() );
            return btn;
		}
	}
	// Cell editor for the name (button)
	public final class GuiCellEditor extends  AbstractCellEditor implements TableCellEditor, ActionListener {
		private static final long serialVersionUID = 9L;
		private JButton btn;
		private Component comp;
		public GuiCellEditor(final Component aComp) {
			btn = new JButton();
			btn.addActionListener(this);
			comp = aComp;
		}
 
		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
			String val = table.getValueAt(row, column) == null? "": table.getValueAt(row, column).toString();
			btn.setText(val);
			return btn;
		}
 
		@Override
		public Object getCellEditorValue() { return btn.getText(); }
 
		@Override		
		public void actionPerformed(ActionEvent e) {
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					SwingUtilities.invokeLater(new Runnable() {
						@Override
						public void run() {
							fireEditingStopped();
							JOptionPane.showMessageDialog(comp, String.format("Not much to show, %s", btn.getText()), "About", JOptionPane.INFORMATION_MESSAGE, null);
						}
					});
 
				}
			});
		}
	}
 
}
