package com.gfg.library69.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DBConfiguration {


    @Value("${mysql-uri}")
    String uri;

    @Value("${mysql-username}")
    String username;
    @Value("${mysql-password}")
    String password;

//    @Bean("Database")
//    public Connection mysqlConnection(){
//        System.out.println(" I am getting called here from configuration");
//        Connection connection=null;
//        try {
//            connection= DriverManager.getConnection(uri,username,password);
//
//        } catch (SQLException e) {
//            System.out.println("Exception here"+e.getMessage());
//        }
//        return connection;
//    }

//    @Bean("sampleBean2")
//    public Connection oracleConnection(){
//        System.out.println(" I am getting called here from configuration");
//        Connection connection=null;
//        try {
//            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/library","jbdl69dl","Jbdl@69dl");
//        } catch (SQLException e) {
//            System.out.println("Exception here"+e.getMessage());
//        }
//        return connection;
//    }
}
