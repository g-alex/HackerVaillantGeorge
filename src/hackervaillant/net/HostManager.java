/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hackervaillant.net;

import java.util.EnumMap;
import java.util.Map;

/**
 *
 * @author judu
 */
public class HostManager {

   public enum Host {

      BANK, PEOPLE;

   }
   private static Map<Host, String> hostIPs = new EnumMap<Host, String>(Host.class);

   private static Map<Host, Integer> tcpPorts = new EnumMap<Host, Integer>(Host.class);
   private static Map<Host, Integer> udpPorts = new EnumMap<Host, Integer>(Host.class);


   public static void addHost(Host host, String ip, Integer udport, Integer tcport) {
      hostIPs.put(host, ip);
      tcpPorts.put(host, tcport);
      udpPorts.put(host, udport);
   }

   public static String getIP(Host host) {
      return hostIPs.get(host);
   }

   public static Integer getTPort(Host host) {
      return tcpPorts.get(host);
   }

   public static Integer getUPort(Host host) {
      return udpPorts.get(host);
   }

}
