package farmindia.bmpl.com.farmindia;

/**
 * Created by nikhilgupta on 30/03/17.
 */

public class BuyCropModel {


   public String cropName;
    public String cropVariety;
    public String price;
    public String contactNo;
    public String farmerName;
    public String farmerMail;
    public String quantity;

    public BuyCropModel(String farmerMail,String farmerName,String cropName, String cropVariety, String price, String quantity, String latitude, String longitude,String contactNo) {
        this.cropName = cropName;
        this.cropVariety = cropVariety;
        this.price = price;
        this.farmerMail=farmerMail;
        this.quantity = quantity;
        this.farmerName=farmerName;
        this.latitude = latitude;
        this.contactNo=contactNo;
        this.longitude = longitude;
    }


    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getFarmerName() {
        return farmerName;
    }

    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
    }

    public String getFarmerMail() {
        return farmerMail;
    }

    public void setFarmerMail(String farmerMail) {
        this.farmerMail = farmerMail;
    }

    private String latitude;
    private String longitude;

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public String getCropVariety() {
        return cropVariety;
    }

    public void setCropVariety(String cropVariety) {
        this.cropVariety = cropVariety;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
