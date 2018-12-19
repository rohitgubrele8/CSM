package com.codiecon.codiecon.models.Response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse implements Serializable {

  private static final long serialVersionUID = 1L;

  private boolean success;

  private int status;

  private String errorCode;

  private String errorMessage;

  private int version;

  public BaseResponse(){

  }

  public BaseResponse(boolean success, int status) {
    this.success = success;
    this.status = status;
  }

  public BaseResponse(String errorCode, String errorMessage){
    this.errorCode = errorCode;
    this.errorMessage = errorMessage;
  }

  public BaseResponse(boolean success, int status, String errorMessage) {
    this.success = success;
    this.status = status;
    this.errorMessage = errorMessage;
  }


  public BaseResponse(boolean success, int status, String errorCode, String errorMessage) {
    this.success = success;
    this.status = status;
    this.errorCode = errorCode;
    this.errorMessage = errorMessage;
  }

  public BaseResponse(boolean success, int status, int version) {
    this.success = success;
    this.status = status;
    this.version = version;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public String getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  public int getVersion() {
    return version;
  }

  public void setVersion(int version) {
    this.version = version;
  }


}
