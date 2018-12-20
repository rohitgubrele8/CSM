package com.codiecon.codiecon.service;

import com.codiecon.codiecon.models.request.OwnerDetailsRequest;
import com.codiecon.codiecon.models.vo.OwnerDetailsVo;

public interface OwnerDetailsService {

  public void saveOwnerDetails(OwnerDetailsRequest ownerDetailsRequest);

  public OwnerDetailsVo getOwnerDetails(String email);
}
