class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
     //    gas[] = {1,2,3,4,5};
      //  int cost[]= {3,4,5,1,2};
        int startingPoint=0;
        int surplus=0;
        int deficit =0;
        for(int i=0;i<gas.length;i++){
            int gain = gas[i] - cost[i];
            surplus += gain;
            if(surplus<0){
                deficit += surplus;
                surplus=0;
                 startingPoint = i + 1;
            }
        }
        if(surplus + deficit>=0){
            System.out.println("Starting station"+ startingPoint);
             return startingPoint;
        }
        else {
        System.out.println("no station found");
        return -1;
        }
       
    }
  
}