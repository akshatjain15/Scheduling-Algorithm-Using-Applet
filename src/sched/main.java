
package sched;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class main extends Applet implements ActionListener {
String msg;
Button FCFS,SJFS,PRIORITY,RR;
       public void init() {
    	   Color c1 = new Color(160,32,240);
    	   setBackground(c1);
    	   Color c2 = new Color(238,130,238); 
            Button FCFS = new Button("FCFS");
           Label x = new Label("x",Label.CENTER);
           add(x);
           SJFS = new Button("SJFS");
           PRIORITY = new Button("PRIORITY");
           RR= new Button ("RR");
           add(FCFS);
           add(SJFS);
           add(PRIORITY);
           
           FCFS.addActionListener(this);
           SJFS.addActionListener(this);
            PRIORITY.addActionListener(this);
           SJFS. setBackground(c2);
           FCFS. setBackground(c2);
           PRIORITY. setBackground(c2);
           
           }
      public void actionPerformed(ActionEvent ae)
      {
           String str = ae.getActionCommand();
           if(str.equals("FCFS"))
           {
           msg = "You pressed FCFS.";
            new fcfs().setVisible(true);
           this.hide();
           }
          else if(str.equals("SJFS")) 
          {
           msg = "You pressed SJFS.";
           this.hide();
           new sjfs().setVisible(true);
          }
           else  if (str.equals("PRIORITY"))
           {
        	   msg = "You pressed priority.";
               new Priority().setVisible(true);
               this.hide();
           }
           
           repaint();
           }
           public void paint(Graphics g) {
        	   g.setColor(Color.yellow);
           g.drawString(msg, 6, 100);
           this.setSize(680,610);
           
           }
          
}

	
	
