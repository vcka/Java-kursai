public class Progress {
    private int progress = 0;
    private int progress2 = 0;

    public synchronized int getProgress2() {
        return progress2;
    }

    public synchronized void setProgress2(int progress2) {
        this.progress2 = progress2;
    }

    public synchronized int getProgress() {
        return progress;
    }

    public synchronized void setProgress(int progress) {
        this.progress = progress;
    }
}
