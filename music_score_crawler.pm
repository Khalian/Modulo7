#!/usr/bin/perl
use strict;
use warnings;

use HTTP::Request;
use HTTP::Response;
use LWP::UserAgent;
use HTML::TreeBuilder;

# This code is used to obtain the key and the notes for a given song. This can be used as 
# a prerequisite for other code

# The scale of the songs
my $scale = undef;

# The key used in the song
my $key = undef;

# The song is characterized by the note stream, or the stream of notes
my @noteStream;

# The song's lyrics is categorized by a single vector
my @lyricsOfSong;

my $ROBOT_NAME = 'NoteStreamReader/1.0';
my $ROBOT_MAIL = 'asanyal4@jhu.edu';

my $ua = new LWP::UserAgent;  # create an new LWP::UserAgent
$ua->agent( $ROBOT_NAME );    # identify who we are
$ua->from ( $ROBOT_MAIL );    # and give an email address in case anyone would
                              # like to complain
                  
# A hash map of note corresponding to the set of notes in western classical
my %note_map;
            
# Defines the notes and sharps
$note_map{'a'} = 1;
$note_map{'a#'} = 1;
$note_map{'b'} = 1;
$note_map{'c'} = 1;
$note_map{'c#'} = 1;
$note_map{'d'} = 1;
$note_map{'d#'} = 1;
$note_map{'e'} = 1;
$note_map{'f'} = 1;
$note_map{'f#'} = 1;
$note_map{'g'} = 1;
$note_map{'g#'} = 1;

# Defines the flats as well, to maintain harmonic equivalency
$note_map{'ab'} = 1;
$note_map{'bb'} = 1;
$note_map{'db'} = 1;
$note_map{'eb'} = 1;
$note_map{'gb'} = 1;        

                              
# Some phrases and words that are parsed by the crawler which are not part of the lyrics of a song  
my %metaDataWordHashMap;
                            
my @metaDataWords = ("Keyless", "Online", "Home", "This", "work", "is", "licensed", "under", "a", "Creative", 
                     "Commons", "Attribution-NonCommercial-ShareAlike", "2.5", 
                     "License.", "About", "Us", "Contact", "|", "Transpose:-3",
                     "See", "Legend", "details)Band", "version", 
                     "(notes", "prelude/interludes", "bar-by-bar", "chords", "License", 
                     "Yahoo", "Group", "External", "Links", "Pallavi", "Music", "GroupSankara",
                     "Eye", "FoundationSankara", "NethralayaUdavum", "KarangalChords", "names", 
                     "symbols", "Enter", "search", "termsSubmit", "form", "News", "Language", 
                     "Attribution", "NonCommercial", "ShareAlike", "NotesTamilHindiTeluguKannadaMalayalamKids", 
                     "CornerCarnaticMiscDevotionalEnglish", "Request", "SongLegendFAQKEYLESS", "(SeeLegendfor",
                     "details)Meter", ":", "version(notes", "bar", "chords)PallaviAaj");

# Initialize the word for a fast lookup when constructing lyrics
foreach my $word (@metaDataWords) 
{
    $metaDataWordHashMap{$word} = 1;
}

# Reads the songSources.txt file one by one and get the notestreams
my $fileNumber = 0;                              
open(FILE, "song_sources.txt") or die ("Cant open the song listings");
print "Reading lyrics and notes from contents song_sources.txt \n";
while(<FILE>){                   
    my $link = $_;
    chomp $link;
    
    print "Processing link ", $link, "\n";
   
    my $request  = new HTTP::Request 'GET' => $link;
    my $response = $ua->request( $request );

    my $html_tree = new HTML::TreeBuilder;

    # Make tree
    $html_tree->parse($response->content);

    # Elementify the tree
    $html_tree->elementify();

    # Extract the body element from the elementified tree
    my @body = $html_tree->look_down("_tag", "body");

    # The body Contents variable
    my $bodyContents = "";

    # Fetch the body contents, removes the tags
    foreach my $elem (@body)
    {
        $bodyContents.= $elem->as_trimmed_text();
    }

    # Removes all the non ASCII Chars from the text
    $bodyContents =~ tr/\x80-\xFF//d;

    my @bodyElements = split /[-<>.,~\s+]/, $bodyContents;
    my @bodyElementsScaleRef = split /\s+/, $bodyContents;

    my $line_number = 0;
    my $scale_key_info_linenumber = 0;
    
    # One pass to get the scale
    foreach (@bodyElementsScaleRef) {
       my $elem = $_;
       
       chomp $elem;
       
       if ($elem =~ "Scale") {
          # According to the nature of the inputs, the scale resides in the next line
          $scale_key_info_linenumber = $line_number + 1;
       }
       
       $line_number += 1;
    }

    # Reset line number for second pass
    $line_number = 0;

    # Second pass for parsing notestream and lyrics stream
    foreach (@bodyElements)
    {
       my $elem = $_;
       
       chomp $elem;
       
       if (length($elem) == 1 and $elem =~ m/[a-zA-Z]/ and exists $note_map{lc($elem)}){
          push @noteStream, lc($elem);
       } elsif (length($elem) == 2 and $elem =~ m/[a-zA-Z]#/ and exists $note_map{lcfirst($elem)}) {
          push @noteStream, lcfirst($elem);
       } elsif (length($elem) == 2 and $elem =~ m/[a-zA-Z]b/) {
          push @noteStream, lcfirst($elem);
       } elsif ($elem =~ "Scale") {
          # This is done in pass 1 so continue
          $line_number += 1;
          next;
       } elsif(!exists $metaDataWordHashMap{$elem}) {
          # If its a component of the lyrics then just add that to the lyrics of the song
          if (length($elem) > 0 and $elem !~ m/[0-9]/) {
             
             # At this point we do some corruption checks, not every note has 
             # been correctly acquired and some have been Erroneously concatenated
             
             if ($elem =~ "#")
             {
                my @uncorruptedNotes = split /(?<=\#)/, $elem;
                foreach (@uncorruptedNotes)
                {
                    my $note = $_;
                    if (exists $note_map{lc($elem)})
                    {
                        push @noteStream, lcfirst($_);
                    }
                }
                next;
             } elsif (length($elem) == 2 and substr($elem, 1, 1) =~ "m") {
                # Ignore chords, analysis is only on melody lines
                next
             }       
             push @lyricsOfSong, $elem;
          }
       }
       
       $line_number += 1;
    }

    my $scaleKeyInfo = $bodyElementsScaleRef[$scale_key_info_linenumber];

    $key = lc(substr($scaleKeyInfo, 0, 1));
    my $scaleLetter = substr($scaleKeyInfo, 1, 1);

    # As of this moment i am only supporting minor and major scales
    if ($scaleLetter eq "m") {
        $scale = "MINOR"; 
    } elsif ($scaleLetter eq "M") {
        $scale = "MAJOR";
    } else {
        # Heuristic: Most songs are in minor scale
        $scale = "MINOR";
    }
    
    open(my $notesFile, ">", "NotesOf".$fileNumber.".nsf");
    
    print "Creating notestream file:", "NotesOf".$fileNumber.".nsf", "\n";
    
    print $notesFile "Scale:".$scale."\n";
    print $notesFile "Key:".$key."\n";

    foreach (@noteStream) 
    {
        print $notesFile $_." ";    
    }
    
    close($notesFile);
    
    print "Creating lyrics file:", "LyricsOf".$fileNumber.".lyrics", "\n";
    
    open(my $lyricsFile, ">", "LyricsOf".$fileNumber.".lyrics");

    foreach (@lyricsOfSong) 
    {
        print $lyricsFile $_." ";    
    }
    
    close($lyricsFile);
    
    $fileNumber += 1;
    
}

close FILE;                      #close the file.
