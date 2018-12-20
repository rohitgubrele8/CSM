package com.codiecon.codiecon.serviceImpl;

import com.codiecon.codiecon.models.Response.OtpResponse;
import com.codiecon.codiecon.models.entity.LoginDetails;
import com.codiecon.codiecon.models.entity.Otp;
import com.codiecon.codiecon.models.request.OtpRequest;
import com.codiecon.codiecon.repository.LoginDetailsRepository;
import com.codiecon.codiecon.service.OtpService;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;


@Service
public class OtpServiceImpl implements OtpService {

  @Autowired
  LoginDetailsRepository loginDetailsRepository;

  @Override
  public OtpResponse validateOtp(OtpRequest otpRequest) {

    try {
      LoginDetails loginDetails = loginDetailsRepository.findByEmail(otpRequest.getEmail());
      Preconditions.checkArgument(Objects.nonNull(loginDetails));
      if (loginDetails.getOtp().equals(otpRequest.getOtp())) {
        return new OtpResponse(true, HttpStatus.OK.value(), loginDetails.getRole(), true);
      } else
        return new OtpResponse(false, HttpStatus.OK.value(), null, false);
    } catch (Exception e) {
      throw new RuntimeException("failed to validate otp");
    }
  }

  @Override
  @Transactional(readOnly = false)
  public void reGenerateOtp(String email) {
    try {
      Integer otp = GenerateOtp();
      LoginDetails loginDetails = loginDetailsRepository.findByEmail(email);
      Preconditions.checkArgument(Objects.nonNull(loginDetails));
      loginDetails.setOtp(otp);
      loginDetailsRepository.save(loginDetails);
      sendOtp(otp, email);
    } catch (Exception e) {
      throw new RuntimeException("failed to regenerateOtp");
    }
  }

  @Override
  public Integer GenerateOtp() {
    Integer otp = ThreadLocalRandom.current().nextInt(0, 9999);
    return otp;
  }

  @Override
  public void sendOtp(Integer otp, String email) {
    String smtpHostServer = "smtp.gmail.com";
    Properties props = System.getProperties();
    props.setProperty("mail.transport.protocol", "smtp");
    props.setProperty("mail.host", "smtp.gmail.com");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.port", "587");
    props.put("mail.smtp.starttls.enable", "true");
    Authenticator authenticator = new javax.mail.Authenticator() {
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication("cmscodiecon@gmail.com", "codiecon123");
      }
    };
    Session session = Session.getInstance(props, authenticator);
    sendEmail(session, email, "OTP", otp.toString());
  }

  private void sendEmail(Session session, String toEmail, String subject, String body) {
    try {
      MimeMessage msg = new MimeMessage(session);
      //set message headers
      msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
      msg.addHeader("format", "flowed");
      msg.addHeader("Content-Transfer-Encoding", "8bit");

      msg.setFrom(new InternetAddress("cmsCodiecon@gmail.com", "RohitGubrele"));

      msg.setReplyTo(InternetAddress.parse("rohitgubrele8@gmail.com", false));

      msg.setSubject(subject, "UTF-8");

      msg.setText(body, "UTF-8");

      msg.setSentDate(new Date());

      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
      System.out.println("Message is ready");
      Transport.send(msg);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
