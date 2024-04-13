package thymeleaf.exam;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
public  class User {
    @NonNull
    private String userName;
    private int age;
}
