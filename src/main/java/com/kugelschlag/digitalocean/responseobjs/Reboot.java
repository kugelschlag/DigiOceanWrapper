package com.kugelschlag.digitalocean.responseobjs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kugelschlag.http.response.BaseResponse;

/**
 * Created by dbarber on 4/11/18.
 */

/**
 * Reboot wrapper for the response object returned from Digital Ocean from the
 * enable_backups request
 *
 * A reboot action is an attempt to reboot the Droplet in a graceful way,
 * similar to using the reboot command from the console.
 *
 */
public class Reboot extends BaseResponse {

    public static final String ACTION = "reboot";

    //Action represents the outer enclosing JSON response object returned from Digital Ocean
    @SerializedName("action")
    @Expose
    private Action action;

    public Action getAction() {
        return action;
    }

}

