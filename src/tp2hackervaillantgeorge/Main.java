/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2hackervaillantgeorge;

import hackervaillant.net.RequestParser;

/**
 *
 * @author indy
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        RequestParser.parse("GET\n"
                + "what:P\n"
                + "from:N\n"
                + "value:Hippie");
    }
}
