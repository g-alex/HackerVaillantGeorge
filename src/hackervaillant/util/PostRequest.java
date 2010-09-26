/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hackervaillant.util;

import hackervaillant.net.HostManager.Host;
import hackervaillant.net.UDPClient;

/**
 *
 * @author indy
 */
public class PostRequest implements IParsedRequest {

   private String cbn;

   private String n;

   private String p;

   public String execute() {

      //Bank
      StringBuilder bankBuilder = new StringBuilder();
      bankBuilder.append("CBN:").append(cbn).append('\n');
      bankBuilder.append("P:").append(p).append('\n');

      UDPClient bankClient = new UDPClient(Host.BANK);
      bankClient.send(bankBuilder.toString());

      //People
      StringBuilder peopleBuilder = new StringBuilder();
      peopleBuilder.append("N:").append(n).append('\n');
      peopleBuilder.append("P:").append(p).append('\n');

      UDPClient peopleClient = new UDPClient(Host.PEOPLE);
      peopleClient.send(peopleBuilder.toString());

      return "Done";
   }

   public void setFirst(String cb) {
      cbn = cb;
   }

   public void setSecond(String pseudal) {
      n = pseudal;
   }

   public void setThird(String person) {
      p = person;
   }
}
