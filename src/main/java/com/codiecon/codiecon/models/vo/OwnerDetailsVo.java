package com.codiecon.codiecon.models.vo;


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
public class OwnerDetailsVo {

  private String ownerId;

  private String name;

  private String email;

  private String contactNumber;

  private String ownerAddress;

  private String zipCode;

  private PaymentDetailsVo paymentDetailsVo;
}
