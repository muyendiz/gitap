/* Abdullah Furkan Erdem 21400803*/
#ifndef FLIGHT_H
#define FLIGHT_H

#include "Seat.h"
#include "ReservationSystem.h"
#include "Reservation.h"
#include <iostream>

using namespace std;
class Seat;
class Flight
{
public:
    Flight(int,int,int);

    virtual ~Flight();
    int countAvailableSeat();
    void flightDisplay();
    int flightNo;
    int rowNo;
    int seatNo;
    Seat*** planOfSeats;

};

#endif // FLIGHT_H
