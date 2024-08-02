package queue.doublelinked;

/**
 * @author 10029
 * @date 2023/4/23
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode n1 = new HeroNode(1, "1", "11");
        HeroNode n2 = new HeroNode(2, "2", "22");
        HeroNode n3 = new HeroNode(3, "3", "33");
        HeroNode n4 = new HeroNode(4, "4", "44");
        HeroNode n6 = new HeroNode(6, "6", "66");
        HeroNode n5 = new HeroNode(5, "5", "55");
        HeroNode n7 = new HeroNode(7, "5", "55");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList(null);
//        doubleLinkedList.add(n1);
        doubleLinkedList.add(n2);
        doubleLinkedList.add(n5);
        doubleLinkedList.add(n6);
        doubleLinkedList.addByOrder(n4);
        doubleLinkedList.addByOrder(n3);
        doubleLinkedList.addByOrder(n1);
        doubleLinkedList.show();
        doubleLinkedList.update(new HeroNode(4, "5454", "454"));
        doubleLinkedList.show();
        doubleLinkedList.delete(n3);
        doubleLinkedList.show();
    }
}

class HeroNode {
    int no;
    String name;
    String nickname;
    HeroNode next;
    HeroNode pre;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    /**
     * @param head 链表头节点
     * @return
     */
    public static int getSize(HeroNode head) {
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
    public static HeroNode findLastIndexHeroNode(HeroNode head, int index) {
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
    public static void ReverseHeroNode(HeroNode head) {
        if (head.next == null || head.next.next == null) {

        }
        HeroNode temp = head.next; //1
        HeroNode next = null;
        HeroNode newHead = new HeroNode(0, "", "");
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

    public static HeroNode conditonTwoOrder(HeroNode node1, HeroNode node2) {
        HeroNode newNode = new HeroNode(0, "", "");
        if (node1.next == null) {
            return node2;
        }
        if (node2.next == null) {
            return node1;
        }
        while (node1 != null || node2 != null) {
            if (node1.no < node2.no) {
                newNode.next = node1;
                node1 = node1.next;
            }
        }
        return null;

    }

    /**
     * 逆序打印链表
     *
     * @param heroNode
     */
    public static void reversePrint(HeroNode heroNode) {
        if (heroNode == null) {
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

class DoubleLinkedList {
    //先初始化头节点 头节点不要动；
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return this.head;
    }

    public void setHeroNode(HeroNode head) {
        this.head = head;
    }

    public DoubleLinkedList(HeroNode head) {
        if (head!=null) {
            this.head = head;
        }
    }

    //1.先找到当前链表的尾节点
    //2.将尾节点的next指向新节点
    public void add(HeroNode node) {
        //因为头节点不能动
        HeroNode help = head;
        while (true) {
            if (help.next == null) {
                break;
            }
            help = help.next;
        }
        help.next = node;
        node.pre = help;

    }

    public void addByOrder(HeroNode node) {
        HeroNode help = head.next;
        //添加的编号是否存在，默认false
        boolean flag = false;
        while (help!= null && help.no <= node.no) {
            if (help.no == node.no) {
                flag = true;
                break;
            }
            help = help.next;
        }
        if (!flag) {
            help.pre.next = node;
            node.next=help;
            node.pre=help.pre;
        } else {
            System.out.println("node is exis");
        }
    }

    /**
     * 根据节点no修改
     *
     * @param node
     */
    public void update(HeroNode node) {
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
    public void delete(HeroNode node) {
        if (head.next == null) {
            return;
        }
        HeroNode help = head.next;
        while (help != null && help.no != node.no) {
            help = help.next;
        }
        if (help == null) {
            System.out.println("该节点不存在");
            return;
        }
        help.pre.next = help.next;
        //判断是否最后一个节点，防止出现NullPointer
        if (help.next != null) {
            help.next.pre = help.pre;
        }
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
        System.out.println("-----------------------------------------");
    }


}
