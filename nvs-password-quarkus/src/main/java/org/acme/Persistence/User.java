package org.acme.Persistence;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Entity
@Getter
@Setter
@ToString

public class User extends PanacheEntity{
    private String userName;
    private String telephonNumber;
    private String passWord;




}