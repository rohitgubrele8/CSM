package com.codiecon.codiecon.models.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentDetailsRequest {

  @NotEmpty
  private String bankAccountNumber;

  @NotEmpty
  private String branchName;

  @NotEmpty
  private String bankName;

}
