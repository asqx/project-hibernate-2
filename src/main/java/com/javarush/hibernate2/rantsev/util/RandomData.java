package com.javarush.hibernate2.rantsev.util;

import java.util.concurrent.ThreadLocalRandom;

public class RandomData {
    public static String getFilmName() {
        int randomElementIndex
                = ThreadLocalRandom.current().nextInt(Constant.FIRST_NAME_FILM.length);
        String nameFilm = Constant.FIRST_NAME_FILM[randomElementIndex];
        randomElementIndex = ThreadLocalRandom.current().nextInt(Constant.SECOND_NAME_FILM.length);
        nameFilm = nameFilm + Constant.SECOND_NAME_FILM[randomElementIndex];
        randomElementIndex = ThreadLocalRandom.current().nextInt(Constant.LAST_NAME_FILM.length);
        nameFilm = nameFilm + Constant.LAST_NAME_FILM[randomElementIndex];
        return nameFilm;
    }

    public static String randomString(int lenght, boolean upCase) {
        StringBuilder randomString = new StringBuilder(String.valueOf(Constant.ALPHABET.charAt(ThreadLocalRandom.current()
                .nextInt(0, 26))));

        if (upCase) {
            randomString = new StringBuilder(randomString.toString().toUpperCase());
        }

        for (int i = 0; i < lenght; i++) {
            randomString.append(Constant.ALPHABET.charAt(ThreadLocalRandom.current().nextInt(0, 26)));
        }
        return randomString.toString();
    }

    public static String randomEmail() {
        return randomString(ThreadLocalRandom.current().nextInt(5, 10), false)
                + Constant.ENDING_EMAIL[ThreadLocalRandom.current().nextInt(0, 4)];
    }

    public static String randomAddress() {
        return ThreadLocalRandom.current().nextInt(1, 200) + " "
                + randomString(ThreadLocalRandom.current().nextInt(5, 9), true);
    }

    public static String randomCity() {
        return randomString(ThreadLocalRandom.current().nextInt(4, 9), true);
    }
}
