package assignment.hotel.management;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Update extends registeruser {
    
    public Update(String username, String password, String gender, String role) {
        super(username, password, gender, role);
    }
    
    public void Updateuser(){
    try {
        String filename = "C:\\Users\\Lee Wei Jie\\Downloads\\School stuff\\SEM 5\\Java\\Assignment\\Account detail.txt";
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        
        
        String table[][] = new String [100][];
        String line ;
        int count = 0;
        String name = getusername();
        while((line = br.readLine())!= null){
            String [] values = line.split(",");
            if (name.equals(values[0])){
                values[1] = getpassword();
                values[2] = getgender();
                values[3] = getrole();
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
            for (int j=0; j<4 ; j++){
                if (j==3){
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
        
        JOptionPane.showMessageDialog(null,"DATA UPDATE SUCCESSFULLY");
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(null, "File not found");
    }
    }
    
}

