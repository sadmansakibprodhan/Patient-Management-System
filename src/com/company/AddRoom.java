package com.company;

//Created by sadman sakib on 08/13/17.

        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.sql.*;

public class AddRoom {

    JFrame frame;
    JLabel lb, roomType, roomNo;
    JButton clear, addRoom, back;
    JComboBox numberOfRoomsC;
    JRadioButton nonAc, ac, deluxe;
    JTextField roomNoF;
    private Statement stmt;


    public AddRoom() {
        frame = new JFrame();

        frame.setSize(600, 400);
        frame.setTitle("Patient Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        lb = new JLabel("Add Room");
        roomNoF = new JTextField();
        //checkOutF = new JTextField();
        numberOfRoomsC = new JComboBox();
        roomType = new JLabel("Room Type");
        roomNo = new JLabel("Room No:");
        //checkOut = new JLabel("Check-Out");
        nonAc = new JRadioButton("Non-AC");
        ac = new JRadioButton("AC");
        deluxe = new JRadioButton("DeLuxe");
        clear = new JButton("Clear");
        back = new JButton("Back");
        addRoom = new JButton("Add Room");

        ButtonGroup bgroup = new ButtonGroup();
        bgroup.add(nonAc);
        bgroup.add(ac);
        bgroup.add(deluxe);

//      label

        lb.setBounds(237,5,400,60);
        lb.setFont(new Font("Comic Sans MS", Font.ITALIC, 24));
        frame.add(lb);

        roomType.setBounds(35,75,130,60);
        roomType.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        frame.add(roomType);

        roomNo.setBounds(100,180,130,60);
        roomNo.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        frame.add(roomNo);

//        checkOut.setBounds(400,180,130,60);
//        checkOut.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
//        frame.add(checkOut);


//      label framing

//        numberOfRoomsC.setBounds(430,125,90,40);
//        numberOfRoomsC.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
//        for(int i = 101; i <= 110; i++)
//            numberOfRoomsC.addItem(i);
//        frame.add(numberOfRoomsC);


        nonAc.setBounds(30,115,80,50);
        nonAc.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        frame.add(nonAc);

        ac.setBounds(130,115,80,50);
        ac.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        frame.add(ac);

        deluxe.setBounds(206,115,85,50);
        deluxe.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        frame.add(deluxe);

        roomNoF.setBounds(35,230,230,30);
        roomNoF.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        frame.add(roomNoF);

//        checkOutF.setBounds(335,230,230,30);
//        checkOutF.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
//        frame.add(checkOutF);

        back.setBounds(128, 320, 90, 30);
        back.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        frame.add(back);

        addRoom.setBounds(228, 320, 145, 30);
        addRoom.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        frame.add(addRoom);

        clear.setBounds(383, 320, 90, 30);
        clear.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        frame.add(clear);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                MenuFrame.frame.setVisible(true);
            }
        });

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(true);

                roomNoF.setText(" ");
//                checkOutF.setText(" ");

                bgroup.clearSelection();

            }
        });

        addRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//
//                try {
//                    if (roomNoF.getText().isEmpty()){
//                        // throw new Exception ();
//                        JOptionPane.showMessageDialog(null, "Enter Room No In TextField", "Invalid TextFields", JOptionPane.ERROR_MESSAGE);
//                    }
//
//                }
//
//                catch (Exception e1){
//                    roomNoF.setForeground(Color.red);
//                    JOptionPane.showMessageDialog(null, "Enter Meaningful Number Format", "Wrong Input in TextFields", JOptionPane.ERROR_MESSAGE);
//                    roomNoF.setText(" ");
//                    roomNoF.setForeground(Color.black);
//                }

                    Connection connection = null;
                    PreparedStatement pstmt;
                    String s = "";
                    if(ac.isSelected()){
                        s = ac.getText().toString();
                    }
                    else if(nonAc.isSelected()){
                        s = nonAc.getText().toString();
                    }
                    else if(deluxe.isSelected()){
                        s = deluxe.getText().toString();
                    }
                    String p = roomNoF.getText();

                    System.out.println(s+" "+p);
                    try{
                        connection = connectConfig.getConnection();

                        String query = " insert into room (`type`, `room`, `check_room`)"
                                + " values (?, ?, ?)";

                        // create the mysql insert preparedstatement
                        PreparedStatement preparedStmt = connection.prepareStatement(query);
                        preparedStmt.setString (1, s);
                        preparedStmt.setString (2, p);
                        preparedStmt.setString (3, "0");


                        // execute the preparedstatement
                        preparedStmt.execute();
                    }catch (Exception ex){

                    }
                    finally {
                        try {

                            //stmt.close();
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
//                System.out.println("X: " + e.getX() + " Y: " + e.getY());
//
//            }
//        });

        frame.setLayout(null);
        frame.setVisible(true);

    }
}

