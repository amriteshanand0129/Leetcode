class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int start1 = 0, start2 = 1, xor1 = start1, xor2 = start2;
        for(int i: derived) {
            if(i == 1) {
                xor1 = ~xor1;
                xor2 = ~xor2;
            }
        }
        return start1 == xor1 || start2 == xor2;
    }
}