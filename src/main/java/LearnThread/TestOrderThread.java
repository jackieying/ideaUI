package LearnThread;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class TestOrderThread {

    public final static AtomicInteger TEST_ATOMIC_INTEGER = new AtomicInteger(0);

    public static ReentrantLock lock = new ReentrantLock();

    public static Node nodeNext = new Node();

    public static void main(String[] args) throws Exception {


        PrintThread printThread1 = new PrintThread(TEST_ATOMIC_INTEGER, "threadA");
        PrintThread printThread2 = new PrintThread(TEST_ATOMIC_INTEGER, "threadB");
        PrintThread printThread3 = new PrintThread(TEST_ATOMIC_INTEGER, "threadC");

        Thread thread1 = new Thread(printThread1);
        Thread thread2 = new Thread(printThread2);
        Thread thread3 = new Thread(printThread3);

        Node node3 = new Node(thread3);
        Node node2 = new Node(thread2, node3);
        Node node1 = new Node(thread1, node2);

        node3.setNextWaiter(node1);

        node1.setNodeName("NodeA");
        node2.setNodeName("NodeB");
        node3.setNodeName("NodeC");

        Boolean threadAIsStart = false;
        Boolean threadBIsStart = false;
        Boolean threadCIsStart = false;

        Map<Node, Boolean> map = new ConcurrentHashMap<Node, Boolean>() {
            {
                put(node1, threadAIsStart);
                put(node2, threadBIsStart);
                put(node3, threadCIsStart);

            }
        };
        runThreadCommand(node1, map);

    }

    static void runThreadCommand(Node node, Map map) throws Exception {
        synchronized (nodeNext) {
            nodeNext = node.getNextWaiter();
            if (null != map && Boolean.FALSE.equals(map.get(node))) {
                node.getThread().start();
                map.put(node, Boolean.TRUE);
            }
            nodeNext = node.getNextWaiter();
            if (null != map && Boolean.FALSE.equals(map.get(nodeNext))) {
                nodeNext.getThread().start();
                map.put(nodeNext, Boolean.TRUE);
            } else {
                LockSupport.unpark(nodeNext.getThread());
            }
            while (TEST_ATOMIC_INTEGER.get() < 100) {
                runThreadCommand(nodeNext, map);
            }
        }

    }
}
