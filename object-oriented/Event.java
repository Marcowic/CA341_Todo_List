public class Event extends Item{

    String location;
    

    public Event(String title, String location, Date date, Time time){
        super(title, date, time);
        this.location = location;
    }
    public String toString(){
        return String.format("<<Event>> TITLE: %s DATE: %s TIME: %s Location: %s",title, date, time, location);
    }

}