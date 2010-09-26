/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hackervaillant.net;

import hackervaillant.util.GetRequest;
import hackervaillant.util.IParsedRequest;
import hackervaillant.util.PostRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author indy
 */
public class RequestParser {

    public static String parse(String request) throws RequestException {
        //TODO: parse and execute request
        try {
            BufferedReader bob = new BufferedReader(new StringReader(request));
            String line = bob.readLine();
            IParsedRequest parsedRequest;
            if (line.equals("GET")) {
                parsedRequest = new GetRequest();
            } else if (line.equals("POST")) {
                parsedRequest = new PostRequest();
            } else {
                throw new RequestException();
            }
            int i = 0;
            while ((line = bob.readLine()) != null) {
                switch (++i) {
                    case 1:
                        parsedRequest.setFirst(line.substring(line.indexOf(":") +1));
                        break;
                    case 2:
                        parsedRequest.setSecond(line.substring(line.indexOf(":") + 1));
                        break;
                    case 3:
                        parsedRequest.setThird(line.substring(line.indexOf(":") + 1));
                        break;
                }
            } // while
            return parsedRequest.execute();
        } catch (IOException ex) {
            Logger.getLogger(RequestParser.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } // catch
    }
}
