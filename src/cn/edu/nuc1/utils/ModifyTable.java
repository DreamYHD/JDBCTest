package cn.edu.nuc1.utils;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Administrator on 2017/6/7.
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
            mStatement.execute(sql);
            message="注册成功";
        } catch (SQLException mE) {
            mE.printStackTrace();
        }
        return message;
    }
}
