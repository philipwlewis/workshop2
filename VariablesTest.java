// VariablesTest application
public class VariablesTest {
    public static void main(String[] args) {
        int x = 2;
        System.out.println("x: " + x);
        float area = 20.3F;
        char a = '\u5468', b = '\\';
        int nHours = 022;
        double ratio = 7/5;
        long s_per_min = 60;
        byte s_per_day = (byte) (s_per_min * 60 * 24);
        System.out.println("s_per_min: " + s_per_min);
        System.out.println("s_per_day: " + s_per_day);
        double d1 = 0.29/0.0001;
        double d2 = 0.00029*1.0e7;
        System.out.println("d1: " + d1);
        System.out.println("d2: " + d1);
        System.out.println("equal?: " + (d1 == d2) );
        double epsilon = 1e-10;
        if (Math.abs(d1 - d2) < epsilon) {
            System.out.println("d1 and d2 differ by less than public class MyBirthday {\n" + //
                                "" + epsilon );
        };
    } 
}

