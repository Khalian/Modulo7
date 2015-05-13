#!/usr/bin/perl
use strict;
use warnings;

# A hash map of note corresponding to the note degree
# Kind of like the fret number on the A string of a guitar
my %note_degree_map;

# The inverse of the above map, used for quick lookups on keys
my %note_degree_map_inverse;

# The number of nodes in western music
my $num_notes_in_western_music = 12;

# Initializes the note degree map
sub init_note_degree_map {

    # Defines the notes and sharps
    $note_degree_map{'a'} = 1;
    $note_degree_map{'a#'} = 2;
    $note_degree_map{'b'} = 3;
    $note_degree_map{'c'} = 4;
    $note_degree_map{'c#'} = 5;
    $note_degree_map{'d'} = 6;
    $note_degree_map{'d#'} = 7;
    $note_degree_map{'e'} = 8;
    $note_degree_map{'f'} = 9;
    $note_degree_map{'f#'} = 10;
    $note_degree_map{'g'} = 11;
    $note_degree_map{'g#'} = 12;
    # Defines the inverses
    
    $note_degree_map_inverse{1} = 'a';
    $note_degree_map_inverse{2} = 'a#';
    $note_degree_map_inverse{3} = 'b';
    $note_degree_map_inverse{4} = 'c';
    $note_degree_map_inverse{5} = 'c#';
    $note_degree_map_inverse{6} = 'd';
    $note_degree_map_inverse{7} = 'd#';
    $note_degree_map_inverse{8} = 'e';
    $note_degree_map_inverse{9} = 'f';
    $note_degree_map_inverse{10} = 'f#';
    $note_degree_map_inverse{11} = 'g';
    $note_degree_map_inverse{12} = 'g#';
    
    # Defines the flats as well, to maintain harmonic equivalency
    $note_degree_map{'ab'} = 12;
    $note_degree_map{'bb'} = 2;
    $note_degree_map{'db'} = 5;
    $note_degree_map{'eb'} = 7;
    $note_degree_map{'gb'} = 10;        
}

# This method takes a note stream file and then 
sub transposeKey {

    # The current note stream
    my @noteStream = @{$_[0]};

    my @newNoteStream;
    
    # The current key of the song
    my $current_key = $_[1];
    
    # The new key of the song to be acheived
    my $transpose_key = $_[2];
    
    # The interval distance between the new and the old key
    my $interval_distance_of_key = 
        $note_degree_map{$transpose_key} - $note_degree_map{$current_key};
    
    # By definition of key transposition every note in the note stream 
    # will be moved by the interval distance between the old and new keys
    foreach my $note (@noteStream) {
        
        my $note_position = $note_degree_map{$note};
        
        # Occurs if the note in the note stream does not belong to the standard western
        # music set of notes
        if (defined($note_position)) {
            my $new_note_position = 
                $note_position - $interval_distance_of_key % $num_notes_in_western_music;
        
            # This also enforces a standard in which flats are removed. Harmonically
            # equivalent songs are thus standardized (or exactly equal in note streams)
            my $newNote = $note_degree_map_inverse{$new_note_position};
     
            # Insert the new Note Stream       
            push @newNoteStream, $newNote;     
        }       
    }
    
    return @newNoteStream;
}

# Construct a distribution of intervals given a note stream 
sub constructIntervalVector {

    # The current note stream 
    my @noteStream = @{$_[0]};
    
    # Frequencies of the intervals
    my %interval_frequency_vector;
    
    # Initialize the frequencies to 0
    for (my $i = 1; $i <= 12; $i++) 
    {
        $interval_frequency_vector{$i} = 0;
    }   
    
    # A marker note which keeps the previous note position
    my $previousNote = undef;
    
    my $noteNumber = 0;
    
    foreach my $note (@noteStream) 
    {
        if ($noteNumber == 0) 
        {
            $previousNote = $note;
            next;
        }
        
        # Compute the interval between two successive notes
        my $prev_note_position = $note_degree_map{$previousNote};
        my $note_position = $note_degree_map{$note};
        
        my $interval = ($note_position - $prev_note_position) % $num_notes_in_western_music;
        $interval_frequency_vector{$interval} += 1;
        
        $previousNote = $note;
    }
}

# Read every note stream files and construct interval vectors and note vectors
sub readNoteStreamFiles {
    my @notestream_files = glob("*.nsf");
    
    foreach my $filename (@notestream_files) {
    
        # The scale of this particular song associated with this note stream file
        my $scale_of_song;
    
        # The key of this particular song associated with this note stream file
        my $key_of_song;
        
        # The notestream of this particular song
        my @notestream_of_song;
        
        open(my $fh, $filename) or die "Could not open file '$filename' $!";
         
        while (my $line = <$fh>) {
          chomp $line;
          if ($line =~ "Scale") {
             my @scaleLineParts = split /:/, $line;
             $scale_of_song = $scaleLineParts[1];
          } elsif ($line =~ "Key") {
             my @keyLineParts = split /:/, $line;
             $key_of_song = $keyLineParts[1];
          } else {
             # This line is the note stream associated with the song
             @notestream_of_song = split /\s+/, $line; 
          }
        }
        
        # Transpose the key of the song to key of A as a part of the standardization
        my @normalized_note_stream_of_song  = &transposeKey(\@notestream_of_song, $key_of_song, 'a');
        
        # my %intervalFreqs = &constructIntervalVector(\@normalized_note_stream_of_song);
        &constructIntervalVector(\@normalized_note_stream_of_song);
       
    }
}
sub main {
    &init_note_degree_map;
    &readNoteStreamFiles;
}

&main;
