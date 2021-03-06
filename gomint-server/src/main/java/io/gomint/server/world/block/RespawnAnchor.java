package io.gomint.server.world.block;

import io.gomint.inventory.item.ItemDiamondPickaxe;
import io.gomint.inventory.item.ItemStack;
import io.gomint.server.registry.RegisterInfo;
import io.gomint.world.block.BlockRespawnAnchor;
import io.gomint.world.block.BlockType;

/**
 * @author KingAli
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:respawn_anchor")
public class RespawnAnchor extends Block implements BlockRespawnAnchor {

    @Override
    public String blockId() {
        return "minecraft:respawn_anchor";
    }

    @Override
    public long breakTime() {
        return 75200;
    }

    @Override
    public Class<? extends ItemStack<?>>[] toolInterfaces() {
        return new Class[]{
            ItemDiamondPickaxe.class
        };
    }

    @Override
    public float blastResistance() {
        return 6000.0f;
    }

    @Override
    public BlockType blockType() {
        return BlockType.RESPAWN_ANCHOR;
    }
}
