package STLProbs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class ExpeditionFuelProblem {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int n = Integer.parseInt(input);
		
		int ans = 0;
		boolean flag = false;
		City[] cities = new City[n];
		for(int i=0;i<n;i++)
		{
			String[] str = br.readLine().split("\\s");
			cities[i] = new City(Integer.parseInt(str[0]),Integer.parseInt(str[1]));
		}
		
		String[] str1 = br.readLine().split("\\s");
		
		int distanceToTravel = Integer.parseInt(str1[0]);
		int initialFuel = Integer.parseInt(str1[1]);
		
		Arrays.sort(cities);
		
		for(int i=0;i<n;i++)
		{
			cities[i].distance = distanceToTravel-cities[i].distance;
			System.out.print(cities[i].distance+" ");
		}
		
		PriorityQueue<Integer> pq= new PriorityQueue<Integer>(n,Collections.reverseOrder());
		int x = 0;
		int prev = 0;
		while(x<n-1)
		{
			//initialFuel-=cities[x].distance-prev;
			if(initialFuel>= (cities[x].distance-prev))
			{
				initialFuel-=(cities[x].distance-prev);
				pq.add(cities[x].capacity);
				prev  = cities[x].distance;
			}
			else {
				if(pq.isEmpty())
				{
					flag = true;
					break;
				}
				
				initialFuel+=pq.poll();
				pq.add(cities[x].capacity);
				ans++;
			}
			x++;
			
		}
		
		if(flag)
		{
			System.out.print("-1");
			return;
		}
		
		distanceToTravel = distanceToTravel - cities[n-1].distance;
		if(initialFuel>=distanceToTravel)
		{
			System.out.print(ans);
			return;
		}
		
		while(initialFuel < distanceToTravel)
		{
			if(pq.isEmpty())
			{
				flag=true;
				break;
			}
			initialFuel +=pq.poll();
			ans++;
		}
		
		if(flag)
		{
			System.out.print("-1");
			return;
		}
		System.out.print(ans);
	}

}


class City implements Comparable<City>
{
	int distance;
	int capacity;
	public City(int distance,int capacity)
	{
		this.distance = distance;
		this.capacity = capacity;
	}
	@Override
	public int compareTo(City b) {
		// TODO Auto-generated method stub
		return b.distance -this.distance;
	}
}