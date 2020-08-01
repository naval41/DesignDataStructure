/**
*
Find Median from Data Stream

Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

For example,
[2,3,4], the median is 3
[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
 

Example:

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2

*/

import java.util.PriorityQueue;
import java.util.Queue;

class MedianFinder {
	   private Queue<Integer> small = new PriorityQueue<Integer>((a,b)->b-a); //In a reverse order
	   private Queue<Integer> large = new PriorityQueue<Integer>();   //In a natural order
	    
	   // Adds a number into the data structure.
	   public void addNum(int num) {
	        large.add(num);
	        small.add(large.poll());
	        if (large.size() < small.size())
	            large.add(small.poll());
	    }

	    // Returns the median of current data stream
	    public double findMedian() {
	        return large.size() > small.size()
	               ? large.peek()
	               : (large.peek() + small.peek()) / 2.0;
	    }
}
