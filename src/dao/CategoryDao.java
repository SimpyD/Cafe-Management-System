/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Category;

public class CategoryDao {

    public static void save(Category category) {
        
        String query = "insert into category (name) values ('" + category.getName() + "')";
        
        DbOperations.setDataOrDelete(query, "category added suscessfully");
    }

    //loading all deatils
    public static ArrayList<Category> getAllRecords() {
        ArrayList<Category> list = new ArrayList<>();
        
        try {
            ResultSet rs = DbOperations.getData("select * from category");
            while(rs.next()){
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                list.add(category);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        return list;
    }
    
    //delete any category
    public static void delete(String id){
        String query = "delete from category where id = '"+id+"'";
        DbOperations.setDataOrDelete(query, "Category Deleted sucessfully");
    }
}
