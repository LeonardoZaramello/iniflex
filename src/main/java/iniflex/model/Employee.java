package iniflex.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;

public class Employee extends Person {
  BigDecimal salary;
  String role;

  public Employee(String name, LocalDate birthDate, BigDecimal salary, String role) {
    super(name, birthDate);
    this.salary = salary;
    this.role = role;
  }


  public BigDecimal getSalary() {
    return salary;
  }

  public String getSalaryFormated() {
    DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
    decimalFormatSymbols.setDecimalSeparator(',');
    decimalFormatSymbols.setGroupingSeparator('.');

    return new DecimalFormat("#,###.00", decimalFormatSymbols).format(this.salary);
  }

  public void setSalary(BigDecimal salary) {
    this.salary = salary;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getAllInfos() {
    return "Name: " + this.name + " - " + "Birth Date: " + this.getBirthDateFormated() + " - "
        + "Salary: " + this.getSalaryFormated() + " - " + "Role: " + this.role;
  }
}
