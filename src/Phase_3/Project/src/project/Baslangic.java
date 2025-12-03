package Phase_3.Project.src.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Baslangic {
    public static void main(String[] args) {	
        // JFrame oluşturuluyor
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(400, 400, 1130, 756);

        // JPanel oluşturuluyor
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.YELLOW); 
                g.fillRect(0, 0, getWidth(), getHeight()); 
            }
        };
       

        frame.getContentPane().add(panel);
        panel.setLayout(null);
        panel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("COMPUTER STORE INVENTORY MANAGMENT SYSTEM", SwingConstants.CENTER);
        lblNewLabel.setBounds(-10, -150, 1118, 721);
        lblNewLabel.setForeground(new Color(0, 0, 153));
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));

        JLabel lblNewLabel_1 = new JLabel("",SwingConstants.CENTER);
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\LENOVO\\eclipse-workspace\\Phase_2\\src\\Phase_3\\Project\\src\\project\\İmages\\4854186.png"));
        
        lblNewLabel_1.setBounds(239, 188, 600, 448);
       
        panel.add(lblNewLabel_1, BorderLayout.CENTER);
        panel.add(lblNewLabel, BorderLayout.NORTH);
        panel.add(lblNewLabel);
        
        panel.add(lblNewLabel_1);
        
        JButton btnNewButton = new JButton("HOMEPAGE");
        btnNewButton.setForeground(new Color(0, 0, 153));
        btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 17));
        btnNewButton.setBounds(449, 647, 195, 41);
        btnNewButton.addActionListener(e -> {
            ComputerStoreGUI computerStoreGUI = new ComputerStoreGUI();
            computerStoreGUI.show();
        });
       
        panel.add(btnNewButton);
        
        
  
        frame.setVisible(true);
    }
 
    
}