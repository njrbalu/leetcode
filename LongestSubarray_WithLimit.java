package leetcode;

public class LongestSubArray {

	public static void main(String[] args) {
		
		int[] numbers = new int[]{10,1,2,7,4,2};
		int limit = 5;
		LongestSubArray array = new LongestSubArray();
		int x = array.longestsubarray(numbers, limit);
		System.out.println(x);
	}
	
	public int longestsubarray(int[] numbers,int limit) {
		
		int longestlength = Integer.MIN_VALUE;
		
		int[][] dp_array = new int[numbers.length][numbers.length];
		
		for(int i=0;i<numbers.length;i++) {
			dp_array[i][i]=1;
		}
			
		for(int i=numbers.length;i>=0;i--) {
			//printArray(dp_array);
			for(int j=i+1;j<numbers.length;j++) {
				if(dp_array[i][j-1] == 1 && dp_array[i+1][j] == 1 && Math.abs(numbers[i]-numbers[j]) <= limit) {
					dp_array[i][j] = 1;
				}
				else
					dp_array[i][j] = 0;
			}
		}
		
		for(int i=0;i<numbers.length;i++) {
			int length = 0;
			for(int j=0;j<numbers.length;j++) {
				length+=dp_array[i][j];
			}
			if(length>longestlength)
				longestlength=length;
		}
		return longestlength;		
	}
	
	public void printArray(int[][] a) {
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a.length;j++) {
				System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}
	}

}
