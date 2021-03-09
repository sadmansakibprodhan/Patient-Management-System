//Created by sadman sakib on 08/13/17.


package com.company;
        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;


public class Bill
{
    JFrame frame;
    JLabel lb, patientId, roomType, roomNo, totalAmount;
    JTextField patientIdF, totalAmountF;
    JRadioButton roomTypeAc, roomTypeNonAc, roomTypeDeluxe;
    JComboBox roomNoF;
    JButton calculateBill, clear, back;

    public Bill()
    {

        frame = new JFrame();

        frame.setSize(600, 400);
        frame.setTitle("Patient Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        lb = new JLabel("Patient Bill");
        patientId = new JLabel("Patient ID");
        roomType = new JLabel("Room Type");
        roomNo = new JLabel("Room Number");
        totalAmount = new JLabel("Total Amount");

        patientIdF = new JTextField();
        roomTypeAc = new JRadioButton("AC");
        roomTypeNonAc = new JRadioButton("Non-AC");
        roomTypeDeluxe = new JRadioButton("Deluxe");

        roomNoF = new JComboBox();
        totalAmountF = new JTextField();

        calculateBill = new JButton("Calculate Bill");
        clear = new JButton("Clear");
        back = new JButton("Back");

        ButtonGroup bgroup = new ButtonGroup();
        bgroup.add(roomTypeAc);
        bgroup.add(roomTypeNonAc);
        bgroup.add(roomTypeDeluxe);

        // label

        lb.setBounds(240,5,400,60);
        lb.setFont(new Font("Comic Sans MS", Font.ITALIC, 24));
        frame.add(lb);

        patientId.setBounds(60,70,150,50);
        patientId.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        frame.add(patientId);

        roomNo.setBounds(60,120,150,50);
        roomNo.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        frame.add(roomNo);

        roomType.setBounds(435,70,150,50);
        roomType.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        frame.add(roomType);

        totalAmount.setBounds(55,220,150,50);
        totalAmount.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        frame.add(totalAmount);


        // label framing


        patientIdF.setBounds(190,80,180,30);
        patientIdF.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        frame.add(patientIdF);

        roomTypeAc.setBounds(435,120,180,30);
        roomTypeAc.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
        frame.add(roomTypeAc);

        roomTypeNonAc.setBounds(435,150,180,30);
        roomTypeNonAc.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
        frame.add(roomTypeNonAc);

        roomTypeDeluxe.setBounds(435,180,180,30);
        roomTypeDeluxe.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
        frame.add(roomTypeDeluxe);

        roomNoF.setBounds(190,130,80,30);
        roomNoF.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        frame.add(roomNoF);

        totalAmountF.setBounds(190,230,180,30);
        totalAmountF.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        frame.add(totalAmountF);



        calculateBill.setBounds(190, 180, 145, 30);
        calculateBill.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        frame.add(calculateBill);


        back.setBounds(185, 320, 100, 30);
        back.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        frame.add(back);

        clear.setBounds(300, 320, 100, 30);
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

                patientIdF.setText(" ");
                bgroup.clearSelection();
                //roomNoF.setSelectedIndex(0);

            }
        });

        calculateBill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    if (patientIdF.getText().isEmpty()){
                        // throw new Exception ();
                        JOptionPane.showMessageDialog(null, "Enter Patient Id In TextField", "Invalid TextFields", JOptionPane.ERROR_MESSAGE);
                    }


//                    if (patientIdF.getText()!=null) {
//                        String str = patientIdF.getText();
//
//                        for (int i = 0; i < str.length(); i++) {
//                            if (str.charAt(i) == '1' || str.charAt(i) == '2' || str.charAt(i) == '3' ||
//                                    str.charAt(i) == '4' || str.charAt(i) == '5' || str.charAt(i) == '6' ||
//                                    str.charAt(i) == '7' || str.charAt(i) == '8' || str.charAt(i) == '9' ||
//                                    str.charAt(i) == '0' || str.charAt(i) == '@' || str.charAt(i) == '*' ||
//                                    str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '/' ||
//                                    str.charAt(i) == '?' || str.charAt(i) == '#') {
//                                throw new Exception();
//                            }
//                        }
//                    }
                }
                catch (Exception e1){
                    patientIdF.setForeground(Color.red);
                    JOptionPane.showMessageDialog(null, "Enter Meaningful id", "Wrong Input in TextFields", JOptionPane.ERROR_MESSAGE);
                    patientIdF.setText(" ");
                    patientIdF.setForeground(Color.black);
                }
            }
        });


        calculateBill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

//                try {
//                    if (totalAmountF.getText().isEmpty()){
//                        // throw new Exception ();
//                        JOptionPane.showMessageDialog(null, "Enter Check-In Time In TextField", "Invalid TextFields", JOptionPane.ERROR_MESSAGE);
//                    }
//
//                    if (totalAmountF.getText()!=null) {
//                        String str = totalAmountF.getText();
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
//                                    str.charAt(i) == '/' || str.charAt(i) == '?' || str.charAt(i) == '#') {
//                                throw new Exception();
//                            }
//                        }
//                    }
//                }
//
//                catch (Exception e1){
//                    totalAmountF.setForeground(Color.red);
//                    JOptionPane.showMessageDialog(null, "Enter Meaningful Number Format", "Wrong Input in TextFields", JOptionPane.ERROR_MESSAGE);
//                    totalAmountF.setText(" ");
//                    totalAmountF.setForeground(Color.black);
//                }


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

