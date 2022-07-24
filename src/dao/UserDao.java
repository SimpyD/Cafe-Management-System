/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.User;
import java.util.ArrayList;

public class UserDao {
    //passing the object
    public static void save(User user){
        //extract values
        //and save details in db
        
        String query = "insert into user(name , email , mobileNumber,address,password,securityQuestion,answer,status) values('"+user.getName()+"','"+user.getEmail()+"','"+user.getMobileNumber()+"','"+user.getAddress()+"','"+user.getPassword()+"','"+user.getSecurityQuestion()+"','"+user.getAnswer()+"','false')";
        DbOperations.setDataOrDelete(query, "Registered Sucessfully !! Wait for admin approval");
    }
    
    
    public static User  login(String email,String password){
        //check user exits or not
        User user = null;
        try {
            //call the result set
            //a mehtod in dboperations
            ResultSet rs = DbOperations.getData("select * from user where email = '"+email+"' and password = '"+password+"'");
            while(rs.next()){
                user = new User();
                user.setStatus(rs.getString("status"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return user;
    }
    
    public static User getSecurityQuestion(String email){
           User user = null;
        try {
            //call the result set
            //a mehtod in dboperations
            ResultSet rs = DbOperations.getData("select * from user where email = '"+email+"'");
            while(rs.next()){
                user = new User();
                user.setSecurityQuestion(rs.getString("securityQuestion"));
                user.setAnswer(rs.getString("answer"));
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return user;
    }
    
    public static void update(String email,String newPassword){
        String query = "update user set password = '"+newPassword+"' where email = '"+email+"'";
        DbOperations.setDataOrDelete(query, "password changed sucessfully");
    }
    
    //for verify table
    public static ArrayList<User> getAllRecords(String email){
        ArrayList<User> list = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("select * from user where email like '%"+email+"%'");
            
            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setMobileNumber(rs.getString("mobileNumber"));
                user.setAddress(rs.getString("address"));
                user.setSecurityQuestion(rs.getString("securityQuestion"));
                user.setStatus(rs.getString("status"));
                
                list.add(user);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }
    
    //update from verify
    public static void changeStatus(String email,String status){
        String query = "update user set status = '"+status+"' where email = '"+email+"'";
        DbOperations.setDataOrDelete(query, "status updated sucessfully");
    }
    
    public static void changePassword(String email , String oldPassword,String newPassword){
        
        try {
            ResultSet rs = DbOperations.getData("select * from user where email = '"+email+"' and password = '"+oldPassword+"'");
            if(rs.next()){
                update(email, newPassword);
            }else{
                JOptionPane.showMessageDialog(null, "Password doesnt match!!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public static void changeSecurityQestion(String email,String password,String securityQuestion,String answer){
        try {
            ResultSet rs = DbOperations.getData("select * from user where email = '"+email+"'&& password = '"+password+"'");
            
            if(rs.next()){
                update(email, securityQuestion, answer);
            }else{
                JOptionPane.showMessageDialog(null, "Incorrect email or password!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public static void update(String email,String securityQuestion,String answer){
        String query = "update user set securityQuestion = '"+securityQuestion+"' , answer = '"+answer+"' where email = '"+email+"'";
        DbOperations.setDataOrDelete(query, "Security Question changed sucessfully");
    }
}
