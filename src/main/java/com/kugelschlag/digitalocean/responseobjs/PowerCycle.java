package com.kugelschlag.digitalocean.responseobjs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kugelschlag.http.response.BaseResponse;

/**
 * Created by dbarber on 4/11/18.
 */

/**
 * Power Cycle  wrapper for the response object returned from Digital Ocean from the
 * enable_backups request
 *
 * A powercycle action is similar to pushing the reset button on a physical machine,
 * it's similar to booting from scratch
 */
public class PowerCycle extends BaseResponse {

    public static final String ACTION = "power_cycle";

    //Action represents the outer enclosing JSON response object returned from Digital Ocean
    @SerializedName("action")
    @Expose
    private Action action;

    public Action getAction() {
        return action;
    }

}

