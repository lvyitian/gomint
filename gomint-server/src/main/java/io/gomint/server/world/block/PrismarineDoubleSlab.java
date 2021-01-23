/*
 * Copyright (c) 2020 Gomint team
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.server.world.block;

import io.gomint.server.registry.RegisterInfo;
import io.gomint.server.world.block.state.BooleanBlockState;
import io.gomint.server.world.block.state.EnumBlockState;
import io.gomint.world.block.BlockPrismarineDoubleSlab;
import io.gomint.world.block.BlockPrismarineSlab;
import io.gomint.world.block.BlockType;
import io.gomint.world.block.data.PrismarineType;

@RegisterInfo(sId = "minecraft:double_stone_slab2[stone_slab_type_2=prismarine_rough,prismarine_dark,prismarine_brick]")
public class PrismarineDoubleSlab extends Block implements BlockPrismarineDoubleSlab {

    private enum PrismarineMagicType {
        NORMAL("prismarine_rough"),
        DARK("prismarine_dark"),
        BRICK("prismarine_brick");

        private final String type;

        PrismarineMagicType(String type) {
            this.type = type;
        }
    }

    private static final BooleanBlockState TOP = new BooleanBlockState( () -> new String[]{"top_slot_bit"} ); // This is stupid and shouldn't be calculated, this is only there because vanilla extends double slabs from slabs
    private static final EnumBlockState<PrismarineMagicType, String> VARIANT = new EnumBlockState<>(v -> {
        return new String[]{"stone_slab_type_2"};
    }, PrismarineMagicType.values(), v -> v.type, v -> {
        for (PrismarineMagicType value : PrismarineMagicType.values()) {
            if (value.type.equals(v)) {
                return value;
            }
        }

        return null;
    });

    @Override
    public BlockType blockType() {
        return BlockType.PRISMARINE_DOUBLE_SLAB;
    }

    @Override
    public float blastResistance() {
        return 30.0f;
    }

    @Override
    public long breakTime() {
        return 3000;
    }

    @Override
    public PrismarineType type() {
        return PrismarineType.valueOf(VARIANT.state(this).name());
    }

    @Override
    public BlockPrismarineDoubleSlab type(PrismarineType type) {
        VARIANT.state(this, PrismarineMagicType.valueOf(type.name()));
        return this;
    }

}