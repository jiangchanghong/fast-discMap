import java.util.HashMap;
import java.util.Map;

/**
 * Created by 长宏 on 2016/11/23 0023.
 */
public class TestHashcode {
    static Map<Integer, Integer> hash_number = new HashMap<>();
    static int getcode(String key) {
        int hashindex = (Math.abs(key.hashCode())) % 997 + 3;
        if (hash_number.containsKey(hashindex)) {
            hash_number.put(hashindex, hash_number.get(hashindex) + 1);
        }
        else {
            hash_number.put(hashindex, 1);
        }
        return hashindex;
    }

    static String randstring() {
        int c = (int) (Math.random() * 20);
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < c; i++) {
            b.append(randchar());
        }
        return b.toString();
    }

    static char randchar() {
        int c = (int) (Math.random() * num);
        return chars[c];
    }
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
//            System.out.println(getcode(randstring()));
            getcode(randstring());
        }
        System.out.println(hash_number.keySet().size());//不突然的数量
        System.out.println(hash_number.values().stream().mapToInt(a->a).max().getAsInt());//最长的数

    }
    static char[] chars = {'a', 'z', 'c', 'd', 'e', 'f', 'g', 'h', 'q', 'e', 'r', 't', 'u', 'i', 'k', 'm'};
    static int num = chars.length;
}