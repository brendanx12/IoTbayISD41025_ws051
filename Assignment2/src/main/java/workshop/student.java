package workshop;

/**
 *
 * @author Mushini
 */
public class student {
    private String name;
    private String email;
    private String password;
    private String DOB;

    public student(String name, String email, String password, String DOB) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.DOB = DOB;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    } 
}
