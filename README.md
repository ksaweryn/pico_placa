# pico_placa

I am trying to:

Using object-oriented, tested code using the language that you feel most proficient in, please write a "pico y placa" predictor. The inputs should be a license plate number (the full
number, not the last digit), a date (as a String), and a time, and the program will return whether or not that car can be on the road.

This program uses maven version 3.5.2 and java version 8u152-zulu
To compile please use:
mvn clean install

After building the jar plese run the program. 
Open your terminal/cmd and execute:

`$ cd target

$ java -jar pico-placa-1.0.0-SNAPSHOT.jar vehicleLicense date time`

E.g.,

java -jar pico-placa-1.0.0-SNAPSHOT.jar PTJ0001 10-03-2018 19:15

Please replace the input arguments as requiered.
