package com.codiecon.codiecon.models.Response;

import com.codiecon.codiecon.models.vo.OwnerDetailsVo;
import com.codiecon.codiecon.models.vo.VehicleDetailsVo;

public class OwnerDetailsResponse extends BaseResponse{

  public OwnerDetailsVo ownerDetailsVo;


  public OwnerDetailsResponse(boolean success, int status) {
    super(success, status);
  }

  public OwnerDetailsResponse(boolean success, int status, OwnerDetailsVo ownerDetailsVo) {
    super(success, status);
    this.ownerDetailsVo = ownerDetailsVo;
  }

}
