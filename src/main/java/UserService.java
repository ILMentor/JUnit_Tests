import Exceptions.CustomFieldException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

public class UserService {

    private List<Users> users;

    public UserService(List<Users> users) {
        this.users = users;
    }

    public List<Users> getUsers() {
        return users;
    }

    public List<Users> createNewUser(String name, LocalDate dateOfBirth) throws CustomFieldException {
        validateUser(name, dateOfBirth);
         Users user = new Users(name, dateOfBirth);
         users.add(user);
         return users;
    }

    public void removeUser(String name){
        users = users.stream().filter(it -> !it.getName().equals(name)).collect(Collectors.toList());
    }

    private void validateUser(String name, LocalDate dateOfBirth) throws CustomFieldException {
        if(isNull(name) || name.isBlank())
            throw new CustomFieldException("Name could not be empty or null");
        if(isNull(dateOfBirth))
            throw new CustomFieldException("Date of birth could not be null");
    }

    public boolean isBirthDay(Users user, LocalDate localDate) throws CustomFieldException {
        if(isNull(user) || isNull(user.getDateOfBirth()))
            throw new CustomFieldException("User of date of birthday is null");
        if (isNull(localDate))
            throw new CustomFieldException("Compare date could nor be null");
        return user.getDateOfBirth().getDayOfMonth() == localDate.getDayOfMonth()
                && localDate.getMonth().equals(user.getDateOfBirth().getMonth());
    }
}
