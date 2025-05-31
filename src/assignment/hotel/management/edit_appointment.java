
package assignment.hotel.management;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class edit_appointment extends AppointmentAdd {
    public edit_appointment(String technician, String service, String roomid, String Status, String payment){
       super(technician,service, roomid, Status, payment);
    }
    public void editappointmentfunction(){
        try {
        String filename = "C:\\Users\\Lee Wei Jie\\Downloads\\School stuff\\SEM 5\\Java\\Assignment\\Appointment.txt";
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        
        
        String table[][] = new String [1000][];
        String line ;
        int count = 0;
        String roomid = getroomid();
        while((line = br.readLine())!= null){
            String [] values = line.split(",");
            if (roomid.equals(values[2])){
                values[0] = gettechnician();
                values[1] = getservice();
                values[3] = getStatus();
                values[4] = getpayment();
            }
            table[count] = values;
            count++;
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
        
        JOptionPane.showMessageDialog(null,"APPOINTMENT UPDATE SUCCESSFULLY");
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(null, "File not found");
    }
    }
    
    
}
