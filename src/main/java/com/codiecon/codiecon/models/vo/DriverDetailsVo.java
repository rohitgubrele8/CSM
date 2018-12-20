package com.codiecon.codiecon.models.vo;

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
public class DriverDetailsVo {

  private String name;

  private String dlNumber;

  private DLType dlType;

  private String contactNumber;

  private String email;

  private PaymentDetailsVo paymentDetailsVo;
}
