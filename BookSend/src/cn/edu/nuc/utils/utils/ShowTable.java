package cn.edu.nuc.utils.utils;

import cn.edu.nuc.utils.DBSystemManage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ShowTable {
    public static void showTable(JTable mJTable,String sql,int length,String[] mStrings){
        Object[][] mObjects = new Object[200][length];
        int index = 0;
        try {
            ResultSet mResultSet = DBSystemManage.getInstance().mStatement.executeQuery(sql);
            while (mResultSet.next()) {
                for (int i = 1; i <= length; i++) {
                    mObjects[index][i - 1] ="   "+mResultSet.getObject(i);
                }
                index++;
            }
        } catch (SQLException mE) {
            mE.printStackTrace();
        }
        Object[][] mO = new Object[index][length];
        for (int i = 0; i < index; i++) {
            for (int j = 0; j < length; j++) {
                mO[i][j] = mObjects[i][j];
            }
        }
        mJTable.setModel(new DefaultTableModel(mO, mStrings));
    }
}
