package farmindia.bmpl.com.farmindia;

/**
 * Created by nikhilgupta on 02/04/17.
 */

public class BuyCropRetailerShowModel {


    public String cropName;
    public String cropVariety;
    public String price;
    public String contactNo;
    public String farmerName;
    public String farmerMail;
    public String date;
    public int noOfposts;

    BuyCropRetailerShowModel(BuyCropRetailerShowModel buyCropRetailerShowModel){
        this.cropName=buyCropRetailerShowModel.cropName;
        this.cropVariety=buyCropRetailerShowModel.cropVariety;
        this.price=buyCropRetailerShowModel.price;
        this.contactNo=buyCropRetailerShowModel.contactNo;
        this.farmerName=buyCropRetailerShowModel.farmerName;
        this.farmerMail=buyCropRetailerShowModel.farmerMail;
        this.date=buyCropRetailerShowModel.date;
        this.quantity=buyCropRetailerShowModel.quantity;
        this.imageURL=buyCropRetailerShowModel.imageURL;
        this.latitude=buyCropRetailerShowModel.latitude;
        this.longitude=buyCropRetailerShowModel.longitude;

    }
    public BuyCropRetailerShowModel(){


    }
    public BuyCropRetailerShowModel(String cropName, String cropVariety, String price, String contactNo, String farmerName, String farmerMail, String date, String quantity, String imageURL, String latitude, String longitude,int noOfposts) {
        this.cropName = cropName;
        this.cropVariety = cropVariety;
        this.price = price;
        this.contactNo = contactNo;
        this.farmerName = farmerName;
        this.farmerMail = farmerMail;
        this.date = date;
        this.quantity = quantity;
        this.imageURL = imageURL;
        this.noOfposts=noOfposts;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String quantity;
    public String imageURL;
    public String latitude;
    public String longitude;

}
