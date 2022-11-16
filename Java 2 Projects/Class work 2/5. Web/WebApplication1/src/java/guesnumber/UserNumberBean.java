package guesnumber;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Random;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;


@Named(value = "userNumberBean")
@SessionScoped

public class UserNumberBean implements Serializable {

    private Integer randomNumber;
    private Integer userNumber;
    
    public UserNumberBean() {
        randomNumber = new Random().nextInt(11);
        System.out.println("number = " + randomNumber);
    }

    public Integer getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(Integer userNumber) {
        this.userNumber = userNumber;
    }
    
    public String getResponse(){
        if((userNumber!=null) && (userNumber.equals(randomNumber))){
            ((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false)).invalidate();
            return "Good guess!";
        }
        return "Sorry, " + userNumber + " isn't it. Try again.";
    }
    
}
