/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hackervaillant.net;

import hackervaillant.util.Person;

/**
 *
 * @author judu
 */
public class Request {

   private HostManager.Host to;
   private Client.Proto proto;
   private String body;
   private Person person;

   public Request() {
   }


   public Request to(HostManager.Host host) {
         to = host;
         return this;
   }

   public Request proto(Client.Proto protocol) {
      this.proto = protocol;
      return this;
   }

   public Request body(String bo) {
      this.body = bo;
      return this;
   }

   public Request person(Person personne) {
      this.person = personne;
      return this;
   }

}
