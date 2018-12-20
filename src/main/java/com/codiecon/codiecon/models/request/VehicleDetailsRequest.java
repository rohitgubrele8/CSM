package com.codiecon.codiecon.models.request;

import com.codiecon.codiecon.models.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicleDetailsRequest {

  @NotEmpty
  private String vehicleNumber;


  private VehicleType vehicleType;

  @NotEmpty
  private String vehicleModel;

  @Email
  private String ownerEmail;

  @NotEmpty
  private String insuranceNumber;


}
