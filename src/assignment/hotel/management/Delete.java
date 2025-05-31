
package assignment.hotel.management;

import java.io.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Lee Wei Jie
 */
public class Delete extends registeruser{
    public Delete(String username){
        super(username);
       }
    
    public void Deleteuser(){
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
            if (!name.equals(values[0])){
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
        fr.close();
        br.close();
        
        JOptionPane.showMessageDialog(null,"DATA DELETE SUCCESSFULLY");
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(null, "File not found");
    } 
    }
}
