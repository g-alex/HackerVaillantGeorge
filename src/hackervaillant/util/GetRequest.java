/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hackervaillant.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import hackervaillant.net.HostManager.Host;
import hackervaillant.net.RequestException;
import hackervaillant.net.TCPClient;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author indy
 */
public class GetRequest implements IParsedRequest {

    private String what;
    private String from;
    private String value;

    public String execute() {
        Person p;
        String s=null;
        Gson gsonPerson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        try {
            if (from.equals("N")) {
                TCPClient client = new TCPClient(Host.PEOPLE);
                client.connect();
                client.send(value+"\n");
                p = (Person) client.receive();
                System.out.println(p);
                client.close();
            } else if (from.equals("P")) {
                p = gsonPerson.fromJson(value, Person.class);
            } else {
                throw new RequestException();
            }
            if (what.equals("CBN")) {
               System.out.println("get CBN from person : " + p);
                TCPClient client = new TCPClient(Host.BANK);
                client.connect();
                client.send(p);
                s = (String) client.receive();
                client.close();
            } else if (what.equals("P")) {
               System.out.println("tojson");
                s=gsonPerson.toJson(p);
            } else {
                throw new RequestException();
            }
        } catch (RequestException ex) {
            Logger.getLogger(GetRequest.class.getName()).log(Level.SEVERE, null, ex);
        }

        return s+"\n";
    }

    public void setFirst(String inTheButt) {
       System.out.println("inthebutt :-" + inTheButt + "-");
        what = inTheButt;
    }

    public void setSecond(String de) {
       System.out.println("de :-" + de+"-");
        from = de;
    }

    public void setThird(String valeur) {
       System.out.println("valeur :-" + valeur +"-");
        value = valeur;
    }
}
