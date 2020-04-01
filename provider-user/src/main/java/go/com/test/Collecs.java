package go.com.test;

public class Collecs {
    public static void main(String[] args) {
//        String[] arr={"a","b"};
//        System.out.println(arr.length);
//
//        String str="aaaaa";
//        str.length();


//        String s = "a" + "b" + "c" + "d";
//        System.out.println(s == "abcd");

        Test1 test1 =new Test1();
        System.out.println(test1.test());

    }
}


class Test1 {
    public int test() {
        int x = 1;
        try {
            return 1;
        } finally {
            return 2;
        }
    }
}