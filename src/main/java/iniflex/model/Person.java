package iniflex.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Person {
  String name;
  LocalDate birthDate;


  public Person(String name, LocalDate birthDate) {
    this.name = name;
    this.birthDate = birthDate;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public String getBirthDateFormated() {
    DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String formatedDate = this.birthDate.format(formater);
    return formatedDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }
}
