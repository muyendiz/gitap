/* Abdullah Furkan Erdem 21400803*/
#include <iostream>
#include <string>
#include "Flight.h"
#include "Seat.h"
#include "Reservation.h"
#include "ReservationSystem.h"
using namespace std;

Reservation::Reservation( int reservationNo,const int flightNo, const int numPassengers,  int *seatRow,  char *seatCol)
{
    Reservation::flightNo=flightNo;
    Reservation::reservationNo=reservationNo;
    Reservation:: numPassengers=numPassengers;
    Reservation::seatRow=seatRow;
    Reservation::seatCol=seatCol;

}

Reservation::~Reservation()
{
    //dtor
}

void Reservation::resDisplay()
{
    cout<<"Reservation under Code "<<Reservation:: reservationNo<<" in Flight "<<Reservation:: flightNo<<" : ";
    for (int i = 0; i<Reservation::numPassengers; i++)
    {
        cout<<Reservation::seatRow[i]<<" "<<Reservation::seatCol[i]<<" ";
    }
 cout<<endl;
}

void Reservation:: setReserved(Flight ** flightList,int sizeOfList)
{
    for(int i = 0 ; i< sizeOfList ; i ++)
    {

        if(Reservation:: flightNo == flightList[i]->flightNo)
        {

            for(int j=0; j<(Reservation::numPassengers); j++)
            {
                int row = Reservation::seatRow[j]-1;

                int col = (int)(Reservation::seatCol[j])-65;
                flightList[i]->planOfSeats[row][col]->reserveSeat();
            }
        }

    }
}
void Reservation::cancelReservation(Flight ** flightList, int sizeOfList)
{
    cout << "Reservation for the seats ";
    for(int i = 0 ; i< sizeOfList ; i ++)
    {
        if(Reservation::flightNo == flightList[i]->flightNo)
        {
            for(int j=0; j<Reservation:: numPassengers; j++)
            {
                cout<<Reservation::seatRow[j]<<Reservation::seatCol[j]<<" ";
                (flightList[i]->planOfSeats[Reservation::seatRow[j]-1][(int)(Reservation::seatCol[j])-65])->cancelSeat();
            }
            Reservation::reservationNo==0;
        }

    }
    cout<< "are canceled in Flight "<< Reservation::flightNo<< endl;
}




