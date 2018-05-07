package com.kugelschlag.digitalocean.responseobjs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kugelschlag.http.response.BaseResponse;


/**
 * Created by dbarber on 4/11/18.
 */

/**
 * DisableBackups wrapper for the response object returned from Digital Ocean from the
 * disable_backups request
 */

public class DisableBackups extends BaseResponse {

    public static final String ACTION = "disable_backups";

    //Action represents the outer enclosing JSON response object returned from Digital Ocean
    @SerializedName("action")
    @Expose
    private Action action;

    public Action getAction() {
        return action;
    }
}
