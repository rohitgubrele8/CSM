package com.codiecon.codiecon.controller;

import com.codiecon.codiecon.models.Response.BaseResponse;
import com.codiecon.codiecon.models.Response.OtpResponse;
import com.codiecon.codiecon.models.enums.DocumentType;
import com.codiecon.codiecon.models.request.DocumentSubmitRequest;
import com.codiecon.codiecon.models.request.OtpRequest;
import com.codiecon.codiecon.service.SignUpService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Api(value = "documentController", description = "OtpFlow")
@RestController
@RequestMapping(value = "/documents")
public class DocumentController {

  @Autowired
  SignUpService signUpService;

  @RequestMapping(value = "/upload", method = RequestMethod.POST, produces =
      MediaType.APPLICATION_JSON_VALUE)
  public BaseResponse uploadDocuments(@RequestBody MultipartFile file, @RequestParam("email") String email,
      @RequestParam("documentType") String documentType) {
    signUpService.uploadDocuments(file,email, DocumentType.valueOf(documentType));
    return new BaseResponse(true, HttpStatus.OK.value());
  }

}
