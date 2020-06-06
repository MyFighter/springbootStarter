package StringCicleExercise;

public class Test_5 {
    public static String longestPalindrome(String s) {
        if(s.length()<1)
            return s;
        int bIndex = 0,eIndex = 0, b = 0, e = 0;
        for (int i = 0; i < s.length(); i++) {
            if(i > 0 && i<s.length()-1 && s.charAt(i-1) == s.charAt(i+1)){
                b=i;e=i;
                //中间展开
                while( b>=0 && e<s.length()){
                    if(s.charAt(b) != s.charAt(e)){
                        break;
                    }
                    if( (e-b) > (eIndex - bIndex)){
                        eIndex = e;
                        bIndex = b;
                    }
                    b--;e++;
                }
            }
            if(i<s.length()-1 && s.charAt(i) == s.charAt(i+1)){
                b=i;e=i+1;
                //中间展开
                while( b>=0 && e<s.length()){
                    if(s.charAt(b) != s.charAt(e)){
                        break;
                    }
                    if( (e-b) > (eIndex - bIndex)){
                        eIndex = e;
                        bIndex = b;
                    }
                    b--;e++;
                }
            }
        }
        return s.substring(bIndex, eIndex+1);
    }


    public static void main(String[] args) {
        System.out.println(longestPalindrome("ccc"));
    }
}
