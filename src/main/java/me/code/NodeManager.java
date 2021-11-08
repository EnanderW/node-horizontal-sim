package me.code;

import java.util.ArrayList;
import java.util.List;

public class NodeManager {

    private static final int NODE_COUNT = 5;

    public static NodeManager INSTANCE = new NodeManager();

    private List<Node> nodes;

    public NodeManager() {
        this.nodes = new ArrayList<>();
    }

    public void start() {
        for (int i = 0; i < NODE_COUNT; i++) {
            Node node = new Node("Thread #" + (i + 1));
            node.start();

            nodes.add(node);
        }
    }

    private int nodeIndex = 0;
    public void push(int num) {
        Node node = nodes.get(nodeIndex++);
        if (nodeIndex >= nodes.size())
            nodeIndex = 0;


        node.push(num);
    }

}
