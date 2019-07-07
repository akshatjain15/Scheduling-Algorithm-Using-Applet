package sched;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class   fcfs  extends JFrame implements ActionListener
{
   JButton jb[] = new JButton[3];
   JTextField  jt1[];
   JLabel  jl[],jl1,jl2;
   JPanel  jp,jp1;
   Container con;
   int  k,p;
   String str[] = {"SUBMIT","RESET","EXIT"};
   String str1[] = {"Process","   BT"};


   public fcfs()
	{
       super("fcfs scheduling algoritham");
	   con = getContentPane();

	   k= Integer.parseInt(JOptionPane.showInputDialog("Enter number of process"));

	   jl1 = new JLabel("Process");
	   jl2 = new JLabel("Burst Time");
	   

	   jl = new JLabel[k];
       jt1 = new JTextField[k];
	  


       for(int i=0;i<k;i++)
		{
		   jl[i] = new JLabel("process"+(i+1));
		   jt1[i]  = new JTextField(10);
          
	   }

	  for(int i=0;i<2;i++)
	{
		  jb[i] = new JButton(str[i]);
	  }

	  con.setLayout(new  GridLayout(k+2,3));
	  con.add(jl1);
	  con.add(jl2);
	 

	  int l=0;

	  for(int i=0;i<k;i++)
		{
            con.add(jl[l]);
			con.add(jt1[l]);
			
			l++;
	  }
	  l=0;
	  for(int i=0;i<2;i++)
		{
		  con.add(jb[l]);
		  jb[l].addActionListener(this);
		  l++;
        }
	}

	public void actionPerformed(ActionEvent ae)
	{
		 int b[]=new int [k];
		int summ=0;
		 
		if(ae.getSource() == jb[2])
        {
			System.exit(0);
	    }
		else if(ae.getSource() == jb[1])
		{
			setVisible(false);
		    Priority  window = new Priority();
			window.setSize(100,300);
			window.setVisible(true);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
		else if(ae.getSource() == jb[0])
		{
			
			 JPanel main = new JPanel();
			 main.setLayout(new BorderLayout());
			 jp = new JPanel();
			 jp1 = new JPanel();
			 jp.setLayout(new GridLayout(k+1,7));
			 jp1.setLayout(new FlowLayout());
		
			  
			 for(int i=0;i<k;i++)
			  {
				 b[i]=Integer.parseInt(jt1[i].getText());  
				 
				 summ+=b[i];
		       }
			  for (int i=0;i<2;i++ )
	            {
				  jp.add(new JLabel(str1[i]));
	            }
				for (int i=0;i<k;i++)
				{
			    jp.add(new JLabel("process"+(i+1)));
				jp.add(new JLabel("   "+b[i]));
				  
				}
				int avg=summ/k;
				
				String str2 = "Average Waiting Time is "+ avg;
	             jp1.add(new JLabel(str2));
				 main.add(jp,BorderLayout.NORTH);
				 main.add(jp1,BorderLayout.SOUTH);

	          JOptionPane.showMessageDialog(null,main,"output",JOptionPane.PLAIN_MESSAGE);

	        }
	}

   
	public static void main(String[] args)
	{
            fcfs  window = new fcfs();
			window.setSize(500,300);
			window.setVisible(true);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
