package org.acme.Persistence;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Entity
@Getter
@Setter
@ToString

public class User extends PanacheEntity{
    @NotBlank(message="Username can not be empty")
    private String Username;

    @Email(message = "Wrong format email")
    @NotBlank(message="Email can not be empty")
    private String Email;

    @Pattern(regexp="(^$|[0-9]{10})")
    private String Telephonnumber;

    @NotBlank(message="Password can not be empty")
    private String Password;




}