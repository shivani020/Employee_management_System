package EMS;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener {

    Random ran = new Random(); // for generating random employee id (unique)
    int number = ran.nextInt(999999); // generating integer with 6 digits

    JTextField tfname, tffname, tfaddress, tfphone, tfaadhar, tfemail, tfsalary, tfdesignation;
    JDateChooser dcdob;
    JComboBox cbeducation;
    JLabel lblempID;
    JButton add, back;

    AddEmployee() {
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);

        JLabel heading = new JLabel("ADD EMPLOYEE DETAILS");
        heading.setBounds(260, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 30));
        heading.setForeground(Color.BLACK);
        add(heading);

        JLabel labelname = new JLabel("NAME");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);

        tfname = new JTextField();
        tfname.setBounds(190, 150, 150, 30);
        add(tfname);

        JLabel labelfname = new JLabel("FATHER's NAME");
        labelfname.setBounds(450, 150, 150, 30);
        labelfname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelfname);

        tffname = new JTextField();
        tffname.setBounds(650, 150, 150, 30);
        add(tffname);

        JLabel labeldob = new JLabel("DOB");
        labeldob.setBounds(50, 200, 150, 30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldob);

        dcdob = new JDateChooser();
        dcdob.setBounds(190, 200, 150, 30);
        add(dcdob);

        JLabel labelsalary = new JLabel("SALARY");
        labelsalary.setBounds(450, 200, 150, 30);
        labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelsalary);

        tfsalary = new JTextField();
        tfsalary.setBounds(650, 200, 150, 30);
        add(tfsalary);

        JLabel labeladdress = new JLabel("ADDRESS");
        labeladdress.setBounds(50, 250, 150, 30);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(190, 250, 150, 30);
        add(tfaddress);

        JLabel labelphone = new JLabel("PHONE");
        labelphone.setBounds(450, 250, 150, 30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphone);

        tfphone = new JTextField();
        tfphone.setBounds(650, 250, 150, 30);
        add(tfphone);

        JLabel labelemail = new JLabel("EMAIL");
        labelemail.setBounds(50, 300, 150, 30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelemail);

        tfemail = new JTextField();
        tfemail.setBounds(190, 300, 150, 30);
        add(tfemail);

        JLabel labeleducation = new JLabel("HIGHEST EDUCATION");
        labeleducation.setBounds(450, 300, 150, 30);
        labeleducation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeleducation);

        String courses[] = { "BBA", "BCA", "BA", "B.COM", "BTECH", "BSC", "MBA", "MCA", "MA", "M.COM", "MTECH", "MSC",
                "PHD" };
        cbeducation = new JComboBox(courses);
        cbeducation.setBackground(Color.WHITE);
        cbeducation.setBounds(650, 300, 150, 30);
        add(cbeducation);

        JLabel labeldesignation = new JLabel("DESIGNATION");
        labeldesignation.setBounds(50, 350, 150, 30);
        labeldesignation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldesignation);

        tfdesignation = new JTextField();
        tfdesignation.setBounds(190, 350, 150, 30);
        add(tfdesignation);

        JLabel labelaadhar = new JLabel("AADHAR NUMBER");
        labelaadhar.setBounds(450, 350, 150, 30);
        labelaadhar.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelaadhar);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(650, 350, 150, 30);
        add(tfaadhar);

        JLabel labelempID = new JLabel("EMPLOYEE ID");
        labelempID.setBounds(50, 400, 150, 30);
        labelempID.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempID);

        lblempID = new JLabel("" + number); // "" + number -> converting number into string
        lblempID.setBounds(190, 400, 150, 30);
        lblempID.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblempID);

        add = new JButton("Add Details");
        add.setBounds(250, 550, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);

        back = new JButton("BACK");
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);

        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == add) {

            String name = tfname.getText();
            String fname = tffname.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();// getText works on textfield
                                                                                         // only....
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = (String) cbeducation.getSelectedItem();
            // getselecteditem return an object so that it is typecasted in string....
            String designation = tfdesignation.getText();
            String aadhar = tfaadhar.getText();
            String empID = lblempID.getText();

            try {
                Conn conn = new Conn();
                String query = "insert into employee values('" + name + "','" + fname + "','" + dob + "','" + salary
                        + "','" + address + "','" + phone + "','" + email + "','" + education + "','" + designation
                        + "','" + aadhar + "','" + empID + "')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
