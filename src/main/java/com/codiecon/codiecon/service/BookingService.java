package com.codiecon.codiecon.service;

import com.codiecon.codiecon.models.request.BookingRequest;

public interface BookingService {

  boolean bookVehicle(BookingRequest bookingRequest);
}
