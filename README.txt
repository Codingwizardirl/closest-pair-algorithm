========================================
|                                      |
| READ ME FIRST BEFORE GETTING STARTED |
|          By Prachya Boonkwan         |
|         and Naums Mogers             |
|    Email: naums.mogers@ed.ac.uk      |
|                                      |
========================================



HOW TO WORK ON YOUR CODE
========================

Your task is to implement Shamos's Algorithm for finding the 
distance of closest pairs generated at random and compare its runtime
with the naive method. Your code stub is provided in the file
closestPair/StudentCode.java.

You will find two empty methods "closestPair" and "closestPairAux". 
The first method is, as explained in the comment, the preparation step 
for the recursive part of Shamos's Algorithm.  The second method is 
therefore the recursive part which NEEDS to be called in the first 
method.

YOUR TASK: is to fill up these empty methods with your 
implementation of Shamos's Algorithm, which is explained in the 
assignment sheet. Do not run your test script until you make these
methods return some integers, preferably the square distance of the 
closest points. Otherwise, the code will not compile. DO NOT MODIFY
ANY OTHER FILES AS YOUR CODE WILL ONLY BE TESTED ON THE ORIGINAL 
SOFTWARE PACKAGE.

DO NOT delete the top line of the file StudentCode.java which says:

    package closestPair;

This line is very important for compiling.

You do not have to implement the naive method yourself. The naive 
method can simply be called by using the following instruction:

    int sqrDist = PointSet.naiveClosestPair(P);

where P is an instance of PointSet. This method returns the square 
distance of a closest pair of points in P so you need a variable
to store this value.

Your code must have appropriate comments, especially in the 
implementation of Shamos's Algorithm. We also assess your 
understanding based on the comments given to the code.

While implementing the algorithm, you may want, at some point, to
test your code. In that case, you can write a test script that
calls your methods. This will be described in the next section.

DO NOT INCLUDE THE TEST SCRIPT IN THE SUBMITTED TAR FILE. The 
author would like to thank you in advance for your generosity 
but he does have his own hardcore test script.


HOW TO WRITE A TEST SCRIPT
==========================

As aforementioned in the assignment sheet, you are required to test 
your code before submission. Some of you might need help to get 
started with testing.

First, you have to create a file (e.g. call it "test.java") in the 
directory "closestPair". The header for the file looks like the 
following:

    package closestPair;

    public class test {

        public static void main(String[] argv) {
            /* CONTENT OF THE TEST SCRIPT */
        }

    }

Now you can add your test script in the main method. For example,
you can call the closestPairCheck method by this script:

    package closestPair;

    public class test {

        public static void main(String[] argv) {
            ClosestPairToolkit.closestPairCheck(10, 400);
        }

    }

This will run a test on your implementation, given n = 10 and 
t = 400. 

If you would like to test your implementation of the methods
"closestPair" and "closestPairAux", you can call them by the
following instructions.

    int sqrDist = StudentCode.closestPair(P);

and

    int sqrDist = StudentCode.closestPairAux(X, Y);

where P is an instance of PointSet and X and Y are arrays of 
Point instances. Since these methods return the square 
distance of the closest points, we need to have a variable to
store such value. These methods must always be called with 
the prefix "StudentCode" because they are static methods of
the StudentCode class.

DEBUGGING TIP: When something goes wrong with the code, it 
is recommended to make use of a debugging tool. Otherwise, 
you can print out step by step to see what is going on in 
your code. DO NOT FORGET TO REMOVE ALL DEBUGGING MESSAGES
FROM THE CODE BEFORE SUBMISSION.

Some methods may throw an exception. In such case it will be
explicitly expressed in the method's header, such as:

    public static int closestPair(PointSet P)
        throws TrivialClosestPairException, 
               UnknownSortOptionException
    {
        /* CODE ... */
    }

In this case, you have to use the try-catch statement in your
test script. For example,

    /* CODE ... */
    try {
        /* CODE ... */
        int sqrDist = StudentCode.closestPair(P);
        /* CODE ... */
    } catch (TrivialClosestPairException e) {
        e.printStackTrace();
    } catch (UnknownSortOptionException e) {
        e.printStackTrace();
    }
    /* CODE ... */

The Java Compiler is quite fragile as regards to this exception
throwing mechanism.

Then you can compile and run the test script by the following 
commands.

    $ pwd       # Make sure you're in the folder inf2bcw1/src
    /afs/inf.ed.ac.uk/user/s??/s???????/inf2bcw1/src
    $ javac closestPair/*.java      # Compile all files including the test script
    $ java closestPair/test         # Run the test script

In the test script, make sure that your code passes all the 
hardcore tests (by simply running closestPairCheck).

Reminder: DO NOT INCLUDE THE TEST SCRIPT IN THE SUBMITTED 
TAR FILE.



WHAT TO SUBMIT IN THE TAR FILE
==============================

1. Your implementation of Shamos's Algorithm in the file 
   StudentCode.java.
2. The runtime records produced by the method 
   ClosestPairToolkit.getRuntimes -- it MUST be saved as a text file
   called closestPairTimes.
3. The graph plot of the runtimes produced by the method
   ClosestPairToolkit.plotRuntimes -- it MUST be saved as a picture
   called plot.jpg.

Before submission, please make sure that your tar file is NOT
corrupted.



Happy coding,
Prachya and Naums :)
