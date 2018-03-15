package io.gomint.server.world.block;

import io.gomint.inventory.item.ItemBlockOfGold;
import io.gomint.inventory.item.ItemDiamondPickaxe;
import io.gomint.inventory.item.ItemIronPickaxe;
import io.gomint.inventory.item.ItemStack;
import io.gomint.server.registry.RegisterInfo;
import io.gomint.world.block.BlockType;

import java.util.ArrayList;
import java.util.List;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo( id = 41 )
public class BlockOfGold extends Block implements io.gomint.world.block.BlockBlockOfGold {

    @Override
    public byte getBlockId() {
        return 41;
    }

    @Override
    public long getBreakTime() {
        return 4500;
    }

    @Override
    public float getBlastResistance() {
        return 30.0f;
    }

    @Override
    public BlockType getType() {
        return BlockType.BLOCK_OF_GOLD;
    }

    @Override
    public Class<? extends ItemStack>[] getToolInterfaces() {
        // Only iron and up
        return new Class[]{
            ItemIronPickaxe.class,
            ItemDiamondPickaxe.class,
        };
    }

    @Override
    public List<ItemStack> getDrops( ItemStack itemInHand ) {
        if ( isCorrectTool( itemInHand ) ) {
            return new ArrayList<ItemStack>() {{
                add( ItemBlockOfGold.create( 1 ) );
            }};
        }

        return new ArrayList<>();
    }

}
