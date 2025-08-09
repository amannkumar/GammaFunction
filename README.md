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

