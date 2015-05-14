#!/usr/bin/perl
use strict;
use warnings;

use HTTP::Request;
use HTTP::Response;
use LWP::UserAgent;
use HTML::TreeBuilder;
use URI::URL;

my $ua = new LWP::UserAgent;

my $ROBOT_NAME = 'URLReader/1.0';
my $ROBOT_MAIL = 'asanyal4@jhu.edu';

my $request  = new HTTP::Request 'GET' => "http://keylessonline.com/list/hindi";
my $response = $ua->request( $request );

my $html_tree = new HTML::TreeBuilder;

$html_tree->parse($response->content);

open(my $fh, ">" ,"songSources.txt") or die "Could not open file songSources.txt'";

foreach my $item (@{$html_tree->extract_links()})
{
    my $link = shift @$item;
    my $furl = (new URI::URL $link)->abs($response->base);
    
    # We are only interested in the scores that are tabulated in the western music format
    if ($furl =~ "western") 
    {
        print $fh $furl."\n";
    }
}

close ($fh);
