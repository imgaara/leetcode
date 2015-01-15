import util.UndirectedGraphNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by Administrator on 2014/7/21 0021.
 */
public class Clone_Graph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (null == node) {
            return null;
        }

        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        Map<Integer, UndirectedGraphNode> exists = new HashMap<Integer, UndirectedGraphNode>();
        q.add(node);
        exists.put(node.label, new UndirectedGraphNode(node.label));

        while (!q.isEmpty()) {
            UndirectedGraphNode cur = q.poll();
            UndirectedGraphNode newCur = exists.get(cur.label);
            for (UndirectedGraphNode neighbor : cur.neighbors) {
                int label = neighbor.label;
                UndirectedGraphNode newNeighbor = exists.get(label);
                if (null == newNeighbor) {
                    newNeighbor = new UndirectedGraphNode(label);
                    q.offer(neighbor);
                    exists.put(label, newNeighbor);
                }

                newCur.neighbors.add(newNeighbor);
            }
        }

        return exists.get(node.label);
    }
}
