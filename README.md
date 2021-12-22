# Logic Gate Calculator

System is able to calculate the value of a given simple logical formula.\
for example:\
true AND false = false\
AND[OR[false, true], OR[false, NOT[true]], true] = false

# OOP Principles
1. Abstraction:<br>
A logical formula consists of several gates. 
There are different kinds of gates, but they are characterized by some same conceptual idea.<br>
The abstract super-class Gate defines a generalization for these ideas.<br>
This enables each sub-class to implement it as it suits to her.

2. Encapsulation:<br>
Expressed by having private fields and some protected methods.

3. Inheritance:<br>
The different types of gates described in the system are inheriting methods and a field from the super-class Gate.

4. Polymorphism:<br>
The System is relaying on run-time polymorphism by sub-classes overriding the super-class definitions.

# OOP Patterns:
1. Singleton Pattern<br>
The gates "TrueGate" and "FalseGate"
2. Strategy Pattern<br>
The class Gate implements the abstract method calc(), which returns the value of the gate.<br>
Inside calc() there is a call for abstract method func() which is implemented differently by each of Gates' sub-classes.<br>
This enables calc() to decide of an algorithm during run-time.<br><br>

to be noted that the formula is calculated by the method simplify() in a recursive manner.
