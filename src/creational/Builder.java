package creational;

class Phone {
    private String os;
    private int ram;
    private String processor;
    private double screensize;
    private int battery;

    public Phone(String os, int ram, String processor, double screensize, int battery) {
        this.os = os;
        this.ram = ram;
        this.processor = processor;
        this.screensize = screensize;
        this.battery = battery;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "os='" + os + '\'' +
                ", ram=" + ram +
                ", processor='" + processor + '\'' +
                ", screensize=" + screensize +
                ", battery=" + battery +
                '}';
    }
}

class PhoneBuilder {
    private String os;
    private int ram;
    private String processor;
    private double screensize;
    private int battery;

    public PhoneBuilder setOs(String os) {
        this.os = os;
        return this;
    }

    public PhoneBuilder setRam(int ram) {
        this.ram = ram;
        return this;
    }

    public PhoneBuilder setProcessor(String processor) {
        this.processor = processor;
        return this;
    }

    public PhoneBuilder setScreensize(double screensize) {
        this.screensize = screensize;
        return this;
    }

    public PhoneBuilder setBattery(int battery) {
        this.battery = battery;
        return this;
    }

    public Phone getPhone(){
        return new Phone(os, ram, processor, screensize, battery);
    }
}


public class Builder {
    public static void main(String[] args) {

        //old way
        //Phone p = new Phone("Android", 4, "Qualcomm", 5.5, 4000);
        //System.out.println(p);

        //using builder pattern
        Phone p = new PhoneBuilder().setOs("Apple").setProcessor("A13 Bionic").getPhone();
        System.out.println(p);

        Phone p1 = new PhoneBuilder().setOs("Apple").setProcessor("A10 Bionic").setBattery(6000).getPhone();
        System.out.println(p1);

        Phone p2 = new PhoneBuilder().setOs("Android").setProcessor("Qualcomm").setScreensize(5.5).getPhone();
        System.out.println(p2);
    }
}
