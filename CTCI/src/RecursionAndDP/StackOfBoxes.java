package RecursionAndDP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StackOfBoxes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Box[] boxList = { new Box(6, 4, 4), new Box(8, 6, 2), new Box(5, 3, 3), new Box(7, 8, 3), new Box(4, 2, 2), new Box(9, 10, 3)};
		ArrayList<Box> boxes = new ArrayList<Box>();
		for (Box b : boxList) {
			boxes.add(b);
		}
		
		int height = createStack(boxes);
		System.out.println("Recursion solution "+height);
		int height1 = createStackDP(boxes);
		System.out.println("DP solution "+height1);
		int height2 = createStackDPChoice(boxes);
		System.out.println("DP solution "+height2);

	}
	
	static int createStackDPChoice(ArrayList<Box> boxes)
	{
		Collections.sort(boxes,new BoxComparator());
		int maxHeight = 0;
		int[] stackMap = new int[boxes.size()];
		maxHeight = createStackDPChoice(boxes,null,0,stackMap);
		return maxHeight;
	}
	
	static int createStackDPChoice(ArrayList<Box> boxes,Box bottom,int offset,int[] stackMap)
	{
		if(offset>=boxes.size())
		{
			return 0;
		}
		
		Box newBottom = boxes.get(offset);
		int heightWithBottom=0;
		if(bottom==null || newBottom.canBeAbove(bottom))
		{
			if(stackMap[offset]==0)
			{
				stackMap[offset] = createStackDPChoice(boxes,newBottom,offset+1,stackMap);
				stackMap[offset]+=newBottom.height;
			}
			
			heightWithBottom=stackMap[offset];
		}
		
		int heightWithOutBottom = createStackDPChoice(boxes,bottom,offset+1,stackMap);
		return Math.max(heightWithBottom, heightWithOutBottom);
	}
	static int createStackDP(ArrayList<Box> boxes)
	{
		Collections.sort(boxes,new BoxComparator());
		int maxHeight = 0;
		int[] stackMap = new int[boxes.size()];
		for(int i=0;i<boxes.size();i++)
		{
			int height = createStackDP(boxes,i,stackMap);
			maxHeight = Math.max(height, maxHeight);
		}
		return maxHeight;
	}
	
	static int createStackDP(ArrayList<Box> boxes,int bottomIndex,int[] stackMap)
	{
		if(bottomIndex < boxes.size() && stackMap[bottomIndex]>0)
		{
			return stackMap[bottomIndex];
		}
		int maxHeight = 0;
		Box bottom = boxes.get(bottomIndex);
		for(int i=bottomIndex+1;i<boxes.size();i++)
		{
			if(boxes.get(i).canBeAbove(bottom))
			{
				int height = createStackDP(boxes,i,stackMap);
				maxHeight = Math.max(height, maxHeight);
			}
		}
		
		maxHeight+=bottom.height;
		stackMap[bottomIndex]=maxHeight;
		return maxHeight;
	}
	static int createStack(ArrayList<Box> boxes)
	{
		Collections.sort(boxes,new BoxComparator());
		int maxHeight = 0;
		for(int i=0;i<boxes.size();i++)
		{
			int height = createStack(boxes,i);
			maxHeight = Math.max(maxHeight, height);
		}
		
		return maxHeight;
	}
	
	static int createStack(ArrayList<Box> boxes,int bottomIndex)
	{
		Box bottom = boxes.get(bottomIndex);
		int maxHeight = 0;
		
		for(int i=bottomIndex+1; i<boxes.size();i++) {
			if(boxes.get(i).canBeAbove(bottom))
			{
				int height = createStack(boxes,i);
				maxHeight = Math.max(height, maxHeight);
			}
		}
		
		maxHeight+=bottom.height;
		return maxHeight;
	}

}

class Box {
	public int width;
	public int height;
	public int depth;
	public Box(int w, int h, int d) {
		width = w;
		height = h;
		depth = d;
	}
	
	public boolean canBeUnder(Box b) {
		if (width > b.width && height > b.height && depth > b.depth) {
			return true;
		}
		return false;
	}
	
	public boolean canBeAbove(Box b) {
		if (b == null) {
			return true;
		}
		if (width < b.width && height < b.height && depth < b.depth) {
			return true;
		}
		return false;		
	}
	
	public String toString() {
		return "Box(" + width + "," + height + "," + depth + ")";
	}
}

class BoxComparator implements Comparator<Box>
{

	@Override
	public int compare(Box bx1, Box bx2) {
		// TODO Auto-generated method stub
		return bx2.height-bx1.height;
	}
	
}