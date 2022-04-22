package opgave2;

public class Person {
    private final String name;
    private final int dayOfBirth; // 1..31
    private final int monthOfBirth; // 1..12
    private final int yearOfBirth; // 1900..2010

    public Person(String name, int yearOfBirth, int monthOfBirth, int dayOfBirth) {
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
    }

    public int calcAge(int day, int month, int year) {
        int age = year - yearOfBirth;
        if (month < monthOfBirth || month == monthOfBirth && day <= dayOfBirth) {
            return age - 1;
        }
        else {
            return age;
        }
    }


    public void printPerson() {
        System.out.println(name + ", born " + yearOfBirth + "-" + monthOfBirth + "-" + dayOfBirth);
    }
}
