import java.awt.Color; 
import java.awt.Dimension; 
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class ChessFrame extends JFrame implements ActionListener{ 
	static JMenuBar mb=new JMenuBar();
	static JMenu youxi=new JMenu("��Ϸģʽ");
	static JMenuItem moshi1=new JMenuItem("���˶�ս��");
	static JMenuItem moshi2=new JMenuItem("�˻���ս");
//	static  JButton k=new JButton("��ʼ");
	 public ChessFrame() { 
	  // ���ñ��� 
	  this.setTitle("������"); 
      
	  this.setResizable(false); 
	  // ����Ĭ�Ϲر�ѡ�� 
	  this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
	  // �������ڴ����� 
	              //  setBackground(Color.pink);
	                //this.add(new ChessBoardPanel()); 
	                
	               
	               } 
	               public static void main(String[] args) { 
	            	   ChessFrame cf=new ChessFrame(); 
	            	   ChessBoardPanel cb =new ChessBoardPanel();
	            	
	                cb.setBackground(Color.PINK);
	                cf.setJMenuBar(mb);	
	                youxi.add(moshi1);
	            	 youxi.add(moshi2);
	            	 mb.add(youxi); 
	            	 cf.add(cb);
	            	 JLabel image2; 
	            	 JLabel image1; 
	           	  cb.add(image1 = new JLabel(new ImageIcon("2.jpg"))); 
	           	  image1.setBounds(-478,-150,1600,900);
	           	cb.add(image2 = new JLabel(new ImageIcon("2.jpg"))); 
	           	image2.setBounds(0,-150,1600,900);
	            	moshi1.addActionListener(new ActionListener(){

	            		public void actionPerformed(ActionEvent e) {
							if(cb.start==false){
								moshi1.setText("���˶�ս��");
								moshi2.setText("�˻���ս");
								for (int i = 0; i < 19; i++) { 
							        for (int j = 0; j < 19; j++) { 
							         cb.arr[i][j] = 0; 
							        } 
							       }
								cb.PVP=true;
							    JOptionPane.showMessageDialog(null, "���˶�ս"); 
							}
							else{
								JOptionPane.showMessageDialog(null, "�����ڶԾ����л�ģʽ��");
							}
	            			
						}
	            	
	            	});
	            	moshi2.addActionListener(new ActionListener(){

	            		public void actionPerformed(ActionEvent e) {
	            			if(cb.start==false){
	            				moshi2.setText("�˻���ս��");
	            				moshi1.setText("���˶�ս");
	            				for (int i = 0; i < 19; i++) { 
	            			        for (int j = 0; j < 19; j++) { 
	            			         cb.arr[i][j] = 0; 
	            			        } 
	            			       }
								cb.PVP=false;
							    JOptionPane.showMessageDialog(null, "�˻���ս"); 
							}
							else{
								JOptionPane.showMessageDialog(null, "�����ڶԾ����л�ģʽ��");
							}
						}
	            	
	            	});
	            	 
	            	   cf.setBounds(100,100,800,670);
	            
	            	   cf.setVisible(true); 
	            	   
	            	  
	               }
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				} 
	              } 
	               
