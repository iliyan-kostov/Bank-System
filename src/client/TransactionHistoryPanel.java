package client;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Martin Draganov
 */
public class TransactionHistoryPanel extends JPanel {

    // референция към най-горното ниво (обекта - родител) с данните от сървъра:
    public final BankSystemUI parent;

    private JScrollPane scrollPane1;
    private JTable transactionTable;
    private JButton backBtn;
    private ClientDataUIHelper user;

    public TransactionHistoryPanel(ClientDataUIHelper user, BankSystemUI parent) {

        // референция към най-горното ниво (обекта - родител) с данните от сървъра:
        this.parent = parent;

        this.user = user;
        initComponents();
    }

    private void initComponents() {

        scrollPane1 = new JScrollPane();
        transactionTable = new JTable();
        backBtn = new JButton();

        //======== scrollPane1 ========
        {
            JPanel display_data = new JPanel(new BorderLayout());

            // свързване към контейнера от най-горно ниво - постоянен с актуални данни:
            display_data.add(parent.scrollpane_History, BorderLayout.CENTER);

            scrollPane1.setViewportView(display_data);
        }

        //---- transactionTable ----
        this.transactionTable = user.getTransferHistoryTable();

        //---- backBtn ----
        backBtn.setText("Back");
        backBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) getParent().getParent().getLayout(); 	//first parent is the current panel holding the button, we want the main panel
                setVisible(false);
                cl.show(getParent().getParent(), "mainCard");

            }
        });

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(32, Short.MAX_VALUE)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(backBtn, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(211, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(backBtn)
                        .addContainerGap(20, Short.MAX_VALUE))
        );
    }

}
