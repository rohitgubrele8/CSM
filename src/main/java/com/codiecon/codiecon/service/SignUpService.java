package com.codiecon.codiecon.service;

import com.codiecon.codiecon.models.Response.LoginResponse;
import com.codiecon.codiecon.models.request.LoginRequest;
import com.codiecon.codiecon.models.request.SignUpRequest;


public interface SignUpService {

  public void signUp(SignUpRequest signUpRequest);

  public LoginResponse login(LoginRequest loginRequest);
}
