/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hackervaillant.net;

import hackervaillant.net.HostManager.Host;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author judu
 */
public class UDPClient implements Client {

   DatagramSocket socket;

   Host host;

   public UDPClient(Host host) {
      try {
         this.host = host;
         socket = new DatagramSocket();

      } catch (SocketException ex) {
         Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
      }

   }

   public void connect() {
      return;
   }

   public void send(Object obj) {
      try {
         if (!(obj instanceof String)) {
            return;
         }
         String str = (String) obj;
         byte[] sendData = str.getBytes();

         DatagramPacket packet = new DatagramPacket(sendData, sendData.length, InetAddress.getByName(HostManager.getIP(host)), HostManager.getUPort(host));
         socket.send(packet);
      } catch (IOException ex) {
         Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
      }

      socket.close();
   }

   public Object receive() {
      return null;
   }
}
