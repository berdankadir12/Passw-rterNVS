package at.htl;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@ToString

@Entity
public class User  {

    @Id
    @GeneratedValue
    private long id;

    @NotBlank(message="Username can not be empty")

    private String username;

    @Email(message = "Wrong format email")
    @NotBlank(message="Email can not be empty")
    private String email;

    private String telNr;

    @NotBlank(message="Password can not be empty")
    private String password;


    private String salt;


}