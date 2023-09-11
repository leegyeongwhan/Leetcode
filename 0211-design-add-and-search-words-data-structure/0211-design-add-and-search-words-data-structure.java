class WordDictionary {

 static class Node {
        public Map<Character, Node> children;
        public boolean isEndOfWord;

        public Node() {
            this.children = new LinkedHashMap<>();
            this.isEndOfWord = false;
        }
    }

    private Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node node = this.root;

        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                node.children.put(c, new Node());
            }
            node = node.children.get(c);
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        return search(word, this.root, 0);
    }

    public boolean search(String word, Node node, int index) {
        if (index == word.length()) {
            return node.isEndOfWord;
        }

        char c = word.charAt(index);

        if (c == '.') {
            for (Map.Entry<Character, Node> entry : node.children.entrySet()) {
                if (entry.getValue() != null) {
                    if (search(word, entry.getValue(), index + 1)) {
                        return true;
                    }
                }
            }
            return false;
        }

        Node child = node.children.get(c);

        if (child == null) {
            return false;
        }
        return search(word, child, index + 1);
}
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */