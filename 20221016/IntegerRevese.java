public class IntegerRevese{

    public static void main(String[] args) {
        System.out.println(reverse(54321));
    }


    private static long reverse(int x){
        long result = 0;
        while(x != 0){
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return result;
    }


}