package com.naofi.util;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Map;

public class IdGenerator {
    private AtomicInteger id = new AtomicInteger(0);
    private Map<String, AtomicInteger> ids = new ConcurrentHashMap<>();


    public String newId(String name) {
        return name + ids.computeIfAbsent(name, k -> new AtomicInteger(0)).incrementAndGet();
    }

    public String getId(String name) {
        return name + ids.get(name).get();
    }
}
