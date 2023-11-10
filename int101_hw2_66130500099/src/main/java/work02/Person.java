package work02;
import java.util.Objects;
import work01.Utilitor;

public class Person {
    private static int nextId = 1;
    private int id;
    private String firstname ;
    private String lastname;



    public Person(String firstname, String lastname) {
        if(Utilitor.testString(firstname) != null && Utilitor.testString(lastname) != null) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = nextId;
        nextId++;
        }


    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("id=").append(id);
        sb.append(", firstname='").append(firstname).append('\'');
        sb.append(", lastname='").append(lastname).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = Utilitor.testString(firstname);
    }

    public void setLastname(String lastname) {
        this.lastname = Utilitor.testString(lastname);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return getId() == person.getId() && Objects.equals(getFirstname(), person.getFirstname()) && 
                Objects.equals(getLastname(), person.getLastname());
    }


}
