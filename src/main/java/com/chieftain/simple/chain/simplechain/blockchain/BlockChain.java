package com.chieftain.simple.chain.simplechain.blockchain;

import org.springframework.stereotype.Component;

import java.util.LinkedList;


@Component
public class BlockChain {

    LinkedList<Block> blockChain;

    public BlockChain() {
        blockChain = new LinkedList<Block>();
        blockChain.add(new Block(0, "0", "my genesis block!!"));
    }

    public Block generateNextBlock(String data) {
        Block previousBlock = blockChain.getLast();
        Block newBlock = new Block(previousBlock.getIndex() + 1, previousBlock.getHash(), data);
        if (isBlockValid(newBlock)) {
            blockChain.add(newBlock);
            return newBlock;
        }
        // TODO exception of some kind
        return null;
    }


    private boolean isBlockValid(Block newBlock) {
        Block previousBlock = blockChain.getLast();
        if (previousBlock.getIndex() + 1 != newBlock.getIndex()) {
            System.out.println("Wrong index");
            return false;
        } else if (!previousBlock.getHash().equals(newBlock.getPreviousHash())) {
            System.out.println("Wrong hash compared to Previous Block");
            return false;
        } else if (!newBlock.calculateHash().equals(newBlock.getHash())) {
            System.out.println("Wrong Hash calculateHash");
            return false;
        }
        return true;
    }

    public LinkedList<Block> getBlockChain() {
        return blockChain;
    }
}
