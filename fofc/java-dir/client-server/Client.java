/* --------------------------------------------------------------------------
(c) 1999 Imago Systems Limited
RJ Meehan

Client program
-------------------------------------------------------------------------- */

import java.net.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Client extends Frame implements ActionListener
{
	private Socket sock;
 	private TextField tfInput;
	private TextField tfPortNo;
	private TextField tfIP;
	private boolean bContinue = true;

	public static void main(String args[])
	{
		Client client = new Client("Client");
	}

	public Client(String title)
	{
		super(title);
		Panel p = new Panel();
		p.setLayout(new FlowLayout());
		p.add(new Label("IP address"));
		tfIP = new TextField("127.0.0.1", 20);
		p.add(tfIP);
		p.add(new Label("Port number:"));
		tfPortNo = new TextField(5);
		p.add(tfPortNo);
		p.add(new Label("Message:"));
		tfInput = new TextField(40);
		tfInput.addActionListener(this);
		p.add(tfInput);
		this.add("Center", p);
		Panel p2 = new Panel();
		Button but = new Button("Send");
		but.addActionListener(this);
		p2.add(but);
		this.add("South", p2);
		this.addWindowListener(new WindowAdapter()
					{public void windowClosing(WindowEvent e)
					{exitClient();} });
		this.pack();
		this.setVisible(true);

		while (carryOn())
		{
		}

		Debug.println("Exiting...");
		this.setVisible(false);
		this.dispose();
		System.exit(0);
	}

	private synchronized void exitClient()
	{
		bContinue = false;
	}

	private synchronized boolean carryOn()
	{
		return bContinue;
	}

	private void transmitMessage(String mess, InetAddress ip, int iPortNo)
	{
		Socket sock = null;
		OutputStream os = null;
		DataOutputStream dos = null;
	
		try
		{
			sock = new Socket(ip, iPortNo);
			os = sock.getOutputStream();
			dos = new DataOutputStream(os);
			dos.writeBytes(mess);
			Debug.println("Message written");
		}
		catch (IOException ioe)
		{
			Debug.error(ioe, "Failed to write message to socket");
		}
		finally
		{
			try_to_close_stream(dos);
			try_to_close_stream(os);
			try
			{
				sock.close();
			}
			catch (IOException ioe)
			{
				Debug.error(ioe, "Failed to close socket");
			}
		}
	}

	private void try_to_close_stream(OutputStream out)
	{
		if (out != null)
		{
			try
			{
				out.close();
			}
			catch (IOException ioe)
			{
				Debug.error(ioe, "Failed to close stream");
			}
		}
	}

	public void actionPerformed(ActionEvent evt)
	{
		try
		{
			int iPortNo = Integer.parseInt(tfPortNo.getText());
			InetAddress [] ips = InetAddress.getAllByName(tfIP.getText());
			if (ips.length > 0)
			{
				transmitMessage(tfInput.getText(), ips[0], iPortNo);
			}
		}
		catch (NumberFormatException nfe)
		{
			Debug.error(nfe, "Port number not valid");
		}
		catch (UnknownHostException uhe)
		{
			Debug.error(uhe, "IP address or host name not known");
		}
	}
}

class Debug
{
	public static void error(Throwable ex, String s)
	{
		System.out.println("-------------------------------------");
		ex.printStackTrace();
		System.out.println("\nException was: "+ex+"\n\n");
		System.out.println("Error message: "+s);
		System.out.println("-------------------------------------");
	}
	
	public static void println(String s)
	{
		System.out.println(s);
	}
}