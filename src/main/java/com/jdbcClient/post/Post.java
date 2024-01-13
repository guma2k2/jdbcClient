package com.jdbcClient.post;

import java.time.LocalDate;

public record Post (Integer id, String title, String slug, LocalDate date, int timeToRead, String tags) {
}
