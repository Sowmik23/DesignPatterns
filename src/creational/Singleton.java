package creational;

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
}
