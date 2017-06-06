package io.gomint.server.world.block;

/**
 * @author geNAZt
 * @version 1.0
 */
public class TallGrass extends Block {

    @Override
    public int getBlockId() {
        return 31;
    }

    @Override
    public boolean isTransparent() {
        return true;
    }

    @Override
    public boolean isSolid() {
        return false;
    }

    @Override
    public boolean canPassThrough() {
        return true;
    }

}
