# CSDS233-Assignment-2

## Part A
### Parts A-2 and A-3
For parts A-2 and A-3 please see the attached PDF, `A2-A3 Response.pdf`.

## Part B
### Modifications:
* I've changed the `insert` method arguments to include only a `key` and `data` (value). This is because the root of the tree is already stored as a field in the class, so it is redundant to require the user to pass it each time they want to add a node to the linked list. Additionally, a proper binary search tree should have data associated with keys, so my `Node` class has fields for both. The insert method lets you insert a new node with a certain key containing data.
* I've changed the `preorderRec` method to **return** instead of print out the preorder of the binary search tree. I've also renamed the method to `preorder`. Like `insert`, it does not require the root node to be passed to it, since it is able to internally utilize the instance field `root` through the getter `getRootNode()`.
* I've changed `sum` to not require the root node, for the same reason I've done so for the other methods.
* I've changed `kthBiggest` to not require the root node, for the same reason I've done so for the other methods.