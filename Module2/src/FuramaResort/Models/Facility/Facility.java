package FuramaResort.Models.Facility;

public abstract class Facility {
    private String serviceName;
    private int areaUsing;
    private long priceOfService;
    private byte limitNumberPeople;
    private String typeOfRental;

    public Facility(String serviceName, int areaUsing, long priceOfService, byte limitNumberPeople, String typeOfRental) {
        this.serviceName = serviceName;
        this.areaUsing = areaUsing;
        this.priceOfService = priceOfService;
        this.limitNumberPeople = limitNumberPeople;
        this.typeOfRental = typeOfRental;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getAreaUsing() {
        return areaUsing;
    }

    public void setAreaUsing(int areaUsing) {
        this.areaUsing = areaUsing;
    }

    public long getPriceOfService() {
        return priceOfService;
    }

    public void setPriceOfService(long priceOfService) {
        this.priceOfService = priceOfService;
    }

    public byte getLimitNumberPeople() {
        return limitNumberPeople;
    }

    public void setLimitNumberPeople(byte limitNumberPeople) {
        this.limitNumberPeople = limitNumberPeople;
    }

    public String getTypeOfRental() {
        return typeOfRental;
    }

    public void setTypeOfRental(String typeOfRental) {
        this.typeOfRental = typeOfRental;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "serviceName='" + serviceName + '\'' +
                ", areaUsing=" + areaUsing +
                ", priceOfService=" + priceOfService +
                ", limitNumberPeople=" + limitNumberPeople +
                ", typeOfRental='" + typeOfRental + '\'' +
                '}';
    }
}
