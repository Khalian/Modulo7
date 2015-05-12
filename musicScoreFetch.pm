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

my $ua = new LWP::UserAgent;

my $ROBOT_NAME = 'SheetReader/1.0';
my $ROBOT_MAIL = 'asanyal4@jhu.edu';

my $ua = new LWP::UserAgent;  # create an new LWP::UserAgent
$ua->agent( $ROBOT_NAME );    # identify who we are
$ua->from ( $ROBOT_MAIL );    # and give an email address in case anyone would
                              # like to complain

# Reads the songSources.txt file one by one and get the notestreams
my $fileNumber = 0;                              
open(FILE, "songSources.txt") or die ("Cant open the song listings");
while(<FILE>){                   
    $link = $_;
    chomp $link;
   
    my $request  = new HTTP::Request 'GET' => $link;
    my $response = $ua->request( $request );

    my $html_tree = new HTML::TreeBuilder;

    # Code to check if the body is properly 
    #if ($response->is_success) {
    #    print $response->content;
    #} else {
    #    print "Error: ". $response->code." ".$response->message; 
    #}

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

    my @bodyElements = split /\s+/, $bodyContents;

    my $line_number = 0;
    my $scale_key_info_linenumber = 0;

    foreach (@bodyElements)
    {
       my $elem = $_;
       
       if (length($elem) == 1 and $elem =~ m/[a-zA-Z]/) {
          push @noteStream, lc($elem);
       } elsif (length($elem) == 2 and $elem =~ m/[a-zA-Z]#/) {
          push @noteStream, lcfirst($elem);
       } elsif ($elem =~ Scale) {
          # According to the nature of the inputs, the scale resides in the next line
          $scale_key_info_linenumber = $line_number + 1;
       }
       
       $line_number += 1;
    }

    $scaleKeyInfo = $bodyElements[$scale_key_info_linenumber];

    $key = lc(substr($scaleKeyInfo, 0, 1));
    $scaleLetter = substr($scaleKeyInfo, 1, 1);

    if ($scaleLetter eq "m") {
        $scale = "MINOR"; 
    } elsif ($scaleLetter eq "M") {
        $scale = "MAJOR";
    }
    
    open(my $notesFile, ">", "NotesOf".$fileNumber.".ns");
    
    print $notesFile "Scale:".$scale."\n";
    print $notesFile "Key:".$key."\n";

    foreach (@noteStream) 
    {
        print $notesFile $_." ";    
    }
    
    close(notesFile);
    
    $fileNumber += 1;
    
}
close FILE;                      #close the file.
