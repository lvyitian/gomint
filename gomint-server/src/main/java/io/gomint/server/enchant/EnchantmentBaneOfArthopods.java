/*
 * Copyright (c) 2020, GoMint, BlackyPaw and geNAZt
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.server.enchant;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.inventory.item.ItemStack;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo( id = 11 )
public class EnchantmentBaneOfArthopods extends Enchantment implements io.gomint.enchant.EnchantmentBaneOfArthopods {

    /**
     * Create new enchantment bane of arthopods
     */
    public EnchantmentBaneOfArthopods() {
        super( (short) 5 );
    }

    @Override
    public byte getMinEnchantAbility( short level ) {
        return (byte) ( 5 + ( level - 1 ) * 8 );
    }

    @Override
    public byte getMaxEnchantAbility( short level ) {
        return (byte) ( getMinEnchantAbility( level ) + 20 );
    }

    @Override
    public boolean canBeApplied( ItemStack itemStack ) {
        return itemStack.getItemType() == ItemType.DIAMOND_SWORD ||
            itemStack.getItemType() == ItemType.STONE_SWORD ||
            itemStack.getItemType() == ItemType.GOLDEN_SWORD ||
            itemStack.getItemType() == ItemType.IRON_SWORD ||
            itemStack.getItemType() == ItemType.WOODEN_SWORD;
    }

}
