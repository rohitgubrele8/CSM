package com.codiecon.codiecon.models.enums;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public enum  ApplicationStatus {
  PERSONAL_DETAILS_SUBMITTED,
  DOCUMENTS_SUBMITTED,
  OTP_VERIFIED,
  OTP_PENDING,
  REJECTED,
  APPROVED
}
