package com.brunner.service.util;

import java.io.File;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

// SMTP 메일 발송
public class SMTPMail {

	public static void main(String[] args) {
		SMTPMail p = new SMTPMail();
		p.sendMail(
				"smtp.gmail.com",      // smtpHost
				true,                  // useSSL
				false,                 // useTLS
				"hbsim0605",           // id
				"bcjhuywygvonhauh",    // pwd
				"hbsim0605@gmail.com", // from
				"hbsim0605@naver.com", // to
				null,                  // cc
				null,                  // bcc
				"test",                // subject
				"�����׽�Ʈ",               // body
				null                   // attach files
				); 
	}

	/***
	 * 
	 * @param smtpHost // "smtp.gmail.com"
	 * @param useSSL   // SSL
	 * @param useTLS   // TLS 
	 * @param id
	 * @param pwd
	 * @param fromAddress
	 * @param toAddresses
	 * @param ccAddresses
	 * @param bccAddresses
	 * @param mailSubject
	 * @param mailBody
	 * @param attachFiles
	 * 
	 */
	public void sendMail(
			String smtpHost, 
			boolean useSSL, 
			boolean useTLS,
			String id, 
			String pwd,
			String fromAddress,
			String toAddresses,
			String ccAddresses,
			String bccAddresses,
			String mailSubject,
			String mailBody,
			String[] attachFiles
			) {

		try {
			// ���� ȯ�� ���� �����Դϴ�.
			Properties props = new Properties();

			// ���� ���������� gmail�� �̿��� ���̱� ������ smtp�� ����մϴ�.
			props.setProperty("mail.transport.protocol", "smtp");

			// ���� ȣ��Ʈ �ּҸ� �����մϴ�.
			props.setProperty("mail.host", smtpHost);

			Session session = null;
			if(useSSL) {
				// ssl�� ����� ��� �����մϴ�.
				props.put("mail.smtp.auth", "true"); //enable authentication
				props.put("mail.smtp.socketFactory.port", "465");
				props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
				props.put("mail.smtp.socketFactory.fallback", "false");
				props.put("mail.smtp.ssl.trust",smtpHost);
				props.setProperty("mail.smtp.quitwait", "false");

				// id�� password�� �����ϰ� session�� �����մϴ�.
				session = Session.getInstance(props, new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(id, pwd);
					}
				});

				// ����� ����Դϴ�.
				session.setDebug(true);
			}

			if(useTLS) {
				props.put("mail.smtp.auth", "true"); 
				props.put("mail.smtp.port", "587"); //TLS Port
				props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS			
				props.put("mail.smtp.ssl.trust",smtpHost);

				// id�� password�� �����ϰ� session�� �����մϴ�.
				session = Session.getDefaultInstance(props, new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(id, pwd);
					}
				});

				// ����� ����Դϴ�.
				session.setDebug(true);
			}

			// ���� �޽����� ����� ���� Ŭ������ �����մϴ�.
			MimeMessage message = new MimeMessage(session);

			// �۽��� ����
			message.setFrom(getAddress(fromAddress));

			// ������ ����
			message.addRecipients(Message.RecipientType.TO, getAddresses(toAddresses));

			if(ccAddresses != null && ccAddresses.trim().equals("") == false) {
				// ���� ������ ����
				message.addRecipients(Message.RecipientType.CC, getAddresses(ccAddresses));
			}
			
			if(bccAddresses != null && bccAddresses.trim().equals("") == false) {
				// ���� ���� ������ ����
				message.addRecipients(Message.RecipientType.BCC, getAddresses(bccAddresses));
			}
			
			// ���� ������ �����մϴ�.
			message.setSubject(mailSubject);

			// ���� ������ ������ ���� Ŭ������ �����մϴ�.
			message.setContent(new MimeMultipart());

			// ���� ������ ���� MultipartŬ������ �޾ƿ´�. (�� new MimeMultipart()�� ���� Ŭ�����Դϴ�.)
			Multipart mp = (Multipart) message.getContent();

			// html �������� ������ �ۼ��ؼ� �ٿ������ �ֽ��ϴ�.
			mp.addBodyPart(
					getContents(String.format("<html><head></head><body>%s</body></html>", mailBody)));

			if(attachFiles != null && attachFiles.length > 0) {
				for(String attachFile : attachFiles) {
					// ÷�� ������ �߰��մϴ�. (���� ��� �⸸ ���� ÷��)
					mp.addBodyPart(getFileAttachment(attachFile));
				}
			}
			
			// �̹��� ������ �߰��ؼ� contextId�� �����մϴ�. contextId�� �� ���� ������ cid�� ��ũ�� ���� �����մϴ�.
			// mp.addBodyPart(getImage("capture.png", "image"));

			// ������ �����ϴ�.
			Transport.send(message);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	/***
	 * �̹����� ���÷� ���� �о�ͼ� BodyPart Ŭ������ �����. (�ٿ���� ��ȯ)
	 * 
	 * @param filename
	 * @param contextId
	 * @return
	 * @throws MessagingException
	 */
	@SuppressWarnings("unused")
	private BodyPart getImage(String filename, String contextId) throws MessagingException {
		
		BodyPart mbp = getFileAttachment(filename);

		if (contextId != null) {
			// ContextId
			mbp.setHeader("Content-ID", "<" + contextId + ">");
		}

		return mbp;
	}

	/***
	 * 
	 * @param filename
	 * @return
	 * @throws MessagingException
	 */
	private BodyPart getFileAttachment(String filename) throws MessagingException {
		
		BodyPart mbp = new MimeBodyPart();
		File file = new File(filename);

		DataSource source = new FileDataSource(file);
		mbp.setDataHandler(new DataHandler(source));
		mbp.setDisposition(Part.ATTACHMENT);
		mbp.setFileName(file.getName());
		return mbp;
	}

	/***
	 * 
	 * @param html
	 * @return
	 * @throws MessagingException
	 */
	private BodyPart getContents(String html) throws MessagingException {
		BodyPart mbp = new MimeBodyPart();
		mbp.setContent(html, "text/html; charset=utf-8");
		return mbp;
	}

	/***
	 * 
	 * @param address
	 * @return
	 * @throws AddressException
	 */
	private Address getAddress(String address) throws AddressException {
		return new InternetAddress(address);
	}

	/***
	 * 
	 * @param addresses
	 * @return
	 * @throws AddressException
	 */
	private Address[] getAddresses(String addresses) throws AddressException {
		String[] array = addresses.split(",");
		Address[] ret = new Address[array.length];

		for (int i = 0; i < ret.length; i++) {
			ret[i] = getAddress(array[i]);
		}

		return ret;
	}
}