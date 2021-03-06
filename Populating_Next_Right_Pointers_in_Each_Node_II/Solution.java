/**
Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
*/

/**

 * Definition for binary tree with next pointer.

 * public class TreeLinkNode {

 *     int val;

 *     TreeLinkNode left, right, next;

 *     TreeLinkNode(int x) { val = x; }

 * }

 */

public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode prevHead = root;
        TreeLinkNode curHead = null;
        TreeLinkNode tail = null;
        while (prevHead != null) {
            curHead = tail = null;
            while (prevHead != null) {
                if (prevHead.left != null) {
                    if (tail == null) {
                        curHead = tail = prevHead.left;
                    } else {
                        tail.next = prevHead.left;
                        tail = tail.next;
                    }
                }
                if (prevHead.right != null) {
                    if (tail == null) {
                        curHead = tail = prevHead.right;
                    } else {
                        tail.next = prevHead.right;
                        tail = tail.next;
                    }
                }
                prevHead = prevHead.next;
            }
            prevHead = curHead;
        }
    }
}
