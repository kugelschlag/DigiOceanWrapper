package com.kugelschlag.digitalocean.client; /**
 * Created by dbarber on 3/13/18.
 */


import com.kugelschlag.digitalocean.exceptions.DigitalOceanException;


public class DigiOceanClientDriver {

    DigiOceanClientDriver() {
    }

    public static void main(String args[]) {
        connectWithDigitalOceanServer();
    }


    /**
     * Test driver to connect with a running DigitalOcean server
     * Runs a few REST API commands that Digital Ocean exposes at the host IP:port
     */
    static private void connectWithDigitalOceanServer() {



        final String digiOceanToken = "xxx29fad...xxx"; //stubbed, use correct token
        final String dropletID = "xxx123"; //stubbed, use correct dropLetID

        try {


            DigitalOceanClient oceanClient = new DigitalOceanClient("https://api.digitalocean.com/v2/droplets/"
                    + dropletID +"/actions", okhttp3.Credentials.basic(digiOceanToken, ""));


            //----------------------------------------------------------------------------------------------------------
            //Test Digi Ocean API with wrapped calls and just print out response
            //----------------------------------------------------------------------------------------------------------
            System.out.println("Rename Droplet - Digital Ocean Server says:" + oceanClient.setRenameDroplet("BarbaDroplet1").getJsonBody() + "\n\n");
            System.out.println("Rename Droplet - Digital Ocean Server says:" + oceanClient.setRenameDroplet("BarbaDroplet2").getAction().getStatus() + "\n\n");


//            System.out.println("Reboot - Digital Ocean Server says:" + oceanClient.rebootDroplet().getJsonBody());
//            System.out.println("Reboot - Digital Ocean Server says:" + oceanClient.rebootDroplet().getAction().getStatus() +"\n");


//
//            System.out.println("Enable Backups - Digital Ocean Server says:" + oceanClient.setEnableBackups().getJsonBody());
//            System.out.println("Enable Backups - Digital Ocean Server says:" + oceanClient.setEnableBackups().getAction().getRegion().getFeatures() +"\n\n\n");
//
//            System.out.println("Disable Backups - Digital Ocean Server says:" + oceanClient.setDisableBackups().getJsonBody());
//            System.out.println("Disable Backups - Digital Ocean Server says:" + oceanClient.setDisableBackups().getAction().getRegion().getFeatures() +"\n");
//
//            System.out.println("Power Cycle - Digital Ocean Server says:" + oceanClient.powerCycleDroplet().getJsonBody());
//            System.out.println("Power Cycle  - Digital Ocean Server says:" + oceanClient.powerCycleDroplet().getAction().getStatus() +"\n");
//
//            System.out.println("Shutdown - Digital Ocean Server says:" + oceanClient.shutDownDroplet().getJsonBody());
//            System.out.println("Shutdown  - Digital Ocean Server says:" + oceanClient.shutDownDroplet().getAction().getStatus() +"\n");
//
//            System.out.println("Power On - Digital Ocean Server says:" + oceanClient.powerOnDroplet().getJsonBody());
//            System.out.println("Power On  - Digital Ocean Server says:" + oceanClient.powerOnDroplet().getAction().getStatus() +"\n");
//
//            System.out.println("Password Reset - Digital Ocean Server says:" + oceanClient.passwordResetDroplet().getJsonBody());
//            System.out.println("Password Reset - Digital Ocean Server says:" + oceanClient.passwordResetDroplet().getAction().getStatus() +"\n");


        } catch (DigitalOceanException e) {
            System.out.println("Digital Ocean Server says:  " + e.getMessage() + " : " + e.getCause().getMessage());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
