import java.time.LocalDate;

public class Users {
    private String name;
    private LocalDate dateOfBirth;

    public Users(String name, LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
}
