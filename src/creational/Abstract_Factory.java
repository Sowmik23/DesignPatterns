package creational;

//abstract factory

abstract class CPU{}
class EmberCPU extends  CPU{}
class EnginolaCPU extends CPU{}

abstract class MMU{}
class EmberMMU extends MMU{}
class EnginolaMMU extends MMU{}

class EmberToolkit extends Abstract_Factory {

    public CPU createCPU(){
        return new EmberCPU();
    }

    public MMU createMMU(){
        return new EmberMMU();
    }
}

class EnginolaToolkit extends Abstract_Factory{

    public CPU createCPU(){
        return new EnginolaCPU();
    }

    public MMU createMMU(){
        return new EnginolaMMU();
    }
}

// Enums: An enum is a special "class" that represents a collections of
// constants (unchangeable variables, like final variables).

enum Architecture {
    ENGINOLA, EMBER
}

abstract class Abstract_Factory {

    private static final EmberToolkit EMBER_TOOLKIT = new EmberToolkit();
    private static final EnginolaToolkit ENGINOLA_TOOLKIT = new EnginolaToolkit();

    // returns a concrete factory object that is an instance of the concrete
    // factory class appropriate for the given architecture

    static Abstract_Factory getFactory(Architecture architecture){
        Abstract_Factory factory = null;
        switch (architecture){
            case ENGINOLA:
                factory = ENGINOLA_TOOLKIT;
            case EMBER:
                factory = EMBER_TOOLKIT;
                break;
        }
        return factory;
    }
    public abstract CPU createCPU();
    public abstract MMU createMMU();


    public static void main(String[] args){
        Abstract_Factory factory = Abstract_Factory.getFactory(Architecture.EMBER);
        CPU cpu = factory.createCPU();
    }
}