/* Abdullah Furkan Erdem 21400803*/
#ifndef RESERVATIONSYSTEM_H
#define RESERVATIONSYSTEM_H


#include "Flight.h"
#include "Seat.h"

#include "Reservation.h"
#include <iostream>
#include <string>
using namespace std;

class Flight;
class Reservation;
class ReservationSystem
{
public:


    ReservationSystem();
    ~ReservationSystem();
    Flight **listOfFlights;
    Reservation  **listOfReservations;
    int sizeOfList;
    int sizeOfReservations;
    int reservationCounter;
    void addFlight( const int flightNo, const int rowNo, const int seatNo );
    void cancelFlight( const int flightNo );
    void showAllFlights();
    void showFlight( const int flightNo );
    int makeReservation(const  int flightNo, const int numPassengers,   int *seatRow,  char *seatCol );
    void cancelReservation(const  int resCode );
    void showReservation( const  int resCode );
    // new function I used
    void addingNewFlightToList(Flight*, int& );
};

#endif // RESERVATIONSYSTEM_H
