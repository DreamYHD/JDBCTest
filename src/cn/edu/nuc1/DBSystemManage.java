package cn.edu.nuc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Administrator on 2017/6/10.
 */
public class DBSystemManage {
    //数据库名称
    public final static String URL ="jdbc:mysql://localhost:3306/BookGetSendSystem";
    //用户名
    public final static String USERNAME = "root";
    //密码
    public final static String PASSWORD = "478214";
    //驱动
    public final static String DRIVER = "com.mysql.jdbc.Driver";
    //连接
    public Connection mConnection;
    //执行sql语句操作的对象
    public Statement mStatement;
    private static DBSystemManage  mDBSystemManage = new DBSystemManage();
    public static DBSystemManage getInstance(){
        return mDBSystemManage;
    }
    private DBSystemManage(){
        try {
            //注册驱动
            Class.forName(DRIVER);
            mConnection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            mStatement = mConnection.createStatement();
        } catch (ClassNotFoundException mE) {
            mE.printStackTrace();
        } catch (SQLException mE) {
            mE.printStackTrace();
        }
    }
    public  void onDestroy(){
        if (mConnection != null) {
            try {
                mConnection.close();
            } catch (SQLException mE) {
                mE.printStackTrace();
            }
        }
        if (mStatement != null) {
            try {
                mStatement.close();
            } catch (SQLException mE) {
                mE.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        DBSystemManage.getInstance();
    }

}

