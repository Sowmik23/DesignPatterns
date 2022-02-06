package creational;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Singleton {

    //make sure private constructor and private vairable
    private Singleton instance;
    private Singleton(){
    }

    public Singleton getInstance(){
        if(instance==null){
            instance = new Singleton();
        }

        return instance;
    }

    public static void main(String[] args) {

        //test
        DateFormat df = new SimpleDateFormat("EEEE, dd-MMM-yyyy hh:mm:ss aa");
        df.setTimeZone(TimeZone.getTimeZone("Asia/Dhaka"));
        String today = df.format(new Date());
        System.out.println(today);
    }
}
