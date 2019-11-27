public class Time{
    String hour, minute;
    public Time(String hour, String minute){
        this.hour = hour;
        this.minute = minute;

    }

    public String toString(){
        return String.format("%s:%s", hour, minute);
    }
}