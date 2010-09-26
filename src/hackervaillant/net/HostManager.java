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

   private static Map<Host, Integer> hostPorts = new EnumMap<Host, Integer>(Host.class);

   public static void addHost(Host host, String ip, Integer port) {
      hostIPs.put(host, ip);
      hostPorts.put(host, port);
   }

   public static String getIP(Host host) {
      return hostIPs.get(host);
   }

   public static Integer getPort(Host host) {
      return hostPorts.get(host);
   }
}
