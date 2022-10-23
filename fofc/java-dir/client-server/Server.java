/* --------------------------------------------------------------------------
(c) 1999 Imago Systems Limited
RJ Meehan

Server program
-------------------------------------------------------------------------- */

import java.net.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Server extends Frame implements ActionListener
{
	private ServerSocket ss;
 	private TextArea ta;
	private boolean bContinue = true;
	private boolean bServerRunning = false;
	private Button but;

	public static void main(String args[])
	{
		Server serv = new Server("Server");
	}

	public Server(String title)
	{
		super(title);
		Panel p = new Panel();
		p.setLayout(new FlowLayout());
		but = new Button("Start");
		but.addActionListener(this);
		p.add(but);
		this.add("North", p);
		ta = new TextArea(10, 40);
		ta.setEnabled(false);
		this.add("Center", ta);
		this.addWindowListener(new WindowAdapter()
					{public void windowClosing(WindowEvent e)
					{exitServer();} });
		this.pack();
		this.setVisible(true);

		while (carryOn())
		{
			if (isServerRunning())
			{
				if (ss == null)
				{
					createServerSocket();
				}
				handleConnection();
			}
			else
			{
				if (ss != null)
				{
					try
					{
						ss.close();
					}
					catch (IOException ioe)
					{
						Debug.error(ioe, "Failed to close server socket");
					}
					ss = null;
				}
			}
		}
		Debug.println("Exiting...");
		this.setVisible(false);
		this.dispose();
		System.exit(0);
	}

	private synchronized void runServer(boolean state)
	{
		bServerRunning = state;
	}

	private synchronized void exitServer()
	{
		bContinue = false;
	}

	private synchronized boolean isServerRunning()
	{
		return bServerRunning;
	}

	private synchronized boolean carryOn()
	{
		return bContinue;
	}

	private void createServerSocket()
	{
		try
		{
			ss = new ServerSocket(1234);
			ss.setSoTimeout(1000);	// 1 second
			Debug.println("Server socket created...");
		}
		catch (IOException ioe)
		{
			Debug.error(ioe, "Failed to open server socket");
			ss = null;
		}
	}

	private void handleConnection()
	{
		InputStream is = null;
		DataInputStream dis = null;
		StringBuffer sb = new StringBuffer();

		try
		{
			Debug.println("Waiting for connection...");

			// Following call will block for 1s until a connection is made
			Socket new_sock = ss.accept();

			Debug.println("Connection made...");

			is = new_sock.getInputStream();
			dis = new DataInputStream(is);
			while (true)
			{
				byte [] bya = new byte[1];
				bya[0] = dis.readByte();
				sb.append(new String(bya));
			}
		}
		catch (EOFException eofe)
		{
			// Ignore this, this is OK
			report_input(sb.toString());
			Debug.println("Connection finished");
		}
		catch (IOException ioe)
		{
			// Timeout occurred, so ignore
			Debug.println("---> Timed out");
		}
		finally
		{
			try_to_close_stream(dis);
			try_to_close_stream(is);
		}
	}

	private void try_to_close_stream(InputStream inp)
	{
		if (inp != null)
		{
			try
			{
				inp.close();
			}
			catch (IOException ioe)
			{
				Debug.error(ioe, "Failed to close stream");
			}
		}
	}

	private void report_input(String s)
	{
		ta.setText("Message received:\n" +s);
	}

	public void actionPerformed(ActionEvent evt)
	{
		String cmd = evt.getActionCommand();
		if (cmd.equals("Start"))
		{
			but.setLabel("Stop");
			but.setActionCommand("Stop");
			runServer(true);
		}
		else if (cmd.equals("Stop"))
		{
			but.setLabel("Start");
			but.setActionCommand("Start");
			runServer(false);
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