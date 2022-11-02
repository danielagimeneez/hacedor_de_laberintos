/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author andres
 */
public class eTable extends JTable{
    @Override
    public Component prepareRenderer (TableCellRenderer renderer, int rowIndex, int columnIndex){
        Component component = super.prepareRenderer (renderer, rowIndex, columnIndex);
        component.setBackground (Color.WHITE) ;
        component.setForeground (Color.WHITE) ;
        int val = Integer.parseInt(getValueAt(rowIndex, columnIndex).toString());
        if (val==3) {
            component.setBackground(Color.BLUE);
            component.setForeground(Color.BLUE);
        }else if(val==5){
            component.setBackground(Color.GREEN);
            component.setForeground(Color.GREEN);
        }else if(val == 0){
            component.setBackground(Color.BLACK);
            component.setForeground(Color.BLACK);
        }
        return component;
    }
 
}
