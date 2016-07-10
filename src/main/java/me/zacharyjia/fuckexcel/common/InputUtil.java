package me.zacharyjia.fuckexcel.common;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zachary on 16/7/10.
 */
public class InputUtil {

    public static boolean isEmpty(String ...args) {
        for (String input : args) {
            if (input == null || "".equals(input)) {
                return true;
            }
        }
        return false;
    }

    public static Set<String> string2tag(String str) {
        if (str != null) {
            String[] tags = str.trim().split(",");
            return new HashSet<String>(Arrays.asList(tags));
        } else {
            return null;
        }
    }
}
