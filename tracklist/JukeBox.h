#ifndef JUKEBOX_H
#define JUKEBOX_H
#include <iostream>
#include <string>
using namespace std;

class JukeBox
{

 public:
 JukeBox();
 ~JukeBox();
 void addTrack( string trackTitle, int releaseYear );
void removeTrack( string trackTitle );
void addMusician( string trackTitle, string musicianFirstName,
string musicianLastName, string musicianRole );
void removeMusician( string trackTitle, string musicianFirstName,
string musicianLastName );
void showAllTracks();
void showTrack( string trackTitle );
void showMusicianRoles( string musicianFirstName,string musicianLastName );void convertToSmall(string& input);

    private:
        struct Track{
            Track():nextTrack(NULL),headOfListMusician(NULL){}
        string title;
        int year;
        Track * nextTrack;

        struct Musician{
            Musician():nextMusician(NULL){}
        string firstName;
        string lastName;
        string roleOfMusician;
        Musician* nextMusician;
        };

        Musician* headOfListMusician;


        };

        Track* headOfListTrack;

};

#endif // JUKEBOX_H
