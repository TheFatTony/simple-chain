package com.chieftain.simple.chain.simplechain.transfer;


import com.chieftain.simple.chain.simplechain.blockchain.Block;
import com.chieftain.simple.chain.simplechain.blockchain.BlockChain;
import com.chieftain.simple.chain.simplechain.shared.BlockDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequestMapping("/node")
public class NodeController {


    @Autowired
    private BlockChain blockChain;

    @Autowired
    private ModelMapper modelMapper;


    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<BlockDto> getBlocks() {
        return blockChain.getBlockChain().stream().map(o -> convertToDto(o)).collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addBlock(@RequestParam(value = "data", required = true) String data) {
        Block newBlock = blockChain.generateNextBlock(data);
        newBlock.mineBlock(BlockChain.difficulty);
        blockChain.addBlock(newBlock);

        return ResponseEntity.ok("ok");
    }


    private BlockDto convertToDto(Block items) {
        BlockDto itemsDto = modelMapper.map(items, BlockDto.class);
        return itemsDto;
    }

}
