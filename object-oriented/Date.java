public class Date{
    String day, month, year;
    public Date(String day, String month, String year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String toString(){
        return String.format("%s/%s/%s", day, month, year);
    }
}