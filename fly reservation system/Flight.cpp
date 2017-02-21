/* Abdullah Furkan Erdem 21400803*/
#include <iostream>
#include <string>
#include "Flight.h"
#include "Seat.h"
#include "ReservationSystem.h"
#include "Reservation.h"
using namespace std;

Flight::Flight(int flightNo, int rowNo, int seatNo)
{
    Flight::flightNo = flightNo;
    Flight:: rowNo = rowNo;
    Flight:: seatNo = seatNo;

    Flight:: planOfSeats = new Seat**[rowNo];

    for(int i = 0 ; i<rowNo; i++)
    {
        Flight:: planOfSeats[i]= new Seat*[seatNo];
    }

    for(int i = 0; i < rowNo; i++)
    {

        for(int j = 0 ; j < seatNo; j++ )
        {
            Flight:: planOfSeats[i][j] = new Seat();
        }
    }
}


Flight::~Flight()
{

}

int Flight::countAvailableSeat()
{
    int counts = 0 ;
    for(int i = 0; i < Flight::rowNo; i++)
    {

        for(int j = 0 ; j < Flight::seatNo; j++ )
        {
            if((Flight::planOfSeats)[i][j]->availability)
            {
                counts++;
            }
        }
    }
    return counts;
}

void Flight:: flightDisplay()
{
    cout<<"Flight "<<Flight::flightNo<<" has "<<Flight::countAvailableSeat()<<" available seats"<<endl;
    std::string firstRow = "A B C D E F G H I J K L M N O P Q R S T U V W X Y X Z ";
                      for(int i = 0 ; i < (Flight::rowNo)+1; i++){

        if(i==0)
        {
            cout<<firstRow.substr(0,(Flight::seatNo)*2-1);

        }
        else
        {
            cout<<i<<" ";
            for(int j = 0 ; j < Flight::seatNo; j++)
            {

                if(Flight::planOfSeats[i-1][j]->availability)
                {
                    cout<<" o ";
                }
                else
                {

                    cout<<" x ";
                }
            }
        }
        cout<<endl;

    }
}
