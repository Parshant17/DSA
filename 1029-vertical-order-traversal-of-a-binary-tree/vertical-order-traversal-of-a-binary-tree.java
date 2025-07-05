

class Solution {
    static class NodeInfo {
        int row;
        int val;

        NodeInfo(int row, int val) {
            this.row = row;
            this.val = val;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, List<NodeInfo>> columnMap = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0, 0));

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            TreeNode node = curr.node;
            int row = curr.row;
            int col = curr.col;

            columnMap.putIfAbsent(col, new ArrayList<>());
            columnMap.get(col).add(new NodeInfo(row, node.val));

            if (node.left != null) {
                queue.offer(new Pair(node.left, row + 1, col - 1));
            }
            if (node.right != null) {
                queue.offer(new Pair(node.right, row + 1, col + 1));
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (List<NodeInfo> nodeList : columnMap.values()) {
            nodeList.sort((a, b) -> {
                if (a.row == b.row) {
                    return Integer.compare(a.val, b.val);
                }
                return Integer.compare(a.row, b.row);
            });
            List<Integer> column = new ArrayList<>();
            for (NodeInfo ni : nodeList) {
                column.add(ni.val);
            }
            result.add(column);
        }

        return result;
    }

    static class Pair {
        TreeNode node;
        int row;
        int col;

        Pair(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
}
