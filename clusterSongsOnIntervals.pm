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

# A hash map which contains as key song number and as value interval frequencies of 
# that song
my %interval_frequency_map; 

# The number of clusters parameter
my $num_clusters = 5;

# A hashmap which maps song number with cluster number
my %cluster_membership;

# Number of songs processed while creating the interval frequency map
my $song_number;

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
        # Estimate the key given the data
        # &estimate_key();
        # Hack right now, will change after key estimation strategy is defined
        $current_key = 'c';
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
    
    return %interval_frequency_vector;
}

# Gets the cosine similarity between two vectors
sub cosine_sim_a {

    my $vec1 = shift;
    my $vec2 = shift;

    my $num     = 0;
    my $sum_sq1 = 0;
    my $sum_sq2 = 0;

    my @val1 = values %{ $vec1 };
    my @val2 = values %{ $vec2 };

    # determine shortest length vector. This should speed 
    # things up if one vector is considerable longer than
    # the other (i.e. query vector to document vector).

    if ((scalar @val1) > (scalar @val2)) {
	my $tmp  = $vec1;
	   $vec1 = $vec2;
	   $vec2 = $tmp;
    }

    # calculate the cross product

    my $key = undef;
    my $val = undef;

    while (($key, $val) = each %{ $vec1 }) {
	$num += $val * ($$vec2{ $key } || 0);
    }

    # calculate the sum of squares

    my $term = undef;

    foreach $term (@val1) { $sum_sq1 += $term * $term; }
    foreach $term (@val2) { $sum_sq2 += $term * $term; }

    return ( $num / sqrt( $sum_sq1 * $sum_sq2 ));
}


# Read every note stream files and construct interval vectors and note vectors
sub readNoteStreamFiles {
    my @notestream_files = glob("*.nsf");
    
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
        
        # Transpose the key of the song to key of A as a part of the standardization
        my @normalized_note_stream_of_song  = &transposeKey(\@notestream_of_song, $key_of_song, 'a');
       
        my %interval_frequency_vector = &constructIntervalVector(\@normalized_note_stream_of_song);
      
        $interval_frequency_vector{$song_number} = %interval_frequency_vector;
        $song_number += 1; 
    }
}

# Assigns the cluster member ship of a given song Num and puts that value in 
# cluster_membership hashmap
sub assignClusterMemberShip {
    my assignedCluster

}

# This method performs k means clustering over interval frequencies for all songs
sub kMeansClusterSongs {

    # A hashmap containing the centroids of the cluster, a centroid has key = centroid number
    # and value = hashmap of a note stream
    my %centroids;
    
    # Heuristic for initialization, space out the songs into equal width intervals
    # and choose randomly from these intervals 
    my $spacing = int($song_number / $num_clusters);
    
    my $centroid_number = 1;
    
    # Initializing original centroid points
    for (my $i = 1; $i <= $song_number; $i += $spacing)
    {
        my $randomPoint = int(rand($spacing)) + $i;
        $centroids{$centroid_number} = $interval_frequency_map{$randomPoint};
        $centroid_number += 1;
    }
    
    # Hacky convergence criteria, will fix this
    for (my $i = 1; i <= 100; $i++)
    {
        while (my ($songNum, $intervalVector) = each(%interval_frequency_map)) {
            my %intervalFreqVector = %$intervalVector;
            @assignClusterMemberShip(\%intervalFreqVector, \%centroids, $songNum);
            @recomputeClusters(\%centroids);
        }
    }
}

sub main {
    &init_note_degree_map;
    &readNoteStreamFiles;
    &kMeansClusterSongs;
}

&main;
