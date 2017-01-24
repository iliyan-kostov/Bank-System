
package client;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import networking.messageHandlers.MessageHandler;
import networking.messages.DisconnectNotice;
import networking.messages.Message;
import networking.messages.Update;
import networking.messages.request.BalanceRequest;
import networking.messages.request.TransactionHistoryRequest;

/**
 * @author Martin Draganov
 */
public class MainPanel extends JPanel implements MessageHandler {
	networking.connections.Client connection;
		
		private JPanel thisPanel;
	    private JPanel panelMain;
	    private JLabel helloUserLabel;
	    private JLabel helloLabel;
	    private JLabel label1;
	    private JLabel accessLabel;
	    private JButton createBankAccBtn;
	    private JButton balanceCheck;
	    private JButton changePassBtn;
	    private JButton depositBtn;
	    private JButton transferBtn;
	    private JButton transactionBtn;
	    private JButton withdrawBtn;
	    private JButton logoutBtn;
	    //private JButton backBtn;
	    private ClientDataUIHelper user;
	    
    public MainPanel(ClientDataUIHelper user, networking.connections.Client connection) {
    	this.user = user;
    	thisPanel = this;
        initComponents();
        this.connection = connection;
    }

    private void initComponents() {
        panelMain = new JPanel();
        helloUserLabel = new JLabel();
        helloLabel = new JLabel();
        label1 = new JLabel();
        accessLabel = new JLabel();
        createBankAccBtn = new JButton();
        balanceCheck = new JButton();
        changePassBtn = new JButton();
        depositBtn = new JButton();
        transferBtn = new JButton();
        transactionBtn = new JButton();
        withdrawBtn = new JButton();
        logoutBtn = new JButton();
        //backBtn = new JButton();

        //======== panel1 ========
        {

            this.setLayout(new CardLayout());

            //======== panelMain ========
            {

                //---- helloLabel ----
                helloLabel.setText("Hello");
                helloLabel.setHorizontalAlignment(SwingConstants.CENTER);
                
              //---- helloUserLabel ----
                helloUserLabel.setText(user.getUsername());
                helloUserLabel.setHorizontalAlignment(SwingConstants.CENTER);

                //---- label1 ----
                label1.setText("Access mode : ");

                //---- createBankAccBtn ----
                createBankAccBtn.setText("Create Account");
                createBankAccBtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						 add(new CreateAccPanel(user),"CreateAccPanel");
						 CardLayout cl = (CardLayout)(getLayout());
					     cl.show(thisPanel, "CreateAccPanel");
					        
						
					}
				});

                //---- balanceCheck ----
                balanceCheck.setText("Balance Info");
                balanceCheck.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							connection.send(new BalanceRequest());
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							//JOptionPane.showConfirmDialog(this, "Connection problem !");
							e1.printStackTrace();
						}
						JOptionPane.showConfirmDialog(panelMain, "Request send, wait a moment !");
						add(new BalancePanel(user),"BalancePanel");
						 CardLayout cl = (CardLayout)(getLayout());
					     cl.show(thisPanel, "BalancePanel");
					}
				});

                //---- changePassBtn ----
                changePassBtn.setText("Change Password");
                changePassBtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						add(new ChangePasswordPanel(user),"ChangePassPanel");
						 CardLayout cl = (CardLayout)(getLayout());
					     cl.show(thisPanel, "ChangePassPanel");
						
					}
				});

                //---- depositBtn ----
                depositBtn.setText("Deposit Money");
                depositBtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						add(new DepositPanel(user),"DepositPanel");
						 CardLayout cl = (CardLayout)(getLayout());
					     cl.show(thisPanel, "DepositPanel");
					}
				});

                //---- transferBtn ----
                transferBtn.setText("Transfer");
                transferBtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						add(new TransferPanel(user),"TransferPanel");
						 CardLayout cl = (CardLayout)(getLayout());
					     cl.show(thisPanel, "TransferPanel");
						
					}
				});
                
                transactionBtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							connection.send(new TransactionHistoryRequest());
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						JOptionPane.showConfirmDialog(panelMain, "Request send, wait a moment !");
						
					}
				});

                //---- transactionBtn ----
                transactionBtn.setText("Transaction History");
                transactionBtn.setHorizontalAlignment(SwingConstants.LEFT);
                transactionBtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						add(new TransactionHistoryPanel(user),"TransferPanel");
						 CardLayout cl = (CardLayout)(getLayout());
					     cl.show(thisPanel, "TransferPanel");
					}
				});

                //---- withdrawBtn ----
                withdrawBtn.setText("Withdraw");
                withdrawBtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						add(new WithdrawPanel(user),"WithdrawPanel");
						 CardLayout cl = (CardLayout)(getLayout());
					     cl.show(thisPanel, "WithdrawPanel");
					}
				});

                //---- logoutBtn ----
                logoutBtn.setText("Logout");
                logoutBtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						int choice = JOptionPane.showConfirmDialog((JButton)e.getSource(), "Are you sure you want to log out ???", "Logout", JOptionPane.YES_NO_OPTION);
						switch(choice){
						case JOptionPane.NO_OPTION :
							break;
						case JOptionPane.YES_OPTION:
							setVisible(false);
						}
						
					}
				});
                
              //---- backBtn ----
               // backBtn.setText("Back");

                GroupLayout panelMainLayout = new GroupLayout(panelMain);
                panelMain.setLayout(panelMainLayout);
                panelMainLayout.setHorizontalGroup(
                    panelMainLayout.createParallelGroup()
                        .addGroup(panelMainLayout.createSequentialGroup()
                            .addGap(29, 29, 29)
                            .addComponent(helloLabel, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(panelMainLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(transferBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(transactionBtn, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(helloUserLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(changePassBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(createBankAccBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(112, 112, 112)
                            .addGroup(panelMainLayout.createParallelGroup()
                                .addGroup(panelMainLayout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(accessLabel, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                                    .addGap(28, 28, 28))
                                .addGroup(panelMainLayout.createSequentialGroup()
                                    .addGroup(panelMainLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(balanceCheck, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(depositBtn)
                                        .addComponent(withdrawBtn, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(logoutBtn, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
//                        .addGroup(GroupLayout.Alignment.TRAILING, panelMainLayout.createSequentialGroup()
//                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                .addComponent(backBtn, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
//                                .addGap(192, 192, 192))
                );
                panelMainLayout.setVerticalGroup(
                    panelMainLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panelMainLayout.createSequentialGroup()
                            .addGroup(panelMainLayout.createParallelGroup()
                                .addGroup(panelMainLayout.createSequentialGroup()
                                    .addGap(21, 21, 21)
                                    .addGroup(panelMainLayout.createParallelGroup()
                                        .addComponent(helloUserLabel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(helloLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(label1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(accessLabel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(61, 61, 61)
                                    .addGroup(panelMainLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(balanceCheck)
                                        .addComponent(createBankAccBtn))
                                    .addGap(27, 27, 27)
                                    .addGroup(panelMainLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(depositBtn)
                                        .addComponent(changePassBtn))
                                    .addGap(37, 37, 37)
                                    .addComponent(transferBtn))
                                .addGroup(panelMainLayout.createSequentialGroup()
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(withdrawBtn)))
                            .addGap(31, 31, 31)
                            .addGroup(panelMainLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(transactionBtn)
                                .addComponent(logoutBtn))
                            .addGap(50, 100, 200))
//                            .addComponent(backBtn)
//                            .addGap(30, 30, 30))
                );
            }
            this.add(panelMain, "card1");
        }
       
    }

    /**
     * Handling responses from server
     */
	@Override
	public Message handle(Message message) {
		switch(message.getType()){
		case DisconnectNotice.TYPE:
			handleDisconnect();
			break;
		case Update.TYPE:
			handleUpdate((Update)message);
		}
		return null;
	}
	
	public synchronized void handleDisconnect(){
		JOptionPane.showMessageDialog(getParent(), "Disconnected from server !");
		System.exit(1);
	}
	public synchronized void handleUpdate(Update message){
		if(message.getProflieData() != null){
			this.user = (ClientDataUIHelper)message.getProflieData();
			
			
		}
	}
}
