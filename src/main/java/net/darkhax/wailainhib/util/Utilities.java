package net.darkhax.wailainhib.util;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class Utilities {
    
    public static final Random RND = new Random();
    
    public static int getBlockLightLevel (World world, int x, int y, int z, boolean day) {
        
        return day ? world.getChunkFromChunkCoords(x >> 4, z >> 4).getBlockLightValue(x & 0xF, y, z & 0xF, 0) : world.getChunkFromChunkCoords(x >> 4, z >> 4).getBlockLightValue(x & 0xF, y, z & 0xF, 16);
    }
    
    public static boolean canPlayerSleep (EntityPlayer player) {
        
        return (!player.isPlayerSleeping()) && (player.isEntityAlive()) && (player.worldObj.getWorldTime() > 12541L) && (player.worldObj.getWorldTime() < 23458L);
    }
    
    public static boolean isPlayerInSun (EntityPlayer player) {
        
        boolean isSkylight = true;
        
        for (int y = (int) player.posY; y < 256; y++) {
            
            isSkylight = player.worldObj.isAirBlock((int) player.posX, y, (int) player.posZ);
            
            if (!isSkylight)
                break;
        }
        
        return isSkylight;
    }
    
    public static MovingObjectPosition rayTrace (EntityPlayer player, double length) {
        
        Vec3 vec1 = Vec3.createVectorHelper(player.posX, player.posY + player.getEyeHeight(), player.posZ);
        Vec3 vec2 = player.getLookVec();
        Vec3 vec3 = vec1.addVector(vec2.xCoord * length, vec2.yCoord * length, vec2.zCoord * length);
        return player.worldObj.rayTraceBlocks(vec1, vec3);
    }
}
