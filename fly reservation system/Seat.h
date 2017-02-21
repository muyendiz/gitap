/* Abdullah Furkan Erdem 21400803*/
#ifndef SEAT_H
#define SEAT_H
#include <iostream>
#include <string>
#include "Flight.h"

#include "ReservationSystem.h"
#include "Reservation.h"
using namespace std;

class Seat
{
    public:
        Seat();
        virtual ~Seat();
        bool availability;
  void reserveSeat();
   void cancelSeat();
};

#endif // SEAT_H
