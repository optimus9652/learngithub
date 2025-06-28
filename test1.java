public class test1 {
    public static void main(String[] args) {
        int count1 = 0;
        int multiply = 1;
        for(int  i = 1;i < 20;i++) {
            multiply *= multiply;
        }
        System.out.println(multiply);
    }
}