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
        Arrays.sort(nums);

        HashMap<Integer, int[]> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            int sum = sumOfDigits(nums[i]);
            if(map.containsKey(sum)) {
                int[] arr = map.get(sum);
                if(arr[1] != -1) 
                    arr[0] = arr[1];
                arr[1] = i;
            }
            else {
                int[] arr = new int[2];
                arr[0] = i; arr[1] = -1;
                map.put(sum, arr);
            }
        }
        int max_sum = -1;
        for(int sum: map.keySet()) {
            if(map.get(sum)[1] != -1) {
                int[] arr = map.get(sum);
                max_sum = Math.max(max_sum, nums[arr[0]] + nums[arr[1]]);
            }
        }
        return max_sum;
    }
}