# ECM1410: Object Oriented Programming
**Week 02: Java Basics Practice**


### 1. Coding `HelloWorldApp.java`

#### 1.1 Setting up the CodeSpaces workspace

Accept the GitHub assignment for workshop 2, and open it in CodeSpaces.

#### 1.2 Create the source code

Open the file `HelloWorldApp.java`

Add the following content to the file:

```java
// HelloWorld application
public class HelloWorldApp {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
```

Note: If you find yourself copying code from a pdf file or online, you may see compile time error (e.g., illegal character). This is because some special characters (such as double quote, single quote) are coded in different way (or may be misformatted). You may fix it by deleting and retyping these special characters.

#### 1.3 Compile the source code

In the Terminal panel (lower half of the screen) type the following to compile the program, then press enter:

```
>> javac HelloWorldApp.java
```

(Note the prompt where you type on the command line is `$` in the CodeSpaces Terminal panel, but we will use `>>` to represent it 
 
If the compilation is successful, the compiler will generate a file named
`HelloWorldApp.class` in the same directory as the Java source file.

This class file contains the Java Byte Code we discussed in the first lecture.
If the compilation failed, try to fix it yourself by reading the error message. 

Ask one of the teaching team (or neighbour) if you are not able to fix the problem.

#### 1.4 Run the program

At this point you should have successfully generated the java byte code (`HelloWorldApp.class`), we may pass it to the Java virtual Machine (JVM) to be interpreted and run. 

To do this use the command line prompt in the Terminal panel. Type the following to compile the program, then press enter:

```
>> java HelloWorldApp
```

#### 1.5 Modify the code

Feel free to try and change the message from “Hello World!” to something else. You’ll need to recompile and rerun the resulting file in order to see the effects of your changes each time.

Let’s do something cool! How about we adapt the code so we can pass in your name and age from the terminal and let the program prints them out. 

We can access the arguments used when the program is executed, by accessing the strings array `args` object that is defined on the function definition line: 

We can access individual string objects from this array use code like `args[0]` and `args[1]` etc.

Adapt the program to update it with the code below

```java
System.out.println("Hello World! My name is " + args[0] + ".")
```

Recompile and run the program, passing your name as an argument. 

```
>> java HelloWorldApp YOURNAME
```

You should see the following:

```
Hello World! My name is YOURNAME. 
```

Note that in addition to `System.out.println` java has the command `System.out.print` (which prints without ending with a newline) and is useful if we want to build up output in stages.

e.g. we can use this to rewrite our code in the following way (note how the final section uses `println` to end the line.)

```java
System.out.print("Hello World! My name is ");
System.out.print(args[0]);
System.out.println(".")
```

**Task**

Adapt the code so you can run the program using:

```
>> java HelloWorldApp YOURNAME YOURAGE
```

So that the output is:

```
Hello World! My name is YOURNAME. I am YOURAGE years old.
```

Experiment with your code. What happens if you pass a single argument? What about three arguments? In later sessions we will learn how to write code that can adapt to different situations.


When you have completed this, please commit your work to upload it to the classroom.

### 2. Coding `VariablesTest.java`

#### 1. literals

In this activity we will explore some different Java literals (boolean /  numerical / string data).

Right click in the Files panel and select **New File**. 

Name the file: `VariablesTest.java` and use the following template code as a starting point.

```java
// VariablesTest application
public class VariablesTest {
    public static void main(String[] args) {
        int x = 4
    
    }
}
```

Add a second line of code to display the value of variable `x`.

```java
        System.out.println("x: " + x);
```

Recompile and run the code, and check the output is as expected.

**Explore**

See what happens if you change the double quotes `" "` to single quotes `' '` (hint. you will have to change them back to get your code to work!)

Now add the two of the lines of code below. Then add two further lines to print the values associated with the following statements following the format used above (*`name: value`*)

```java
byte s_per_min = 60;
long s_per_day = (s_per_min * 60 * 24);
```

**Explore**

See what happens if you switch round the types of the last two statements i.e.

```java
long s_per_min = 60;
byte s_per_day = (s_per_min * 60 * 24);
```

You will see an error because Java detects you are taking a calculation involving `long` type integers, and storing the result in a `byte` type integer which has a much smaller range (so that only 8 bits of the 64 bit `long` number can be stored). 

In certain cases we may wish to override this error, to force conversion. We can do this by adding code that indicates we explicitly wish to convert the result to a `byte` object.

```java
long s_per_min = 60;
byte s_per_day = (byte) (s_per_min * 60 * 24);
```

If you look at the result you will see the conversion down to 8-bits means the result is stored changes. 

It is important to be aware of some of the behaviours of Java. The example statements include other variable assignments in which the resulting value stored may differ from your expectations. 

Add the following to your file and display their values (again using format *`name: value`*). 

```java
float area = 20.3F
char a = '\u5468', b = '\\';
int nHours = 022;
double ratio = 7/5;
```

#### 2. Numerical precision

The calculations for `d1` and `d2` should both result in value `2900`. However the calculations use floating point numbers that during processing are converted into and back from binary representations, in which small rounding errors can develop. (The maximum level of precision will depend on the amount of memory allocated to each value).

Add the following to the bottom of your code, and you should see this effect in action.

```java
double d1 = 0.29/0.0001;
double d2 = 0.00029*1.0e7;
System.out.println("d1: " + d1);
System.out.println("d2: " + d1);
```

An issue related to this can occur if we try to test floating point numbers for equality. Add the following line to your code, that checks if `d1` and `d2` store the same value.

```java
System.out.println("d1 equals d2: " + (d1 == d2) );
```

When I run this code the test evaluates to `false` (even though they both display as the same value!). It is important to remember that even neglibly small differences can affect a test comparing the values of floating point numbers. 

For this reason while we may use an equality test on integer values, we avoid them for floating point numbers. Instead code similar to the following can be used to check if floating point numbers store the same value to a given tolerance.

```java
double epsilon = 1e-10;
if (Math.abs(d1 - d2) < epsilon) {
    System.out.print("d1,d2 differ by less than ");
    System.out.println( epsilon );
}    
```

**Explore**

What happens if you do not declare that `epsilon` is a `double`, i.e. modify your line to:

```java
epsilon = 1e-10;
```

It is useful to get familiar with the resulting errors that are shown during compilation especially if you are transferring from Python where you do not have to explicitly declare object types when they are created.

If you haven't already experienced it, find out what happens if you remove one of the semi-colons `;` from the code.

### 3 Coding `MyBirthday.java`

#### 3.1 The problem

In this exercise we will assume that we are near the start of our birthday month, where our birthday is near to the end of the current month. We decide to write a program to calculate on which weekday our birthday.

We will do this by using the following variables:

 - the **current week day** ( `int` in range 0-6 )
 - the **current date in the month** ( `int` in range 1-31 ) 
 - the **date of our birthday** (`int` in range 1-31 )

The weekday values uses the following mapping: 0 Sun, 1 Mon, 2 Tues ...  

We will try to calculate:

  - the **week day our birthday falls on** (int in range 0-6) 

#### Example

Let's use the following example to test our code:

Today's date: **Tues 7th Jan**

Birthday: **23rd January** (which will be a **Thursday**) 

i.e. 

with variables `2`, `7`, `23` we expect to get result `4`.

#### 3.2 Writing the program

Create new file `MyBirthday.java` in your codespace working directory.

You may start with the following template code. Note how the variable names have been chosen to describe the content they store. 

Note also how values which will remain constant can be defined through the `final` specifier. 

*(Why do think it is useful for the compiler to be given this information?)*

```java
// MyBirthday application
public class MyBirthday {
    public static void main(String[] args) {
        int currentDay = 2; 
        int currentDate = 7; 
        int myBirthdayDate = 23; 

        // value below is a constant
        final int DAYS_A_WEEK = 7; 
        
        // Tasks

        // 1. calc number of days from current date
        //    to birthday 


        // 2. use this along with the current weekday 
        //    to find when the birthday falls


        // 3. Display the result
    

    }
}
```

For part `2.` recall the modulo operator `%` that finds the remainder after an integer division, 

e.g. `23%10` gives `3` and `15%7` gives `1`. 

This can be used to convert a weekday calculation, 

e.g. if the current day is Friday (5) in eleven days time the weekday will be `(11+5)%7` = `16%7` = `2` i.e. a Tuesday.

#### 3.3 Extending the functionality

To make this more useful we might try to adapt the code so the compiled program can be called with arguments to specify other situations.

You will find that the same code as we used earlier will not work:

```
int currentDay = args[0];
```

This is because, as indicated in the function definition, the arguments are in the form of a string array, and we need to convert these into numerical type if we are to utilise them in calculations.

To convert the string to an integer we can use the following code:

```java
int currentDay = Integer.ParseInt(args[0]);
```

Edit your code so that it can be used with different inputs. Check that for the following inputs your code matches the output below:

```
>> java MyBirthday 2 7 23
Birthday falls on: 4
```

**Explore**

Consider how you could reduce the memory requirements of your code by using alternative variable types. Do you think this process would be worth doing in practise?

### 4 Coding `RectangleComputation.java`

In the lecture you were set a task of coding a program that could find the area, radius and perimeter of a circle.

Add an additional file to your workspace called `RectangleComputation.java` 

In this file write a program that will take two arguments, containing the height and width of a rectangle (as doubles).

Your program should print out the area and perimeter of a rectangle and display the result in the format below:

```
shape: rectangle
area: XXXXX
perimeter: XXXXX
```

You do not have the round or format the results.

As an extension add code that declare a boolean variable `isSquare`.
Assign a value to it depending on the ratio between the height and width.
If the ratio equals to 1 (to a tolerance of 0.1%)  `isSquare` should be set to `true`, and `false` otherwise.

Use the value of `isSquare` to correctly identify the shape in the first line of the output (i.e. so it will print `shape: square` for a square and `rectangle` otherwise. 

Notes: 

 - Use the correct way of testing floats for equality, as mentioned above.
 - The syntax for `if`-`else` statement in Java is as follows.

```
if (condition) {

    ...

} else {
    
    ...

}
```

### 5 More exercises

If you finish all the above exercises, download examples from the lectures, do some changes and run it. Make sure you understand how they work.
There are also many examples and exercises available online. There are some listed on the ELE. 

For example, this link from NTU (Nanyang Techno-logical University, Singapore) contains many exercises for practicing Java basics: 

https://www.ntu.edu.sg/home/ehchua/programming/java/J2a_BasicsExercises.html

### 6 Optional Challenge: MyBirthdayPro.java

This is an optional activity for students wishing a challenge. It may require you to research additional appropriate methods, and is considerably more difficult than the exercises above.

Explore how to write a better version of the program that takes 5 arguments:

current date, current month, current year, birthday date, birthday month

It should calculate the weekday on which your next birthday will fall, and print it in string form (`Mon`, `Tue`, `Wed` etc). 