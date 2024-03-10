package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Balancer {
    public static void split(List<ArrayList<Integer>> nodes, Iterator<Integer> source) {
        int nodeIndex = 0;
        while (source.hasNext()) {
            nodes.get(nodeIndex).add(source.next());
            nodeIndex = (nodeIndex + 1) % nodes.size();
        }
    }
}
