To clean:
ant -buildfile src/build.xml clean

To compile: 
ant -buildfile src/build.xml all

To run
ant -buildfile src/build.xml run -Darg0=/home/girish_kurkute_assign_2/input.txt -Darg1=/home/girish_kurkute_assign_1/delete.txt -Darg2=/home/girish_kurkute_assign_2/output1.txt -Darg3=/home/girish_kurkute_assign_1/output2.txt -Darg4=/home/girish_kurkute_assign_2/output3.txt 


In observer pattern, when one object changes, all the dependent objects gets notification and they get updated.
The object that changes the value and need to notify other objects is known as Subject and the objects those get notified are known as observer.
In this project original node is subject and two backup nodes are observer.So when original node changes the respective changes are made into backup nodes.
Backup node objects are stored into array data structure with the help of registerObserver() method.
When the course in deleted from a original node, notifyObservers() method gets called to notify all the backup nodes that subject is changed.
Then update() is called to make changes in to backup nodes as per original node.
Subject and observer holds a one-many relationship.




