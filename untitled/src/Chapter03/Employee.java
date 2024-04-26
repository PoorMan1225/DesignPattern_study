package Chapter03;

public class Employee {
    private int payOfHour = 0;
    private int hourOfWork = 0;

    public int getPayOfHour() {
        return payOfHour;
    }

    public void setPayOfHour(int payOfHour) {
        this.payOfHour = payOfHour;
    }

    public int getHourOfWork() {
        return hourOfWork;
    }

    public void setHourOfWork(int hourOfWork) {
        this.hourOfWork = hourOfWork;
    }

    public String calculatePay() {
        return String.valueOf(hourOfWork * payOfHour);
    }
}
