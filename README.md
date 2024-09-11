Short summarize:
App that gets statistics for which players played
the most together in common matches and their duration.
Which resultet by my thinking all matches time to be 90, because I want only the most played time together by players, which equal to full time match played

*Rabbit holes:

1. record csv file name - record as in java.lang, signature rename post needed
2. Time-Date-Formats
3. toMinutes - Null
4. foreign keys - needed or not
5. player stats - persisted or no?
6. dataReadServices - one-way - in from csv or two-way
7. Validations - sql(nullable=false) or@NonNull for ints or @NotBlank for strings, @Valid for requests,bodies
8. Custom error handling - not quite implemented, not enough knowledge


Flow of building:

Entities :
1. Team - because it is the only one without foreign keys.
2. Player - only one foreign key to team
3. Match - 2 fk - teamAId, teamBId, reworked to no foreign keys
4. Record - 2 fk , one of which is another 2fks inside - playedId,matchId(aTeamId,bTeamId) also the only one where data column can be nullable,
5. reworked to no foreign keys because of useless complexity

Repositories and services for each csv file(entity)

New entity - PlayerTogetherStats :
1. Self id - auto_increment/generate
2. p1 Id
3. p2 id
4. minutes played tg
5. match id

The god service - PlayerTgStatService:
3 util classes because it became too big and logic started 
failing
1. PlayerOverlapCalculator - calcs if the players met,for how long, do they overlap from records
2. PlayerPairStats - persists the data from overlapCalc
3. PlayerStatsCalculator - puts it all together through 2 maps holding overlap records ( max and pairs) and does the magic though
iterating the list of all input records from record repository.


I've given serious though about mapping the tables by foreign keys, custom error handling, using lombok not vanilla, but personally was not satisfied by the data download from classroom, to go to print->then pdf safe->then from pdf to csv. Very bad start of the assignment, kinda boring working with those csv files, overall the mid-exam tasks were far superior to this one.
Not happy about the lack of deep coverage of spring. Overall i've learned a lot in a short period of time but lacking the brutal exercise we got when we were learning loops, could have been beneficial a lot.

