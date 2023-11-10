package work01;

public class Utilitor {
    public static String testString(String value){
        if(value == null ){
            throw new NullPointerException("value is null");
        } else if(value.isBlank()) {
            throw new IllegalArgumentException("value is blank");
        } return value;

    }
    public static double  testPositive (double value){
        if(value < 0){
            throw new IllegalArgumentException("value is not positive");
        } else return value;
    }

    public static long computeIsbn10 (long isbn10) {
        long sum = 0;
        long i = 2;
        long digit;
        while (isbn10 > 0) {
            digit = isbn10 % 10;
            
            sum += digit * i;

            isbn10 /= 10;
            i++;

        }
     
        sum %= 11;

        long checkdigit = 11- sum ;
    return checkdigit;
    }
}
