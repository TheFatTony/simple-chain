package com.chieftain.simple.chain.simplechain.blockchain;

import org.springframework.stereotype.Component;

import java.util.LinkedList;


@Component
public class BlockChain {

    public static int difficulty = 2;

    static String hashTarget = new String(new char[difficulty]).replace('\0', '0');

    LinkedList<Block> blockChain;

    public BlockChain() {
        blockChain = new LinkedList<Block>();
        blockChain.add(new Block(0, "0", "my genesis block!!"));
    }

    public Block generateNextBlock(String data) {
        Block previousBlock = blockChain.getLast();
        Block newBlock = new Block(previousBlock.getIndex() + 1, previousBlock.getHash(), data);
        return newBlock;
    }

    public boolean addBlock(Block newBlock) {
        if (isBlockValid(newBlock)) {
            blockChain.add(newBlock);
            return true;
        } else {
            return false;
        }
    }


    public boolean isBlockValid(Block newBlock) {
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
        } else if (!newBlock.getHash().substring(0, difficulty).equals(hashTarget)) {
            System.out.println("This block hasn't been mined");
            return false;
        }
        return true;
    }

    public LinkedList<Block> getBlockChain() {
        return blockChain;
    }
}
