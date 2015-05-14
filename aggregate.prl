#!/usr/local/bin/perl -w
use FileHandle;
use strict;
my @freq = (16.35, 17.32, 18.35, 19.45, 20.60, 21.83, 23.12, 24.50, 25.96, 27.50, 29.14, 30.87);
my @note = ("c", "c#", "d", "d#", "e", "f", "f#", "g", "g#", "a", "a#", "b");
#we open a set of files which contain unaggregated frequencies
my @notestream_files = sort glob("data/*.txt");
my $file = undef;
foreach my $filename (@notestream_files) {
	#for each file in the set we perform aggregation
	open(my $fh, $filename) or die "Could not open file '$filename' $!";
	#remove the folder prefix in the filename
	$file = substr $filename, 5;
	#open another file which will store the aggregated output
	open(my $fwr, '>', "corpus/$file") or die "Could not open file '$filename' $!";
	#we intend to aggregate frequencies to produce a singe value per 0.25 seconds
	my $limit = 0.25;
	my $aggr = 0;
	my $count = 0;
	print "opened $filename\n";
	while (my $line = <$fh>) {
		chomp $line;
		my @words = split ' ', $line;
		if ($words[0] > $limit) {
			$aggr = $aggr/$count;
			#write one aggregate value for every interval of 0.25 second
			print $fwr "$limit $aggr\n";
			$aggr = 0;
			$count = 0;
			$limit = $limit + 0.25;
		}
		else {
			$aggr += $words[1];
		$count += 1;
		}
	}
	close $fwr;
	print "written corpus/$file\n";
}
