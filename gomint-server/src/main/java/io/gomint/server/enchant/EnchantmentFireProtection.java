/*
 * Copyright (c) 2020, GoMint, BlackyPaw and geNAZt
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.server.enchant;

import io.gomint.enchant.Rarity;
import io.gomint.server.inventory.item.ItemStack;
import io.gomint.server.registry.RegisterInfo;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(id = 1)
public class EnchantmentFireProtection extends Enchantment implements io.gomint.enchant.EnchantmentFireProtection {

    /**
     * Create new enchantment fire protection
     */
    public EnchantmentFireProtection() {
        super((short) 4);
    }

    @Override
    public int minEnchantAbility(short level) {
        return (byte) (10 + (level - 1) * 8);
    }

    @Override
    public int maxEnchantAbility(short level) {
        return (byte) (minEnchantAbility(level) + 12);
    }

    @Override
    public boolean canBeApplied(ItemStack<?> itemStack) {
        return EnchantmentHelper.canBeAppliedArmor(itemStack);
    }

    @Override
    public Rarity rarity() {
        return Rarity.UNCOMMON;
    }

    @Override
    public boolean collidesWith(Enchantment enchantment) {
        return enchantment instanceof EnchantmentProtection ||
            enchantment instanceof EnchantmentBlastProtection ||
            enchantment instanceof EnchantmentProjectileProtection ||
            super.collidesWith(enchantment);
    }

}
