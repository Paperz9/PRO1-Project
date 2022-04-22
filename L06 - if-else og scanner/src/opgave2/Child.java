package opgave2;

public class Child {
    private int age;
    private boolean male;

    public Child(int age, boolean male) {
        this.age = age;
        this.male = male;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMale(){
        return this.male;
    }

    public String institution() {
        if (age == 0) {
            System.out.print("Home");
        }
        else if (age >= 1 && age <= 2) {
            System.out.print("Nursery");
        }
        else if (age >= 3 && age <= 5) {
            System.out.print("Kindergarten");
        }
        else if (age >= 6 && age <= 16) {
            System.out.print("School");
        }
        else if (age >= 17) {
            System.out.print("Out of school");
        }
        return "";
    }

    public String gender() {
        if (male) {
            System.out.print("It's a boy");
        }
        else {
            System.out.print("It's a girl");
        }
        return "";
    }

    public String team() {
        if (male && age < 8) {
            System.out.print("Young boys");
        }
        else if (male) {
            System.out.print("Cool boys");
        }
        else if (!male && age < 8) {
            System.out.print("Tumbling girls");
        }
        else if (!male) {
            System.out.print("Springy girls");
        }
        return "";
    }
}
