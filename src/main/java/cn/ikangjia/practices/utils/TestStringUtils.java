package cn.ikangjia.practices.utils;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 *
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2025/11/20 13:33
 */
public class TestStringUtils {

    public static void test() {
        // 最常用，判空
        System.out.println(StringUtils.hasLength("")); //  false
        System.out.println(StringUtils.hasLength(" ")); //  true
        System.out.println(StringUtils.hasLength(null)); // false
        System.out.println(StringUtils.hasText("")); // false
        System.out.println(StringUtils.hasText(" ")); // false
        System.out.println(StringUtils.hasText(null)); // false

        System.out.println("=============");

        // 判断字符串内是否包含空白
        System.out.println(StringUtils.containsWhitespace("")); //  false
        System.out.println(StringUtils.containsWhitespace(null)); // false
        System.out.println(StringUtils.containsWhitespace(" a ")); //  true
        System.out.println(StringUtils.containsWhitespace("a b")); //  true
        System.out.println(StringUtils.containsWhitespace(" "));//  true

        System.out.println("=========");

        // 分割字符串
        String[] parts = StringUtils.tokenizeToStringArray("a,b,c", ",");
        System.out.println(Arrays.toString(parts)); // [a, b, c]

        // 清除字符串内所有空白
        String trimmed = StringUtils.trimAllWhitespace("  he  llo  ");
        System.out.println(trimmed); // "hello"
    }

    public static void main(String[] args) {
        test();
    }
}
