package HomeWork8;

import javax.swing.table.AbstractTableModel;
import java.io.IOException;
import java.util.ArrayList;

public class TableModel extends AbstractTableModel {

    ArrayList<Row> data;

    String [] columnNames = {"Страна", "Количество зараженных"};

    public TableModel(){
        data = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Row row = this.data.get(rowIndex);
        return row.getFild(columnIndex);
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public void addRow(Row r){
        data.add(r);
        fireTableDataChanged();
    }

    public void setDataByFilter(String continent) throws IOException {
        this.data = new ArrayList<Row>(DataStat.getDataByFilter(continent));
        fireTableDataChanged();
    }

}
