package com.taske.taskDelat.strategy;


public class StrategyAnalysis {

    private boolean consistents ;

    private  String message;

    public StrategyAnalysis(boolean consistents, String message) {
        this.consistents = consistents;
        this.message = message;
    }

    public StrategyAnalysis() {
    }

    public boolean isConsistents() {
        return consistents;
    }

    public void setConsistents(boolean consistents) {
        this.consistents = consistents;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
