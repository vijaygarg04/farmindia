package farmindia.bmpl.com.farmindia;

/**
 * Created by nikhilgupta on 02/04/17.
 */

public class ContractFarmerShowModel {
    public String cropName;
    public String cropVariety;
    public String quantity;

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

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNoOfFarmers() {
        return noOfFarmers;
    }

    public void setNoOfFarmers(String noOfFarmers) {
        this.noOfFarmers = noOfFarmers;
    }

    public String getURLtoContract() {
        return URLtoContract;
    }

    public void setURLtoContract(String URLtoContract) {
        this.URLtoContract = URLtoContract;
    }

    public String getFPIname() {
        return FPIname;
    }

    public void setFPIname(String FPIname) {
        this.FPIname = FPIname;
    }

    public String getFPIcontactNo() {
        return FPIcontactNo;
    }

    public void setFPIcontactNo(String FPIcontactNo) {
        this.FPIcontactNo = FPIcontactNo;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String price;
    public String noOfFarmers;
    public String URLtoContract;
    public String FPIname;
    public String FPIcontactNo;
    public String duration;

    public ContractFarmerShowModel(){

    }
    public ContractFarmerShowModel(ContractFarmerShowModel contractFarmerShowModel){
                this.cropVariety=contractFarmerShowModel.getCropVariety();
                this.duration=contractFarmerShowModel.getDuration();
        this.cropName=contractFarmerShowModel.getCropName();
        this.URLtoContract=contractFarmerShowModel.getURLtoContract();
        this.FPIcontactNo=contractFarmerShowModel.getFPIcontactNo();
        this.FPIname=contractFarmerShowModel.getFPIname();
        this.price=contractFarmerShowModel.getPrice();
        this.quantity=contractFarmerShowModel.getQuantity();
        this.noOfFarmers=contractFarmerShowModel.getNoOfFarmers();

        //this.cropName=contractFarmerShowModel.cropName;

       // this.cropVariety=contractFarmerShowModel.

    }

    public ContractFarmerShowModel(String cropName, String cropVariety, String quantity, String price, String noOfFarmers, String URLtoContract, String FPIname, String FPIcontactNo, String duration) {
        this.cropName = cropName;
        this.cropVariety = cropVariety;
        this.quantity = quantity;
        this.price = price;
        this.noOfFarmers = noOfFarmers;
        this.URLtoContract = URLtoContract;
        this.FPIname = FPIname;
        this.FPIcontactNo = FPIcontactNo;
        this.duration = duration;
    }
}
