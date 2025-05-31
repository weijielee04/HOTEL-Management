
package assignment.hotel.management;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

public class AppointmentAdd {
    private String technician;
    private String service;
    private String roomid;
    private String Status;
    private String date;
    private String payment;
    
    public AppointmentAdd(String technician, String service, String roomid, String Status){
        this.technician=technician;
        this.service=service;
        this.roomid=roomid;
        this.Status=Status;
    }
    
    
    public AppointmentAdd(String technician, String service, String roomid, String Status,String date,String payment){
        this.technician=technician;
        this.service=service;
        this.roomid=roomid;
        this.Status=Status;
        this.date=date;
        this.payment = payment;
    }
    public AppointmentAdd(String technician, String service, String roomid, String Status,String payment){
        this.technician=technician;
        this.service=service;
        this.roomid=roomid;
        this.Status=Status;
        this.payment=payment;
    }
    public AppointmentAdd(String date, String Status){
        this.date=date;
        this.Status=Status;
    }
    public AppointmentAdd(String date){
        this.date=date;
    }

    
    public void settechnician(String technician){
        this.technician=technician;
    }
    public String gettechnician(){
        return technician;
    }
    public void setservice(String service){
        this.service=service;
    }
    public String getservice(){
        return service;
    }
    public void setroomid(String roomid){
        this.roomid=roomid;
    }
    public String getroomid(){
        return roomid;
    }
    public void setStatus(String Status){
        this.Status=Status;
    }
    public String getStatus(){
        return Status;
    }
    public void setdate(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date d = new Date();
        String date1 = formatter.format(d);
        this.date=date1;
    }
    public String getdate(){
        return date;
    }
    public void setpayment(String payment){
        this.payment=payment;
    }
    public String getpayment(){
        return payment;
    }
    
    public void Addappointment(){
       try {
           setdate();

           FileWriter writer = new FileWriter("C:\\Users\\Lee Wei Jie\\Downloads\\School stuff\\SEM 5\\Java\\Assignment\\Appointment.txt",true);
           
           writer.write(technician+","+service+","+roomid+","+Status+","+payment+","+getdate()+"\n");
           writer.close();
           
           
           JOptionPane.showMessageDialog(null, "Appointment add successful");
       } catch (Exception e){
           JOptionPane.showMessageDialog(null,"Error occured while saving registration to file, Please try again");
       }
    }
    
}
