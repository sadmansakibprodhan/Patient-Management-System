package com.company;

//Created by sadman sakib on 08/13/17.
     import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.awt.event.MouseAdapter;
        import java.awt.event.MouseEvent;
import java.sql.*;
public class MainFrame {
    JFrame frame;
    JLabel lb, lbuID, lbuPass;
    JButton login;
    JTextField txUserID;
    JPasswordField txUserPass;
    private Statement stmt = null;

    public MainFrame() {
        frame = new JFrame();

        frame.setSize(600, 400);
        frame.setTitle("Patient Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        lb = new JLabel("Patient Management System");
        lbuID = new JLabel("User ID: ");
        lbuPass = new JLabel("Password: ");

        txUserID = new JTextField();
        txUserPass = new JPasswordField();

        login = new JButton("Login");


        lb.setBounds(55, 35, 500, 60);
        lb.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        frame.add(lb);

        lbuID.setBounds(135, 145, 400, 60);
        lbuID.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        frame.add(lbuID);

        lbuPass.setBounds(112, 210, 400, 60);
        lbuPass.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        frame.add(lbuPass);


        txUserID.setBounds(235, 145, 180, 50);
        txUserID.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        frame.add(txUserID);
        txUserID.getSelectedTextColor();

        txUserPass.setBounds(235, 210, 180, 50);
        txUserPass.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        frame.add(txUserPass);

        login.setBounds(235, 285, 180, 50);
        login.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        frame.add(login);


        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection connection = null;
                String s = txUserID.getText();
                String p = new String(txUserPass.getPassword());

                System.out.println(s+" "+p);
                try{
                    connection = connectConfig.getConnection();

                    stmt = connection.createStatement();

                    String sql;
                    sql = "SELECT * FROM user WHERE usname = '"+s+"' and uspass = '"+p+"'";
                    System.out.println(sql);
                    ResultSet rs = stmt.executeQuery(sql);
                    System.out.println(rs);

                    //STEP 5: Extract data from result set
                    //if(rs.) {
                    int flag = 0;
                        while (rs.next()) {
                            flag = 1;
                            System.out.println("Database Connected");
                            System.out.println(rs.first());
                            new MenuFrame();
                            frame.setVisible(false);

                        }
                        if(flag == 0){
                            JOptionPane.showMessageDialog(null, "Wrong user name and password!!","", JOptionPane.ERROR_MESSAGE);
                        }
//                    }
//                    else
//                    {
//                        JOptionPane.showMessageDialog(null, "Wrong user name and password!!","", JOptionPane.ERROR_MESSAGE);
//                    }
                    rs.close();

                }catch (Exception ex){

                }
                finally {
                    try {

                        stmt.close();
                        connection.close();
                        System.out.println("connection closed");
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });


//        frame.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//
//                System.out.println("X: " + e.getX() + "Y: " + e.getY());
//
//            }
//        });

        frame.setLayout(null);
        frame.setVisible(true);

    }


}

