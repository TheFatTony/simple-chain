package com.chieftain.simple.chain.simplechain;

import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;

public class BlockChain {

    LinkedList<Block> blockChain;


    public BlockChain() {
        blockChain = new LinkedList<Block>();
        blockChain.add(new Block(0, "0", "my genesis block!!"));
    }

    public void generateNextBlock(Object data){
        Block previousBlock = blockChain.getLast();
        blockChain.add(new Block(previousBlock.getIndex() +1 , previousBlock.getHash(), data));

    }
}
