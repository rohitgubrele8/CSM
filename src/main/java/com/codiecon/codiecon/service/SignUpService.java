package com.codiecon.codiecon.service;

import com.codiecon.codiecon.models.Response.LoginResponse;
import com.codiecon.codiecon.models.enums.DocumentType;
import com.codiecon.codiecon.models.request.DocumentSubmitRequest;
import com.codiecon.codiecon.models.request.LoginRequest;
import com.codiecon.codiecon.models.request.SignUpRequest;
import org.springframework.web.multipart.MultipartFile;


public interface SignUpService {

  public void signUp(SignUpRequest signUpRequest);

  public LoginResponse login(LoginRequest loginRequest);

  public void uploadDocuments(MultipartFile file,String email, DocumentType documentType);

}
