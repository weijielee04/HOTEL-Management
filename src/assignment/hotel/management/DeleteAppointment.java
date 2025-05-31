/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.hotel.management;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Lee Wei Jie
 */
public class DeleteAppointment extends AppointmentAdd{
    public DeleteAppointment(String technician, String service, String roomid, String Status, String date,String payment){
        super(technician,service, roomid, Status, date, payment);
    }
   
    
    public void DeleteAppointment1(){
        try {
        String filename = "C:\\Users\\Lee Wei Jie\\Downloads\\School stuff\\SEM 5\\Java\\Assignment\\Appointment.txt";
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        
        
        String table[][] = new String [100][];
        String line ;
        int count = 0;
        String date = getdate();
        while((line = br.readLine())!= null){
            String [] values = line.split(",");
            if (!date.equals(values[5])){
                table[count] = values;
                count++;
            }
        }
        
        br.close();
        fr.close();
        
        FileWriter fw = new FileWriter(filename);
        BufferedWriter bw = new BufferedWriter(fw);
        for(int i=0;i<count;i++){
            String sentences = "";
            for (int j=0; j<6 ; j++){
                if (j==5){
                    sentences = sentences+table[i][j];
                }else{
                    sentences = sentences+table[i][j]+",";
                }
            }
            sentences = sentences +"\n";
            bw.write(sentences);
        }
        
        bw.close();
        fw.close();
        fr.close();
        br.close();
        
        JOptionPane.showMessageDialog(null,"Appointment DELETE SUCCESSFULLY");
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(null, "File not found");
    } 
    }
    
}
