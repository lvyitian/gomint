/*
 * Copyright (c) 2020 Gomint team
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.world.block;

/**
 * @author geNAZt
 * @version 1.0
 * @stability 3
 */
public interface BlockBlastFurnace extends Block, BlockFacing<BlockBlastFurnace> {

    /**
     * Check if this furnace is burning
     *
     * @return true if burning, false if not
     */
    boolean burning();

    /**
     * Set the burning of this furnace
     *
     * @param burning true when it should burn, false if it shouldn't
     * @return block for chaining
     */
    BlockBlastFurnace burning(boolean burning);

}
