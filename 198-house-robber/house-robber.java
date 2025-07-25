class Solution {
    public int rob(int[] money) {
        Integer [] cache = new Integer[money.length];
        return rob(money, 0, cache);

    }
    public int rob(int[] money, int houseNo, Integer cache[]){
        if(houseNo >= money.length){
            return 0;
        }
        if(cache[houseNo] != null){
            return cache[houseNo];
        }
        int choice1 = money[houseNo] + rob(money, houseNo + 2, cache);
        int choice2 = rob(money, houseNo + 1, cache);
        int result = Math.max(choice1, choice2);
        cache[houseNo] = result;
        return result;
    }
}