
package deneme;
import java.sql.*;
import java.sql.Connection;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import deneme.MainScreen;

public class LoginScreen extends JFrame {
    private JTextField usernameField;
    private  JPasswordField passwordField;
    

    public LoginScreen() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 350);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                Color backgroundColor = new Color(22, 22, 22); // Set the background color to RGB(22, 22, 22)
                g2d.setColor(backgroundColor);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Görsel için JLabel oluştur
        ImageIcon logoIcon = new ImageIcon("path/to/your/image.jpg");
        JLabel logoLabel = new JLabel(logoIcon);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setForeground(Color.WHITE); // Set the username label color to white
        usernameField = new JTextField(20);
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.WHITE); // Set the password label color to white
        passwordField = new JPasswordField(20);

        JButton loginButton = new JButton("Login");

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(logoLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(usernameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(loginButton, gbc);

        add(panel);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (username.equals("admin") && password.equals("12345")) {
                    JOptionPane.showMessageDialog(LoginScreen.this, "Welcome " + username);
                    Timer timer = new Timer(500, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                     
                            dispose();
                            openMainScreen();
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                } else {
                    JOptionPane.showMessageDialog(LoginScreen.this, "Login Failed. Invalid username or password.");
                }
            }
        });
    }

    private void openMainScreen() {
        MainScreen mainScreen = new MainScreen();
        mainScreen.setVisible(true);
    }

    public static void main(String[] args) {
        String url= "jdbc:mysql://localhost:3306/cmpe";
        String username="root";
        String password="AHMETefe2003";
        try{ 
          Class.forName("com.mysql.cj.jdbc.Driver");
           Connection connection = DriverManager.getConnection(url,username,password);
           Statement statement = connection.createStatement(); 
        }catch(Exception e){
        System.out.println(e);
    }
        
        
        
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LoginScreen loginScreen = new LoginScreen();
                loginScreen.setVisible(true);
            }
        });
    }
}
