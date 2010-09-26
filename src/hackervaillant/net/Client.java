package hackervaillant.net;

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
