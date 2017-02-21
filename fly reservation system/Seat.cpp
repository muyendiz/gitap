/* Abdullah Furkan Erdem 21400803*/
#include <iostream>
#include <string>
#include "Flight.h"
#include "Seat.h"
#include "ReservationSystem.h"
#include "Reservation.h"
using namespace std;

Seat::Seat()
{
    Seat::availability=1;//ctor
}

Seat::~Seat()
{
    //dtor
}
void Seat::reserveSeat(){
Seat::availability = 0;
}
   void Seat::cancelSeat(){
   Seat::availability = 1;
   }
