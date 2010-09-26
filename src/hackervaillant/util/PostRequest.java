/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hackervaillant.util;

/**
 *
 * @author indy
 */
public class PostRequest implements IParsedRequest {

    private String cbn;
    private String n;
    private String p;

    public void execute() {
        throw new UnsupportedOperationException("Not supported yet.");
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
