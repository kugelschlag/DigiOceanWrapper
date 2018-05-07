package com.kugelschlag.digitalocean.responseobjs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kugelschlag.http.response.BaseResponse;

/**
 * Created by dbarber on 4/11/18.
 */

/**
 * Shutdown  wrapper for the response object returned from Digital Ocean from the
 * enable_backups request
 *
 * A shutdown action is an attempt to shutdown the Droplet in a graceful way,
 * similar to using the shutdown command from the console.
 * Since a shutdown command can fail, this action guarantees that the command
 * is issued, not that it succeeds.
 * The preferred way to turn off a Droplet is to attempt a shutdown,
 * with a reasonable timeout, followed by a power off action to ensure the Droplet is off.
 */
public class Shutdown extends BaseResponse {

    public static final String ACTION = "shutdown";

    //Action represents the outer enclosing JSON response object returned from Digital Ocean
    @SerializedName("action")
    @Expose
    private Action action;

    public Action getAction() {
        return action;
    }

}

