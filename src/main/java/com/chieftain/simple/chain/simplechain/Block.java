package com.chieftain.simple.chain.simplechain;

import java.sql.Timestamp;
import java.util.Date;

public class Block {

    private int index;
    private String previousHash;
    private Date timestamp;
    private Object data;
    private String hash;


    public Block(int index, String previousHash, Object data) {
        this.index = index;
        this.previousHash = previousHash;
        this.timestamp = new Date();
        this.data = data;
        this.hash = HashUtils.calculateHash(index + previousHash + timestamp + data.toString());
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }


}
