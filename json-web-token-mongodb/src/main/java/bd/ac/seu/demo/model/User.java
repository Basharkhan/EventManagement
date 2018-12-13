package bd.ac.seu.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "User")
public class User {
    private String id;
    private String userName;
    private String email;
    private String password;
    private Set<Role> roles;
}
