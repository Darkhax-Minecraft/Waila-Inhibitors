package net.darkhax.wailainhib.util;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class Utilities {
    
    public static final Random RND = new Random();
    
    public static int getBlockLightLevel (World world, int x, int y, int z, boolean day) {
        
        return day ? world.getChunkFromChunkCoords(x >> 4, z >> 4).getBlockLightValue(x & 0xF, y, z & 0xF, 0) : world.getChunkFromChunkCoords(x >> 4, z >> 4).getBlockLightValue(x & 0xF, y, z & 0xF, 16);
    }
    
    public static boolean canPlayerSleep (EntityPlayer player) {
        
        return (!player.isPlayerSleeping()) && (player.isEntityAlive()) && (player.worldObj.getWorldTime() > 12541L) && (player.worldObj.getWorldTime() < 23458L);
    }
    
    public static boolean isPlayerInSun (World world, int x, int y, int z) {
        
        for (int pos = y; pos < 256; pos++)
            if (!world.isAirBlock(x, pos, z) || world.getBlock(x, pos, z).getMaterial().isSolid())
                return false;
                
        return true;
    }
}
