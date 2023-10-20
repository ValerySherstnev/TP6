public class ArrayManipulation {

    static final int SIZE = 40000000;
    static final int HALF = SIZE / 2;
    static final int DEC = SIZE / 5;

    public static void main(String[] args) {
        float[] arr = new float[SIZE];

        methodOne(arr);
        methodTwo(arr);
        methodThree(arr);
    }

    public static void methodOne(float[] arr) {
        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1.0f;
        }

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < SIZE; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + (double) i / 5) * Math.cos(0.2f + (double) i / 5)
                    * Math.cos(0.4f + (double) i / 2));
        }

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        System.out.println("Занимаемое время для первого метода: " + executionTime + " мс.");
    }

    public static void methodTwo(float[] arr) {
        float[] arr1 = new float[HALF];
        float[] arr2 = new float[HALF];

        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1.0f;
        }

        long startTime = System.currentTimeMillis();

        System.arraycopy(arr, 0, arr1, 0, HALF);
        System.arraycopy(arr, 0, arr2, 0, HALF);

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < HALF; i++) {
                arr1[i] = (float) (arr1[i] * Math.sin(0.2f + (double) i / 5) * Math.cos(0.2f + (double) i / 5)
                        * Math.cos(0.4f + (double) i / 2));
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < HALF; i++) {
                int index = i + HALF;
                arr2[i] = (float) (arr2[i] * Math.sin(0.2f + (double) index / 5) * Math.cos(0.2f + (double) index / 5)
                        * Math.cos(0.4f + (double) index / 2));
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(arr1, 0, arr, 0, HALF);
        System.arraycopy(arr2, 0, arr, 0, HALF);

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        System.out.println("Занимаемое время для второго метода: " + executionTime + " мс.");

    }
    public static void methodThree(float[] arr){
        float[] arr1 = new float[DEC];
        float[] arr2 = new float[DEC];
        float[] arr3 = new float[DEC];
        float[] arr4 = new float[DEC];
        float[] arr5 = new float[DEC];

        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1.0f;
        }
        long startTime = System.currentTimeMillis();

        System.arraycopy(arr, 0, arr1, 0,DEC);
        System.arraycopy(arr, 0, arr2, 0, DEC);
        System.arraycopy(arr, 0, arr3, 0, DEC);
        System.arraycopy(arr, 0, arr4, 0, DEC);
        System.arraycopy(arr, 0, arr5, 0, DEC);

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < DEC; i++) {
                arr1[i] = (float) (arr1[i] * Math.sin(0.2f + (double) i / 5) * Math.cos(0.2f + (double) i / 5)
                        * Math.cos(0.4f + (double) i / 2));
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < DEC; i++) {
                int index = i + DEC;
                arr2[i] = (float) (arr2[i] * Math.sin(0.2f + (double) index / 5) * Math.cos(0.2f + (double) index / 5)
                        * Math.cos(0.4f + (double) index / 2));
            }
        });
        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < DEC; i++) {
                arr1[i] = (float) (arr1[i] * Math.sin(0.2f + (double) i / 5) * Math.cos(0.2f + (double) i / 5)
                        * Math.cos(0.4f + (double) i / 2));
            }
        });

        Thread thread4 = new Thread(() -> {
            for (int i = 0; i < DEC; i++) {
                int index = i + DEC;
                arr2[i] = (float) (arr2[i] * Math.sin(0.2f + (double) index / 5) * Math.cos(0.2f + (double) index / 5)
                        * Math.cos(0.4f + (double) index / 2));
            }
        });
        Thread thread5 = new Thread(() -> {
            for (int i = 0; i < DEC; i++) {
                arr1[i] = (float) (arr1[i] * Math.sin(0.2f + (double) i / 5) * Math.cos(0.2f + (double) i / 5)
                        * Math.cos(0.4f + (double) i / 2));
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();


        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(arr1, 0, arr, 0, DEC);
        System.arraycopy(arr2, 0, arr, 0, DEC);
        System.arraycopy(arr3, 0, arr, 0, DEC);
        System.arraycopy(arr4, 0, arr, 0, DEC);
        System.arraycopy(arr5, 0, arr, 0, DEC);

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        System.out.println("Занимаемое время для третьего метода: " + executionTime + " мс.");
        System.out.println("Первая ячейка: " + arr1[DEC - 1]);
        System.out.println("Последняя ячейка: " + arr1[DEC - 1]);
        System.out.println("Первая ячейка: " + arr2[DEC - 1]);
        System.out.println("Последняя ячейка: " + arr2[DEC - 1]);
        System.out.println("Первая ячейка: " + arr3[DEC - 1]);
        System.out.println("Последняя ячейка: " + arr3[DEC - 1]);
        System.out.println("Первая ячейка: " + arr4[DEC - 1]);
        System.out.println("Последняя ячейка: " + arr4[DEC - 1]);
        System.out.println("Первая ячейка: " + arr5[DEC - 1]);
        System.out.println("Последняя ячейка: " + arr5[DEC - 1]);
    }
}