package com.codiecon.codiecon.models.request;


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
public class VehicleAvailabilityRequest {
  private String vehicleId;

  private String availabilityCode;

}
