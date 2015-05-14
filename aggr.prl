#!/usr/local/bin/perl -w
use FileHandle;
use strict;
my @freq = (16.35, 17.32, 18.35, 19.45, 20.60, 21.83, 23.12, 24.50, 25.96, 27.50, 29.14, 30.87, 32.70);
my @note = ("c", "c#", "d", "d#", "e", "f", "f#", "g", "g#", "a", "a#", "b", "c");
#we open a set of files which contain unaggregated frequencies
my @notestream_files = sort glob("data/*.txt");
my $file = undef;
foreach my $filename (@notestream_files) {
	#for each file in the set we perform aggregation
	open(my $fh, $filename) or die "Could not open file '$filename' $!";
	#remove the folder prefix in the filename
	$file = substr $filename, 5;
	$file =~ s/\.txt/\.nsf/;
	#open another file which will store the aggregated output
	open(my $fwr, '>', "corpus/$file") or die "Could not open file '$filename' $!";
	print $fwr "Scale:MINOR\n";
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
			my $flag = 0;
			my $exponent = 0;
			while ($flag==0) {
				if ($aggr<0) { $aggr *= -1;}
				if ($aggr>=0 and $aggr<16.35) { $flag = 1;}
				for (my $i=0; $i<12; $i++) {
					my $avg = ($freq[$i]*(2**$exponent) + $freq[$i+1]*(2**$exponent))/2;
					if($avg>8000) {
						print "err at $aggr \n";
					}
					if ( $aggr>=($freq[$i]*(2**$exponent)) and $aggr<=$avg ) {
						print $fwr "$note[$i] ";
						$flag = 1;
					}
					elsif ( $aggr<($freq[$i+1]*(2**$exponent)) and $aggr>$avg ) {
						print $fwr "$note[$i+1] ";
						$flag = 1;
					}
				}
				$exponent += 1;
			}
			#write one aggregate value for every interval of 0.25 second
			#print $fwr "$aggr ";
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
