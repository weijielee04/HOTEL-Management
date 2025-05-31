
package assignment.hotel.management;

import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;


public class feedback {
    private String roomid;
    private String name;
    private String feedback; 
    
    public feedback(String roomid, String name, String feedback){
        this.roomid=roomid;
        this.name=name;
        this.feedback=feedback;
    }
    
    public void enterfeedbackdatabase(){
      
        try {
            FileWriter writer = new FileWriter("C:\\Users\\Lee Wei Jie\\Downloads\\School stuff\\SEM 5\\Java\\Assignment\\Feedback.txt",true);
            
            writer.write(roomid+","+name+","+feedback+"\n");
            writer.close();
            
            JOptionPane.showMessageDialog(null, "Thanks for feedback\nHope you have a great time");
        }catch (IOException e){
            JOptionPane.showMessageDialog(null,"Error occured while saving the data, Please try again!");
        }
        
    }
    
}
