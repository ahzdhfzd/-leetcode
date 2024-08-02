package queue.linked;

/**
 * @author 10029
 * @date 2023/4/23
 */
public class RingLinkedDemo {
    public static void main(String[] args) {
        RingLinkedList ringLinkedList = new RingLinkedList();
//        ringLinkedList.add(50);
//        ringLinkedList.show();
        ringLinkedList.countBoy(1, 5, 2);

    }


}

class Boy {
    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }

    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}


class RingLinkedList {
    private Boy first;

    public void add(int nums) {
        if (nums <= 0) {
            System.out.println("nums is fail");
            return;
        }
        //辅助指针
        Boy curBoy = null;
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                boy.setNext(first);
                curBoy = boy;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }


    }

    public void show() {
        if (first == null) {
            return;
        }
        Boy curBoy = first;
        do {
            System.out.println(curBoy);
            curBoy = curBoy.getNext();
        } while (curBoy != first);
        System.out.println("===================================");
    }

    public  void countBoy(int startNo, int nums, int countNum) {
        this.add(nums);
        if (startNo > nums || startNo < 1 || countNum == 0) {
            System.out.println("failed  ");
            return;
        }
        Boy helper = first;
        while (helper.getNext() != first) {
            helper = helper.getNext();
        }
        for (int i = 0; i < startNo-1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        while (helper!=first){
            for (int i = 0; i < countNum-1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.println(first+"-");
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println(first);


    }
}