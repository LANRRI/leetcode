/**
 * Created by ruidli on 2017/8/14.
 */
public class TestBitOpration {
//    public static void main(String args[]) throws Exception{
////        int i = 1 << ('{'-'a');
////
////        System.out.println(i);
//
////        new BufferedReader(new FileReader(""));
////        new BufferedWriter(new FileWriter(""));
////        new GZIPOutputStream(new FileOutputStream(""));
////
////
////        new ObjectInputStream(new FileInputStream("a.dat"));
//
//
//        String s = "abc";
//        String ss = new String("abc");
//        System.out.println(s == ss);
//
//        String sss = "ab"+"c";
//        System.out.println(s == sss);
//        System.out.println(sss == ss);
//
//        String s2 = "ab" + new String("c");
//        System.out.println(ss.intern() == s2.intern());
//    }

    public static void main(String[] args) {
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";
        String s6 = s3 + s4;
        System.out.println(s1.equals(s2));
        System.out.println(s1 == s5);
        System.out.println(s1 == s6);
        System.out.println(s1 == s6.intern());
        System.out.println(s2 == s2.intern());
    }
}
