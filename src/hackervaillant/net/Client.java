package hackervaillant.net;

/**
 *
 * @author judu
 */
public interface Client {

   public enum Proto {
      TCP, UDP;
   }

   public void connect();
   public void send(Object obj);
   public Object receive();

}
