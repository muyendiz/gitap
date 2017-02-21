#include "JukeBox.h"

JukeBox::JukeBox()
{
   headOfListTrack = NULL;

}

JukeBox::~JukeBox()
{
    //dtor
}




////////////////////////////////////////////////////////////////////////


 void JukeBox::addTrack( string trackTitle, int releaseYear )
 {
     convertToSmall(trackTitle);
     Track * newTrack = new Track();
     newTrack->title=trackTitle;
     newTrack->year=releaseYear;
     Track* cur = headOfListTrack;
     bool available= false;

     if(cur==NULL){headOfListTrack=newTrack;}

     else {while(cur->nextTrack!=NULL){
        if(cur->title==trackTitle){available=true;}
       cur = cur->nextTrack;
     }
     if(!available){
     cur->nextTrack=newTrack;
     } else if(available){cout<<"there is also another track with specified name"<<endl;}}

 }


/////////////////////////////////////////////////////////////////////////////////////////


void JukeBox::removeTrack( string trackTitle ){
Track* cur = headOfListTrack;
bool available = false;
convertToSmall(trackTitle);
if(cur->title==trackTitle){headOfListTrack=cur->nextTrack; delete cur;available=true;}
else {
    while (cur->nextTrack!=NULL){
 if(cur->nextTrack->title==trackTitle)
 {
    available=true;
    cur->nextTrack= cur->nextTrack->nextTrack;
    delete cur->nextTrack;
 }
 cur=cur->nextTrack;
}

}
if(!available){cout<<"There is no track with specified title" <<endl; }

}



////////////////////////////////////////////////////////////////////



void JukeBox::convertToSmall(string& input){
    int length = input.length();
    for(int i = 0 ; i<length; i++){  if((int)(input[i])<97&&(int)(input[i])!=32){ input[i]= input[i]+32;  }}
    }




void JukeBox::addMusician( string trackTitle, string musicianFirstName, string musicianLastName, string musicianRole ){

convertToSmall(trackTitle);convertToSmall(musicianFirstName);convertToSmall(musicianLastName);convertToSmall(musicianRole);

Track* curTrack = headOfListTrack;
Track::Musician* newMusician = new Track::Musician() ;
newMusician->firstName=musicianFirstName;
newMusician->lastName=musicianLastName;
newMusician->roleOfMusician=musicianRole;

bool availableTrack = false;
bool availableMusician = false ;


while (curTrack!=NULL){
 if(curTrack->title==trackTitle)
 {
    availableTrack=true;
    Track::Musician* curMusician = curTrack->headOfListMusician;

    if(curMusician==NULL){curTrack->headOfListMusician=newMusician;}
     else {while(curMusician->nextMusician!=NULL){
        if(curMusician->firstName==musicianFirstName&&curMusician->lastName==musicianLastName){availableMusician=true;}
        curMusician = curMusician->nextMusician;
     }
     if(!availableMusician){
     curMusician->nextMusician=newMusician;}
     else if(availableMusician){cout<<"There is also musician with specified name "<<endl;}

     }
 }

 curTrack=curTrack->nextTrack;
}


if(!availableTrack){cout<<"There is no track with specified title" <<endl; }

}

////////////////////////////////////////////////////////////////////////////////////////




void JukeBox::removeMusician( string trackTitle, string musicianFirstName,string musicianLastName ){
convertToSmall(trackTitle);convertToSmall(musicianFirstName);convertToSmall(musicianLastName);
Track* curTrack = headOfListTrack;
bool availableTrack = false;
bool availableMusician = false ;
while(curTrack!=NULL){
    if(curTrack->title==trackTitle){

        availableTrack=true;
        Track::Musician* curMusician = curTrack->headOfListMusician;
        if(curMusician->firstName==musicianFirstName&&curMusician->lastName==musicianLastName){
                curTrack->headOfListMusician=curMusician->nextMusician; delete curMusician; availableMusician=true;}
    else {
    while (curMusician->nextMusician!=NULL){
 if(curMusician->nextMusician->firstName==musicianFirstName&&curMusician->nextMusician->lastName==musicianLastName)
 {
    availableMusician=true;
    curMusician->nextMusician = curMusician->nextMusician->nextMusician;
    delete curMusician->nextMusician;
 }
 curMusician=curMusician->nextMusician;
}

}
    }
    curTrack = curTrack->nextTrack;
}
if(!availableMusician)cout<<"there is no available Musician with specified name "<<endl;

if(!availableTrack)cout<<"there is no available Track with specified name "<<endl;

}

////////////////////////////////////////////////////////////////////////////////////


void JukeBox::showAllTracks(){
Track* cur = headOfListTrack;
int counter = 0 ;
if(headOfListTrack==NULL){cout<<"----none----"<<endl;}
else
    while (cur!=NULL){
            counter++;
        cout<<cur->title<<" , "<< cur->year<<"  "<<"( for the "<<counter<<" track)" <<endl;
        cur=cur->nextTrack;
    }
}

/////////////////////////////////////////////////////////////////////////////////////



void JukeBox::showTrack( string trackTitle ){

convertToSmall(trackTitle);
int counter = 0 ;
Track* curTrack = headOfListTrack;
bool availableTrack = false;
while(curTrack!=NULL){
    if(curTrack->title==trackTitle){
            availableTrack= true;
            cout<<curTrack->title<< " , "<<curTrack->year <<endl;
            Track::Musician* curMusician = curTrack->headOfListMusician;
            while (curMusician!=NULL){
                counter++ ;
            cout<<curMusician->firstName<< " , "<<curMusician->lastName<< " , "<< curMusician->roleOfMusician << "  ( for the "<<counter<< " musician)"<<endl;
                curMusician=curMusician->nextMusician;
            }
}
curTrack=curTrack->nextTrack;
}
if(!availableTrack){cout<<"There is no track with specified name"<<endl;}
}



///////////////////////////////////////////////////////////////////




void JukeBox::showMusicianRoles( string musicianFirstName,string musicianLastName ){

convertToSmall(musicianFirstName);convertToSmall(musicianLastName);
int counter=0;

Track* curTrack = headOfListTrack;
cout<<musicianFirstName<<" , "<< musicianLastName<<endl;
bool availableMusician = false ;
while(curTrack!=NULL){

Track::Musician* curMusician = curTrack->headOfListMusician;

while (curMusician->nextMusician!=NULL){
 if(curMusician->nextMusician->firstName==musicianFirstName&&curMusician->nextMusician->lastName==musicianLastName)
 {
    availableMusician=true;
    counter++;
    cout<<curMusician->roleOfMusician<< " , "<< curTrack->title << " , " <<curTrack->year<<" (for the  "<< counter <<" musician) "<< endl ;
 }
 curMusician=curMusician->nextMusician;
}
 curTrack = curTrack->nextTrack;
}



if(!availableMusician)cout<<"there is no available Musician with specified name "<<endl;


}





