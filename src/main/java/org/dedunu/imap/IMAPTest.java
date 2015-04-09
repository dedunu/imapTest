package org.dedunu.imap;

import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Session;
import javax.mail.Store;

public class IMAPTest {
    public static void main(String []args) {
        Properties props = System.getProperties();
        props.setProperty("mail.store.protocol","imap");
        Session session = Session.getDefaultInstance(props, null);

        try {
          
            /*
            	Hostname : imap.example.com
            	Port : 143
            	Username : john.doe@example.com
            	Password : Pa$$w0rd
            */

            Store store = session.getStore("imap");
            store.connect("imap.example.com",143,"john.doe@example.com","Pa$$w0rd");
            Folder rootFolder = store.getDefaultFolder();
            Folder[] imapFolders = rootFolder.list("*");

            System.out.println(imapFolders.length);

            for (Folder folder : imapFolders) {
                System.out.println(folder.getFullName());
            }

            store.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}