package com.codiecon.codiecon.models.vo;

import com.codiecon.codiecon.models.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicleDetailsVo {

  private String Id;

  private String vehicleNumber;

  private VehicleType vehicleType;

  private String vehicleModel;

  private String insuranceNumber;

}
