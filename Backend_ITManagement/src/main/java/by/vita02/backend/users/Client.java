package by.vita02.backend.users;

import by.vita02.backend.company.Company;
import by.vita02.backend.enums.Role;
import by.vita02.backend.order.Order;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientos")
public class Client extends User {

  private String passportNumber;
  @OneToOne(cascade = CascadeType.ALL) private Company company;
  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL) private List<Order> orders = new ArrayList<>();

  public Client(
      String nickName,
      String name,
      String surname,
      String emailAddr,
      String passportNumber,
      Company company) {
    super(nickName, name, surname, emailAddr, Role.CLIENT);
    this.passportNumber = passportNumber;
    this.company = company;
  }

  public Client() {}

  public String getPassportNumber() {
    return passportNumber;
  }

  public void setPassportNumber(String passportNumber) {
    this.passportNumber = passportNumber;
  }

  public Company getCompany() {
    return company;
  }

  public void setCompany(Company company) {
    this.company = company;
  }

  public List<Order> getOrders() {
    return orders;
  }

  public void setOrders(List<Order> orders) {
    this.orders = orders;
  }
}
