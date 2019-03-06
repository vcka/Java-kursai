import java.time.LocalDateTime;
import java.util.List;
import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        Progress progress = new Progress();
//        BiFunction<String, String, Character[]> combineWordsIntoArray;
//        combineWordsIntoArray = ((x,y)->(x+y).toCharArray().);
        Thread thread = new Thread(() -> {
            try {
                System.out.println(LocalDateTime.now());
                for (int i = 0; i <= 40; i++) {
                    progress.setProgress(i);
                    Thread.sleep(1000);
                }
                System.out.println(LocalDateTime.now());
            } catch (InterruptedException e) {
                System.out.println("Job done.");
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                System.out.println(LocalDateTime.now());
                for (int i = 0; i <= 40; i++) {
                    progress.setProgress2(i);
                    Thread.sleep(1000);
                }
                System.out.println(LocalDateTime.now());
            } catch (InterruptedException e) {
                System.out.println("Job done.");
            }
        });

        thread.start();
        thread2.start();
//        do {
//            Thread.sleep(3000);
//            System.out.println("Current progress: " + progress.getProgress());
//        } while (progress.getProgress() != 40);
    }
}
