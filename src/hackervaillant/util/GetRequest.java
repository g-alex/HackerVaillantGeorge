/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hackervaillant.util;

/**
 *
 * @author indy
 */
public class GetRequest implements IParsedRequest {

    private String what;
    private String from;
    private String value;

    public String execute() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setFirst(String inTheButt) {
        what = inTheButt;
    }

    public void setSecond(String de) {
        from = de;
    }

    public void setThird(String valeur) {
        value = valeur;
    }
}
