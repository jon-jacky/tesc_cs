/* --------------------------------------------------------------------------

TermClient.java

Terminal-based client for network client-server demo

Based on Client program by RJ Meehan, (c) 1999 Imago Systems Limited,
from http://www.imagosystems.co.uk/sockets.htm

Meehan's Client uses AWT.  This version gets host and port from
command line, gets message from standard input.

You can run this client on a remote system using telnet, and send
messages to Meehan's AWT-based Server running on your desktop.

31-Mar-2001  J. Jacky  Based on Meehan's Client, strip out AWT stuff

-------------------------------------------------------------------------- */

import java.net.*;
import java.io.*;

// In Meehan's version the Client was an AWT Frame. We dispense with all that. 
public class TermClient { 

    private Socket sock; // from Meehan - not sure why it's here

    // Our main routine is based on Meehan's actionPerformed routine
    // but interactive input from stdio as in O'Reilly JAVA EXAMPLES p. 14
    public static void main(String args[]) throws IOException
    {
	try
	    {
		InetAddress [] ips;
		int iPortNo;
		String msg;

		// Check command line
		if (args.length < 2) {
		    System.out.println("Usage: java TermClient <host> <port>");
		    exit();
		}

		// Get host, port from command line
		ips = InetAddress.getAllByName(args[0]);
		iPortNo = Integer.parseInt(args[1]);
		if (ips.length < 1) exit();
		System.out.println("Calling host "+ips[0]+", port "+iPortNo);
		System.out.println("Type message at >, or press RETURN to exit");
		    
		// Set up input - magic copied from O'Reilly JAVA EXAMPLES p. 14
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// This loop not in Meehan's code - he used AWT events
		while (true) 
		    {
			System.out.print("> ");
			msg = in.readLine();
			if (msg.length() > 0) 
			    transmitMessage(msg, ips[0], iPortNo);
			else 
			    exit();
		    }
	    }

	catch (NumberFormatException nfe)
	    {
		TermDebug.error(nfe, "Port number not valid");
	    }
	catch (UnknownHostException uhe)
	    {
		TermDebug.error(uhe, "IP address or host name not known");
	    }
    } // main

    // New code
    private static void exit()
    {
	System.out.println("Client exiting");
	System.exit(0);
    }

    // Omit Meeham's exitClient() and carryOn()

    /* 
     Not static in Meeham, But javac complains 
     "non-static method cannot be referenced from a static context"
    */
    private static void transmitMessage(String mess, InetAddress ip, int iPortNo)
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
		TermDebug.println("Message written");
	    }
	catch (IOException ioe)
	    {
		TermDebug.error(ioe, "Failed to write message to socket");
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
			TermDebug.error(ioe, "Failed to close socket");
		    }
	    }
    }

    /* Not static in Meehan */
    private static void try_to_close_stream(OutputStream out)
    {
	if (out != null)
	    {
		try
		    {
			out.close();
		    }
		catch (IOException ioe)
		    {
			TermDebug.error(ioe, "Failed to close stream");
		    }
	    }
    }
} // Client

class TermDebug
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
} // Debug
