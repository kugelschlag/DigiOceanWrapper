package com.kugelschlag.digitalocean.responseobjs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kugelschlag.http.response.BaseResponse;

/**
 * Created by dbarber on 4/11/18.
 */

/**
 * PowerOn  wrapper for the response object returned from Digital Ocean from the
 * enable_backups request
 *
 * Power On a Droplet that was off
 */
public class PowerOn extends BaseResponse {

    public static final String ACTION = "power_on";

    //Action represents the outer enclosing JSON response object returned from Digital Ocean
    @SerializedName("action")
    @Expose
    private Action action;

    public Action getAction() {
        return action;
    }

}

