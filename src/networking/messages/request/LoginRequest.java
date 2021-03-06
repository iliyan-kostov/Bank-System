package networking.messages.request;

import networking.messages.Message;
import networking.messages.Request;

import java.io.Serializable;

/**
 * A {@link Request} used by the client to request access to the system by using
 * an already registered system profile. The user provides the pair of username
 * and password of the existing profile.
 *
 * @author iliyan-kostov <https://github.com/iliyan-kostov/>
 */
public final class LoginRequest extends Request implements Serializable {

    /**
     * Reference to the value of {@link Message#type} used by this class.
     */
    public static final String TYPE = "LOGINREQUEST";

    /**
     * The username provided by the user.
     */
    private final String loginUsername;

    /**
     * The password provided by the user.
     */
    private final String loginPassword;

    /**
     * Constructor.
     *
     * @param loginUsername the value for {@link #loginUsername}.
     *
     * @param loginPassword the value for {@link #loginPassword}.
     */
    public LoginRequest(String loginUsername, String loginPassword) {
        super(LoginRequest.TYPE);
        this.loginUsername = loginUsername;
        this.loginPassword = loginPassword;
    }

    /**
     * Returns the value of {@link #loginUsername}.
     *
     * @return the value of {@link #loginUsername}.
     */
    public final String getLoginUsername() {
        return this.loginUsername;
    }

    /**
     * Returns the value of {@link #loginPassword}.
     *
     * @return the value of {@link #loginPassword}.
     */
    public final String getLoginPassword() {
        return this.loginPassword;
    }

    @Override
    public String toString() {
        return (LoginRequest.TYPE + ":\n"
                + "-----------------\n"
                + "username: " + this.getUsername() + "\n"
                + "loginUsername: " + this.getLoginUsername() + "\n"
                + "loginPassword: " + this.getLoginPassword() + "\n"
                + "-----------------\n");
    }
}
