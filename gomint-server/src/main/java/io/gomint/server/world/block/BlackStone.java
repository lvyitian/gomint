package io.gomint.server.world.block;

import io.gomint.inventory.item.ItemStack;
import io.gomint.server.registry.RegisterInfo;
import io.gomint.server.world.block.helper.ToolPresets;
import io.gomint.world.block.BlockBlackStone;
import io.gomint.world.block.BlockType;

/**
 * @author KingAli
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:blackstone")
public class BlackStone extends Block implements BlockBlackStone {

    @Override
    public String blockId() {
        return "minecraft:blackstone";
    }

    @Override
    public long breakTime() {
        return 2300;
    }

    @Override
    public Class<? extends ItemStack<?>>[] toolInterfaces() {
        return ToolPresets.PICKAXE;
    }

    @Override
    public float blastResistance() {
        return 30.0f;
    }

    @Override
    public BlockType blockType() {
        return BlockType.BLACKSTONE;
    }
}
