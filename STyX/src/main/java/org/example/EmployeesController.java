package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class EmployeesController {

    @GetMapping("/api/employees")
    public ModelAndView employees(@RequestParam(value = "search", required = false, defaultValue = "") final String search) {
        final var alice = new Employee("1", "Alice");
        final var bob = new Employee("2", "Bob");
        final var employees = Stream.of(alice, bob)
                .filter(employee -> search.isEmpty() || employee.name().startsWith(search))
                .collect(Collectors.toList());
        final var employeesModel = new EmployeesModel(employees);

        return new ModelAndView("employees", "employeesModel", employeesModel);
    }
}