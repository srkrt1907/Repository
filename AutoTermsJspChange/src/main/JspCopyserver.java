package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JList;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.util.Vector;

import javax.swing.JTextPane;

import org.apache.log4j.Logger;


public class JspCopyserver extends JFrame {
	
	
	private static final Logger log = Logger.getLogger(JspCopyserver.class);
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	DefaultListModel model;
	JList list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JspCopyserver frame = new JspCopyserver();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JspCopyserver() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIp = new JLabel("Ip Adress");
		lblIp.setBounds(10, 11, 46, 14);
		contentPane.add(lblIp);
		
		textField = new JTextField();
		textField.setBounds(66, 8, 239, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblDosya = new JLabel("Dosya");
		lblDosya.setBounds(10, 43, 46, 14);
		contentPane.add(lblDosya);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(66, 40, 239, 20);
		contentPane.add(textField_1);
		
		textField_1.setText("C:/Users/Kafein/Documents/terms.jsp");
		
		
		JButton btnNewButton = new JButton("Kopyala");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Copy(textField.getText(),textField_1.getText());
			}
		});
		btnNewButton.setBounds(216, 71, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnIpEkle = new JButton("Ip Ekle");
		btnIpEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.addElement(textField.getText());
			}
		});
		btnIpEkle.setBounds(316, 7, 77, 23);
		contentPane.add(btnIpEkle);
		
		model = new DefaultListModel<>();
		list = new JList<>(model);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(list);
		scrollPane.setBounds(410, 7, 200, 229);
		contentPane.add(scrollPane);
		
		JButton btnSeciliSil = new JButton("Secili Sil");
		btnSeciliSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = list.getSelectedIndex();
				if (selectedIndex != -1) {
				    model.remove(selectedIndex);
				}
			}
		});
		btnSeciliSil.setBounds(521, 247, 89, 23);
		contentPane.add(btnSeciliSil);
		
		JButton btnTmnSil = new JButton("T\u00FCm\u00FCn\u00FC Sil");
		btnTmnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.removeAllElements();
			}
		});
		btnTmnSil.setBounds(410, 247, 99, 23);
		contentPane.add(btnTmnSil);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 128, 372, 146);
		contentPane.add(scrollPane_1);
		
		JLabel label = new JLabel("Dosya");
		label.setBounds(10, 103, 46, 14);
		contentPane.add(label);
				
	}
	
	void Copy(String ip , String filename)
	{
			for(int k = 0 ; k <= model.getSize() ; k++)
			{
				  String FILETOTRANSFER = filename;
				  String SFTPHOST;
				  if(model.getSize() == 0)
					  SFTPHOST = ip;
				  else
					  SFTPHOST = model.getElementAt(k).toString();
				  
			        int SFTPPORT = 22;
			        String SFTPUSER = "";//kullaniciadi
			        String SFTPPASS = "";//sifre

			        Session session = null;
			        Channel channel = null;
			        ChannelSftp channelSftp = null;
			        log.info("("+SFTPHOST+")preparing the host information for sftp.");
			        System.out.println("preparing the host information for sftp.");
			        try {
			            JSch jsch = new JSch();
			            session = jsch.getSession(SFTPUSER, SFTPHOST, SFTPPORT);
			            session.setPassword(SFTPPASS);
			            java.util.Properties config = new java.util.Properties();
			            config.put("StrictHostKeyChecking", "no");
			            session.setConfig(config);
			            session.connect();
			            log.info("Host connected.");
			            System.out.println("Host connected.");
			            channel = session.openChannel("sftp");
			            channel.connect();
			            log.info("sftp channel opened and connected.");
			            System.out.println("sftp channel opened and connected.");
			            channelSftp = (ChannelSftp) channel;
			           
			            
			            
			            
			            Vector<ChannelSftp.LsEntry> list = channelSftp.ls("/usr/local/tomcat/webapps");
			            for(int i=0; i<list.size();i++){
			                if (list.get(i).getAttrs().isDir()) {	
			                	try {
			                		String dir = "/usr/local/tomcat/webapps/" + list.get(i).getFilename() + "/WEB-INF/views";
			                		channelSftp.cd(dir);
				     	            File f = new File(FILETOTRANSFER);
				     	            channelSftp.put(new FileInputStream(f), f.getName());
			                		
								} catch (Exception e) {
									log.error("connection errror = " , e);
									e.printStackTrace();
									continue;
								}
			                	System.out.println(list.get(i).toString()); // display only directories
			                	log.info(list.get(i).toString());
			                }
			            }
			            log.info("Host connected.");
			            log.info("File transfered successfully to host." + channelSftp.toString());
			            
			        } catch (Exception ex) {
			        	log.error("Exception found while tranfer the response.",ex);
			        	JOptionPane.showMessageDialog(this, "Ýþlem Gercekleþtirme Hatasi.", "Warning",
			                    JOptionPane.WARNING_MESSAGE);
			        }
			        finally{
			        		
			            channelSftp.exit();
			            log.info("sftp Channel exited.");
			            channel.disconnect();
			            log.info("Channel disconnected.");
			            session.disconnect();
			            log.info("Host Session disconnected.");
			            JOptionPane.showMessageDialog(this, "Ýþlem Baþarýlý Bir Þekilde Gerçekleþtirildi.", "Warning",
			                    JOptionPane.WARNING_MESSAGE);
			        }
			}
		
		 
	}
}
