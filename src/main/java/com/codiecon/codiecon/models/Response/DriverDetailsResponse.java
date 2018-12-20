package com.codiecon.codiecon.models.Response;

import com.codiecon.codiecon.models.vo.DriverDetailsVo;

public class DriverDetailsResponse extends BaseResponse{



  public DriverDetailsVo driverDetailsVo;


  public DriverDetailsResponse(boolean success, int status) {
    super(success, status);
  }

  public DriverDetailsResponse(boolean success, int status, DriverDetailsVo driverDetailsVo) {
    super(success, status);
    this.driverDetailsVo = driverDetailsVo;
  }
}
