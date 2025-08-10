SOEN 6011 – Deliverables D1–D3
Function F4 – Gamma Function (Γ(x))
Author: Aman Kumar

--------------------------------------
1. INTRODUCTION
--------------------------------------
This project implements the Gamma function Γ(x) in Java using the Lanczos approximation. 
It supports real numbers, including negative non-integers, and follows mathematical 
properties.

--------------------------------------
2. FEATURES
--------------------------------------
- Accurate Gamma function computation using Lanczos approximation.
- Handles:
    * Positive real inputs
    * Negative non-integer inputs via reflection formula
- Throws exceptions for undefined inputs (non-positive integers).
- GUI for user-friendly input and output display.
- Logging of inputs, results, and error messages.
- Precision: outputs up to 8 decimal places.
- Meets functional and non-functional requirements from SOEN 6011.

--------------------------------------
3. SYSTEM REQUIREMENTS
--------------------------------------
- Java JDK 8+ (tested with JDK 20)
- Any IDE (IntelliJ IDEA recommended) or command-line Java compiler
- JUnit 4 for running automated tests

--------------------------------------
4. RUNNING THE APPLICATION
--------------------------------------
To run the GUI:
    1. Open the project in IntelliJ IDEA.
    2. Run the `main` method in `GammaFunction.java`.
    3. Enter a real number x > 0 in the input box and click "Compute Γ(x)".
    4. The result will appear in the output area.

--------------------------------------
5. RUNNING TESTS
--------------------------------------
JUnit 4 test cases are provided in `GammaFunctionTest.java`.

To run tests in IntelliJ:
    - Right-click the test file and choose "Run All Tests".

From the command line (if JUnit jar is in the classpath):
    javac -cp .:junit-4.13.1.jar GammaFunction.java GammaFunctionTest.java
    java -cp .:junit-4.13.1.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore GammaFunctionTest

--------------------------------------
6. LOGGING
--------------------------------------
All calculations are logged in "gamma_log.txt" in the working directory.

Log entries include:
    [YYYY-MM-DD HH:MM:SS] INPUT: <x> | RESULT: <value>
    [YYYY-MM-DD HH:MM:SS] INPUT: <x> | ERROR: <message>

--------------------------------------
7. LIMITATIONS
--------------------------------------
- Does not handle complex numbers (x with imaginary parts).
- Very large positive x may produce overflow due to limitations of double precision.

--------------------------------------
8. REFERENCES
--------------------------------------
1. Lanczos, C. "A precision approximation of the gamma function."
2. Abramowitz, M., and Stegun, I.A. "Handbook of Mathematical Functions."
3. SOEN 6011 Course Material – Concordia University.

--------------------------------------
END OF README
--------------------------------------
