package com.codiecon.codiecon.models.Response;

import com.codiecon.codiecon.models.enums.VehicleType;
import com.codiecon.codiecon.models.vo.VehicleDetailsVo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class VehicleDetailsResponse extends BaseResponse{

  public List<VehicleDetailsVo> vehicleDetailsVos;

  public VehicleDetailsResponse(boolean success, int status) {
    super(success, status);
  }

  public VehicleDetailsResponse(boolean success, int status, List<VehicleDetailsVo> vehicleDetailsVos) {
    super(success, status);
    this.vehicleDetailsVos = vehicleDetailsVos;
  }
}
