package hackervaillant.net;

import hackervaillant.net.HostManager.Host;
import hackervaillant.util.Person;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author judu
 */
public class TCPClient implements Client {

   private Socket socket;

   private Host host;

   private OutputStream outToServer;
   private InputStream inFromServer;

   public TCPClient(Host host) {
      try {
         this.host = host;

         socket = new Socket(HostManager.getIP(host), HostManager.getPort(host));
      } catch (UnknownHostException ex) {
         Logger.getLogger(TCPClient.class.getName()).log(Level.SEVERE, null, ex);
      } catch (IOException ex) {
         Logger.getLogger(TCPClient.class.getName()).log(Level.SEVERE, null, ex);
      }
   }

   public void connect() {
      try {
         if (host == Host.BANK) {
            outToServer = new ObjectOutputStream(socket.getOutputStream());
            inFromServer = new DataInputStream(socket.getInputStream());

         } else {
            outToServer = new DataOutputStream(socket.getOutputStream());
            inFromServer = new ObjectInputStream(socket.getInputStream());
         }
      } catch (IOException ex) {
         Logger.getLogger(TCPClient.class.getName()).log(Level.SEVERE, null, ex);
      }

   }

   public void send(Object obj) {
      try {
         if (obj instanceof String) {

            ((DataOutputStream) outToServer).writeBytes((String) obj);

         } else if (obj instanceof Person) {
            ((ObjectOutputStream) outToServer).writeObject(obj);
         } else {
            return;
         }
      } catch (IOException ex) {
         Logger.getLogger(TCPClient.class.getName()).log(Level.SEVERE, null, ex);
      }
   }

   public Object receive() {
      if(this.host == Host.BANK) {
         BufferedReader reader = new BufferedReader(new InputStreamReader((DataInputStream) inFromServer));
         try {
            return reader.readLine();
         } catch (IOException ex) {
            Logger.getLogger(TCPClient.class.getName()).log(Level.SEVERE, null, ex);
         }
      } else {
         try {
            return (Person) ((ObjectInputStream) inFromServer).readObject();
         } catch (IOException ex) {
            Logger.getLogger(TCPClient.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
            Logger.getLogger(TCPClient.class.getName()).log(Level.SEVERE, null, ex);
         }
      }
      return null;
   }
}
