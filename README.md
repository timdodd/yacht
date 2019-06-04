

#  Yacht

This code is a subset of the functionality of Yacht. It provides an api to evaluate what options are available and the associated scores for a collection of dies.

```
  Yachts.options(List<Die> dice);
```

The RuleDefinitions class provides a good overview of the Yacht rules that are supported, how they are determined to be present, and how they are scored.


## Technology used

This was coded in Java 8 and make heavy use of the Java 8 functional apis given the nature of this problem. 

This project uses maven.

This project uses lombok to eliminate java boilerplate (getters, setters etc). Lombok instruments your code at compile time to add the necessary operations into the compiled java. 

For intellij
 - install the lombok plug
 - enable 'annotation processing' for the project
 
For eclipse
 - install the lombok plugin  
 
## Command line

To build and run from the command line run (maven must be installed on your computer and on your PATH):

```
  mvn clean compile test
```



