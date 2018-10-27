/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Tejada
 */
    public class ColorT extends DefaultTableCellRenderer{
        private int columna ;

    public ColorT(int Colpatron)
    {
    this.columna = Colpatron;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
    super.getTableCellRendererComponent(table, value, selected, focused, row, column);
    if(table.getValueAt(row,columna).equals("0"))
    {
        this.setForeground(Color.RED);
    }else if(table.getValueAt(row,columna).equals("1")){
        this.setForeground(Color.BLUE);
    }
    return this;
    }
  }
