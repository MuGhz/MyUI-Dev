Codebase MyUI
=====

### Specification


- Target SDK : Marshmallow (25)
- Minimum SDK : Ice Cream Sandwich (15)
- Installed Library :
    1. [Roughike Bottombar](https://github.com/roughike/BottomBar) 
        Defining footer tab with much easier way.    
    2. [Retrofit](square.github.io/retrofit/) 
        Tool for getting Http Request.
    3. [GSON](https://github.com/google/gson)
        Convert a Response from Retrofit into Gson, and can be converted into JSON Format.
    4. [JUnit](http://junit.org/junit4/)
        Simple framework to write repeatable tests.
    5. [Espresso](https://google.github.io/android-testing-support-library/docs/espresso/)
        Tool for creating Instrumental tests.
    6. [JaCoCo](https://github.com/jacoco/jacoco)
        Tool for creating Code Coverage Report.
    7. [Gradle Console Reporter](https://github.com/ksoichiro/gradle-console-reporter)
        Print all Gradle Report into Console.
    
### Development Guideline

1. Test Driven Development
2. To maintain high **Code Coverage** (which is important), make sure to:
    - Write **Unit Test** that cover all lines in function
    - Separate code that doesn't involved in **Unit Testing** (Read more about Unit Testing to understand it)
    into another package, and then exclude those package from **Code Coverage Report**
    - To exclude the package that doesn't need to be reported, please see file **jacoco.gradle** and see **classDirectories**, part **excludes** 
3. Clean Code (I'll only write some main points that I think it's important to remember, for further information, please read Books about Clean Code)
    
    1. Create a **Meaningfull Names** when you create a function, class, or variable
    2. Create a **Function that handle 1 specific task** instead of 1 function for many task
    3. Create a **Comments** for every important parts of code, to make an easier understanding of code
    4. Create a **Code that Self Explained** to make the code easier to read
    5. Create many **Small Function** when solving some problem is easier to do rather than creating 
    1 large function. It's also easier to maintain if you have this kind of function

4. Coding Guideline (For further information please visit this [link](https://source.android.com/source/code-style))

   - Never write a code that doesn't handle an exception, always make sure that you catch every exception and give some feedback to user when that happen (Exception handling)
   
   ```java
   /** Set port. If value is not a valid number, 80 is substituted. */
   
   void setServerPort(String value) {
       try {
           serverPort = Integer.parseInt(value);
       } catch (NumberFormatException e) {
           serverPort = 80;  // default port for server
       }
   }
   ```
   
   - When handling exception, make sure that you doesn't use Generic Exception as a way to catch those exception,
   unless you doesn't sure what kind of error will be raised on the code
   
   ```java
   try {
       gettingDatafromAPI();        // may throw HttpException
       convertDataToJSON();   // may throw ParsingException
       calculateItAndReturn();  // may throw NumberFormatException
       // phew, made it all the way
   } catch (Exception e) {                 // I'll just catch all exceptions
       handleError();                      // with one generic handler!
   }   
   ```
   
   - When you importing some module or package, use full path import so we can make sure what package are imported,
   unless it's come from Java Standard Library
    
    ```java
      import android.support.v4.app.*; //Doesn't know which pacakage is needed, so it's bad
      import android.support.v4.app.Fragment //Fragment with compat support is imported
    ```

   - Use proper Naming Convention
   
   ```java
      public static final int SOME_CONSTANT = 42; //For Final variable, use all Uppercase Letter
      private static MyClass sSingleton; //When using staticm use s at the beginning of name
      private int mPrivate; // When using non-public/non-static, use m at the beginning of name
      public int publicField; //Others, use lowercase at first word
   ```
   - Use TODO Comments when you're creating a temporary solution (line of code, or function) to make
   an understanding to next developer that this function needs some fixing

### API Access 

API that will be used for this project is : [API CS](https://api.cs.ui.ac.id/)

You can see this [link](https://api-dev.cs.ui.ac.id/how-to-use/) if you want to see how to access API CS

### Virtual Machine (Server)

We Prepare a VM for you, if you think that you need it for solving some task (such as creating additional
backend, or creating a proxy API)

... to be continue

### Build Status and Code Coverage

Make sure that Build Status are Success and Code Coverage is High

Here's the summary of build status and code coverage from important branch :

1. **Master**

    [![build status](https://gitlab.com/hafiyyan94/MyUI/badges/master/build.svg)](https://gitlab.com/hafiyyan94/MyUI/commits/master)
    [![coverage report](https://gitlab.com/hafiyyan94/MyUI/badges/master/coverage.svg)](https://gitlab.com/hafiyyan94/MyUI/commits/master)

2. **Development**

    [![build status](https://gitlab.com/hafiyyan94/MyUI/badges/master/build.svg)](https://gitlab.com/hafiyyan94/MyUI/commits/development)
    [![coverage report](https://gitlab.com/hafiyyan94/MyUI/badges/master/coverage.svg)](https://gitlab.com/hafiyyan94/MyUI/commits/development)
    
All Right Reserved to Team Fasilkom UI