package farmindia.bmpl.com.farmindia;

/**
 * Created by nikhilgupta on 17/03/17.
 */

class SingleItemModel {
    private String name;
    private int url;
    private String description;
    private String uniqueId;


    public SingleItemModel() {
    }

    public SingleItemModel(String name, int url,String uniqueId) {
        this.name = name;
        this.url = url;
        this.uniqueId=uniqueId;
        this.description = name;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public int getUrl() {
        return url;
    }

    public void setUrl(int url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
