
class SubClass extends PracticeProblem {
       private void displayName() {
             System.out.println("SubClass is a type of SuperClass");
       }
}
public class PracticeProblem {

	private void displayName() {
        System.out.println("Super Class");
  }
	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//		String s = "eeeeeeeeeeeeebbbbbccc";
//		int k = 2;
//		lengthOfLongestSubstringTwoDistinct_New(s,k);
		//System.out.println(length);
		PracticeProblem superClass = new SubClass();
        superClass.displayName();

	}
	
	public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int cl=0;
        char last=' ';
        int max=0;
        int c=0;
        while(c<s.length()){
            int cc=1; 
            boolean bool=true;
            char curr=s.charAt(c);
            while((c+1)<s.length() && (s.charAt(c+1)==curr || s.charAt(c+1)==last)){
                bool=false;
                
                if(s.charAt(c+1)==curr)
                    cc++;
                else{
                    char temp=curr;
                    curr=last;
                    last=temp;
                    cl++;
                }
                c++;
            }
           // if(!bool)
                //c--;
            last=curr;
            if(max<(cl+cc))
                max=cl+cc;
            cl=cc;
            //if(bool)
                c++;
            
        }
        return max;
    }
	
	public static void lengthOfLongestSubstringTwoDistinct_New(String s,int k)
	{
		int[] count = new int[128];
		// check whether string has at least k unique characters
		int uniqueCount = 0;
		for(int i=0;i<s.length();i++)
		{
			if(count[s.charAt(i)-'0']==0)
			{
				count[s.charAt(i)-'0']++;
				uniqueCount++;
			}
			count[s.charAt(i)-'0']++;
		}
		
		if(uniqueCount<k)
		{
			System.out.print("Number of unique characters in string are less than k");
			return;
		}
		
		count = new int[128];
		count[s.charAt(0)-'0']++;
		// Sliding window check for all characters
		int max_window_size=1;
		int max_window_start=0;
		int window_start=0;
		int window_end = 0;
		for(int i=1;i<s.length();i++)
		{
			count[s.charAt(i)-'0']++;
			window_end++;
			
			//slide the window till it meets the condition
			while(!IsValid(count,k))
			{
				count[s.charAt(window_start)-'0']--;
				window_start++;
			}
			
			if(window_end-window_start +1>max_window_size)
			{
				max_window_size = window_end-window_start +1;
				max_window_start = window_start;
			}
		}
		
		
		System.out.println("Max substring is of length "+max_window_size);
		for(int i=max_window_start;i<max_window_size;i++)
		{
			System.out.print(s.charAt(i));
		}
		
	}
	
	//Helper method to check sliding window is valid or not 
	public static boolean IsValid(int[] count,int k)
	{
		int val=0;
		for(int i=0;i<128;i++)
		{
			if(count[i]>0)
			{
				val++;
			}
		}
		return (k>=val);
	}

}
