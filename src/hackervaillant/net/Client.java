/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hackervaillant.net;

import java.net.DatagramSocket;
import java.net.Socket;

/**
 *
 * @author judu
 */
public interface Client {

   public enum Host {
      BANK, PEOPLE;
   }

   public enum Proto {
      TCP, UDP;
   }

   public void connect();
   public void send();
   public Object receive();

}
