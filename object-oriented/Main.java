import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        System.out.println("WELCOME TO THE TODO LIST!");
        Scanner sc = new Scanner(System.in);


        System.out.println("Press \"Enter\" to begin");
        String s = sc.nextLine();
        
        /* Init a todo list queue */
        ArrayList<Item> todo_list = new ArrayList<Item>();
        ArrayList<Item> done_list = new ArrayList<Item>();

        while (!s.equals("quit")) {

            /* Main Loop where input will be prompted and processed. */

            if(todo_list.isEmpty()) {
                System.out.println("There is nothing in the todo list yet!!");
            }
            System.out.println("Type \"add\" to add an entry, \"remove\" to remove the oldest entry, \"showme\" to display the todo list, \"quit\" to close the program.\n");

            s = sc.nextLine();
            if(s.equals("add")) {

                /* Promp and pick an option to prompt for the correct input from the user. */

                System.out.println("What would you like to add?");
                System.out.println("Enter \"event\" or \"task\"");
                String option = sc.nextLine();

                if (option.equals("event")){
                    
                    System.out.println("TITLE: ");
                    String title = sc.nextLine();

                    System.out.println("Enter the following dd/mm/yyyy for date:");

                    Date date = makeDate();

                    System.out.println("Enter the following hh:mm for time:");
                    
                    Time time = makeTime();

                    System.out.println("LOCATION: ");
                    String location = sc.nextLine();                    
                    
                    todo_list.add(new Event(title, location, date, time));
                    // System.out.println(date);
                    System.out.println("Event added.");
                    System.out.println();
                }
                else if (option.equals("task")){
                    System.out.println("TITLE: ");
                    String title = sc.nextLine();

                    System.out.println("Enter the following dd/mm/yyyy : ");

                    Date date = makeDate();

                    System.out.println("TIME:");
                    Time time = makeTime();

                    System.out.println("DURATION:");
                    String duration = sc.nextLine();

                    System.out.println("MEMBERS (separated by comma):");
                    String members = sc.nextLine();

                    todo_list.add(new Task(title, date, time, duration, members));
                    System.out.println("Task added.");
                }
                else{
                    System.out.println("Invalid command! \"" + option+ "\"");
                }
                

            }
            else if(s.equals("remove")) {

                /* Remove the [0] item in the todo list and add it to the done list */

                if(todo_list.size() > 0){
                done_list.add(todo_list.get(0));
                todo_list.remove(0);
                System.out.println();
                } else{
                    System.out.println("");
                }
            }

            else if(s.equals("showme")) {
                display(todo_list, done_list);
            } 
            else if (s.equals("quit")){

            }
            else {
                System.out.println("Invalid command " + s );
            }
            
            
        }
        System.out.println("Thank you for usign the todo list");
        System.out.println("Closing program");

    }

    public static void display(ArrayList<Item> todo_list, ArrayList<Item> done_list){

        /* Display both the todo queue and done list  */

        System.out.println("--------------------------------------<<TODO>>--------------------------------------");
        
        for(Item item : todo_list){
            System.out.println(item);
        }
        
        System.out.println("--------------------------------------<<DONE>>--------------------------------------");
        for(Item item : done_list){
            System.out.println(item);
        }
        System.out.println();
    }


    public static Boolean checkDay(String day){
        Integer d = Integer.parseInt(day);
        if(32 > d && d > 0 && day.length() <= 2){
            return true;
        }
        return false;
    }
    public static Boolean checkMonth(String month){
        Integer m = Integer.parseInt(month);
        if(13 > m && m > 0 && month.length() <= 2){
            return true;
        }

        return false;
    }
    public static Boolean checkYear(String year){
        Integer y = Integer.parseInt(year);
        if(y >= 2019 && year.length() == 4){
            return true;
        }

        return false;
    }
    
    public static Time makeTime(){

        Scanner se = new Scanner(System.in);
        String h = "";
        String m = "";

        Boolean valid_hour = false;
        while (!valid_hour){
            try{
                System.out.println("Hour (hh):");
                String hh = se.nextLine();
                valid_hour = checkHour(hh);
                h = hh;
                } catch (Exception numberFormatException){
                    System.out.println("Invalid Hour!");
                }
        }
        Boolean valid_minute = false;
        while (!valid_minute){
            try{
                System.out.println("Minute (mm):");
                String mm = se.nextLine();
                valid_minute = checkHour(mm);
                m = mm;
                } catch (Exception numberFormatException){
                    System.out.println("Invalid Minutes!");
                }
        }
        Time time = new Time(h, m);
        return time;
    }

    public static Boolean checkHour(String h){
        Integer hour = Integer.parseInt(h);
        if(24 >= hour && hour >= 0){
            return true;
        }
        return false;
    }

    public static Boolean checkMinute(String m){
        Integer minute = Integer.parseInt(m);
        if(59 >= minute && minute >= 0){
            return true;
        }
        return false;
    }
    public static Date makeDate(){

        Scanner sd = new Scanner(System.in);
        String d = "";
        String m = "";
        String y = "";
        Boolean valid_day = false;
        while(!valid_day){
            try{
            System.out.println("Day (dd):");
            String dd = sd.nextLine();
            valid_day = checkDay(dd);
            d = dd;
            } catch (Exception numberFormatException){
                System.out.println("Invalid Day!");
            }
        }
        
        Boolean valid_month = false;
        while(!valid_month){
            try{
            System.out.println("Month (mm):");
            String mm = sd.nextLine();
            valid_month = checkMonth(mm);
            m = mm;
            } catch (Exception numberFormatException){
                System.out.println("Invalid Month!");
            }
        }
        Boolean valid_year = false;
        while(!valid_year){
            try{
            System.out.println("Year (yyyy):");
            String yy = sd.nextLine();
            valid_year = checkYear(yy);
            y = yy;
            } catch (Exception numberFormatException){
                System.out.println("Invalid Year!");
            }
        }
        
        Date date = new Date(d, m, y);
        return date;
    }
}