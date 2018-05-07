package com.kugelschlag.digitalocean.client;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import com.kugelschlag.digitalocean.responseobjs.*;
import com.kugelschlag.digitalocean.exceptions.DigitalOceanException;
import com.kugelschlag.http.post.HttpPost;
import com.kugelschlag.http.request.Request;
import com.kugelschlag.http.response.BaseResponse;


import java.io.IOException;

public class DigitalOceanClient {

    public static final String ACTION_TYPE_KEY = "type";

    private final Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();

    private final HttpPost httpPost;

    //Base64 encoded basic auth token
    private String token;

    public DigitalOceanClient(String host, String token) {
        this.httpPost = new HttpPost(host, token);
        this.token = token;
    }


    /**
     * Rename the Digital Ocean Droplet
     * - create a request and return a response
     * @param newName  - the new name for the droplet
     * @return Rename - the provisioned/populated response object
     */
    public Rename setRenameDroplet(String newName) {
        Request request = Request.action(ACTION_TYPE_KEY, Rename.ACTION)
                .param(Rename.NAME_PARAM, newName)
                .build();

        return provisionReponse(request, Rename.class);

    }

    /**
     * Enable Backups on the Digital Ocean Droplet
     * - create a request and return a response
     * @return EnableBackups - the provisioned/populated response object
     */
    public EnableBackups setEnableBackups() {
        Request request = Request.action(ACTION_TYPE_KEY, EnableBackups.ACTION)
                .build();
        return provisionReponse(request, EnableBackups.class);

    }


    /**
     * Disable Backups on the Digital Ocean Droplet
     * - create a request and return a response
     * @return DisableBackups - the provisioned/populated response object
     */
    public DisableBackups setDisableBackups() {
        Request request = Request.action(ACTION_TYPE_KEY, DisableBackups.ACTION)
                .build();
        return provisionReponse(request, DisableBackups.class);

    }


    /**
     * Reboot the Digital Ocean Droplet
     * - create a request and return a response
     * @return Reboot - the provisioned/populated response object
     */
    public Reboot rebootDroplet() {
        Request request = Request.action(ACTION_TYPE_KEY, Reboot.ACTION)
                .build();
        return provisionReponse(request, Reboot.class);

    }


    /**
     * Shutdown the Digital Ocean Droplet
     * - create a request and return a response
     * @return Reboot - the provisioned/populated response object
     */
    public Shutdown shutDownDroplet() {
        Request request = Request.action(ACTION_TYPE_KEY, Shutdown.ACTION)
                .build();
        return provisionReponse(request, Shutdown.class);

    }


    /**
     * Power On the Digital Ocean Droplet
     * - create a request and return a response
     * @return Reboot - the provisioned/populated response object
     */
    public PowerOn powerOnDroplet() {
        Request request = Request.action(ACTION_TYPE_KEY, PowerOn.ACTION)
                .build();
        return provisionReponse(request, PowerOn.class);

    }


    /**
     * PowerCycle the Digital Ocean Droplet
     * - create a request and return a response
     * @return PowerCycle - the provisioned/populated response object
     */
    public PowerCycle powerCycleDroplet() {
        Request request = Request.action(ACTION_TYPE_KEY, PowerCycle.ACTION)
                .build();
        return provisionReponse(request, PowerCycle.class);

    }


    /**
     * Password Reset the Digital Ocean Droplet
     * - create a request and return a response
     * @return PowerCycle - the provisioned/populated response object
     */
    public PasswordReset passwordResetDroplet() {
        Request request = Request.action(ACTION_TYPE_KEY, PasswordReset.ACTION)
                .build();
        return provisionReponse(request, PasswordReset.class);

    }



    ///////////////////////////////////////////////////////////////////////////
    //Provision/populate the response object with data from server
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Post a request and provision/populate a response
     * @param request - the request object to be used for the HTTP Post
     * @param classType - Class type of BaseResponse
     * @param <T> Class type T generic
     * @return BaseResponse type provisioned object
     */
    private <T extends BaseResponse> T provisionReponse(Request request, Class<T> classType) {

        try {

            //create the json strong from the key/value pair in the map
            String json = gson.toJson(request.getMap());

            //post the request - in this case a Base64 basic auth token is used for authentication
            String body = httpPost.post(json, token);

            //create the response object
            T t = gson.fromJson(body, classType);

            //System.out.println(t.isSuccess());

            //add convenience json string for response objects to hold
            t.setJsonBody(body);

            if (!t.isSuccess()) {
                throw new DigitalOceanException(t.getErrorMsg());
            }

            //return the provisioned response object
            return t;


        } catch (IOException e) {
            throw new DigitalOceanException("Unable to communicate with node, correct IP:port address?", e);
        }
        catch (Exception e)  {
            e.printStackTrace();
        }
        return null;
    }
}
