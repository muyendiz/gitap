/* Abdullah Furkan Erdem 21400803*/
#include <iostream>
#include <string>
#include "Flight.h"
#include "Seat.h"
#include "ReservationSystem.h"
#include "Reservation.h"
using namespace std;

ReservationSystem::ReservationSystem()
{

    ReservationSystem::listOfFlights = new Flight*[0];
    ReservationSystem:: sizeOfList = 0 ;
    ReservationSystem:: listOfReservations = new Reservation*[0];
    ReservationSystem:: sizeOfReservations = 0 ;
    ReservationSystem::reservationCounter= 1 ;

}
ReservationSystem::~ReservationSystem()
{
}
//--------------------------------------------------
void ReservationSystem:: addFlight( const int flightNo, const int rowNo, const int seatNo )
{
    bool exist = 0 ;
    for(int i = 0 ; i< ReservationSystem::sizeOfList; i++)
    {
        if(ReservationSystem::listOfFlights[i]->flightNo==flightNo)
        {
            exist=1;
        }
    }
    if(exist)
    {
        cout <<"Flight "<<flightNo<<" already exists"<<endl;
    }
    else
    {
        Flight* newFlight = new Flight(flightNo, rowNo, seatNo);
        ReservationSystem::addingNewFlightToList(newFlight,ReservationSystem::sizeOfList);
        cout <<"Flight "<<flightNo<<" has been added"<<endl;
    }
}
//--------------------------------------------------
void ReservationSystem::addingNewFlightToList(Flight* newFlight,int& sizeOfList)
{
    Flight ** tempList = new Flight*[sizeOfList+1];

    if(sizeOfList >0)
    {
        for(int i = 0 ; i<sizeOfList; i ++)
        {
            tempList[i] = ReservationSystem:: listOfFlights[i];
        }
    }
    tempList[sizeOfList]=newFlight;
     delete [] ReservationSystem::listOfFlights;
    ReservationSystem::listOfFlights = tempList;
    sizeOfList += 1 ;
}

//-----------------------------------------------------
void  ReservationSystem::cancelFlight( const  int flightNo )
{
    if(ReservationSystem::sizeOfList>0){
    Flight ** tempList = new Flight*[ReservationSystem::sizeOfList-1];


    bool exist = 0 ;
    for(int i = 0 ; i< ReservationSystem::sizeOfList; i++)
    {
        if(ReservationSystem::listOfFlights[i]->flightNo==flightNo)
        {
            exist=1;
        }
    }
    if(!exist)
    {
        cout <<"Flight "<<flightNo<<" does not exists"<<endl;
    }
    else
    {
       for(int i = 0 ; i < ReservationSystem::sizeOfReservations;i++){
            if(flightNo==ReservationSystem::listOfReservations[i]->flightNo){
                ReservationSystem::listOfReservations[i]->reservationNo=0;           }}
        int selected = 0 ;

        for(int i = 0 ; i<ReservationSystem::sizeOfList; i++ )
        {
            if( ReservationSystem::listOfFlights[i]->flightNo == flightNo)
            {
                selected = i ;
            }
        }

        for(int i = 0 ; i< selected; i++ )
        {

            tempList[i] = ReservationSystem:: listOfFlights[i];
        }
        for(int i = selected + 1 ; i< ReservationSystem::sizeOfList; i++ )
        {
            tempList[i-1] = ReservationSystem:: listOfFlights[i];

        }
        delete [] ReservationSystem::listOfFlights;
        ReservationSystem::listOfFlights = tempList;
        ReservationSystem::sizeOfList-=1;
        cout <<"Flight "<<flightNo<<" has been canceled"<<endl;
    }}else{cout<<"There is no flight"<<endl;}
}
//----------------------------------------------------------------------
void ReservationSystem:: showAllFlights()
{
    cout<<"Flights currently operated :"<<endl;
    for(int i = 0 ; i<ReservationSystem::sizeOfList; i++)
    {

        cout<< "Flight " << ReservationSystem:: listOfFlights[i]-> flightNo << "  ( "<<ReservationSystem:: listOfFlights[i]->countAvailableSeat()<<" available seats)"<<endl;
    }


}
//------------------------------------------------------------
void ReservationSystem::showFlight(const int flightNo )
{
    bool exist = 0 ;
    for(int i = 0 ; i< ReservationSystem::sizeOfList; i++)
    {
        if((ReservationSystem::listOfFlights[i])->flightNo==flightNo)
        {
            exist=1;
            (ReservationSystem::listOfFlights[i])->flightDisplay();
        }
    }
    if(!exist)
    {
        cout <<"Flight "<<flightNo<<" does not exists"<<endl;
    }


}
//-----------------------------------------------------
int ReservationSystem::makeReservation(const  int flightNo,  const  int numPassengers,   int *seatRow,    char *seatCol )
{
     int selected;
    bool exist = 0 ;
    bool check= 1 ;
    for(int i = 0 ; i<ReservationSystem::sizeOfList; i++)
    {
        if(ReservationSystem::listOfFlights[i]->flightNo==flightNo)
        {
            selected=i;
            exist=1;
        }
    }
    if(!exist)
    {
        cout <<"Flight "<<flightNo<<" does not exist exists"<<endl;
        return 0 ;
    }
    else if(exist)
    {

        for(int i = 0 ; i<  numPassengers; i++)
        {
        int row = *(seatRow+i)-1;
        int col = int(*(seatCol+i))-65;

           if( ReservationSystem::listOfFlights[selected]->planOfSeats[row][col]->availability==0)

            {
                check = 0 ;
                cout<<seatRow[i]<<seatCol[i]<<" ";
            }
        }
        }
        if(check&&exist){
    Reservation* newReservation = new Reservation((ReservationSystem::reservationCounter), flightNo, numPassengers, seatRow, seatCol);
    Reservation** templist = new Reservation*[(ReservationSystem::sizeOfReservations+1)];



        newReservation->setReserved(ReservationSystem::listOfFlights,ReservationSystem::sizeOfList);

        if((ReservationSystem::sizeOfReservations)>0)
        {
            for(int i = 0 ; i<ReservationSystem::sizeOfReservations; i++)
            {
                templist[i] = ReservationSystem::listOfReservations[i];
            }
        }

        templist[ReservationSystem::sizeOfReservations]=newReservation;
        delete [] ReservationSystem::listOfReservations;
        ReservationSystem::listOfReservations = templist;
        ReservationSystem::sizeOfReservations += 1 ;
        ReservationSystem::reservationCounter += 1 ;
        return  ReservationSystem::reservationCounter-1  ;


}
else if(!check)
        {
            cout<<"are not available"<<endl;return -1;
        }
        return -1;
}
//-----------------------------------------------------------------------
void ReservationSystem::cancelReservation( const int resCode )
{
    int selected =0 ;
    bool exist = 0 ;
    for(int i = 0 ; i< ReservationSystem::sizeOfReservations; i++)
    {
        if(ReservationSystem::listOfReservations[i]->reservationNo==resCode)
        {
            exist=1;
        }
    }
    if(!exist)
    {
        cout <<" No reservations are found under code "<<resCode<<endl;
    }
    else
    {

        Reservation ** tempList = new Reservation*[ReservationSystem::sizeOfReservations-1];

        for(int i = 0 ; i<ReservationSystem::sizeOfReservations; i++ )
        {
            if( ReservationSystem::listOfReservations[i]->reservationNo == resCode)
            {
                selected = i ;
                ReservationSystem::listOfReservations[i]->cancelReservation(ReservationSystem::listOfFlights,ReservationSystem::sizeOfList);
            }
        }
        for(int i = 0 ; i< selected; i++ )
        {

            tempList[i] = ReservationSystem:: listOfReservations[i];
        }
        for(int i = selected + 1 ; i< ReservationSystem::sizeOfReservations; i++ )
        {
            tempList[i-1] = ReservationSystem:: listOfReservations[i];

        }
        delete [] ReservationSystem::listOfReservations;
        ReservationSystem::listOfReservations = tempList;
        ReservationSystem::sizeOfReservations-=1;

    }
}
//------------------------------------------------------------------------------------
void ReservationSystem::showReservation( const  int resCode )
{
    bool exist = 0 ;
    for(int i = 0 ; i< ReservationSystem::sizeOfReservations; i++)
    {
        if(ReservationSystem::listOfReservations[i]->reservationNo==resCode)
        {
            exist=1;
        }
    }
    if(!exist)
    {
        cout <<" No reservations under code "<<resCode<<endl;
    }
    else
    {

        for(int i = 0 ; i<ReservationSystem::sizeOfReservations; i++ )
        {
            if(ReservationSystem::listOfReservations[i]->reservationNo == resCode)
            {
                ReservationSystem::listOfReservations[i]->resDisplay();
            }

        }
    }
}
