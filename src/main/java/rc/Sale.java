package rc;

import java.util.Map;

public class Sale {
    //Sale parameters
    String saleName;
    String startDate;
    String endDate;
    int saleCap;
    Map<String, Integer> mapPaymentMethodTypeToRate;
    Map<Integer, Integer> mapDaystoPercentTokensBonuses; // Time bonus
    Map<Integer, Integer> mapAmounttoPercentTokensBonuses;// Amount bonus


    public Sale(String saleName, String startDate, String endDate, int saleCap, Map<String, Integer> mapPaymentMethodTypeToRate, Map<Integer, Integer> mapDaystoPercentTokensBonuses, Map<Integer, Integer> mapAmounttoPercentTokensBonuses) {
        this.saleName = saleName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.saleCap = saleCap;
        this.mapPaymentMethodTypeToRate = mapPaymentMethodTypeToRate;
        this.mapDaystoPercentTokensBonuses = mapDaystoPercentTokensBonuses;
        this.mapAmounttoPercentTokensBonuses = mapAmounttoPercentTokensBonuses;
    }

    public String getSaleName() {
        return saleName;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public int getSaleCap() {
        return saleCap;
    }

    public Map<String, Integer> getMapPaymentMethodTypeToRate() {
        return mapPaymentMethodTypeToRate;
    }

    public Map<Integer, Integer> getMapDaystoPercentTokensBonuses() {
        return mapDaystoPercentTokensBonuses;
    }

    public Map<Integer, Integer> getMapAmounttoPercentTokensBonuses() {
        return mapAmounttoPercentTokensBonuses;
    }
}
