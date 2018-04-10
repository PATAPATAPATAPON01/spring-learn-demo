package spring.learn.eventbus;

import org.junit.Test;

import java.util.Arrays;

public class MK {


    public static void main(String[] args) {


        int[] lasts = new int[26];
        Arrays.fill(lasts, -1);

        String s = "abcda";


        //子串开始位置
        int start = 0;

        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {


            //当前元素重复
            if (lasts[s.charAt(i) - 'a'] >= start) {

                maxLen = maxLen > (i - start) ? maxLen : (i - start);

                //移动到重复元素的下一个位置
                start = lasts[s.charAt(i) - 'a'] + 1;
            }

            //更新该字符的上一个重复位置
            lasts[s.charAt(i) - 'a'] = i;


        }
        System.out.println(maxLen > (s.length() - start) ? maxLen : (s.length() - start));
    }

    @Test
    public void method() {
        String s = "abc";
        System.out.println(s.charAt(2));

    }
}
