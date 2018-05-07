package com.kugelschlag.digitalocean.responseobjs;

/**
 * Created by dbarber on 4/11/18.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * Action represents the outer enclosing JSON response object returned from Digital Ocean
 */
public class Action {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("started_at")
    @Expose
    private String startedAt;
    @SerializedName("completed_at")
    @Expose
    private String completedAt;
    @SerializedName("resource_id")
    @Expose
    private Integer resourceId;
    @SerializedName("resource_type")
    @Expose
    private String resourceType;
    @SerializedName("region")
    @Expose
    private Region region;
    @SerializedName("region_slug")
    @Expose
    private String regionSlug;

    public Integer getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public String getStartedAt() {
        return startedAt;
    }

    public String getCompletedAt() {
        return completedAt;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public String getResourceType() {
        return resourceType;
    }

    public Region getRegion() {
        return region;
    }

    public String getRegionSlug() {
        return regionSlug;
    }
}

