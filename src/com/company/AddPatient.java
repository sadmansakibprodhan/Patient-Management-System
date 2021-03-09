package com.company;

//Created by sadman sakib on 08/13/17.

       import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.awt.event.MouseAdapter;
        import java.awt.event.MouseEvent;
        import java.sql.*;
public class AddPatient {
    private Statement stmt = null;
    private Connection connection = null;
    JFrame frame;
    JLabel lb, nameL, ageL, birthDateL, birthDL, birthML, birthYL, genderL, diseaseL, departmentL, tellNoL, roomNoL;
    JTextField name, tellNo;
    JRadioButton genderM, genderF;
    JCheckBox deapartmentPediatricians, deapartmentMedicine, deapartmentGynecology;
    JCheckBox diseaseFever, diseaseCough, diseaseEye;
    JComboBox birthDate, birthMonth, birthYear, age, roomNo;
    JButton save, clear, back;

    public AddPatient()
    {
        frame = new JFrame();

        frame.setSize(700,500);
        frame.setTitle("Patient Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        // label

        lb = new JLabel("Add Patient");
        nameL = new JLabel("Name");
        ageL = new JLabel("Age");
        roomNoL = new JLabel("Available Room");
//        birthDateL = new JLabel("Birth Date");
//        birthDL = new JLabel("D: ");
//        birthML = new JLabel("M: ");
//        birthYL = new JLabel("Y: ");
        genderL = new JLabel("Gender");
        diseaseL = new JLabel("Desease");
        departmentL = new JLabel("Department");
        tellNoL = new JLabel("Tele-phone: ");
        name = new JTextField();
        tellNo = new JTextField();

        age = new JComboBox();
//        birthDate = new JComboBox();
//        birthMonth = new JComboBox();
//        birthYear = new JComboBox();

        genderM = new JRadioButton("Male");
        genderF = new JRadioButton("Female");

        diseaseFever = new JCheckBox("Fever");
        diseaseCough = new JCheckBox("Cough");
        diseaseEye = new JCheckBox("Eye");

        deapartmentPediatricians = new JCheckBox("Pediatricians");
        deapartmentMedicine = new JCheckBox("Medicine");
        deapartmentGynecology = new JCheckBox("Gynecology");

        save = new JButton("Save");
        clear = new JButton("Clear");
        back = new JButton("Back");

        ButtonGroup bgroup = new ButtonGroup();
        bgroup.add(genderM);
        bgroup.add(genderF);

        // framing

        lb.setBounds(285,5,400,60);
        lb.setFont(new Font("Comic Sans MS", Font.ITALIC, 24));
        frame.add(lb);


        nameL.setBounds(10,65,180,20);
        nameL.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        frame.add(nameL);

        departmentL.setBounds(525,195,180,20);
        departmentL.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        frame.add(departmentL);

        tellNoL.setBounds(10,130,180,20);
        tellNoL.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        frame.add(tellNoL);

//        birthDateL.setBounds(10,195,180,20);
//        birthDateL.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
//        frame.add(birthDateL);
//
//        birthDL.setBounds(10,222,180,20);
//        birthDL.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
//        frame.add(birthDL);
//
//        birthML.setBounds(85,222,180,20);
//        birthML.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
//        frame.add(birthML);
//
//        birthYL.setBounds(160,222,180,20);
//        birthYL.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
//        frame.add(birthYL);

        genderL.setBounds(360,65,180,20);
        genderL.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        frame.add(genderL);

        ageL.setBounds(10,195,180,20);
        ageL.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        frame.add(ageL);

        roomNoL.setBounds(10,295,180,20);
        roomNoL.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        frame.add(roomNoL);

        diseaseL.setBounds(360,195,180,20);
        diseaseL.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        frame.add(diseaseL);





        // frame box
        name.setBounds(10,90,230,30);
        name.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        frame.add(name);

        tellNo.setBounds(10,155,230,30);
        tellNo.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        frame.add(tellNo);

        deapartmentPediatricians.setBounds(520,220,148,30);
        deapartmentPediatricians.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        frame.add(deapartmentPediatricians);

        deapartmentMedicine.setBounds(520,250,124,30);
        deapartmentMedicine.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        frame.add(deapartmentMedicine);

        deapartmentGynecology.setBounds(520,280,143,30);
        deapartmentGynecology.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        frame.add(deapartmentGynecology);

//        birthDate.setBounds(30,220,50,25);
//        birthDate.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
//        frame.add(birthDate);
//        for(int i = 1; i < 32; i++)
//            birthDate.addItem(i);
//
//        birthMonth.setBounds(107,220,50,25);
//        birthMonth.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
//        frame.add(birthMonth);
//        for(int i = 1; i <= 12; i++)
//            birthMonth.addItem(i);
//
//        birthYear.setBounds(178,220,80,25);
//        birthYear.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
//        frame.add(birthYear);
//        for(int i = 1975; i < 2050; i++)
//            birthYear.addItem(i);

        genderM.setBounds(355,90,100,30);
        genderM.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        frame.add(genderM);

        genderF.setBounds(455,90,230,30);
        genderF.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        frame.add(genderF);

        diseaseFever.setBounds(355,220,100,30);
        diseaseFever.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        frame.add(diseaseFever);

        diseaseCough.setBounds(355,250,105,30);
        diseaseCough.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        frame.add(diseaseCough);

        diseaseEye.setBounds(355,280,86,30);
        diseaseEye.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        frame.add(diseaseEye);

        age.setBounds(10,220,90,30);
        age.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        frame.add(age);
        for(int i = 1; i <= 150; i++)
            age.addItem(i);

        roomNo = new JComboBox();
        roomNo.setBounds(10,320,150,30);
        roomNo.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        frame.add(roomNo);
        try{
            connection = connectConfig.getConnection();

            stmt = connection.createStatement();

            String sql;
            sql = "SELECT * FROM room WHERE check_room = 0";
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println(rs);

            //STEP 5: Extract data from result set
            //if(rs.) {
            int flag = 0;
            while (rs.next()) {

                roomNo.addItem(rs.getString(1)+" - "+rs.getString(3)+" - "+rs.getString(2));

            }
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

        back.setBounds(195, 380, 80, 40);
        back.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        frame.add(back);

        save.setBounds(295, 380, 80, 40);
        save.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        frame.add(save);

        clear.setBounds(395, 380, 100, 40);
        clear.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
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

                name.setText(" ");
                tellNo.setText(" ");

                bgroup.clearSelection();

                age.setSelectedIndex(0);

                deapartmentPediatricians.setSelected(false);
                deapartmentMedicine.setSelected(false);
                deapartmentGynecology.setSelected(false);

                diseaseFever.setSelected(false);
                diseaseCough.setSelected(false);
                diseaseEye.setSelected(false);

            }
        });

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Connection connection = null;
                PreparedStatement pstmt;

                String p = name.getText();
                String q = tellNo.getText();
                String a = age.getSelectedItem().toString();

                String g = "";
                String d="";
                String dept = "";

                if(genderF.isSelected()){
                    g = genderF.getText().toString();
                }
                else if(genderM.isSelected()){
                    g = genderM.getText().toString();
                }

                if(diseaseFever.isSelected()){
                    d = d+" "+diseaseFever.getText().toString();
                }
                if(diseaseCough.isSelected()){
                    d = d+" "+diseaseCough.getText().toString();
                }
                if(diseaseEye.isSelected()){
                    d = d+" "+diseaseEye.getText().toString();
                }


                if(deapartmentPediatricians.isSelected()){
                    dept = dept+" "+deapartmentPediatricians.getText().toString();
                }
                if(deapartmentMedicine.isSelected()){
                    dept = dept+" "+deapartmentMedicine.getText().toString();
                }
                if(deapartmentGynecology.isSelected()){
                    dept = dept+" "+deapartmentGynecology.getText().toString();
                }

                System.out.println(g+" "+p+" "+q+" "+d+" "+dept+" "+a);

                try{
                    connection = connectConfig.getConnection();

                    String query = "insert patient (`name`, `telPhn`, `age`, `gender`, `deas`, `dept`)"+
                            "values (?, ?, ?, ?, ?, ?)";
                    // create the mysql insert preparedstatement
                    PreparedStatement preparedStmt = connection.prepareStatement(query);
                    preparedStmt.setString (1,p);
                    preparedStmt.setString (2, q);
                    preparedStmt.setString (3, a);
                    preparedStmt.setString (4, g);
                    preparedStmt.setString (5, d);
                    preparedStmt.setString (6, dept);

                    // execute the preparedstatement
                    preparedStmt.execute();


                    String roomnumber = roomNo.getSelectedItem().toString();
                    String room[] = roomnumber.split(" ");
                    //String qu = "UPDATE `room` SET `check_room`= 1 WHERE room = ";

                    // create the java mysql update preparedstatement
                    System.out.println(room[0]);

                    String que = "update room set check_room = 1 where id = '"+room[0]+"'";
                    PreparedStatement pStmt = connection.prepareStatement(que);
                    //pStmt.setInt (3, 1);

                    //pStmt.setString(2, "Fred");

                    // execute the java preparedstatement
                    pStmt.executeUpdate();
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


        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (name.getText().isEmpty()){
                        // throw new Exception ();
                        JOptionPane.showMessageDialog(null, "Enter Patient Name In TextField", "Invalid TextFields", JOptionPane.ERROR_MESSAGE);
                    }


                    if (name.getText()!=null) {
                        String str = name.getText();

                        for (int i = 0; i < str.length(); i++) {
                            if (str.charAt(i) == '1' || str.charAt(i) == '2' || str.charAt(i) == '3' ||
                                    str.charAt(i) == '4' || str.charAt(i) == '5' || str.charAt(i) == '6' ||
                                    str.charAt(i) == '7' || str.charAt(i) == '8' || str.charAt(i) == '9' ||
                                    str.charAt(i) == '0' || str.charAt(i) == '@' || str.charAt(i) == '*' ||
                                    str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '/' ||
                                    str.charAt(i) == '?' || str.charAt(i) == '#') {
                                throw new Exception();
                            }
                        }
                    }
                }
                catch (Exception e1){
                    name.setForeground(Color.red);
                    JOptionPane.showMessageDialog(null, "Enter Meaningful Name", "Wrong Input in TextFields", JOptionPane.ERROR_MESSAGE);
                    name.setText(" ");
                    name.setForeground(Color.black);
                }
                }
            });

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    if (tellNo.getText().isEmpty()){
                        // throw new Exception ();
                        JOptionPane.showMessageDialog(null, "Enter Tele-Phone Number In TextField", "Invalid TextFields", JOptionPane.ERROR_MESSAGE);
                    }

                    if (tellNo.getText()!=null) {
                        String str = tellNo.getText();

                        for (int i = 0; i < str.length(); i++) {
                            if (str.charAt(i) == 'a' || str.charAt(i) == 'b' || str.charAt(i) == 'c' ||
                                    str.charAt(i) == 'd' || str.charAt(i) == 'e' || str.charAt(i) == 'f' ||
                                    str.charAt(i) == 'g' || str.charAt(i) == 'h' || str.charAt(i) == 'i' ||
                                    str.charAt(i) == 'j' || str.charAt(i) == 'k' || str.charAt(i) == 'l' ||
                                    str.charAt(i) == 'm' || str.charAt(i) == 'n' || str.charAt(i) == 'o' ||
                                    str.charAt(i) == 'p' || str.charAt(i) == 'q' || str.charAt(i) == 'r' ||
                                    str.charAt(i) == 's' || str.charAt(i) == 't' || str.charAt(i) == 'u' ||
                                    str.charAt(i) == 'v' || str.charAt(i) == 'w' || str.charAt(i) == 'x' ||
                                    str.charAt(i) == 'y' || str.charAt(i) == 'z' ||

                                    str.charAt(i) == 'A' || str.charAt(i) == 'B' || str.charAt(i) == 'C' ||
                                    str.charAt(i) == 'D' || str.charAt(i) == 'E' || str.charAt(i) == 'F' ||
                                    str.charAt(i) == 'G' || str.charAt(i) == 'H' || str.charAt(i) == 'I' ||
                                    str.charAt(i) == 'J' || str.charAt(i) == 'K' || str.charAt(i) == 'L' ||
                                    str.charAt(i) == 'M' || str.charAt(i) == 'N' || str.charAt(i) == 'O' ||
                                    str.charAt(i) == 'P' || str.charAt(i) == 'Q' || str.charAt(i) == 'R' ||
                                    str.charAt(i) == 'S' || str.charAt(i) == 'T' || str.charAt(i) == 'U' ||
                                    str.charAt(i) == 'V' || str.charAt(i) == 'W' || str.charAt(i) == 'X' ||
                                    str.charAt(i) == 'Y' || str.charAt(i) == 'Z' || str.charAt(i) == '@' ||
                                    str.charAt(i) == '*' || str.charAt(i) == '+' || str.charAt(i) == '-' ||
                                    str.charAt(i) == '/' || str.charAt(i) == '?' || str.charAt(i) == '#') {
                                throw new Exception();
                            }
                        }
                    }
                }

                catch (Exception e1){
                    tellNo.setForeground(Color.red);
                    JOptionPane.showMessageDialog(null, "Enter Meaningful Tele-Phone Number", "Wrong Input in TextFields", JOptionPane.ERROR_MESSAGE);
                    tellNo.setText(" ");
                    tellNo.setForeground(Color.black);
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

