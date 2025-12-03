package Phase_3.Project.src.project;
import java.awt.Color;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ComputerStoreGUI {

	private JFrame frame;
	String url = "jdbc:sqlite:Project_inventory.db"; 
	 Connection conn ;
	 Statement statement ;
	 ResultSet rs ;  
	 DatabaseMetaData meta ;
	 String tableName = "PRODUCT";
	
    private JTextField textField_11;
    private JTextField textField_12;
    private JTextField textField_13;
    private JTextField textField_14;
    private JTextField textField_15;
    private JTextField textField_16;
    private JTextField textField_17;
    private JTextField textField_18;
    private JTextField textField_19;
    private JTextField textField_20;
    private JTextField textField_21;
    private JTextField textField_22;
    private JTextField textField_23;
    private JTextField textField_24;
    private JTextField textField_25;
    private JTextField textField_26;
    private JTextField textField_27;
    private JTextField textField_28;
    private JTextField textField_29;
    private JTextField textField_30;
    private JTextField textField_31;
    private JTextField textField_32;
    private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComputerStoreGUI window = new ComputerStoreGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ComputerStoreGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(400, 400, 1130, 756);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.YELLOW);
		JLabel lblNewLabel = new JLabel("Product");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblNewLabel.setToolTipText("");
		lblNewLabel.setBounds(54, 59, 103, 43);
		frame.getContentPane().add(lblNewLabel);
		
		 try {
             conn = DriverManager.getConnection(url);
             statement = conn.createStatement();
	         statement.setQueryTimeout(30);  
	         meta = conn.getMetaData(); 
	         
	         rs = meta.getTables(null, null, tableName, null); 
			    if (rs.next()) { System.out.println("Table " + tableName + " exists.\r\n"); }
		       	else { 
		        
		          
		       		System.out.println("Table " + tableName + " does not exist.\r\n"); 
		             		 
		          		 
		          		statement.executeUpdate("CREATE TABLE PRODUCT (product_id integer PRIMARY KEY,  name varchar(40), category varchar(40), price int, stock_quantity int)");
		          		statement.executeUpdate("CREATE TABLE CUSTOMER (customer_id int NOT NULL, name text NOT NULL, email text NOT NULL,phone_number int)");
		           		statement.executeUpdate("CREATE TABLE SUPPLİER (supplier_id int NOT NULL, name text NOT NULL, contact_info text NOT NULL)");
		           		statement.executeUpdate("CREATE TABLE ORDER_TABLE (order_id int NOT NULL, customer_id int NOT NULL, order_date int, total_amount int NOT NULL)");
		           		statement.executeUpdate("CREATE TABLE ORDER_DETAIL (order_detail_id int NOT NULL, order_id int NOT NULL, product_id int NOT NULL, quantity int NOT NULL, subtotal int NOT NULL)");
		       	}
	      
         } catch (SQLException e) {
             System.out.println("Connection failed: " + e.getMessage());
         }
		
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 10));
		lblNewLabel_1.setBounds(54, 123, 45, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name:");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 10));
		lblNewLabel_2.setBounds(51, 146, 60, 40);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Category:");
		lblNewLabel_3.setFont(new Font("Arial Black", Font.BOLD, 10));
		lblNewLabel_3.setBounds(51, 196, 69, 13);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Price:");
		lblNewLabel_4.setFont(new Font("Arial Black", Font.BOLD, 10));
		lblNewLabel_4.setBounds(51, 233, 45, 13);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField_11 = new JTextField();
		textField_11.setBounds(150, 123, 96, 19);
		frame.getContentPane().add(textField_11);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(150, 160, 96, 19);
		frame.getContentPane().add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(150, 196, 96, 19);
		frame.getContentPane().add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(150, 233, 96, 19);
		frame.getContentPane().add(textField_14);
		
		JLabel lblNewLabel_5 = new JLabel("Stock Quantity:");
		lblNewLabel_5.setFont(new Font("Arial Black", Font.BOLD, 10));
		lblNewLabel_5.setBounds(51, 272, 96, 13);
		frame.getContentPane().add(lblNewLabel_5);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(150, 269, 96, 19);
		frame.getContentPane().add(textField_15);
		
		JButton btnNewButton = new JButton("SAVE or UPDATE");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int match=0;
				try {
					String query2= "select * from product where product_id =" + textField_11.getText();
					 rs = statement.executeQuery(query2); 
				        while(rs.next()) {
				        	match=1;
				        }
				        
				        if (match==0) {
				        	String query="INSERT INTO PRODUCT VALUES("+textField_11.getText()+",'"+textField_12.getText()+"','"+textField_13.getText()+"',"+textField_14.getText()+","+textField_15.getText()+")";
				        	statement.executeUpdate(query);
				        	JOptionPane.showMessageDialog(null, 
				                    "New Product record added successfully.", 
				                    "Success", 
				                    JOptionPane.INFORMATION_MESSAGE);
				        	
						}else {
							if(textField_12.getText().compareTo("")!=0){
								String query="update product set name='"+textField_12.getText()+"' where product_id="+textField_11.getText();
								statement.executeUpdate(query); 
							}if(textField_13.getText().compareTo("")!=0){
								String query="update product set category='"+textField_13.getText()+"' where product_id="+textField_11.getText();
								statement.executeUpdate(query);
							}if(textField_14.getText().compareTo("")!=0){
								String query="update product set price='"+textField_14.getText()+"' where product_id="+textField_11.getText();
								statement.executeUpdate(query);
							}if(textField_15.getText().compareTo("")!=0){
								String query="update product set stock_quantity='"+textField_15.getText()+"' where product_id="+textField_11.getText();
								statement.executeUpdate(query);
							}
						}
				        
				} catch (SQLException el) {
					JOptionPane.showMessageDialog(null, 
			                "Connection failed: " + el.getMessage(), 
			                "Database Error", 
			                JOptionPane.ERROR_MESSAGE);
		         }
				
				
			
		
			}});
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnNewButton.setBounds(54, 317, 164, 21);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblCustomer = new JLabel("Customer");
		lblCustomer.setToolTipText("");
		lblCustomer.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblCustomer.setBounds(295, 59, 103, 43);
		frame.getContentPane().add(lblCustomer);
		
		JLabel lblNewLabel_1_1 = new JLabel("ID:");
		lblNewLabel_1_1.setFont(new Font("Arial Black", Font.BOLD, 10));
		lblNewLabel_1_1.setBounds(298, 123, 45, 13);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Name:");
		lblNewLabel_2_1.setFont(new Font("Arial Black", Font.BOLD, 10));
		lblNewLabel_2_1.setBounds(295, 146, 60, 40);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(344, 123, 96, 19);
		frame.getContentPane().add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(344, 160, 96, 19);
		frame.getContentPane().add(textField_17);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Email: ");
		lblNewLabel_2_1_1.setFont(new Font("Arial Black", Font.BOLD, 10));
		lblNewLabel_2_1_1.setBounds(295, 185, 60, 40);
		frame.getContentPane().add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Phone:");
		lblNewLabel_2_1_2.setFont(new Font("Arial Black", Font.BOLD, 10));
		lblNewLabel_2_1_2.setBounds(295, 219, 60, 40);
		frame.getContentPane().add(lblNewLabel_2_1_2);
		
		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setBounds(344, 196, 96, 19);
		frame.getContentPane().add(textField_18);
		
		textField_19 = new JTextField();
		textField_19.setColumns(10);
		textField_19.setBounds(344, 233, 96, 19);
		frame.getContentPane().add(textField_19);
		
		JButton btnNewButton_1 = new JButton("SAVE or UPDATE");
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int match=0;
				try {
					String query3= "select * from customer where customer_id =" + textField_16.getText();
					 rs = statement.executeQuery(query3); 
				        while(rs.next()) {
				        	match=1;
				        }
				        
				        if (match==0) {
				        	String query="INSERT INTO CUSTOMER VALUES("+textField_16.getText()+",'"+textField_17.getText()+"','"+textField_18.getText()+"',"+textField_19.getText()+")";
				        	statement.executeUpdate(query);
				        	JOptionPane.showMessageDialog(null, 
				                    "New Customer record added successfully.", 
				                    "Success", 
				                    JOptionPane.INFORMATION_MESSAGE);
						}else {
							if(textField_17.getText().compareTo("")!=0){
								String query="update customer set name='"+textField_17.getText()+"' where customer_id="+textField_16.getText();
								statement.executeUpdate(query); 
							}if(textField_18.getText().compareTo("")!=0){
								String query="update customer set email='"+textField_18.getText()+"' where customer_id="+textField_16.getText();
								statement.executeUpdate(query);
							}if(textField_19.getText().compareTo("")!=0){
								String query="update customer set phone_number='"+textField_19.getText()+"' where customer_id="+textField_16.getText();
								statement.executeUpdate(query);
							}
						}
				        
				} catch (SQLException e3) {
					JOptionPane.showMessageDialog(null, 
			                "Connection failed: " + e3.getMessage(), 
			                "Database Error", 
			                JOptionPane.ERROR_MESSAGE);
		         }
				
		
			}});
		btnNewButton_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnNewButton_1.setBounds(285, 317, 155, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblComputer = new JLabel("CRUD PROCESS");
		lblComputer.setForeground(new Color(0, 0, 204));
		lblComputer.setToolTipText("");
		lblComputer.setFont(new Font("Arial Black", Font.BOLD, 17));
		lblComputer.setBounds(525, 5, 385, 43);
		frame.getContentPane().add(lblComputer);
		
		JLabel lblSupplier = new JLabel("Supplier");
		lblSupplier.setToolTipText("");
		lblSupplier.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblSupplier.setBounds(485, 59, 103, 43);
		frame.getContentPane().add(lblSupplier);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("ID:");
		lblNewLabel_1_1_1.setFont(new Font("Arial Black", Font.BOLD, 10));
		lblNewLabel_1_1_1.setBounds(485, 126, 45, 13);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_2_1_3 = new JLabel("Name:");
		lblNewLabel_2_1_3.setFont(new Font("Arial Black", Font.BOLD, 10));
		lblNewLabel_2_1_3.setBounds(485, 142, 60, 40);
		frame.getContentPane().add(lblNewLabel_2_1_3);
		
		textField_20 = new JTextField();
		textField_20.setColumns(10);
		textField_20.setBounds(544, 123, 96, 19);
		frame.getContentPane().add(textField_20);
		
		textField_21 = new JTextField();
		textField_21.setColumns(10);
		textField_21.setBounds(544, 160, 96, 19);
		frame.getContentPane().add(textField_21);
		
		JLabel lblNewLabel_2_1_3_1 = new JLabel("Contact:");
		lblNewLabel_2_1_3_1.setFont(new Font("Arial Black", Font.BOLD, 10));
		lblNewLabel_2_1_3_1.setBounds(485, 185, 60, 40);
		frame.getContentPane().add(lblNewLabel_2_1_3_1);
		
		textField_22 = new JTextField();
		textField_22.setColumns(10);
		textField_22.setBounds(544, 196, 96, 19);
		frame.getContentPane().add(textField_22);
		
		JLabel lblOrder = new JLabel("Order");
		lblOrder.setToolTipText("");
		lblOrder.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblOrder.setBounds(674, 59, 103, 43);
		frame.getContentPane().add(lblOrder);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Order ID:");
		lblNewLabel_1_1_1_1.setFont(new Font("Arial Black", Font.BOLD, 10));
		lblNewLabel_1_1_1_1.setBounds(674, 126, 60, 13);
		frame.getContentPane().add(lblNewLabel_1_1_1_1);
		
		textField_23 = new JTextField();
		textField_23.setColumns(10);
		textField_23.setBounds(777, 123, 96, 19);
		frame.getContentPane().add(textField_23);
		
		JLabel lblNewLabel_2_1_3_2 = new JLabel("Customer ID:");
		lblNewLabel_2_1_3_2.setFont(new Font("Arial Black", Font.BOLD, 10));
		lblNewLabel_2_1_3_2.setBounds(674, 142, 85, 40);
		frame.getContentPane().add(lblNewLabel_2_1_3_2);
		
		textField_24 = new JTextField();
		textField_24.setColumns(10);
		textField_24.setBounds(777, 160, 96, 19);
		frame.getContentPane().add(textField_24);
		
		JLabel lblNewLabel_2_1_3_1_1 = new JLabel("Date:");
		lblNewLabel_2_1_3_1_1.setFont(new Font("Arial Black", Font.BOLD, 10));
		lblNewLabel_2_1_3_1_1.setBounds(674, 185, 60, 40);
		frame.getContentPane().add(lblNewLabel_2_1_3_1_1);
		
		textField_25 = new JTextField();
		textField_25.setColumns(10);
		textField_25.setBounds(777, 196, 96, 19);
		frame.getContentPane().add(textField_25);
		
		JLabel lblNewLabel_2_1_3_1_1_1 = new JLabel("Amount:");
		lblNewLabel_2_1_3_1_1_1.setFont(new Font("Arial Black", Font.BOLD, 10));
		lblNewLabel_2_1_3_1_1_1.setBounds(674, 219, 60, 40);
		frame.getContentPane().add(lblNewLabel_2_1_3_1_1_1);
		
		textField_26 = new JTextField();
		textField_26.setColumns(10);
		textField_26.setBounds(777, 230, 96, 19);
		frame.getContentPane().add(textField_26);
		
		JButton btnNewButton_1_1 = new JButton("SAVE or UPDATE");

		btnNewButton_1_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int match = 0;
		        try {
		            
		            String queryCheck = "SELECT * FROM SUPPLİER WHERE supplier_id = " + textField_20.getText();
		            rs = statement.executeQuery(queryCheck); 
		            while (rs.next()) {
		                match = 1; 
		            }
		            
		            if (match == 0) {
		                
		                String queryInsert = "INSERT INTO SUPPLİER VALUES(" +
		                                     textField_20.getText() + ", '" +
		                                     textField_21.getText() + "', '" +
		                                     textField_22.getText() + "')";
		                statement.executeUpdate(queryInsert);
		                JOptionPane.showMessageDialog(null, 
			                    "New Supplier record added successfully.", 
			                    "Success", 
			                    JOptionPane.INFORMATION_MESSAGE);
		               
		            } else {
		                
		                if (textField_21.getText().compareTo("") != 0) {
		                    String queryUpdateName = "UPDATE SUPPLİER SET name = '" + textField_21.getText() + 
		                                             "' WHERE supplier_id = " + textField_20.getText();
		                    statement.executeUpdate(queryUpdateName);
		                }
		                if (textField_22.getText().compareTo("") != 0) {
		                    String queryUpdateContact = "UPDATE SUPPLİER SET contact_info = '" + textField_22.getText() + 
		                                                "' WHERE supplier_id = " + textField_20.getText();
		                    statement.executeUpdate(queryUpdateContact);
		                }
		                System.out.println("Supplier record updated successfully.");
		            }
		        } catch (SQLException e2) {
		        	JOptionPane.showMessageDialog(null, 
			                "Connection failed: " + e2.getMessage(), 
			                "Database Error", 
			                JOptionPane.ERROR_MESSAGE);
		        }
		    }
		});

		btnNewButton_1_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnNewButton_1_1.setBounds(485, 317, 155, 21);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("SAVE or UPDATE");

		btnNewButton_1_2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int match = 0; 
		        int customerExists = 0; 
		        
		        try {
		            
		            String queryCheckCustomer = "SELECT * FROM CUSTOMER WHERE customer_id = " + textField_24.getText();
		            rs = statement.executeQuery(queryCheckCustomer);
		            while (rs.next()) {
		                customerExists = 1; 
		            }

		            if (customerExists == 0) {
		               
		                JOptionPane.showMessageDialog(null, 
		                    "Error: The provided customer_id does not exist. Please provide a valid customer_id.", 
		                    "Invalid Customer ID", 
		                    JOptionPane.ERROR_MESSAGE);
		                return; 
		            }

		            
		            String queryCheckOrder = "SELECT * FROM ORDER_TABLE WHERE order_id = " + textField_23.getText();
		            rs = statement.executeQuery(queryCheckOrder);
		            while (rs.next()) {
		                match = 1; 
		            }

		            if (match == 0) {
		                
		                String queryInsert = "INSERT INTO ORDER_TABLE VALUES(" +
		                                     textField_23.getText() + ", " +
		                                     textField_24.getText() + ", '" +
		                                     textField_25.getText() + "', " +
		                                     textField_26.getText() + ")";
		                statement.executeUpdate(queryInsert);
		                JOptionPane.showMessageDialog(null, 
		                    "New order record added successfully.", 
		                    "Success", 
		                    JOptionPane.INFORMATION_MESSAGE);
		            } else {
		                
		                if (textField_24.getText().compareTo("") != 0) {
		                    String queryUpdateCustomerId = "UPDATE ORDER_TABLE SET customer_id = " + textField_24.getText() + 
		                                                   " WHERE order_id = " + textField_23.getText();
		                    statement.executeUpdate(queryUpdateCustomerId);
		                }
		                if (textField_25.getText().compareTo("") != 0) {
		                    String queryUpdateOrderDate = "UPDATE ORDER_TABLE SET order_date = '" + textField_25.getText() + 
		                                                  "' WHERE order_id = " + textField_23.getText();
		                    statement.executeUpdate(queryUpdateOrderDate);
		                }
		                if (textField_26.getText().compareTo("") != 0) {
		                    String queryUpdateTotalAmount = "UPDATE ORDER_TABLE SET total_amount = " + textField_26.getText() + 
		                                                    " WHERE order_id = " + textField_23.getText();
		                    statement.executeUpdate(queryUpdateTotalAmount);
		                }
		                JOptionPane.showMessageDialog(null, 
		                    "Order record updated successfully.", 
		                    "Success", 
		                    JOptionPane.INFORMATION_MESSAGE);
		            }
		        } catch (SQLException e2) {
		            JOptionPane.showMessageDialog(null, 
		                "Connection failed: " + e2.getMessage(), 
		                "Database Error", 
		                JOptionPane.ERROR_MESSAGE);
		        }
		    }
		});
		btnNewButton_1_2.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnNewButton_1_2.setBounds(688, 317, 155, 21);
		frame.getContentPane().add(btnNewButton_1_2);
		
		JLabel lblOrder_1 = new JLabel("Order Details");
		lblOrder_1.setToolTipText("");
		lblOrder_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblOrder_1.setBounds(913, 59, 103, 43);
		frame.getContentPane().add(lblOrder_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("ID:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Arial Black", Font.BOLD, 10));
		lblNewLabel_1_1_1_1_1.setBounds(896, 126, 60, 13);
		frame.getContentPane().add(lblNewLabel_1_1_1_1_1);
		
		textField_27 = new JTextField();
		textField_27.setColumns(10);
		textField_27.setBounds(999, 123, 96, 19);
		frame.getContentPane().add(textField_27);
		
		JLabel lblNewLabel_2_1_3_2_1 = new JLabel("Order ID:");
		lblNewLabel_2_1_3_2_1.setFont(new Font("Arial Black", Font.BOLD, 10));
		lblNewLabel_2_1_3_2_1.setBounds(896, 142, 85, 40);
		frame.getContentPane().add(lblNewLabel_2_1_3_2_1);
		
		textField_28 = new JTextField();
		textField_28.setColumns(10);
		textField_28.setBounds(999, 160, 96, 19);
		frame.getContentPane().add(textField_28);
		
		JLabel lblNewLabel_2_1_3_1_1_2 = new JLabel("Product ID:");
		lblNewLabel_2_1_3_1_1_2.setFont(new Font("Arial Black", Font.BOLD, 10));
		lblNewLabel_2_1_3_1_1_2.setBounds(896, 185, 85, 40);
		frame.getContentPane().add(lblNewLabel_2_1_3_1_1_2);
		
		textField_29 = new JTextField();
		textField_29.setColumns(10);
		textField_29.setBounds(999, 196, 96, 19);
		frame.getContentPane().add(textField_29);
		
		JLabel lblNewLabel_2_1_3_1_1_1_1 = new JLabel("Quantity:");
		lblNewLabel_2_1_3_1_1_1_1.setFont(new Font("Arial Black", Font.BOLD, 10));
		lblNewLabel_2_1_3_1_1_1_1.setBounds(896, 219, 60, 40);
		frame.getContentPane().add(lblNewLabel_2_1_3_1_1_1_1);
		
		textField_30 = new JTextField();
		textField_30.setColumns(10);
		textField_30.setBounds(999, 230, 96, 19);
		frame.getContentPane().add(textField_30);
		
		JLabel lblNewLabel_2_1_3_1_1_1_1_1 = new JLabel("Subtotal:");
		lblNewLabel_2_1_3_1_1_1_1_1.setFont(new Font("Arial Black", Font.BOLD, 10));
		lblNewLabel_2_1_3_1_1_1_1_1.setBounds(896, 259, 60, 40);
		frame.getContentPane().add(lblNewLabel_2_1_3_1_1_1_1_1);
		
		textField_31 = new JTextField();
		textField_31.setColumns(10);
		textField_31.setBounds(999, 270, 96, 19);
		frame.getContentPane().add(textField_31);
		
		JButton btnNewButton_1_2_1 = new JButton("SAVE or UPDATE");

		btnNewButton_1_2_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int match = 0;
		        int productExists = 0; 
		        int orderExists = 0; 
		        
		        try {
		            
		            String queryCheckProduct = "SELECT * FROM PRODUCT WHERE product_id = " + textField_29.getText();
		            rs = statement.executeQuery(queryCheckProduct);
		            while (rs.next()) {
		                productExists = 1;
		            }
		            
		            if (productExists == 0) {
		                JOptionPane.showMessageDialog(null, 
		                    "Error: The provided product_id does not exist. Please provide a valid product_id.", 
		                    "Invalid Product ID", 
		                    JOptionPane.ERROR_MESSAGE);
		                return; 
		            }

		            
		            String queryCheckOrder = "SELECT * FROM ORDER_TABLE WHERE order_id = " + textField_28.getText();
		            rs = statement.executeQuery(queryCheckOrder);
		            while (rs.next()) {
		                orderExists = 1; 
		            }
		            
		            if (orderExists == 0) {
		                JOptionPane.showMessageDialog(null, 
		                    "Error: The provided order_id does not exist. Please provide a valid order_id.", 
		                    "Invalid Order ID", 
		                    JOptionPane.ERROR_MESSAGE);
		                return; 
		            }

		            
		            String queryCheckOrderDetail = "SELECT * FROM ORDER_DETAIL WHERE order_detail_id = " + textField_27.getText();
		            rs = statement.executeQuery(queryCheckOrderDetail); 
		            while (rs.next()) {
		                match = 1; 
		            }
		            
		            if (match == 0) {
		                
		                String queryInsert = "INSERT INTO ORDER_DETAIL VALUES(" +
		                                     textField_27.getText() + ", " +
		                                     textField_28.getText() + ", " +
		                                     textField_29.getText() + ", " +
		                                     textField_30.getText() + ", " +
		                                     textField_31.getText() + ")";
		                statement.executeUpdate(queryInsert);
		                JOptionPane.showMessageDialog(null, 
		                    "New order detail record added successfully.", 
		                    "Success", 
		                    JOptionPane.INFORMATION_MESSAGE);
		            } else {
		                
		                if (textField_28.getText().compareTo("") != 0) {
		                    String queryUpdateOrderId = "UPDATE ORDER_DETAIL SET order_id = " + textField_28.getText() +
		                                                " WHERE order_detail_id = " + textField_27.getText();
		                    statement.executeUpdate(queryUpdateOrderId);
		                }
		                if (textField_29.getText().compareTo("") != 0) {
		                    String queryUpdateProductId = "UPDATE ORDER_DETAIL SET product_id = " + textField_29.getText() +
		                                                  " WHERE order_detail_id = " + textField_27.getText();
		                    statement.executeUpdate(queryUpdateProductId);
		                }
		                if (textField_30.getText().compareTo("") != 0) {
		                    String queryUpdateQuantity = "UPDATE ORDER_DETAIL SET quantity = " + textField_30.getText() +
		                                                 " WHERE order_detail_id = " + textField_27.getText();
		                    statement.executeUpdate(queryUpdateQuantity);
		                }
		                if (textField_31.getText().compareTo("") != 0) {
		                    String queryUpdateSubtotal = "UPDATE ORDER_DETAIL SET subtotal = " + textField_31.getText() +
		                                                 " WHERE order_detail_id = " + textField_27.getText();
		                    statement.executeUpdate(queryUpdateSubtotal);
		                }
		                JOptionPane.showMessageDialog(null, 
		                    "Order detail record updated successfully.", 
		                    "Success", 
		                    JOptionPane.INFORMATION_MESSAGE);
		            }
		        } catch (SQLException e2) {
		            JOptionPane.showMessageDialog(null, 
		                "Connection failed: " + e2.getMessage(), 
		                "Database Error", 
		                JOptionPane.ERROR_MESSAGE);
		        }
		    }
		});
		btnNewButton_1_2_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnNewButton_1_2_1.setBounds(896, 317, 164, 21);
		frame.getContentPane().add(btnNewButton_1_2_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(54, 413, 491, 275);
		frame.getContentPane().add(textArea);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Arial Black", Font.BOLD, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"CHOOSE A TYPE ", 
				"PRODUCT (ID) => NAME,CATEGORY,PRICE,STOCK QUANTITY", 
				"CUSTOMER (ID) => NAME,EMAIL,PHONE", 
				"SUPPLİER (ID) => NAME,CONTACT", 
				"ORDER (ID) => CUSTOMER ID,DATE,AMOUNT",
				"ORDER DETAILS (ID) => ORDER ID,PRODUCT ID,QUANTITY,SUBTOTAL"}));
		comboBox.setBounds(54, 369, 534, 33);
		frame.getContentPane().add(comboBox);
		
		textField_32 = new JTextField();
		textField_32.setColumns(10);
		textField_32.setBounds(633, 423, 96, 19);
		frame.getContentPane().add(textField_32);
		
		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("ENTER ID :");
		lblNewLabel_1_1_1_1_2.setFont(new Font("Arial Black", Font.BOLD, 10));
		lblNewLabel_1_1_1_1_2.setBounds(555, 424, 69, 19);
		frame.getContentPane().add(lblNewLabel_1_1_1_1_2);
		
		JButton btnNewButton_1_3 = new JButton("CLEAR");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textArea.setText("  ");
				
			}
		});
		btnNewButton_1_3.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnNewButton_1_3.setBounds(602, 523, 85, 21);
		frame.getContentPane().add(btnNewButton_1_3);
		
		JButton btnNewButton_1_4 = new JButton("PRINT");
		btnNewButton_1_4.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        
		        if (comboBox.getSelectedIndex() == 0) {
		            textArea.setText("Please make a choice for type");
		        } else if (comboBox.getSelectedIndex() == 1) {
		            
		            if (textField_32.getText().compareTo("") == 0) {
		                textArea.setText("You have to fill the blank for enter product id");
		            } else {
		                try {
		                    String query2 = "select * from product where product_id = " + textField_32.getText();
		                    rs = statement.executeQuery(query2); 
		                    if (rs.next()) { 
		                        textArea.setText("PRODUCT\nID: " + rs.getString("product_id") +
		                                         "\nNAME: " + rs.getString("name") +
		                                         "\nCATEGORY: " + rs.getString("category") +
		                                         "\nPRICE: " + rs.getString("price") +
		                                         "\nSTOCK QUANTITY: " + rs.getString("stock_quantity"));
		                    } else { 
		                        textArea.setText("No product found with the provided ID.");
		                    }
		                } catch (SQLException e2) {
		                    System.out.println("Connection failed: " + e2.getMessage());
		                }
		            }
		        } else if (comboBox.getSelectedIndex() == 2) {
		            
		            if (textField_32.getText().compareTo("") == 0) {
		                textArea.setText("You have to fill the blank for enter customer id");
		            } else {
		                try {
		                    String query3 = "select * from customer where customer_id = " + textField_32.getText();
		                    rs = statement.executeQuery(query3); 
		                    if (rs.next()) {
		                        textArea.setText("CUSTOMER\nID: " + rs.getString("customer_id") +
		                                         "\nNAME: " + rs.getString("name") +
		                                         "\nEMAIL: " + rs.getString("email") +
		                                         "\nPHONE: " + rs.getString("phone_number"));
		                    } else {
		                        textArea.setText("No customer found with the provided ID.");
		                    }
		                } catch (SQLException e3) {
		                    System.out.println("Connection failed: " + e3.getMessage());
		                }
		            }
		        } else if (comboBox.getSelectedIndex() == 3) {
		            
		            if (textField_32.getText().compareTo("") == 0) {
		                textArea.setText("You have to fill the blank for enter supplier id");
		            } else {
		                try {
		                    String query4 = "select * from SUPPLİER where supplier_id = " + textField_32.getText();
		                    rs = statement.executeQuery(query4); 
		                    if (rs.next()) {
		                        textArea.setText("SUPPLİER\nID: " + rs.getString("supplier_id") +
		                                         "\nNAME: " + rs.getString("name") +
		                                         "\nCONTACT: " + rs.getString("contact_info"));
		                    } else {
		                        textArea.setText("No supplier found with the provided ID.");
		                    }
		                } catch (SQLException e4) {
		                    System.out.println("Connection failed: " + e4.getMessage());
		                }
		            }
		        } else if (comboBox.getSelectedIndex() == 4) {
		            
		            if (textField_32.getText().compareTo("") == 0) {
		                textArea.setText("You have to fill the blank for enter order id");
		            } else {
		                try {
		                    String query5 = "select * from ORDER_TABLE where order_id = " + textField_32.getText();
		                    rs = statement.executeQuery(query5); 
		                    if (rs.next()) {
		                        textArea.setText("ORDER\nID: " + rs.getString("order_id") +
		                                         "\nDATE: " + rs.getString("order_date") +
		                                         "\nCUSTOMER ID: " + rs.getString("customer_id") +
		                                         "\nTOTAL AMOUNT: " + rs.getString("total_amount"));
		                    } else {
		                        textArea.setText("No order found with the provided ID.");
		                    }
		                } catch (SQLException e5) {
		                    System.out.println("Connection failed: " + e5.getMessage());
		                }
		            }
		        } else if (comboBox.getSelectedIndex() == 5) {
		            
		            if (textField_32.getText().compareTo("") == 0) {
		                textArea.setText("You have to fill the blank for enter order detail id");
		            } else {
		                try {
		                    String query6 = "select * from ORDER_DETAIL where order_detail_id = " + textField_32.getText();
		                    rs = statement.executeQuery(query6); 
		                    if (rs.next()) {
		                        textArea.setText("ORDER DETAIL\nID: " + rs.getString("order_detail_id") +
		                                         "\nORDER ID: " + rs.getString("order_id") +
		                                         "\nPRODUCT ID: " + rs.getString("product_id") +
		                                         "\nQUANTITY: " + rs.getString("quantity") +
		                                         "\nSUBTOTAL: " + rs.getString("subtotal"));
		                    } else {
		                        textArea.setText("No order detail found with the provided ID.");
		                    }
		                } catch (SQLException e6) {
		                    System.out.println("Connection failed: " + e6.getMessage());
		                }
		            }
		        }
		    }
		});
		btnNewButton_1_4.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnNewButton_1_4.setBounds(555, 468, 174, 21);
		frame.getContentPane().add(btnNewButton_1_4);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"CHOOSE TYPE TO DELETE", "PRODUCT", "CUSTOMER", "SUPPLİER", "ORDER", "ORDER DETAİLS"}));
		comboBox_1.setBounds(825, 371, 222, 33);
		frame.getContentPane().add(comboBox_1);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setForeground(new Color(153, 0, 0));
		lblNewLabel_7.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblNewLabel_7.setBounds(814, 555, 294, 31);
		frame.getContentPane().add(lblNewLabel_7);
		
		textField = new JTextField();
		textField.setBounds(896, 524, 96, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1_2_2 = new JButton("DELETE");

		btnNewButton_1_2_2.addActionListener(new ActionListener() {	
		    public void actionPerformed(ActionEvent e) {
		        
		        if (comboBox_1.getSelectedIndex() == 0) {
		            lblNewLabel_7.setText("Make a choice to delete process");
		        } else if (comboBox_1.getSelectedIndex() == 1) {
		            if (textField.getText().compareTo("") == 0) {
		                lblNewLabel_7.setText("You have to fill the blank for enter id");
		            } else {
		                try {
		                    String query = "delete from product where product_id = " + textField.getText();
		                    statement.executeUpdate(query);
		                    lblNewLabel_7.setText("Product with ID " + textField.getText() + " was deleted");
		                } catch (Exception e2) {
		                    lblNewLabel_7.setText("An error occurred during deletion");
		                    System.out.println("Error: " + e2.getMessage());
		                }
		            }
		        } else if (comboBox_1.getSelectedIndex() == 2) {
		            if (textField.getText().compareTo("") == 0) {
		                lblNewLabel_7.setText("You have to fill the blank for enter id");
		            } else {
		                try {
		                    String query = "delete from customer where customer_id = " + textField.getText();
		                    statement.executeUpdate(query);
		                    lblNewLabel_7.setText("Customer with ID " + textField.getText() + " was deleted");
		                } catch (Exception e2) {
		                    lblNewLabel_7.setText("An error occurred during deletion");
		                    System.out.println("Error: " + e2.getMessage());
		                }
		            }
		        } else if (comboBox_1.getSelectedIndex() == 3) {
		            if (textField.getText().compareTo("") == 0) {
		                lblNewLabel_7.setText("You have to fill the blank for enter id");
		            } else {
		                try {
		                    String query = "delete from SUPPLİER where supplier_id = " + textField.getText();
		                    statement.executeUpdate(query);
		                    lblNewLabel_7.setText("Order with ID " + textField.getText() + " was deleted");
		                } catch (Exception e2) {
		                    lblNewLabel_7.setText("An error occurred during deletion");
		                    System.out.println("Error: " + e2.getMessage());
		                }
		            }
		        } else if (comboBox_1.getSelectedIndex() == 4) {
		            if (textField.getText().compareTo("") == 0) {
		                lblNewLabel_7.setText("You have to fill the blank for enter id");
		            } else {
		                try {
		                    String query = "delete from ORDER_TABLE where order_id = " + textField.getText();
		                    statement.executeUpdate(query);
		                    lblNewLabel_7.setText("Order with ID " + textField.getText() + " was deleted");
		                } catch (Exception e2) {
		                    lblNewLabel_7.setText("An error occurred during deletion");
		                    System.out.println("Error: " + e2.getMessage());
		                }
		            }
		        }  else if (comboBox_1.getSelectedIndex() == 5) {
		            if (textField.getText().compareTo("") == 0) {
		                lblNewLabel_7.setText("You have to fill the blank for enter id");
		            } else {
		                try {
		                    String query = "delete from  ORDER_DETAIL where order_detail_id = " + textField.getText();
		                    statement.executeUpdate(query);
		                    lblNewLabel_7.setText(" ORDER DETAIL with ID " + textField.getText() + " was deleted");
		                } catch (Exception e2) {
		                    lblNewLabel_7.setText("An error occurred during deletion");
		                    System.out.println("Error: " + e2.getMessage());
		    }
		            }
		        }
		    }
		});
		btnNewButton_1_2_2.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnNewButton_1_2_2.setBounds(881, 597, 112, 21);
		frame.getContentPane().add(btnNewButton_1_2_2);
		
		JLabel lblNewLabel_6 = new JLabel("ENTER ID :");
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_6.setBounds(814, 525, 85, 17);
		frame.getContentPane().add(lblNewLabel_6);
		
		
	}
	 public void show() {
	        frame.setVisible(true);
	    }
	}