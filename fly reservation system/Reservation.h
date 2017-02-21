/* Abdullah Furkan Erdem 21400803*/
#ifndef RESERVATION_H
#define RESERVATION_H
#include "Seat.h"
#include "ReservationSystem.h"
#include "Flight.h"
#include <iostream>
#include <string>
using namespace std;
class Flight;
class Reservation
{
public:

    Reservation( int, const int, const int,  int*, char*);

    virtual ~Reservation();

    int flightNo;
    int numPassengers;
   int *seatRow;
    int reservationNo;
     char *seatCol;
    void resDisplay();
    void setReserved(Flight **,int);
    void cancelReservation(Flight **, int);
    bool checkReservation(Flight **, int);


};

#endif // REsERVATION_H

