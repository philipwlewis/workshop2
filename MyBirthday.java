// MyBirthday application
public class MyBirthday {
    public static void main(String[] args) {
        int currentDay = Integer.parseInt(args[0]); // Sunday is 0, Monday is 1, ...
        int currentDate = Integer.parseInt(args[1]);
        int myBirthdayDate = Integer.parseInt(args[2]);

        final int DAYS_A_WEEK = 7; // final is used for declaring constants
        int myBirthdayDay =  (myBirthdayDate-currentDate)%DAYS_A_WEEK + currentDay;
        myBirthdayDay = myBirthdayDay%DAYS_A_WEEK;// % is the modulus operator
        System.out.println("Birthday falls on day: " + myBirthdayDay );
    }
}