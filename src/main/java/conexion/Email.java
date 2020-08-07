package conexion;

import java.io.File;

import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * 
 * @author Amanda Castro, Miranda Venegas 
 * @version 1.0
 *
 */
public class Email {
  
  private final String email = "mvenegasc22@gmail.com";
  private final String password = "cafeteraCarisima99thehell";
  
  private Properties properties;
  
  private Session session;
  
  private ArrayList<String> recipients;
  private String subject;
  
  private ArrayList<File> files;
  
  private String body;
  private boolean isHtml;
  
  /**
   * Constructor de la clase
   */
  public Email() {
    files = new ArrayList<File>();
    recipients = new ArrayList<String>();
    properties = new Properties();
    properties.put("mail.smtp.host", "smtp.gmail.com");
    properties.put("mail.smtp.port", "587");
    properties.put("mail.smtp.auth", "true");
    properties.put("mail.smtp.starttls.enable", "true");
    properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
    session = Session.getInstance(properties, new javax.mail.Authenticator() {
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(email, password);
      }
    });
  }
  
  /**
   * Coloca el titulo del correo
   * 
   * @param subject Titulo del correo
   */
  public void setSubject(String subject) {
    this.subject = subject;
  }
  
  /**
   * A�ade un destinatario
   * 
   * @param email Destinatario
   */
  public void addRecipient(String email) {
    recipients.add(email);
  }
  
  /**
   * A�ade un archivo al correo
   * 
   * @param file Archivo a a�adir
   */
  public void addFile(File file) {
    files.add(file);
  }
  
  /**
   * A�ade un archivo al correo
   * 
   * @param path Ruta del archivo
   */
  public void addFile(String path) {
    File file = new File(path);
    files.add(file);
  }
  
  /**
   * A�ade un seccion del cuerpo al correo
   * 
   * @param body Contenido a agregar
   * @param isHtml Verdadero si el contenido es html, falso en caso contrario
   */
  public void addBody(String body, boolean isHtml) {
    this.body = body;
    this.isHtml = isHtml;
  }
  
  /**
   * Envia el email creado
   * 
   * @return result Verdadero si el correo se envio exitosamente, falso en caso contrario
   */
  public boolean sendEmail() {
    try {
      return sendEmailAux();
    } 
    catch (MessagingException e) {
        e.printStackTrace();
      return false;
    }
  }
  
  /**
   * Procesa la informacion dada al correo y realiza el envio
   * 
   * @return result Verdadero si el correo se envio exitosamente, falso si cae en la excepcion
   * @throws MessagingException Error al enviar el mensaje
   */
  private boolean sendEmailAux() throws MessagingException {
    MimeMessage message = new MimeMessage(session);
    //message.setFrom(email);
    message.setSubject(subject);
    message.setRecipients(Message.RecipientType.TO, createAddresses());
    Multipart multipart = new MimeMultipart();
    multipart.addBodyPart(getBody());
    if(files.size() > 0) {
      multipart = getFiles(multipart);
    }
    message.setContent(multipart);
    message.saveChanges();
    message.setSentDate(new Date());
    Transport.send(message);
    return true;
  }
  
  /**
   * Retorna el cuerpo del correo
   * 
   * @return part Cuerpo del correo
   * @throws MessagingException Fallo en el formato del cuerpo
   */
  private MimeBodyPart getBody() throws MessagingException {
    MimeBodyPart part = new MimeBodyPart();
    if(isHtml) {
      part.setContent(body, "text/html;charset=UTF-8");
    }
    else {
      part.setText(body);
    }
    return part;
  }
  
  /**
   * Retorna los archivo del correo
   * 
   * @param multipart Multiparte en la cual a�adir los archivos
   * @return multipart Multiparte con los archivos a�adidos
   * @throws MessagingException Error al a�adir los archivos al multiparte
   */
  private Multipart getFiles(Multipart multipart) throws MessagingException {
    for(int i = 0; i < files.size(); i++) {
      MimeBodyPart part = new MimeBodyPart();
      File file = files.get(i);
      if(file.exists()) {
        FileDataSource source = new FileDataSource(file);
        part.setDataHandler(new DataHandler(source));
        part.setFileName(source.getName());
        multipart.addBodyPart(part);
      }
    }
    return multipart;
  }
  
  /**
   * Genera una direccion para cada destinatario
   * 
   * @return addresses Direcciones creadas
   * @throws AddressException Fallo en el formato de los correos
   */
  private Address[] createAddresses() throws AddressException {
    Address[] addresses = new Address[recipients.size()];
    for(int i = 0; i < recipients.size(); i++) {
      addresses[i] = new InternetAddress(recipients.get(i));
    }
    return addresses;
  }
  
}
