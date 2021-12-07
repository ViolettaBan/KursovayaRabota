package by.vita02.backend.users;

import by.vita02.backend.enums.Role;

import javax.persistence.*;

@Entity
@Table(name = "useros")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {

  private String nickName;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String surname;
  private String emailAddr;
  private String password;

  public String getPassword() {
    return password;
  }

  private Role role;

  public User(String nickName, String name, String surname, String emailAddr, Role role) {
    this.nickName = nickName;
    this.name = name;
    this.surname = surname;
    this.emailAddr = emailAddr;
    this.role = role;
  }

  public User() {}

  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getEmailAddr() {
    return emailAddr;
  }

  public void setEmailAddr(String emailAddr) {
    this.emailAddr = emailAddr;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }
}
