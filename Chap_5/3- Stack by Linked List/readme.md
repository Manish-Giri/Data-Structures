1. Implementation of a stack based on a linked list as the underlying data structure
2. While both array-based and stack-based implementations offer relatively fast operations, a design decsion should be made on the expected size of the stack
3. For a smaller size, an array can be used to implement the stack as that would provide faster retrieval and comparatively lesser time would be required for shifting items around during insertions/deletions
4. On the other hand, for a large size, linked list should be used as insertions/deletions would require changing only a few references.
5. On average, about O(N) time is required for a search in either case.
