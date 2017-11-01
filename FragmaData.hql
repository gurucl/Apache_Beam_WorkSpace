create table movies(ID int, Name string, Genre string) row format delimited fields terminated by ',' collection items terminated by '\\|';
load data local '/home/hduser/fragma/data/movies.dat' into table movies;
select * from movies limit 5;
