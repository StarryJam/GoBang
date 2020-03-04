
public class Mark {
               
	int sum=0;
    int sum1=0;
    int sum2=0;
    int max=0;
    int chess=0;
    int x;
    int y;
    int[][] arr=new int[19][19];
    int[][] mark=new int[19][19];
    
    int getX(){return x;}
    int getY(){return y;}
    
    void setChess(int a){
    	chess=a;
    }
    
    void copy(int a,int b,int c){
		arr[a][b]=c;
	}
    
	void clean(){
		for(int i=0;i<19;i++){
			for(int j=0;j<19;j++){
				arr[i][j]=0;
				max=0;
			}
		}
	}
	

	
	void add(){
		
    	//先手分数 
        for(int i=0;i<19;i++){
        	for(int j=0;j<19;j++){
        	sum=0;
            sum1=0;
            sum2=0;
            int both=0;
            int dead=0;
            int p=0;
            mark[i][j]=0;
        		if(arr[i][j]==0){
        			//西北.东南方向
        			p=0;both=0;dead=0;
        			for(int k=1;k<=4;k++)
        			{
        				if(i-k>=0&&j-k>=0)
        				{
        					if(arr[i-k][j-k]==-chess)
        					{
        						p++;
        					    dead++;
        				    }
        				    else if(arr[i-k][j-k]==chess){
        						both++;
        					    break;
        				    }
        				    else
        				    {
        				    	for(int l=k;l<=4;l++)
        					    {
        					    	if(i-l>=0&&j-l>=0)
        					    	{
        					    		if(arr[i-l][j-l]==0)
        							    {
        								   dead++;
        							    }
        						    }
        					    }
        					    break;
        				    }
        			    }
        		    }
        			for(int k=1;k<=4;k++){
        				if(i+k<19&&j+k<19){
        				if(arr[i+k][j+k]==-chess){
        					p++;
        					dead++;
        				}
        				else if(arr[i+k][j+k]==chess){
        					if(k!=1)
        						both++;
        					break;
        				}
        				else{
        					for(int l=k;l<=4;l++){
        						if(i+l<19&&j+l<19){
        							if(arr[i+l][j+l]==0){
        								dead++;
        							}
        						}
        					}
        					break;
        				}
        			}
        		}
        		if(dead>=4){
        			if (both==0&&p!=0)          //对方四子
        			{
        				sum1=(int) (sum1+Math.pow(10,p));
        			}
        			else if (both==1&&p!=0)        //对方三子
        			{
        				sum1=(int) (sum1+Math.pow(10,p-1));
        			}
			        if(p>=4)
			        {
			        	sum1=sum1+1000000;
			        }
        		}
        			
        			
        			//左右方向
        			p=0;both=0;dead=0;
        			for(int k=1;k<=4;k++){
        				if(i-k>=0){
        				if(arr[i-k][j]==-chess){
        					p++;
        					dead++;
        				}
        				else if(arr[i-k][j]==chess){
        						both++;
        					break;
        				}
        				else{
        					for(int l=k;l<=4;l++){
        						if(i-l>=0){
        							if(arr[i-l][j]==0){
        								dead++;
        							}
        						}
        					}
        					break;
        				}
        			}
        		}
        			for(int k=1;k<=4;k++){
        				if(i+k<19){
        				if(arr[i+k][j]==-chess){
        					p++;
        					dead++;
        				}
        				else if(arr[i+k][j]==chess){
        						both++;
        					break;
        				}
        				else{
        					for(int l=k;l<=4;l++){
        						if(i+l<19){
        							if(arr[i+l][j]==0){
        								dead++;
        							}
        						}
        					}
        					break;
        				}
        			}
        		}
        			if(dead>=4){
	        			if (both==0&&p!=0)
	        			{
	        				sum1=(int) (sum1+Math.pow(10,p));
	        			}
	        			else if (both==1&&p!=0)
	        			{
	        				sum1=(int) (sum1+Math.pow(10,p-1));
	        			}
				        if(p>=4)
				        {
				        	sum1=sum1+1000000;
				        }
	        		}
        			
        			//上下方向
        			p=0;both=0;dead=0;
        			for(int k=1;k<=4;k++){
        				if(j-k>=0){
        			    if(arr[i][j-k]==-chess){
        					p++;
        					dead++;
        				}
        			    else if(arr[i][j-k]==chess){
        			    		both++;
        			    	break;
        			    }
        			    else{
        			    	for(int l=k;l<=4;l++){
        						if(j-l>=0){
        							if(arr[i][j-l]==0){
        								dead++;
        							}
        						}
        					}
        					break;
        			    }
        			}
        		}
        			for(int k=1;k<=4;k++){
        				if(j+k<19){
        				if(arr[i][j+k]==-chess){
        					p++;
        					dead++;
        				}
        				else if(arr[i][j+k]==chess){
        						both++;
        					break;
        				}
        				else{
        					for(int l=k;l<=4;l++){
        						if(j+l<19){
        							if(arr[i][j+l]==0){
        								dead++;
        							}
        						}
        					}
        					break;
        				}
        			}
        		}
        			if(dead>=4){
	        			if (both==0&&p!=0)
	        			{
	        				sum1=(int) (sum1+Math.pow(10,p));
	        			}
	        			else if (both==1&&p!=0)
	        			{
	        				sum1=(int) (sum1+Math.pow(10,p-1));
	        			}
				        if(p>=4)
				        {
				        	sum1=sum1+1000000;
				        }
	        		}
			        
        			//东北.西南方向
        			p=0;both=0;dead=0;
        			for(int k=1;k<=4;k++){
        				if(i+k<19&&j-k>=0){
        				if(arr[i+k][j-k]==-chess){
        					p++;
        					dead++;
        				}
        				else if(arr[i+k][j-k]==chess){
        						both++;
        					break;
        				}
        				else{
        					for(int l=k;l<=4;l++){
        						if(i+l<19&&j-l>=0){
        							if(arr[i+l][j-l]==0){
        								dead++;
        							}
        						}
        					}
        					break;
        				}
        			}
        		}
        			for(int k=1;k<=4;k++){
        				if(i-k>=0&&j+k<19){
        				if(arr[i-k][j+k]==-chess){
        					p++;
        					dead++;
        					
        				}
        				else if(arr[i-k][j+k]==chess){
        						both++;
        					break;
        				}
        				else{
        					for(int l=k;l<=4;l++){
        						if(i-l>=0&&j+l<19){
        							if(arr[i-l][j+l]==0){
        								dead++;
        							}
        						}
        					}
        					break;
        				}
        			}
        		}
        			if(dead>=4){
	        			if (both==0&&p!=0)
	        			{
	        				sum1=(int) (sum1+Math.pow(10,p));
	        			}
	        			else if (both==1&&p!=0)
	        			{
	        				sum1=(int) (sum1+Math.pow(10,p-1));
	        			}
				        if(p>=4)
				        {
				        	sum1=sum1+1000000;
				        }
	        		}
        			
        			
//白棋分数
        			//西北.东南方向
        			p=0;both=0;dead=0;
        			for(int k=1;k<=4;k++)
        			{
        				if(i-k>=0&&j-k>=0)
        				{
        					if(arr[i-k][j-k]==chess)
        					{
        						p++;
        					    dead++;
        				    }
                            else if(arr[i-k][j-k]==-chess)
                            {
        						both++;
        					    break;
        				    }
        				    else
        				    {
        				    	for(int l=k;l<=4;l++)
        				    	{
        				    		if(i-l>=0&&j-l>=0)
        				    		{
        				    			if(arr[i-l][j-l]==0)
        				    			{
        				    				dead++;
        							    }
        						    }
        					    }
        					    break;
        				    }
        			    }
        		    }
        			for(int k=1;k<=4;k++){
        				if(i+k<19&&j+k<19){
        				if(arr[i+k][j+k]==chess){
        					p++;
        					dead++;
        				}
        				else if(arr[i+k][j+k]==-chess){
        						both++;
        					break;
        				}
        				else{
        					for(int l=k;l<=4;l++){
        						if(i+l<19&&j+l<19){
        							if(arr[i+l][j+l]==0){
        								dead++;
        							}
        						}
        					}
        					break;
        				}
        			}
        		}
        			if(dead>=4){
	        			if (both==0&&p!=0)
	        			{
	        				sum2=(int) (sum2+2*Math.pow(10,p));
	        			}
	        			else if (both==1&&p!=0)
	        			{
	        				sum2=(int) (sum2+2*Math.pow(10,p-1));
	        			}
				        if(p>=4)
				        {
				        	sum2=sum2+2000000;
				        }
	        		}
        			
        			//左右方向
        			p=0;both=0;dead=0;
        			for(int k=1;k<=4;k++)
        			{
        				if(i-k>=0)
        				{
        					if(arr[i-k][j]==chess)
        				    {
        				    	p++;
        					    dead++;
        				    }
        				    else if(arr[i-k][j]==-chess)
        				    {
        						both++;
        					    break;
        				    } 
        				    else
        				    {
        					    for(int l=k;l<=4;l++)
        					    {
        					    	if(i-l>=0)
        						    {
        						    	if(arr[i-l][j]==0)
        							    {
        							    	dead++;
        							    }
        						    }
        					    }
        					    break;
        				    }
        			    }
        		    }
        			for(int k=1;k<=4;k++)
        			{
        				if(i+k<19)
        				{
        					if(arr[i+k][j]==chess)
        					{
        						p++;
        					    dead++;
        				    }
        				    else if(arr[i+k][j]==-chess)
        				    {
        						both++;
        					    break;
        				    }
                            else
                            {
                            	for(int l=k;l<=4;l++)
                            	{
                            		if(i+l<19)
                            		{
                            			if(arr[i+l][j]==0)
                            			{
                            				dead++;
        							    }
        						    }
        					    }
        					    break;
        				    }
        			    }
        		    }
        			if(dead>=4)
        			{
	        			if(both==0&&p!=0)
	        			{
	        				sum2=(int) (sum2+2*Math.pow(10,p));
	        			}
	        			else if (both==1&&p!=0)
	        			{
	        				sum2=(int) (sum2+2*Math.pow(10,p-1));
	        			}
				        if(p>=4)
				        {
				        	sum2=sum2+2000000;
				        }
	        		}
        			
        			//上下方向
        			p=0;both=0;dead=0;
        			for(int k=1;k<=4;k++){
        				if(j-k>=0){
        			    if(arr[i][j-k]==chess){
        					p++;
        					dead++;
        				}
        			    else if(arr[i][j-k]==-chess){
        			    		both++;
        			    	break;
        			    }
        			    else{
        			    	for(int l=k;l<=4;l++){
        						if(j-l>=0){
        							if(arr[i][j-l]==0){
        								dead++;
        							}
        						}
        					}
        					break;
        			    }
        			}
        		}
        			for(int k=1;k<=4;k++){
        				if(j+k<19){
        				if(arr[i][j+k]==chess){
        					p++;
        					dead++;
        				}
        				else if(arr[i][j+k]==-chess){
        						both++;
        					break;
        				}
        				else{
        					for(int l=k;l<=4;l++){
        						if(j+l<19){
        							if(arr[i][j+l]==0){
        								dead++;
        							}
        						}
        					}
        					break;
        				}
        			}
        		}
        			if(dead>=4){
	        			if (both==0&&p!=0)
	        			{
	        				sum2=(int) (sum2+2*Math.pow(10,p));
	        			}
	        			else if (both==1&&p!=0)
	        			{
	        				sum2=(int) (sum2+2*Math.pow(10,p-1));
	        			}
				        if(p>=4)
				        {
				        	sum2=sum2+2000000;
				        }
	        		}
        			
        			//东北.西南方向
        			p=0;both=0;dead=0;
        			for(int k=1;k<=4;k++){
        				if(i+k<19&&j-k>=0){
        				if(arr[i+k][j-k]==chess){
        					p++;
        					dead++;
        				}
        				else if(arr[i+k][j-k]==-chess){
        						both++;
        					break;
        				}
        				else{
        					for(int l=k;l<=4;l++){
        						if(i+l<19&&j-l>=0){
        							if(arr[i+l][j-l]==0){
        								dead++;
        							}
        						}
        					}
        					break;
        				}
        			}
        		}
        			for(int k=1;k<=4;k++){
        				if(i-k>=0&&j+k<19){
        				if(arr[i-k][j+k]==chess){
        					p++;
        					dead++;
        				}
        				else if(arr[i-k][j+k]==-chess){
        						both++;
        					break;
        				}
        				else{
        					for(int l=k;l<=4;l++){
        						if(i-l>=0&&j+l<19){
        							if(arr[i-l][j+l]==0){
        								dead++;
        							}
        						}
        					}
        					break;
        				}
        			}
        		}
        			if(dead>=4){
	        			if (both==0&&p!=0)
	        			{
	        				sum2=(int) (sum2+2*Math.pow(10,p));
	        			}
	        			else if (both==1&&p!=0)
	        			{
	        				sum2=(int) (sum2+2*Math.pow(10,p-1));
	        			}
				        if(p>=4)
				        {
				        	sum2=sum2+2000000;
				        }
	        		}
        			
        sum=sum1+sum2;
        mark[i][j]=sum;
        if (sum>=max){
        	max=sum;
        	x=i;
        	y=j;
        	}
        }
        		}
        	}
        }
    }