public class Kid extends Person {
    public Kid(String name) {
        super(name);
    }

    public void tweet() {
        super.greet();
        greet();
    }

    public void greet() {
        System.out.println("What's up!");
    }
}