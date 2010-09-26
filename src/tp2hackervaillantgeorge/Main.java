/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2hackervaillantgeorge;

import hackervaillant.net.HostManager;
import hackervaillant.util.ClientTCPDial;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author indy
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if(args.length < 2) {
           System.err.println("Usage: prog peopleIP bankIP");
        }
        System.out.println(args[0]);
        System.out.println(args[1]);

        HostManager.addHost(HostManager.Host.PEOPLE, args[0], 4096, 2048);
        HostManager.addHost(HostManager.Host.BANK, args[1], 4243, 4242);


        ClientTCPDial server = new ClientTCPDial();
        server.start();
      try {
         server.join();
      } catch (InterruptedException ex) {
         Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
      }
        
    }
}
