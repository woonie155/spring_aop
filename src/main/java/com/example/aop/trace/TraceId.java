package com.example.aop.trace;

import lombok.Data;

import java.util.UUID;

@Data
public class TraceId {

    public String id;
    public int level;

    public TraceId(){
        this.id = createId();
        this.level = 0;
    }

    private TraceId(String id, int level){
        this.id = id;
        this.level = level;
    }

    private String createId(){
        return UUID.randomUUID().toString().substring(0, 8);
    }

    public TraceId createNextId(){
        return new TraceId(id, level+1);
    }
    public TraceId createPreviousId(){
        return new TraceId(id, level-1);
    }
    public boolean isFirstLevel(){
        return level == 0;
    }
}

