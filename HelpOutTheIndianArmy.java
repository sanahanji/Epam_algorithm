

import java.util.*;

public class HelpOutTheIndianArmy {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String firstCases = in.nextLine();
		String splittedString[] = firstCases.split(" ");
		int noOfCases = Integer.parseInt(splittedString[0]);
		long source = Long.parseLong(splittedString[1]);
		long destination =  Long.parseLong(splittedString[2]);
		long x[] = new long[noOfCases];
		long p[] = new long[noOfCases];
		List<Pair> pairs = new ArrayList<Pair>();
		for(int i=0; i<noOfCases; i++){
			String line = in.nextLine();
			x[i] = Long.parseLong(line.split(" ")[0]);
			p[i] = Long.parseLong(line.split(" ")[1]);
			pairs.add(new Pair(x[i]-p[i], x[i]+p[i]));
			// System.out.println(x[i] + " " +p[i]);
		}
		//System.out.println(source + " " + destination );
		Collections.sort(pairs);
//		for(int i=0;i<pairs.size();i++)
//		System.out.println(pairs.get(i).m_start + " " + pairs.get(i).m_end);
		long result = destination -source;
//		System.out.println(result);
		for(int i=1;i<pairs.size();i++){
			if(pairs.get(i-1).m_end>= pairs.get(i).m_start && pairs.get(i-1).m_end<= pairs.get(i).m_end ){
				pairs.get(i-1).m_end = pairs.get(i).m_start ;
			}else if(pairs.get(i-1).m_end>= pairs.get(i).m_start){
				long temp = pairs.get(i-1).m_end;
				pairs.get(i-1).m_end = pairs.get(i).m_start ;
				pairs.get(i).m_end = temp;
			}
			
		}
//		for(int i=0;i<pairs.size();i++)
//			System.out.println(pairs.get(i).m_start + " " + pairs.get(i).m_end);
		for(Pair pair : pairs){
			if(source<=pair.m_start && destination>=pair.m_end){
				result = result - (pair.m_end - pair.m_start);
			}else if(source>=pair.m_start && source<=pair.m_end && destination>=pair.m_end){
				result = result - (pair.m_end - source);
			}else if(source>=pair.m_start && destination<=pair.m_end){
				result = result - (destination - source);
			}else if(source<=pair.m_start && destination<=pair.m_start){
				
			}
			else if(source>=pair.m_start && destination>=pair.m_end){
				
			}else
				result = result - (destination - pair.m_start);
		}
		System.out.println(result);
		in.close();
	}
	
	
	static class Pair implements Comparable<Pair>{
		
		 long m_start;
		 long m_end;
	   Pair( long start, long end){
		   m_start = start;
		   m_end = end;
	   }
	   
	   
	   
		@Override
		public int compareTo(Pair o) {
	     if(this.m_start>=o.m_start){
	    	 return 1;
	     }else
			return -1;
		}
		
	}

}
