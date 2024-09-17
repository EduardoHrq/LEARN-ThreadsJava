package org.using_volatile;

public class Race {
    // ao tornar-se volatile os threads passaram a assisti-lo, e usar sempre o valor atual
    private volatile boolean isFinished;

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }
}
