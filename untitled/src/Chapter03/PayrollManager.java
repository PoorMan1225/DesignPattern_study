package Chapter03;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class PayrollManager {
    private List<Employee> employees = new ArrayList<>();
    private OutputFormat outputFormat;

    public void writeEmployeePay() {
        employees.forEach(employee -> outputFormat.print(employee.calculatePay()));
    }

}
