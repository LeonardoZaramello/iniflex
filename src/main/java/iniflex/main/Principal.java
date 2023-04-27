package iniflex.main;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import iniflex.model.Employee;

public class Principal {

  public static void main(String[] args) {

    // 3.1 � Inserir todos os funcion�rios, na mesma ordem e informa��es da tabela acima.
    List<Employee> employees = new ArrayList<Employee>() {
      {
        add(new Employee("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"),
            "Operador"));
        add(new Employee("Jo�o", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        add(new Employee("Caio", LocalDate.of(1961, 5, 02), new BigDecimal("9836.14"),
            "Coordenador"));
        add(new Employee("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"),
            "Diretor"));
        add(new Employee("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"),
            "Recepcionista"));
        add(new Employee("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"),
            "Operador"));
        add(new Employee("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"),
            "Contador"));
        add(new Employee("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        add(new Employee("Helo�sa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"),
            "Eletricista"));
        add(new Employee("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));
      }
    };


    // 3.2 � Remover o funcion�rio �Jo�o� da lista.
    // employees.removeIf(emp -> emp.getName().equals("Jo�o"));
    employees = employees.stream().filter(emp -> !emp.getName().equals("Jo�o"))
        .collect(Collectors.toList());



    // 3.3 � Imprimir todos os funcion�rios com todas suas informa��es, sendo que:
    // � informa��o de data deve ser exibido no formato dd/mm/aaaa;
    // � informa��o de valor num�rico deve ser exibida no formatado com separador de milhar como
    // ponto e decimal como v�rgula.
    System.out.println("3.3 - Imprimir todos os funcion�rios com todas suas informa��es.");

    for (Employee employee : employees) {
      System.out.println(employee.getAllInfos());
    }
    System.out.println("");


    // 3.4 � Os funcion�rios receberam 10% de aumento de sal�rio, atualizar a lista de funcion�rios
    // com novo valor.
    System.out.println(
        "3.4 - Os funcion�rios receberam 10% de aumento de sal�rio, atualizar a lista de funcion�rios com novo valor.");
    for (Employee employee : employees) {
      BigDecimal oldSalary = employee.getSalary();
      employee.setSalary(
          employee.getSalary().multiply(new BigDecimal(1.1)).setScale(2, RoundingMode.HALF_UP));


      System.out.println(MessageFormat.format("{0} old Salary: {1} - new Salary: {2}",
          employee.getName(), oldSalary, employee.getSalary()));
    }
    System.out.println("");


    // 3.5 � Agrupar os funcion�rios por fun��o em um MAP, sendo a chave a �fun��o� e o valor a
    // �lista de funcion�rios�.
    Map<String, List<String>> employeeRoleMap = new HashMap<String, List<String>>();
    List<String> list;

    for (Employee employee : employees) {
      if (employeeRoleMap.containsKey(employee.getRole())) {

        list = employeeRoleMap.get(employee.getRole());
        list.add(employee.getName());
      } else {

        list = new ArrayList<String>();
        list.add(employee.getName());
        employeeRoleMap.put(employee.getRole(), list);
      }
    }


    // 3.6 � Imprimir os funcion�rios, agrupados por fun��o.
    System.out.println("3.6 - Imprimir os funcion�rios, agrupados por fun��o.");
    System.out.println(employeeRoleMap);
    System.out.println("");


    // 3.8 � Imprimir os funcion�rios que fazem anivers�rio no m�s 10 e 12.
    System.out.println("3.8 - Imprimir os funcion�rios que fazem anivers�rio no m�s 10 e 12.");

    employees.stream()
        .filter(employee -> employee.getBirthDate().getMonthValue() == 10
            || employee.getBirthDate().getMonthValue() == 12)
        .forEach(employee -> System.out.println(employee.getAllInfos()));
    System.out.println("");


    // 3.9 � Imprimir o funcion�rio com a maior idade, exibir os atributos: nome e idade.
    System.out.println(
        "3.9 - Imprimir o funcion�rio com a maior idade, exibir os atributos: nome e idade.");

    Employee oldestEmployee = employees.stream().max((actual, next) -> {
      if (actual.getBirthDate().isBefore(next.getBirthDate())) {
        return 1;
      } else if (actual.getBirthDate().isAfter(next.getBirthDate())) {
        return -1;
      }
      return 0;
    }).get();

    System.out.println("Name: " + oldestEmployee.getName() + " - " + "Age: "
        + Period.between(oldestEmployee.getBirthDate(), LocalDate.now()).getYears());
    System.out.println("");


    // 3.10 � Imprimir a lista de funcion�rios por ordem alfab�tica.
    System.out.println("3.10 - Imprimir a lista de funcion�rios por ordem alfab�tica.");
    employees.stream().sorted((actual, next) -> actual.getName().compareTo(next.getName()))
        .forEach(employee -> System.out.println(employee.getAllInfos()));

    System.out.println("");


    // 3.11 � Imprimir o total dos sal�rios dos funcion�rios.
    System.out.println("3.11 - Imprimir o total dos sal�rios dos funcion�rios.");

    BigDecimal totalSalary =
        employees.stream().map(emp -> emp.getSalary()).reduce(BigDecimal::add).get();

    System.out.println("Total: " + totalSalary);
    System.out.println("");

    // 3.12 � Imprimir quantos sal�rios m�nimos ganha cada funcion�rio, considerando que o sal�rio
    // m�nimo � R$1212.00.
    System.out.println(
        "3.12 - Imprimir quantos sal�rios m�nimos ganha cada funcion�rio, considerando que o sal�rio m�nimo � R$1212.00.");

    for (Employee employee : employees) {
      BigDecimal minWage =
          employee.getSalary().divide(new BigDecimal(1211), 1, RoundingMode.HALF_UP);

      System.out.println(
          MessageFormat.format("{0} earns {1} minimum wages", employee.getName(), minWage));
    }

  }

}
