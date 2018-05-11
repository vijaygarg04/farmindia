package farmindia.bmpl.com.farmindia;

/**
 * Created by nikhilgupta on 11/03/17.
 */

public class ModelClassForRegistration {

    public ModelClassForRegistration( ){

    }
    public int code;
    public String name;
    private String phone;
    private String email;
    private String latitude;
    private String longitude;
    private int noOfposts;
   // private String dob;
    private String age;

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }

    public int getNoOfposts() {
        return noOfposts;
    }

    public void setNoOfposts(int noOfposts) {
        this.noOfposts = noOfposts;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public boolean isSignedIn() {
        return isSignedIn;
    }

    public void setSignedIn(boolean signedIn) {
        isSignedIn = signedIn;
    }

    private boolean isSignedIn=false;

    public ModelClassForRegistration(String name, String phone, String age, String email, boolean isSignedIn,int code,String latitude,String longitude) {
        this.name=name;
        this.phone=phone;
        this.email=email;
        this.age= age;
        this.isSignedIn=isSignedIn;
        this.code=code;
        this.latitude=latitude;
        this.longitude=longitude;
        this.noOfposts=0;
    }
}
