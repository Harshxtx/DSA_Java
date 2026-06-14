package OOPS;

class Movie {
    String name;
    int duration;
    double rating;
    String genre;

    void display(){
        System.out.println("Movie name: "+name);
        System.out.println("Duration(in min.): "+duration+" min");
        System.out.println("Rating: "+rating+"/5");
        System.out.println("Genre: "+genre);
    }
}

public class ClassAndObject {
    public static void main(String[] args) {

        Movie avenger = new Movie();

        avenger.name="Avengers: Doomsday";
        avenger.duration=210;
        avenger.rating=4.9;
        avenger.genre="Action";

        avenger.display();
        System.out.println();

        Movie  interstellar= new Movie();

        interstellar.name="Interstellar";
        interstellar.duration=170;
        interstellar.rating=4.7;
        interstellar.genre="Adventure";

        interstellar.display();
    }
}
