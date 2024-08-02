package queue;

/**
 * @author 10029
 * @date 2023/4/21
 */
public class ArrayQueueDemo {

    /**
     * 单向数组模拟队列
     */
    class ArrayQueue{
        private int front;
        private int rear;
        private  int maxsize;
        private int[] arr;
        public ArrayQueue(int maxsize){
            this.maxsize = maxsize;
            arr = new int[maxsize];
            front = -1;
            rear = -1;
        }
        public boolean isFull(){
            return  rear == maxsize - 1;
        }
        public boolean isEmpty(){
            return  rear == front;
        }

        public void addQueue(int n){
            if (isFull()){
                return;
            }
            arr[++rear] = n;

        }
        public int poll(){
            if (isEmpty()){
                throw new IndexOutOfBoundsException("queue is empty");
            }
            return arr[++front];
        }
        public int peek(){
            if (isEmpty()){
                throw new IndexOutOfBoundsException("queue is empty");
            }
            return arr[front+1];
        }
    }
    static class RingArrayQueue{
        private int front;
        private int rear;
        private  int maxsize;
        private int[] arr;
        public RingArrayQueue(int maxsize){
            this.maxsize = maxsize+1;
            arr = new int[maxsize+1];
            front = 0;
            rear = 0;
        }
        public boolean isFull(){
            return  (rear+1)%(maxsize) == front;
        }
        public boolean isEmpty(){
            return  rear == front;
        }

        public void addQueue(int n){
            if (isFull()){
                throw new IndexOutOfBoundsException("queue is full");
            }
            arr[rear] = n;
            rear = (rear+1)%(maxsize);

        }
        public int poll(){
            if (isEmpty()){
                throw new IndexOutOfBoundsException("queue is empty");
            }

            return arr[front];

        }
        public int peek(){
            if (isEmpty()){
                throw new IndexOutOfBoundsException("queue is empty");
            }
            int result = arr[front];
            front = (front+1)%(maxsize);
            return result;
        }
        public void show(){
            for (int i = 0; i < getSize(); i++) {
                System.out.print(arr[(i+front)%maxsize]+" ");
            }
            System.out.print("\n");

        }
        public int getSize(){
            return (rear+maxsize-front)%(maxsize);
        }
    }

    public static void main(String[] args) {
        RingArrayQueue q = new RingArrayQueue(3);
        q.addQueue(1);
        q.show();
        q.addQueue(2);
        q.show();
        q.addQueue(3);
        q.show();
        System.out.println(q.peek());
        q.addQueue(4);
        q.show();
        System.out.println(q.peek());
        System.out.println(q.peek());
        System.out.println(q.peek());
        System.out.println(q.peek());

    }

}
