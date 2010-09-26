/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hackervaillant.util;

import hackervaillant.net.RequestException;
import hackervaillant.net.RequestParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author indy
 */
public class ClientTCPHandler extends Thread {

    private Socket connectionSock;

    public ClientTCPHandler(Socket sock) {
        connectionSock = sock;
    }

    @Override
    public void run(){
        BufferedReader inFromClient = null;
	try {
	    String request;
	    inFromClient = new BufferedReader(new InputStreamReader(connectionSock.getInputStream()));
	    ObjectOutputStream outToClient = new ObjectOutputStream(connectionSock.getOutputStream());
	    request = inFromClient.readLine();
	    Logger.getAnonymousLogger().log(Level.INFO, request);outToClient.writeBytes(RequestParser.parse(request));
	} catch (RequestException ex) {
            Logger.getLogger(ClientTCPHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
	    Logger.getLogger(ClientTCPHandler.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
	    try {
		inFromClient.close();
	    } catch (IOException ex) {
		Logger.getLogger(ClientTCPHandler.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
    }
}
