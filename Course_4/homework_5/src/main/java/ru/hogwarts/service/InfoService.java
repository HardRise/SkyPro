package ru.hogwarts.service;

import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class InfoService {
    public int otherTask() {
        return Stream.iterate(1, a -> a + 1)
                .parallel()
                .limit(1_000_000)
                .mapToInt(Integer::intValue)
                .sum();
    }
}
