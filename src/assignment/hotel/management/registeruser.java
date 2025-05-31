
package assignment.hotel.management;

import java.io.*;
import javax.swing.*;


public class registeruser {
    private String username;
    private String password;
    private String gender;
    private String role;
    

    
    
    
    public registeruser(String username, String password, String gender, String role){
        this.username=username;
        this.password=password;
        this.gender=gender;
        this.role=role;

    }
    
    public registeruser(String username, String password){
        this.username=username;
        this.password=password;
    }
    public registeruser(String username){
        this.username=username;
    }
    public void setusername(String username){
        this.username=username;
    }
    
    public String getusername(){
        return username;
    }
        
    public void setpassword(String password){
        this.password=password;
    }
    
    public String getpassword(){
        return password;
    }
    public void setgender(String gender){
        this.gender=gender;
    }
    public String getgender(){
        return gender;
    }
    public void setrole(String role){
        this.role=role;
    }
    public String getrole(){
        return role;
    }
    
    public void enterdatabase(){
        try {
            FileWriter writer = new FileWriter("C:\\Users\\Lee Wei Jie\\Downloads\\School stuff\\SEM 5\\Java\\Assignment\\Account detail.txt" ,true);
            
            writer.write(username+","+password+","+gender+","+role+"\n");
            writer.close();
            
            JOptionPane.showMessageDialog(null, "Registration successful");
            
        } catch (IOException e){
            JOptionPane.showMessageDialog(null,"Error occurred while saving registration to file, Please try again");
        }
    }
    
    public String validation(){
        try{
            FileReader fr = new FileReader("C:\\Users\\Lee Wei Jie\\Downloads\\School stuff\\SEM 5\\Java\\Assignment\\Account detail.txt");
            BufferedReader br = new BufferedReader(fr);
            String table [][] = new String [100][];
            String line;
            int count = 0;
            String role;
            while((line = br.readLine()) !=null){
                String [] values = line.split(",");
                if (username.equals(values[0])&&password.equals(values[1])){
                    role=values[3];
                    return role;
                    }  
                }
            return "Incorrect Password or Username\n Please try again";
            }catch(FileNotFoundException e){
                JOptionPane.showMessageDialog(null,"Error occurred while saving registration to file, Please try again");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null,"Error occured while reading the file, Please try again");
            }
        return null;
        }          
    }    

    
    

