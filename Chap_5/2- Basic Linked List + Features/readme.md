This is an improvement over the basic linked list described earlier.

Other than the features mentioned earlier, this implementation of the linked list has 2 additional features:

=>Find: An additional method find(int key) is available which searches the linked list for a specific link whose data matches the given key. When successful, that link is returned, if not, an appropriate message is returned

=>Delete: An additional method delete(int key) is available which searches the linked list for a specific link whose data matches the given key. When successful, the link is deleted and returned to the user(for processing if needed), and if not, an appropriate message is returned. 
Note: To implement this delete(key) feature, an extra reference to the preceeding node is also needed (in addition to the current node at all times). This so as to link the preceeding node to the next node in case of a successful deletion.
