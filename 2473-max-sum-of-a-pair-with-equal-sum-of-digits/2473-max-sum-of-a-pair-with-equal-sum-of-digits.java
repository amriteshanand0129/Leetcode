class Solution {
    public int sumOfDigits(int num) {
        int sum = 0;
        while(num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
    public int maximumSum(int[] nums) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            int sum = sumOfDigits(nums[i]);
            if(map.containsKey(sum))
                map.get(sum).add(i); 
            else {
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(i);
                map.put(sum, arr);
            }
        }
        int max_sum = -1;
        for(int sum: map.keySet()) {
            if(map.get(sum).size() > 1) {
                ArrayList<Integer> arr = map.get(sum);
                for(int i=0; i<arr.size(); i++) {
                    for(int j=i+1; j<arr.size(); j++) {
                        max_sum = Math.max(max_sum, nums[arr.get(i)] + nums[arr.get(j)]);
                    }
                }
            }
        }
        return max_sum;
    }
}