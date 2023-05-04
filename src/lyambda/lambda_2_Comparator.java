package lyambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class lambda_2_Comparator {
    public static void main(String[] args) {
        List<String>list = new ArrayList<>();

        list.add("Hello");
        list.add("Goodbye");
        list.add("a");
        list.add("ad");

//        .............. 1 способ .............

/*        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()){
                    return 1;
                } else if(o1.length() < o2.length()){
                    return -1;
                }else {
                    return 0;
                }
            }
        });
*/

//        .............. 2 способ .............

        list.sort((o1, o2) -> {
            if (o1.length() > o2.length()){
                return 1;
            } else if(o1.length() < o2.length()){
                return -1;
            }else {
                return 0;
            }
        });

        System.out.println(list);

    }
}