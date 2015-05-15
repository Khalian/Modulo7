# Modulo7
A semantic and technical analysis of musical scores based on Information Retrieval Principles

Pipeline Usage:

1. perl build_song_sources_crawler.pm
This creates song_sources.txt

2. perl music_score_crawler.pm
Reads song_sources.txt and creates .nsf and .lyrics files

3. perl lyrics_analyzer.pm
Reads .lyrics files. Menu driven and self explanatory

4. perl notes_analyzer.pm
Reads .nsf files. Menu driven and self explanatory

5. rm *.lyrics *.nsf
To clean up workspace of data files, optionally remove song_sources.txt
