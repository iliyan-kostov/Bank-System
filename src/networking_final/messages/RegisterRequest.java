package networking_final.messages;

/**
 * A {@link Message} used by the client to request registering a profile in the
 * system. The user requests the creation of a specific pair of username and
 * password by providing first and last name.
 *
 * @author iliyan-kostov <iliyan.kostov.gml@gmail.com>
 */
public final class RegisterRequest extends Message {

    /**
     * Reference to the value of {@link Message#type} used by this class.
     */
    public static final String TYPE = "REGISTERREQUEST";

    /**
     * The username requested by the user.
     */
    private final String registerUsername;

    /**
     * The password requested by the user.
     */
    private final String registerPassword;

    /**
     * The first name provided by the user.
     */
    private final String firstName;

    /**
     * The last name provided by the user.
     */
    private final String lastName;

    /**
     * Constructor.
     *
     * @param registerUsername value for {@link #registerUsername}.
     *
     * @param registerPassword value for {@link #registerPassword}.
     *
     * @param firstName value for {@link #firstName}.
     *
     * @param lastName value for {@link #lastName}.
     */
    public RegisterRequest(String registerUsername, String registerPassword, String firstName, String lastName) {
        super(RegisterRequest.TYPE);
        this.registerUsername = registerUsername;
        this.registerPassword = registerPassword;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Returns the value of {@link #registerUsername}.
     *
     * @return the value of {@link #registerUsername}.
     */
    public final String getRegisterUsername() {
        return this.registerUsername;
    }

    /**
     * Returns the value of {@link #registerPassword}.
     *
     * @return the value of {@link #registerPassword}.
     */
    public final String getRegisterPassword() {
        return this.registerPassword;
    }

    /**
     * Returns the value of {@link #firstName}.
     *
     * @return the value of {@link #firstName}.
     */
    public final String getFirstName() {
        return this.firstName;
    }

    /**
     * Returns the value of {@link #lastName}.
     *
     * @return the value of {@link #lastName}.
     */
    public final String getLastName() {
        return this.lastName;
    }
}