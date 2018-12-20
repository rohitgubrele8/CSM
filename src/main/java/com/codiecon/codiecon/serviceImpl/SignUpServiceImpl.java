package com.codiecon.codiecon.serviceImpl;

import com.codiecon.codiecon.models.Response.LoginResponse;
import com.codiecon.codiecon.models.entity.Documents;
import com.codiecon.codiecon.models.entity.LoginDetails;
import com.codiecon.codiecon.models.enums.DocumentType;
import com.codiecon.codiecon.models.request.DocumentSubmitRequest;
import com.codiecon.codiecon.models.request.LoginRequest;
import com.codiecon.codiecon.models.request.SignUpRequest;
import com.codiecon.codiecon.repository.DocumentsRepository;
import com.codiecon.codiecon.repository.DriverDetailsRepository;
import com.codiecon.codiecon.repository.LoginDetailsRepository;
import com.codiecon.codiecon.repository.OwnerDetailsRepository;
import com.codiecon.codiecon.service.SignUpService;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.File;

import com.gdn.tms.util.rest.util.FileHandler;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;


@Service
public class SignUpServiceImpl implements SignUpService {

  private static final int MIN_OTP_RANGE = 1000;
  private static final int MAX_OTP_RANGE = 9999;

  @Autowired
  OwnerDetailsRepository ownerDetailsRepository;

  @Autowired
  LoginDetailsRepository loginDetailsRepository;

  @Autowired
  DriverDetailsRepository driverDetailsRepository;

  @Autowired
  DocumentsRepository documentsRepository;


  @Override
  public void signUp(SignUpRequest signUpRequest) {

    try {
      LoginDetails loginDetails = new LoginDetails();
      loginDetails.setEmail(signUpRequest.getEmail());
      loginDetails.setPassword(signUpRequest.getPassword());
      loginDetails.setRole(signUpRequest.getRole());
      loginDetails.setName(signUpRequest.getName());
      loginDetailsRepository.save(loginDetails);
    } catch (Exception e) {
      throw new RuntimeException("Duplicate email");
    }
  }


  @Override
  public LoginResponse login(LoginRequest loginRequest) {
    try {
      LoginDetails loginDetails = loginDetailsRepository
          .findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
      Preconditions.checkArgument(Objects.nonNull(loginDetails));
      return new LoginResponse(true, HttpStatus.OK.value(), true, loginDetails.getRole());
    } catch (Exception e) {
      return new LoginResponse(false, HttpStatus.OK.value(), false, null);
    }

  }


  @Override
  public void uploadDocuments(MultipartFile file, String email, DocumentType documentType) {
    try {
      String fileName =
          new StringBuilder().append(generateImageFileName(documentType.toString(), email))
              .toString();

      File imageFile = new File(fileName);
      imageFile.getParentFile().mkdirs();
      imageFile.setWritable(true);
      FileHandler.saveFile(fileName, file);
      Documents documents = documentsRepository.findByEmail(email);
      if (null == documents) {
        documents = new Documents(email, generateImageFileName(documentType.toString(), email),
            documentType);
        documentsRepository.save(documents);

      } else {
        throw new RuntimeException("Documents for email already exit");
      }
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage());
    }
  }

  private String generateImageFileName(String infoType, String email) {
    return new StringBuilder("CMS/").append(infoType).append("/").append(email).append("/")
        .append(infoType).append(".jpg").toString();
  }


}
