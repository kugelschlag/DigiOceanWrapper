package com.kugelschlag.digitalocean.responseobjs;

/**
 * Created by dbarber on 4/10/18.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kugelschlag.http.response.BaseResponse;


/**
 * Rename wrapper for the response object returned from Digital Ocean from the
 * rename_droplet request
 */

public class Rename extends BaseResponse  {


    public static final String ACTION = "rename";
    public static final String NAME_PARAM = "name";

    //Action represents the outer enclosing JSON response object returned from Digital Ocean
    @SerializedName("action")
    @Expose
    private Action action;

    public Action getAction() {
        return action;
    }

}
