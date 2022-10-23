/* --------------------------------------------------------------------------

TermServer.java

Terminal-based server for network client-server demo

Based on Server program by RJ Meehan, (c) 1999 Imago Systems Limited,
from http://www.imagosystems.co.uk/sockets.htm

Get server port from command line.  Meehan's server has port number
1234 wired in.

Meehan's Server uses AWT.  This version gets port from
command line, writes received message to standard output.

Meehan's Server wrote timeout messages to standard output -- 
this one doesn't because they'd overwhelm and distract from 
received messages.

You can run this server on a remote system using telnet, and send
messages from Meehan's AWT-based Client running on your desktop.

14-Apr-2001  J. Jacky  Based on Meehan's Server, strip out AWT stuff
-------------------------------------------------------------------------- */

import java.net.*;
import java.io.*;

// In Meehan's version the Client was an AWT Frame. We dispense with all that. 
public class TermServer {

    static ServerSocket ss; // This is where Meehan had it
    static boolean bContinue = true;
    static boolean bServerRunning = false;

    public static void main(String args[])
	{
	    int iPortNo; // This is what Meehan calls it in Client	
    
	    // Get port number from command line -- hardwired in Meehan
	    if (args.length < 1) { // check arg is there
		System.out.println("Usage: java TermServer <port>");
		exit();
	    }
	    iPortNo = Integer.parseInt(args[0]);
	    // what if it doesn't parse?

	    // In Meehan this came from Start button
	    runServer(true);

	    while (carryOn())
		{
		    if (isServerRunning())
			{
			    if (ss == null)
				{
				    createServerSocket(iPortNo);
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
					    ServerDebug.error(ioe, "Failed to close server socket");
					}
				    ss = null;
				}
			}
		}
	    ServerDebug.println("Exiting...");
	    System.exit(0);
	}

    // New code
    private static void exit()
    {
	System.out.println("Client exiting");
	System.exit(0);
    }

    private static void runServer(boolean state)
	{
	    bServerRunning = state;
	}

    private static void exitServer()
	{
	    bContinue = false;
	}

    private static boolean isServerRunning()
	{
	    return bServerRunning;
	}

    private static boolean carryOn()
	{
	    return bContinue;
	}

    private static void createServerSocket(int port)
	{
	    try
		{
		    ss = new ServerSocket(port);
		    ss.setSoTimeout(1000);	// 1 second
		    ServerDebug.println("Server socket created at port " 
				  + port + ", waiting for connection"
				  + ", type ^C to exit");
		}
	    catch (IOException ioe)
		{
		    ServerDebug.error(ioe, "Failed to open server socket");
		    ss = null;
		}
	}

    private static void handleConnection()
	{
	    InputStream is = null;
	    DataInputStream dis = null;
	    StringBuffer sb = new StringBuffer();

	    try
		{
		    // Don't do this!  Prints on screen every second
		    // ServerDebug.println("Waiting for connection..."); // from Meehan

		    // Following call will block for 1s until a connection is made
		    Socket new_sock = ss.accept();

		    ServerDebug.println("Connection made...");

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
		    ServerDebug.println("Connection finished, waiting for another"
				  + ", type ^C to exit");
		}
	    catch (IOException ioe)
		{
		    // Timeout occurred, so ignore
		    // Don't do this -- prints on screen every second
		    // ServerDebug.println("---> Timed out"); // From Meehan
		}
	    finally
		{
		    try_to_close_stream(dis);
		    try_to_close_stream(is);
		}
	}

    private static void try_to_close_stream(InputStream inp)
	{
	    if (inp != null)
		{
		    try
			{
			    inp.close();
			}
		    catch (IOException ioe)
			{
			    ServerDebug.error(ioe, "Failed to close stream");
			}
		}
	}

    private static void report_input(String s)
	{
	    // in Meehan this was ta.setText
	    System.out.println("Message received: " +s);
	}

    // remove Meehan's actionPerformed, handled Start and Stop buttons
}

    class ServerDebug // just Debug in Meehan, rename to distinguish in same dir
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
