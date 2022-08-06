/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     val: number
 *     left: TreeNode | null
 *     right: TreeNode | null
 *     constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.left = (left===undefined ? null : left)
 *         this.right = (right===undefined ? null : right)
 *     }
 * }
 */

//@ts-ignore
class TreeNode {
    val: number
    left: TreeNode | null
    right: TreeNode | null
    constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
        this.val = (val===undefined ? 0 : val)
        this.left = (left===undefined ? null : left)
        this.right = (right===undefined ? null : right)
    }
}

/**
 * 
 * @param p 왼쪽 노드
 * @param q 오른쪽 노드
 * @returns 
 */
function isSameTree(p: TreeNode | null, q: TreeNode | null): boolean {
    if (p === null && q === null) {
        return true;
    }
    if (!p !== !q) {
        return false;
    }

    if (p !== null && q !== null) {
        if (p.val === q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
        }
    }
    
    return false;
};

const a: TreeNode = new TreeNode(1, new TreeNode(2), new TreeNode(1))
const b: TreeNode = new TreeNode(1, new TreeNode(2), new TreeNode(1))

console.log(isSameTree(a, b))