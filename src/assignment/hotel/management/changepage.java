
package assignment.hotel.management;

import javax.swing.JFrame;

public class changepage {
    private String filename;
    private JFrame currentFrame;
    
    public changepage (JFrame currentFrame, String filename){
        this.filename=filename;    
        this.currentFrame = currentFrame;
    }

    public void selectpage(){
        JFrame newpage = new JFrame(filename);
        newpage.setVisible(true);
        currentFrame.dispose();
    }
    
}
