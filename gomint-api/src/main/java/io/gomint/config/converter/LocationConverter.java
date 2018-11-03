/*
 * Copyright (c) 2018 GoMint team
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.config.converter;

import io.gomint.GoMint;
import io.gomint.config.ConfigSection;
import io.gomint.math.Location;
import io.gomint.world.World;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

/**
 * @author geNAZt
 * @version 1.0
 */
public class LocationConverter extends BaseConverter {

    @Override
    public Object toConfig( Class<?> type, Object object, ParameterizedType parameterizedType ) {
        Location location = (Location) object;
        Map<String, Object> saveMap = new HashMap<>();

        if ( location.getWorld() != null ) {
            saveMap.put( "world", location.getWorld().getWorldName() );
        }

        saveMap.put( "x", location.getX() );
        saveMap.put( "y", location.getY() );
        saveMap.put( "z", location.getZ() );
        saveMap.put( "yaw", location.getYaw() );
        saveMap.put( "pitch", location.getPitch() );

        return saveMap;
    }

    @Override
    @SuppressWarnings( "unchecked" )
    public Object fromConfig( Class type, Object object, ParameterizedType parameterizedType ) {
        World world = null;
        Float headYaw = null;
        Map<String, Object> locationMap;

        if ( object instanceof Map ) {
            locationMap = (Map<String, Object>) object;
        } else {
            locationMap = (Map<String, Object>) ( (ConfigSection) object ).getRawMap();
        }

        float x = super.asFloat( locationMap.get( "x" ) );
        float y = super.asFloat( locationMap.get( "y" ) );
        float z = super.asFloat( locationMap.get( "z" ) );
        float yaw = super.asFloat( locationMap.get( "yaw" ) );
        float pitch = super.asFloat( locationMap.get( "pitch" ) );

        if ( locationMap.containsKey( "world" ) ) {
            world = GoMint.instance().getWorld( (String) locationMap.get( "world" ) );
        }

        if ( locationMap.containsKey( "headYaw" ) ) {
            headYaw = (Float) locationMap.get( "headYaw" );
        }

        headYaw = headYaw == null ? yaw : headYaw;

        return new Location( world, x, y, z, headYaw, yaw, pitch );
    }

    @Override
    public boolean supports( Class<?> type ) {
        return Location.class.isAssignableFrom( type );
    }

}
