# Modulo7

[![Join the chat at https://gitter.im/Khalian/Modulo7](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/Khalian/Modulo7?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

A semantic and technical analysis of musical scores based on Information Retrieval and SQL principles

OVERVIEW: Modulo7 is an research attempt to build a purely objective music analyzer Music Information Retrieval Engine
using music theory, natural language principles and big data principles along with a SQL like querying interface.

Most Music recommendation engines take into account user feedback for recommendation and analysis
purpose and does not take into account music theory. Modulo7 allows comparisons based on both 
simple and complex rules of music theory and would eventually allow extensible rules to be defined 
by users for comparisons. Standard Users will be able to use simple rules for recommendation and statistics
mining, and power users would be able to define their own custom rules for ranking/search and querying. I hope this paradigm
shift will allow a faster recommendation engine, statistics mining and Music Information Retrieval in general.

Modulo7 will also support a query engine and a big data distributed database like format(using HDFS) and a unified representation
for all forms of music (using a domain specific conversion followed by a serialization via Avro).

Typically a query on this engine will be sql like. An example query will be of the format:-

e.g. ) select sheet_music from MUSIC_DATABASE where melodic_complexity > some value

The measure melodic_complexity is a defined parameter for sheet music format and the above query will acquire all such
songs from the database.

(MODULO7 IS IN ACTIVE DEVELOPMENT AND NOT READY FOR PRODUCTION USAGE).

Modulo7 has the following broad goals:-

1. A crawling engine that acquires information from various recorded form of music
including acoustic sources (.mp3, .midi etc), sheet music images, lyrics etc. The crawling engine will
run as a daemon/service and acquire these information. Third party libraries like Echo Nest, Google API
as well as hand crafted crawling techniques are used for this purpose (STATUS: DEFERRED DUE TO LEGAL ISSUES,
MANUALLY COMPILING DATABASE EARMARKED FOR RESEARCH - UNDER PROCESS)

2. A vector space model for music. These models will represent music in an abstract form
on which standard and customized rules based on music theory can be applied. Concepts like phrasing analysis,
timber and pitch analysis and custom rules (e.g - a higher number of power chords implies chances of the music 
song being a rock or metal song). The vector space model will include custom similarity measure
and extensible similarity measures based on user input on complex music theory rules (STATUS : UNDER CONSTRUCTION)
THIS COMPONENT IS THE BULK OF THE WORK AND THE NOVELTY OF THE PROJECT.

3. An acoustics miner component. The acoustic miner takes files like (.mp3, .midi) etc
and acquires note, pitch, key and other forms of information from the files. These will be then feed 
to the vector space model component. (STATUS : COMPLETED)

4. A sheet music miner component. The sheet miner will take western music sheets of the 
form (.png, .jpeg etc) files and extract the notes, key signature from the images. This information
can then be used to create a (STATUS : COMPLETED)

5. A music xml parser component : It takes files of music XML format and parses the relevant information
from them. (STATUS : COMPLETED)

5. A lyrics analyzer : The lyrics analyzer will take its input from the crawling engine and then make objective
analysis on the lyrics (e.g the vocabulary richness of the song, semantic intent based on context etc).
(STATUS : INDEXER COMPLETE, WORKING ON BASIC QUERY ENGINE FIRST)

7. A query Engine : This engine will parse a query and run it on top of Modulo7 representation (STATUS : UNDER
CONSTRUCTION)

8. A distributed Database : This engine will support a distributed persistent store of the vector space model. (STATUS :
BINARY SERIALIZATION COMPLETE, HDFS CODE NEEDED TO BE WRITTEN)

THE PERL MODULE WAS THE FIRST PROTOTYPE DRAFT OF THE PROJECT AND IS DEPRECATED. THE WHOLE MODULE WILL BE
MOVED TO A DIFFERENT PROJECT IN A FUTURE COMMIT OF THE PROJECT.

For the perl modules do (@Deprecated) : -
cd src/main/perl

Pipeline Usage For Perl:

1. $ perl build_song_sources_crawler.pm
This creates song_sources.txt

2. $ perl music_score_crawler.pm
Reads song_sources.txt and creates .nsf and .lyrics files

3. $ perl lyrics_analyzer.pm
Reads .lyrics files. Menu driven and self explanatory

4. $ perl notes_analyzer.pm
Reads .nsf files. Menu driven and self explanatory

5. $ rm *.lyrics *.nsf
To clean up workspace of data files, optionally remove song_sources.txt

Performing frequency analysis:

1. The software used is "Sonic Visualiser" with the plugin "Melodia".

2. Open any song and apply the transformation using the plugin.

3. Save the layer generated by the plugin as a text file.

4. $ perl aggr.prl
Converts the raw frequency in the text file into its equivalent stream of musical notes.

5. The result of the above operation can be fed to note_analyzer.pm
