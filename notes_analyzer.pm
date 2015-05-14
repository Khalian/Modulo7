#!/usr/bin/perl
use strict;
use warnings;
use Storable qw(dclone);

# A hash map of note corresponding to the note degree
# Kind of like the fret number on the A string of a guitar
my %note_degree_map;

# The inverse of the above map, used for quick lookups on keys
my %note_degree_map_inverse;

# The number of nodes in western music
my $num_notes_in_western_music = 12;

# Number of songs processed while creating the interval frequency map
my $song_number = 1;

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
    
    if (not defined($current_key) or length($current_key) == 0) {
        # Heuristic : Most keys are in C
        $current_key = 'c';
    }
    
    if (not defined($transpose_key) or length($transpose_key) == 0) {
        # Heuristic : Most keys are in C
        $transpose_key = 'c';
    }
    
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

# Read every note stream files and construct interval vectors and note vectors
sub readNoteStreamFiles {

    # Sorted to maintain ordering consistency
    my @notestream_files = sort glob("*.nsf");
    
    $song_number = 1;
    
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
                
        # Frequencies of the intervals
        my %interval_frequency_map;
        
        # Initialize the frequencies to 0
        for (my $i = 1; $i <= 12; $i++) 
        {
            $interval_frequency_map{$i} = 0;
        }   
        
        # A marker note which keeps the previous note position
        my $previousNote = undef;
        
        my $noteNumber = 0;
        
        foreach my $complete_note (@notestream_of_song) 
        {   
            my $note = lc(substr($complete_note, 0, 1));
            
            if ($noteNumber == 0) 
            {
                $previousNote = lc(substr($note, 0, 1));
                $noteNumber += 1;
                next;
            }
            
            # Compute the interval between two successive notes
            my $prev_note_position = $note_degree_map{$previousNote};
            my $note_position = $note_degree_map{$note};
            
            my $interval = ($note_position - $prev_note_position) % $num_notes_in_western_music;
            
            $interval_frequency_map{$interval} += 1;
            
            $previousNote = lc(substr($note, 0, 1));
            
            $noteNumber += 1;
        }
           
        # Apply generic music theory rules to analyze songs
        &analyzeSong(\%interval_frequency_map,  $filename, $scale_of_song);
       
        $song_number += 1; 
    }
}
 
# Method which analyzes a song based on music theory rules   
sub analyzeSong {

    my $interval_vector = shift;    
    
    my %interval_frequencies = %$interval_vector;
    
    my $song_name = shift;
    
    my $scale_of_song = shift;
    
    # Used to measure size of song, required for normalization of emotional measures
    my $total_frequency = 0;
    
    # Objective measure of sadness, happiness quotient of the song, these are indexes
    my $happiness_index = 0;
    my $sadness_index = 0;
    my $power_index = 0;
    my $tension_index = 0;
    
    # Estimate the best frequency and the corresponding interval 
    while (my ($interval, $frequency) = each(%interval_frequencies))
    {
        # If a minor interval, then add to sadness index, minor intervals are odd number intervals except 7
        if ($interval == 1 or $interval == 3 or $interval == 5)
        {
            $sadness_index += $frequency;
        } 
        
        # If a major interval, then add to happiness index, major intervals are even number intervals except 8
        elsif ($interval == 2 or $interval == 4)
        {
            $happiness_index += $frequency;
        }
        
        # If a perfect interval like 5 or 8, use measures that indicate a sense of power to the song
        elsif ($interval == 7 or $interval == 8)
        {
            $power_index += $frequency;
        }
        
        # Corresponds to a tense unresolved tone
        elsif ($interval == 6)
        {
            $tension_index += $frequency;
        }
        
        # Anything higher than interval = 8 indicates strong dissonance, does not contribute too highly to 
        # mood of song
        
        $total_frequency += $frequency;
    }
        
    # Normalize the indices by length of song to allow for relative comparison of moods of songs
    $sadness_index = $sadness_index / $total_frequency;
    $happiness_index = $happiness_index / $total_frequency;
    $power_index = $power_index / $total_frequency;
    $tension_index = $tension_index / $total_frequency;
    
    # Check the scale to add to intent of the song, heuristic add by 0.1
    if ($scale_of_song eq "MAJOR") 
    {
        $happiness_index += 0.1;
    } 
    
    # Minor scale is an expression of sad content
    elsif ($scale_of_song eq "MINOR")
    {
        $sadness_index += 0.05;
    }
    
    print "The indices for song :", $song_name, " are happiness index = ", $happiness_index, 
        " sadness index = ", $sadness_index, " power index = ", $power_index, " tension index = ", $tension_index ,"\n";
} 

sub main {
    print "WELCOME TO NOTES ANALYZER PART \n";
    
    print "Analyzing emotional content of songs store in .nsf files \n";

    &init_note_degree_map;
    &readNoteStreamFiles;
}

&main;
