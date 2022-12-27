# OOP-Matala1

## INTRODUCTION:

In this task, we made an Observer - Pattern structure of a group that follows an UndoableStringBuilder and it's changes.

The Observable is the GroupAdmin which controls the UndoableStringBuilder and changes it on command,
it also has a list containing members that observe the changes of the UndoableStringBuilder.

The Observer - side is a group of members that is being stored as a list in the GroupAdmin class,
each member has his own arguments of GroupAdmin, it's own name, and the UndoableStringBuilder that is being updated from the GroupAdmin.


## FUNCTIONALLITIES/ALGORITHMS:

The two classes are oparating using the following methods:

<ins>GroupAdmin:</ins>

Has methods that oparate the append/delete/insert/undo methods from the UndoableStringBuilder, by calling them from the UndoableStringBuilder class,
and after each of these called oparations, a notifyMembers method is being called. The notifyMembers method is going through all the members contained in the member's list and for each member it calls the Update method, 
which is being oparated in each member in the ConcreteMember class.

Additionally, the GroupAdmin class has Register and Unregister methods which get a member as an argument and add/remove it from the list.


<ins>ConcreteMember:</ins>

Is being made with a constructor that holds the GroupAdmin and a name for the member,
when constructed, the member's UndoableStringBuilder's parameter will shallow-copy the one that the GroupAdmin holds.

Has an Update method which, whenever called, points the UndoableStringBuilder parameter to the GroupAdmin's UndoableStringBuilder, 
and then prints a messege regarding the updated UndoableStringBuilder, with the name of the member.


## HOW-TO-USE:

In order to download and run the program, the following steps are required:

(1) - Download the project from Git-Hub.</br>
(2) - Open the folder in InteliJ.</br>
(3) - Create Main class in the src folder.</br>
(4) - In the Main class - create a new Group Admin, and some Concrete Members to add to the GroupAdmin's list.</br>
(5) - Register the ConcreteMembers with the admin.register(Member obj) function.</br>
(6) - Use the append/delete/insert/undo methods at will, to update the UndoableStringBuilder, and notify the members.</br>
(7) - Optional - you can remove a member by calling the admin.unregister(Member obj) function.</br>
(8) - You will be able to see in console that the updates regarding the UndoableStringBuilder are being notified to the current registered ConcreteMembers.</br>
