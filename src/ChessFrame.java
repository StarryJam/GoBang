import java.awt.Color; 
import java.awt.Dimension; 
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class ChessFrame extends JFrame implements ActionListener{ 
	static JMenuBar mb=new JMenuBar();
	static JMenu youxi=new JMenu("游戏模式");
	static JMenuItem moshi1=new JMenuItem("人人对战√");
	static JMenuItem moshi2=new JMenuItem("人机对战");
//	static  JButton k=new JButton("开始");
	 public ChessFrame() { 
	  // 设置标题 
	  this.setTitle("五子棋"); 
      
	  this.setResizable(false); 
	  // 设置默认关闭选项 
	  this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
	  // 将面板放于窗口中 
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
								moshi1.setText("人人对战√");
								moshi2.setText("人机对战");
								for (int i = 0; i < 19; i++) { 
							        for (int j = 0; j < 19; j++) { 
							         cb.arr[i][j] = 0; 
							        } 
							       }
								cb.PVP=true;
							    JOptionPane.showMessageDialog(null, "人人对战"); 
							}
							else{
								JOptionPane.showMessageDialog(null, "不能在对局中切换模式！");
							}
	            			
						}
	            	
	            	});
	            	moshi2.addActionListener(new ActionListener(){

	            		public void actionPerformed(ActionEvent e) {
	            			if(cb.start==false){
	            				moshi2.setText("人机对战√");
	            				moshi1.setText("人人对战");
	            				for (int i = 0; i < 19; i++) { 
	            			        for (int j = 0; j < 19; j++) { 
	            			         cb.arr[i][j] = 0; 
	            			        } 
	            			       }
								cb.PVP=false;
							    JOptionPane.showMessageDialog(null, "人机对战"); 
							}
							else{
								JOptionPane.showMessageDialog(null, "不能在对局中切换模式！");
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
	               
