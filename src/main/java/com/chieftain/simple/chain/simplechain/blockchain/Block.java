package com.chieftain.simple.chain.simplechain.blockchain;

import java.util.Date;

public class Block {


    private int index;
    private String previousHash;
    private Date timestamp;
    private String data;
    private String hash;
    private int nonce = 0;


    public Block(int index, String previousHash, String data) {
        this.index = index;
        this.previousHash = previousHash;
        this.timestamp = new Date();
        this.data = data;
        this.hash = calculateHash();
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHash() {
        return hash;
    }


    public int getNonce() {
        return nonce;
    }

    public String calculateHash() {
        return HashUtils.calculateHash(index + Integer.toString(nonce) + previousHash + timestamp + data);
    }

    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0');
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            this.hash = calculateHash();
        }
    }


}
