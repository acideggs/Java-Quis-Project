package project_pbo;

import java.util.Random;

public class kuis_session {

    private static String username;
    private static int[] id_soal = new int[10];
    private static String status;
    private static int skor = 0;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getIdSoal(int index) {
        return id_soal[index];
    }

    public void setSoal(int id_soal, int index) {
        this.id_soal[index] = id_soal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSkor() {
        return skor;
    }

    public void setSkor(int skor) {
        this.skor = skor;
    }

    private static void shuffleArray(int[] array) {
        int index, temp;
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

}
