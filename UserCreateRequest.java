import java.time.LocalDate;

public class UserCreateRequest {
    String name;
    int age;
    LocalDate birthDate;

    public class User {
        String name;
        int age;
        LocalDate birthDate;

        public User(String name, int age, LocalDate birthDate) {
            this.name = name;
            this.age = age;
            this.birthDate = birthDate;
        }
    }

}
