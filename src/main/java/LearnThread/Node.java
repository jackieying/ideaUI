package LearnThread;

public class Node {
    private Thread thread;
    private Node nextWaiter;
    private String nodeName;

    Node(Thread thread, Node mode) {
        this.nextWaiter = mode;
        this.thread = thread;
    }

    Node() {

    }

    Node(Thread thread) {
        this.thread = thread;
    }

    public Node getNextWaiter(){
        return this.nextWaiter;
    }

    public void setNextWaiter(Node nextWaiter) {
        this.nextWaiter = nextWaiter;
    }

    public Thread getThread() {
        return thread;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }
}
