

import java.util.*;

public class RodCuttingProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
        Scanner s = new Scanner(System.in);
        int t=s.nextInt();
        while((t--)!=0)
        {
        		int n=s.nextInt();
        		int count=0; 
        		for(int i=3;i<=n;)
        		{
        			count=count+1;
        			i=i+(i+1);
        		}
        		System.out.println(count);
        }
        s.close();
	}

}
