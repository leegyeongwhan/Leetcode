class Trie {

    static class Node {
        public Map<Character, Node> children;
        public boolean isEndOfWord;

        public Node() {
            this.children = new HashMap<>();
            this.isEndOfWord = false;
        }
    }

    private Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node current = this.root;

        for (char c : word.toCharArray()) {
            if (!current.children.containsKey(c)) {
                current.children.put(c, new Node());
            }
            current = current.children.get(c);
        }
        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        Node node = this.root;

        for (char c : word.toCharArray()) {
            if (node.children.get(c) == null) {
                return false;
            }
                        node = node.children.get(c);

        }
        return node.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        Node node = root;

        for (char c : prefix.toCharArray()) {
            if (node.children.get(c) == null) {
                return false;
            }
            node = node.children.get(c);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */