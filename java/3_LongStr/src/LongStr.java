import java.util.HashMap;

public class LongStr {

    public static void main(String[] args) {
        int a = lengthOfLongestSubstring("pwwkew");
        System.out.println(a);
    }

    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if(len == 0){
            return 0;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        int max= 0;
        int left=0;
        for (int i =0;i<len;i++){
            if(map.containsKey(s.charAt(i))){
                left=Math.max(left,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;
    }
}
