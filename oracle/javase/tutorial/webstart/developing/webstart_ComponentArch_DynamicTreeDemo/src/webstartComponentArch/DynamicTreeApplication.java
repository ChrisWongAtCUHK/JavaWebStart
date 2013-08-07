/*
 * Copyright (c) 1995, 2009, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 
package webstartComponentArch;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DynamicTreeApplication extends JFrame {
    public static void main(String [] args) {
        DynamicTreeApplication app = new DynamicTreeApplication();
        JOptionPane.showMessageDialog(null, "args.length=" + args.length);
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < args.length; i++)
        	sb.append("args[" + i + "]:" + args[i] + "\n");
        JOptionPane.showMessageDialog(null, sb.toString());
        if(args.length > 0){
        	// Read arg0 and read file
        	String readFile = args[0];
        	
        	// Read arg1 and write file
        	if(args.length > 1){
        		String writeFile = args[1];
            	write(writeFile, "Yo~");
        	}
        	
        	JOptionPane.showMessageDialog(null, read(readFile));
        }
        app.createGUI();
    }

    private void createGUI() {
        //Create and set up the content pane.
        DynamicTreePanel newContentPane = new DynamicTreePanel();
        newContentPane.setOpaque(true); 
        setContentPane(newContentPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    
	// Print one file
	public static String read(String filename) {
		File file = new File(filename);
		if(!file.exists()){
			return filename + " does not exist.";
		}
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String inputLine;
			StringBuffer sb = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				sb.append(inputLine + "\n");
			}
			br.close();
			return sb.toString();
		} catch (IOException e) {
			return filename + " is not ready";
		}
	}
	
	// Write a file
	public static void write(String filename, String dataLine) {
		try {
			DataOutputStream dos;
			File outFile = new File(filename);

			dos = new DataOutputStream(new FileOutputStream(outFile));

			dos.writeBytes(dataLine);
			dos.close();
		} catch (IOException ex) {
			return;
		}
	}
}
