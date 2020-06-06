public class Test_392 {
    public boolean isSubsequence(String s, String t) {
        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();
        for (int i = 0,j=-1; i < ss.length; i++) {
            if((j = index(ts, j+1, ss[i])) == -1)
                return false;
        }
        return true;
    }

    public int index(char[] c, int fromIndex, int t){
        for (int j=fromIndex; j < c.length; j++) {
            if(c[j] == t)
                return j;
        }
        return -1;
    }
}
