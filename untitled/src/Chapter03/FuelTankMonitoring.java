package Chapter03;

public class FuelTankMonitoring {
    private WarningSignal warningSignal;
    private InspectionTank inspectionTank;

    public void checkAndWarn() {
        if(inspectionTank.checkFuelTank()) {
            warningSignal.giveWarningSignal();
        }
    }
}
