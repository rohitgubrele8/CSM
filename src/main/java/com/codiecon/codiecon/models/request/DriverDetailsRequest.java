package com.codiecon.codiecon.models.request;


import com.codiecon.codiecon.models.enums.DLType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DriverDetailsRequest {

  @NotEmpty
  private String name;

  @NotEmpty
  private String dlNumber;

  private DLType dlType;

  @NotEmpty
  private String contactNumber;

  @NotEmpty
  private String email;

  private PaymentDetailsRequest paymentDetailsRequest;
}
