This is my implementation of a Doubly Linked List. This linked list has considerable improvements over a singly linked list. These improvements are implemented in the form of additional
methods, as follows:

1. INSERTION 
Being a doubly linked list, each link in the list maintains a reference to it's previous as well as following node, which allows to implement the following insertion routines:
a. insertFront(data) - this method allows the user to insert a link (with data) at the front of the list.
b. insertLast(data) - this methods allows the user to insert a link(with data) at the end of the list.
c. insertAfter(key, data) - this method allows the user to insert a link(with data) after a specific link whose data matches the given key, if successful.

2. DELETION
Again, doubly linked list features allows the following deletion routines:
a. deleteFront() - deletes the first link from the list
b. deleteLast() - deletes the last link from the list
c. deleteKey(key) - searches a specific link whose data matches the key passed in, and if successful, deletes it.

3. DISPLAY 
The doubly linked list should display it's links both forward(left -> right) and backward(right -> left). Accordingly, it has these methods:
a. displayForward()
b. displayBackward()

