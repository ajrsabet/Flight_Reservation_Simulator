package util;

public class TypeWriter {
    private int delay;

    public TypeWriter(int delay) {
        this.delay = delay;
    }

    // create a delay between each character to simulate typing effect
    public void PrintLn(String line) {

        for (int i = 0; i < line.length(); i++) {
            System.out.print(line.charAt(i));
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println();
    }

    public void Print(String line) {
        for (int i = 0; i < line.length(); i++) {
            System.out.print(line.charAt(i));
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
