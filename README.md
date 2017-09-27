# prime-number-test
Java program that outputs a multiplication table of prime numbers, the number of primes is read in from the console.

##
Running Application
The application can be run two ways;

- Maven
Firstly you will need to install Maven on the client machine if not already installed, downloadable from [here(https://maven.apache.org/download.cgi)]. Once installed use the terminal to navigate to the prime-number-test/prime-core root folder and run **mvn install**. After receiving the success message navigate to the prime-number-test/app/prime-cli root folder and run **mvn exec:java**. Follow the on screen prompts to generate prime tables.

- Java
I have provided a java application binary that removes the dependency on Maven to run the program, you will still need java installed. To run the binary you should download the prime-cli-app.jar.jar jar file located in prime-number-test/bin/prime-cli-app.jar to your local machine. From the terminal run the following java command and follow the on screen prompts;

```
$JAVA_HOME/bin/java -jar prime-cli-app.jar
```

##
Good Points
- Wiring of all the dependencies is minimised to the main program, this is where you'd expect this type of object construction to reside when not using an IOC container and you would certainly not want this inside the main program objects.

- The prime generator algorithm was compatible with a TDD rhythm dues to the various rules governing primes.

- Command Line Interface Application has been separated from the main program into two projects allowing greater reuse, time permitting I shall add a web based UI and Service API to the project to illustrate the reuse and demonstrate more design skills.

- Each class has a single responsibility, the use of the Strategy pattern allowed the PrimeTable class to delegate the behaviour to a pluggable implementation that implements the PrimeTableFormatter interface. This would allow formats to be changed at runtime without the need for any changes to the dependent code.

- The use of Mockito allowed the tests to just test that specific method behaviour, you do not want to retest code in other classes this would be a maintenance issue on a large project.

##
Future Changes
- I expect there is a more efficient way to generate primes, if I had more time I would carry out some performance testing and see if the execution time was unacceptable. I prefer to allow the design to evolve without over-thinking about performance i.e. produce a design, test performance then refactor if necessary. It is worth noting that if this was a real project we would need to produce some non functional requirements with regards to acceptable response times so the program could be tested properly.

- I think it would make sense to apply the strategy pattern to the multiplication table algorithm too, you may want to build a different table not just multiplication e.g. add.

- I picked the multi-dimensional array as the data structure for implementing the table due to its fast access, if the (still to be written) performance tests failed an alternative structure could be tried.

- The program could use multiple cores and partition the search by running multiple threads to scan through non intersecting blocks of numbers returning the generated primes to some orchestrator thread.

