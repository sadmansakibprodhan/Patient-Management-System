package com.company;
//Created by sadman sakib on 09/13/17.
        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.awt.event.MouseAdapter;
        import java.awt.event.MouseEvent;

public class MenuFrame {
    static JFrame frame;
    JLabel lb, patientDetailsL, roomDetailsL;
    JTextField patientDetails, roomDetails;
    JButton addPatient, disCharge, addRoom, bill, click, click1;

    public MenuFrame()
    {
        frame = new JFrame();

        frame.setSize(600,400);
        frame.setTitle("Patient Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        lb = new JLabel("Patient Management System");
        patientDetailsL = new JLabel("Search Patient Details");
        addPatient = new JButton("Add Patient");
        disCharge = new JButton("Discharged Patient");
        patientDetails = new JTextField();

        roomDetails = new JTextField();
        roomDetailsL = new JLabel("Search Room Details");
        addRoom = new JButton("Add Room");
        bill = new JButton("Bill");
        click = new JButton("Click");
        click1 = new JButton("Click");


        lb.setBounds(135,5,400,60);
        lb.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        frame.add(lb);


        addPatient.setBounds(35,94,200,50);
        addPatient.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        frame.add(addPatient);

        disCharge.setBounds(35,194,200,50);
        disCharge.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        frame.add(disCharge);

        addRoom.setBounds(35,294,200,50);
        addRoom.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        frame.add(addRoom);

        patientDetailsL.setBounds(320,60,220,50);
        patientDetailsL.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        frame.add(patientDetailsL);


        roomDetailsL.setBounds(320,160,220,50);
        roomDetailsL.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        frame.add(roomDetailsL);



        patientDetails.setBounds(320,100,180,40);
        patientDetails.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        frame.add(patientDetails);

        click.setBounds(515,105,65,30);
        click.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
        frame.add(click);

        roomDetails.setBounds(320,200,180,40);
        roomDetails.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        frame.add(roomDetails);

        click1.setBounds(515,205,65,30);
        click1.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
        frame.add(click1);

        bill.setBounds(345,294,130,50);
        bill.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        frame.add(bill);


        addPatient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new AddPatient();
            }
        });
        addRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new AddRoom();
            }
        });

        bill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new Bill();
            }
        });

        click.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    if (patientDetails.getText().isEmpty()){
                        // throw new Exception ();
                        JOptionPane.showMessageDialog(null, "Enter Patient Name In TextField", "Invalid TextFields", JOptionPane.ERROR_MESSAGE);
                    }


                    if (patientDetails.getText()!=null) {
                        String str = patientDetails.getText();

                        for (int i = 0; i < str.length(); i++) {
                            if (str.charAt(i) == '1' || str.charAt(i) == '2' || str.charAt(i) == '3' ||
                                    str.charAt(i) == '4' || str.charAt(i) == '5' || str.charAt(i) == '6' ||
                                    str.charAt(i) == '7' || str.charAt(i) == '8' || str.charAt(i) == '9' ||
                                    str.charAt(i) == '0' || str.charAt(i) == '@' || str.charAt(i) == '*' ||
                                    str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '/' ||
                                    str.charAt(i) == '#') {
                                throw new Exception();
                            }
                        }
                    }
                }
                catch (Exception e1){
                    patientDetails.setForeground(Color.red);
                    JOptionPane.showMessageDialog(null, "Enter Meaningful Name", "Wrong Input in TextFields", JOptionPane.ERROR_MESSAGE);
                    patientDetails.setText(" ");
                    patientDetails.setForeground(Color.black);
                }


            }
        });


        click1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    if (roomDetails.getText().isEmpty()){
                        // throw new Exception ();
                        JOptionPane.showMessageDialog(null, "Enter Room Number In TextField", "Invalid TextFields", JOptionPane.ERROR_MESSAGE);
                    }

//                    if (roomDetails.getText()!=null) {
//                        String str = roomDetails.getText();
//
//                        for (int i = 0; i < str.length(); i++) {
//                            if (str.charAt(i) == 'a' || str.charAt(i) == 'b' || str.charAt(i) == 'c' ||
//                                    str.charAt(i) == 'd' || str.charAt(i) == 'e' || str.charAt(i) == 'f' ||
//                                    str.charAt(i) == 'g' || str.charAt(i) == 'h' || str.charAt(i) == 'i' ||
//                                    str.charAt(i) == 'j' || str.charAt(i) == 'k' || str.charAt(i) == 'l' ||
//                                    str.charAt(i) == 'm' || str.charAt(i) == 'n' || str.charAt(i) == 'o' ||
//                                    str.charAt(i) == 'p' || str.charAt(i) == 'q' || str.charAt(i) == 'r' ||
//                                    str.charAt(i) == 's' || str.charAt(i) == 't' || str.charAt(i) == 'u' ||
//                                    str.charAt(i) == 'v' || str.charAt(i) == 'w' || str.charAt(i) == 'x' ||
//                                    str.charAt(i) == 'y' || str.charAt(i) == 'z' ||
//
//                                    str.charAt(i) == 'A' || str.charAt(i) == 'B' || str.charAt(i) == 'C' ||
//                                    str.charAt(i) == 'D' || str.charAt(i) == 'E' || str.charAt(i) == 'F' ||
//                                    str.charAt(i) == 'G' || str.charAt(i) == 'H' || str.charAt(i) == 'I' ||
//                                    str.charAt(i) == 'J' || str.charAt(i) == 'K' || str.charAt(i) == 'L' ||
//                                    str.charAt(i) == 'M' || str.charAt(i) == 'N' || str.charAt(i) == 'O' ||
//                                    str.charAt(i) == 'P' || str.charAt(i) == 'Q' || str.charAt(i) == 'R' ||
//                                    str.charAt(i) == 'S' || str.charAt(i) == 'T' || str.charAt(i) == 'U' ||
//                                    str.charAt(i) == 'V' || str.charAt(i) == 'W' || str.charAt(i) == 'X' ||
//                                    str.charAt(i) == 'Y' || str.charAt(i) == 'Z' || str.charAt(i) == '@' ||
//                                    str.charAt(i) == '*' || str.charAt(i) == '+' || str.charAt(i) == '-' ||
//                                    str.charAt(i) == '/' || str.charAt(i) == '#') {
//                                throw new Exception();
//                            }
//                        }
//                    }
                }

                catch (Exception e1){
                    roomDetails.setForeground(Color.red);
                    JOptionPane.showMessageDialog(null, "Enter Meaningful Number", "Wrong Input in TextFields", JOptionPane.ERROR_MESSAGE);
                    roomDetails.setText(" ");
                    roomDetails.setForeground(Color.black);
                }


            }
        });


//        frame.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//
//                System.out.println("X: "+e.getX()+"Y: "+e.getY());
//
//            }
//        });

        frame.setLayout(null);
        frame.setVisible(true);

    }
}
