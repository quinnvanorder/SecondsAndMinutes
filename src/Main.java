import java.text.DecimalFormat;

/*
Create a method called getDurationString with two parameters, 1st minutes, 2nd seconds.
Validate that minutes >= 0
Validate seconds >=0 and <= 59
Return "Invalid Value" if either of the above are not true
If valid, calculate how many hours minutes and seconds equal the minutes and seconds passed to this method and return
the value as a string in the format "XXh YYm ZZs" where XX represents a number of hours, YY minutes and ZZ seconds.

Create a second method of the same name but with only one parameter of seconds.
Validate that it is >=0 and return "invalid state" if not true.
If valid, calculate how many minutes are in the seconds value and then call the other overloaded method passing the
correct minutes and seconds

TIPS:
Use int or long for your number data types.
Methods should be static
Output for 61 minutes should be 01h 01m 00s, note the 2 digits. use if-else



 */
public class Main {
    public static void main(String[] args) {
        System.out.println(getDurationString(61,32));
        System.out.println(getDurationString(3692));
    }

    public static String getDurationString (int minutes, int seconds){
        int hours = 0;
        if (minutes < 0 || (seconds < 0 || seconds > 59)){
            return "Invalid Value";
        }
        else if (minutes / 60 > 0) {
            hours = minutes / 60;
            minutes = minutes % 60;
        }
        DecimalFormat twoDigits = new DecimalFormat("00");
        return twoDigits.format(hours) + "h " + twoDigits.format(minutes) + "m " + twoDigits.format(seconds) + "s";
    }

    public static String getDurationString (int seconds){
        if (seconds < 0){
            return "Invalid String";
        }
        else {
            return getDurationString((seconds / 60), (seconds % 60));
        }
    }
}
