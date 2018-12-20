package com.codiecon.codiecon.models.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = PaymentDetails.TABLE_NAME)
public class PaymentDetails {

  private static final long serialVersionUID = 1L;
  public static final String TABLE_NAME = "paymentDetails";
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid")
  private String id;

  @Column(nullable = false)
  private String userId;

  @Column(nullable = false)
  private String bankAccountNumber;

  @Column(nullable = false)
  private String branchName;

  @Column(nullable = false)
  private String bankName;

  private  boolean markForDelete;

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    PaymentDetails that = (PaymentDetails) o;
    return Objects.equals(id, that.id) && Objects.equals(userId, that.userId) && Objects
        .equals(bankAccountNumber, that.bankAccountNumber) && Objects
        .equals(branchName, that.branchName) && Objects.equals(bankName, that.bankName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, userId, bankAccountNumber, branchName, bankName);
  }
}
