package com.codiecon.codiecon.models.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OwnerDetailsRequest implements Serializable {

  @NotEmpty
  private String name;

  @NotEmpty
  @Email
  private String email;

  @NotEmpty
  private String contactNumber;

  @NotEmpty
  private String ownerAddress;

  @NotEmpty
  private String zipCode;

  private PaymentDetailsRequest paymentDetailsRequest;

}
