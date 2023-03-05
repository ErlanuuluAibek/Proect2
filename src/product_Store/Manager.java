package product_Store;

public class Manager {
    private String login;
    private String password;

    public Manager(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "product_Store.Manager: " +
                " login: " + login +
                " password: " + password;
    }
}
