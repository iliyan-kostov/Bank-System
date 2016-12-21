package networking_final.messages;

/**
 * A {@link Message} used by the client to request information about the balance
 * of the bank accounts owned by the user.
 *
 * @author iliyan-kostov <iliyan.kostov.gml@gmail.com>
 */
public final class BalanceRequest extends Message {

    /**
     * Reference to the value of {@link Message#type} used by this class.
     */
    public static final String TYPE = "BALANCEREQUEST";

    /**
     * Constructor.
     */
    public BalanceRequest() {
        super(BalanceRequest.TYPE);
    }
}