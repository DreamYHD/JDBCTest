package cn.edu.nuc.utils.utils;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * sql语句执行
 */
public class ModifyTable {
    private String sql="";
    private String message="";
    private Statement mStatement;

    public ModifyTable(Statement mStatement) {
       this.mStatement=mStatement;
    }
    public void setSql(String mSql) {
        sql = mSql;
    }
    public String modifyRecord(){
        try {
            //执行sql
            mStatement.execute(sql);
        } catch (SQLException mE) {
            mE.printStackTrace();
        }
        return message;
    }
}
