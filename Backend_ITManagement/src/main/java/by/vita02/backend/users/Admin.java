package by.vita02.backend.users;


import by.vita02.backend.enums.Role;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "admins")
public class Admin extends User{
    public Admin(String nickName, String name, String surname, String emailAddr, Role role) {
        super(nickName, name, surname, emailAddr, role);
    }

    public Admin() {
    }
}
