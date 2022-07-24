/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.swing.JOptionPane;

public class tables {

    public static void main(String[] args) {
        try {
            String userTable = "create table user(id int AUTO_INCREMENT primary key, name varchar(200), email varchar(200), mobileNumber varchar(10), address varchar(200), password varchar(200), securityQuestion varchar(200),answer varchar(200), status varchar(20), UNIQUE(email))";
            String adminDetails = "insert into user(name , email , mobileNumber,address,password,securityQuestion,answer,status) "
                    + "values('Admin','admin@gmail.com','1212121212','bhilai','admin','book','aos','true')";

            //craete tabel for categories
            String categoryTable = "create table category(id int AUTO_INCREMENT primary key, name varchar(200))";
//            table for bill
            String billTable = "create table bill(id int primary key, name varchar(200),mobileNumber varchar(200),email varchar(200),date varchar(50),total varchar(200), createdBy varchar(200))";
//            product table
            String productTable = "create table product(id int AUTO_INCREMENT primary key, name varchar(200),category varchar(200),price varchar(200))";
            //use dboperation
            DbOperations.setDataOrDelete(userTable, "User Table Created Sucessfully");
            DbOperations.setDataOrDelete(adminDetails, "Admin details added Sucessfully");
            DbOperations.setDataOrDelete(categoryTable, "Category Table Created Sucessfully");
            DbOperations.setDataOrDelete(productTable, "Product table created sucessfully!!");
            DbOperations.setDataOrDelete(billTable, "bill table created sucesfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
