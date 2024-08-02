package queue.linked;

/**
 * @author 10029
 * @date 2023/4/22
 */
public class LinkedDemo {
    public static void main(String[] args) {
//        HeroNode n1 = new HeroNode(1, "1", "11");
//        HeroNode n2 = new HeroNode(2, "2", "22");
//        HeroNode n3 = new HeroNode(3, "3", "33");
//        HeroNode n4 = new HeroNode(4, "4", "44");
//        HeroNode n6 = new HeroNode(6, "6", "66");
//        HeroNode n5 = new HeroNode(5, "5", "55");
//        HeroNode n7 = new HeroNode(7, "5", "55");
//        SingleLinkedList linkedList = new SingleLinkedList();
//        linkedList.add(n1);
//        linkedList.add(n2);
//        linkedList.addByOrder(n4);
//        linkedList.addByOrder(n6);
//        linkedList.addByOrder(n3);
//        linkedList.addByOrder(n5);
//        linkedList.addByOrder(n5);
//        linkedList.update(new HeroNode(5, "666666666", "(999999999"));
//        linkedList.delete(n7);
////        System.out.println(HeroNode.getSize(linkedList.getHead()));
////        System.out.println(HeroNode.findLastIndexHeroNode(linkedList.getHead(), 7));
////        linkedList.show();
////        HeroNode.ReverseHeroNode(linkedList.getHead());
//        HeroNode.reversePrint(linkedList.getHead());
//        System.out.println("-----------------");
//        linkedList.show();
         HeroNode a = new  HeroNode(1, "1", "!");
         HeroNode b = new  HeroNode(2, "b", "!");
        a.next = b;
         HeroNode c = new  HeroNode(0, "", "");
        c.next = a;
        a = a.next;
 new SingleLinkedList(c).show();
 new SingleLinkedList(a).show();
    }
}

/**
 * head节点
 */
class HeroNode {
    int no;
    String name;
    String nickname;
     HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    /**
     * @param head 链表头节点
     * @return
     */
    public static int getSize( HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
         HeroNode help = head.next;
        while (help != null) {
            length++;
            help = help.next;
        }
        return length;
    }

    /**
     * 查找链表倒数第几个元素
     *
     * @param head
     * @param index
     * @return
     */
    public static  HeroNode findLastIndexHeroNode( HeroNode head, int index) {
        if (head.next == null) {
            return null;
        }
         HeroNode l = head.next;
         HeroNode f = head.next;
        int i = 0;
        while (f != null) {
            if (i < index) {
                i++;
            } else {
                l = l.next;
            }
            f = f.next;
        }
        return l;
    }

    /**
     * 反转链表
     *
     * @param head
     */
    public static void ReverseHeroNode( HeroNode head) {
        if (head.next == null || head.next.next == null) {

        }
         HeroNode temp = head.next; //1
         HeroNode next = null;
         HeroNode newHead = new  HeroNode(0, "", "");
        while (temp != null) {
            // 1 2 3 4
            next = temp.next;//2
             HeroNode next1 = newHead.next;
            newHead.next = temp;//1
            newHead.next.next = next1;
            temp = next;//2
        }
        head.next = newHead.next;
    }
    public static  HeroNode conditonTwoOrder( HeroNode node1,  HeroNode node2){
         HeroNode newNode = new  HeroNode(0,"","");
       if (node1.next == null){
           return node2;
       }
       if (node2.next == null){
           return node1;
       }
       while (node1!=null || node2!=null){
           if (node1.no< node2.no){
               newNode.next =node1;
               node1 = node1.next;
           }
       }
       return null;

    }
    /**
     * 逆序打印链表
     * @param heroNode
     */
    public static void reversePrint( HeroNode heroNode) {
        if (heroNode == null ) {
            return;
        }
        reversePrint(heroNode.next);
        System.out.println(heroNode);

    }


    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}

class SingleLinkedList {
    //先初始化头节点 头节点不要动；
    private  HeroNode head = new  HeroNode(0, "", "");

    public  HeroNode getHead() {
        return this.head;
    }
    public void setHeroNode( HeroNode head){
        this.head = head;
    }

    public SingleLinkedList( HeroNode head) {
        this.head = head;
    }

    //1.先找到当前链表的尾节点
    //2.将尾节点的next指向新节点
    public void add( HeroNode node) {
        //因为头节点不能动
         HeroNode help = head;
        while (true) {
            if (help.next == null) {
                break;
            }
            help = help.next;
        }
        help.next = node;

    }

    public void addByOrder( HeroNode node) {
        //因为是单链表所以我们找的help是位于添加位置的前一个节点
         HeroNode help = head;
        //添加的编号是否存在，默认false
        boolean flag = false;
        while (help.next != null && help.next.no <= node.no) {
            if (help.next.no == node.no) {
                flag = true;
                break;
            }
            help = help.next;
        }
        if (!flag) {
             HeroNode temp = help.next;
            help.next = node;
            node.next = temp;
        } else {
            System.out.println("node is exis");
        }
    }

    /**
     * 根据节点no修改
     *
     * @param node
     */
    public void update( HeroNode node) {
        if (head.next == null) {
            return;
        }
         HeroNode help = head.next;
        while (help != null) {
            if (help.no == node.no) {
                help.name = node.name;
                head.nickname = node.nickname;
                break;
            }
            help = help.next;
        }
    }

    /**
     * 根据节点no删除
     *
     * @param node
     */
    public void delete( HeroNode node) {
        if (head.next == null) {
            return;
        }
         HeroNode help = head;
        while (help.next != null && help.next.no != node.no) {
            help = help.next;
        }
        if (help.next == null) {
            System.out.println("该节点不存在");
            return;
        }
        help.next = help.next.next;
        System.gc();
    }


    public void show() {
        if (head.next == null) {
            return;
        }
         HeroNode help = head.next;
        while (help != null) {
            System.out.println(help.toString());
            help = help.next;
        }
    }


}



