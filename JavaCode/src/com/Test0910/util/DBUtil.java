package com.Test0910.util;

import javax.sql.DataSource;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-09-10
 */
public class DBUtil {
    private static String url = "jdbc:mysql://127.0.0.1:3306/musicplayer" +
            "?useSSL=fasle";
    private static String username = "root";
    private static String password = "";

    private static volatile DataSource DATASOURCE;
    private static DataSource getDataSource() {
        if (DATASOURCE == null) {
            synchronized (DBUtil.class) {
                /*if (DATASOURCE == null){
                    DATASOURCE = new MysqlDataSource();
                    ((MysqlDataSource) DATASOURCE).setUrl(url);*/
            }
        }
        return null;
    }
}
