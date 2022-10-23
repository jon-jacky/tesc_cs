/**
 * ChatApplet.java  1.00 96/11/01 Merlin Hughes
 *
 * Copyright (c) 1996 Prominence Dot Com, Inc. All Rights Reserved.
 *
 * Permission to use, copy, modify, and distribute this software
 * for non-commercial purposes and without fee is hereby granted
 * provided that this copyright notice appears in all copies.
 *
 * http://prominence.com/                  merlin@prominence.com
 */

import java.net.*;
import java.io.*;
import java.awt.*;
import java.applet.*;

// Applet parameters:
//   host = host name
//   port = host port

public class ChatApplet extends Applet implements Runnable {
  protected DataInputStream i;
  protected DataOutputStream o;

  protected TextArea output;
  protected TextField input;

  protected Thread listener;

  public void init () {
    setLayout (new BorderLayout ());
    add ("Center", output = new TextArea ());
    output.setEditable (false);
    add ("South", input = new TextField ());
    input.setEditable (false);
  }

  public void start () {
    listener = new Thread (this);
    listener.start ();
  }

  public void stop () {
    if (listener != null)
      listener.stop ();
    listener = null;
  }

  public void run () {
    try {
      String host = getParameter ("host");
      if (host == null)
	host = getCodeBase ().getHost ();
      String port = getParameter ("port");
      if (port == null)
	port = "9830";
      output.appendText ("Connecting to " + host + ":" + port + "...");
      Socket s = new Socket (host, Integer.parseInt (port));
      i = new DataInputStream (new BufferedInputStream (s.getInputStream ()));
      o = new DataOutputStream (new BufferedOutputStream (s.getOutputStream ()));
      output.appendText (" connected.\n");
      input.setEditable (true);
      input.requestFocus ();
      execute ();
    } catch (IOException ex) {
      ByteArrayOutputStream out = new ByteArrayOutputStream ();
      ex.printStackTrace (new PrintStream (out));
      output.appendText ("\n" + out);
    }
  }

  public void execute () {
    try {
      while (true) {
        String line = i.readUTF ();
        output.appendText (line + "\n");
      }
    } catch (IOException ex) {
      ByteArrayOutputStream out = new ByteArrayOutputStream ();
      ex.printStackTrace (new PrintStream (out));
      output.appendText (out.toString ());
    } finally {
      listener = null;
      input.hide ();
      validate ();
      try {
        o.close ();
      } catch (IOException ex) {
        ex.printStackTrace ();
      }
    }
  }

  public boolean handleEvent (Event e) {
    if ((e.target == input) && (e.id == Event.ACTION_EVENT)) {
      try {
        o.writeUTF ((String) e.arg);
        o.flush ();
      } catch (IOException ex) {
        ex.printStackTrace();
        listener.stop ();
      }
      input.setText ("");
      return true;
    } else if ((e.target == this) && (e.id == Event.WINDOW_DESTROY)) {
      if (listener != null)
        listener.stop ();
      hide ();
      return true;
    }
    return super.handleEvent (e);
  }
}
