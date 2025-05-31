
package assignment.hotel.management;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;


public class setcomplete extends AppointmentAdd{
    public setcomplete(String date){
        super(date);
    }
    
    public void setcomplete(){
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
            if (date.equals(values[5])){
                values[3]= "Complete";
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
        fr.close();
        br.close();
        
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(null, "File not found");
    } 
        
    }
    
}
