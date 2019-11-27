public class Task extends Item{

    String duration, members;

    public Task(String title, Date date, Time time, String duration, String members){
        super(title, date, time);
        this.duration = duration;
        this.members = members;
    }
    public String toString(){
        return String.format("<<TASK>> TITLE: %s DATE: %s TIME: %s Duration: %s MEMBERS: %s",title, date, time, duration, members);
    }

}