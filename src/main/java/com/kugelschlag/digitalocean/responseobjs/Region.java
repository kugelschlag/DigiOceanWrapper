package com.kugelschlag.digitalocean.responseobjs;

/**
 * Created by dbarber on 4/11/18.
 */
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Region is a sub-object of the Action object
 * Action represents the outer enclosing JSON response object returned from Digital Ocean
 */

public class Region {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("sizes")
    @Expose
    private List<String> sizes = null;
    @SerializedName("features")
    @Expose
    private List<String> features = null;
    @SerializedName("available")
    @Expose
    private Boolean available;


    public String getName() {
        return name;
    }

    public String getSlug() {
        return slug;
    }

    public List<String> getSizes() {
        return sizes;
    }

    public List<String> getFeatures() {
        return features;
    }

    public Boolean getAvailable() {
        return available;
    }
}