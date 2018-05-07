package com.kugelschlag.digitalocean.responseobjs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kugelschlag.http.response.BaseResponse;

/**
 * Created by dbarber on 4/11/18.
 */

/**
 * EnableBackups wrapper for the response object returned from Digital Ocean from the
 * enable_backups request
 */
public class EnableBackups extends BaseResponse {

    public static final String ACTION = "enable_backups";

    //Action represents the outer enclosing JSON response object returned from Digital Ocean
    @SerializedName("action")
    @Expose
    private Action action;

    public Action getAction() {
        return action;
    }

}

