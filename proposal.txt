#Proposal

###Metadata
Title: *Gorbert* or *Rosebud* 
Developer: *Michael Walker*


###Project Overview
Goal: Simplify/expediate identification of a film from a quote

Features:
* identify a film by speaking or writing a quote -- speech to text recognition or text input field as a search bar
  * save quotes as favorites -- store favorites in a local sql database for the user
  * view top rated, most searched quotes -- track statistics of app usage to allow users to view popular content
    * view recommendations based on similar films -- I have absolutely zero idea how to implement something like this; 
    * link to services to stream or purchase a film -- 
  

###Similar Work
Shazam (app) -- I'm aiming for a similar functionality, but shazam is designed to identify songs from an audio clip, whereas my idea aims to identify movie quotes from an audio clip or text input. Several extended features are poached from shazam.
Movie Quotes (app) by Rovingly -- Several quote apps exist, but from what I've seen they all are "quote of the day" type apps or collections of popular movie quotes. The only app I saw that claimed to have similar functionality is the aforementioned app, but when I downloaded it and tested it....it failed to find any quote I gave it. The only result I actually got was from searching a single word. So, arguably, my project aims to be an improvement of this pre-existing one, but I wouldn't quite put it that way.


###Previous Experience
Predominately mobile device programming and other java programming. Potentially some data structures material, but I haven't fully considered those components yet.

###Technology
Android Studio -- manages autoformatting, linting, dependencies (gradle)
Java or Kotlin
SQLite database
Speech to text library, haven't fully investigated the different options. Also been browsing search strategies for locating given lines.
Possibly IMSDB (internet movie script database) or opensubtitles.org -- still determining best  way to acquire the scripts I need.
As far as testing -- never done anything beyond manual testing. Very open to recommendations/procedures. My only thought would be compile a list of expected results to various queries and check the results against that list.

###Risk Areas
* Finding/making accurate transcripts of films    //    found a database of scripts and a database of subtitles -- each of which has part  of the data I need. Also discovered that "post-production scripts" are a thing that exists, and have reached out to major film studios to figure out if/how to obtain them
* potentially using Kotlin    //    wrote a Hello World program, viewed tutorial, read syntax documentation
* implementing speech to text   //    
* android development   //    taken a class, just...less than confident
* SQL   //    same as above, used before, but not intimately familiar
* quickly searching multiple scripts for a given quote    //    largely brainstorming storage/search ideas, read search algorithm documentation; looking for a library that will solve this neatly

###Product Backlog
