package strings;

import java.util.Set;
import java.util.*;

/**
 * Created by sanjay on 16/07/2017.
 */
public class StringSegment {

    public static void main(String[] args){

        String input = "gobackhome";
        String[] dict_values = new String[] { "hello", "hell" ,"on", "now" };
        Set<String> dict = new HashSet<String>(Arrays.asList(dict_values));
        System.out.println(can_segment_string(input,dict));

    }


    public static boolean can_segment_string(String s, Set<String> dict) {
        Set<String> solved = new HashSet<String>();
        return can_segment_string(s, dict, solved);
    }

    public static boolean can_segment_string(String s, Set<String> dict, Set<String> solved) {
        for (int i = 1; i <= s.length(); ++i) {
            String first = s.substring(0, i);
            if (dict.contains(first)) {
                String second = s.substring(i);

                if (second == null || second.length() == 0 || dict.contains(second)) {
                    return true;
                }

                if (!solved.contains(second)) {
                    if (can_segment_string(second, dict, solved)) {
                        return true;
                    }
                    solved.add(second);
                }
            }
        }
        return false;
    }
}
