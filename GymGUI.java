// GymGUI.java
// Contains the GUI interface for the Gym Management System

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GymGUI {
    private JFrame frame;
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public GymGUI() {
        frame = new JFrame("Sakshyam's Gym GUI");
        frame.setSize(1000, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Home screen
        cardPanel.add(createHomePanel(), "Home");
        cardPanel.add(createRegularMemberPanel(), "Regular");
        cardPanel.add(createPremiumMemberPanel(), "Premium");

        frame.add(cardPanel);
        frame.setVisible(true);
    }

    private JPanel createHomePanel() {
        JPanel panel = new JPanel(new BorderLayout());

        // Sidebar
        JLabel title = new JLabel("<html><b>Alpha Gym<br>Management<br>System</b></html>");
        title.setHorizontalAlignment(JLabel.CENTER);
        JPanel sidebar = new JPanel();
        sidebar.setPreferredSize(new Dimension(200, 0));
        sidebar.add(title);
        panel.add(sidebar, BorderLayout.WEST);

        // Main area
        JPanel mainArea = new JPanel();
        mainArea.setBackground(new Color(180, 165, 220));
        mainArea.setLayout(new GridBagLayout());

        JLabel welcome = new JLabel("Welcome to the Admin's Portal !");
        welcome.setFont(new Font("Arial", Font.BOLD, 18));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2; gbc.insets = new Insets(20, 0, 20, 0);
        mainArea.add(welcome, gbc);

        JButton addRegularBtn = new JButton("Add a Regular Member");
        addRegularBtn.addActionListener(e -> cardLayout.show(cardPanel, "Regular"));
        gbc.gridy = 1; gbc.gridwidth = 1;
        mainArea.add(addRegularBtn, gbc);

        JButton addPremiumBtn = new JButton("Add a Premium Member");
        gbc.gridx = 1;
        addPremiumBtn.addActionListener(e -> cardLayout.show(cardPanel, "Premium"));
        mainArea.add(addPremiumBtn, gbc);

        panel.add(mainArea, BorderLayout.CENTER);
        return panel;
    }

    private JPanel createRegularMemberPanel() {
        return createMemberForm(false);
    }

    private JPanel createPremiumMemberPanel() {
        return createMemberForm(true);
    }

    private JPanel createMemberForm(boolean isPremium) {
        JPanel panel = new JPanel(new BorderLayout());

        // Sidebar
        JLabel title = new JLabel("<html><b>Alpha Gym<br>Management<br>System</b></html>");
        title.setHorizontalAlignment(JLabel.CENTER);
        JPanel sidebar = new JPanel();
        sidebar.setPreferredSize(new Dimension(200, 0));
        sidebar.add(title);
        panel.add(sidebar, BorderLayout.WEST);

        // Form
        JPanel form = new JPanel();
        form.setBackground(new Color(180, 165, 220));
        form.setLayout(new GridLayout(isPremium ? 13 : 12, 4, 10, 10));
        JTextField[] fields = new JTextField[12];
        String[] labels = {"ID", "Name", "Email", "DOB", "Membership Start Date", "Referral Source",
                           "Location", "Phone", "Paid Amount", "Plan", "Gender", "Personal Trainer's Name"};

        for (int i = 0; i < (isPremium ? 12 : 11); i++) {
            form.add(new JLabel(labels[i] + " : "));
            fields[i] = new JTextField();
            form.add(fields[i]);
        }

        // Gender radio buttons
        form.add(new JLabel("Gender : "));
        JPanel genderPanel = new JPanel();
        JRadioButton male = new JRadioButton("Male");
        JRadioButton female = new JRadioButton("Female");
        ButtonGroup bg = new ButtonGroup();
        bg.add(male); bg.add(female);
        genderPanel.add(male); genderPanel.add(female);
        form.add(genderPanel);

        // Buttons
        String[] btnLabels = {"Go Back", "Clear", "Display", "Revert Member", "Pay Due Amount",
                              "Save To File", "Read From File", "Mark Attendance", "Activate Membership",
                              "Deactivate Membership", "Calculate Discount", "Upgrade Plan"};

        JPanel btnPanel = new JPanel(new GridLayout(3, 4, 5, 5));
        for (String txt : btnLabels) {
            JButton b = new JButton(txt);
            if (txt.equals("Go Back")) {
                b.setBackground(Color.RED);
                b.addActionListener(e -> cardLayout.show(cardPanel, "Home"));
            } else {
                b.setBackground(new Color(255, 204, 51));
            }
            btnPanel.add(b);
        }

        panel.add(form, BorderLayout.CENTER);
        panel.add(btnPanel, BorderLayout.SOUTH);
        return panel;
    }

    public static void main(String[] args) {
        new GymGUI(); // Start the GUI
    }
}
