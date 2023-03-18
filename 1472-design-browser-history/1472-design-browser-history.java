class BrowserHistory {
    private List<String> histories = new ArrayList<>();
    private int cursor = 0;

    public BrowserHistory(String homepage) {
        histories.add(homepage);
    }
    
    public void visit(String url) {
        this.histories = histories.subList(0, cursor + 1);
        histories.add(url);
        cursor++;
    }
    
    public String back(int steps) {
        if (cursor - steps < 0) {
            cursor = 0;
            return histories.get(cursor);
        }
        cursor -= steps;
        return histories.get(cursor);
    }
    
    public String forward(int steps) {
        if (cursor + steps > histories.size() - 1) {
            cursor = histories.size() - 1;
            return histories.get(cursor);
        }
        cursor += steps;
        return histories.get(cursor);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */