
import java.util.*;


public class GlowingBulb {
	static Set<Integer> list = new TreeSet<Integer>();
	static List<Integer> switches = new ArrayList<Integer>( 12 );

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner( System.in );
		int t = s.nextInt();
		List<Integer> result = new ArrayList<Integer>(t);
		long k, l, h, m = 0;
		int i;
		long ans = 0;
		while ( s.hasNextLine() ) 
		{
			list.clear();
			switches.clear();
			result.clear();
			s.nextLine();
			String switchString = s.nextLine();
			k = s.nextLong();
			for(i =0 ; i< switchString.length(); i++)
			{
				if(switchString.charAt( i )-48 == 1) switches.add( i+1 );
			}
			l=1; 
			h= 1000000000000000L;
			while ( l <= h )
			{
				m = (l+h) >> 1;
				if(Sub_process(m) >= k)
				{
					ans = m;
					h = m-1;
				}
				else  
					l = m+1;
			}
			System.out.println(ans);
		}
		s.close();
	}
	
	
	private static long Sub_process( long m )
	{
		int p = switches.size();
		int i,j;
		long result = 0;
		for(i=1; i< (1 << p); i++ )
		{
			long pr = 1;
			int sign = -1 ;
			for(j =0; j < p; j++ )
			{
				if(((i>>j)&1) == 1)
				{
					pr = pr * switches.get( j );
					sign *= -1;
				}
			}
			result += sign*(m/pr);
		}
	return result;
	}

}


