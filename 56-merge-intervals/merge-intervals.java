class Solution {
    public int[][] merge(int[][] intervals) {
        // sort the intervals
      Arrays.sort(intervals ,(a,b)->a[0]-b[0]);
      //store the final result 
      List<int[]> result = new ArrayList<>();
    
      for(int[]  interval  : intervals){
        //this result is not overlapping
        if(result.size()==0|| result.get(result.size()-1)[1]<interval[0]){//get last slot
            result.add(interval);

        }else{
          result.get(result.size()-1)[1]= Math.max(result.get(result.size()-1)[1], interval[1]);
        }
      }
      return result.toArray(new int [result.size()][]);
    }
}