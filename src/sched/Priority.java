package sched;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Priority  extends JFrame implements ActionListener
 {
	   JButton jb[] = new JButton[3];
	   JTextField  jt1[],jt2[];
	   JLabel  jl[],jl1,jl2,jl3;
	   JPanel  jp,jp1,jp2;
	   Container con;
	   int  k,p;
	   String str[] = {"SUBMIT","RESET","EXIT"};
	   String str1[] = {"process","burst time","priority"};
	  
	   public Priority()
	   {
		   super("Priority scheduling algoritham");
		   con = getContentPane();
		   k= Integer.parseInt(JOptionPane.showInputDialog("Enter number of process"));

		   jl1 = new JLabel("Process");
		   jl2 = new JLabel("Burst time");
		   jl3 = new JLabel("priority");

		   jl = new JLabel[k];
	       jt1 = new JTextField[k];
		   jt2 = new JTextField[k];
		   for(int i=0;i<k;i++)
			{
			   jl[i] = new JLabel("process"+(i+1));
			   jt1[i]  = new JTextField(10);
	           jt2[i]  = new JTextField(10);
		   }
		   for(int i=0;i<3;i++)
		   {
			  jb[i] = new JButton(str[i]);
		  }
		   con.setLayout(new  GridLayout(k+2,3));
			  con.add(jl1);
			  con.add(jl2);
			  con.add(jl3);

			  int l=0;

			  for(int i=0;i<k;i++)
				{
		            con.add(jl[l]);
					con.add(jt1[l]);
					con.add(jt2[l]);
					l++;
			  }
			  l=0;
			  for(int i=0;i<3;i++)
				{
				  con.add(jb[l]);
				  jb[l].addActionListener(this);
				  l++;
		        }
			}
	 
	   public void actionPerformed(ActionEvent ae) 
		{
		 
		   int p[]= new int[k];
			 int b[]=new int [k];
			String c[]= new String[k];
			for(int i=0;i<k;i++)
			  {
				 
				      p[i]=Integer.parseInt(jt2[i].getText());
				      b[i]=Integer.parseInt(jt1[i].getText());  
				      c[i]="process"+(i+1);
			  }
			
			int summ=0;
			 
			if(ae.getSource() == jb[2])
	        {
				System.exit(0);
		    }
			else if(ae.getSource() == jb[1])
			{
				setVisible(false);
			    Priority  window = new Priority();
				window.setSize(400,300);
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
			
				  
				  for (int i = 0; i < k-1; i++)
				  {
			            for (int j = 0; j < k-i-1; j++)
			            {
			            	if(p[j] == p[j+1])
			            	{
			            		String s3="cant asssign same prioroty ";
			            		
			            		jp1.add(new JLabel(s3));
			            		 main.add(jp1,BorderLayout.NORTH);
			            		 JOptionPane.showMessageDialog(null,main,"output",JOptionPane.PLAIN_MESSAGE);
			            		 System.exit(0);
			            	}
			                if (p[j] > p[j+1])
			                {
			                    int temp =p[j];
			                    p[j] = p[j+1];
			                    p[j+1] = temp;
			                    
			                    int temp1 =b[j];
			                    b[j] = b[j+1];
			                    b[j+1] = temp1;
			                    
			                    String s1=c[j];
			                    c[j] = c[j+1];
			                    c[j+1] = s1;
			                }
			            }
			            
			            summ+=b[i];
				  }
				  for (int i=0;i<3;i++ )
		            {
					  jp.add(new JLabel(str1[i]));
		            }
					for (int i=0;i<k;i++)
					{
					  //jp.add(new JLabel("process"+(i+1)));
						jp.add(new JLabel("   "+c[i]));
					 jp.add(new JLabel("   "+b[i]));
					  jp.add(new JLabel("   "+p[i]));
					  
					  
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
	            Priority  window = new Priority();
				window.setSize(200,300);
				window.setVisible(true);
				window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

  }
		
 