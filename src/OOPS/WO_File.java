package OOPS;

class Password {
    private String password;
    void setPassword(String password) {
        this.password = password;
    }
}
public class WO_File {

    public static void main(String[] args) {
        Password p = new Password();

        p.setPassword("admin123");
    }
}