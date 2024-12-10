class Solution {
    public boolean isSpecial(String sub) {
        char ch = sub.charAt(0);
        for(int i=0; i<sub.length(); i++) {
            if(sub.charAt(i) != ch)
                return false;
        }
        return true;
    }
    public boolean occursThrice(String s, String sub) {
        int n = s.length(), m = sub.length(), count = 0;
        for(int i=0; i<=n-m; i++) {
            if(s.substring(i, i+m).equals(sub))
                count++;
        }
        return count >= 3;
    }
    public int maximumLength(String s) {
        int n = s.length(), max = -1;
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<=n; j++) {
                String sub = s.substring(i, j);
                if(isSpecial(sub) && occursThrice(s, sub)) {
                    max = Math.max(max, sub.length());
                }
            }
        }
        return max;
    }
}