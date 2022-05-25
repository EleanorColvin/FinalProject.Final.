public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public void greet() {
        System.out.println("Hello!");
    }

    public void introduce() {
        System.out.println("My name is " + name);
    }

    public void greetAndIntroduce() {
        greet();
        introduce();
    }
}