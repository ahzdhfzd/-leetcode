import org.w3c.dom.Node;

/**
 * @author 10029
 * @date 2023/3/11
 */
public class Solution1 {
    public Node copyRandomList(Node head) {
            if (head == null){
                return null;
            }
            Node cur = head;
            while (cur != null) {
                Node temp = new Node(cur.val);
                temp.next = cur.next;
                cur.next = temp;
                cur = temp.next;
            }
            cur = head;
            while (cur!=null) {
                if (cur.random!=null){
                    cur.next.random = cur.random.next;
                }
                cur = cur.next.next;
            }
            Node pre = head,res = head.next;
            cur = head.next;
            while (cur.next!=null){
                pre.next = pre.next.next;
                cur.next = cur.next.next;
                pre = pre.next;
                cur = cur.next;
            }
            pre.next = null;
            return res;

    }
    public static class Node{
        int val;
        Node next;
        Node random;
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

    }
}
