package ss11_dsa_stack_queue.optional.trien_khai_queue_use_array;

public class MyQueue {
    private int capacity;//dung luong,so phan tu ma hang doi co the chua
    private int[] queueArr;
    private int head = 0;//dau
    private int tail = -1;//cuoi
    private int currentSize = 0;//kich co hien tai

    //Tạo lớp MyQueue với các thuộc tính:
    public MyQueue(int currentSize) {
        this.currentSize = currentSize;
        queueArr = new int[this.capacity];
    }

    //Cài đặt phương thức isQueueFull ()
    public boolean isQueueFull() {
        boolean status = false;
        if (currentSize == capacity) {
            status = true;
        }
        return status;
    }
    // Cài đặt phương thức isQueueEmpty()
    public boolean isEmpty(){
        boolean status = false;
        if (currentSize==0){
            status= true;
        }
        return  status;
    }
    // Cài đặt phương thức enqueue ()Enqueue có nghĩa là thêm một phần tử
    public void enqueue(int item){
        if(isQueueFull()){
            System.out.println("Overflow! Unable to add element");
        }else {
            tail++;
            if (tail==capacity-1){
                tail=0;
            }
            currentSize++;
            System.out.println("Element "+ item+" is pushes to Queue !");
        }
    }
    //Cài đặt phương thức dequeue () dequeue để loại bỏ một phần tử
    public  void dequeue(){
        if (isEmpty()){
            System.out.println("Underflow! Unable to remove element from Queue !");
        }else {
            head++;
            if (head==capacity-1){
                System.out.println("Pop eperation done ! remover: "+queueArr[head-1]);
                head=0;
            }
            currentSize--;
        }

    }
}
