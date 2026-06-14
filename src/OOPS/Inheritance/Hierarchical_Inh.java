package OOPS.Inheritance;

class Mercedes {

    void name() {
        System.out.print("Mercedes - ");
    }
}

class Benz extends Mercedes {

    void model() {
        System.out.println("Benz Roadster");
    }
}

class AMG extends Mercedes {

    void model() {
        System.out.println("AMG One");
    }
}

public class Hierarchical_Inh {

    public static void main(String[] args) {

        Benz b=new Benz();
        b.name();
        b.model();
        System.out.println();

        AMG a=new AMG();
        a.name();
        a.model();
    }
}
